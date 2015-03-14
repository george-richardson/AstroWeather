package Graphs;

import AstroWeather.Main;
import NewAPI.Forecast;

public class HumidityByHour extends WeatherGraphPanel {

	public HumidityByHour(Main parent, Forecast.data[] hourlyForecastData) {
		super(parent, "Humidity", hourlyForecastData);
	}

	@Override
	protected double extractValue(Forecast.data forecast) {
		return forecast.getHumidityAsPercentage();
	}
}
