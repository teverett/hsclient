package com.khubla.hsclient;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class HSConfiguration {
	/**
	 * URL
	 */
	private final String hsURL;
	/**
	 * Username
	 */
	private final String hsUsername;
	/**
	 * Password
	 */
	private final String hsPassword;

	public HSConfiguration(String hsURL, String hsUsername, String hsPassword) {
		super();
		this.hsURL = hsURL;
		this.hsUsername = hsUsername;
		this.hsPassword = hsPassword;
	}

	public String getHsPassword() {
		return hsPassword;
	}

	public String getHsURL() {
		return hsURL;
	}

	public String getHsUsername() {
		return hsUsername;
	}
}
