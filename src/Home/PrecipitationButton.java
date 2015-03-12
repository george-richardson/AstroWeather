package Home;

import API.Forecast;

public class PrecipitationButton extends HomeButton {
    public PrecipitationButton(Forecast forecast) {
        super("Rain", forecast.getPrecipitation() + "%");
    }
}
