package Home;

import java.awt.Insets;

import javax.swing.JButton;

import Common.Resources;

@SuppressWarnings("serial")
public class HourButton extends JButton {
	public HourButton(String s) {
		super(s);
		commonInit();
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Resources.titleColor);
	}
	
	public HourButton(String s, boolean d) {
		super(s);
		commonInit();
		setBackground(Resources.titleColor);
		setForeground(Resources.bgColor);
		
	}
	
	void commonInit() {
		setFont(Resources.titleFont);
		setHorizontalTextPosition(JButton.CENTER);
		setHorizontalAlignment(JButton.CENTER);
		setMargin(new Insets(5, 8, 5, 5));
	}
}
