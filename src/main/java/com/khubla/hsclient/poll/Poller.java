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
	private final int pollIntervalmin;
	/**
	 * callback
	 */
	private final DataPointCallback dataPointCallback;
	/**
	 * threads
	 */
	private final int threads;
	/**
	 * changes only
	 */
	private final boolean changesOnly;

	/**
	 * create a poller
	 *
	 * @param hsConfiguration HomeSeer URL and authentication info
	 * @param pollIntervalmin polling interval, minutes
	 * @param dataPointCallback callback interface
	 * @param threads number of threads to use to request changed data from HomeSeer
	 * @param changesOnly if true: only call the callback with changes. If false: call the callback
	 *        with every data point on every poll interval
	 */
	public Poller(HSConfiguration hsConfiguration, int pollIntervalmin, DataPointCallback dataPointCallback, int threads, boolean changesOnly) {
		super();
		this.hsConfiguration = hsConfiguration;
		this.pollIntervalmin = pollIntervalmin;
		this.dataPointCallback = dataPointCallback;
		this.changesOnly = changesOnly;
		this.threads = threads;
	}

	public boolean isChangesOnly() {
		return changesOnly;
	}

	public void run() throws HSClientException, InterruptedException, IOException {
		/*
		 * spin
		 */
		while (true) {
			/*
			 * collect devices to query, then close the HomeSeer connection to avoid holding it open
			 */
			HSClient hsClient = null;
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			List<Integer> deviceIDsToQuery = null;
			try {
				if (changesOnly) {
					/*
					 * get devices which have changed since last check
					 */
					deviceIDsToQuery = hsClient.getChangedDevices();
				} else {
					/*
					 * get all devices
					 */
					final Map<Integer, Device> allDevices = hsClient.getDevicesByRef();
					if (null != allDevices) {
						deviceIDsToQuery = new ArrayList<Integer>();
						deviceIDsToQuery.addAll(allDevices.keySet());
					}
				}
			} catch (final Exception e) {
				logger.error("Error communicating to HomeSeer", e);
			} finally {
				if (null != hsClient) {
					hsClient.close();
				}
			}
			/*
			 * query devices
			 */
			try {
				if ((deviceIDsToQuery != null) && (deviceIDsToQuery.size() > 0)) {
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
						for (final Integer ref : deviceIDsToQuery) {
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
						if (elapsedTimesMS < (pollIntervalmin * 1000)) {
							Thread.sleep((pollIntervalmin * 1000) - elapsedTimesMS);
						} else {
							logger.warn("Data collection time of " + Long.toString(elapsedTimesMS) + " ms is longer than poll interval of " + (pollIntervalmin * 1000) + " ms");
						}
					} catch (final Exception e) {
						logger.error("Error polling", e);
					}
				}
			} catch (final Exception e) {
				logger.error("Error communicating to HomeSeer", e);
			}
		}
	}
}
