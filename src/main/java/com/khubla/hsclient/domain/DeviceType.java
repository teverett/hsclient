package com.khubla.hsclient.domain;

import com.fasterxml.jackson.annotation.*;

public class DeviceType {
	@JsonProperty("Device_API")
	private Integer device_API;
	@JsonProperty("Device_API_Description")
	private String device_API_Description;
	@JsonProperty("Device_Type")
	private Integer device_Type;
	@JsonProperty("Device_Type_Description")
	private String device_Type_Description;
	@JsonProperty("Device_SubType")
	private Integer device_SubType;
	@JsonProperty("Device_SubType_Description")
	private String device_SubType_Description;

	public String getDevice_API_Description() {
		return device_API_Description;
	}

	public String getDevice_SubType_Description() {
		return device_SubType_Description;
	}

	public String getDevice_Type_Description() {
		return device_Type_Description;
	}

	public void setDevice_API_Description(String device_API_Description) {
		this.device_API_Description = device_API_Description;
	}

	public void setDevice_SubType_Description(String device_SubType_Description) {
		this.device_SubType_Description = device_SubType_Description;
	}

	public void setDevice_Type_Description(String device_Type_Description) {
		this.device_Type_Description = device_Type_Description;
	}
}
