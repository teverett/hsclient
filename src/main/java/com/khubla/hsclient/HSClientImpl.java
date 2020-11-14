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
	public void connect(HSConfiguration hsConfiguration) throws HSClientException, IOException {
		if (null != hsJSONClient) {
			hsJSONClient.close();
		}
		hsJSONClient = new HSJSONClient(hsConfiguration.getHsURL(), hsConfiguration.getHsUsername(), hsConfiguration.getHsPassword());
	}

	@Override
	public Device controlDeviceByLabel(Integer ref, String label) throws HSClientException {
		if (null != hsJSONClient) {
			final DeviceResponse deviceResponse = hsJSONClient.controlDeviceByLabel(ref, label);
			if (null != deviceResponse) {
				if (deviceResponse.getResponse() == null) {
					final List<Device> devices = deviceResponse.getDevices();
					if ((null != devices) && (devices.size() > 0)) {
						return devices.get(0);
					}
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public Device controlDeviceByValue(Integer ref, double value) throws HSClientException {
		if (null != hsJSONClient) {
			final DeviceResponse deviceResponse = hsJSONClient.controlDeviceByValue(ref, value);
			if (null != deviceResponse) {
				if (deviceResponse.getResponse() == null) {
					final List<Device> devices = deviceResponse.getDevices();
					if ((null != devices) && (devices.size() > 0)) {
						return devices.get(0);
					}
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public List<Camera> getCameras() throws HSClientException {
		if (null != hsJSONClient) {
			final CamerasResponse camerasResponse = hsJSONClient.getCameras();
			if (null != camerasResponse) {
				if (camerasResponse.getResponse() == null) {
					return camerasResponse.getCameras();
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public String getCameraSnapshot(String camid) throws HSClientException {
		if (null != hsJSONClient) {
			final CameraSnapshotResponse cameraSnapshotResponse = hsJSONClient.getCameraSnapshot(camid);
			if (null != cameraSnapshotResponse) {
				if (cameraSnapshotResponse.getResponse() == null) {
					return cameraSnapshotResponse.getSnapShot();
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public List<Integer> getChangedDevices() throws HSClientException {
		if (null != hsJSONClient) {
			final ChangedDevicesResponse changedDevicesResponse = hsJSONClient.getChangedDevices();
			if (null != changedDevicesResponse) {
				if (changedDevicesResponse.getResponse() == null) {
					return changedDevicesResponse.getRefs();
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public Device getChildDeviceByDeviceType(Device device, String deviceType) throws HSClientException {
		if (null != hsJSONClient) {
			if ((null != deviceType) && (null != device)) {
				final Map<Integer, Device> children = getChilden(device);
				if (null != children) {
					for (final Device child : children.values()) {
						if (child.getDevice_type_string().compareTo(deviceType) == 0) {
							return child;
						}
					}
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	/**
	 * get child devices of device
	 *
	 * @param device parent device
	 * @return devices
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	@Override
	public Map<Integer, Device> getChilden(Device device) throws HSClientException {
		if (null != hsJSONClient) {
			if ((null != device) && (null != device.getAssociated_devices()) && (device.getAssociated_devices().size() > 0)) {
				final Map<Integer, Device> ret = new HashMap<Integer, Device>();
				if (null != device.getAssociated_devices()) {
					for (final Integer refId : device.getAssociated_devices()) {
						final Device childDevice = getDevice(refId);
						if (childDevice.getRelationship() == RelationshipStatus.child) {
							ret.put(childDevice.getRef(), childDevice);
						}
					}
				}
				return ret;
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public Counter getCounter(String name) throws HSClientException {
		if (null != hsJSONClient) {
			final CountersResponse countersResponse = hsJSONClient.getCounter(name);
			if (null != countersResponse) {
				if (countersResponse.getResponse() == null) {
					if (null != countersResponse.getResponse()) {
						if (countersResponse.getCounters().size() > 0) {
							return countersResponse.getCounters().get(0);
						}
					}
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public Device getDevice(Integer ref) throws HSClientException {
		if (null != hsJSONClient) {
			final StatusResponse statusResponse = hsJSONClient.getStatus(ref, null, null);
			if (null != statusResponse) {
				if (statusResponse.getResponse() == null) {
					return statusResponse.getDevices().get(0);
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public List<ControlPair> getDeviceControls(Integer ref) throws HSClientException {
		if (null != hsJSONClient) {
			final ControlResponse controlResponse = hsJSONClient.getControl(ref);
			if (null != controlResponse) {
				if (controlResponse.getResponse() == null) {
					return controlResponse.getControlPairs();
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public DeviceInfo getDeviceInfo() throws HSClientException {
		if (null != hsJSONClient) {
			return hsJSONClient.getDeviceInfo();
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public Map<String, Device> getDevicesByName() throws HSClientException {
		if (null != hsJSONClient) {
			final StatusResponse statusResponse = hsJSONClient.getStatus(null, null, null);
			if (null != statusResponse) {
				if (statusResponse.getResponse() == null) {
					final Map<String, Device> ret = new HashMap<String, Device>();
					for (final Device device : statusResponse.getDevices()) {
						ret.put(device.getName(), device);
					}
					return ret;
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public Map<Integer, Device> getDevicesByRef() throws HSClientException {
		if (null != hsJSONClient) {
			final StatusResponse statusResponse = hsJSONClient.getStatus(null, null, null);
			if (null != statusResponse) {
				if (statusResponse.getResponse() == null) {
					final Map<Integer, Device> ret = new HashMap<Integer, Device>();
					for (final Device device : statusResponse.getDevices()) {
						ret.put(device.getRef(), device);
					}
					return ret;
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public Map<String, Map<String, Event>> getEventsByGroup() throws HSClientException {
		if (null != hsJSONClient) {
			final EventsResponse eventsResponse = hsJSONClient.getEvents();
			if (null != eventsResponse) {
				if (eventsResponse.getResponse() == null) {
					final Map<String, Map<String, Event>> ret = new HashMap<String, Map<String, Event>>();
					for (final Event event : eventsResponse.getEvents()) {
						if (null == ret.get(event.getGroup())) {
							ret.put(event.getGroup(), new HashMap<String, Event>());
						}
						ret.get(event.getGroup()).put(event.getName(), event);
					}
					return ret;
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public Map<Integer, Event> getEventsById() throws HSClientException {
		if (null != hsJSONClient) {
			final EventsResponse eventsResponse = hsJSONClient.getEvents();
			if (null != eventsResponse) {
				if (eventsResponse.getResponse() == null) {
					final Map<Integer, Event> ret = new HashMap<Integer, Event>();
					for (final Event event : eventsResponse.getEvents()) {
						ret.put(event.getId(), event);
					}
					return ret;
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public String getHSVersion() throws HSClientException {
		if (null != hsJSONClient) {
			final HSVersionResponse hsVersionResponse = hsJSONClient.getHSVersion();
			if (null != hsVersionResponse) {
				return hsVersionResponse.getResponse();
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public String getImage(String path) throws HSClientException {
		if (null != hsJSONClient) {
			final GetImageResponse getImageResponse = hsJSONClient.getImage(path);
			if (null != getImageResponse) {
				if (getImageResponse.getResponse().compareTo("ok") == 0) {
					return getImageResponse.getFileBase64();
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public List<String> getLocations1() throws HSClientException {
		if (null != hsJSONClient) {
			final LocationsResponse locationsResponse = hsJSONClient.getLocations();
			if (null != locationsResponse) {
				if (locationsResponse.getResponse() == null) {
					return locationsResponse.getLocation1();
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public List<String> getLocations2() throws HSClientException {
		if (null != hsJSONClient) {
			final LocationsResponse locationsResponse = hsJSONClient.getLocations();
			if (null != locationsResponse) {
				if (locationsResponse.getResponse() == null) {
					return locationsResponse.getLocation2();
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public List<Plugin> getPlugins() throws HSClientException {
		if (null != hsJSONClient) {
			final PluginsResponse pluginsResponse = hsJSONClient.getPlugins();
			if (null != pluginsResponse) {
				if (pluginsResponse.getResponse() == null) {
					return pluginsResponse.getPlugins();
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public String getPluginVersion(String pluginName) throws HSClientException {
		if (null != hsJSONClient) {
			final PluginVersionResponse pluginVersionResponse = hsJSONClient.getPluginVersion(pluginName);
			if (null != pluginVersionResponse) {
				return pluginVersionResponse.getResponse();
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	/**
	 * get root devices
	 *
	 * @return devices
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	@Override
	public Map<Integer, Device> getRootDevices() throws HSClientException {
		if (null != hsJSONClient) {
			final Map<Integer, Device> ret = new HashMap<Integer, Device>();
			final Map<Integer, Device> devices = getDevicesByRef();
			if (null != devices) {
				for (final Device device : devices.values()) {
					if ((device.getRelationship() == RelationshipStatus.parentroot) || (device.getRelationship() == RelationshipStatus.standalone)) {
						ret.put(device.getRef(), device);
					}
				}
			}
			return ret;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public SessionConfig getSessionConfig() throws HSClientException {
		if (null != hsJSONClient) {
			return hsJSONClient.getSessionConfig();
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public String getSetting(String name) throws HSClientException {
		if (null != hsJSONClient) {
			final SettingResponse settingResponse = hsJSONClient.getSetting(name);
			if (null != settingResponse) {
				if (settingResponse.getResponse() == null) {
					return settingResponse.getValue();
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public List<HSSystem> getSystems() throws HSClientException {
		if (null != hsJSONClient) {
			final SystemsResponse systemsResponse = hsJSONClient.getSystems();
			if (null != systemsResponse) {
				if (systemsResponse.getResponse() == null) {
					return systemsResponse.getSystems();
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public String getVersion() throws HSClientException {
		if (null != hsJSONClient) {
			final StatusResponse statusResponse = hsJSONClient.getStatus(null, null, null);
			if (null != statusResponse) {
				if (statusResponse.getResponse() == null) {
					return statusResponse.getVersion();
				}
			}
			return null;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public void panCamera(CameraPan direction, String camid) throws HSClientException {
		if (null != hsJSONClient) {
			hsJSONClient.panCamera(direction, camid);
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public String pluginfunction(String functionName, String plugin, String instance, Map<String, String> parameters) throws HSClientException {
		if (null != hsJSONClient) {
			return hsJSONClient.pluginfunction(functionName, plugin, instance, parameters);
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public boolean register(Integer license, String password, Integer licenseold, String passold) throws HSClientException {
		if (null != hsJSONClient) {
			final RegisterLicenseResponse registerLicenseResponse = hsJSONClient.register(license, password, licenseold, passold);
			if (null != registerLicenseResponse) {
				if (null != registerLicenseResponse.getResponse()) {
					if (registerLicenseResponse.getResponse().compareTo("Registration successful") == 0) {
						return true;
					}
				}
			}
			return false;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public void runEvent(Integer eventId) throws HSClientException {
		if (null != hsJSONClient) {
			hsJSONClient.runEvent(eventId);
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public void runEvent(String group, String name) throws HSClientException {
		if (null != hsJSONClient) {
			hsJSONClient.runEvent(group, name);
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public void speak(String phrase, String host) throws HSClientException {
		if (null != hsJSONClient) {
			hsJSONClient.speak(phrase, host);
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}

	@Override
	public boolean updatePlugin(String pluginName) throws HSClientException {
		if (null != hsJSONClient) {
			final UpdatePluginResponse updatePluginResponse = hsJSONClient.updatePlugin(pluginName);
			if (null != updatePluginResponse) {
				if (null != updatePluginResponse.getResponse()) {
					if (updatePluginResponse.getResponse().compareTo("Success, plugin install completed") == 0) {
						return true;
					}
				}
			}
			return false;
		} else {
			throw new HSClientException(NOT_CONNECTED);
		}
	}
}
