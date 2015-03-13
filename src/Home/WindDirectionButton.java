package Home;

import Common.Resources;

import javax.swing.*;
import java.awt.*;

public class WindDirectionButton extends HomeButton {
    String speed;

    public WindDirectionButton(int direction, int speed) {
        super(getWindIcon(direction), "Wind");
        this.speed = "" + speed;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.black);
        g2.setFont(Resources.titleFont);
        FontMetrics fm = g2.getFontMetrics();
        g2.drawString(speed, 53 - (fm.stringWidth(speed)/2), 55);
        g2.dispose();
    }

    private static Icon getWindIcon(int direction) {
        String file;
        if (direction > 338 || direction <= 23) file = "north";
        else if (direction > 293) file = "northwest";
        else if (direction > 248) file = "west";
        else if (direction > 203) file = "southwest";
        else if (direction > 158) file = "south";
        else if (direction > 113) file = "southeast";
        else if (direction > 68) file = "east";
        else file = "northeast";
        return Resources.getImage("windIcons/" + file + ".png");

    }
}
