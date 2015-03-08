import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferedImage;

public class CopyGUI extends JFrame implements ActionListener {
    JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                BufferedImage image = null;
                try {                
                    image = ImageIO.read(new File("C:/Users/Damon/Desktop/background2.jpg"));
                } catch (IOException ex) {
                    // handle exception...
                }            
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters    
            }                
        };
    JPanel Settings = new JPanel();     
    JPanel Search = new JPanel(); 
    JPanel CurrLoc = new JPanel();
    JPanel Temp = new JPanel();
    JPanel Wind = new JPanel();
    JPanel Support = new JPanel();
    JPanel About = new JPanel();
    JPanel Feedback = new JPanel();
    JPanel Help = new JPanel();
    JButton back = new JButton();
    JButton tempbut = new JButton("Temperature");
    JButton windbut = new JButton("Wind Speed");
    JButton suppbut = new JButton("SUPPORT");
    JButton aboutbut = new JButton("About this app");
    JButton feedbackbut = new JButton("Feedback");
    JButton helpbut = new JButton("Help");
    JCheckBox locationBox = new JCheckBox(); 
    JLabel panelText = new JLabel("     SETTINGS");
    JLabel suppText = new JLabel("     SUPPORT");
    JLabel locationText = new JLabel("     Show current Location");
    JLabel locallText = new JLabel("     Show current location");
    JTextField txt = new JTextField();
    JTextField tempText = new JTextField("     Celcius");
    JTextField windText = new JTextField("     Miles per hour");
    Font myFont = new Font("Kreativ", Font.BOLD, 14);
    public static void main(String[] args) {
        CopyGUI app = new CopyGUI();
        app.startApp();
    }
    
    public CopyGUI() {
        super("Settings");
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    
    public void startApp() {
        Container c = getContentPane();
        //Set the labels to the left
        panelText.setFont(myFont);
        suppText.setFont(myFont);
        tempbut.setHorizontalAlignment(SwingConstants.LEFT);
        windbut.setHorizontalAlignment(SwingConstants.LEFT);
        suppbut.setHorizontalAlignment(SwingConstants.LEFT); 
        aboutbut.setHorizontalAlignment(SwingConstants.LEFT);
        feedbackbut.setHorizontalAlignment(SwingConstants.LEFT);
        helpbut.setHorizontalAlignment(SwingConstants.LEFT);
    
        panel.setLayout(new GridLayout(9, 1));
        
       
        
        
        Search.setLayout(new GridLayout(1, 2));
        Search.setBackground(new Color(36,102,176));
        Search.setBorder(BorderFactory.createLineBorder(Color.black));
        Search.add(back);
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setHorizontalAlignment(SwingConstants.LEFT);
        panel.add(Search); 
        
        
        Settings.setLayout(new GridLayout(1, 1));
        Settings.setBackground(new Color(0,0,0,0));
        Settings.setBorder(BorderFactory.createLineBorder(Color.black));
        Settings.add(panelText);
        panelText.setForeground(Color.white);
        panel.add(Settings); 
         
         
        CurrLoc.setLayout(new GridLayout(2, 2));
        CurrLoc.setBackground(new Color(0,0,0,0));
        CurrLoc.setBorder(BorderFactory.createLineBorder(Color.black));
        locationText.setForeground(Color.white);
        locallText.setForeground(Color.gray);
        CurrLoc.add(locationText);
        locationBox.setHorizontalAlignment(SwingConstants.CENTER);
        locationBox.setBackground(new Color(0,0,0,0));
        CurrLoc.add(locationBox);
        CurrLoc.add(locallText);
        
        panel.add(CurrLoc); 
        
        Temp.setLayout(new GridLayout(2, 1));
        Temp.setBorder(BorderFactory.createLineBorder(Color.black));
        Temp.setBackground(new Color(0,0,0,0));
        tempbut.setOpaque(false);
        tempbut.setContentAreaFilled(false);
        tempbut.setBorderPainted(false);
        tempbut.setForeground(Color.white);
        Temp.add(tempbut);
        tempText.setForeground(Color.gray);
        Temp.add(tempText);
        tempText.setBackground(new Color(0,0,0,0));
        tempText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        panel.add(Temp); 
        
        Wind.setLayout(new GridLayout(2, 1));
        Wind.setBorder(BorderFactory.createLineBorder(Color.black));
        Wind.setBackground(new Color(0,0,0,0));
        windbut.setOpaque(false);
        windbut.setContentAreaFilled(false);
        windbut.setBorderPainted(false);
        windbut.setForeground(Color.white);
        Wind.add(windbut);
        windText.setForeground(Color.gray);
        Wind.add(windText);
        windText.setBackground(new Color(0,0,0,0));
        windText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        panel.add(Wind); 
        
        Support.setLayout(new GridLayout(1, 1));
        Support.setBorder(BorderFactory.createLineBorder(Color.black));
        Support.setBackground(new Color(0,0,0,0));
        Support.add(suppText);
        suppText.setForeground(Color.white);
        panel.add(Support);
        
        About.setLayout(new GridLayout(1, 1));
        About.setBackground(new Color(0,0,0,0));
        About.setBorder(BorderFactory.createLineBorder(Color.black));
        aboutbut.setOpaque(false);
        aboutbut.setContentAreaFilled(false);
        aboutbut.setBorderPainted(false);
        aboutbut.setForeground(Color.white);
        About.add(aboutbut);
        panel.add(About); 
        
        Feedback.setLayout(new GridLayout(1, 1));
        Feedback.setBackground(new Color(0,0,0,0));
        feedbackbut.setOpaque(false);
        feedbackbut.setContentAreaFilled(false);
        feedbackbut.setBorderPainted(false);
        feedbackbut.setForeground(Color.white);
        Feedback.setBorder(BorderFactory.createLineBorder(Color.black));
        Feedback.add(feedbackbut);
        panel.add(Feedback);
        
        
        Help.setLayout(new GridLayout(1, 1));
        Help.setBackground(new Color(0,0,0,0));
        Help.setBorder(BorderFactory.createLineBorder(Color.black));
        helpbut.setOpaque(false);
        helpbut.setContentAreaFilled(false);
        helpbut.setBorderPainted(false);
        helpbut.setForeground(Color.white);
        Help.add(helpbut);
        panel.add(Help); 
        
        
        c.add(panel);
        back.setIcon(new ImageIcon("C:/Users/Damon/Desktop/back.png"));
        back.addActionListener(this);
        tempbut.addActionListener(this);  
        windbut.addActionListener(this); 
        suppbut.addActionListener(this);
        aboutbut.addActionListener(this);
        feedbackbut.addActionListener(this);  
        helpbut.addActionListener(this); 
        locationBox.addActionListener(this); 
        
        
        
        
        this.setSize(320, 480);
        this.setResizable(false);
        this.setVisible(true);
         
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
            if (e.getSource().equals(back)) {
           
             back.setIcon(new ImageIcon("C:/Users/Damon/Desktop/back1.png"));
        }
        else if (e.getSource().equals(tempbut)) {
           TempFrame jtemp = new TempFrame();
            jtemp.setVisible(true); 
        }
        else if (e.getSource().equals( windbut)) {
            WindFrame jwind = new WindFrame();
            jwind.setVisible(true);
        }
         else if (e.getSource().equals( suppbut)) {
          
        }
         else if (e.getSource().equals(  aboutbut)) {
           
        }
         else if (e.getSource().equals( feedbackbut)) {
          
        }
         else if (e.getSource().equals(  helpbut)) {
           
        }
        else if (e.getSource().equals(  locationBox)) {
           
        }
        
    }
}
