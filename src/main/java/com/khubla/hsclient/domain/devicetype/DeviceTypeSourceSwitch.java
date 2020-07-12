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
public enum DeviceTypeSourceSwitch {
	invalid(0), system(1), source(10), sourceextended(15), zone(20), zoneexended(25), root(99);

	public static DeviceTypeSourceSwitch valueOfLabel(Integer id) {
		for (final DeviceTypeSourceSwitch e : values()) {
			if (e.id == id) {
				return e;
			}
		}
		return null;
	}

	public final int id;

	private DeviceTypeSourceSwitch(int id) {
		this.id = id;
	}

	private DeviceTypeSourceSwitch(String id) {
		this.id = Integer.parseInt(id);
	}
}
