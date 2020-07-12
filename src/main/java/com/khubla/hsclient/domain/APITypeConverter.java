package com.khubla.hsclient.domain;

import com.fasterxml.jackson.databind.util.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class APITypeConverter extends StdConverter<String, APIType> {
	@Override
	public APIType convert(String value) {
		if (null != value) {
			return APIType.valueOfLabel(Integer.valueOf(value));
		}
		return null;
	}
}
