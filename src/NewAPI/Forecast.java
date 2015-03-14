package NewAPI;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by George on 13/03/2015.
 */
public class Forecast {

    private hourly hourly;
    private daily daily;

    public Forecast.hourly getHourly() {
        return hourly;
    }

    public Forecast.daily getDaily() {
        return daily;
    }

    public class hourly {
        private data[] data;

        public Forecast.data[] getData() {
            return data;
        }
    }

    public class daily {
        private data[] data;

        public Forecast.data[] getData() {
            return data;
        }
    }

    public class data {
        private long time;
        private float temperature;
        private float temperatureMax;
        private float humidity;
        private float windSpeed;
        private int windBearing;
        private float cloudCover;
        private float precipProbability;
        private float moonPhase;

        public long getTimeInSecondsSinceEpoch() {
            return time;
        }

        public long getTimeInMillisecondsSinceEpoch() {
            return time * 1000;
        }

        public String getTimeAsHour() {
            Calendar cal = Calendar.getInstance();
            //cal.setTimeZone(TimeZone.getTimeZone("Europe/London"));
            cal.setTimeInMillis(getTimeInMillisecondsSinceEpoch());
            return "" + cal.get(cal.HOUR_OF_DAY);
        }

        public String getTimeAsDay() {
            Calendar cal = Calendar.getInstance();
            //cal.setTimeZone(TimeZone.getTimeZone("Europe/London"));
            cal.setTimeInMillis(getTimeInMillisecondsSinceEpoch());
            return cal.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG, Locale.ENGLISH);
        }

        public String getTimeAsDayAndHour() {
            Calendar cal = Calendar.getInstance();
            //cal.setTimeZone(TimeZone.getTimeZone("Europe/London"));
            cal.setTimeInMillis(getTimeInMillisecondsSinceEpoch());
            return cal.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.SHORT, Locale.ENGLISH)+ " " + cal.get(cal.HOUR_OF_DAY) + ":00";
        }


        public float getTemperature() {
            return temperature;
        }

        public float getHumidity() {
            return humidity;
        }

        public int getHumidityAsPercentage() {
            return (int) (humidity*100);
        }

        public float getWindSpeed() {
            return windSpeed;
        }

        public int getWindBearing() {
            return windBearing;
        }

        public float getCloudCover() {
            return cloudCover;
        }

        public int getCloudCoverAsInt() {return (int) (cloudCover * 100);}

        public float getPrecipProbability() {
            return precipProbability;
        }

        public int getPrecipProbabilityAsPercentage() {
            return (int) (precipProbability*100);
        }

        public float getMoonPhase() {
            return moonPhase;
        }

        public float getMoonPhaseAsAngle(){return moonPhase * 360;}

        public float getTemperatureMax() {
            return temperatureMax;
        }
    }


}
