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
public enum DeviceTypeSecurity {
	alarm(1), arming(10), keypad(20), zoneperimeter(30), zoneperimeterdelay(31), zoneinterior(32), zoneinteriordelay(33), zoneauxiliary(34), zoneother(35), zonesafetysmoke(40), zonesafetyco(
			41), zonesafetyo2(42), zonesafetyother(43), outputrelay(50), outputother(51), communicator(60), siren(70), root(99);

	public static DeviceTypeSecurity valueOfLabel(Integer id) {
		for (final DeviceTypeSecurity e : values()) {
			if (e.id == id) {
				return e;
			}
		}
		return null;
	}

	public final int id;

	private DeviceTypeSecurity(int id) {
		this.id = id;
	}

	private DeviceTypeSecurity(String id) {
		this.id = Integer.parseInt(id);
	}
}
