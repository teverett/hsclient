package com.khubla.hsclient.domain;

import com.fasterxml.jackson.annotation.*;

/**
 * @author Tom Everett.
 * @copyright Copyright (C) 2020,tom@khubla.com
 */
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
