package Location;

import API.Forecasts;
import AstroWeather.Main;
import Common.AstroPanel;
import Common.Resources;
import Home.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class LocationPanel extends AstroPanel {

	private ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			parent.changePanel(new MainPanel(parent, orientation, new Forecasts(locationField.getText())));
		}
	};

	private JTextField locationField = new JTextField();

	public LocationPanel(Main parent, boolean orientation) {
		super(parent, orientation, null);
		setLayout(new BorderLayout());
		setBackground(Resources.bgColor);
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.add(locationField, BorderLayout.CENTER);
		JButton goBtn = new JButton("Go");
		goBtn.addActionListener(actionListener);
		topPanel.add(goBtn, BorderLayout.EAST);
		topPanel.setOpaque(false);
		add(topPanel, BorderLayout.NORTH);
	}

	@Override
	public void changeOrientation(boolean orientation) {
		this.orientation = orientation;
	}

}
