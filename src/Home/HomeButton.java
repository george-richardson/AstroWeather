package Home;

import Common.Resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("serial")
public class HomeButton extends JButton {
	public HomeButton(Icon icon, String label) {
		super(label, icon);
		commonInit();
	}
	
	public HomeButton(String label, String value) {
		super("<html><div style='text-align:center;font-family=" + Resources.titleFont.getFontName() + "'><span style='font-size:4em;'>"
				+ value.substring(0, value.length()-1) + "</span>" + value.substring(value.length()-1) + "<br>"
				+ label + "</div></html>");
		commonInit();
	}
	
	private void commonInit() {
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setVerticalTextPosition(JButton.BOTTOM);
		setHorizontalTextPosition(JButton.CENTER);
		setHorizontalAlignment(JButton.CENTER);
		setFont(Resources.homeButtonFont);
		setForeground(Resources.titleColor);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(100, 100);
	}
	
	@Override
	public Dimension getMinimumSize() {
		return new Dimension(100, 100);
	}
	
	public static Icon createIcon(String filePath) {
		try {
			return new ImageIcon(ClassLoader.getSystemResource(filePath));
		} catch (Exception e) {
			System.err.println("ERR: COULD NOT FIND ICON FILE");
			return null;
		}
	}
}
