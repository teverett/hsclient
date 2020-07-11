package com.khubla.hsclient.poll;

import java.io.*;

import org.slf4j.*;

import com.khubla.hsclient.*;
import com.khubla.hsclient.domain.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class PollerWorker implements Runnable {
	/**
	 * logger
	 */
	private static Logger logger = LoggerFactory.getLogger(PollerWorker.class);
	/**
	 * device ref
	 */
	private final Integer deviceRef;
	/**
	 * HSConfiguration
	 */
	private final HSConfiguration hsConfiguration;
	/**
	 * callback
	 */
	private final DataPointCallback dataPointCallback;

	public PollerWorker(Integer deviceRef, HSConfiguration hsConfiguration, DataPointCallback dataPointCallback) {
		super();
		this.deviceRef = deviceRef;
		this.hsConfiguration = hsConfiguration;
		this.dataPointCallback = dataPointCallback;
	}

	@Override
	public void run() {
		try {
			final Device device = updateDevice(deviceRef);
			if (null != device) {
				final Double value = device.getValue();
				final long lastChange = device.getLast_change() == null ? 0 : device.getLast_change().getTime();
				final DataPoint dataPoint = new DataPoint(deviceRef, value, lastChange, device.getLocation(), device.getLocation2(), device.getName(), device.getStatus(), device.getDevice_type_string());
				dataPointCallback.update(dataPoint);
			}
		} catch (final Exception e) {
			logger.error("Error collecting data for device " + deviceRef, e);
		}
	}

	private Device updateDevice(Integer ref) throws HSClientException, IOException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			return hsClient.getDevice(ref);
		} catch (final Exception e) {
			logger.error("Error updating device " + ref, e);
			return null;
		} finally {
			hsClient.close();
		}
	}
}
