package Home;

import API.Forecast;
import Common.Resources;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class DayLabel extends JLabel {

    public DayLabel(Forecast forecast) {
        super(formatDate(forecast), JLabel.CENTER);
        setFont(Resources.titleFont);
        setForeground(Resources.titleColor);
    }

    private static String formatDate(Forecast forecast) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE dd");
        return dateFormat.format(forecast.date);
    }
}
