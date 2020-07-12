/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2020
 */
package com.khubla.hsclient.domain;

/**
 * http://help.homeseer.com/help/HS3/static/#.device_type
 *
 * @author tom
 */
public enum APIType {
	none(0), plugin(4), thermostat(16), media(32), security(8), sourceswitch(64), script(128);

	public static APIType valueOfLabel(Integer id) {
		for (final APIType e : values()) {
			if (e.id == id) {
				return e;
			}
		}
		return null;
	}

	public final int id;

	private APIType(int id) {
		this.id = id;
	}

	private APIType(String id) {
		this.id = Integer.parseInt(id);
	}
}
