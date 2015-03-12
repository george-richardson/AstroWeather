package Graphs;

import API.Forecast;
import API.Forecasts;
import AstroWeather.Main;

public class TemperatureByHour extends WeatherGraphPanel {

	public TemperatureByHour(Main parent, boolean orientation, Forecasts forecasts) {
		super(parent, orientation, forecasts, "Temperature By Hour");
	}

	@Override
	protected double extractValue(Forecast forecast) {
		return Double.parseDouble(forecast.highTemp);
	}
}
