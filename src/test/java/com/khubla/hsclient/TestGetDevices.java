package com.khubla.hsclient;

import java.io.*;
import java.util.*;

import org.junit.*;

import com.khubla.hsclient.domain.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class TestGetDevices extends AbstractTest {
	@Test
	@Ignore
	public void testGetByRef() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final Map<Integer, Device> devices = hsClient.getDevicesByRef();
			Assert.assertNotNull(devices);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		} finally {
			if (null != hsClient) {
				hsClient.close();
			}
		}
	}

	@Test
	@Ignore
	public void testGeyByName() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			Assert.assertNotNull(hsClient);
			final Map<String, Device> devices = hsClient.getDevicesByName();
			Assert.assertNotNull(devices);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		} finally {
			if (null != hsClient) {
				hsClient.close();
			}
		}
	}

	@Test
	@Ignore
	public void testShowDevices() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			Assert.assertNotNull(hsClient);
			final Map<Integer, Device> devices = hsClient.getDevicesByRef();
			Assert.assertNotNull(devices);
			for (final Device device : devices.values()) {
				System.out.println(device.getName() + ": " + device.getDevice_type().getDevice_Type() + " : " + device.getDevice_type().getDevice_Type_Description());
			}
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		} finally {
			if (null != hsClient) {
				hsClient.close();
			}
		}
	}
}
