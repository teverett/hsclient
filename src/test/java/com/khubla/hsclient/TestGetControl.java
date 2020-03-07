package com.khubla.hsclient;

import org.junit.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class TestGetControl extends AbstractTest {
	@Test
	@Ignore
	public void testGetControl() {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(URL, USERNAME, PASSWORD);
			// final ControlResponse controlResponse = hsClient.get
			// Assert.assertNotNull(controlResponse);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
