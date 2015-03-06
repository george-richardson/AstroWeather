package API;
import java.net.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.io.*;

//Haricharran Sampat
/*

// data given over 5 days  -> store data for each day as a 
// forecast object

public class myWeather {

	static String theWeatherRSS;
	static String theCity;
	static ArrayList<Forecast> weatherForecastList;
	
	
	

	public myWeather(String city) {
		
		weatherForecastList = new ArrayList<Forecast>();

		// initialise with 5 forecast objects
		for (int i = 0; i < 5; i++) {
			weatherForecastList.add(new Forecast());
		}

		
		theCity = city;
		
		theWeatherRSS = getWeatherAsRSS(city);


		try {

			// could make weatherForecastList global and only have 1 arg ?
			
			parseGeneral(theWeatherRSS, weatherForecastList);
			parseLocation(theWeatherRSS, weatherForecastList);
			parseWind(theWeatherRSS, weatherForecastList);
			parseAstronomy(theWeatherRSS, weatherForecastList);
			parseAtmosphere(theWeatherRSS, weatherForecastList);

		}

		catch (Exception e) {
			System.out.println("error retrieving weather information");
		}
	}
	
	
	

	void parseGeneral(String weatherHTML, ArrayList<Forecast> wflist) {

		int i = 0;
		int startIndex = 0;

		// get general weather for 5 day period
		while (startIndex != -1) {
			startIndex = weatherHTML.indexOf("<yweather:forecast", startIndex);
			if (startIndex != -1) { // found a weather forecast
				int endIndex = weatherHTML.indexOf(">", startIndex);
				String weatherForecast = weatherHTML.substring(startIndex,
						endIndex + 1);

				Forecast f = wflist.get(i);
				
				f.day  = getValueForKey(weatherForecast, "day");
				f.date = getValueForKey(weatherForecast, "date");
				f.lowTemp = getValueForKey(weatherForecast, "low");
				f.highTemp= getValueForKey(weatherForecast, "high");
				f.forecast = getValueForKey(weatherForecast, "text");

				i++;

				// move to end of this forecast
				startIndex = endIndex;
			}
		}

	}// end parse method
	
	
	

	void parseLocation(String weatherHTML, ArrayList<Forecast> wflist) {

		int startIndex = 0;

		// get location data
		while (startIndex != -1) {

			startIndex = weatherHTML.indexOf("<yweather:location", startIndex);
			if (startIndex != -1) { // found a weather forecast
				int endIndex = weatherHTML.indexOf(">", startIndex);
				String weatherForecast = weatherHTML.substring(startIndex,
						endIndex + 1);
				
				Forecast f = wflist.get(0);

				f.country = getValueForKey(weatherForecast,"country");
				f.city = getValueForKey(weatherForecast, "city");
				f.region = getValueForKey(weatherForecast, "region");

				startIndex = endIndex;
			}
		}

	}// end parseLocation
	
	
	
	

	void parseWind(String weatherHTML, ArrayList<Forecast> wflist) {

		int startIndex = 0;

		// get wind for current day only
		while (startIndex != -1) {
			startIndex = weatherHTML.indexOf("<yweather:wind", startIndex);
			if (startIndex != -1) { // found a weather forecast
				int endIndex = weatherHTML.indexOf(">", startIndex);
				String weatherForecast = weatherHTML.substring(startIndex,
						endIndex + 1);

				Forecast f = wflist.get(0);
				
				f.windChill = getValueForKey(weatherForecast, "chill");
				f.windDir = getValueForKey(weatherForecast, "direction");
				f.windSpeed = getValueForKey(weatherForecast, "speed");

				startIndex = endIndex;
			}
		}

	}// end parseWind
	
	
	

	void parseAstronomy(String weatherHTML, ArrayList<Forecast> wflist) {

		int startIndex = 0;

		// get atmosphere for current day only
		while (startIndex != -1) {
			startIndex = weatherHTML.indexOf("<yweather:astronomy", startIndex);
			if (startIndex != -1) { // found a weather forecast
				int endIndex = weatherHTML.indexOf(">", startIndex);
				String weatherForecast = weatherHTML.substring(startIndex,
						endIndex + 1);
				
				Forecast f = wflist.get(0);

				f.sunrise = getValueForKey(weatherForecast, "sunrise");
				f.sunset = getValueForKey(weatherForecast, "sunset");

				startIndex = endIndex;
			}
		}

	}// end parseAstronomy

	
	
	
	void parseAtmosphere(String weatherHTML, ArrayList<Forecast> wflist) {

		int startIndex = 0;

		// get general astronomy for current day only
		while (startIndex != -1) {
			startIndex = weatherHTML
					.indexOf("<yweather:atmosphere", startIndex);
			if (startIndex != -1) { // found a weather forecast
				int endIndex = weatherHTML.indexOf(">", startIndex);
				String weatherForecast = weatherHTML.substring(startIndex,
						endIndex + 1);
				
				Forecast f = wflist.get(0);

				f.humidity = getValueForKey(weatherForecast, "humidity");
				f.visibility = getValueForKey(weatherForecast, "visibility");
				f.pressure = getValueForKey(weatherForecast, "pressure");


				startIndex = endIndex;
			}
		}

	}// end parseAtmosphere
	
	
	

	String getValueForKey(String theString, String keyString) {
		int startIndex = theString.indexOf(keyString);
		startIndex = theString.indexOf("\"", startIndex);
		int endIndex = theString.indexOf("\"", startIndex + 1);
		String resultString = theString.substring(startIndex + 1, endIndex);
		return resultString;
	}
	*/
	


/*
	String getWeatherAsRSS(String city) {
		try {
			
			URL url = new URL("http://weather.yahooapis.com/forecastrss?w="
					+ city + "&u=c");
			
			//URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q="+city+"&mode=xml&units=metric&cnt=7");
			
			URLConnection con = url.openConnection();
			Pattern p = Pattern.compile("text/html;\\s+charset=([^\\s]+)\\s*");
			Matcher m = p.matcher(con.getContentType());
			
			String charset = m.matches() ? m.group(1) : "ISO-8859-1";
			Reader r = new InputStreamReader(con.getInputStream(), charset);
			StringBuilder buf = new StringBuilder();
			while (true) {
				int ch = r.read();
				if (ch < 0)
					break;
				buf.append((char) ch);
			}
			String str = buf.toString();
			return (str);
		} catch (Exception e) {
			System.err.println("Weather API Exception: " + e);
		}
		return null;
	}
	

}// end class
*/

