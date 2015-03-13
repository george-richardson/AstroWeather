package NewAPI;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by George on 13/03/2015.
 */
public class API {

    public static final String locationAPIKey = "AIzaSyAiJx46inL5dt60IY8J0AqHPGk9cvOGhP8";
    public static final String weatherAPIKey =  "8cf3187428e482773e8d309c38ff7ca1";
    public static final String locationURL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    public static final String weatherURL = "https://api.forecast.io/forecast/8cf3187428e482773e8d309c38ff7ca1/";

    public String getJSON(String urlToRead) {
        URL url;
        HttpURLConnection con;
        BufferedReader br;
        String line;
        StringBuilder result = new StringBuilder();
        try {
            url = new URL(urlToRead);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while ((line = br.readLine())!= null) {
                result.append(line);
            }
            br.close();
        } catch (MalformedURLException e) {
            System.err.println(e + ": " + e.getMessage());
        } catch (IOException e) {
            System.err.println(e + ": " + e.getMessage());
        }
        return result.toString();
    }

    public Location getLocationFromString(String address) {
        Gson gs = new Gson();
        Location location = gs.fromJson(getJSON(API.locationURL + address.replaceAll("\\s+","") + "&key=" + API.locationAPIKey), Location.class);
        if (location.getStatus().equals("ZERO_RESULTS")) throw new LocationDoesNotExistException(address);
        return location;
    }

    public Forecast getForecastFromLocation(Location location) {
        Gson gs = new Gson();
        return gs.fromJson(getJSON(weatherURL + location.getLat() + "," + location.getLng() + "?units=uk"), Forecast.class);
    }

    public Forecast getForecastFromString(String address) {
        return getForecastFromLocation(getLocationFromString(address));
    }

    public static void main(String[] args) {
        API api = new API();
        try {
            Location loc = api.getLocationFromString("Paris");
            System.out.println(loc.getStatus());
            System.out.println(loc.getLat());
            System.out.println(loc.getLng());
            System.out.println(api.getForecastFromLocation(loc).getDaily().getData()[0].getMoonPhase());
        } catch (LocationDoesNotExistException e) {
            System.err.println(e.getMessage());
        }

    }
}
