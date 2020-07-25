package com.khubla.hsclient.plugins.zwave.domain;

import java.util.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.khubla.hsclient.plugins.zwave.converter.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class Node {
	@JsonProperty("NodeID")
	private Integer nodeId;
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Manufacturer")
	private String manufacturer;
	@JsonProperty("ProductType")
	private String productType;
	@JsonProperty("ProductID")
	private String productID;
	@JsonProperty("Listener")
	private Boolean listener;
	@JsonProperty("Library")
	private String library;
	@JsonProperty("Firmware")
	private String firmware;
	@JsonProperty("Hardware")
	private String hardware;
	@JsonProperty("NeighborCount")
	private Integer neighborCount;
	@JsonProperty("Speed")
	private String speed;
	@JsonProperty("Neighbors")
	@JsonDeserialize(converter = IntegerListConverter.class)
	private List<Integer> neighbors;
	@JsonProperty("LastWorkingRoute")
	private String lastWorkingRoute;
	@JsonProperty("BasicType")
	private String basicType;
	@JsonProperty("GenericType")
	private String genericType;
	@JsonProperty("SpecificType")
	private String specificType;
	@JsonProperty("CCControlled")
	private String ccControlled;
	@JsonProperty("CCSupportedSecure")
	private String ccSupportedSecure;
	@JsonProperty("CCControlledSecure")
	private String ccControlledSecure;
	@JsonProperty("DeviceRef")
	private Integer deviceRef;
	@JsonProperty("Beaming")
	private Boolean beaming;
	@JsonProperty("UsesInterface")
	private Integer usesInterface;
	@JsonProperty("CCSupported")
	private String ccSupported;

	public String getBasicType() {
		return basicType;
	}

	public Boolean getBeaming() {
		return beaming;
	}

	public String getCcControlled() {
		return ccControlled;
	}

	public String getCcControlledSecure() {
		return ccControlledSecure;
	}

	public String getCcSupported() {
		return ccSupported;
	}

	public String getCcSupportedSecure() {
		return ccSupportedSecure;
	}

	public Integer getDeviceRef() {
		return deviceRef;
	}

	public String getFirmware() {
		return firmware;
	}

	public String getGenericType() {
		return genericType;
	}

	public String getHardware() {
		return hardware;
	}

	public String getLastWorkingRoute() {
		return lastWorkingRoute;
	}

	public String getLibrary() {
		return library;
	}

	public Boolean getListener() {
		return listener;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getName() {
		return name;
	}

	public Integer getNeighborCount() {
		return neighborCount;
	}

	public List<Integer> getNeighbors() {
		return neighbors;
	}

	public Integer getNodeId() {
		return nodeId;
	}

	public String getProductID() {
		return productID;
	}

	public String getProductType() {
		return productType;
	}

	public String getSpecificType() {
		return specificType;
	}

	public String getSpeed() {
		return speed;
	}

	public Integer getUsesInterface() {
		return usesInterface;
	}

	public void setBasicType(String basicType) {
		this.basicType = basicType;
	}

	public void setBeaming(Boolean beaming) {
		this.beaming = beaming;
	}

	public void setCcControlled(String ccControlled) {
		this.ccControlled = ccControlled;
	}

	public void setCcControlledSecure(String ccControlledSecure) {
		this.ccControlledSecure = ccControlledSecure;
	}

	public void setCcSupported(String ccSupported) {
		this.ccSupported = ccSupported;
	}

	public void setCcSupportedSecure(String ccSupportedSecure) {
		this.ccSupportedSecure = ccSupportedSecure;
	}

	public void setDeviceRef(Integer deviceRef) {
		this.deviceRef = deviceRef;
	}

	public void setFirmware(String firmware) {
		this.firmware = firmware;
	}

	public void setGenericType(String genericType) {
		this.genericType = genericType;
	}

	public void setHardware(String hardware) {
		this.hardware = hardware;
	}

	public void setLastWorkingRoute(String lastWorkingRoute) {
		this.lastWorkingRoute = lastWorkingRoute;
	}

	public void setLibrary(String library) {
		this.library = library;
	}

	public void setListener(Boolean listener) {
		this.listener = listener;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNeighborCount(Integer neighborCount) {
		this.neighborCount = neighborCount;
	}

	public void setNeighbors(List<Integer> neighbors) {
		this.neighbors = neighbors;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public void setSpecificType(String specificType) {
		this.specificType = specificType;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public void setUsesInterface(Integer usesInterface) {
		this.usesInterface = usesInterface;
	}
}
