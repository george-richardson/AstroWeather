package Home;

import API.Forecasts;
import AstroWeather.Main;
import Common.AstroPanel;
import Common.Resources;
import Graphs.HumidityByHour;
import Graphs.PrecipitationByHour;
import Graphs.TemperatureByHour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class MainPanel extends AstroPanel {
	private JPanel currentDay, otherDays, hourScroll, buttonGrid;
	private JLabel currentDayLabel;
	private JScrollPane dayScrollPane;
	private HomeButton windBtn, tempBtn, cloudCoverBtn, lunarBtn, precipBtn, humidityBtn;

	public MainPanel(Main parent, boolean orientation, Forecasts forecasts) {
		super(parent, orientation, forecasts);
		commonInit();
		if (orientation) portraitInit();
		else landscapeInit();
	}

	public void commonInit() {
		UIManager.put("ScrollBar.width", new Integer(0));
		//setBackground(Resources.bgColor);

		// Current Day
		currentDay = new JPanel();
		currentDay.setOpaque(false);
		currentDay.setLayout(new BorderLayout());

		currentDayLabel = new JLabel("<html>Monday<span style='text-size: 18px'>02/02</span></html>");
		currentDayLabel.setFont(Resources.titleFont);
		currentDayLabel.setForeground(Resources.titleColor);
		currentDayLabel.setHorizontalAlignment(JLabel.CENTER);

		currentDay.add(currentDayLabel, BorderLayout.NORTH);

		cloudCoverBtn = new CloudCoverageButton(forecasts.getTodaysForecast());
		lunarBtn = new MoonPhaseButton();
		windBtn = new WindDirectionButton(forecasts.getTodaysForecast());
		tempBtn = new TemperatureButton(forecasts.getTodaysForecast());
        tempBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change(new TemperatureByHour(parent, orientation, forecasts));
            }
        });
		humidityBtn = new HumidityButton(forecasts.getTodaysForecast());
        humidityBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change(new HumidityByHour(parent, orientation, forecasts));
            }
        });
		precipBtn = new PrecipitationButton(forecasts.getTodaysForecast());
        precipBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                change(new PrecipitationByHour(parent, orientation, forecasts));
            }
        });

		otherDays = new JPanel(new GridLayout(10, 1));
		otherDays.setOpaque(false);

		for (int i = 0; i < 10; i++) {
			otherDays.add(new DayPanel());
		}

		dayScrollPane = new JScrollPane(otherDays);
		dayScrollPane.setBorder(null);
		dayScrollPane.setOpaque(false);
		dayScrollPane.getViewport().setOpaque(false);
		dayScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		dayScrollPane.getVerticalScrollBar().setUnitIncrement(16);

	}

	public void portraitInit() {
		buttonGrid = new JPanel(new GridLayout(2, 3));
		buttonGrid.setOpaque(false);
		buttonGrid.add(cloudCoverBtn);
		buttonGrid.add(lunarBtn);
		buttonGrid.add(windBtn);
		buttonGrid.add(tempBtn);
		buttonGrid.add(humidityBtn);
		buttonGrid.add(precipBtn);
		currentDay.add(buttonGrid, BorderLayout.CENTER);

		hourScroll = new JPanel(new GridLayout(1, 10));
		hourScroll.setOpaque(false);

		hourScroll.add(new HourButton("20", true));
		for (int i = 0; i < 9; i++) {
			hourScroll.add(new HourButton("20"));
		}

		JScrollPane hourScrollPane = new JScrollPane(hourScroll);
		hourScrollPane.setOpaque(false);
		hourScrollPane.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Resources.titleColor));
		hourScrollPane.getViewport().setOpaque(false);
		hourScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		hourScrollPane.getHorizontalScrollBar().setUnitIncrement(16);

		// Set Layout.
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Add Panels to main panel
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 50;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(currentDay, gbc);

		gbc.gridy = 1;
		gbc.weighty = 80;
		add(hourScrollPane, gbc);

		gbc.gridy = 2;
		gbc.weighty = 250;
		add(dayScrollPane, gbc);
	}

	public void landscapeInit() {
		buttonGrid = new JPanel(new GridLayout(3, 2));
		buttonGrid.setOpaque(false);
		buttonGrid.add(cloudCoverBtn);
		buttonGrid.add(tempBtn);
		buttonGrid.add(lunarBtn);
		buttonGrid.add(humidityBtn);
		buttonGrid.add(windBtn);
		buttonGrid.add(precipBtn);
		currentDay.add(buttonGrid, BorderLayout.CENTER);

		hourScroll = new JPanel(new GridLayout(10, 1));
		hourScroll.setOpaque(false);

		hourScroll.add(new HourButton("20", true));
		for (int i = 0; i < 9; i++) {
			hourScroll.add(new HourButton("20"));
		}

		JScrollPane hourScrollPane = new JScrollPane(hourScroll);
		hourScrollPane.setBorder(null);
		hourScrollPane.setOpaque(false);
		hourScrollPane.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 1, Resources.titleColor));
		hourScrollPane.getViewport().setOpaque(false);
		hourScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		hourScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		hourScrollPane.getVerticalScrollBar().setUnitIncrement(16);

		// Set Layout.
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// Add Panels to main panel
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 1;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.BOTH;
		add(currentDay, gbc);

		gbc.gridx = 1;
		gbc.weightx = 60;
		add(hourScrollPane, gbc);

		gbc.gridx = 2;
		gbc.weightx = 250;
		add(dayScrollPane, gbc);
	}

	public void changeOrientation(boolean orientation) {
		this.orientation = orientation;
		removeAll();
		if (orientation) portraitInit();
		else landscapeInit();
	}
}
