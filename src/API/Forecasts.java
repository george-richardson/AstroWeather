package API;

import java.util.List;

public class Forecasts {

	private List<Forecast> hourlyForecasts;
	private List<Forecast> dailyForecasts;

	public Forecasts(String city) {
		HourlyWeatherChecker hourlyWeatherChecker = new HourlyWeatherChecker(city);
		hourlyForecasts = hourlyWeatherChecker.getWeather();

		DailyWeatherChecker dailyWeatherChecker = new DailyWeatherChecker(city);
		dailyForecasts = dailyWeatherChecker.getWeather();
	}

	public List<Forecast> getHourlyForecasts() {
		return hourlyForecasts;
	}

	public List<Forecast> getDailyForecasts() {
		return dailyForecasts;
	}
}
