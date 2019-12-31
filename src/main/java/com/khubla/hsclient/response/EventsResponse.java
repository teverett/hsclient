package com.khubla.hsclient.response;

import java.util.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.khubla.hsclient.*;
import com.khubla.hsclient.domain.*;

public class EventsResponse {
	public static EventsResponse parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, EventsResponse.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
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
