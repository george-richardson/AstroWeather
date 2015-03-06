package Graphs;

import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.data.xy.XYSeries;

class test extends JFrame {
	public test() {
		setTitle("app");
		setSize(480, 320);
		setLocation(10, 200);
	}

	public static void main(String[] args) {
		JFrame f = new test();
		f.setResizable(false);
		JPanel panel = JPanelWithBackground.load("assets/background.png");
		panel.add(new TemperatureGraph(createDataset()));
		f.setContentPane(panel);
		f.setVisible(true);
	}

	private static XYSeries createDataset() {
		// TODO: get data from API
		XYSeries series = new XYSeries("Temperature");

		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		for (int i = 0; i < 24; i++) {
			series.add(calendar.getTimeInMillis(), Math.random() * 20);
			calendar.add(Calendar.HOUR, 1);
		}

		return series;
	}
}