package com.khubla.hsclient.domain;

public enum UserRight {
	User_Guest(1), User_Admin(2), User_Local(4), User_Normal(8), User_Guest_Local(5), User_Admin_Local(6), User_Normal_Local(12), User_Invalid(-1);

	public static UserRight valueOfLabel(Integer value) {
		for (final UserRight e : values()) {
			if (e.value == value) {
				return e;
			}
		}
		return null;
	}

	private int value;

	private UserRight(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
};
