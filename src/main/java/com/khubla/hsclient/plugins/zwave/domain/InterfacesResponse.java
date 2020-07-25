package com.khubla.hsclient.plugins.zwave.domain;

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
public class InterfacesResponse {
	public static InterfacesResponse parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, InterfacesResponse.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	@JsonProperty("Name")
	private String name;
	@JsonProperty("Version")
	private String version;
	@JsonProperty("List")
	private List<Interface> list;

	public List<Interface> getList() {
		return list;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public void setList(List<Interface> list) {
		this.list = list;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
