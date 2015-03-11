package AstroWeather;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Common.AstroPanel;
import Common.Resources;
import Location.LocationPanel;

@SuppressWarnings("serial")
public class Main extends JFrame {
	
	private boolean orientation;
	private AstroPanel p;
	private static final int lh = 320, lw = 480, ph = 480, pw = 320;


	public static void main(String[] args) {
		new Main();
	}
	
	private Main() {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(Resources.homeButtonFont);
		

		orientation = true;
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		JButton switchOrientationBtn = new JButton("Switch Orientation");
		switchOrientationBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				switchOrientation();
			}
		});
		
		add(switchOrientationBtn, BorderLayout.SOUTH);
		p = new LocationPanel(this, orientation);
		changeDimensions();
		add(p, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	
	private void switchOrientation() {
		orientation = !orientation;
		changeDimensions();
		p.changeOrientation(orientation);
		pack();
	}
	
	private void changeDimensions() {
		Dimension d;
		if (orientation) d = new Dimension(pw, ph);
		else d = new Dimension(lw, lh);
		p.setMinimumSize(d);
		p.setPreferredSize(d);
		p.setMaximumSize(d);
	}
	
	public void changePanel(AstroPanel newPanel) {
		remove(p);
		p = newPanel;
		add(p, BorderLayout.CENTER);
		
		// Do not ask me why this works. Wizardry i expect.
//		setVisible(false);
//		switchOrientation();
//		switchOrientation();
//		setVisible(true);
		// Do not ask me why this doesnt work
		changeDimensions();
		pack();
	}

}
