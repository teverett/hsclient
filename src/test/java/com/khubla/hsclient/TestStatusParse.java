package com.khubla.hsclient;

import java.io.*;

import org.apache.commons.io.*;
import org.junit.*;

import com.khubla.hsclient.response.*;

public class TestStatusParse {
	@Test
	public void testStatusParse() {
		try {
			InputStream is = TestStatusParse.class.getResourceAsStream("/getstatus.json");
			StringWriter writer = new StringWriter();
			IOUtils.copy(is, writer, "UTF-8");
			String json = writer.toString();
			StatusResponse statusReponse = StatusResponse.parse(json);
			Assert.assertNotNull(statusReponse);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
