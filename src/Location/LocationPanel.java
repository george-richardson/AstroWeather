package Location;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import API.Forecasts;
import AstroWeather.Main;
import Common.AstroPanel;
import Common.Resources;
import Home.MainPanel;

@SuppressWarnings("serial")
public class LocationPanel extends AstroPanel {

	private ActionListener goButtonAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				removeAll();
				add(loading, BorderLayout.CENTER);
				validate();
				repaint();
				Thread t = new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							String city = locationField.getText();
							parent.changePanel(new MainPanel(parent, orientation, new Forecasts(city)));
							Scanner s = new Scanner(new File("previousSearches.txt"));
							PrintWriter pw = new PrintWriter("temp.txt");
							pw.println(city);
							int i = 0;
							while(s.hasNextLine() && i < 7) {
								String str = s.nextLine();
								System.out.println(str);
								pw.println(str);
								i++;
							}
							s.close();
							pw.close();
							Path from = new File("temp.txt").toPath();
							Path to = new File("previousSearches.txt").toPath();
							
							Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
						} catch (Exception e) {
							parent.changePanel(new LocationPanel(parent, orientation));
						}
					}
				});
				t.start();
				
			} catch (Exception ex) {
				
			}
		}
	};
	
	private ActionListener prevButtonAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				removeAll();
				add(loading, BorderLayout.CENTER);
				validate();
				repaint();
				Thread t = new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							String city = ((JButton)e.getSource()).getText();
							parent.changePanel(new MainPanel(parent, orientation, new Forecasts(city)));
						} catch (Exception e) {
							parent.changePanel(new LocationPanel(parent, orientation));
						}
					}
				});
				t.start();
				
			} catch (Exception ex) {
				
			}
		}
	};

	private JTextField locationField = new JTextField();
	private JPanel loading;

	public LocationPanel(Main parent, boolean orientation) {
		super(parent, orientation, null);
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		locationField.setOpaque(false);
		locationField.setFont(Resources.titleFont);
		locationField.setForeground(Resources.titleColor);
		locationField.setBorder(BorderFactory.createCompoundBorder(locationField.getBorder(), new EmptyBorder(5, 3, 3, 3)));
		
		JButton goBtn = new JButton("Go");
		goBtn.setOpaque(false);
		goBtn.setFont(Resources.titleFont);
		goBtn.setForeground(Resources.titleColor);
		goBtn.setContentAreaFilled(false);
		goBtn.addActionListener(goButtonAction);
		
		JPanel topPanel = new JPanel(new BorderLayout());
		topPanel.add(locationField, BorderLayout.CENTER);
		
		JPanel previouslyPanel = new JPanel(new GridLayout(8, 1));
		previouslyPanel.setOpaque(false);
		try {
			Scanner s = new Scanner(new File("previousSearches.txt"));
			int i = 0;
			while(s.hasNextLine()&& i < 8) {
				JButton btn = new PreviousLocationButton(s.nextLine());
				btn.addActionListener(prevButtonAction);
				previouslyPanel.add(btn);
			}
			s.close();
		} catch (Exception e) {} 
		
		topPanel.add(goBtn, BorderLayout.EAST);
		topPanel.setOpaque(false);
		add(topPanel, BorderLayout.NORTH);
		add(previouslyPanel, BorderLayout.CENTER);
		
		loading = new JPanel(new BorderLayout());
		loading.setOpaque(false);
		try {
			loading.add(new JLabel(new ImageIcon(new File("assets/loader.gif").toURI().toURL())), BorderLayout.CENTER);		
		} catch (Exception e) {}
		
	}

	@Override
	public void changeOrientation(boolean orientation) {
		this.orientation = orientation;
	}

}
