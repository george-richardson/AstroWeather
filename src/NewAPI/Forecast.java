package NewAPI;

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
        private int time;
        private float temperature;
        private float temperatureMax;
        private float humidity;
        private float windSpeed;
        private int windBearing;
        private float cloudCover;
        private float precipProbability;
        private float moonPhase;

        public int getTime() {
            return time;
        }

        public float getTemperature() {
            return temperature;
        }

        public float getHumidity() {
            return humidity;
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

        public float getPrecipProbability() {
            return precipProbability;
        }

        public float getMoonPhase() {
            return moonPhase;
        }

        public float getTemperatureMax() {
            return temperatureMax;
        }
    }


}
