package Home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import AstroWeather.Main;
import Common.AstroPanel;
import Common.Resources;

@SuppressWarnings("serial")
public class MainPanel extends AstroPanel {
	private JPanel currentDay, otherDays, hourScroll;
	private JLabel currentDayLabel;
	private HomeButton windBtn, tempBtn, cloudCoverBtn, lunarBtn, precipBtn, humidityBtn;
	
	public MainPanel(Main parent, boolean orientation) {
		super(parent, orientation);
		commonInit();
		portraitInit();
	}
	
	public void commonInit() {
		setBackground(Resources.bgColor);
	}
	
	public void portraitInit() {
		// Set Layout.
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		// Create panels for different sections
		
		// Current Day
		currentDay = new JPanel();
		currentDay.setOpaque(false);
		currentDay.setLayout(new BorderLayout());
		currentDayLabel = new JLabel("Monday");
		currentDayLabel.setFont(Resources.titleFont);
		currentDayLabel.setForeground(Resources.titleColor);
		currentDay.add(currentDayLabel, BorderLayout.NORTH);

		
		JPanel buttonGrid = new JPanel(new GridLayout(2, 3));
		buttonGrid.setOpaque(false);
		cloudCoverBtn = new HomeButton(HomeButton.createIcon("moon75.png"), "Cloud");
		buttonGrid.add(cloudCoverBtn);
		lunarBtn = new HomeButton(HomeButton.createIcon("moon75.png"), "Lunar");
		buttonGrid.add(lunarBtn);
		windBtn = new HomeButton(HomeButton.createIcon("moon75.png"), "Wind");
		buttonGrid.add(windBtn);
		tempBtn = new HomeButton("Temp", "8°");
		buttonGrid.add(tempBtn);
		humidityBtn = new HomeButton("Humidity", "11%");
		buttonGrid.add(humidityBtn);
		precipBtn = new HomeButton("Rain", "80%");
		buttonGrid.add(precipBtn);
		currentDay.add(buttonGrid, BorderLayout.CENTER);
		
		hourScroll = new JPanel();
		hourScroll.setBackground(new Color(0, 0, 255));
		otherDays = new JPanel();
		otherDays.setBackground(new Color(0, 255, 0));
		
		// Add Panels to main panel
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 50;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(currentDay, gbc);
		
		gbc.gridy = 1;
		gbc.weighty = 80;
		add(hourScroll, gbc);
		
		gbc.gridy = 2;
		gbc.weighty = 250;
		add(otherDays, gbc);
	}
	
	public void changeOrientation(boolean orientation) {
		
	}
	
}
