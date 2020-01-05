package com.khubla.hsclient.json;

public class HSJSONClientException extends Exception {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public HSJSONClientException(Exception e) {
		super(e);
	}

	public HSJSONClientException(String errorMessage, Exception e) {
		super(errorMessage, e);
	}
}