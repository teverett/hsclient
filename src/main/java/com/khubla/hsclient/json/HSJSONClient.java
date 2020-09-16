package com.khubla.hsclient.json;

import java.io.*;
import java.util.*;

import org.apache.http.*;
import org.apache.http.auth.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.*;
import org.apache.http.impl.client.*;
import org.apache.http.util.*;
import org.slf4j.*;

import com.khubla.hsclient.*;
import com.khubla.hsclient.domain.*;
import com.khubla.hsclient.json.response.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class HSJSONClient implements Closeable {
	/**
	 * response
	 */
	public static class HTTPResponse {
		private final String httpEntity;
		private final int httpCode;

		public HTTPResponse(String httpEntity, int httpCode) {
			super();
			this.httpEntity = httpEntity;
			this.httpCode = httpCode;
		}

		public int getHttpCode() {
			return httpCode;
		}

		public String getHttpEntity() {
			return httpEntity;
		}
	}

	/**
	 * ALL
	 */
	private static final String ALL = "all";
	/**
	 * logger
	 */
	private static Logger logger = LoggerFactory.getLogger(HSJSONClient.class);
	/**
	 * changed device id, for the "getdeviceschanged" API
	 */
	private static String DEVICE_CHANGE_ID = UUID.randomUUID().toString();
	/**
	 * user
	 */
	private static final String USER = "user";
	/**
	 * pass
	 */
	private static final String PASS = "pass";
	/**
	 * request
	 */
	private static final String REQUEST = "request";
	/**
	 * myhs server
	 */
	private static final String MY_HS = "http://myhs.homeseer.com/json/";
	/**
	 * HS URL
	 */
	private final String url;
	/**
	 * HS Username
	 */
	private final String username;
	/**
	 * HS Password
	 */
	private final String password;
	/**
	 * HTTP Client
	 */
	private CloseableHttpClient httpClient;

	public HSJSONClient(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
		final CredentialsProvider provider = new BasicCredentialsProvider();
		final UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
		provider.setCredentials(AuthScope.ANY, credentials);
		httpClient = HttpClientBuilder.create().setDefaultCredentialsProvider(provider).build();
	}

	@Override
	public void close() throws IOException {
		httpClient.close();
	}

	public DeviceResponse controlDeviceByLabel(Integer ref, String label) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("ref", Integer.toString(ref));
		parameters.put("label", label);
		final HTTPResponse httpResponse = executeGETQuery("controldevicebylabel", parameters);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return DeviceResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query controldevicebylabel returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public DeviceResponse controlDeviceByValue(Integer ref, double value) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("ref", Integer.toString(ref));
		parameters.put("value", Double.toString(value));
		final HTTPResponse httpResponse = executeGETQuery("controldevicebyvalue", parameters);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return DeviceResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query controldevicebyvalue returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	private HTTPResponse executeGETQuery(String serverUrl, boolean passCredentialsAsHTTPParameters, String command, Map<String, String> parameters) throws HSClientException {
		try {
			final URIBuilder builder = new URIBuilder(serverUrl);
			builder.addParameter(REQUEST, command);
			if (true == passCredentialsAsHTTPParameters) {
				builder.setParameter(USER, username).setParameter(PASS, password);
			}
			if (null != parameters) {
				for (final String k : parameters.keySet()) {
					builder.setParameter(k, parameters.get(k));
				}
			}
			final HttpGet request = new HttpGet(builder.build());
			logger.debug(request.toString());
			final CloseableHttpResponse response = httpClient.execute(request);
			try {
				final HttpEntity entity = response.getEntity();
				if (entity != null) {
					return new HTTPResponse(EntityUtils.toString(entity), response.getStatusLine().getStatusCode());
				} else {
					logger.warn("HTTP response '" + response.getStatusLine().getStatusCode() + "' running command '" + command + "'");
					return new HTTPResponse(null, response.getStatusLine().getStatusCode());
				}
			} finally {
				response.close();
			}
		} catch (final Exception e) {
			logger.error("Exception running command '" + command + "'", e);
			throw new HSClientException("Exception running command '" + command + "'", e);
		}
	}

	private HTTPResponse executeGETQuery(String command, Map<String, String> parameters) throws HSClientException {
		return executeGETQuery(url, false, command, parameters);
	}

	public CamerasResponse getCameras() throws HSClientException {
		final HTTPResponse httpResponse = executeGETQuery("getcameras", null);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return CamerasResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query getcameras returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public CameraSnapshotResponse getCameraSnapshot(String camid) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("camid", camid);
		final HTTPResponse httpResponse = executeGETQuery("getcamerasnapshot", parameters);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return CameraSnapshotResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query getcamerasnapshot returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public ChangedDevicesResponse getChangedDevices() throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("devicechangeid", DEVICE_CHANGE_ID);
		final HTTPResponse httpResponse = executeGETQuery("getdeviceschanged", parameters);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return ChangedDevicesResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query getdeviceschanged returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public ControlResponse getControl(Integer ref) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		if (null != ref) {
			parameters.put("ref", Integer.toString(ref));
		} else {
			parameters.put("ref", ALL);
		}
		final HTTPResponse httpResponse = executeGETQuery("getcontrol", parameters);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return ControlResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query getcontrol returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public CountersResponse getCounter(String counter) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		if (null != counter) {
			parameters.put("counter", counter);
		}
		final HTTPResponse httpResponse = executeGETQuery("getcounter", parameters);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return CountersResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query getcounter returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public DeviceInfo getDeviceInfo() throws HSClientException {
		final HTTPResponse httpResponse = executeGETQuery("getdeviceinfo", null);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return DeviceInfo.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query getdeviceinfo returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public EventsResponse getEvents() throws HSClientException {
		final HTTPResponse httpResponse = executeGETQuery("getevents", null);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return EventsResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query getevents returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public HSVersionResponse getHSVersion() throws HSClientException {
		final HTTPResponse httpResponse = executeGETQuery("hsversion", null);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return HSVersionResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query hsversion returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

	public GetImageResponse getImage(String path) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("path", path);
		final HTTPResponse httpResponse = executeGETQuery("getimage", parameters);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return GetImageResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query getimage returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public LocationsResponse getLocations() throws HSClientException {
		final HTTPResponse httpResponse = executeGETQuery("getlocations", null);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return LocationsResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query getLocations returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public String getPassword() {
		return password;
	}

	public PluginsResponse getPlugins() throws HSClientException {
		final HTTPResponse httpResponse = executeGETQuery("pluginlist", null);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return PluginsResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query pluginlist returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public PluginVersionResponse getPluginVersion(String pluginName) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("plugin", pluginName);
		final HTTPResponse httpResponse = executeGETQuery("pluginversion", parameters);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return PluginVersionResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query pluginversion returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public SessionConfig getSessionConfig() throws HSClientException {
		final HTTPResponse httpResponse = executeGETQuery("getsessionconfig", null);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return SessionConfig.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query getsessionconfig returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public SettingResponse getSetting(String setting) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("setting", setting);
		final HTTPResponse httpResponse = executeGETQuery("getsetting", parameters);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return SettingResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query getSetting returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public StatusResponse getStatus(Integer ref, String location1, String location2) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		if (null != ref) {
			parameters.put("ref", Integer.toString(ref));
		}
		if (null != location1) {
			parameters.put("location1", location1);
			if (null != location2) {
				parameters.put("location2", location2);
			}
		}
		final HTTPResponse httpResponse = executeGETQuery("getstatus", parameters);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return StatusResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query getstatus returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public SystemsResponse getSystems() throws HSClientException {
		final HTTPResponse httpResponse = executeGETQuery(MY_HS, true, "getsystems", null);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return SystemsResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query getsystems returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public void panCamera(CameraPan direction, String camid) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("direction", direction.toString());
		parameters.put("camid", camid);
		executeGETQuery("pancamera", parameters);
	}

	public String pluginfunction(String functionName, String plugin, String instance, Map<String, String> parameters) throws HSClientException {
		final Map<String, String> parms = new HashMap<String, String>();
		if (null != parameters) {
			parms.putAll(parameters);
		}
		parms.put("function", functionName);
		parms.put("plugin", plugin);
		if (null != instance) {
			parms.put("instance", instance);
		}
		final HTTPResponse httpResponse = executeGETQuery("pluginfunction", parms);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return httpResponse.getHttpEntity();
		} else {
			logger.error("Query pluginfunction returned HTTP " + httpResponse.getHttpCode());
			return null;
		}
	}

	public RegisterLicenseResponse register(Integer license, String password, Integer licenseold, String passold) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("license", license.toString());
		parameters.put("password", password);
		parameters.put("licenseold", licenseold.toString());
		parameters.put("passold", passold);
		final HTTPResponse httpResponse = executeGETQuery("register", parameters);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return RegisterLicenseResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query register returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}

	public void runEvent(Integer eventid) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("eventid", Integer.toString(eventid));
		executeGETQuery("runevent", parameters);
	}

	public void runEvent(String group, String eventname) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("group", group);
		parameters.put("eventname", eventname);
		executeGETQuery("runevent", parameters);
	}

	public void setHttpClient(CloseableHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	public void speak(String phrase, String host) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("phrase", phrase);
		parameters.put("host", host);
		executeGETQuery("speak", parameters);
	}

	public UpdatePluginResponse updatePlugin(String pluginName) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("plugin", pluginName);
		final HTTPResponse httpResponse = executeGETQuery("updateplugin", parameters);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return UpdatePluginResponse.parse(httpResponse.getHttpEntity());
		} else {
			logger.error("Query updateplugin returned HTTP " + httpResponse.getHttpCode());
		}
		return null;
	}
}
