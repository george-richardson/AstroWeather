package Home;

import API.Forecast;

public class HumidityButton extends HomeButton {
    public HumidityButton(int humidity) {
        super("Humidity", humidity + "%");
    }
}
