package com.khubla.hsclient.poll;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import org.slf4j.*;

import com.khubla.hsclient.*;

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
	private final int pollIntervalms;
	/**
	 * callback
	 */
	private final DataPointCallback dataPointCallback;
	/**
	 * threads
	 */
	private final int threads;

	public Poller(HSConfiguration hsConfiguration, int pollIntervalms, DataPointCallback dataPointCallback, int threads) {
		super();
		this.hsConfiguration = hsConfiguration;
		this.pollIntervalms = pollIntervalms;
		this.dataPointCallback = dataPointCallback;
		this.threads = threads;
	}

	public void run() throws HSClientException, InterruptedException, IOException {
		/*
		 * spin
		 */
		while (true) {
			HSClient hsClient = null;
			try {
				/*
				 * get devices which have changed since last check
				 */
				hsClient = new HSClientImpl();
				hsClient.connect(hsConfiguration);
				final List<Integer> changedDevices = hsClient.getChangedDevices();
				if ((changedDevices != null) && (changedDevices.size() > 0)) {
					try {
						dataPointCallback.beginUpdate();
						final long startTimeMS = System.currentTimeMillis();
						/*
						 * thread pool
						 */
						final ExecutorService executorService = Executors.newFixedThreadPool(threads);
						/*
						 * walk devices
						 */
						for (final Integer ref : changedDevices) {
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
						final long elapsedTimesMS = System.currentTimeMillis() - startTimeMS;
						/*
						 * done
						 */
						dataPointCallback.endUpdate(elapsedTimesMS);
						/*
						 * log
						 */
						logger.info("Data collection performed in " + Long.toString(elapsedTimesMS) + " ms on " + threads + " threads");
						/*
						 * nap time
						 */
						if (elapsedTimesMS < pollIntervalms) {
							Thread.sleep(pollIntervalms - elapsedTimesMS);
						} else {
							logger.warn("Data collection time of " + Long.toString(elapsedTimesMS) + " ms is longer than poll interval of " + pollIntervalms + " ms");
						}
					} catch (final Exception e) {
						logger.error("Error polling", e);
					}
				}
			} catch (final Exception e) {
				logger.error("Error communicating to HomeSeer", e);
			} finally {
				if (null != hsClient) {
					hsClient.close();
				}
			}
		}
	}
}
