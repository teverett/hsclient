package com.khubla.hsclient.util;

import java.util.*;

import com.khubla.hsclient.*;
import com.khubla.hsclient.domain.*;
import com.khubla.hsclient.json.*;

public class DeviceUtil {
	private final HSClient hsClient;
	private Map<String, Device> deviceMapByName;
	private Map<Integer, Device> deviceMapByRef;

	public DeviceUtil(HSClient hsClient) throws HSJSONClientException {
		this.hsClient = hsClient;
		refresh();
	}

	public Map<String, Device> getDeviceMapByName() {
		return deviceMapByName;
	}

	public Map<Integer, Device> getDeviceMapByRef() {
		return deviceMapByRef;
	}

	/**
	 * get all devices of type deviceType
	 *
	 * @param deviceType
	 * @return list of devices
	 * @throws HSJSONClientException
	 */
	public List<Device> getDevices(String deviceType) throws HSJSONClientException {
		final List<Device> ret = new ArrayList<Device>();
		for (final Device device : deviceMapByRef.values()) {
			if (deviceType.compareTo(device.getDevice_type_string()) == 0) {
				ret.add(device);
			}
		}
		return ret;
	}

	/**
	 * refresh all device status from HomeSeer Server
	 *
	 * @throws HSJSONClientException
	 */
	public void refresh() throws HSJSONClientException {
		deviceMapByName = hsClient.getDevicesByName();
		deviceMapByRef = hsClient.getDevicesByRef();
	}
}
