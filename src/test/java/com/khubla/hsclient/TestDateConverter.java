package com.khubla.hsclient;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

import com.khubla.hsclient.domain.converter.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class TestDateConverter {
	@Test
	public void testDate1() {
		try {
			String dateString = "/Date(1595133858051-0600)/";
			DateConverter dateConverter = new DateConverter();
			Date date = dateConverter.convert(dateString);
			assertNotNull(date);
			assertNotNull(date.getYear() == 2020);
			assertNotNull(date.getMonth() == 7);
			assertNotNull(date.getDay() == 25);
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testDate2() {
		try {
			String dateString = "/Date(1595635070772)/";
			DateConverter dateConverter = new DateConverter();
			Date date = dateConverter.convert(dateString);
			assertNotNull(date);
			assertNotNull(date.getYear() == 2020);
			assertNotNull(date.getMonth() == 7);
			assertNotNull(date.getDay() == 25);
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
