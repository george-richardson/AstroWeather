package Graphs;

import Common.Resources;

import javax.swing.*;

/**
 * Created by Beneen on 14/03/2015.
 */
public class WeatherGraphTitleLabel extends JLabel {

    public WeatherGraphTitleLabel(String valueLabel) {
        super(valueLabel + " By Hour", JLabel.CENTER);
        setFont(Resources.titleFont);
        setForeground(Resources.titleColor);
    }
}
