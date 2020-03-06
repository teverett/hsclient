package com.khubla.hsclient;

import java.io.*;

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
	public void testGetCounter() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final Counter counter = hsClient.getCounter("test");
			Assert.assertNotNull(counter);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		} finally {
			if (null != hsClient) {
				hsClient.close();
			}
		}
	}

	@Test
	public void testGetCounterMock() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImplMock();
			hsClient.connect(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final Counter counter = hsClient.getCounter("counter1");
			Assert.assertNotNull(counter);
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
