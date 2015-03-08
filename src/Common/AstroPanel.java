package Common;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AstroWeather.Main;

@SuppressWarnings("serial")
public abstract class AstroPanel extends JPanel {
	protected Main parent;
	protected boolean orientation;
	
	protected AstroPanel(Main parent, boolean orientation) {
		this.parent = parent;
		this.orientation= orientation;
		
		// JLabel background = new JLabel(new ImageIcon(Resources.backgroundImage));
		//    background.setLayout(new BorderLayout());
		//    add(background);
		setBackground(Color.green);
		    
	}
	protected void change(AstroPanel p) {
		parent.changePanel(p);
	}

	public abstract void changeOrientation(boolean orientation);
	
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		Dimension dimension = getSize();
	//	graphics.drawImage(Resources.backgroundImage, 0, 0, dimension.width, dimension.height, null);
	}
}
