package API;
import java.net.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;


//author : Haricharran Sampat

public class AstroWeatherAPI {
	

		static String theWeatherRSS;
		static String theCity;
		static ArrayList<Forecast> weatherForecastList;
		
		static String choice;
		
		String zone ="Australia/Adelaide";
				//"GB";
				//"Europe/London";
		// can find list of java timezone codes here:
		//http://en.wikipedia.org/wiki/List_of_tz_database_time_zones
		
		String numDays = "15";
		
		
	

		public AstroWeatherAPI(String city) {
			
			
			weatherForecastList = new ArrayList<Forecast>();
			
			theCity = city;
			
			theWeatherRSS = getWeatherAsRSS(city);
          
			
			init();
			
			

			try {
				
				getValues(theWeatherRSS, "<symbol", "name");
				getValues(theWeatherRSS, "<windDirection", "name");
				getValues(theWeatherRSS, "<windSpeed", "mps");
				getValues(theWeatherRSS, "<windSpeed", "name");
				getValues(theWeatherRSS, "<temperature", "min");
				getValues(theWeatherRSS, "<temperature", "max");
				getValues(theWeatherRSS, "<pressure", "value");
				getValues(theWeatherRSS, "<humidity", "value");
				getValues(theWeatherRSS, "<clouds", "value");
				getValues(theWeatherRSS, "<sun", "rise");
				getValues(theWeatherRSS, "<sun", "set");

			}

			catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("error retrieving weather information");
			}
			
		}
		
		
		
		// initialises weatherForecastList and sets correct dates  for given timezone
		public void init(){
			
			
			TimeTracker track = new TimeTracker(zone, Integer.parseInt(numDays));
			
			String [] dates = track.getDates();
			
			
			for (int i = 0; i < Integer.parseInt(numDays); i++) {
			
				Forecast f = new Forecast();
				f.date = dates[i];
				weatherForecastList.add(f);
				
			}
			
		}
		
		

		//gets all values for a given key 
		// eg key = windSpeed -> sets  windSpeed att in each Forecast Object
		//val = mph
		void getValues(String wdata, String key, String val){
			
			int i=0;
			int startIndex = 0;
			
			choice = val;
			
			
			while (startIndex != -1) {
				
				startIndex = wdata.indexOf(key, startIndex);
				if (startIndex != -1) { // found a weather forecast
					int endIndex = wdata.indexOf(">", startIndex);
					String weatherForecast = wdata.substring(startIndex,
							endIndex + 1);
				
				
				Forecast f = weatherForecastList.get(i);
				
				setChoice(f, key, getValueForKey(weatherForecast, val));
				
				i++;
				
				startIndex = endIndex;
				
				}
			}	
			
		}
		
		
		
		
		void setChoice(Forecast f, String field, String value){
			
			
			switch (field) {
	
				case "<symbol":
					
					f.rain = value;
					break;
		
					
				case "<windDirection":
					
					f.windDir = value;
					break;
		
					
				case "<windSpeed":
					
					if (choice.equals("mps")) {
						f.windSpeedVal = value;
					}
		
					else {
						f.windSpeedType = value;
					}
					break;
		
					
				case "<temperature":
					if (choice.equals("min")) {
						f.lowTemp = value;
					}
		
					else {
						f.highTemp = value;
					}
					break;
					
		
				case "<pressure":
					
					f.pressure = value;
					break;
		
					
				case "<humidity":
					
					f.humidity = value;
					break;
		
					
				case "<clouds":
					
					f.clouds = value;
					break;
		
					
				case "<sun":
					
					if (choice.equals("rise")) {
						f.sunrise = value;
		
					}
		
					else {
						f.sunset = value;
					}
					break;
		
				
		
				default:
					
					break;
		
			}
			
		}

		
	
	
		
		String getValueForKey(String theString, String keyString) {
			int startIndex = theString.indexOf(keyString);
			startIndex = theString.indexOf("\"", startIndex);//start at opening "
			int endIndex = theString.indexOf("\"", startIndex + 1);//end at closing "
			String resultString = theString.substring(startIndex + 1, endIndex);
			return resultString;
		}
		

		
		String getWeatherAsRSS(String city) {
			try {
				/*
				 * Adapted from:
				 * http://stackoverflow.com/questions/1381617/simplest-
				 * way-to-correctly-load-html-from-web-page-into-a-string-in-java
				 * Answer provided by: erickson
				 */
			//	URL url = new URL("http://weather.yahooapis.com/forecastrss?w="
				//		+ city + "&u=c");
				
				//URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q="+city+"&mode=xml&units=metric&cnt=10");
				
				URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q="+city+"&mode=xml&units=metric&cnt="+numDays);
				
				URLConnection con = url.openConnection();
				Pattern p = Pattern.compile("text/html;\\s+charset=([^\\s]+)\\s*");
				Matcher m = p.matcher(con.getContentType());
				/*
				 * If Content-Type doesn't match this pre-conception, choose default
				 * and hope for the best.
				 */
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

