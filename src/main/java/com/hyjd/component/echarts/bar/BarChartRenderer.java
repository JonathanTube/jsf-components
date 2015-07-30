package com.hyjd.component.echarts.bar;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.hyjd.component.echarts.BaseChartRenderer;
import com.hyjd.component.echarts.UIChart;
import com.hyjd.component.echarts.bar.model.BarChartModel;
import com.hyjd.component.echarts.bar.model.BarChartSeries;

//告诉这个类是渲染哪个组件的，通过componentFamily和rendererType到配置文件中定位组件
@FacesRenderer(componentFamily = BarChart.COMPONENT_FAMILY, rendererType = BarChart.COMPONENT_TYPE)
// 渲染类必须继承Renderer
public class BarChartRenderer extends BaseChartRenderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		BarChart barChart = (BarChart) component;

		encodeMarkup(context, barChart);

		encodeScript(writer, barChart);

		encodeOption(writer, barChart);

		encodeTitle(writer, barChart);

		encodeTooltip(writer);

		encodeGrid(writer, barChart);

		encodeLegend(writer, barChart);

		encodeToolbox(writer, barChart);

		encodeXAxis(writer, barChart);
		encodeYAxis(writer, barChart);

		encodeSeries(writer, barChart);

		endScript(writer);
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
		BarChartModel model = (BarChartModel) uiChart.getValue();
		writer.write("data:[");
		List<BarChartSeries> serieses = model.getSeries();

		for (Iterator<BarChartSeries> it = serieses.iterator(); it.hasNext();) {
			writer.write("'" + it.next().getLabel() + "'");
			if (it.hasNext())
				writer.write(",");
		}
		writer.write("]");
	}

	private void encodeSeries(ResponseWriter writer, BarChart barChart) throws IOException {
		writer.write("series : [");
		encodeSeriesData(writer, barChart);
		writer.write("]");
	}

	private void encodeXAxis(ResponseWriter writer, BarChart barChart) throws IOException {
		BarChartModel model = (BarChartModel) barChart.getValue();

		writer.write("xAxis : [{type : 'category',");
		writer.write("axisLabel : {");
		writer.write("show:true,");
		writer.write("interval: '" + barChart.getXaxisLabelInterval() + "',");// 是否全部显示标签(echart会自动隐藏显示不下的内容0:全部，auto：自动)
		writer.write("rotate:" + barChart.getXaxisRotate() + ",");// 旋转的角度
		writer.write("textStyle: {");
		writer.write("fontSize:" + barChart.getXaxisFontSize());
		writer.write("}");
		writer.write("},");
		writer.write("data : [");
		if (model.getSeries().size() > 0) {
			Map<Object, Number> param = model.getSeries().get(0).getData();
			for (Iterator<Object> it = param.keySet().iterator(); it.hasNext();) {
				writer.write("'" + it.next() + "'");
				if (it.hasNext())
					writer.write(",");
			}
		}
		writer.write("]}],");
	}

	private void encodeYAxis(ResponseWriter writer, UIChart uiChart) throws IOException {
		writer.write("yAxis : [{");
		writer.write("type : 'value'");
		if (isNotBlank(uiChart.getYaxisMax())) {
			writer.write(",max : " + uiChart.getYaxisMax());
		}
		if (isNotBlank(uiChart.getYaxisMin())) {
			writer.write(",min : " + uiChart.getYaxisMin());
		}
		writer.write("}],");
	}

	@Override
	protected void encodeSeriesData(ResponseWriter writer, UIChart uiChart) throws IOException {

		BarChartModel model = (BarChartModel) uiChart.getValue();

		for (Iterator<BarChartSeries> it = model.getSeries().iterator(); it.hasNext();) {
			BarChartSeries series = it.next();
			writer.write("{");
			if (isNotBlank(series.getLabel())) {
				writer.write("name:'" + series.getLabel() + "',");
			}
			if (isNotBlank(series.getStack())) {
				writer.write("stack:'" + series.getStack() + "',");
			}
			writer.write("type:'bar',data:[");
			for (Iterator<Object> itData = series.getData().keySet().iterator(); itData.hasNext();) {
				writer.write(series.getData().get(itData.next()).toString());
				if (itData.hasNext())
					writer.write(",");
			}
			writer.write("]}");
			if (it.hasNext())
				writer.write(",");
		}
	}
}
