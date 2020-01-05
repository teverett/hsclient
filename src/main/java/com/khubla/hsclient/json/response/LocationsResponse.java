package com.khubla.hsclient.json.response;

import java.util.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.khubla.hsclient.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class LocationsResponse {
	public static LocationsResponse parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, LocationsResponse.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	@JsonProperty("Name")
	private String name;
	@JsonProperty("Version")
	private String version;
	@JsonProperty("location1")
	private List<String> location1;
	@JsonProperty("location2")
	private List<String> location2;

	public List<String> getLocation1() {
		return location1;
	}

	public List<String> getLocation2() {
		return location2;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public void setLocation1(List<String> location1) {
		this.location1 = location1;
	}

	public void setLocation2(List<String> location2) {
		this.location2 = location2;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
