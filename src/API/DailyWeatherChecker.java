package API;

import java.text.SimpleDateFormat;

// check weather in days
public class DailyWeatherChecker extends AstroWeatherChecker {

	public DailyWeatherChecker(String city) {
		super(city);

		this.numDays = "15";

		this.timePeriod = "daily";
		this.timeAttribute = "day";
		this.timeFormat = new SimpleDateFormat("yyyy-M-dd"); //2015-03-11

		theWeatherRSS = getWeatherAsRSS(city,timePeriod);
	}
}//end class
