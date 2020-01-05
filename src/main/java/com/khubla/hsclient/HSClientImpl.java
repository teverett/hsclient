package com.khubla.hsclient;

import java.io.*;
import java.util.*;

import com.khubla.hsclient.domain.*;
import com.khubla.hsclient.json.*;
import com.khubla.hsclient.json.response.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class HSClientImpl implements HSClient {
	/**
	 * JSON API to HomeSeer
	 */
	private final HSJSONClient hsJSONClient;

	public HSClientImpl(String url, String username, String password) {
		hsJSONClient = new HSJSONClient(url, username, password);
	}

	@Override
	public void close() throws IOException {
		hsJSONClient.close();
	}

	@Override
	public Device controlDeviceByLabel(String label, String value) throws HSClientException {
		return hsJSONClient.controlDeviceByLabel(label, value);
	}

	@Override
	public Device controlDeviceByValue(Integer ref, String value) throws HSClientException {
		return hsJSONClient.controlDeviceByValue(ref, value);
	}

	@Override
	public Counter getCounter(String name) throws HSClientException {
		final CountersResponse countersResponse = hsJSONClient.getCounter(name);
		if (null != countersResponse) {
			if (countersResponse.getCounters().size() > 0) {
				return countersResponse.getCounters().get(0);
			}
		}
		return null;
	}

	@Override
	public Device getDevice(Integer ref) throws HSClientException {
		final StatusResponse statusResponse = hsJSONClient.getStatus(ref, null, null);
		if (null != statusResponse) {
			return statusResponse.getDevices().get(0);
		}
		return null;
	}

	@Override
	public Device getDeviceControls(Integer ref) throws HSClientException {
		final ControlResponse controlResponse = hsJSONClient.getControl(null);
		if (null != controlResponse) {
			return controlResponse.getDevices().get(0);
		}
		return null;
	}

	@Override
	public Map<String, Device> getDeviceControlsByName() throws HSClientException {
		final ControlResponse controlResponse = hsJSONClient.getControl(null);
		if (null != controlResponse) {
			final Map<String, Device> ret = new HashMap<String, Device>();
			for (final Device device : controlResponse.getDevices()) {
				ret.put(device.getName(), device);
			}
			return ret;
		}
		return null;
	}

	@Override
	public Map<Integer, Device> getDeviceControlsByRef() throws HSClientException {
		final ControlResponse controlResponse = hsJSONClient.getControl(null);
		if (null != controlResponse) {
			final Map<Integer, Device> ret = new HashMap<Integer, Device>();
			for (final Device device : controlResponse.getDevices()) {
				ret.put(device.getRef(), device);
			}
			return ret;
		}
		return null;
	}

	@Override
	public Map<String, Device> getDevicesByName() throws HSClientException {
		final StatusResponse statusResponse = hsJSONClient.getStatus(null, null, null);
		if (null != statusResponse) {
			final Map<String, Device> ret = new HashMap<String, Device>();
			for (final Device device : statusResponse.getDevices()) {
				ret.put(device.getName(), device);
			}
			return ret;
		}
		return null;
	}

	@Override
	public Map<Integer, Device> getDevicesByRef() throws HSClientException {
		final StatusResponse statusResponse = hsJSONClient.getStatus(null, null, null);
		if (null != statusResponse) {
			final Map<Integer, Device> ret = new HashMap<Integer, Device>();
			for (final Device device : statusResponse.getDevices()) {
				ret.put(device.getRef(), device);
			}
			return ret;
		}
		return null;
	}

	@Override
	public Map<Integer, Event> getEventsById() throws HSClientException {
		final EventsResponse eventsResponse = hsJSONClient.getEvents();
		if (null != eventsResponse) {
			final Map<Integer, Event> ret = new HashMap<Integer, Event>();
			for (final Event event : eventsResponse.getEvents()) {
				ret.put(event.getId(), event);
			}
			return ret;
		}
		return null;
	}

	@Override
	public Map<String, Event> getEventsByName() throws HSClientException {
		final EventsResponse eventsResponse = hsJSONClient.getEvents();
		if (null != eventsResponse) {
			final Map<String, Event> ret = new HashMap<String, Event>();
			for (final Event event : eventsResponse.getEvents()) {
				ret.put(event.getName(), event);
			}
			return ret;
		}
		return null;
	}

	@Override
	public List<String> getLocations1() throws HSClientException {
		final LocationsResponse locationsResponse = hsJSONClient.getLocations();
		if (null != locationsResponse) {
			return locationsResponse.getLocation1();
		}
		return null;
	}

	@Override
	public List<String> getLocations2() throws HSClientException {
		final LocationsResponse locationsResponse = hsJSONClient.getLocations();
		if (null != locationsResponse) {
			return locationsResponse.getLocation2();
		}
		return null;
	}

	@Override
	public void runEvent(Integer eventId) throws HSClientException {
		hsJSONClient.runEvent(eventId);
	}

	@Override
	public void runEvent(String group, String name) throws HSClientException {
		hsJSONClient.runEvent(group, name);
	}

	@Override
	public void speak(String phrase, String host) throws HSClientException {
		hsJSONClient.speak(phrase, host);
	}
}
