package com.khubla.hsclient;

import org.junit.*;

public class TestGetControl extends AbstractTest {
	@Test
	@Ignore
	public void testGetControl() {
		try {
			final HSClient hsClient = new HSClientImpl(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			// final ControlResponse controlResponse = hsClient.get
			// Assert.assertNotNull(controlResponse);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
