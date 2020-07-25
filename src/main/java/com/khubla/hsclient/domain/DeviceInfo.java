package com.khubla.hsclient.domain;

import java.util.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.khubla.hsclient.*;
import com.khubla.hsclient.domain.converter.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class DeviceInfo {
	public static DeviceInfo parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, DeviceInfo.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	@JsonProperty("Name")
	private String name;
	@JsonProperty("Version")
	private String version;
	@JsonProperty("Count")
	private Integer count;
	@JsonDeserialize(converter = DateConverter.class)
	@JsonProperty("TimeLastDeviceAdded")
	private Date timeLastDeviceAdded;
	@JsonDeserialize(converter = DateConverter.class)
	@JsonProperty("TimeLastDeviceRemoved")
	private Date timeLastDeviceRemoved;

	public Integer getCount() {
		return count;
	}

	public String getName() {
		return name;
	}

	public Date getTimeLastDeviceAdded() {
		return timeLastDeviceAdded;
	}

	public Date getTimeLastDeviceRemoved() {
		return timeLastDeviceRemoved;
	}

	public String getVersion() {
		return version;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTimeLastDeviceAdded(Date timeLastDeviceAdded) {
		this.timeLastDeviceAdded = timeLastDeviceAdded;
	}

	public void setTimeLastDeviceRemoved(Date timeLastDeviceRemoved) {
		this.timeLastDeviceRemoved = timeLastDeviceRemoved;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
