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
public class StatusResponse {
	public static StatusResponse parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, StatusResponse.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	@JsonProperty("Name")
	private String name;
	@JsonProperty("Version")
	private String version;
	@JsonProperty("Devices")
	private List<Device> devices;
	@JsonProperty("TempFormatF")
	private Boolean tempFormat;

	public List<Device> getDevices() {
		return devices;
	}

	public String getName() {
		return name;
	}

	public Boolean getTempFormat() {
		return tempFormat;
	}

	public String getVersion() {
		return version;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTempFormat(Boolean tempFormat) {
		this.tempFormat = tempFormat;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
