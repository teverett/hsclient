package com.khubla.hsclient.json.response;

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
public class ChangedDevicesResponse {
	public static ChangedDevicesResponse parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, ChangedDevicesResponse.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	private List<Integer> refs;
	@JsonProperty("Response")
	private String response;

	public List<Integer> getRefs() {
		return refs;
	}

	public String getResponse() {
		return response;
	}

	public void setRefs(List<Integer> refs) {
		this.refs = refs;
	}
}
