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
public enum DeviceTypeMedia {
	status(1), statusAdditional(2), control(3), volume(4), shuffle(5), repeat(6), genre(7), album(8), artist(9), track(10), playlist(11), type(12), selector(20), root(99);

	public static DeviceTypeMedia valueOfLabel(Integer id) {
		for (final DeviceTypeMedia e : values()) {
			if (e.id == id) {
				return e;
			}
		}
		return null;
	}

	public final int id;

	private DeviceTypeMedia(int id) {
		this.id = id;
	}

	private DeviceTypeMedia(String id) {
		this.id = Integer.parseInt(id);
	}
}
