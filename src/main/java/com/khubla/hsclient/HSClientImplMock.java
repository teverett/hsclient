package com.khubla.hsclient;

import java.io.*;
import java.util.*;

import com.khubla.hsclient.domain.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class HSClientImplMock implements HSClient {
	/**
	 * devs by ref
	 */
	private static Map<Integer, Device> devicesByRef = new HashMap<Integer, Device>();
	/**
	 * devs by name
	 */
	private static Map<String, Device> devicesByName = new HashMap<String, Device>();
	/**
	 * events by ref
	 */
	private static Map<String, Map<String, Event>> eventsByGroup = new HashMap<String, Map<String, Event>>();
	/**
	 * events by id
	 */
	private static Map<Integer, Event> eventsById = new HashMap<Integer, Event>();
	/**
	 * counters
	 */
	private static Map<String, Counter> countersByName = new HashMap<String, Counter>();

	public HSClientImplMock() {
		if (devicesByRef.size() == 0) {
			addDevices();
		}
		if (eventsByGroup.size() == 0) {
			addEvents();
		}
		if (countersByName.size() == 0) {
			addCounters();
		}
	}

	private void addCounters() {
		final Counter counter1 = new Counter();
		counter1.setName("counter1");
		counter1.setValue(12);
		countersByName.put(counter1.getName(), counter1);
	}

	private void addDevice(Device device) {
		devicesByRef.put(device.getRef(), device);
		devicesByName.put(device.getName(), device);
	}

	private void addDevices() {
		/*
		 * furnace
		 */
		final Device thermostatDevice1 = new Device();
		thermostatDevice1.setLocation("Kitchen");
		thermostatDevice1.setRef(99);
		thermostatDevice1.setName("Furnace Thermostat Temperature");
		thermostatDevice1.setValue(22.0);
		addDevice(thermostatDevice1);
		/*
		 * fp1
		 */
		final Device thermostatDevice2 = new Device();
		thermostatDevice2.setLocation("Living Room");
		thermostatDevice2.setRef(16);
		thermostatDevice2.setName("Main Floor Fireplace - Temperature");
		thermostatDevice2.setValue(25.0);
		addDevice(thermostatDevice2);
		/*
		 * fp2
		 */
		final Device thermostatDevice3 = new Device();
		thermostatDevice3.setLocation("Basement");
		thermostatDevice3.setRef(30);
		thermostatDevice3.setName("Basement Fireplace - Temperature");
		thermostatDevice3.setValue(18.0);
		addDevice(thermostatDevice3);
		/*
		 * man door
		 */
		final Device manDoor = new Device();
		manDoor.setLocation("Main Floor");
		manDoor.setRef(67);
		manDoor.setName("Man Door Status");
		manDoor.setValue(23.0);
		addDevice(manDoor);
		/*
		 * kitchen dimmer
		 */
		final Device kitchenDimmer = new Device();
		kitchenDimmer.setLocation("Main Floor");
		kitchenDimmer.setRef(108);
		kitchenDimmer.setName("Kitchen Dimmer");
		kitchenDimmer.setValue(50.0);
		addDevice(kitchenDimmer);
		/*
		 * dining room dimmer
		 */
		final Device diningRoomDimmer = new Device();
		diningRoomDimmer.setLocation("Main Floor");
		diningRoomDimmer.setRef(49);
		diningRoomDimmer.setName("Dining Room Dimmer");
		diningRoomDimmer.setValue(75.0);
		addDevice(diningRoomDimmer);
		/*
		 * Back Outside Lights
		 */
		final Device backOutsideLights = new Device();
		backOutsideLights.setLocation("Outside");
		backOutsideLights.setRef(32);
		backOutsideLights.setName("Back Outside Lights");
		backOutsideLights.setValue(0.0);
		addDevice(backOutsideLights);
		/*
		 * Front Outside Lights
		 */
		final Device frontOutsideLights = new Device();
		frontOutsideLights.setLocation("Outside");
		frontOutsideLights.setRef(33);
		frontOutsideLights.setName("Front Outside Lights");
		frontOutsideLights.setValue(0.0);
		addDevice(frontOutsideLights);
		/*
		 * Fireplace Left Outlet
		 */
		final Device fireplaceLeftOutlet = new Device();
		fireplaceLeftOutlet.setLocation("Main Floor");
		fireplaceLeftOutlet.setRef(35);
		fireplaceLeftOutlet.setName("Fireplace Left Outlet");
		fireplaceLeftOutlet.setValue(0.0);
		addDevice(fireplaceLeftOutlet);
	}

	private void addEvent(Event event) {
		if (null == eventsByGroup.get(event.getGroup())) {
			eventsByGroup.put(event.getGroup(), new HashMap<String, Event>());
		}
		eventsByGroup.get(event.getGroup()).put(event.getName(), event);
		eventsById.put(event.getId(), event);
	}

	private void addEvents() {
		/*
		 * a event
		 */
		final Event event1 = new Event();
		event1.setName("event1");
		event1.setId(12);
		addEvent(event1);
	}

	@Override
	public void close() throws IOException {
		/*
		 * intentionally empty
		 */
	}

	@Override
	public void connect(HSConfiguration hsConfiguration) throws HSClientException, IOException {
		/*
		 * intentionally empty
		 */
	}

	@Override
	public Device controlDeviceByLabel(Integer ref, String label) throws HSClientException {
		return null;
	}

	@Override
	public Device controlDeviceByValue(Integer ref, double value) throws HSClientException {
		final Device ret = devicesByRef.get(ref);
		if (null != ret) {
			ret.setValue(value);
		}
		return ret;
	}

	@Override
	public List<Camera> getCameras() throws HSClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getCameraSnapshot(String camid) throws HSClientException {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Integer> getChangedDevices() throws HSClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Device getChildDeviceByDeviceType(Device device, String deviceType) throws HSClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Device> getChilden(Device device) throws HSClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Counter getCounter(String name) throws HSClientException {
		return countersByName.get(name);
	}

	@Override
	public Device getDevice(Integer ref) throws HSClientException {
		return devicesByRef.get(ref);
	}

	@Override
	public List<ControlPair> getDeviceControls(Integer ref) throws HSClientException {
		return null;
	}

	@Override
	public DeviceInfo getDeviceInfo() throws HSClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Device> getDevicesByName() throws HSClientException {
		return devicesByName;
	}

	@Override
	public Map<Integer, Device> getDevicesByRef() throws HSClientException {
		return devicesByRef;
	}

	@Override
	public Map<String, Map<String, Event>> getEventsByGroup() throws HSClientException {
		return eventsByGroup;
	}

	@Override
	public Map<Integer, Event> getEventsById() throws HSClientException {
		return eventsById;
	}

	@Override
	public String getHSVersion() throws HSClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getImage(String path) throws HSClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getLocations1() throws HSClientException {
		final List<String> locations = new ArrayList<String>();
		for (final Device device : devicesByRef.values()) {
			if (false == locations.contains(device.getLocation())) {
				locations.add(device.getLocation());
			}
		}
		return locations;
	}

	@Override
	public List<String> getLocations2() throws HSClientException {
		return null;
	}

	@Override
	public List<Plugin> getPlugins() throws HSClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPluginVersion(String pluginName) throws HSClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Device> getRootDevices() throws HSClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionConfig getSessionConfig() throws HSClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSetting(String name) throws HSClientException {
		/*
		 * intentionally empty, for now
		 */
		return null;
	}

	@Override
	public List<HSSystem> getSystems() throws HSClientException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getVersion() throws HSClientException {
		return "1.0";
	}

	@Override
	public void panCamera(CameraPan direction, String camid) throws HSClientException {
		// TODO Auto-generated method stub
	}

	@Override
	public String pluginfunction(String functionName, String plugin, String instance, Map<String, String> parameters) throws HSClientException {
		return null;
	}

	@Override
	public void register(String license, String password, String licenseold, String passold) throws HSClientException {
		// TODO Auto-generated method stub
	}

	@Override
	public void runEvent(Integer eventId) throws HSClientException {
		/*
		 * intentionally empty
		 */
	}

	@Override
	public void runEvent(String group, String name) throws HSClientException {
		/*
		 * intentionally empty
		 */
	}

	@Override
	public void speak(String phrase, String host) throws HSClientException {
		/*
		 * intentionally empty
		 */
	}

	@Override
	public void updatePlugin(String pluginName) throws HSClientException {
		// TODO Auto-generated method stub
	}
}
