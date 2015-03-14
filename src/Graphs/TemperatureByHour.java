package Graphs;

import AstroWeather.Main;
import NewAPI.Forecast;

public class TemperatureByHour extends WeatherGraphPanel {

	public TemperatureByHour(Main parent, Forecast.data[] hourlyForecastData) {
		super(parent, "Temperature", hourlyForecastData);
	}

	@Override
	protected double extractValue(Forecast.data forecast) {
		return forecast.getTemperature();
	}
}
