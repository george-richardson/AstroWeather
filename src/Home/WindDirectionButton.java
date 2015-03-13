package Home;

import javax.swing.*;
import java.awt.*;

public class WindDirectionButton extends HomeButton {

    public WindDirectionButton() {
        super("windIcons/east.png", "Wind");
        JLabel speed = new JLabel("50");
        speed.setForeground(Color.RED);
        add(speed);
    }
}
