package Home;

import Common.Resources;

import javax.swing.*;

/**
 * Created by George on 13/03/2015.
 */
public class TopButton extends JButton {
    public TopButton(String path) {
        super(Resources.getImage(path));
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }
}
