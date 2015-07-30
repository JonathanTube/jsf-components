package com.hyjd.component.echarts.pie.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class PieChartModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private Map<String, Number> data;

	public PieChartModel(String name) {
		this.name = name;
		data = new LinkedHashMap<String, Number>();
	}

	public PieChartModel() {
		data = new LinkedHashMap<String, Number>();
	}

	public PieChartModel(Map<String, Number> data) {
		this.data = data;
	}

	public Map<String, Number> getData() {
		return data;
	}

	public void setData(Map<String, Number> data) {
		this.data = data;
	}

	public void set(String category, Number data) {
		this.data.put(category, data);
	}

	public void clear() {
		this.data.clear();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}