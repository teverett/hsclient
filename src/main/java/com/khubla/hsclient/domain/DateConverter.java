package com.khubla.hsclient.domain;

import java.time.*;
import java.util.*;

import com.fasterxml.jackson.databind.util.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class DateConverter extends StdConverter<String, Date> {
	@Override
	public Date convert(String value) {
		if (null != value) {
			final String dateString = value.substring(value.indexOf("(") + 1, value.indexOf(")"));
			if (false == dateString.startsWith("-")) {
				final String time = dateString.substring(0, dateString.indexOf("-"));
				final Instant instant = Instant.ofEpochMilli(Long.parseLong(time));
				return Date.from(instant);
			}
		}
		return null;
	}
}
