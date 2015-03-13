package Home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import API.Forecast;
import org.jfree.chart.block.LineBorder;

import Common.Resources;

@SuppressWarnings("serial")
public class DayPanel extends JPanel {
    public DayPanel(String day, int cloudCover, int temp) {
        setLayout(new BorderLayout());
        setOpaque(false);
        //setBorder(BorderFactory.createLineBorder(Resources.titleColor));
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Resources.titleColor));
        add(new DayLabel(day), BorderLayout.NORTH);
        JPanel p = new JPanel(new GridLayout(1, 2));
        p.setOpaque(false);
        p.add(new CloudCoverageButton(cloudCover));
        p.add(new TemperatureButton(temp));
        add(p, BorderLayout.CENTER);
    }
}
