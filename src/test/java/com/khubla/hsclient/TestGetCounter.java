package com.khubla.hsclient;

import org.junit.*;

import com.khubla.hsclient.domain.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class TestGetCounter extends AbstractTest {
	@Test
	@Ignore
	public void testGetCounter() {
		try {
			final HSClient hsClient = new HSClientImpl(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final Counter counter = hsClient.getCounter("test");
			Assert.assertNotNull(counter);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
