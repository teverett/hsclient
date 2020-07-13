/*
 * Copyright (C) khubla.com - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Tom Everett <tom@khubla.com>, 2020
 */
package com.khubla.hsclient.domain;

/**
 * http://help.homeseer.com/help/HS3/static/#.scripting_devices_deviceclass1
 *
 * @author tom
 */
public enum RelationshipStatus {
	notset(0), indeterminate(1), parentroot(2), standalone(3), child(4);

	public static RelationshipStatus valueOfLabel(Integer id) {
		for (final RelationshipStatus e : values()) {
			if (e.id == id) {
				return e;
			}
		}
		return null;
	}

	public final int id;

	private RelationshipStatus(int id) {
		this.id = id;
	}

	private RelationshipStatus(String id) {
		this.id = Integer.parseInt(id);
	}
}
