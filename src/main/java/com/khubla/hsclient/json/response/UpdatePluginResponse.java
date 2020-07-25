package com.khubla.hsclient.json.response;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.khubla.hsclient.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class UpdatePluginResponse {
	public static UpdatePluginResponse parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, UpdatePluginResponse.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	@JsonProperty("Response")
	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
