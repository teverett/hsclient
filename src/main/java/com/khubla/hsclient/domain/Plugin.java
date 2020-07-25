package com.khubla.hsclient.domain;

import com.fasterxml.jackson.annotation.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class Plugin {
	@JsonProperty("Name")
	private String name;
	@JsonProperty("Version")
	private String version;
	@JsonProperty("VersionAvailable")
	private String versionAvailable;
	@JsonProperty("UpdateAvailable")
	private Boolean updateAvailable;

	public String getName() {
		return name;
	}

	public Boolean getUpdateAvailable() {
		return updateAvailable;
	}

	public String getVersion() {
		return version;
	}

	public String getVersionAvailable() {
		return versionAvailable;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUpdateAvailable(Boolean updateAvailable) {
		this.updateAvailable = updateAvailable;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setVersionAvailable(String versionAvailable) {
		this.versionAvailable = versionAvailable;
	}
}
