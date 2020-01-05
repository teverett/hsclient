package com.khubla.hsclient;

/**
 * @author Tom Everett.
 * @copyright Copyright (C) 2020,tom@khubla.com
 */
public class HSClientException extends Exception {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public HSClientException(Exception e) {
		super(e);
	}

	public HSClientException(String errorMessage, Exception e) {
		super(errorMessage, e);
	}
}