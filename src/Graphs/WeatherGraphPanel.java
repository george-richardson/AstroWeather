package Graphs;

import AstroWeather.Main;
import Common.AstroPanel;
import Home.MainPanel;
import Home.TopButton;
import NewAPI.Forecast;
import org.jfree.data.xy.XYSeries;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
@SuppressWarnings("serial")


public abstract class WeatherGraphPanel extends AstroPanel {

    private ActionListener backListener = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            parent.changePanel(new MainPanel(parent, orientation, false, 1));
        }
    };

    private final XYSeries series;
    private final String valueLabel;

    public WeatherGraphPanel(Main parent, boolean orientation, String valueLabel, Forecast.data[] hourlyForecastData) {
        super(parent, orientation);
        this.valueLabel = valueLabel;
        this.series = collectDataByHour(hourlyForecastData, valueLabel);
        layoutGraph();
    }

    private void layoutGraph() {
        removeAll();
        setLayout(new BorderLayout());
        add(createTopRibbon(), BorderLayout.NORTH);
        add(new WeatherGraph(valueLabel, series), BorderLayout.CENTER);
    }

    private JPanel createTopRibbon() {
        JPanel ribbon = new JPanel();
        ribbon.setLayout(new BorderLayout());
        ribbon.setOpaque(false);
        ribbon.add(createBackButton(), BorderLayout.WEST);
        ribbon.add(new WeatherGraphTitleLabel(valueLabel), BorderLayout.CENTER);
        return ribbon;
    }

    private JButton createBackButton() {
        JButton back = new TopButton("backarrow.png");
        back.setHorizontalAlignment(SwingConstants.LEFT);
        back.addActionListener(backListener);
        return back;
    }

    @Override
    public void changeOrientation(boolean orientation) {
        this.orientation = orientation;
        layoutGraph();
    }

    private XYSeries collectDataByHour(Forecast.data[] hourlyForecastData, String valueLabel) {
        XYSeries dataByHour = new XYSeries(valueLabel);
        for (Forecast.data forecast : hourlyForecastData) {
            dataByHour.add(forecast.getTimeInMillisecondsSinceEpoch(), extractValue(forecast));
        }
        return dataByHour;
    }

    /**
     * @return the value displayed on the y-axis for this weather graph
     */
    protected abstract double extractValue(Forecast.data forecast);
}
