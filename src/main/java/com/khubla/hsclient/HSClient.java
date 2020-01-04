package com.khubla.hsclient;

import java.io.*;
import java.util.*;

import com.khubla.hsclient.domain.*;
import com.khubla.hsclient.response.*;

public interface HSClient extends Closeable {
	Device controlDeviceByLabel(String label, String value) throws HSClientException;

	Device controlDeviceByValue(Integer ref, String value) throws HSClientException;

	ControlResponse getControl(Integer ref) throws HSClientException;

	CountersResponse getCounter(String counter) throws HSClientException;

	Map<String, Device> getDevicesByName() throws HSClientException;

	Map<Integer, Device> getDevicesByRef() throws HSClientException;

	EventsResponse getEvents() throws HSClientException;

	LocationsResponse getLocations() throws HSClientException;

	SettingResponse getSetting(String setting) throws HSClientException;

	StatusResponse getStatus(Integer ref, String location1, String location2) throws HSClientException;

	void runEvent(String eventid) throws HSClientException;

	void runEvent(String group, String eventname) throws HSClientException;

	void speak(String phrase, String host) throws HSClientException;
}