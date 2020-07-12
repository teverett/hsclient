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
public enum DeviceTypeGeneric {
	generic(999);

	public static DeviceTypeGeneric valueOfLabel(Integer id) {
		for (final DeviceTypeGeneric e : values()) {
			if (e.id == id) {
				return e;
			}
		}
		return null;
	}

	public final int id;

	private DeviceTypeGeneric(int id) {
		this.id = id;
	}

	private DeviceTypeGeneric(String id) {
		this.id = Integer.parseInt(id);
	}
}
