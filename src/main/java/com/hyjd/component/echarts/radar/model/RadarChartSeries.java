package com.hyjd.component.echarts.radar.model;

import java.io.Serializable;

public class RadarChartSeries implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;

	private Number[] data;

	public RadarChartSeries() {
		super();
	}

	public RadarChartSeries(String name, Number[] data) {
		this.name = name;
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Number[] getData() {
		return data;
	}

	public void setData(Number[] data) {
		this.data = data;
	}
}
