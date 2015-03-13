package Home;

import API.Forecast;

public class TemperatureButton extends HomeButton {
    public TemperatureButton(int temp) {
        super("Temp", temp + "°");
    }
}
