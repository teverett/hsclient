package com.khubla.hsclient;

import org.junit.*;

import com.khubla.hsclient.response.*;

public class TestGetControl extends AbstractTest {
	@Test
	public void testGetControl() {
		try {
			final HSClient hsClient = HSClientImpl.connect(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final ControlResponse controlResponse = hsClient.getControl(null);
			Assert.assertNotNull(controlResponse);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
