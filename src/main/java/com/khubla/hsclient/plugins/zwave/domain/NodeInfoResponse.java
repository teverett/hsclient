package com.khubla.hsclient.plugins.zwave.domain;

import java.util.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.*;
import com.khubla.hsclient.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class NodeInfoResponse {
	public static NodeInfoResponse parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, NodeInfoResponse.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	@JsonProperty("HomeID")
	private String homeID;
	@JsonProperty("NetworkFriendlyName")
	private String networkFriendlyName;
	@JsonProperty("Nodes")
	private List<Node> nodes;

	public String getHomeID() {
		return homeID;
	}

	public String getNetworkFriendlyName() {
		return networkFriendlyName;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setHomeID(String homeID) {
		this.homeID = homeID;
	}

	public void setNetworkFriendlyName(String networkFriendlyName) {
		this.networkFriendlyName = networkFriendlyName;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
}
