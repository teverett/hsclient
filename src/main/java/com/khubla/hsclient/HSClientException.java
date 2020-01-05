package com.khubla.hsclient;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
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