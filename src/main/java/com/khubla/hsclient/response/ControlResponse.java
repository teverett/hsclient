package com.khubla.hsclient.response;

import java.io.*;
import java.util.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.khubla.hsclient.domain.*;

public class ControlResponse {
	public static ControlResponse parse(String json) throws JsonParseException, JsonMappingException, IOException {
		final ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, ControlResponse.class);
	}

	private String ref;
	private String name;
	private String location;
	private String location2;
	@JsonProperty("ControlPairs")
	private List<ControlPair> controlPairs;

	public List<ControlPair> getControlPairs() {
		return controlPairs;
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

	public void setControlPairs(List<ControlPair> controlPairs) {
		this.controlPairs = controlPairs;
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
}
