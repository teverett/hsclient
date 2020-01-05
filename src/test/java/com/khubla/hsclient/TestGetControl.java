package com.khubla.hsclient;

import org.junit.*;

/**
 * @author Tom Everett.
 * @copyright Copyright (C) 2020,tom@khubla.com
 */
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
