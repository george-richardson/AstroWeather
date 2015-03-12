package Graphs;

import API.Forecast;
import API.Forecasts;
import AstroWeather.Main;

public class HumidityByHour extends WeatherGraphPanel {

	public HumidityByHour(Main parent, boolean orientation, Forecasts forecasts) {
		super(parent, orientation, forecasts, "Humidity By Hour");
	}

	@Override
	protected double extractValue(Forecast forecast) {
		return Double.parseDouble(forecast.humidity);
	}
}
