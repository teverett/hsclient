package com.khubla.hsclient.json.response;

import java.util.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.khubla.hsclient.*;
import com.khubla.hsclient.domain.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class DeviceResponse {
	public static DeviceResponse parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, DeviceResponse.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	private String ref;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Version")
	private String version;
	@JsonProperty("TempFormatF")
	private Boolean tempFormatF;
	@JsonProperty("Response")
	private String response;
	private String location;
	private String location2;
	@JsonProperty("Devices")
	private List<Device> devices;

	public List<Device> getDevices() {
		return devices;
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

	public String getRef() {
		return ref;
	}

	public String getResponse() {
		return response;
	}

	public Boolean getTempFormatF() {
		return tempFormatF;
	}

	public String getVersion() {
		return version;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setLocation2(String location2) {
		this.location2 = location2;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public void setTempFormatF(Boolean tempFormatF) {
		this.tempFormatF = tempFormatF;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
