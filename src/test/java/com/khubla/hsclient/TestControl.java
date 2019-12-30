package com.khubla.hsclient;

import java.io.*;

import org.apache.commons.io.*;
import org.junit.*;

import com.khubla.hsclient.response.*;

public class TestControl {
	@Test
	public void testControl() {
		try {
			InputStream is = TestControl.class.getResourceAsStream("/getcontrol.json");
			StringWriter writer = new StringWriter();
			IOUtils.copy(is, writer, "UTF-8");
			String json = writer.toString();
			ControlResponse controlResponse = ControlResponse.parse(json);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
