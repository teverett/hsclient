package com.khubla.hsclient.response;

import java.util.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.khubla.hsclient.*;
import com.khubla.hsclient.domain.*;

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

	public List<Counter> getCounters() {
		return counters;
	}

	public String getName() {
		return name;
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

	public void setVersion(String version) {
		this.version = version;
	}
}
