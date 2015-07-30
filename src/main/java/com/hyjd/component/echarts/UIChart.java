package com.hyjd.component.echarts;

import javax.faces.component.UIOutput;
import javax.faces.component.behavior.ClientBehaviorHolder;

public abstract class UIChart extends UIOutput implements ClientBehaviorHolder {

	protected enum MarkupStyle {
		style, styleClass
	}

	protected enum Option {
		backgroundColor, color, renderAsImage, calculable, animation, showToolbox, showLegend
	}

	protected enum Tmeline {

	}

	protected enum Title {
		text, link, target, subText, subLink, subTarget, textAlign, textStyle, subTextStyle
	}

	protected enum Toolbox {

	}

	protected enum Tooltip {

	}

	protected enum Legend {
		legendOrient, legendX, legendY, legendItemGap
	}

	protected enum DataRange {

	}

	protected enum DataZoom {

	}

	protected enum Grid {
		paddingLeft, paddingRight, paddingTop, paddingBottom
	}

	protected enum XAxis {
		xaxisLabelInterval, xaxisRotate, xaxisFontSize
	}

	protected enum YAxis {
		yaxisMax, yaxisMin
	}

	protected enum Axis {

	}

	protected enum Polar {

	}

	protected enum Series {
		tooltip, type, clickable, itemStyle, data, markPoint, markLine
	}

	public String getBackgroundColor() {
		return (String) getStateHelper().eval(Option.backgroundColor, null);
	}

	public void setBackgroundColor(String backgroundColor) {
		getStateHelper().put(Option.backgroundColor, backgroundColor);
	}

	public String getColor() {
		return (String) getStateHelper().eval(Option.color, null);
	}

	public void setColor(String color) {
		getStateHelper().put(Option.color, color);
	}

	public boolean isRenderAsImage() {
		return (Boolean) getStateHelper().eval(Option.renderAsImage, false);
	}

	public void setRenderAsImage(boolean renderAsImage) {
		getStateHelper().put(Option.renderAsImage, renderAsImage);
	}

	public boolean isCalculable() {
		return (Boolean) getStateHelper().eval(Option.calculable, true);
	}

	public void setCalculable(boolean calculable) {
		getStateHelper().put(Option.calculable, calculable);
	}

	public boolean isAnimation() {
		return (Boolean) getStateHelper().eval(Option.animation, true);
	}

	public void setAnimation(boolean animation) {
		getStateHelper().put(Option.animation, animation);
	}

	public String getStyleClass() {
		return (String) getStateHelper().eval(MarkupStyle.styleClass, null);
	}

	public void setStyleClass(String _styleClass) {
		getStateHelper().put(MarkupStyle.styleClass, _styleClass);
	}

	public String getStyle() {
		String widthStyle = "height:400px";
		String style = (String) getStateHelper().eval(MarkupStyle.style, widthStyle);
		if (!style.contains("height")) {
			style = "height:400px;";
		}
		return style;
	}

	public void setStyle(String style) {
		getStateHelper().put(MarkupStyle.style, style);
	}

	public String getText() {
		return (String) getStateHelper().eval(Title.text, "");
	}

	public void setText(String text) {
		getStateHelper().put(Title.text, text);
	}

	public String getSubText() {
		return (String) getStateHelper().eval(Title.subText, "");
	}

	public void setSubText(String subText) {
		getStateHelper().put(Title.subText, subText);
	}

	public String getTextAlign() {
		return (String) getStateHelper().eval(Title.textAlign, "center");
	}

	public void setTextAlign(String textAlign) {
		getStateHelper().put(Title.textAlign, textAlign);
	}

	public boolean isShowToolbox() {
		return (Boolean) getStateHelper().eval(Option.showToolbox, true);
	}

	public void setShowToolbox(boolean showToolbox) {
		getStateHelper().put(Option.showToolbox, showToolbox);
	}

	public boolean isShowLegend() {
		return (Boolean) getStateHelper().eval(Option.showLegend, true);
	}

	public void setShowLegend(boolean showLegend) {
		getStateHelper().put(Option.showLegend, showLegend);
	}

	public String getXaxisLabelInterval() {
		return (String) getStateHelper().eval(XAxis.xaxisLabelInterval, "auto");
	}

	public void setXaxisLabelInterval(String xaxisLabelInterval) {
		getStateHelper().put(XAxis.xaxisLabelInterval, xaxisLabelInterval);
	}

	public String getXaxisRotate() {
		return (String) getStateHelper().eval(XAxis.xaxisRotate, "0");
	}

	public void setXaxisRotate(String xAxisRotate) {
		getStateHelper().put(XAxis.xaxisRotate, xAxisRotate);
	}

	public String getXaxisFontSize() {
		return (String) getStateHelper().eval(XAxis.xaxisFontSize, "15");
	}

	public void setXaxisFontSize(String xaxisFontSize) {
		getStateHelper().put(XAxis.xaxisFontSize, xaxisFontSize);
	}

	public String getPaddingLeft() {
		return (String) getStateHelper().eval(Grid.paddingLeft, "80");
	}

	public void setPaddingLeft(String paddingLeft) {
		getStateHelper().put(Grid.paddingLeft, paddingLeft);
	}

	public String getPaddingRight() {
		return (String) getStateHelper().eval(Grid.paddingRight, "80");
	}

	public void setPaddingRight(String paddingRight) {
		getStateHelper().put(Grid.paddingRight, paddingRight);
	}

	public String getPaddingTop() {
		return (String) getStateHelper().eval(Grid.paddingTop, "60");
	}

	public void setPaddingTop(String paddingTop) {
		getStateHelper().put(Grid.paddingTop, paddingTop);
	}

	public String getPaddingBottom() {
		return (String) getStateHelper().eval(Grid.paddingBottom, "60");
	}

	public void setPaddingBottom(String paddingBottom) {
		getStateHelper().put(Grid.paddingBottom, paddingBottom);
	}

	public String getLegendOrient() {
		return (String) getStateHelper().eval(Legend.legendOrient, "vertical");
	}

	public void setLegendOrient(String legendOrient) {
		getStateHelper().put(Legend.legendOrient, legendOrient);
	}

	public String getLegendX() {
		return (String) getStateHelper().eval(Legend.legendX, "left");
	}

	public void setLegendX(String legendX) {
		getStateHelper().put(Legend.legendX, legendX);
	}

	public String getLegendY() {
		return (String) getStateHelper().eval(Legend.legendY, "top");
	}

	public void setLegendY(String legendY) {
		getStateHelper().put(Legend.legendY, legendY);
	}

	public String getLegendItemGap() {
		return (String) getStateHelper().eval(Legend.legendItemGap, "10");
	}

	public void setLegendItemGap(String legendItemGap) {
		getStateHelper().put(Legend.legendItemGap, legendItemGap);
	}
	
	public String getYaxisMax() {
		return (String) getStateHelper().eval(YAxis.yaxisMax, "");
	}

	public void setYaxisMax(String yaxisMax) {
		getStateHelper().put(YAxis.yaxisMax, yaxisMax);
	}
	
	public String getYaxisMin() {
		return (String) getStateHelper().eval(YAxis.yaxisMin, "");
	}

	public void setYaxisMin(String yaxisMin) {
		getStateHelper().put(YAxis.yaxisMin, yaxisMin);
	}

}