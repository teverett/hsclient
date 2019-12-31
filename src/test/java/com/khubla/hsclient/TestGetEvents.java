package com.khubla.hsclient;

import org.junit.*;

import com.khubla.hsclient.response.*;

/**
 * @author tom
 */
public class TestGetEvents extends AbstractTest {
	@Test
	public void testGetLocations() {
		try {
			final HSClient hsClient = HSClientImpl.connect(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final EventsResponse eventsResponse = hsClient.getEvents();
			Assert.assertNotNull(eventsResponse);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
