package com.khubla.hsclient;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.*;

import org.junit.jupiter.api.*;

import com.khubla.hsclient.domain.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class TestGetEvents extends AbstractTest {
	@Test
	@Disabled
	public void testGetEventsById() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			final Map<Integer, Event> events = hsClient.getEventsById();
			assertNotNull(events);
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
	@Disabled
	public void testGetEventsByName() throws IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			final Map<String, Map<String, Event>> events = hsClient.getEventsByGroup();
			assertNotNull(events);
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
