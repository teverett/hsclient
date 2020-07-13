package com.khubla.hsclient.domain;

import com.fasterxml.jackson.databind.util.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class RelationshipStatusConverter extends StdConverter<String, RelationshipStatus> {
	@Override
	public RelationshipStatus convert(String value) {
		if (null != value) {
			return RelationshipStatus.valueOfLabel(Integer.valueOf(value));
		}
		return null;
	}
}
