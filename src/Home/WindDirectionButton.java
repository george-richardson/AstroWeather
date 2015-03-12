package Home;

import API.Forecast;
import API.Forecasts;

import javax.swing.*;
import java.awt.*;

public class WindDirectionButton extends HomeButton {

    public WindDirectionButton(Forecast forecast) {
        super(determineWindIcon(forecast), "Wind");
        JLabel speed = new JLabel(forecast.windSpeedVal);
        speed.setForeground(Color.BLACK);
        add(speed);
    }

    private static Icon determineWindIcon(Forecast forecast) {
        return HomeButton.createIcon("windIcons/" + forecast.getWindDirection() + ".png");
    }
}
