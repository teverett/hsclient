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
	 * NOT_CONNECTED message
	 */
	private static final String NOT_CONNECTED = "Not Connected";
	/**
	 * JSON API to HomeSeer
	 */
	private HSJSONClient hsJSONClient;

	@Override
	public void close() throws IOException {
		if (null != hsJSONClient) {
			hsJSONClient.close();
		}
		hsJSONClient = null;
	}

	@Override
	public void connect(String url, String username, String password) throws HSClientException, IOException {
		if (null != hsJSONClient) {
			hsJSONClient.close();
		}
		hsJSONClient = new HSJSONClient(url, username, password);
	}

	@Override
	public Device controlDeviceByLabel(Integer ref, String label) throws HSClientException {
		if (null != hsJSONClient) {
			final DeviceResponse deviceResponse = hsJSONClient.controlDeviceByLabel(ref, label);
			if (null != deviceResponse) {
				final List<Device> devices = deviceResponse.getDevices();
				if ((null != devices) && (devices.size() > 0)) {
					return devices.get(0);
				}
			}
			return null;
		}
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public Device controlDeviceByValue(Integer ref, double value) throws HSClientException {
		if (null != hsJSONClient) {
			final DeviceResponse deviceResponse = hsJSONClient.controlDeviceByValue(ref, value);
			if (null != deviceResponse) {
				final List<Device> devices = deviceResponse.getDevices();
				if ((null != devices) && (devices.size() > 0)) {
					return devices.get(0);
				}
			}
			return null;
		}
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public Counter getCounter(String name) throws HSClientException {
		if (null != hsJSONClient) {
			final CountersResponse countersResponse = hsJSONClient.getCounter(name);
			if (null != countersResponse) {
				if (countersResponse.getCounters().size() > 0) {
					return countersResponse.getCounters().get(0);
				}
			}
			return null;
		}
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public Device getDevice(Integer ref) throws HSClientException {
		if (null != hsJSONClient) {
			final StatusResponse statusResponse = hsJSONClient.getStatus(ref, null, null);
			if (null != statusResponse) {
				return statusResponse.getDevices().get(0);
			}
			return null;
		}
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public Device getDeviceControls(Integer ref) throws HSClientException {
		if (null != hsJSONClient) {
			final ControlResponse controlResponse = hsJSONClient.getControl(null);
			if (null != controlResponse) {
				return controlResponse.getDevices().get(0);
			}
			return null;
		}
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public Map<String, Device> getDeviceControlsByName() throws HSClientException {
		if (null != hsJSONClient) {
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
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public Map<Integer, Device> getDeviceControlsByRef() throws HSClientException {
		if (null != hsJSONClient) {
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
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public Map<String, Device> getDevicesByName() throws HSClientException {
		if (null != hsJSONClient) {
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
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public Map<Integer, Device> getDevicesByRef() throws HSClientException {
		if (null != hsJSONClient) {
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
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public Map<String, Map<String, Event>> getEventsByGroup() throws HSClientException {
		if (null != hsJSONClient) {
			final EventsResponse eventsResponse = hsJSONClient.getEvents();
			if (null != eventsResponse) {
				final Map<String, Map<String, Event>> ret = new HashMap<String, Map<String, Event>>();
				for (final Event event : eventsResponse.getEvents()) {
					if (null == ret.get(event.getGroup())) {
						ret.put(event.getGroup(), new HashMap<String, Event>());
					}
					ret.get(event.getGroup()).put(event.getName(), event);
				}
				return ret;
			}
			return null;
		}
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public Map<Integer, Event> getEventsById() throws HSClientException {
		if (null != hsJSONClient) {
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
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public List<String> getLocations1() throws HSClientException {
		if (null != hsJSONClient) {
			final LocationsResponse locationsResponse = hsJSONClient.getLocations();
			if (null != locationsResponse) {
				return locationsResponse.getLocation1();
			}
			return null;
		}
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public List<String> getLocations2() throws HSClientException {
		if (null != hsJSONClient) {
			final LocationsResponse locationsResponse = hsJSONClient.getLocations();
			if (null != locationsResponse) {
				return locationsResponse.getLocation2();
			}
			return null;
		}
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public String getSetting(String name) throws HSClientException {
		if (null != hsJSONClient) {
			final SettingResponse settingResponse = hsJSONClient.getSetting(name);
			if (null != settingResponse) {
				return settingResponse.getValue();
			}
			return null;
		}
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public void runEvent(Integer eventId) throws HSClientException {
		if (null != hsJSONClient) {
			hsJSONClient.runEvent(eventId);
		}
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public void runEvent(String group, String name) throws HSClientException {
		if (null != hsJSONClient) {
			hsJSONClient.runEvent(group, name);
		}
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public void speak(String phrase, String host) throws HSClientException {
		if (null != hsJSONClient) {
			hsJSONClient.speak(phrase, host);
		}
		throw new HSClientException(NOT_CONNECTED);
	}

	@Override
	public String getVersion() throws HSClientException {
		if (null != hsJSONClient) {
			final StatusResponse statusResponse = hsJSONClient.getStatus(null, null, null);
			if (null != statusResponse) {
				return statusResponse.getVersion();
			}
			return null;
		}
		throw new HSClientException(NOT_CONNECTED);
	}
}
