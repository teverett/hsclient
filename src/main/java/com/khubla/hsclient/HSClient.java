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
	 * send control command by device label
	 *
	 * @param label name of value to set
	 * @param value value to set
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
	 * get all events by id
	 *
	 * @return events by id
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	Map<Integer, Event> getEventsById() throws HSClientException;

	/**
	 * get all events by name
	 *
	 * @return events by name
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	Map<String, Event> getEventsByName() throws HSClientException;

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
	 * run an event by event id
	 *
	 * @param eventId
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	void runEvent(Integer eventId) throws HSClientException;

	/**
	 * run an event by group name and event name
	 *
	 * @param group
	 * @param name
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
	public void speak(String phrase, String host) throws HSClientException;
}