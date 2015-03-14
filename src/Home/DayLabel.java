package Home;

import Common.Resources;

import javax.swing.*;

public class DayLabel extends JLabel {

    public DayLabel(String day) {
        super(day, JLabel.CENTER);
        setFont(Resources.titleFont);
        setForeground(Resources.titleColor);
    }
}
