package com.khubla.hsclient;

import java.io.*;
import java.util.*;

import org.junit.*;

import com.khubla.hsclient.domain.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class TestGetEvents extends AbstractTest {
	@Test
	@Ignore
	public void testGetEventsById() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			final Map<Integer, Event> events = hsClient.getEventsById();
			Assert.assertNotNull(events);
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
	@Ignore
	public void testGetEventsByName() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			Assert.assertNotNull(hsClient);
			final Map<String, Event> events = hsClient.getEventsByName();
			Assert.assertNotNull(events);
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
