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
public enum DeviceTypePlugin {
	root(99), onoffsensor(32), usb(2), switch_(17), entrycontol(64), switch2_(16);

	public static DeviceTypePlugin valueOfLabel(Integer id) {
		for (final DeviceTypePlugin e : values()) {
			if (e.id == id) {
				return e;
			}
		}
		return null;
	}

	public final int id;

	private DeviceTypePlugin(int id) {
		this.id = id;
	}

	private DeviceTypePlugin(String id) {
		this.id = Integer.parseInt(id);
	}
}
