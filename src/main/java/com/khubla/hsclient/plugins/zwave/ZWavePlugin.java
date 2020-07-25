package com.khubla.hsclient.plugins.zwave;

import java.util.*;

import com.khubla.hsclient.*;
import com.khubla.hsclient.plugins.zwave.domain.*;

public interface ZWavePlugin {
	/**
	 * get all Z-Wave interfaces
	 *
	 * @return interfaces
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	List<Interface> getInterfaces() throws HSClientException;

	/**
	 * get Z-Wave networks
	 *
	 * @return networks
	 * @throws HSClientException
	 */
	List<Network> getNetworks() throws HSClientException;

	/**
	 * get info on all Z-Wave nodes
	 *
	 * @param interfaceId
	 * @return list of Z-Wave Node objects
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	List<Node> getNodeInfo(String interfaceId) throws HSClientException;

	/**
	 * get interface status
	 *
	 * @param interfaceId
	 * @return stsatus string for interface
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	String getStatus(String interfaceId) throws HSClientException;

	/**
	 * Check if interface is running
	 *
	 * @param interfaceId
	 * @return true of interface is running
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	Boolean isRunning(String interfaceId) throws HSClientException;

	/**
	 * Remove node
	 *
	 * @param nodeNum
	 * @param interfaceId
	 * @throws HSClientException Exception encountered communicating with HomeSeer
	 */
	void removeNode(String nodeNum, String interfaceId) throws HSClientException;
}