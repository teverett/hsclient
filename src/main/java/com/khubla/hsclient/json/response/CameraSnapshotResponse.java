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
public class CameraSnapshotResponse {
	public static CameraSnapshotResponse parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, CameraSnapshotResponse.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	@JsonProperty("Name")
	private String name;
	@JsonProperty("ID")
	private String id;
	@JsonProperty("SnapShot")
	private String snapShot;
	@JsonProperty("SupportsPanTilt")
	private Boolean supportsPanTilt;
	@JsonProperty("Response")
	private String response;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getResponse() {
		return response;
	}

	public String getSnapShot() {
		return snapShot;
	}

	public Boolean getSupportsPanTilt() {
		return supportsPanTilt;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSnapShot(String snapShot) {
		this.snapShot = snapShot;
	}

	public void setSupportsPanTilt(Boolean supportsPanTilt) {
		this.supportsPanTilt = supportsPanTilt;
	}
}
