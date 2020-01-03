package com.khubla.hsclient.util;

import java.util.*;

import com.khubla.hsclient.*;
import com.khubla.hsclient.domain.*;

public class DeviceUtil {
	private final HSClient hsClient;
	private Map<String, Device> deviceMapByName;
	private Map<Integer, Device> deviceMapByRef;

	public DeviceUtil(HSClient hsClient) throws HSClientException {
		this.hsClient = hsClient;
		refresh();
	}

	/**
	 * get all devices of type deviceType
	 *
	 * @param deviceType
	 * @return
	 * @throws HSClientException
	 */
	public List<Device> getDevices(String deviceType) throws HSClientException {
		final List<Device> ret = new ArrayList<Device>();
		for (final Device device : deviceMapByRef.values()) {
			if (deviceType.compareTo(device.getDevice_type_string()) == 0) {
				ret.add(device);
			}
		}
		return ret;
	}

	public void refresh() throws HSClientException {
		deviceMapByName = hsClient.getDevicesByName();
		deviceMapByRef = hsClient.getDevicesByRef();
	}
}
