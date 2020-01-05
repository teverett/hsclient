package com.khubla.hsclient.domain;

import com.fasterxml.jackson.annotation.*;

public class Counter {
	@JsonProperty("name")
	private String name;
	@JsonProperty("value")
	private Integer value;

	public String getName() {
		return name;
	}

	public Integer getValue() {
		return value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
