package com.khubla.hsclient;

import org.junit.*;

import com.khubla.hsclient.response.*;

public class TestGetStatus extends AbstractTest {
	@Test
	public void testGetStatus() {
		try {
			HSClient hsClient = HSClientImpl.connect(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			StatusResponse statusResponse = hsClient.getStatus(null, null, null);
			Assert.assertNotNull(statusResponse);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
