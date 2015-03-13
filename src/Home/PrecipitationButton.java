package Home;

import API.Forecast;

public class PrecipitationButton extends HomeButton {
    public PrecipitationButton(int chance) {
        super("Rain", chance + "%");
    }
}
