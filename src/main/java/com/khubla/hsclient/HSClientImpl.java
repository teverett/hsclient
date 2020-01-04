package com.khubla.hsclient;

import java.io.*;
import java.util.*;

import org.apache.http.*;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.*;
import org.apache.http.impl.client.*;
import org.apache.http.util.*;

import com.khubla.hsclient.domain.*;
import com.khubla.hsclient.response.*;

public class HSClientImpl implements HSClient {
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

	public static HSClient connect(String url, String username, String password) {
		return new HSClientImpl(url, username, password);
	}

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

	private HSClientImpl(String url, String username, String pasword) {
		super();
		this.url = url;
		this.username = username;
		password = pasword;
	}

	@Override
	public void close() throws IOException {
		httpClient.close();
	}

	@Override
	public Device controlDeviceByLabel(String label, String value) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("label", label);
		parameters.put("value", value);
		final String json = executeGETQuery("controldevicebylabel", parameters);
		return Device.parse(json);
	}

	@Override
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

	@Override
	public ControlResponse getControl(Integer ref) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		if (null != ref) {
			parameters.put("ref", Integer.toString(ref));
		}
		final String json = executeGETQuery("getcontrol", parameters);
		return ControlResponse.parse(json);
	}

	@Override
	public CountersResponse getCounter(String counter) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("counter", counter);
		final String json = executeGETQuery("getcounter", parameters);
		return CountersResponse.parse(json);
	}

	/**
	 * produce a map of devices by name
	 */
	@Override
	public Map<String, Device> getDevicesByName() throws HSClientException {
		final StatusResponse statusResponse = getStatus(null, null, null);
		final Map<String, Device> ret = new HashMap<String, Device>();
		for (final Device device : statusResponse.getDevices()) {
			ret.put(device.getName(), device);
		}
		return ret;
	}

	/**
	 * produce a map of devices by ref
	 */
	@Override
	public Map<Integer, Device> getDevicesByRef() throws HSClientException {
		final StatusResponse statusResponse = getStatus(null, null, null);
		final Map<Integer, Device> ret = new HashMap<Integer, Device>();
		for (final Device device : statusResponse.getDevices()) {
			ret.put(device.getRef(), device);
		}
		return ret;
	}

	@Override
	public EventsResponse getEvents() throws HSClientException {
		final String json = executeGETQuery("getevents", null);
		return EventsResponse.parse(json);
	}

	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

	@Override
	public LocationsResponse getLocations() throws HSClientException {
		final String json = executeGETQuery("getlocations", null);
		return LocationsResponse.parse(json);
	}

	public String getPassword() {
		return password;
	}

	@Override
	public SettingResponse getSetting(String setting) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("setting", setting);
		final String json = executeGETQuery("getsetting", parameters);
		return SettingResponse.parse(json);
	}

	@Override
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

	@Override
	public void runEvent(String eventid) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("eventid", eventid);
		executeGETQuery("runevent", parameters);
	}

	@Override
	public void runEvent(String group, String eventname) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("group", group);
		parameters.put("eventname", eventname);
		executeGETQuery("runevent", parameters);
	}

	public void setHttpClient(CloseableHttpClient httpClient) {
		this.httpClient = httpClient;
	}

	@Override
	public void speak(String phrase, String host) throws HSClientException {
		final Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("phrase", phrase);
		parameters.put("host", host);
		executeGETQuery("speak", parameters);
	}
}
