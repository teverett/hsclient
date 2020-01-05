package com.khubla.hsclient;

import java.io.*;
import java.util.*;

import com.khubla.hsclient.domain.*;
import com.khubla.hsclient.json.*;

public interface HSClient extends Closeable {
	/**
	 * send control command by device label
	 *
	 * @param label
	 * @param value
	 * @return
	 * @throws HSJSONClientException
	 */
	Device controlDeviceByLabel(String label, String value) throws HSJSONClientException;

	/**
	 * send control command by device ref
	 *
	 * @param ref
	 * @param value
	 * @return
	 * @throws HSJSONClientException
	 */
	Device controlDeviceByValue(Integer ref, String value) throws HSJSONClientException;

	/**
	 * get value of counter
	 *
	 * @param name
	 * @return counter
	 * @throws HSJSONClientException
	 */
	Counter getCounter(String name) throws HSJSONClientException;

	/**
	 * get a device by ref
	 *
	 * @param ref
	 * @return Device
	 * @throws HSJSONClientException
	 */
	Device getDevice(Integer ref) throws HSJSONClientException;

	/**
	 * get a device with controls, by ref
	 *
	 * @param ref
	 * @return Device
	 * @throws HSJSONClientException
	 */
	Device getDeviceControls(Integer ref) throws HSJSONClientException;

	/**
	 * get all devices with controls
	 *
	 * @return Map<String, Device>
	 * @throws HSJSONClientException
	 */
	Map<String, Device> getDeviceControlsByName() throws HSJSONClientException;

	/**
	 * get all devices by reference id
	 *
	 * @return Map<Integer, Device>
	 * @throws HSJSONClientException
	 */
	Map<Integer, Device> getDeviceControlsByRef() throws HSJSONClientException;

	/**
	 * get all devices by name
	 *
	 * @return Map<String, Device>
	 * @throws HSJSONClientException
	 */
	Map<String, Device> getDevicesByName() throws HSJSONClientException;

	/**
	 * get all devices by reference id
	 *
	 * @return Map<Integer, Device>
	 * @throws HSJSONClientException
	 */
	Map<Integer, Device> getDevicesByRef() throws HSJSONClientException;

	/**
	 * get all events by id
	 *
	 * @return events by id
	 * @throws HSJSONClientException
	 */
	Map<Integer, Event> getEventsById() throws HSJSONClientException;

	/**
	 * get all events by name
	 *
	 * @return events by name
	 * @throws HSJSONClientException
	 */
	Map<String, Event> getEventsByName() throws HSJSONClientException;

	/**
	 * get all locations
	 *
	 * @return list of location names
	 * @throws HSJSONClientException
	 */
	List<String> getLocations() throws HSJSONClientException;

	/**
	 * run an event by event id
	 *
	 * @param eventId
	 * @throws HSJSONClientException
	 */
	void runEvent(Integer eventId) throws HSJSONClientException;

	/**
	 * run an event by group name and event name
	 *
	 * @param group
	 * @param name
	 * @throws HSJSONClientException
	 */
	void runEvent(String group, String name) throws HSJSONClientException;
}