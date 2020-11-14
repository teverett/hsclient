package com.khubla.hsclient;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class TestGetControls extends AbstractTest {
	@Test()
	@Disabled
	public void testGetControls() {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			// final Map<String, Device> devices = hsClient.getControl(ref)
			// Assert.assertNotNull(devices);
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
