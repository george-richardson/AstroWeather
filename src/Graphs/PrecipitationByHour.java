package Graphs;

import AstroWeather.Main;
import NewAPI.Forecast;

public class PrecipitationByHour extends WeatherGraphPanel {

	public PrecipitationByHour(Main parent, Forecast.data[] hourlyForecastData) {
		super(parent, "Precipitation", hourlyForecastData);
	}

	@Override
	protected double extractValue(Forecast.data forecast) {
		return forecast.getPrecipProbabilityAsPercentage();
	}
}
