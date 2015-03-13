package Graphs;

import AstroWeather.Main;

public class TemperatureByHour extends WeatherGraphPanel {

	public TemperatureByHour(Main parent, boolean orientation) {
		super(parent, orientation, "Temperature By Hour");
	}

//	@Override
//	protected double extractValue(Forecast forecast) {
//		return Double.parseDouble(forecast.highTemp);
//	}
}
