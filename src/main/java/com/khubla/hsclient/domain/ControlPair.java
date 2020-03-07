package com.khubla.hsclient.domain;

import com.fasterxml.jackson.annotation.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2020,tom@khubla.com
 *         </p>
 */
public class ControlPair {
	@JsonProperty("Do_Update")
	private Boolean do_Update;
	@JsonProperty("SingleRangeEntry")
	private String singleRangeEntry;
	@JsonProperty("ControlButtonType")
	private Integer controlButtonType;
	@JsonProperty("ControlButtonCustom")
	private String controlButtonCustom;
	@JsonProperty("CCIndex")
	private Integer cCIndex;
	@JsonProperty("Ref")
	private String ref;
	@JsonProperty("Label")
	private String label;
	@JsonProperty("ControlType")
	private Integer controlType;
	@JsonProperty("ControlLoc_Row")
	private Integer controlLoc_Row;
	@JsonProperty("ControlLoc_Column")
	private Integer controlLoc_Column;
	@JsonProperty("ControlLoc_ColumnSpan")
	private Integer controlLoc_ColumnSpan;
	@JsonProperty("ControlUse")
	private Integer controlUse;
	@JsonProperty("ControlValue")
	private Integer controlValue;
	@JsonProperty("ControlString")
	private String controlString;
	@JsonProperty("ControlStringList")
	private String controlStringList;
	@JsonProperty("ControlStringSelected")
	private String controlStringSelected;
	@JsonProperty("ControlFlag")
	private Boolean controlFlag;
	@JsonProperty("ControlLocation")
	private ControlLocation controlLocation;
	@JsonProperty("Range")
	private Range range;

	public Integer getcCIndex() {
		return cCIndex;
	}

	public String getControlButtonCustom() {
		return controlButtonCustom;
	}

	public Integer getControlButtonType() {
		return controlButtonType;
	}

	public Boolean getControlFlag() {
		return controlFlag;
	}

	public Integer getControlLoc_Column() {
		return controlLoc_Column;
	}

	public Integer getControlLoc_ColumnSpan() {
		return controlLoc_ColumnSpan;
	}

	public Integer getControlLoc_Row() {
		return controlLoc_Row;
	}

	public ControlLocation getControlLocation() {
		return controlLocation;
	}

	public String getControlString() {
		return controlString;
	}

	public String getControlStringList() {
		return controlStringList;
	}

	public String getControlStringSelected() {
		return controlStringSelected;
	}

	public Integer getControlType() {
		return controlType;
	}

	public Integer getControlUse() {
		return controlUse;
	}

	public Integer getControlValue() {
		return controlValue;
	}

	public Boolean getDo_Update() {
		return do_Update;
	}

	public String getLabel() {
		return label;
	}

	public Range getRange() {
		return range;
	}

	public String getRef() {
		return ref;
	}

	public String getSingleRangeEntry() {
		return singleRangeEntry;
	}

	public void setcCIndex(Integer cCIndex) {
		this.cCIndex = cCIndex;
	}

	public void setControlButtonCustom(String controlButtonCustom) {
		this.controlButtonCustom = controlButtonCustom;
	}

	public void setControlButtonType(Integer controlButtonType) {
		this.controlButtonType = controlButtonType;
	}

	public void setControlFlag(Boolean controlFlag) {
		this.controlFlag = controlFlag;
	}

	public void setControlLoc_Column(Integer controlLoc_Column) {
		this.controlLoc_Column = controlLoc_Column;
	}

	public void setControlLoc_ColumnSpan(Integer controlLoc_ColumnSpan) {
		this.controlLoc_ColumnSpan = controlLoc_ColumnSpan;
	}

	public void setControlLoc_Row(Integer controlLoc_Row) {
		this.controlLoc_Row = controlLoc_Row;
	}

	public void setControlLocation(ControlLocation controlLocation) {
		this.controlLocation = controlLocation;
	}

	public void setControlString(String controlString) {
		this.controlString = controlString;
	}

	public void setControlStringList(String controlStringList) {
		this.controlStringList = controlStringList;
	}

	public void setControlStringSelected(String controlStringSelected) {
		this.controlStringSelected = controlStringSelected;
	}

	public void setControlType(Integer controlType) {
		this.controlType = controlType;
	}

	public void setControlUse(Integer controlUse) {
		this.controlUse = controlUse;
	}

	public void setControlValue(Integer controlValue) {
		this.controlValue = controlValue;
	}

	public void setDo_Update(Boolean do_Update) {
		this.do_Update = do_Update;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setRange(Range range) {
		this.range = range;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public void setSingleRangeEntry(String singleRangeEntry) {
		this.singleRangeEntry = singleRangeEntry;
	}
}
