package Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class TemperatureFrame extends JDialog implements ActionListener {
    private JRadioButton celsius = new JRadioButton("Celsius");
    private JRadioButton fahrenheit = new JRadioButton("Fahrenheit");
    private JButton confirm = new JButton("Confirm");
    public static final int CELSIUS = 0;
    public static final int FAHRENHEIT = 1;
    private int metrics = TemperatureFrame.CELSIUS;
    private SettingsMain parent = null;
    private JLabel tempLabel = new JLabel("Temperature");
    private JPanel tempPanel = new JPanel();
    private JPanel celsiusPanel  = new JPanel();
    private JPanel fahrenheitPanel = new JPanel();
    private JPanel confirmPanel = new JPanel();
    public TemperatureFrame(JFrame frame, SettingsMain parent) {
    	super(frame);
    	setUndecorated(true);
    	this.parent = parent;
    	load();
    	setSize(new Dimension(200, 170));
    	setLocationRelativeTo(frame);
    	setVisible(true);
    }
    
	public void load() {
	    Container c = getContentPane();
	    c.setLayout(new GridLayout(4, 1));
	    c.setLayout(new GridLayout(4, 1));
        c.setBackground(new Color(40,40,40));
        
        tempPanel.setLayout(new GridLayout(1, 1));
        tempPanel.add(tempLabel);
        tempLabel.setForeground(new Color(51,181,229));
        tempPanel.setOpaque(false);
        tempPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(51,181,229)));
        c.add(tempPanel);
        
        celsiusPanel.setLayout(new GridLayout(1,1)); 
        celsiusPanel.add(celsius);
        celsiusPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(60,60,60)));
        celsiusPanel.setOpaque(false);
        celsius.setOpaque(false);
        celsius.setForeground(Color.white);
        c.add(celsiusPanel);
        
        fahrenheitPanel.setLayout(new GridLayout(1,1)); 
        fahrenheitPanel.add(fahrenheit);
        fahrenheitPanel.setOpaque(false);
        fahrenheit.setOpaque(false);
        fahrenheit.setForeground(Color.white);
        c.add(fahrenheit);
        
         confirmPanel.setLayout(new GridLayout(1,1)); 
         confirmPanel.setOpaque(false);
         confirmPanel.add(confirm);
         confirmPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, new Color(60,60,60)));
         confirm.setContentAreaFilled(false);
         confirm.setBorderPainted(false);
         confirm.setOpaque(false);
         confirm.setForeground(Color.white);
         c.add(confirmPanel);
	    //c.add(celsius);
	    //c.add(fahrenheit);
	    //c.add(ok);
	    this.setVisible(true);
	    
	    celsius.addActionListener(this);
	    fahrenheit.addActionListener(this);
	    confirm.addActionListener(this);
	}
	
	public int getMetrics() {
		return metrics;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(celsius)) {
			fahrenheit.setSelected(false);
			celsius.setSelected(true);
			metrics = TemperatureFrame.CELSIUS;
            SettingsModel.getInstance().setCelcius(true);
			setParentText();
		}
		else if (e.getSource().equals(fahrenheit)) {
			fahrenheit.setSelected(true);
			celsius.setSelected(false);
			metrics = TemperatureFrame.FAHRENHEIT;
            SettingsModel.getInstance().setCelcius(false);
			setParentText();
		}
		else if (e.getSource().equals(confirm)) {
			this.dispose();
			setParentText();
		}
	}
	
	public void setParentText() {
		parent.setTmperatureMetrics(metrics);
	}
}
