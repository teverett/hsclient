package com.khubla.hsclient;

import org.junit.*;

public class TestConnect {
	private static final String URL = "https://connected.homeseer.com/JSON";
	private static final String USERNAME = "demo@homeseer.com";
	private static final String PASSWORD = "demo100";

	@Test
	@Ignore
	public void testConnect() {
		try {
			HSClient hsClient = HSClient.connect(URL, USERNAME, PASSWORD);
			Assert.assertNotNull(hsClient);
			hsClient.getStatus();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
