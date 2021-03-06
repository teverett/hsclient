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
public class CountersResponse {
	public static CountersResponse parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, CountersResponse.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	@JsonProperty("Name")
	private String name;
	@JsonProperty("Version")
	private String version;
	@JsonProperty("Counters")
	private List<Counter> counters;
	@JsonProperty("Response")
	private String response;

	public List<Counter> getCounters() {
		return counters;
	}

	public String getName() {
		return name;
	}

	public String getResponse() {
		return response;
	}

	public String getVersion() {
		return version;
	}

	public void setCounters(List<Counter> counters) {
		this.counters = counters;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
