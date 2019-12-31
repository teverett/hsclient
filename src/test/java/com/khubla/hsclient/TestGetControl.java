package com.khubla.hsclient;

import org.junit.*;

import com.khubla.hsclient.response.*;

public class TestGetControl extends AbstractTest {
	@Test
	public void testGetStatus() {
		try {
			HSClient hsClient = HSClientImpl.connect(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			ControlResponse controlResponse = hsClient.getControl(null);
			Assert.assertNotNull(controlResponse);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
