package com.khubla.hsclient;

import java.io.*;

import org.junit.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class TestGetVersion extends AbstractTest {
	@Test
	@Ignore
	public void testGetVersion() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			final String version = hsClient.getVersion();
			Assert.assertNotNull(version);
			Assert.assertTrue(version.compareTo("1.0") == 0);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		} finally {
			if (null != hsClient) {
				hsClient.close();
			}
		}
	}
}
