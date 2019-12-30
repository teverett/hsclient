package com.khubla.hsclient.response;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.khubla.hsclient.domain.*;

public class StatusResponse {
	public static StatusResponse parse(String json) throws JsonParseException, JsonMappingException, IOException {
		final ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, StatusResponse.class);
	}

	@JsonProperty("Name")
	private String name;
	@JsonProperty("Version")
	private String version;
	@JsonProperty("Devices")
	private List<Device> devices;

	public List<Device> getDevices() {
		return devices;
	}

	public String getName() {
		return name;
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

	public void setVersion(String version) {
		this.version = version;
	}
}
