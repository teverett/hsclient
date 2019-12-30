package com.khubla.hsclient.domain;

import com.fasterxml.jackson.annotation.*;

public class ControlLocation {
	@JsonProperty("Row")
	private String row;
	@JsonProperty("Column")
	private String rolumn;
	@JsonProperty("ColumnSpan")
	private String columnSpan;

	public String getColumnSpan() {
		return columnSpan;
	}

	public String getRolumn() {
		return rolumn;
	}

	public String getRow() {
		return row;
	}

	public void setColumnSpan(String columnSpan) {
		this.columnSpan = columnSpan;
	}

	public void setRolumn(String rolumn) {
		this.rolumn = rolumn;
	}

	public void setRow(String row) {
		this.row = row;
	}
}
