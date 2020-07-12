/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2020
 */
package com.khubla.hsclient.domain.devicetype;

/**
 * @author tom
 */
public enum DeviceTypeScript {
	disabled(0), anychange(1), valuechange(2), stringchange(3);

	public static DeviceTypeScript valueOfLabel(Integer id) {
		for (final DeviceTypeScript e : values()) {
			if (e.id == id) {
				return e;
			}
		}
		return null;
	}

	public final int id;

	private DeviceTypeScript(int id) {
		this.id = id;
	}

	private DeviceTypeScript(String id) {
		this.id = Integer.parseInt(id);
	}
}
