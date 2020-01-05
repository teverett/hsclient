package com.khubla.hsclient;

import java.util.*;

import org.junit.*;

import com.khubla.hsclient.domain.*;

/**
 * @author Tom Everett.
 * @copyright Copyright (C) 2020,tom@khubla.com
 */
public class TestGetDevices extends AbstractTest {
	@Test
	@Ignore
	public void testGetByRef() {
		try {
			final HSClient hsClient = new HSClientImpl(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final Map<Integer, Device> devices = hsClient.getDevicesByRef();
			Assert.assertNotNull(devices);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void testGeyByName() {
		try {
			final HSClient hsClient = new HSClientImpl(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final Map<String, Device> devices = hsClient.getDevicesByName();
			Assert.assertNotNull(devices);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void testShowDevices() {
		try {
			final HSClient hsClient = new HSClientImpl(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final Map<Integer, Device> devices = hsClient.getDevicesByRef();
			Assert.assertNotNull(devices);
			for (final Device device : devices.values()) {
				System.out.println(device.getName() + ": " + device.getDevice_type().getDevice_Type() + " : " + device.getDevice_type().getDevice_Type_Description());
			}
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
