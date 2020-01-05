package com.khubla.hsclient;

import java.util.*;

import org.junit.*;

/**
 * @author tom
 */
public class TestGetLocations extends AbstractTest {
	@Test
	@Ignore
	public void testGetLocations() {
		try {
			final HSClient hsClient = new HSClientImpl(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final List<String> locationNames1 = hsClient.getLocations1();
			Assert.assertNotNull(locationNames1);
			final List<String> locationNames2 = hsClient.getLocations2();
			Assert.assertNotNull(locationNames2);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
