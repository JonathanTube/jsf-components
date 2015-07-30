package com.hyjd.component.echarts.pie;

import javax.faces.component.FacesComponent;

import com.hyjd.component.echarts.UIChart;

@FacesComponent(namespace = "http://www.hyjd.com/component/echarts", createTag = true, tagName = "pieChart", value = PieChart.COMPONENT_TYPE)
public class PieChart extends UIChart {
	// 用于xml配置和render
	public static final String COMPONENT_FAMILY = "com.hyjd.component.echarts";
	public static final String COMPONENT_TYPE = "com.hyjd.component.echarts.pie.PieChart";
	static final String DEFAULT_RENDERER = "com.hyjd.component.echarts.pie.PieChartRenderer";

	enum Series {
		seriesCenter, seriesRadius
	}

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public PieChart() {
		setRendererType(DEFAULT_RENDERER);
	}

	public String getSeriesCenter() {
		return (String) getStateHelper().eval(Series.seriesCenter, "'50%','60%'");
	}

	public void setSeriesCenter(String seriesCenter) {
		getStateHelper().put(Series.seriesCenter, seriesCenter);
	}

	public String getSeriesRadius() {
		return (String) getStateHelper().eval(Series.seriesRadius, "55%");
	}

	public void setSeriesRadius(String seriesRadius) {
		getStateHelper().put(Series.seriesRadius, seriesRadius);
	}
}
