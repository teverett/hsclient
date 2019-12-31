package com.khubla.hsclient;

import org.junit.*;

import com.khubla.hsclient.response.*;

/**
 * @author tom
 */
public class TestGetLocations extends AbstractTest {
	@Test
	public void testGetLocations() {
		try {
			final HSClient hsClient = HSClientImpl.connect(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final LocationsResponse locationsResponse = hsClient.getLocations();
			Assert.assertNotNull(locationsResponse);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
