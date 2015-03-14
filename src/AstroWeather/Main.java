package AstroWeather;

import Common.AstroPanel;
import Common.Resources;
import Home.MainPanel;
import Location.LocationPanel;
import NewAPI.Forecast;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.net.URLClassLoader;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private boolean orientation;
	private AstroPanel p;
	private static final int lh = 320, lw = 480, ph = 480, pw = 320;
    private Forecast forecast;


	public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
            System.out.println(url.getFile());
        }
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
		p = new LocationPanel(this);
		changeDimensions();
		add(p, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}


	private void switchOrientation() {
		orientation = !orientation;
		changeDimensions();
        if(p instanceof MainPanel) ((MainPanel) p).changeOrientation();
        getContentPane().revalidate();
		pack();
        repaint();
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
        changeDimensions();
        add(p, BorderLayout.CENTER);
		pack();
	}

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }

    public boolean getOrientation() {
        return orientation;
    }
}
