package com.hyjd.component.echarts.radar.model;

import java.io.Serializable;

public class RadarChartIndicator implements Serializable {
	private static final long serialVersionUID = 1L;

	private String text;
	private Number max;

	public RadarChartIndicator() {
		super();
	}

	public RadarChartIndicator(String text, Number max) {
		this.text = text;
		this.max = max;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Number getMax() {
		return max;
	}

	public void setMax(Number max) {
		this.max = max;
	}

}
