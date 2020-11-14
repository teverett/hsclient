package com.khubla.hsclient;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import org.junit.jupiter.api.*;

import com.khubla.hsclient.domain.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class TestGetCounter extends AbstractTest {
	@Test
	@Disabled
	public void testGetCounter() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			final Counter counter = hsClient.getCounter("test");
			assertNotNull(counter);
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
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
			hsClient.connect(hsConfiguration);
			final Counter counter = hsClient.getCounter("counter1");
			assertNotNull(counter);
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
