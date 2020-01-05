package com.khubla.hsclient.json.response;

import java.util.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.khubla.hsclient.domain.*;
import com.khubla.hsclient.json.*;

public class EventsResponse {
	public static EventsResponse parse(String json) throws HSJSONClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, EventsResponse.class);
		} catch (final Exception e) {
			throw new HSJSONClientException(e);
		}
	}

	@JsonProperty("Name")
	private String name;
	@JsonProperty("Version")
	private String version;
	@JsonProperty("Events")
	private List<Event> events;

	public List<Event> getEvents() {
		return events;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
