package com.khubla.hsclient.poll;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import org.slf4j.*;

import com.khubla.hsclient.*;
import com.khubla.hsclient.domain.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class Poller {
	/**
	 * logger
	 */
	private static Logger logger = LoggerFactory.getLogger(Poller.class);
	/**
	 * HSConfiguration
	 */
	private final HSConfiguration hsConfiguration;
	/**
	 * poll interval (minutes)
	 */
	private final int pollInterval;
	/**
	 * callback
	 */
	private final DataPointCallback dataPointCallback;
	/**
	 * threads
	 */
	private final int threads;

	public Poller(HSConfiguration hsConfiguration, int pollInterval, DataPointCallback dataPointCallback, int threads) {
		super();
		this.hsConfiguration = hsConfiguration;
		this.pollInterval = pollInterval;
		this.dataPointCallback = dataPointCallback;
		this.threads = threads;
	}

	public void run() throws HSClientException, InterruptedException, IOException {
		Map<Integer, Device> devices = null;
		HSClient hsClient = null;
		try {
			/*
			 * get devices
			 */
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			devices = hsClient.getDevicesByRef();
		} catch (final Exception e) {
			logger.error("Error getting devices from HomeSeer", e);
		} finally {
			if (null != hsClient) {
				hsClient.close();
			}
		}
		/*
		 * spin
		 */
		if (devices != null) {
			while (true) {
				try {
					dataPointCallback.beginUpdate();
					final long start = System.currentTimeMillis();
					/*
					 * thread pool
					 */
					final ExecutorService executorService = Executors.newFixedThreadPool(threads);
					/*
					 * walk devices
					 */
					for (final Integer ref : devices.keySet()) {
						/*
						 * runnable
						 */
						final Runnable worker = new PollerWorker(ref, hsConfiguration, dataPointCallback);
						/*
						 * add to service
						 */
						executorService.execute(worker);
					}
					/*
					 * wait
					 */
					executorService.shutdown();
					executorService.awaitTermination(60, TimeUnit.SECONDS);
					/*
					 * log the time
					 */
					final long t = System.currentTimeMillis() - start;
					/*
					 * done
					 */
					dataPointCallback.endUpdate(t);
					/*
					 * log
					 */
					logger.info("Data collection performed in " + Long.toString(t) + " ms on " + threads + " threads");
					/*
					 * nap time
					 */
					Thread.sleep((pollInterval * 60 * 1000) - t);
				} catch (final Exception e) {
					logger.error("Error polling", e);
				}
			}
		}
	}
}
