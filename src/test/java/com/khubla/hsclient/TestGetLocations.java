package com.khubla.hsclient;

import java.util.*;

import org.junit.*;

/**
 * @author tom
 */
public class TestGetLocations extends AbstractTest {
	@Test
	public void testGetLocations() {
		try {
			final HSClient hsClient = new HSClientImpl(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final List<String> locationNames = hsClient.getLocations();
			Assert.assertNotNull(locationNames);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
