package com.hyjd.component.echarts.radar.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class RadarChartModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<RadarChartIndicator> indicators;

	private String name;

	private List<RadarChartSeries> data;

	public RadarChartModel(String name) {
		this.name = name;
		data = new LinkedList<RadarChartSeries>();
	}

	public RadarChartModel() {
		data = new LinkedList<RadarChartSeries>();
	}

	public void set(RadarChartSeries series) {
		this.data.add(series);
	}

	public void clear() {
		this.data.clear();
	}

	public List<RadarChartSeries> getData() {
		return data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RadarChartIndicator> getIndicators() {
		return indicators;
	}

	public void setIndicators(List<RadarChartIndicator> indicators) {
		this.indicators = indicators;
	}

}