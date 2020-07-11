package com.khubla.hsclient.poll;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class DataPoint {
	private final Integer deviceRef;
	private final Double value;
	private final long lastChange;
	private final String location;
	private final String location2;
	private final String name;
	private final String status;
	private final String type;

	public DataPoint(Integer deviceRef, Double value, long lastChange, String location, String location2, String name, String status, String type) {
		super();
		this.deviceRef = deviceRef;
		this.value = value;
		this.lastChange = lastChange;
		this.location = location;
		this.location2 = location2;
		this.name = name;
		this.status = status;
		this.type = type;
	}

	public Integer getDeviceRef() {
		return deviceRef;
	}

	public long getLastChange() {
		return lastChange;
	}

	public String getLocation() {
		return location;
	}

	public String getLocation2() {
		return location2;
	}

	public String getName() {
		return name;
	}

	public String getStatus() {
		return status;
	}

	public String getType() {
		return type;
	}

	public Double getValue() {
		return value;
	}
}
