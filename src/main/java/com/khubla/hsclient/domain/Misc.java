package com.khubla.hsclient.domain;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class Misc {
	private static final int NO_LOG = 8;
	private static final int STATUS_ONLY = 0x10;
	private static final int HIDDEN = 0x20;
	private static final int INCLUDE_POWERFAIL = 0x80;
	private static final int SHOW_VALUES = 0x100;
	private static final int AUTO_VOICE_COMMAND = 0x200;
	private static final int VOICE_COMMAND_CONFIRM = 0x400;
	private static final int NO_STATUS_TRIGGER = 0x20000;
	private static final int CONTROL_POPUP = 0x100000;
	/**
	 * value
	 */
	private final int value;

	public Misc(int value) {
		super();
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public boolean isAutoVoiceCommand() {
		return 0 != (value & AUTO_VOICE_COMMAND);
	}

	public boolean isControlPopup() {
		return 0 != (value & CONTROL_POPUP);
	}

	public boolean isHidden() {
		return 0 != (value & HIDDEN);
	}

	public boolean isIncludePowerfail() {
		return 0 != (value & INCLUDE_POWERFAIL);
	}

	public boolean isNoLog() {
		return 0 != (value & NO_LOG);
	}

	public boolean isNoStatusTrigger() {
		return 0 != (value & NO_STATUS_TRIGGER);
	}

	public boolean isShowValues() {
		return 0 != (value & SHOW_VALUES);
	}

	public boolean isStatusOnly() {
		return 0 != (value & STATUS_ONLY);
	}

	public boolean isVoiceCommandConfirm() {
		return 0 != (value & VOICE_COMMAND_CONFIRM);
	}
}
