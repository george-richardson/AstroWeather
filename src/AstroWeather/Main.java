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
import Home.MainPanel;

@SuppressWarnings("serial")
public class Main extends JFrame {
	
	private boolean orientation;
	private AstroPanel p;
	private static final Dimension landscapeDimension = new Dimension(480, 320), portraitDimension = new Dimension(320, 480);


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
		p = new MainPanel(this, orientation);
		p.setMinimumSize(new Dimension(320, 480));
		p.setPreferredSize(new Dimension(320, 480));
		p.setMaximumSize(new Dimension(320, 480));
		add(p, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	
	private void switchOrientation() {
		if (orientation) changeDimensions(landscapeDimension);
		else changeDimensions(portraitDimension);

		orientation = !orientation;
		p.changeOrientation(orientation);
		pack();		
	}
	
	private void changeDimensions(Dimension d) {
		p.setMinimumSize(d);
		p.setPreferredSize(d);
		p.setMaximumSize(d);
	}
	
	public void changePanel(AstroPanel p) {
		this.remove(this.p);
		add(p, BorderLayout.CENTER);
	}

}
