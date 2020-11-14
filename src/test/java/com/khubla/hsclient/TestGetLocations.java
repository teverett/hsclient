package com.khubla.hsclient;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class TestGetLocations extends AbstractTest {
	@Test
	@Disabled
	public void testGetLocations() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			final List<String> locationNames1 = hsClient.getLocations1();
			assertNotNull(locationNames1);
			final List<String> locationNames2 = hsClient.getLocations2();
			assertNotNull(locationNames2);
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
	public void testGetLocationsMock() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImplMock();
			hsClient.connect(hsConfiguration);
			assertNotNull(hsClient);
			final List<String> locationNames1 = hsClient.getLocations1();
			assertNotNull(locationNames1);
			final List<String> locationNames2 = hsClient.getLocations2();
			assertNull(locationNames2);
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
