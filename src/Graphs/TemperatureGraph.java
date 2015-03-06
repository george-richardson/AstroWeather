package Graphs;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Common.Resources;

import java.awt.*;
import java.text.SimpleDateFormat;

@SuppressWarnings("serial")
public class TemperatureGraph extends ChartPanel {

	private static final Color PRIMARY_COLOR = Color.WHITE;
	private static final Color BACKGROUND_COLOR = new Color(0.0f, 0.0f, 0.0f,
			0.0f);

	private static final String TITLE = "Temperature By Hour";
	private static final String X_AXIS_LABEl = "";
	private static final String Y_AXIS_LABEl = "";
	private static final boolean ENABLE_LEGEND = false;
	private static final boolean ENABLE_TOOLTIPS = false;
	private static final boolean ENABLE_URLS = false;
	private static final SimpleDateFormat HOUR_FORMAT = new SimpleDateFormat(
			"kk");

	public TemperatureGraph(XYSeries temperatureByHour) {
		super(createChart(temperatureByHour));
		setPreferredSize(new Dimension(500, 270)); // TODO: might not need this
													// if we can get it to fill
													// the container
		setBackground(BACKGROUND_COLOR);
	}

	private static XYDataset createDataset(XYSeries temperatureByHour) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(temperatureByHour);
		return dataset;
	}

	private static JFreeChart createChart(XYSeries temperatureByHour) {
		XYDataset dataset = createDataset(temperatureByHour);

		JFreeChart chart = ChartFactory.createTimeSeriesChart(TITLE,
				X_AXIS_LABEl, Y_AXIS_LABEl, dataset, ENABLE_LEGEND,
				ENABLE_TOOLTIPS, ENABLE_URLS);

		chart.getTitle().setFont(Resources.chartTitleFont);

		chart.setBackgroundPaint(BACKGROUND_COLOR);
		chart.getTitle().setPaint(PRIMARY_COLOR);

		XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(BACKGROUND_COLOR);

		plot.setDomainGridlinePaint(PRIMARY_COLOR);
		plot.setRangeGridlinePaint(PRIMARY_COLOR);

		DateAxis domainAxis = (DateAxis) plot.getDomainAxis();
		domainAxis.setDateFormatOverride(HOUR_FORMAT);
		colorAxis(domainAxis);

		ValueAxis rangeAxis = plot.getRangeAxis();
		colorAxis(rangeAxis);

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setBaseShapesVisible(false);
		renderer.setSeriesPaint(0, PRIMARY_COLOR);

		plot.setRenderer(renderer);

		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		return chart;
	}

	private static void colorAxis(ValueAxis rangeAxis) {
		rangeAxis.setAxisLinePaint(PRIMARY_COLOR);
		rangeAxis.setTickLabelPaint(PRIMARY_COLOR);
	}
}