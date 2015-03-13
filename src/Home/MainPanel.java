package Home;

import API.Forecast;
import API.Forecasts;
import AstroWeather.Main;
import Common.AstroPanel;
import Common.Resources;
import Graphs.HumidityByHour;
import Graphs.PrecipitationByHour;
import Graphs.TemperatureByHour;
import Location.LocationPanel;
import Settings.SettingsMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class MainPanel extends AstroPanel {
	private JPanel currentDay, otherDays, hourScroll, buttonGrid, topPanel;
	private JLabel currentDayLabel;
	private JScrollPane dayScrollPane;
	private HomeButton windBtn, tempBtn, cloudCoverBtn, lunarBtn, precipBtn, humidityBtn;
    private HourButton[] hourButtons;
    private DayPanel[] dayPanels;
    private NewAPI.Forecast.data[] hourData;
    private NewAPI.Forecast.data[] dayData;
    private TopButton settingsButton, backButton;

	public MainPanel(final Main parent, final boolean orientation, boolean loadHour, int numberToLoad) {
		super(parent, orientation);
        hourData = parent.getForecast().getHourly().getData();
        dayData = parent.getForecast().getDaily().getData();

        UIManager.put("ScrollBar.width", new Integer(0));

        hourButtons = new HourButton[48];
        for (int i = 0 ; i < 48; i++) {
            HourButton hour = new HourButton(hourData[i].getTimeAsHour());
            final int number = i;
            hour.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    parent.changePanel(new MainPanel(parent, orientation, true, number));
                }
            });
            hourButtons[i] = hour;
        }

        dayPanels = new DayPanel[7];
        for (int i = 0 ; i < 7; i++) {
            final int number = i;
            DayPanel day = new DayPanel(dayData[i].getTimeAsDay(), dayData[i].getCloudCoverAsInt(), (int) dayData[i].getTemperatureMax());
            day.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    parent.changePanel(new MainPanel(parent, orientation, false, number));
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
            dayPanels[i] = day;
        }

        currentDay = new JPanel();
        currentDay.setOpaque(false);
        currentDay.setLayout(new BorderLayout());

        settingsButton = new TopButton("settings.png");
        settingsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.changePanel(new SettingsMain(parent, orientation));
            }
        });
        backButton = new TopButton("backarrow.png");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.changePanel(new LocationPanel(parent, orientation));
            }
        });

        topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        topPanel.add(settingsButton, BorderLayout.EAST);
        topPanel.add(backButton, BorderLayout.WEST);

        otherDays = new JPanel(new GridLayout(7, 1));
        otherDays.setOpaque(false);
        for(int i = 0; i < 7; i++) {
            otherDays.add(dayPanels[i]);
        }

        dayScrollPane = new JScrollPane(otherDays);
        dayScrollPane.setBorder(null);
        dayScrollPane.setOpaque(false);
        dayScrollPane.getViewport().setOpaque(false);
        dayScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        dayScrollPane.getVerticalScrollBar().setUnitIncrement(16);

        currentDay.add(topPanel, BorderLayout.NORTH);
        if (loadHour) loadHour(numberToLoad);
        else loadDay(numberToLoad);
		if (orientation) portraitInit();
		else landscapeInit();
	}

	public void loadDay(int day) {
        NewAPI.Forecast.data thisDayData = dayData[day];
		currentDayLabel = new DayLabel(thisDayData.getTimeAsDay());
		topPanel.add(currentDayLabel, BorderLayout.CENTER);

		cloudCoverBtn = new CloudCoverageButton(thisDayData.getCloudCoverAsInt());
		lunarBtn = new MoonPhaseButton(thisDayData.getMoonPhaseAsAngle());
		windBtn = new WindDirectionButton();
		tempBtn = new TemperatureButton((int)thisDayData.getTemperatureMax());
        tempBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change(new TemperatureByHour(parent, orientation, forecasts));
            }
        });
		humidityBtn = new HumidityButton(thisDayData.getHumidityAsPercentage());
        humidityBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //change(new HumidityByHour(parent, orientation, forecasts));
            }
        });
		precipBtn = new PrecipitationButton(thisDayData.getPrecipProbabilityAsPercentage());
        precipBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change(new PrecipitationByHour(parent, orientation, forecasts));
            }
        });


	}

    public void loadHour(int hour) {
        NewAPI.Forecast.data thisHourData = hourData[hour];

        currentDayLabel = new DayLabel(thisHourData.getTimeAsHour());
        currentDay.add(currentDayLabel, BorderLayout.NORTH);

        cloudCoverBtn = new CloudCoverageButton(thisHourData.getCloudCoverAsInt());
        lunarBtn = new MoonPhaseButton(parent.getForecast().getDaily().getData()[0].getMoonPhaseAsAngle());
        windBtn = new WindDirectionButton();
        tempBtn = new TemperatureButton((int)thisHourData.getTemperature());
        tempBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change(new TemperatureByHour(parent, orientation, forecasts));
            }
        });
        humidityBtn = new HumidityButton(thisHourData.getHumidityAsPercentage());
        humidityBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change(new HumidityByHour(parent, orientation, forecasts));
            }
        });
        precipBtn = new PrecipitationButton(thisHourData.getPrecipProbabilityAsPercentage());
        precipBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //change(new PrecipitationByHour(parent, orientation, forecasts));
            }
        });
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

		hourScroll = new JPanel(new GridLayout(1, 48));
		hourScroll.setOpaque(false);

        for (int i = 0; i < hourButtons.length; i++) {
            hourScroll.add(hourButtons[i]);
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

		for (int i = 0; i < hourButtons.length; i++) {
			hourScroll.add(hourButtons[i]);
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

	public void changeOrientation(boolean newOrientation) {
		orientation = !orientation;
		removeAll();
		if (orientation) portraitInit();
		else landscapeInit();
	}
}
