package Location;

import Common.Resources;

import javax.swing.*;

@SuppressWarnings("serial")
public class PreviousLocationButton extends JButton {
	public PreviousLocationButton(String label) {
		super(label);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setHorizontalTextPosition(JButton.CENTER);
		setFont(Resources.titleFont);
		setForeground(Resources.titleColor);
	}
}
