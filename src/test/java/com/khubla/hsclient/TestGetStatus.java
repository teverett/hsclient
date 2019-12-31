package com.khubla.hsclient;

import org.junit.*;

import com.khubla.hsclient.response.*;

public class TestGetStatus extends AbstractTest {
	@Test
	public void testGetStatus() {
		try {
			final HSClient hsClient = HSClientImpl.connect(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final StatusResponse statusResponse = hsClient.getStatus(null, null, null);
			Assert.assertNotNull(statusResponse);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
