package Graphs;

import AstroWeather.Main;
import NewAPI.Forecast;

public class PrecipitationByHour extends WeatherGraphPanel {

	public PrecipitationByHour(Main parent, boolean orientation, Forecast.data[] hourlyForecastData) {
		super(parent, orientation, "Precipitation", hourlyForecastData);
	}

	@Override
	protected double extractValue(Forecast.data forecast) {
		return forecast.getPrecipProbabilityAsPercentage();
	}
}
