package com.khubla.hsclient.domain;

import java.util.*;

public class Device {
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

	public List<Integer> getAssociated_devices() {
		return associated_devices;
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

	public String getHide_from_view() {
		return hide_from_view;
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

	public Integer getValue() {
		return value;
	}

	public void setAssociated_devices(List<Integer> associated_devices) {
		this.associated_devices = associated_devices;
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

	public void setHide_from_view(String hide_from_view) {
		this.hide_from_view = hide_from_view;
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

	public void setValue(Integer value) {
		this.value = value;
	}
}
