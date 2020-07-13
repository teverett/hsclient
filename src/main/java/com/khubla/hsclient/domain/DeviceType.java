package com.khubla.hsclient.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.khubla.hsclient.domain.converter.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class DeviceType {
	@JsonProperty("Device_API")
	@JsonDeserialize(converter = APITypeConverter.class)
	private APIType device_API;
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

	public APIType getDevice_API() {
		return device_API;
	}

	public String getDevice_API_Description() {
		return device_API_Description;
	}

	public Integer getDevice_SubType() {
		return device_SubType;
	}

	public String getDevice_SubType_Description() {
		return device_SubType_Description;
	}

	public Integer getDevice_Type() {
		return device_Type;
	}

	public String getDevice_Type_Description() {
		return device_Type_Description;
	}

	public void setDevice_API(APIType device_API) {
		this.device_API = device_API;
	}

	public void setDevice_API_Description(String device_API_Description) {
		this.device_API_Description = device_API_Description;
	}

	public void setDevice_SubType(Integer device_SubType) {
		this.device_SubType = device_SubType;
	}

	public void setDevice_SubType_Description(String device_SubType_Description) {
		this.device_SubType_Description = device_SubType_Description;
	}

	public void setDevice_Type(Integer device_Type) {
		this.device_Type = device_Type;
	}

	public void setDevice_Type_Description(String device_Type_Description) {
		this.device_Type_Description = device_Type_Description;
	}
}
