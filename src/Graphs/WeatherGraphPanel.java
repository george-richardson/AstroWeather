package Graphs;

import API.Forecasts;
import API.Forecasts;
import AstroWeather.Main;
import Common.AstroPanel;
import org.jfree.data.xy.XYSeries;

import java.awt.*;

@SuppressWarnings("serial")
public class WeatherGraphPanel extends AstroPanel {

	public WeatherGraphPanel(Main parent, boolean orientation, Forecasts forecasts, String graphTitle, XYSeries dataByHour) {
		super(parent, orientation, forecasts);

		setLayout(new BorderLayout());
		add(new WeatherGraph(graphTitle, dataByHour), BorderLayout.CENTER);
	}

	@Override
	public void changeOrientation(boolean orientation) {
		// Nothing special needs to happen for the temperature graph,
		// it will resize automatically
	}
}
