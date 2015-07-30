package com.hyjd.component.echarts.bar.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class BarChartSeries implements Serializable {
	private static final long serialVersionUID = 1L;

	private String label;
	
	private String stack;

	private Map<Object, Number> data = new LinkedHashMap<Object, Number>();

	public BarChartSeries() {
		super();
	}

	public void set(Object object, Number number) {
		data.put(object, number);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Map<Object, Number> getData() {
		return data;
	}

	/**
	 * @return the stack
	 */
	public String getStack() {
		return stack;
	}

	/**
	 * @param stack the stack to set
	 */
	public void setStack(String stack) {
		this.stack = stack;
	}
}
