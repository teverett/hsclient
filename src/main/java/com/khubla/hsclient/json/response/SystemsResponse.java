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
public class SystemsResponse {
	public static SystemsResponse parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, SystemsResponse.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	@JsonProperty("Response")
	private String response;
	private String responsecode;
	private List<HSSystem> systems;
	@JsonProperty("HasSubscription")
	private boolean hasSubscription;

	public String getResponse() {
		return response;
	}

	public String getResponsecode() {
		return responsecode;
	}

	public List<HSSystem> getSystems() {
		return systems;
	}

	public boolean isHasSubscription() {
		return hasSubscription;
	}

	public void setHasSubscription(boolean hasSubscription) {
		this.hasSubscription = hasSubscription;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public void setResponsecode(String responsecode) {
		this.responsecode = responsecode;
	}

	public void setSystems(List<HSSystem> systems) {
		this.systems = systems;
	}
}
