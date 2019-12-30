package com.khubla.hsclient;

import java.io.*;

import org.apache.commons.io.*;
import org.junit.*;

import com.khubla.hsclient.response.*;

public class TestStatus {
	@Test
	public void testStatus() {
		try {
			InputStream is = TestStatus.class.getResourceAsStream("/getstatus.json");
			StringWriter writer = new StringWriter();
			IOUtils.copy(is, writer, "UTF-8");
			String json = writer.toString();
			StatusResponse statusReponse = StatusResponse.parse(json);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
