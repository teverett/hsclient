package com.khubla.hsclient;

import org.junit.*;

import com.khubla.hsclient.response.*;

/**
 * test ignored: not every HS3 has a counter named "test"
 *
 * @author tom
 */
public class TestGetCounter extends AbstractTest {
	@Test
	@Ignore
	public void testGetCounter() {
		try {
			final HSClient hsClient = HSClientImpl.connect(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final CountersResponse countersResponse = hsClient.getCounter("test");
			Assert.assertNotNull(countersResponse);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
