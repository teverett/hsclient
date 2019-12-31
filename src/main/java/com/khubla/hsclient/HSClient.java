package com.khubla.hsclient;

import com.khubla.hsclient.domain.*;
import com.khubla.hsclient.response.*;

public interface HSClient {
	Device controlDeviceByLabel(String label, String value) throws HSClientException;

	Device controlDeviceByValue(Integer ref, String value) throws HSClientException;

	ControlResponse getControl(Integer ref) throws HSClientException;

	Integer getCounter(String counter) throws HSClientException;

	EventsResponse getEvents() throws HSClientException;

	void getLocations() throws HSClientException;

	SettingResponse getSetting(String setting) throws HSClientException;

	StatusResponse getStatus(Integer ref, String location1, String location2) throws HSClientException;

	void runEvent(String eventid) throws HSClientException;

	void runEvent(String group, String eventname) throws HSClientException;

	void speak(String phrase, String host) throws HSClientException;
}