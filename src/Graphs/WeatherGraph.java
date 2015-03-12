package Graphs;

import Common.Resources;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.EventListener;

@SuppressWarnings("serial")
public class WeatherGraph extends ChartPanel {

	private static final String X_AXIS_LABEl = "";
	private static final String Y_AXIS_LABEl = "";
	private static final boolean ENABLE_LEGEND = false;
	private static final boolean ENABLE_TOOLTIPS = false;
	private static final boolean ENABLE_URLS = false;
	private static final SimpleDateFormat HOUR_FORMAT = new SimpleDateFormat("kk");

	public WeatherGraph(String title, XYSeries dataByHour) {
		super(createChart(title, dataByHour));
		setBackground(Resources.bgColor);
		setOpaque(false);
		removeClickListeners();
	}

	/**
	 * Do not allow clicks on the graph so that it is read-only.
	 */
	private void removeClickListeners() {
		setDomainZoomable(false);
		setRangeZoomable(false);
		EventListener[] listeners = getListeners(MouseListener.class);
		for (EventListener listener : listeners) {
			removeMouseListener((MouseListener) listener);
		}
	}

	private static XYDataset createDataset(XYSeries temperatureByHour) {
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(temperatureByHour);
		return dataset;
	}

	private static JFreeChart createChart(String title,
			XYSeries temperatureByHour) {
		XYDataset dataset = createDataset(temperatureByHour);

		JFreeChart chart = ChartFactory.createTimeSeriesChart(title,
				X_AXIS_LABEl, Y_AXIS_LABEl, dataset, ENABLE_LEGEND,
				ENABLE_TOOLTIPS, ENABLE_URLS);

		chart.getTitle().setFont(Resources.chartTitleFont);

		chart.setBackgroundPaint(Resources.bgColor);
		chart.getTitle().setPaint(Resources.titleColor);

		XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Resources.bgColor);

		plot.setDomainGridlinePaint(Resources.titleColor);
		plot.setRangeGridlinePaint(Resources.titleColor);

		DateAxis domainAxis = (DateAxis) plot.getDomainAxis();
		domainAxis.setDateFormatOverride(HOUR_FORMAT);
		colorAxis(domainAxis);

		ValueAxis rangeAxis = plot.getRangeAxis();
		colorAxis(rangeAxis);

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setBaseShapesVisible(false);
		renderer.setSeriesPaint(0, Resources.titleColor);

		plot.setRenderer(renderer);

		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		return chart;
	}

	private static void colorAxis(ValueAxis rangeAxis) {
		rangeAxis.setAxisLinePaint(Resources.titleColor);
		rangeAxis.setTickLabelPaint(Resources.titleColor);
	}
}
