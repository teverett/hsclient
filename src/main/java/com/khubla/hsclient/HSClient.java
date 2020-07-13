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
public interface HSClient extends Closeable {
	/**
	 * connect
	 * 
	 * @param hsConfiguration config
	 * @throws HSClientException exception connecting
	 * @throws IOException exception connecting
	 */
	void connect(HSConfiguration hsConfiguration) throws HSClientException, IOException;

	/**
	 * send control command by device label
	 *
	 * @param ref reference id of device
	 * @param label, such as "on" or "off"
	 * @return Device
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	Device controlDeviceByLabel(Integer ref, String label) throws HSClientException;

	/**
	 * send control command by device ref
	 *
	 * @param ref reference id of device
	 * @param value value to set
	 * @return Device
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	Device controlDeviceByValue(Integer ref, double value) throws HSClientException;

	/**
	 * get child devices of device
	 *
	 * @param device parent device
	 * @return devices
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	Map<Integer, Device> getChilden(Device device) throws HSClientException;

	/**
	 * get value of counter
	 *
	 * @param name Name of counter
	 * @return counter
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	Counter getCounter(String name) throws HSClientException;

	/**
	 * get a device by ref
	 *
	 * @param ref reference id of device
	 * @return Device
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	Device getDevice(Integer ref) throws HSClientException;

	/**
	 * get a device with controls, by ref
	 *
	 * @param ref reference id of device
	 * @return Device
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	Device getDeviceControls(Integer ref) throws HSClientException;

	/**
	 * get all devices with controls
	 *
	 * @return Map of devices by device name
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	Map<String, Device> getDeviceControlsByName() throws HSClientException;

	/**
	 * get all devices by reference id
	 *
	 * @return Map of devices by reference number
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	Map<Integer, Device> getDeviceControlsByRef() throws HSClientException;

	/**
	 * get all devices by name
	 *
	 * @return Map of devices by device name
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	Map<String, Device> getDevicesByName() throws HSClientException;

	/**
	 * get all devices by reference id
	 *
	 * @return Map of devices by reference number
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	Map<Integer, Device> getDevicesByRef() throws HSClientException;

	/**
	 * get all events by group name
	 *
	 * @return events by group name and then by name
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	Map<String, Map<String, Event>> getEventsByGroup() throws HSClientException;

	/**
	 * get all events by id
	 *
	 * @return events by id
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	Map<Integer, Event> getEventsById() throws HSClientException;

	/**
	 * get all locations1
	 *
	 * @return list of location names
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	List<String> getLocations1() throws HSClientException;

	/**
	 * get all locations2
	 *
	 * @return list of location names
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	List<String> getLocations2() throws HSClientException;

	/**
	 * get root devices
	 *
	 * @return devices
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	Map<Integer, Device> getRootDevices() throws HSClientException;

	/**
	 * get a setting
	 *
	 * @param name of setting
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 * @return setting value
	 */
	String getSetting(String name) throws HSClientException;

	/**
	 * get HS JSON API version
	 *
	 * @return version string
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	String getVersion() throws HSClientException;

	/**
	 * run an event by event id
	 *
	 * @param eventId ID of event
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	void runEvent(Integer eventId) throws HSClientException;

	/**
	 * run an event by group name and event name
	 *
	 * @param group group name
	 * @param name name of event
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	void runEvent(String group, String name) throws HSClientException;

	/**
	 * speak a phrase
	 *
	 * @param phrase phrase to speak
	 * @param host host to speak on
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	void speak(String phrase, String host) throws HSClientException;
}