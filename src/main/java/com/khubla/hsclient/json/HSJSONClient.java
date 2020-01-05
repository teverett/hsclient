package com.khubla.hsclient.json;

import java.io.*;
import java.util.*;

import org.apache.http.*;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.*;
import org.apache.http.impl.client.*;
import org.apache.http.util.*;

import com.khubla.hsclient.*;
import com.khubla.hsclient.domain.*;
import com.khubla.hsclient.json.response.*;

public class HSJSONClient implements Closeable {
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

	public Device controlDeviceByLabel(String label, String value) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("label", label);
		parameters.put("value", value);
		final String json = executeGETQuery("controldevicebylabel", parameters);
		return Device.parse(json);
	}

	public Device controlDeviceByValue(Integer ref, String value) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("ref", Integer.toString(ref));
		parameters.put("value", value);
		final String json = executeGETQuery("controldevicebyvalue", parameters);
		return Device.parse(json);
	}

	private String executeGETQuery(String command, Map<String, String> parameters) throws HSClientException {
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
					return EntityUtils.toString(entity);
				}
			} finally {
				response.close();
			}
		} catch (final Exception e) {
			throw new HSClientException("Exception running command '+command+'", e);
		}
		return null;
	}

	public ControlResponse getControl(Integer ref) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		if (null != ref) {
			parameters.put("ref", Integer.toString(ref));
		}
		final String json = executeGETQuery("getcontrol", parameters);
		return ControlResponse.parse(json);
	}

	public CountersResponse getCounter(String counter) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		if (null != counter) {
			parameters.put("counter", counter);
		}
		final String json = executeGETQuery("getcounter", parameters);
		return CountersResponse.parse(json);
	}

	public EventsResponse getEvents() throws HSClientException {
		final String json = executeGETQuery("getevents", null);
		return EventsResponse.parse(json);
	}

	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

	public LocationsResponse getLocations() throws HSClientException {
		final String json = executeGETQuery("getlocations", null);
		return LocationsResponse.parse(json);
	}

	public String getPassword() {
		return password;
	}

	public SettingResponse getSetting(String setting) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("setting", setting);
		final String json = executeGETQuery("getsetting", parameters);
		return SettingResponse.parse(json);
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
		final String json = executeGETQuery("getstatus", parameters);
		return StatusResponse.parse(json);
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
