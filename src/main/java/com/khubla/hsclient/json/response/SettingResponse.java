package com.khubla.hsclient.json.response;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.khubla.hsclient.json.*;

public class SettingResponse {
	public static SettingResponse parse(String json) throws HSJSONClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, SettingResponse.class);
		} catch (final Exception e) {
			throw new HSJSONClientException(e);
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
