package com.khubla.hsclient;

import java.util.*;

import org.junit.*;

import com.khubla.hsclient.plugins.zwave.*;
import com.khubla.hsclient.plugins.zwave.domain.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class TestZWave extends AbstractTest {
	@Test
	@Ignore
	public void testInterfaces() {
		try {
			ZWavePlugin zWavePlugin = new ZWavePlugin(hsConfiguration);
			List<Interface> interfaces = zWavePlugin.getInterfaces();
			Assert.assertNotNull(interfaces);
			Assert.assertTrue(interfaces.size() > 0);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void testNetworks() {
		try {
			ZWavePlugin zWavePlugin = new ZWavePlugin(hsConfiguration);
			List<Network> networks = zWavePlugin.getNetworks();
			Assert.assertNotNull(networks);
			Assert.assertTrue(networks.size() > 0);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void testNodes() {
		try {
			ZWavePlugin zWavePlugin = new ZWavePlugin(hsConfiguration);
			List<Interface> interfaces = zWavePlugin.getInterfaces();
			List<Node> nodes = zWavePlugin.getNodeInfo(interfaces.get(0).getUnique());
			Assert.assertNotNull(nodes);
			Assert.assertTrue(nodes.size() > 0);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void testStatus() {
		try {
			ZWavePlugin zWavePlugin = new ZWavePlugin(hsConfiguration);
			List<Interface> interfaces = zWavePlugin.getInterfaces();
			zWavePlugin.getStatus(interfaces.get(0).getUnique());
			List<Node> nodes = zWavePlugin.getNodeInfo(interfaces.get(0).getUnique());
			Assert.assertNotNull(nodes);
			Assert.assertTrue(nodes.size() > 0);
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Test
	@Ignore
	public void testIsRunning() {
		try {
			ZWavePlugin zWavePlugin = new ZWavePlugin(hsConfiguration);
			List<Interface> interfaces = zWavePlugin.getInterfaces();
			zWavePlugin.isRunning(interfaces.get(0).getUnique());
		} catch (final Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
