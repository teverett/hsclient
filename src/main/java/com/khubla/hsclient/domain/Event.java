package com.khubla.hsclient.domain;

import com.fasterxml.jackson.annotation.*;

public class Event {
	@JsonProperty("Group")
	private String group;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("voice_command")
	private String voice_command;
	@JsonProperty("voice_command_enabled")
	private String voice_command_enabled;

	public String getGroup() {
		return group;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getVoice_command() {
		return voice_command;
	}

	public String getVoice_command_enabled() {
		return voice_command_enabled;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVoice_command(String voice_command) {
		this.voice_command = voice_command;
	}

	public void setVoice_command_enabled(String voice_command_enabled) {
		this.voice_command_enabled = voice_command_enabled;
	}
}
