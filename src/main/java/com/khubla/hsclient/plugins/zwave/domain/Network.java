package com.khubla.hsclient.plugins.zwave.domain;

import java.util.*;

import com.fasterxml.jackson.annotation.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class Network {
	@JsonProperty("HomeID")
	private String homeId;
	@JsonProperty("FriendlyName")
	private String friendlyName;
	@JsonProperty("Interfaces")
	private List<Interface> interfaces;

	public String getFriendlyName() {
		return friendlyName;
	}

	public String getHomeId() {
		return homeId;
	}

	public List<Interface> getInterfaces() {
		return interfaces;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public void setHomeId(String homeId) {
		this.homeId = homeId;
	}

	public void setInterfaces(List<Interface> interfaces) {
		this.interfaces = interfaces;
	}
}
