package Home;

import API.Forecast;
import Common.Resources;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class DayLabel extends JLabel {

    public DayLabel(String day) {
        super(day, JLabel.CENTER);
        setFont(Resources.titleFont);
        setForeground(Resources.titleColor);
    }
}
