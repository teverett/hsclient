package com.khubla.hsclient;

import java.io.*;
import java.util.*;

import com.khubla.hsclient.domain.*;

public interface HSClient extends Closeable {
	/**
	 * send control command by device label
	 *
	 * @param label
	 * @param value
	 * @return Device
	 * @throws HSClientException
	 */
	Device controlDeviceByLabel(String label, String value) throws HSClientException;

	/**
	 * send control command by device ref
	 *
	 * @param ref
	 * @param value
	 * @return Device
	 * @throws HSClientException
	 */
	Device controlDeviceByValue(Integer ref, String value) throws HSClientException;

	/**
	 * get value of counter
	 *
	 * @param name
	 * @return counter
	 * @throws HSClientException
	 */
	Counter getCounter(String name) throws HSClientException;

	/**
	 * get a device by ref
	 *
	 * @param ref
	 * @return Device
	 * @throws HSClientException
	 */
	Device getDevice(Integer ref) throws HSClientException;

	/**
	 * get a device with controls, by ref
	 *
	 * @param ref
	 * @return Device
	 * @throws HSClientException
	 */
	Device getDeviceControls(Integer ref) throws HSClientException;

	/**
	 * get all devices with controls
	 *
	 * @return Map<String, Device>
	 * @throws HSClientException
	 */
	Map<String, Device> getDeviceControlsByName() throws HSClientException;

	/**
	 * get all devices by reference id
	 *
	 * @return Map<Integer, Device>
	 * @throws HSClientException
	 */
	Map<Integer, Device> getDeviceControlsByRef() throws HSClientException;

	/**
	 * get all devices by name
	 *
	 * @return Map<String, Device>
	 * @throws HSClientException
	 */
	Map<String, Device> getDevicesByName() throws HSClientException;

	/**
	 * get all devices by reference id
	 *
	 * @return Map<Integer, Device>
	 * @throws HSClientException
	 */
	Map<Integer, Device> getDevicesByRef() throws HSClientException;

	/**
	 * get all events by id
	 *
	 * @return events by id
	 * @throws HSClientException
	 */
	Map<Integer, Event> getEventsById() throws HSClientException;

	/**
	 * get all events by name
	 *
	 * @return events by name
	 * @throws HSClientException
	 */
	Map<String, Event> getEventsByName() throws HSClientException;

	/**
	 * get all locations1
	 *
	 * @return list of location names
	 * @throws HSClientException
	 */
	List<String> getLocations1() throws HSClientException;

	/**
	 * get all locations2
	 *
	 * @return list of location names
	 * @throws HSClientException
	 */
	List<String> getLocations2() throws HSClientException;

	/**
	 * run an event by event id
	 *
	 * @param eventId
	 * @throws HSClientException
	 */
	void runEvent(Integer eventId) throws HSClientException;

	/**
	 * run an event by group name and event name
	 *
	 * @param group
	 * @param name
	 * @throws HSClientException
	 */
	void runEvent(String group, String name) throws HSClientException;
}