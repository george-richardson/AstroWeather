package Home;

import API.Forecast;

public class HumidityButton extends HomeButton {
    public HumidityButton(Forecast forecast) {
        super("Humidity", forecast.getHumidity() + "%");
    }
}
