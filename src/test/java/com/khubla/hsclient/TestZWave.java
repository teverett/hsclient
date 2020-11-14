package com.khubla.hsclient;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.*;

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
	@Disabled
	public void testInterfaces() {
		try {
			ZWavePlugin zWavePlugin = new ZWavePluginImpl(hsConfiguration);
			List<Interface> interfaces = zWavePlugin.getInterfaces();
			assertNotNull(interfaces);
			assertTrue(interfaces.size() > 0);
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	@Disabled
	public void testNetworks() {
		try {
			ZWavePlugin zWavePlugin = new ZWavePluginImpl(hsConfiguration);
			List<Network> networks = zWavePlugin.getNetworks();
			assertNotNull(networks);
			assertTrue(networks.size() > 0);
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	@Disabled
	public void testNodes() {
		try {
			ZWavePlugin zWavePlugin = new ZWavePluginImpl(hsConfiguration);
			List<Interface> interfaces = zWavePlugin.getInterfaces();
			List<Node> nodes = zWavePlugin.getNodeInfo(interfaces.get(0).getUnique());
			assertNotNull(nodes);
			assertTrue(nodes.size() > 0);
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	@Disabled
	public void testStatus() {
		try {
			ZWavePlugin zWavePlugin = new ZWavePluginImpl(hsConfiguration);
			List<Interface> interfaces = zWavePlugin.getInterfaces();
			zWavePlugin.getStatus(interfaces.get(0).getUnique());
			List<Node> nodes = zWavePlugin.getNodeInfo(interfaces.get(0).getUnique());
			assertNotNull(nodes);
			assertTrue(nodes.size() > 0);
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	@Disabled
	public void testIsRunning() {
		try {
			ZWavePlugin zWavePlugin = new ZWavePluginImpl(hsConfiguration);
			List<Interface> interfaces = zWavePlugin.getInterfaces();
			zWavePlugin.isRunning(interfaces.get(0).getUnique());
		} catch (final Exception e) {
			e.printStackTrace();
			fail();
		}
	}
}
