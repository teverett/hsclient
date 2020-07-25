package com.khubla.hsclient.domain;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class HSSystem {
	private String license;
	private String friendly_name;
	private String hslocalip;
	private String hswanip;
	private String detected_wan_ip;
	private String tunnelip;
	private Boolean online;

	public String getDetected_wan_ip() {
		return detected_wan_ip;
	}

	public String getFriendly_name() {
		return friendly_name;
	}

	public String getHslocalip() {
		return hslocalip;
	}

	public String getHswanip() {
		return hswanip;
	}

	public String getLicense() {
		return license;
	}

	public Boolean getOnline() {
		return online;
	}

	public String getTunnelip() {
		return tunnelip;
	}

	public void setDetected_wan_ip(String detected_wan_ip) {
		this.detected_wan_ip = detected_wan_ip;
	}

	public void setFriendly_name(String friendly_name) {
		this.friendly_name = friendly_name;
	}

	public void setHslocalip(String hslocalip) {
		this.hslocalip = hslocalip;
	}

	public void setHswanip(String hswanip) {
		this.hswanip = hswanip;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public void setOnline(Boolean online) {
		this.online = online;
	}

	public void setTunnelip(String tunnelip) {
		this.tunnelip = tunnelip;
	}
}
