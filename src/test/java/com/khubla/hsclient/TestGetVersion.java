package com.khubla.hsclient;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class TestGetVersion extends AbstractTest {
	@Test
	@Disabled
	public void testGetVersion() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			final String version = hsClient.getVersion();
			assertNotNull(version);
			assertTrue(version.compareTo("1.0") == 0);
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		} finally {
			if (null != hsClient) {
				hsClient.close();
			}
		}
	}
}
