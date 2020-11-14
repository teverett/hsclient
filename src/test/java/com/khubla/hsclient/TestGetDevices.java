package com.khubla.hsclient;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.*;

import com.khubla.hsclient.domain.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class TestGetDevices extends AbstractTest {
	@Test
	public void testGetByName() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			final Map<String, Device> devices = hsClient.getDevicesByName();
			assertNotNull(devices);
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		} finally {
			if (null != hsClient) {
				hsClient.close();
			}
		}
	}

	@Test
	@Disabled
	public void testGetByRef() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			final Map<Integer, Device> devices = hsClient.getDevicesByRef();
			assertNotNull(devices);
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		} finally {
			if (null != hsClient) {
				hsClient.close();
			}
		}
	}

	@Test
	public void testGetByRefMock() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImplMock();
			hsClient.connect(hsConfiguration);
			final Map<Integer, Device> devices = hsClient.getDevicesByRef();
			assertNotNull(devices);
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		} finally {
			if (null != hsClient) {
				hsClient.close();
			}
		}
	}

	@Test
	@Disabled
	public void testShowDevices() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			final Map<Integer, Device> devices = hsClient.getDevicesByRef();
			assertNotNull(devices);
			for (final Device device : devices.values()) {
				System.out.println(device.getName() + ": " + device.getDevice_type().getDevice_Type() + " : " + device.getDevice_type().getDevice_Type_Description());
			}
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		} finally {
			if (null != hsClient) {
				hsClient.close();
			}
		}
	}
}
