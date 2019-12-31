package com.khubla.hsclient.domain;

import com.fasterxml.jackson.annotation.*;

public class Event {
	@JsonProperty("Group")
	private String group;
	@JsonProperty("Name")
	private String name;

	public String getGroup() {
		return group;
	}

	public String getName() {
		return name;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void setName(String name) {
		this.name = name;
	}
}
