package Home;

import Common.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class DayPanel extends JPanel {
    public DayPanel(String day, int cloudCover, int temp) {

        final MouseEvent me = new MouseEvent(this, 0, 0, 0, 100, 100, 1, false);
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getMouseListeners()[0].mouseClicked(me);
            }
        };

        setLayout(new BorderLayout());
        setOpaque(false);
        //setBorder(BorderFactory.createLineBorder(Resources.titleColor));
        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Resources.titleColor));
        add(new DayLabel(day), BorderLayout.NORTH);
        JPanel p = new JPanel(new GridLayout(1, 2));
        p.setOpaque(false);

        CloudCoverageButton cloudBtn = new CloudCoverageButton(cloudCover);
        cloudBtn.addActionListener(al);
        p.add(cloudBtn);

        TemperatureButton tempBtn = new TemperatureButton(temp);
        tempBtn.addActionListener(al);
        p.add(tempBtn);

        add(p, BorderLayout.CENTER);
    }

}
