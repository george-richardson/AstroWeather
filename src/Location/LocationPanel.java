package Location;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import AstroWeather.Main;
import Common.AstroPanel;
import Common.Resources;
import Home.MainPanel;

@SuppressWarnings("serial")
public class LocationPanel extends AstroPanel {
	private ActionListener actionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			parent.changePanel(new MainPanel(parent, orientation));
		}
	};
	
	public LocationPanel(Main parent, boolean orientation) {
		super(parent, orientation);
		setLayout(new BorderLayout());
		setBackground(Resources.bgColor);
		JPanel topPanel = new JPanel(new BorderLayout());
		JTextField locationField = new JTextField();
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
