package com.khubla.hsclient;

import org.junit.*;

import com.khubla.hsclient.domain.*;

/**
 * * test ignored: not every HS3 has a counter named "test"
 *
 * @author Tom Everett.
 * @copyright Copyright (C) 2020,tom@khubla.com
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
