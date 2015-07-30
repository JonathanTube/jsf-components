package com.hyjd.component.echarts.pie;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import com.hyjd.component.echarts.BaseChartRenderer;
import com.hyjd.component.echarts.UIChart;
import com.hyjd.component.echarts.pie.model.PieChartModel;

//告诉这个类是渲染哪个组件的，通过componentFamily和rendererType到配置文件中定位组件
@FacesRenderer(componentFamily = PieChart.COMPONENT_FAMILY, rendererType = PieChart.COMPONENT_TYPE)
public class PieChartRenderer extends BaseChartRenderer {

	@Override
	public void decode(FacesContext context, UIComponent component) {
		/*
		 * String clientId = component.getClientId(context); // 获取请求参数
		 * Map<String, String> parameterMap =
		 * context.getExternalContext().getRequestParameterMap(); String value =
		 * parameterMap.get(clientId); try { // 设置组件值 //
		 * pieChart.setValue(Integer.parseInt(value)); } catch
		 * (NumberFormatException e) { e.printStackTrace(); }
		 */
	}

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
		PieChart pieChart = (PieChart) component;

		encodeMarkup(context, pieChart);

		encodeScript(writer, pieChart);

		encodeOption(writer, pieChart);

		encodeTitle(writer, pieChart);

		encodeTooltip(writer);

		encodeLegend(writer, pieChart);

		encodeToolbox(writer, pieChart);

		encodeSeries(writer, pieChart);

		endScript(writer);
	}

	protected void encodeLegendData(ResponseWriter writer, UIChart uiChart) throws IOException {
		PieChartModel model = (PieChartModel) uiChart.getValue();
		writer.write("data:[");
		for (Iterator<String> it = model.getData().keySet().iterator(); it.hasNext();) {
			String key = it.next();

			writer.write("'" + key + "'");

			if (it.hasNext())
				writer.write(",");
		}

		writer.write("]");
	}

	private void encodeSeries(ResponseWriter writer, PieChart pieChart) throws IOException {
		writer.write("series : [{");
		PieChartModel model = (PieChartModel) pieChart.getValue();
		if(isNotBlank(model.getName())){
			writer.write("name:'" + model.getName() + "',");
		}
		writer.write("type:'pie',");
		writer.write("radius:'" + pieChart.getSeriesRadius() + "',");
		writer.write("center: [" + pieChart.getSeriesCenter() + "],");
		encodeSeriesData(writer, pieChart);
		writer.write("}]");
	}

	@Override
	protected void encodeSeriesData(ResponseWriter writer, UIChart uiChart) throws IOException {

		writer.write("data:[");

		PieChartModel model = (PieChartModel) uiChart.getValue();
		for (Iterator<String> it = model.getData().keySet().iterator(); it.hasNext();) {
			String key = it.next();
			Number value = model.getData().get(key);

			writer.write("{value:" + value + ",name:'" + escapeText(key) + "'}");

			if (it.hasNext())
				writer.write(",");
		}

		writer.write("]");
	}
}
