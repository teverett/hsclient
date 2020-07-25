package com.khubla.hsclient.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.khubla.hsclient.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class SessionConfig {
	public static SessionConfig parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, SessionConfig.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	private String hsVersion;
	private Boolean isLocation1First;
	private Boolean useLocation2;
	private String location1Label;
	private String location2Label;
	@JsonProperty("Floor")
	private String floor;
	private String username;
	private UserPermissions userPermissions;
	@JsonProperty("Version")
	private String version;

	public String getFloor() {
		return floor;
	}

	public String getHsVersion() {
		return hsVersion;
	}

	public Boolean getIsLocation1First() {
		return isLocation1First;
	}

	public String getLocation1Label() {
		return location1Label;
	}

	public String getLocation2Label() {
		return location2Label;
	}

	public Boolean getUseLocation2() {
		return useLocation2;
	}

	public String getUsername() {
		return username;
	}

	public UserPermissions getUserPermissions() {
		return userPermissions;
	}

	public String getVersion() {
		return version;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public void setHsVersion(String hsVersion) {
		this.hsVersion = hsVersion;
	}

	public void setIsLocation1First(Boolean isLocation1First) {
		this.isLocation1First = isLocation1First;
	}

	public void setLocation1Label(String location1Label) {
		this.location1Label = location1Label;
	}

	public void setLocation2Label(String location2Label) {
		this.location2Label = location2Label;
	}

	public void setUseLocation2(Boolean useLocation2) {
		this.useLocation2 = useLocation2;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserPermissions(UserPermissions userPermissions) {
		this.userPermissions = userPermissions;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
