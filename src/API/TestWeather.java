

public class TestWeather
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
		 
		
	    AstroWeatherAPI x = new AstroWeatherAPI("Adelaide");
	    		//("London");
		
		for(Forecast  f: x.weatherForecastList){
			
			
			//System.out.println(f.day);
			System.out.println("date " + f.date);
			System.out.println("clouds " + f.clouds);
			System.out.println("low temp "+f.lowTemp);
			System.out.println("high temp " + f.highTemp);
			System.out.println("windtype " + f.windSpeedType);
		    System.out.println("rain "+f.rain);
		   
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
		
		
		
	}//end main 
	
	
}//end class
