package com.hyjd.component.echarts;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import org.apache.commons.lang3.StringUtils;

@ResourceDependencies({ @ResourceDependency(library = "echarts", name = "echarts-plain-map.js", target = "head") })
public abstract class BaseChartRenderer extends Renderer {

	protected void encodeMarkup(FacesContext context, UIChart uiChart) throws IOException {
		ResponseWriter writer = context.getResponseWriter();

		writer.startElement("div", null);
		writer.writeAttribute("id", uiChart.getId(), null);
		writer.writeAttribute("style", uiChart.getStyle(), null);
		writer.endElement("div");
	}

	protected void encodeTitle(ResponseWriter writer, UIChart uiChart) throws IOException {
		String text = uiChart.getText();
		String subText = uiChart.getSubText();

		if (StringUtils.isNotBlank(text) || StringUtils.isNotBlank(subText)) {
			writer.write("title : {");
			writer.write("text: '" + text + "',");
			writer.write("subtext: '" + subText + "',");
			writer.write("x:'" + uiChart.getTextAlign() + "'");
			writer.write("},");

		}

	}

	protected void encodeOption(ResponseWriter writer, UIChart uiChart) throws IOException {
		if (isNotBlank(uiChart.getBackgroundColor())) {
			writer.write("backgroundColor : " + uiChart.getBackgroundColor() + ",");
		}
		writer.write("calculable : " + uiChart.isCalculable() + ",");
		writer.write("renderAsImage : " + uiChart.isRenderAsImage() + ",");
		writer.write("calculable: " + uiChart.isCalculable() + ",");
		writer.write("animation: " + uiChart.isAnimation() + ",");
	}

	protected void encodeLegend(ResponseWriter writer, UIChart uiChart) throws IOException {
		if (uiChart.isShowLegend()) {
			writer.write("legend: {");
			writer.write("orient : '" + uiChart.getLegendOrient() + "',");
			writer.write("x: '" + uiChart.getLegendX() + "',");
			writer.write("y: '" + uiChart.getLegendY() + "',");
			writer.write("itemGap:" + uiChart.getLegendItemGap() + ",");
			encodeLegendData(writer, uiChart);
			writer.write("},");
		}
	}

	protected abstract void encodeLegendData(ResponseWriter writer, UIChart uiChart) throws IOException;

	protected void encodeTooltip(ResponseWriter writer) throws IOException {
		writer.write("tooltip : {");
		writer.write("trigger: 'item',");
		writer.write("formatter: \"{a} <br/>{b} : {c}\"");
		writer.write("},");
	}

	protected void encodeToolbox(ResponseWriter writer, UIChart uiChart) throws IOException {
		if (uiChart.isShowToolbox()) {
			writer.write("toolbox: {");
			writer.write("show : true,");
			writer.write("feature : {");
			writer.write("mark : {show: true},");
			writer.write("dataView : {show: true, readOnly: false},");
			writer.write("restore : {show: true},");
			writer.write("saveAsImage : {show: true}");
			writer.write("}},");
		}
	}

	protected void encodeGrid(ResponseWriter writer, UIChart uiChart) throws IOException {
		writer.write("grid:{");
		writer.write("x:" + uiChart.getPaddingLeft() + ",");
		writer.write("y:" + uiChart.getPaddingTop() + ",");
		writer.write("x2:" + uiChart.getPaddingRight() + ",");
		writer.write("y2:" + uiChart.getPaddingBottom());
		writer.write("},");
	}

	protected void encodeScript(ResponseWriter writer, UIChart uiChart) throws IOException {
		writer.startElement("script", null);
		writer.writeAttribute("type", "text/javascript", null);

		String id = uiChart.getId();
		// 判断图表是否被括在primefaces的tabView的tab中，移除部分tab的部分css，则能正常显示
		/*
		 * writer.write("if($('#" + id +
		 * "').parent().attr('role') == 'tabpanel'){"); writer.write("$('#" + id
		 * + "').parent().removeClass('ui-helper-hidden');"); writer.write("}");
		 */

		String domId = "echart_" + id;
		writer.write("var " + domId + " = echarts.init(document.getElementById('" + id + "'));");
		writer.write(domId + ".showLoading({text: 'loading...'});");
		writer.write(domId + ".hideLoading();");

		writer.write(domId + ".setOption({");
	}

	protected void endScript(ResponseWriter writer) throws IOException {
		writer.write("});");
		writer.endElement("script");
	}

	protected abstract void encodeSeriesData(ResponseWriter writer, UIChart uiChart) throws IOException;

	protected String escapeText(String text) {
		if (text == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			switch (ch) {
			case '"':
				sb.append("\\\"");
				break;
			case '\'':
				sb.append("\\\'");
				break;
			case '\\':
				sb.append("\\\\");
				break;
			case '\b':
				sb.append("\\b");
				break;
			case '\f':
				sb.append("\\f");
				break;
			case '\n':
				sb.append("\\n");
				break;
			case '\r':
				sb.append("\\r");
				break;
			case '\t':
				sb.append("\\t");
				break;
			case '/':
				sb.append("\\/");
				break;
			default:
				// Reference: http://www.unicode.org/versions/Unicode5.1.0/
				if ((ch >= '\u0000' && ch <= '\u001F') || (ch >= '\u007F' && ch <= '\u009F')
						|| (ch >= '\u2000' && ch <= '\u20FF')) {
					String ss = Integer.toHexString(ch);
					sb.append("\\u");
					for (int k = 0; k < 4 - ss.length(); k++) {
						sb.append('0');
					}
					sb.append(ss.toUpperCase());
				} else {
					sb.append(ch);
				}
			}
		}

		return sb.toString();
	}
}