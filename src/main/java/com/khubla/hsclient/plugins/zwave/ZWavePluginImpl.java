package com.khubla.hsclient.plugins.zwave;

import java.util.*;

import org.slf4j.*;

import com.khubla.hsclient.*;
import com.khubla.hsclient.plugins.zwave.domain.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class ZWavePluginImpl implements ZWavePlugin {
	/**
	 * logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(ZWavePluginImpl.class);
	/**
	 * plugin name
	 */
	private static final String PLUGINNAME = "Z-Wave";
	/**
	 * ZwaveFunction
	 */
	private static final String ZWAVEFUNCTION = "ZwaveFunction";
	/**
	 * HSConfiguration
	 */
	private final HSConfiguration hsConfiguration;

	public ZWavePluginImpl(HSConfiguration hsConfiguration) {
		this.hsConfiguration = hsConfiguration;
	}

	@Override
	public List<Interface> getInterfaces() throws HSClientException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			final InterfacesResponse interfacesResponse = InterfacesResponse.parse(hsClient.pluginfunction(ZWAVEFUNCTION, PLUGINNAME, null, makeParameters("interfaces", null)));
			return interfacesResponse.getList();
		} catch (final Exception e) {
			throw new HSClientException(e);
		} finally {
			try {
				if (null != hsClient) {
					hsClient.close();
				}
			} catch (final Exception e) {
				logger.error("Exception closing hsClient", e);
			}
		}
	}

	/**
	 * get zwave networks
	 *
	 * @return networks list of networks
	 * @throws HSClientException exception
	 */
	@Override
	public List<Network> getNetworks() throws HSClientException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			final NetworksResponse networksResponse = NetworksResponse.parse(hsClient.pluginfunction(ZWAVEFUNCTION, PLUGINNAME, null, makeParameters("networks", null)));
			return networksResponse.getList();
		} catch (final Exception e) {
			throw new HSClientException(e);
		} finally {
			try {
				if (null != hsClient) {
					hsClient.close();
				}
			} catch (final Exception e) {
				logger.error("Exception closing hsClient", e);
			}
		}
	}

	@Override
	public List<Node> getNodeInfo(String interfaceId) throws HSClientException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			final NodeInfoResponse nodeInfoResponse = NodeInfoResponse.parse(hsClient.pluginfunction(ZWAVEFUNCTION, PLUGINNAME, null, makeParameters("nodeinfo", interfaceId)));
			return nodeInfoResponse.getNodes();
		} catch (final Exception e) {
			throw new HSClientException(e);
		} finally {
			try {
				if (null != hsClient) {
					hsClient.close();
				}
			} catch (final Exception e) {
				logger.error("Exception closing hsClient", e);
			}
		}
	}

	@Override
	public String getStatus(String interfaceId) throws HSClientException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			final StatusResponse statusResponse = StatusResponse.parse(hsClient.pluginfunction(ZWAVEFUNCTION, PLUGINNAME, null, makeParameters("status", interfaceId)));
			return statusResponse.getResponse();
		} catch (final Exception e) {
			throw new HSClientException(e);
		} finally {
			try {
				if (null != hsClient) {
					hsClient.close();
				}
			} catch (final Exception e) {
				logger.error("Exception closing hsClient", e);
			}
		}
	}

	@Override
	public Boolean isRunning(String interfaceId) throws HSClientException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			final IsRunningResponse isRunningResponse = IsRunningResponse.parse(hsClient.pluginfunction(ZWAVEFUNCTION, PLUGINNAME, null, makeParameters("isrunning", interfaceId)));
			return isRunningResponse.isResponse();
		} catch (final Exception e) {
			throw new HSClientException(e);
		} finally {
			try {
				if (null != hsClient) {
					hsClient.close();
				}
			} catch (final Exception e) {
				logger.error("Exception closing hsClient", e);
			}
		}
	}

	/**
	 * Make parameter list
	 *
	 * @param p1 first param
	 * @param p2 second param. must always be passed, even as "null"
	 * @return a map
	 */
	private Map<String, String> makeParameters(String p1, String p2) {
		final Map<String, String> ret = new HashMap<String, String>();
		if (null != p1) {
			ret.put("p1", p1);
		} else {
			ret.put("p1", "null");
		}
		if (null != p2) {
			ret.put("p2", p2);
		} else {
			ret.put("p2", "null");
		}
		return ret;
	}

	@Override
	public void removeNode(String nodeNum, String interfaceId) throws HSClientException {
		HSClient hsClient = null;
		try {
			hsClient = new HSClientImpl();
			hsClient.connect(hsConfiguration);
			hsClient.pluginfunction("ZwaveFunctionRemoveNode", PLUGINNAME, null, null);
		} catch (final Exception e) {
			throw new HSClientException(e);
		} finally {
			try {
				if (null != hsClient) {
					hsClient.close();
				}
			} catch (final Exception e) {
				logger.error("Exception closing hsClient", e);
			}
		}
	}
}
