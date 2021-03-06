package com.khubla.hsclient.domain;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.*;
import com.khubla.hsclient.*;
import com.khubla.hsclient.domain.converter.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class UserPermissions {
	public static UserPermissions parse(String json) throws HSClientException {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, UserPermissions.class);
		} catch (final Exception e) {
			throw new HSClientException(e);
		}
	}

	@JsonDeserialize(converter = UserRightConverter.class)
	private UserRight user_permissions;
	private Boolean user_permissions_valid;
	private Boolean eventAccess;
	private Boolean cameraAdd;

	public Boolean getCameraAdd() {
		return cameraAdd;
	}

	public Boolean getEventAccess() {
		return eventAccess;
	}

	public UserRight getUser_permissions() {
		return user_permissions;
	}

	public Boolean getUser_permissions_valid() {
		return user_permissions_valid;
	}

	public void setCameraAdd(Boolean cameraAdd) {
		this.cameraAdd = cameraAdd;
	}

	public void setEventAccess(Boolean eventAccess) {
		this.eventAccess = eventAccess;
	}

	public void setUser_permissions(UserRight user_permissions) {
		this.user_permissions = user_permissions;
	}

	public void setUser_permissions_valid(Boolean user_permissions_valid) {
		this.user_permissions_valid = user_permissions_valid;
	}
}
