package com.khubla.hsclient.domain;

import com.fasterxml.jackson.annotation.*;

public class ControlPair {
	@JsonProperty("Do_Update")
	private String do_Update;
	@JsonProperty("SingleRangeEntry")
	private String singleRangeEntry;
	@JsonProperty("ControlButtonType")
	private String controlButtonType;
	@JsonProperty("ControlButtonCustom")
	private String controlButtonCustom;
	@JsonProperty("CCIndex")
	private String cCIndex;
	@JsonProperty("Range")
	private String range;
	@JsonProperty("Ref")
	private String ref;
	@JsonProperty("Label")
	private String label;
	@JsonProperty("ControlType")
	private String controlType;
	@JsonProperty("ControlLoc_Row")
	private String controlLoc_Row;
	@JsonProperty("ControlLoc_Column")
	private String controlLoc_Column;
	@JsonProperty("ControlLoc_ColumnSpan")
	private String controlLoc_ColumnSpan;
	@JsonProperty("ControlUse")
	private String controlUse;
	@JsonProperty("ControlValue")
	private String controlValue;
	@JsonProperty("ControlString")
	private String controlString;
	@JsonProperty("ControlStringList")
	private String controlStringList;
	@JsonProperty("ControlStringSelected")
	private String controlStringSelected;
	@JsonProperty("ControlFlag")
	private String controlFlag;
	@JsonProperty("ControlLocation")
	private ControlLocation controlLocation;

	public String getcCIndex() {
		return cCIndex;
	}

	public String getControlButtonCustom() {
		return controlButtonCustom;
	}

	public String getControlButtonType() {
		return controlButtonType;
	}

	public String getControlFlag() {
		return controlFlag;
	}

	public String getControlLoc_Column() {
		return controlLoc_Column;
	}

	public String getControlLoc_ColumnSpan() {
		return controlLoc_ColumnSpan;
	}

	public String getControlLoc_Row() {
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

	public String getControlType() {
		return controlType;
	}

	public String getControlUse() {
		return controlUse;
	}

	public String getControlValue() {
		return controlValue;
	}

	public String getDo_Update() {
		return do_Update;
	}

	public String getLabel() {
		return label;
	}

	public String getRange() {
		return range;
	}

	public String getRef() {
		return ref;
	}

	public String getSingleRangeEntry() {
		return singleRangeEntry;
	}

	public void setcCIndex(String cCIndex) {
		this.cCIndex = cCIndex;
	}

	public void setControlButtonCustom(String controlButtonCustom) {
		this.controlButtonCustom = controlButtonCustom;
	}

	public void setControlButtonType(String controlButtonType) {
		this.controlButtonType = controlButtonType;
	}

	public void setControlFlag(String controlFlag) {
		this.controlFlag = controlFlag;
	}

	public void setControlLoc_Column(String controlLoc_Column) {
		this.controlLoc_Column = controlLoc_Column;
	}

	public void setControlLoc_ColumnSpan(String controlLoc_ColumnSpan) {
		this.controlLoc_ColumnSpan = controlLoc_ColumnSpan;
	}

	public void setControlLoc_Row(String controlLoc_Row) {
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

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	public void setControlUse(String controlUse) {
		this.controlUse = controlUse;
	}

	public void setControlValue(String controlValue) {
		this.controlValue = controlValue;
	}

	public void setDo_Update(String do_Update) {
		this.do_Update = do_Update;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public void setSingleRangeEntry(String singleRangeEntry) {
		this.singleRangeEntry = singleRangeEntry;
	}
}
