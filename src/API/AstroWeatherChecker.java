package API;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//author : Haricharran Sampat

public abstract class AstroWeatherChecker {

    private static final String TIME_TAG = "<time ";

    String theWeatherRSS;
    String theCity;
    List<Forecast> weatherForecastList;


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

    String timeAttribute;
    //day for daily or from for hourly

    SimpleDateFormat timeFormat;
    //2015-03-11 for daily or 2015-03-11T18:00:00 for hourly

    public AstroWeatherChecker(String city) {
        weatherForecastList = new ArrayList<Forecast>();
        theCity = city;
    }


    public List<Forecast> getWeather() {
        int numberOfSamples = calculateNumberOfSamples();
        for (int i = 0; i < numberOfSamples; i++) {
            weatherForecastList.add(new Forecast());
        }

        try {

            getValues(theWeatherRSS, TIME_TAG, timeAttribute);
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

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("error retrieving weather information");
        }

        return filterByNumberOfDaysToKeep();

    }

    private int calculateNumberOfSamples() {
        Pattern sample = Pattern.compile(TIME_TAG);
        Matcher matcher = sample.matcher(theWeatherRSS);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }


    //gets all values for a given key
    // eg key = windSpeed -> sets  windSpeed att in each Forecast Object
    //val = mph
    private void getValues(String wdata, String key, String val) {

        int i = 0;
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
    private void setChoice(Forecast f, String field, String value) {
        switch (field) {
            case TIME_TAG:
                try {
                    f.date = timeFormat.parse(value);
                } catch (ParseException e) {
                    throw new RuntimeException("Could not parse time" + value, e);
                }
                break;

            case "<symbol":
                f.rainType = value;
                break;

            case "<windDirection":
                f.windDir = value;
                break;

            case "<windSpeed":

                if (choice.equals("mps")) {
                    f.windSpeedVal = value;
                } else {
                    f.windSpeedType = value;
                }
                break;

            case "<temperature":
                if (choice.equals("min")) {
                    f.lowTemp = value;
                } else {
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
                } else {
                    f.cloudVal = value;
                }
                break;

            case "<sun":
                if (choice.equals("rise")) {
                    f.sunrise = value;

                } else {
                    f.sunset = value;
                }
                break;

            default:
                break;
        }
    }


    // looks up key associated with given value
    private String getValueForKey(String theString, String keyString) {
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
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/" + timePeriod + "?q=" + city + "&mode=xml&units=metric&cnt=" + numDays + "&APPID=0a53221ef5a622a0d9a16cece339aae4");
            //change to hourly


            URLConnection con = url.openConnection();
            con.setConnectTimeout(2000);
            con.setReadTimeout(2000);

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
            Files.write(getCachePath(city, timePeriod), str.getBytes());
            return (str);
        } catch (Exception e) {
            System.err.println("Weather API Exception: " + e);
            return getTheWeatherRSSFromCache(city, timePeriod);
        }
    }

    private Path getCachePath(String city, String timePeriod) {
        return Paths.get(getCacheKey(city, timePeriod));
    }

    private String getCacheKey(String city, String timePeriod) {
        return "./cache/" + city + "-" + timePeriod + "-" + numDays;
    }

    private String getTheWeatherRSSFromCache(String city, String timePeriod) {
        try {
            return new String(Files.readAllBytes(getCachePath(city, timePeriod)));
        } catch (IOException e) {
            throw new RuntimeException("Weather API was not available and could not fall back on cache", e);
        }
    }

    private List<Forecast> filterByNumberOfDaysToKeep() {
        if (weatherForecastList.isEmpty()) {
            return weatherForecastList;
        }

        Date maxDate = calculateMaxDateToKeep();
        List<Forecast> filtered = new ArrayList<>();
        for (Forecast forecast : weatherForecastList) {
            if (forecast.date.before(maxDate)) {
                filtered.add(forecast);
            }
        }
        return filtered;
    }

    private Date calculateMaxDateToKeep() {
        int daysToKeep = Integer.parseInt(numDays);
        Date first = weatherForecastList.get(0).date;
        Calendar current = Calendar.getInstance();
        current.setTime(first);
        current.add(Calendar.DAY_OF_MONTH, daysToKeep);
        current.add(Calendar.SECOND, 1);
        return current.getTime();
    }


}// end class

