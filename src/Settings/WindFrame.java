
package Settings;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.*;

public class WindFrame extends JFrame implements ActionListener {
    private JRadioButton kmPerHour = new JRadioButton("Kilometers per hour");
    private JRadioButton milesPerHour = new JRadioButton("Miles per hour");
    private JButton confirm = new JButton("Confirm");
    public static final int KMPERHOUR = 0;
    public static final int MILESPERHOUR = 1;
    private int metrics = WindFrame.KMPERHOUR ;
    private Main parent = null;
    private JLabel windLabel = new JLabel("Wind Speed");
    private JPanel windPanel = new JPanel();
    private JPanel kphPanel  = new JPanel();
    private JPanel mphPanel = new JPanel();
    private JPanel confirmPanel = new JPanel();
    

    public WindFrame(Main parent) {
        this.parent = parent;
    }
    
    public void load() {
        Container c = getContentPane();
        c.setLayout(new GridLayout(4, 1));
        c.setBackground(new Color(40,40,40));
         
        windPanel.setLayout(new GridLayout(1, 1));
        windPanel.add(windLabel);
        windLabel.setForeground(new Color(51,181,229));
        windPanel.setOpaque(false);
        windPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(51,181,229)));
        c.add(windPanel);
        
        kphPanel.setLayout(new GridLayout(1,1)); 
        kphPanel.add(kmPerHour);
        kphPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(60,60,60)));
        kphPanel.setOpaque(false);
        kmPerHour.setOpaque(false);
        kmPerHour.setForeground(Color.white);
        c.add(kphPanel);
        
        mphPanel.setLayout(new GridLayout(1,1)); 
        mphPanel.add(milesPerHour);
        mphPanel.setOpaque(false);
        milesPerHour.setOpaque(false);
        milesPerHour.setForeground(Color.white);
        c.add(mphPanel);
        
         confirmPanel.setLayout(new GridLayout(1,1)); 
         confirmPanel.setOpaque(false);
         confirmPanel.add(confirm);
         confirmPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, new Color(60,60,60)));
         confirm.setContentAreaFilled(false);
         confirm.setBorderPainted(false);
         confirm.setOpaque(false);
         confirm.setForeground(Color.white);
         c.add(confirmPanel);
        this.setVisible(true);
        
        kmPerHour.addActionListener(this);
        milesPerHour.addActionListener(this);
        confirm.addActionListener(this);
    }
    
    public int getMetrics() {
		return metrics;
	}
	
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(kmPerHour)) {
            milesPerHour.setSelected(false);
            kmPerHour.setSelected(true);
            metrics = WindFrame.KMPERHOUR;
            setParentText();
        }
        else if (e.getSource().equals(milesPerHour)) {
            milesPerHour.setSelected(true);
            kmPerHour.setSelected(false);
            metrics = WindFrame.MILESPERHOUR;
            setParentText();
        }
        else if (e.getSource().equals(confirm)) {
            this.dispose();
            setParentText();
        }
    }
    
    public void setParentText() {
       parent.setWindMetrics(metrics);
    }

}
