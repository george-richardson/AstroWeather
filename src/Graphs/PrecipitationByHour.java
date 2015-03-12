package Graphs;

import API.Forecast;
import API.Forecasts;
import AstroWeather.Main;

public class PrecipitationByHour extends WeatherGraphPanel {

	public PrecipitationByHour(Main parent, boolean orientation, Forecasts forecasts) {
		super(parent, orientation, forecasts, "Precipitation By Hour");
	}

	@Override
	protected double extractValue(Forecast forecast) {
		return Double.parseDouble(forecast.precipitation);
	}
}
