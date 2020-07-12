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
public enum DeviceTypeThermostat {
	operatingstate(1), temperature(2), modeset(3), fanmodeset(4), fanstatus(5), setpoint(6), runtime(7), holdmode(8), operatingmode(9), additionaltemperature(10), setback(11), filterremind(12), root(
			99);

	public static DeviceTypeThermostat valueOfLabel(Integer id) {
		for (final DeviceTypeThermostat e : values()) {
			if (e.id == id) {
				return e;
			}
		}
		return null;
	}

	public final int id;

	private DeviceTypeThermostat(int id) {
		this.id = id;
	}

	private DeviceTypeThermostat(String id) {
		this.id = Integer.parseInt(id);
	}
}
