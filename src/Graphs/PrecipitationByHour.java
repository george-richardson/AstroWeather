package Graphs;

import AstroWeather.Main;

public class PrecipitationByHour extends WeatherGraphPanel {

	public PrecipitationByHour(Main parent, boolean orientation) {
		super(parent, orientation, "Precipitation By Hour");
	}

//	@Override
//	protected double extractValue(Forecast forecast) {
//		return Double.parseDouble(forecast.getPrecipitation());
//	}
}
