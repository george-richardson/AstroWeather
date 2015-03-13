package NewAPI;

/**
 * Created by George on 13/03/2015.
 */
public class Location {
    private results[] results;
    private String status;
    private class results {
        private geometry geometry;
        public geometry getGeometry() {return geometry;}
        private class geometry {
            private location location;
            public location getLocation() {return location;}
            private class location {
                public float lat;
                public float lng;
                public float getLat() {return lat;}
                public float getLng() {return lng;}
            }
        }
    }
    public float getLat() {
        if (results.length > 0) return results[0].getGeometry().getLocation().getLat();
        return 0f;
    }

    public float getLng() {
        if (results.length > 0)return results[0].getGeometry().getLocation().getLng();
        return 0f;
    }

    public String getStatus() {
        return status;
    }
}
