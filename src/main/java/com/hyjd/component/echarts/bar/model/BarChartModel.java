package com.hyjd.component.echarts.bar.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class BarChartModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<BarChartSeries> series = new LinkedList<BarChartSeries>();

	public BarChartModel() {
		super();
	}
	
	public void addSeries(BarChartSeries barChartSeries) {
		this.series.add(barChartSeries);
	}

	public void clear() {
		this.series.clear();
	}

	public List<BarChartSeries> getSeries() {
		return series;
	}
}