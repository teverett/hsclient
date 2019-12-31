package com.khubla.hsclient.domain;

import java.util.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.khubla.hsclient.*;

public class Device {
	public static Device parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, Device.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	private Integer ref;
	private String location;
	private String name;
	private String location2;
	private Integer value;
	private String status;
	private String device_type_string;
	private String last_change;
	private Integer relationship;
	private String hide_from_view;
	private List<Integer> associated_devices = new ArrayList<Integer>();
	private DeviceType device_type;
	private String device_image;
	private String device_type_values;
	@JsonProperty("UserNote")
	private String userNote;
	@JsonProperty("UserAccess")
	private String userAccess;
	private String status_image;
	private String voice_command;
	private String misc;
	private String interface_name;
	@JsonProperty("ControlPairs")
	private List<ControlPair> controlPairs;

	public List<Integer> getAssociated_devices() {
		return associated_devices;
	}

	public List<ControlPair> getControlPairs() {
		return controlPairs;
	}

	public String getDevice_image() {
		return device_image;
	}

	public DeviceType getDevice_type() {
		return device_type;
	}

	public String getDevice_type_string() {
		return device_type_string;
	}

	public String getDevice_type_values() {
		return device_type_values;
	}

	public String getHide_from_view() {
		return hide_from_view;
	}

	public String getInterface_name() {
		return interface_name;
	}

	public String getLast_change() {
		return last_change;
	}

	public String getLocation() {
		return location;
	}

	public String getLocation2() {
		return location2;
	}

	public String getMisc() {
		return misc;
	}

	public String getName() {
		return name;
	}

	public Integer getRef() {
		return ref;
	}

	public Integer getRelationship() {
		return relationship;
	}

	public String getStatus() {
		return status;
	}

	public String getStatus_image() {
		return status_image;
	}

	public String getUserAccess() {
		return userAccess;
	}

	public String getUserNote() {
		return userNote;
	}

	public Integer getValue() {
		return value;
	}

	public String getVoice_command() {
		return voice_command;
	}

	public void setAssociated_devices(List<Integer> associated_devices) {
		this.associated_devices = associated_devices;
	}

	public void setControlPairs(List<ControlPair> controlPairs) {
		this.controlPairs = controlPairs;
	}

	public void setDevice_image(String device_image) {
		this.device_image = device_image;
	}

	public void setDevice_type(DeviceType device_type) {
		this.device_type = device_type;
	}

	public void setDevice_type_string(String device_type_string) {
		this.device_type_string = device_type_string;
	}

	public void setDevice_type_values(String device_type_values) {
		this.device_type_values = device_type_values;
	}

	public void setHide_from_view(String hide_from_view) {
		this.hide_from_view = hide_from_view;
	}

	public void setInterface_name(String interface_name) {
		this.interface_name = interface_name;
	}

	public void setLast_change(String last_change) {
		this.last_change = last_change;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setLocation2(String location2) {
		this.location2 = location2;
	}

	public void setMisc(String misc) {
		this.misc = misc;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRef(Integer ref) {
		this.ref = ref;
	}

	public void setRelationship(Integer relationship) {
		this.relationship = relationship;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStatus_image(String status_image) {
		this.status_image = status_image;
	}

	public void setUserAccess(String userAccess) {
		this.userAccess = userAccess;
	}

	public void setUserNote(String userNote) {
		this.userNote = userNote;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public void setVoice_command(String voice_command) {
		this.voice_command = voice_command;
	}
}
