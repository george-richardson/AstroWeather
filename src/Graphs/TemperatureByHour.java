package Graphs;

import AstroWeather.Main;
import NewAPI.Forecast;

public class TemperatureByHour extends WeatherGraphPanel {

	public TemperatureByHour(Main parent, boolean orientation, Forecast.data[] hourlyForecastData) {
		super(parent, orientation, "Temperature", hourlyForecastData);
	}

	@Override
	protected double extractValue(Forecast.data forecast) {
		return forecast.getTemperature();
	}
}
