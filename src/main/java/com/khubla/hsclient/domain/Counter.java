package com.khubla.hsclient.domain;

import com.fasterxml.jackson.annotation.*;

public class Counter {
	@JsonProperty("name")
	private String name;
	@JsonProperty("value")
	private String value;

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
