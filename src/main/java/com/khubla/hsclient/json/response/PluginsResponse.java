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
public class PluginsResponse {
	public static PluginsResponse parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, PluginsResponse.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	@JsonProperty("Name")
	private String name;
	@JsonProperty("Version")
	private String version;
	@JsonProperty("Plugins")
	private List<Plugin> plugins;
	@JsonProperty("Response")
	private String response;

	public String getName() {
		return name;
	}

	public List<Plugin> getPlugins() {
		return plugins;
	}

	public String getResponse() {
		return response;
	}

	public String getVersion() {
		return version;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlugins(List<Plugin> plugins) {
		this.plugins = plugins;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
