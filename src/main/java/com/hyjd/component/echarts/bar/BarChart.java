package com.hyjd.component.echarts.bar;

import javax.faces.component.FacesComponent;

import com.hyjd.component.echarts.UIChart;

@FacesComponent(namespace = "http://www.hyjd.com/component/echarts", createTag = true, tagName = "barChart", value = BarChart.COMPONENT_TYPE)
public class BarChart extends UIChart {
	// 用于xml配置和render
	public static final String COMPONENT_FAMILY = "com.hyjd.component.echarts";
	public static final String COMPONENT_TYPE = "com.hyjd.component.echarts.bar.BarChart";
	static final String DEFAULT_RENDERER = "com.hyjd.component.echarts.bar.BarChartRenderer";

	enum PropertyKeys {

	}

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public BarChart() {
		setRendererType(DEFAULT_RENDERER);
	}
}
