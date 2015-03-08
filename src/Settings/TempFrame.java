import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferedImage;
 
public class TempFrame extends JFrame 
{
     JPanel panel1 = new JPanel();
     JPanel UniPanel = new JPanel();
     JPanel Calc = new JPanel();
     JPanel Calc1 = new JPanel();
     JPanel Cance = new JPanel();
     JRadioButton celsius = new JRadioButton("Celsius");
     JRadioButton fahrenheit = new JRadioButton("Fahrenheit");
     JRadioButton celciusbut = new JRadioButton();
     JRadioButton fahrenbut = new JRadioButton();
     JButton cancel = new JButton("Cancel");
     JLabel tempLabel = new JLabel("Temperature");    
    public static void main(String[] args) {
       TempFrame application = new TempFrame();
        application.startApp();
    }
    
    
    public void startApp() {
    Container c1 = getContentPane();
    panel1.setLayout(new GridLayout(4, 1));
    panel1.setBackground(new Color(40,40,40));
    
    UniPanel.setLayout(new GridLayout(1, 1));
    UniPanel.add(tempLabel);
    tempLabel.setForeground(new Color(51,181,229));
    UniPanel.setOpaque(false);
    UniPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(51,181,229)));
    panel1.add(UniPanel);
     
    Calc.setLayout(new GridLayout(1,1)); 
    Calc.add(celsius);
    Calc.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(60,60,60)));
    celsius.setOpaque(false);
    celsius.setForeground(Color.white);
    Calc.setOpaque(false);
    panel1.add(Calc);
    
    
    Calc1.setLayout(new GridLayout(1,1)); 
    Calc1.add(fahrenheit);
    fahrenheit.setOpaque(false);
    fahrenheit.setForeground(Color.white);
    Calc1.setOpaque(false);
    panel1.add(Calc1);
    
    
     
     
    
    
    Cance.setLayout(new GridLayout(1,1)); 
    Cance.setOpaque(false);
    Cance.add(cancel);
    cancel.setContentAreaFilled(false);
    cancel.setBorderPainted(false);
    cancel.setOpaque(false);
    cancel.setForeground(Color.white);
    Cance.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0,new Color(60,60,60)));
    panel1.add(Cance);
    //
    c1.add(panel1);
    this.setSize(200, 170);
    this.setResizable(false);
    this.setVisible(true);
    }
}
