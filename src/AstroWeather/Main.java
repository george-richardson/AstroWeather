package AstroWeather;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Common.AstroPanel;

@SuppressWarnings("serial")
public class Main extends JFrame {
	
	private boolean orientation;
	private AstroPanel p;
	
	private static final int LANDSCAPE_HEIGHT = 393;
	private static final int LANDSCAPE_WIDTH = 498;
	private static final int PORTRAIT_HEIGHT = 553;
	private static final int PORTRAIT_WIDTH = 338;

	public static void main(String[] args) {
		new Main();
	}
	
	private Main() {
		setSize(PORTRAIT_WIDTH, PORTRAIT_HEIGHT);
		orientation = true;
		setLocationRelativeTo(null);
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
		add(p);
		validate();
		setVisible(true);
		printSize();
		
	}

	
	private void switchOrientation() {
		if (orientation) setSize(LANDSCAPE_WIDTH, LANDSCAPE_HEIGHT);
		else setSize(PORTRAIT_WIDTH, PORTRAIT_HEIGHT);
		orientation = !orientation;
		validate();
		printSize();
		
	}
	
	public void changePanel(AstroPanel p) {
		this.remove(this.p);
		add(p, BorderLayout.CENTER);
	}

	// Used to check if the panel is the correct size.
	private void printSize() {
		System.out.println();
		int h = p.getSize().height;
		int w = p.getSize().width;
		int optimalh, optimalw;
		if (!orientation) System.out.println("Landscape");
		else System.out.println("Portrait");
		System.out.println("h" + h + " w" + w);
		if (!orientation) {
			optimalh = 320 + Math.abs(320 - h);
			optimalw = 480 + Math.abs(480 - w);
		} else {
			optimalh = 480 + Math.abs(480 - h);
			optimalw = 320 + Math.abs(320 - w);
		}
		System.out.println("oh" + optimalh + " ow" + optimalw);
	}

}
