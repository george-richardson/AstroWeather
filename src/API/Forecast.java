package API;

import java.util.Date;

public class Forecast {
	public Date date;
	public String lowTemp;
	public String highTemp;
	public String precipitation;
	public String rainType;
	public String cloudVal;
	public String cloudType;
	public String windDir;
	public String windSpeedVal;
	public String windSpeedType;
	public String humidity;
	public String visibility;
	public String pressure;
	public String sunrise;
	public String sunset;

    public String getWindDirection() {
        int hyphenIndex = windDir.indexOf('-');
        if (hyphenIndex < 0) {
            return windDir;
        }
        return windDir.substring(0, hyphenIndex);
    }
}
