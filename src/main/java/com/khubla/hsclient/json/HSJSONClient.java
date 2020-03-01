package com.khubla.hsclient.json;

import java.io.*;
import java.util.*;

import org.apache.http.*;
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
	 * logger
	 */
	private static Logger logger = LoggerFactory.getLogger(HSJSONClient.class);
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
	private CloseableHttpClient httpClient = HttpClients.createDefault();

	public HSJSONClient(String url, String username, String password) {
		super();
		this.url = url;
		this.username = username;
		this.password = password;
	}

	@Override
	public void close() throws IOException {
		httpClient.close();
	}

	public Device controlDeviceByLabel(Integer ref, String label) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("ref", Integer.toString(ref));
		parameters.put("label", label);
		final HTTPResponse httpResponse = executeGETQuery("controldevicebylabel", parameters);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return Device.parse(httpResponse.getHttpEntity());
		}
		return null;
	}

	public Device controlDeviceByValue(Integer ref, double value) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("ref", Integer.toString(ref));
		parameters.put("value", Double.toString(value));
		final HTTPResponse httpResponse = executeGETQuery("controldevicebyvalue", parameters);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return Device.parse(httpResponse.getHttpEntity());
		}
		return null;
	}

	private HTTPResponse executeGETQuery(String command, Map<String, String> parameters) throws HSClientException {
		try {
			final URIBuilder builder = new URIBuilder(url);
			builder.setParameter(USER, username).setParameter(PASS, password).addParameter(REQUEST, command);
			if (null != parameters) {
				for (final String k : parameters.keySet()) {
					builder.setParameter(k, parameters.get(k));
				}
			}
			final HttpGet request = new HttpGet(builder.build());
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

	public ControlResponse getControl(Integer ref) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		if (null != ref) {
			parameters.put("ref", Integer.toString(ref));
		}
		final HTTPResponse httpResponse = executeGETQuery("getcontrol", parameters);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return ControlResponse.parse(httpResponse.getHttpEntity());
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
		}
		return null;
	}

	public EventsResponse getEvents() throws HSClientException {
		final HTTPResponse httpResponse = executeGETQuery("getevents", null);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return EventsResponse.parse(httpResponse.getHttpEntity());
		}
		return null;
	}

	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

	public LocationsResponse getLocations() throws HSClientException {
		final HTTPResponse httpResponse = executeGETQuery("getlocations", null);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return LocationsResponse.parse(httpResponse.getHttpEntity());
		}
		return null;
	}

	public String getPassword() {
		return password;
	}

	public SettingResponse getSetting(String setting) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("setting", setting);
		final HTTPResponse httpResponse = executeGETQuery("getsetting", parameters);
		if (httpResponse.getHttpCode() == HttpStatus.SC_OK) {
			return SettingResponse.parse(httpResponse.getHttpEntity());
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
		}
		return null;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
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
}
