import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferedImage;
 
public class WindFrame extends JFrame implements ActionListener
{
     JPanel panel2 = new JPanel();
     JPanel UniPanel = new JPanel();
     JPanel Speed = new JPanel();
     JPanel Speed1 = new JPanel();
     JPanel Cance = new JPanel();
     JRadioButton mph = new JRadioButton("Miles per hour");
     JRadioButton kph = new JRadioButton("Kilometers per hour");
     JRadioButton celciusbut = new JRadioButton();
     JRadioButton fahrenbut = new JRadioButton();
     JButton cancel = new JButton("Cancel");
     JLabel windLabel = new JLabel("Wind Speed");    
    public static void main(String[] args) {
      WindFrame application = new WindFrame();
        application.startApp();
    }
    
    
    public void startApp() {
    Container c = getContentPane();
    panel2.setLayout(new GridLayout(4, 1));
    panel2.setBackground(new Color(40,40,40));
    windLabel.setForeground(new Color(51,181,229));
    UniPanel.setLayout(new GridLayout(1, 1));
    UniPanel.add(windLabel);
    UniPanel.setOpaque(false);
    UniPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(51,181,229)));
    panel2.add(UniPanel);
    
    Speed.setLayout(new GridLayout(1,1)); 
    Speed.add(mph);
    Speed.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(60,60,60)));
    mph.setOpaque(false);
    mph.setForeground(Color.white);
    Speed.setOpaque(false);
    panel2.add(Speed);
    
    Speed1.setLayout(new GridLayout(1,1)); 
    Speed1.add(kph);
    kph.setOpaque(false);
    kph.setForeground(Color.white);
    Speed1.setOpaque(false);
    panel2.add(Speed1);
    
    
    
    
    
    Cance.setLayout(new GridLayout(1,1)); 
    Cance.setOpaque(false);
    Cance.add(cancel);
    cancel.setContentAreaFilled(false);
    cancel.setBorderPainted(false);
    cancel.setOpaque(false);
    cancel.setForeground(Color.white);
    Cance.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, new Color(60,60,60)));
    panel2.add(Cance);
    
    c.add(panel2);
    this.setSize(200, 170);
    this.setResizable(false);
    this.setVisible(true);
    mph.addActionListener(this);
    kph.addActionListener(this);
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {}
}
