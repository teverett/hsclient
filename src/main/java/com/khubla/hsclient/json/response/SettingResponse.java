package com.khubla.hsclient.json.response;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.khubla.hsclient.*;

/**
 * @author Tom Everett.
 * @copyright Copyright (C) 2020,tom@khubla.com
 */
public class SettingResponse {
	public static SettingResponse parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, SettingResponse.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	@JsonProperty("Value")
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
