package com.khubla.hsclient.plugins.zwave.domain;

import com.fasterxml.jackson.annotation.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class Interface {
	@JsonProperty("Unique")
	private String unique;
	@JsonProperty("IsMain")
	private Boolean isMain;
	@JsonProperty("FriendlyName")
	private String friendlyName;
	@JsonProperty("NodeID")
	private Integer nodeId;
	@JsonProperty("NodeCount")
	private Integer nodeCount;

	public String getFriendlyName() {
		return friendlyName;
	}

	public Boolean getIsMain() {
		return isMain;
	}

	public Integer getNodeCount() {
		return nodeCount;
	}

	public Integer getNodeId() {
		return nodeId;
	}

	public String getUnique() {
		return unique;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public void setIsMain(Boolean isMain) {
		this.isMain = isMain;
	}

	public void setNodeCount(Integer nodeCount) {
		this.nodeCount = nodeCount;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public void setUnique(String unique) {
		this.unique = unique;
	}
}
