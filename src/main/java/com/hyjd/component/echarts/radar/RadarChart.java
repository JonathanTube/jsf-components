package com.hyjd.component.echarts.radar;

import javax.faces.component.FacesComponent;

import com.hyjd.component.echarts.UIChart;

@FacesComponent(namespace = "http://www.nkstar.com/component/echarts", createTag = true, tagName = "radarChart", value = RadarChart.COMPONENT_TYPE)
public class RadarChart extends UIChart {
	// 用于xml配置和render
	public static final String COMPONENT_FAMILY = "com.nkstar.component.echarts";
	public static final String COMPONENT_TYPE = "com.nkstar.component.echarts.radar.RadarChart";
	static final String DEFAULT_RENDERER = "com.nkstar.component.echarts.radar.RadarChartRenderer";

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public RadarChart() {
		setRendererType(DEFAULT_RENDERER);
	}

	public String getTextAlign() {
		return (String) getStateHelper().eval(Title.textAlign, "left");
	}

	public void setTextAlign(String textAlign) {
		getStateHelper().put(Title.textAlign, textAlign);
	}
}
