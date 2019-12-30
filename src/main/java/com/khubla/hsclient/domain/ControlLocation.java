package com.khubla.hsclient.domain;

import com.fasterxml.jackson.annotation.*;

public class ControlLocation {
	@JsonProperty("Row")
	private Integer row;
	@JsonProperty("Column")
	private Integer rolumn;
	@JsonProperty("ColumnSpan")
	private Integer columnSpan;

	public Integer getColumnSpan() {
		return columnSpan;
	}

	public Integer getRolumn() {
		return rolumn;
	}

	public Integer getRow() {
		return row;
	}

	public void setColumnSpan(Integer columnSpan) {
		this.columnSpan = columnSpan;
	}

	public void setRolumn(Integer rolumn) {
		this.rolumn = rolumn;
	}

	public void setRow(Integer row) {
		this.row = row;
	}
}
