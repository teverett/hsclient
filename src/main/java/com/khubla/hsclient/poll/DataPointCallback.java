package com.khubla.hsclient.poll;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public interface DataPointCallback {
	void beginUpdate();

	void endUpdate(long timems);

	void update(DataPoint dataPoint);
}
