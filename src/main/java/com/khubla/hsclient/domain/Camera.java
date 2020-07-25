package com.khubla.hsclient.domain;

import com.fasterxml.jackson.annotation.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class Camera {
	@JsonProperty("Name")
	private Integer name;
	@JsonProperty("ID")
	private Integer id;
	@JsonProperty("SnapShot")
	private Integer snapShot;
	@JsonProperty("SupportsPanTilt")
	private Boolean SupportsPanTilt;

	public Integer getId() {
		return id;
	}

	public Integer getName() {
		return name;
	}

	public Integer getSnapShot() {
		return snapShot;
	}

	public Boolean getSupportsPanTilt() {
		return SupportsPanTilt;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(Integer name) {
		this.name = name;
	}

	public void setSnapShot(Integer snapShot) {
		this.snapShot = snapShot;
	}

	public void setSupportsPanTilt(Boolean supportsPanTilt) {
		SupportsPanTilt = supportsPanTilt;
	}
}
