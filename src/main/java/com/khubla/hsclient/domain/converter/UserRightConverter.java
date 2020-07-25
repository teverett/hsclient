package com.khubla.hsclient.domain.converter;

import com.fasterxml.jackson.databind.util.*;
import com.khubla.hsclient.domain.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class UserRightConverter extends StdConverter<String, UserRight> {
	@Override
	public UserRight convert(String value) {
		if (null != value) {
			return UserRight.valueOfLabel(Integer.valueOf(value));
		}
		return null;
	}
}
