package com.khubla.hsclient.domain;

import com.fasterxml.jackson.annotation.*;

public class Range {
	@JsonProperty("RangeStart")
	private Integer rangeStart;
	@JsonProperty("RangeEnd")
	private Integer rangeEnd;
	@JsonProperty("RangeStatusDecimals")
	private Integer rangeStatusDecimals;
	@JsonProperty("RangeStatusValueOffset")
	private Integer rangeStatusValueOffset;
	@JsonProperty("RangeStatusDivisor")
	private Integer rangeStatusDivisor;
	@JsonProperty("RangeStatusSuffix")
	private String rangeStatusSuffix;
	@JsonProperty("ScaleReplace")
	private String scaleReplace;
	@JsonProperty("HasScale")
	private Boolean hasScale;
	@JsonProperty("RangeStatusPrefix")
	private String rangeStatusPrefix;

	public Boolean getHasScale() {
		return hasScale;
	}

	public Integer getRangeEnd() {
		return rangeEnd;
	}

	public Integer getRangeStart() {
		return rangeStart;
	}

	public Integer getRangeStatusDecimals() {
		return rangeStatusDecimals;
	}

	public Integer getRangeStatusDivisor() {
		return rangeStatusDivisor;
	}

	public String getRangeStatusPrefix() {
		return rangeStatusPrefix;
	}

	public String getRangeStatusSuffix() {
		return rangeStatusSuffix;
	}

	public Integer getRangeStatusValueOffset() {
		return rangeStatusValueOffset;
	}

	public String getScaleReplace() {
		return scaleReplace;
	}

	public void setHasScale(Boolean hasScale) {
		this.hasScale = hasScale;
	}

	public void setRangeEnd(Integer rangeEnd) {
		this.rangeEnd = rangeEnd;
	}

	public void setRangeStart(Integer rangeStart) {
		this.rangeStart = rangeStart;
	}

	public void setRangeStatusDecimals(Integer rangeStatusDecimals) {
		this.rangeStatusDecimals = rangeStatusDecimals;
	}

	public void setRangeStatusDivisor(Integer rangeStatusDivisor) {
		this.rangeStatusDivisor = rangeStatusDivisor;
	}

	public void setRangeStatusPrefix(String rangeStatusPrefix) {
		this.rangeStatusPrefix = rangeStatusPrefix;
	}

	public void setRangeStatusSuffix(String rangeStatusSuffix) {
		this.rangeStatusSuffix = rangeStatusSuffix;
	}

	public void setRangeStatusValueOffset(Integer rangeStatusValueOffset) {
		this.rangeStatusValueOffset = rangeStatusValueOffset;
	}

	public void setScaleReplace(String scaleReplace) {
		this.scaleReplace = scaleReplace;
	}
}
