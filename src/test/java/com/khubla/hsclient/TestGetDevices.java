package com.khubla.hsclient;

import java.util.*;

import org.junit.*;

import com.khubla.hsclient.domain.*;

public class TestGetDevices extends AbstractTest {
	@Test
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
}
