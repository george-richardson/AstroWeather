package API;

import java.net.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;


//author : Haricharran Sampat

public abstract class AstroWeatherChecker {
	

		String theWeatherRSS;
		String theCity;
		ArrayList<Forecast> weatherForecastList;
	
		
		// attribute of weather chosen eg name, value, max, min
		String choice;
	
		String numDays;
		// = "15";
		
		String numHours;
		// = "48";// daily -> website predetermined ->  every 3 hours for 6 days starting from current time
		// value of cnt makes no difference
		// 8 blocks of 3h *6 = 48 3hour forecast objects
	
		String timePeriod;
		//daily or hourly
			
		
		
		
		/*
		public ArrayList<Forecast> getWeather(){
			
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
				getValues(theWeatherRSS, "<clouds", "all");
				getValues(theWeatherRSS, "<sun", "rise");
				getValues(theWeatherRSS, "<sun", "set");

			}

			catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("error retrieving weather information");
			}
			
			return weatherForecastList;
			
		}
		
		*/
		

		public AstroWeatherChecker(String city) {
			
			
			weatherForecastList = new ArrayList<Forecast>();
			
			theCity = city;
			
		}
		
		
		
		public ArrayList<Forecast> getWeather(){
			
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
				getValues(theWeatherRSS, "<clouds", "all");
				getValues(theWeatherRSS, "<sun", "rise");
				getValues(theWeatherRSS, "<sun", "set");

			}

			catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("error retrieving weather information");
			}
			
			return weatherForecastList;
			
		}
	
		
		
		// initialises weatherForecastList and sets correct dates  for given time period
		abstract void init();
			
			
		
		

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
				
				//System.out.println(weatherForecast);
				
				Forecast f = weatherForecastList.get(i);
					
				
				setChoice(f, key, getValueForKey(weatherForecast, val));
				
				i++;
				//System.out.println("i = "+ i);
				startIndex = endIndex;
				
				}
			}	
			
		}
		
		
		
		// sets value of the field in the forecast object
		void setChoice(Forecast f, String field, String value){
			
			
			switch (field) {
	
				case "<symbol":
					
					f.rainType = value;
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
					
					if (choice.equals("value")) {
						f.cloudType = value;
					}
		
					else {
						f.cloudVal= value;
					}
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

		
	
	
		// looks up key associated with given value
		String getValueForKey(String theString, String keyString) {
		
			
			int startIndex = theString.indexOf(keyString);
			startIndex = theString.indexOf("\"", startIndex);//start at opening "
			int endIndex = theString.indexOf("\"", startIndex + 1);//end at closing "
			String resultString = theString.substring(startIndex + 1, endIndex);
			return resultString;
	
		}
		

		// gets weather from openWathermap.org 
		// puts data into string from from XML 
		String getWeatherAsRSS(String city, String timePeriod) {
			try {
				/*
				 * Adapted from:
				 * http://stackoverflow.com/questions/1381617/simplest-
				 * way-to-correctly-load-html-from-web-page-into-a-string-in-java
				 * Answer provided by: erickson
				 */
			//	URL url = new URL("http://weather.yahooapis.com/forecastrss?w="
				//		+ city + "&u=c");
				
			//	URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/hourly?q="+city+"&mode=xml&units=metric&cnt=1");
				
				URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/" +timePeriod+ "q="+city+"&mode=xml&units=metric&cnt="+numDays);
				//change to hourly 
				
				
	
				
				
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

