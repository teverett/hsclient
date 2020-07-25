package com.khubla.hsclient.plugins.zwave.converter;

import java.util.*;

import com.fasterxml.jackson.databind.util.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class IntegerListConverter extends StdConverter<String, List<Integer>> {
	@Override
	public List<Integer> convert(String value) {
		if (null != value) {
			final List<Integer> ret = new ArrayList<Integer>();
			final String[] parts = value.split(",");
			for (final String part : parts) {
				final String n = part.trim();
				if ((null != n) && (n.length() > 0)) {
					ret.add(Integer.parseInt(n));
				}
			}
			return ret;
		}
		return null;
	}
}
