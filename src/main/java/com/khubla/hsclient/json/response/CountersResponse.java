package com.khubla.hsclient.json.response;

import java.util.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.khubla.hsclient.domain.*;
import com.khubla.hsclient.json.*;

public class CountersResponse {
	public static CountersResponse parse(String json) throws HSJSONClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, CountersResponse.class);
		} catch (final Exception e) {
			throw new HSJSONClientException(e);
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
