package Graphs;

import java.awt.Color;
import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

@SuppressWarnings("serial")
public class TemperatureGraph extends ChartPanel {

	private static final String TITLE = "Temperature By Hour";
	private static final String X_AXIS_LABEl = "";
	private static final String Y_AXIS_LABEl = "";
	private static final boolean ENABLE_LEGEND = false;
	private static final boolean ENABLE_TOOLTIPS = false;
	private static final boolean ENABLE_URLS = false;
	private static final Color TRANSPARENT = new Color(0.0f, 0.0f, 0.0f, 0.0f);

	public TemperatureGraph(XYSeries temperatureByHour) {
		super(createChart(temperatureByHour));
		setPreferredSize(new Dimension(500, 270)); //TODO: might not need this if we can get it to fill the container
		setBackground(TRANSPARENT);
	}

	private static XYDataset createDataset(XYSeries temperatureByHour) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(temperatureByHour);
		return dataset;
	}

	private static JFreeChart createChart(XYSeries temperatureByHour) {
		XYDataset dataset = createDataset(temperatureByHour);
		
		JFreeChart chart = ChartFactory.createXYLineChart(TITLE, X_AXIS_LABEl, Y_AXIS_LABEl, dataset, PlotOrientation.VERTICAL, ENABLE_LEGEND, ENABLE_TOOLTIPS, ENABLE_URLS);
		chart.setBackgroundPaint(TRANSPARENT);

		XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(TRANSPARENT);

		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinePaint(Color.white);

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setBaseShapesVisible(false);
		plot.setRenderer(renderer);

		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		return chart;
		
	}
}
