package Common;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import AstroWeather.Main;

@SuppressWarnings("serial")
public abstract class AstroPanel extends JPanel {
	protected Main parent;
	protected boolean orientation;
	
	protected AstroPanel(Main parent, boolean orientation) {
		this.parent = parent;
		this.orientation= orientation;
		//setOpaque(false);
	}
	protected void change(AstroPanel p) {
		parent.changePanel(p);
	}

	public abstract void changeOrientation(boolean orientation);
	
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
