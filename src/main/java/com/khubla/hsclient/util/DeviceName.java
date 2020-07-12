package com.khubla.hsclient.util;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class DeviceName {
	public static String getDeviceName(String n) {
		final StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < n.length(); i++) {
			if ((((n.charAt(i) >= 'a') && (n.charAt(i) <= 'z'))) || (((n.charAt(i) >= 'A') && (n.charAt(i) <= 'Z')))) {
				stringBuilder.append(n.charAt(i));
			}
		}
		return stringBuilder.toString();
	}
}
