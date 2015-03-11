package API;
import java.util.ArrayList;



public abstract class TestWeather
{

	// list of codes for cities
	// eg London = 4418
	// New York = 2459115
	
	public static void main(String[] args)
	{
		/*
		WeatherAPI weather = new WeatherAPI("44418");
				//("44418");
		System.out.println(weather.theWeatherRSS);
		for(int i = 0; i < weather.weatherForecastList.size(); i++)
		{
			System.out.println(weather.weatherForecastList.get(i).lowTemp + " " +
			weather.weatherForecastList.get(i).highTemp);
		}
		System.out.println("---------------------------\n\n\n");
		
		
		
		//myWeather w = new myWeather("44418");
		  
		 */ 
		 
		
	 //   AstroWeatherChecker x = new AstroWeatherChecker("London");
	    
		AstroWeatherChecker z = new HourlyWeatherChecker("London");
	    AstroWeatherChecker y = new DailyWeatherChecker("London");
	    		//("London");
		
	   // AstroWeatherChecker z = new HourlyWeatherChecker("London");
	    
		///for(Forecast  f: x.weatherForecastList){
	    
			
	    for(Forecast  f: y.getWeather()){
			
			//System.out.println(f.day);
			System.out.println("date " + f.date);
			System.out.println("clouds val " + f.cloudVal);
			System.out.println("clouds type " + f.cloudType);
			System.out.println("low temp "+f.lowTemp);
			System.out.println("high temp " + f.highTemp);
			System.out.println("windtype " + f.windSpeedType);
		    System.out.println("raintype "+f.rainType);
		    System.out.println("precipitation "+f.precipitation);
		    System.out.println("windval " + f.windSpeedVal);
		    System.out.println("wind direction " + f.windDir);
		    System.out.println("sunrise " + f.sunrise);
		    System.out.println("sunset " + f.sunset);
		    System.out.println("humidity " + f.humidity);
		    System.out.println(f.visibility);
		    System.out.println("pressure " + f.pressure);
		    System.out.println();
		    
			//only get sunrise and sunset for current day 
		    
		}
		
	    ArrayList<Forecast> d = y.getWeather();
	    
	    System.out.println(d.get(0).highTemp);
		
		
	}//end main 
	
	
}//end class
