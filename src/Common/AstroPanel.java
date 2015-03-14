package Common;

import AstroWeather.Main;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public abstract class AstroPanel extends JPanel {

    protected Main parent;

    protected AstroPanel(Main parent) {
        this.parent = parent;
    }
    
    protected void change(AstroPanel p) {
        parent.changePanel(p);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1 = Resources.bgColorTop;
        Color color2 = Resources.bgColorBottom;
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
}
