package NewAPI;

/**
 * Created by George on 13/03/2015.
 */
public class LocationDoesNotExistException extends RuntimeException {
    private String loc;
    public LocationDoesNotExistException(String loc) {
        this.loc = loc;
    }
    public String getMessage() {return "Location \"" + loc + "\" not found.";}
}
