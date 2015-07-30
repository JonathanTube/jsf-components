package com.hyjd.component.echarts.radar;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.hyjd.component.echarts.BaseChartRenderer;
import com.hyjd.component.echarts.UIChart;
import com.hyjd.component.echarts.radar.model.RadarChartIndicator;
import com.hyjd.component.echarts.radar.model.RadarChartModel;
import com.hyjd.component.echarts.radar.model.RadarChartSeries;

//告诉这个类是渲染哪个组件的，通过componentFamily和rendererType到配置文件中定位组件
@FacesRenderer(componentFamily = RadarChart.COMPONENT_FAMILY, rendererType = RadarChart.COMPONENT_TYPE)
public class RadarChartRenderer extends BaseChartRenderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		RadarChart radarChart = (RadarChart) component;

		encodeMarkup(context, radarChart);

		encodeScript(writer, radarChart);

		encodeOption(writer, radarChart);

		encodeTitle(writer, radarChart);

		encodeTooltip(writer);

		encodeLegend(writer, radarChart);

		encodeToolbox(writer, radarChart);

		encodePolar(writer, radarChart);

		encodeSeries(writer, radarChart);

		endScript(writer);
	}

	private void encodePolar(ResponseWriter writer, RadarChart radarChart) throws IOException {
		writer.write(" polar : [{indicator : [");
		RadarChartModel radarChartModel = (RadarChartModel) radarChart.getValue();
		List<RadarChartIndicator> indicators = radarChartModel.getIndicators();
		for (Iterator<RadarChartIndicator> it = indicators.iterator(); it.hasNext();) {
			RadarChartIndicator indicator = it.next();
			writer.write("{");
			writer.write("text:'" + indicator.getText() + "',max:" + indicator.getMax());
			writer.write("}");
			if (it.hasNext())
				writer.write(",");
		}
		writer.write("");
		writer.write("]}],");
	}

	protected void encodeToolbox(ResponseWriter writer, UIChart uiChart) throws IOException {
		if (uiChart.isShowToolbox()) {
			writer.write("toolbox: {");
			writer.write("show : true,");
			writer.write("feature : {");
			writer.write("mark : {show: true},");
			writer.write("dataView : {show: true, readOnly: false},");
			writer.write("magicType : {show: true, type: ['line', 'bar']},");
			writer.write("restore : {show: true},");
			writer.write("saveAsImage : {show: true}");
			writer.write("}},");
		}
	}

	protected void encodeLegendData(ResponseWriter writer, UIChart uiChart) throws IOException {
		RadarChartModel model = (RadarChartModel) uiChart.getValue();
		writer.write("data:[");
		for (Iterator<RadarChartSeries> it = model.getData().iterator(); it.hasNext();) {
			RadarChartSeries radarChartSeries = it.next();

			writer.write("'" + radarChartSeries.getName() + "'");

			if (it.hasNext())
				writer.write(",");
		}

		writer.write("]");
	}

	protected void encodeTooltip(ResponseWriter writer) throws IOException {
		writer.write("tooltip : {");
		writer.write("trigger: 'axis'");
		writer.write("},");
	}

	private void encodeSeries(ResponseWriter writer, RadarChart radarChart) throws IOException {
		writer.write("series : [{");
		RadarChartModel model = (RadarChartModel) radarChart.getValue();
		writer.write("name:'" + model.getName() + "',");
		writer.write("type:'radar',");
		encodeSeriesData(writer, radarChart);
		writer.write("}]");
	}

	@Override
	protected void encodeSeriesData(ResponseWriter writer, UIChart uiChart) throws IOException {

		RadarChartModel model = (RadarChartModel) uiChart.getValue();

		writer.write("data:[");

		for (Iterator<RadarChartSeries> it = model.getData().iterator(); it.hasNext();) {
			RadarChartSeries barChartSeries = it.next();

			writer.write("{name:'" + barChartSeries.getName() + "',");
			writer.write("value:[");
			Number[] numbers = barChartSeries.getData();
			for (int i = 0; i < numbers.length; i++) {
				writer.write(numbers[i].toString());
				if (i < numbers.length - 1) {
					writer.write(",");
				}
			}
			writer.write("]}");

			if (it.hasNext())
				writer.write(",");
		}

		writer.write("]");
	}
}
