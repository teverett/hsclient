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
public class GetImageResponse {
	public static GetImageResponse parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, GetImageResponse.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	@JsonProperty("Response")
	private String response;
	@JsonProperty("FileBase64")
	private String fileBase64;

	public String getFileBase64() {
		return fileBase64;
	}

	public String getResponse() {
		return response;
	}

	public void setFileBase64(String fileBase64) {
		this.fileBase64 = fileBase64;
	}

	public void setResponse(String response) {
		this.response = response;
	}
}
