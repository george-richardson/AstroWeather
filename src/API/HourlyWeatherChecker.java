package API;


import java.text.SimpleDateFormat;

// check weather in hours
public class HourlyWeatherChecker extends AstroWeatherChecker{

	public HourlyWeatherChecker(String city) {
		super(city);

		this.numDays = "1";
		this.timePeriod = "hourly?";
		this.timeAttribute = "from";
		this.timeFormat = new SimpleDateFormat("yyyy-M-dd'T'HH:mm:ss"); //2015-03-11T18:00:00

		theWeatherRSS = getWeatherAsRSS(city,timePeriod);
	}

}//end class
