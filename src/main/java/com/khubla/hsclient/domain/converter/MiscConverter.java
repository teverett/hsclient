package com.khubla.hsclient.domain.converter;

import com.fasterxml.jackson.databind.util.*;
import com.khubla.hsclient.domain.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class MiscConverter extends StdConverter<String, Misc> {
	@Override
	public Misc convert(String value) {
		if (null != value) {
			return new Misc(Integer.valueOf(value));
		}
		return null;
	}
}
