package Graphs;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.data.xy.XYSeries;

class test extends JFrame {
	public test() {
		setTitle("app");
		setSize(480, 320); // default size is 0,0
		setLocation(10, 200); // default is 0,0 (top left corner)
	}

	public static void main(String[] args) {
		JFrame f = new test();
		f.setResizable(false);
		JPanel panel = JPanelWithBackground.load("C:/Users/Beneen/GUI project/background.png");
		panel.add(new TemperatureGraph(createDataset()));
		f.setContentPane(panel);
		f.setVisible(true);
	}
	
	private static XYSeries createDataset() {
		// TODO: get data from API
		XYSeries series = new XYSeries("Temperature");
		series.add(1.0, 1.0);
		series.add(2.0, 4.0);
		series.add(3.0, 3.0);
		series.add(4.0, 5.0);
		series.add(5.0, 5.0);
		return series;
	}
}