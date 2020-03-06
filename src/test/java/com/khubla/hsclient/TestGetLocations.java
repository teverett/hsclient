package com.khubla.hsclient;

import java.io.*;
import java.util.*;

import org.junit.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class TestGetLocations extends AbstractTest {
	@Test
	@Ignore
	public void testGetLocations() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final List<String> locationNames1 = hsClient.getLocations1();
			Assert.assertNotNull(locationNames1);
			final List<String> locationNames2 = hsClient.getLocations2();
			Assert.assertNotNull(locationNames2);
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
	public void testGetLocationsMock() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImplMock();
			hsClient.connect(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final List<String> locationNames1 = hsClient.getLocations1();
			Assert.assertNotNull(locationNames1);
			final List<String> locationNames2 = hsClient.getLocations2();
			Assert.assertNull(locationNames2);
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
