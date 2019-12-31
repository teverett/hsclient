package com.khubla.hsclient;

import java.io.*;

import org.apache.commons.io.*;
import org.junit.*;

import com.khubla.hsclient.response.*;

public class TestControlParse {
	@Test
	public void testControlParse() {
		try {
			InputStream is = TestControlParse.class.getResourceAsStream("/getcontrol.json");
			StringWriter writer = new StringWriter();
			IOUtils.copy(is, writer, "UTF-8");
			String json = writer.toString();
			ControlResponse controlResponse = ControlResponse.parse(json);
			Assert.assertNotNull(controlResponse);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
