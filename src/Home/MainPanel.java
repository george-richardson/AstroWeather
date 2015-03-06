package AstroWeather;

import javax.swing.JLabel;

import Common.AstroPanel;
import Common.Resources;

@SuppressWarnings("serial")
public class MainPanel extends AstroPanel {
	
	public MainPanel(Main parent, boolean orientation) {
		super(parent, orientation);
		JLabel t = new JLabel("Monday");
		t.setFont(Resources.titleFont);
		t.setForeground(Resources.titleColor);
		add(t);
		setBackground(Resources.bgColor);
	}
	
	public void changeOrientation(boolean orientation) {
		
	}
	
}
