package API;
// check weather in days 
public class DailyWeatherChecker extends AstroWeatherChecker {

	public DailyWeatherChecker(String city) {
		super(city);
		
		this.numDays = "15";
		
		this.timePeriod = "daily?";
		
		theWeatherRSS = getWeatherAsRSS(city,timePeriod);
		
		init();
		
	}

	
	// set up forecast arrayList and set correct dates
	public void init(){
		
		TimeTracker track = new TimeTracker();
		
		String [] dates = track.getDayDates(Integer.parseInt(numDays));
		
		
		for (int i = 0; i < Integer.parseInt(numDays); i++) {
		
			Forecast f = new Forecast();
			f.date = dates[i];
			weatherForecastList.add(f);
			
		}
	}
	
	
}//end class
