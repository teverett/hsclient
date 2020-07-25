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
public class CamerasResponse {
	public static CamerasResponse parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, CamerasResponse.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	@JsonProperty("Name")
	private String name;
	@JsonProperty("Version")
	private String version;
	@JsonProperty("Cameras")
	private List<Camera> cameras;

	public List<Camera> getCameras() {
		return cameras;
	}

	public String getName() {
		return name;
	}

	public String getVersion() {
		return version;
	}

	public void setCameras(List<Camera> cameras) {
		this.cameras = cameras;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
