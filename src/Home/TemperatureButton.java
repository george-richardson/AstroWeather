package Home;

import API.Forecast;

public class TemperatureButton extends HomeButton {
    public TemperatureButton(Forecast forecast) {
        super("Temp", forecast.getHighTemperature() + "°");
    }
}
