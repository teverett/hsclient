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
public class ControlResponse {
	public static ControlResponse parse(String json) throws HSClientException {
		try {
			System.out.println(json);
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, ControlResponse.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	@JsonProperty("ControlPairs")
	private List<ControlPair> controlPairs;
	private String ref;
	@JsonProperty("name")
	private String name;
	@JsonProperty("Version")
	private String version;
	private String location;
	private String location2;
	private String voice_command;

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

	public String getVersion() {
		return version;
	}

	public String getVoice_command() {
		return voice_command;
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

	public void setVersion(String version) {
		this.version = version;
	}

	public void setVoice_command(String voice_command) {
		this.voice_command = voice_command;
	}
}
