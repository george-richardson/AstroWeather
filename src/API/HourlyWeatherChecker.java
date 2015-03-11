package API;


// check weather in hours
public class HourlyWeatherChecker extends AstroWeatherChecker{

	public HourlyWeatherChecker(String city) {
		super(city);
		
		this.timePeriod = "hourly?";
		
		theWeatherRSS = getWeatherAsRSS(city,timePeriod);
		
		init();
		
		
	}

	
	
	//set up forecast arrayList and set correct hours and days
	public void init(){
		
		TimeTracker track = new TimeTracker();
		
		String [] dates = track.getHourlyDates();
		
		
		for (int i = 0; i < dates.length; i++) {
		
			Forecast f = new Forecast();
			f.date = dates[i];
			weatherForecastList.add(f);
			
		}
	}
	
}//end class
