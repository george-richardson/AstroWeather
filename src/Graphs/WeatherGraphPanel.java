package Graphs;

import java.awt.BorderLayout;

import org.jfree.data.xy.XYSeries;

import AstroWeather.Main;
import Common.AstroPanel;

@SuppressWarnings("serial")
public class WeatherGraphPanel extends AstroPanel {

	public WeatherGraphPanel(Main parent, boolean orientation, String graphTitle, XYSeries dataByHour) {
		super(parent, orientation);
		
		setLayout(new BorderLayout());
		add(new WeatherGraph(graphTitle, dataByHour), BorderLayout.CENTER);
	}

	@Override
	public void changeOrientation(boolean orientation) {
		// Nothing special needs to happen for the temperature graph,
		// it will resize automatically
	}
}
