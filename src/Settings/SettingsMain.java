package Settings;

import Common.AstroPanel;
import Common.Resources;
import Home.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class SettingsMain extends AstroPanel implements ActionListener {
    private SettingsMainPanel mainPanel = new SettingsMainPanel();
    private SettingsMainPanel locationPanel = new SettingsMainPanel ();
    private JTextField tempText = new JTextField(SettingsModel.getInstance().isCelcius()?"Celsius":"Fahrenheit");
    private JTextField windText = new JTextField(SettingsModel.getInstance().isMph()?"Miles per hour":"Kilometers per hour");
    private JButton tempBut = new JButton("Temperatre");
    private JButton windBut = new JButton("Wind Speed");
    private JButton feedbackBut = new JButton("Feedback");
    private JButton aboutBut = new JButton("About this app");
    private JButton helpBut = new JButton("Help");
    private JLabel suppText = new JLabel("SUPPORT");
    private JLabel settingsLabel = new JLabel("SETTINGS");
    private JLabel locationText = new JLabel("    Show current Location");
    private JLabel locallText = new JLabel("Show current location");
    private JButton back = new JButton();
    private JPanel settingsPanel = new JPanel();     
    private JPanel headerPanel = new JPanel(); 
   
    private SettingsMainPanel Temp = new SettingsMainPanel();
    private SettingsMainPanel Wind = new SettingsMainPanel();
    private JPanel Support = new JPanel();
    private SettingsMainPanel About = new SettingsMainPanel();
    private SettingsMainPanel Feedback = new SettingsMainPanel();
    private SettingsMainPanel Help = new SettingsMainPanel();
    public static int CELSIUS = 0;
    public static int FAHRENHEIT = 1;
    public static int KM_PER_HOUR = 0;
    public static int MILES_PER_HOUR = 1;
    private int tempMetrics = CELSIUS;
    private int windMetrics = KM_PER_HOUR;
    
    private JCheckBox locationBox = new JCheckBox(); 
    
    Font myFont = new Font("Kreativ", Font.BOLD, 14);
    
    
    public static void main(String[] args) {
        //Main app = new Main();
        //app.startApp();
    }
    
    public SettingsMain(AstroWeather.Main parent) {
		super(parent);
		setLayout(new BorderLayout());
		startApp();
	}
    
//    public Main() {
//        super("Settings");
//        this.addWindowListener(new WindowAdapter(){
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
//    }

    public void startApp() {
        //Container c = getContentPane();
        tempBut.setHorizontalAlignment(SwingConstants.LEFT);
        windBut.setHorizontalAlignment(SwingConstants.LEFT);
        back.setIcon(Resources.getImage("settings/back.png"));
        headerPanel.setLayout(new GridLayout(1, 2));
        headerPanel.setBackground(new Color(36,102,176));
        headerPanel.add(back);
        back.setOpaque(false);
        back.setContentAreaFilled(false);
        back.setBorderPainted(false);
        back.setHorizontalAlignment(SwingConstants.LEFT);
        back.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {
                back.setIcon(Resources.getImage("settings/back1.png"));
              // back.setIcon(icon1);
            }
            public void mouseExited(MouseEvent evt)
            {
            back.setIcon(Resources.getImage("settings/back.png"));
            }
           
        });
        
        settingsPanel.setLayout(new GridLayout(1, 1));
        settingsPanel.setOpaque(false);
        settingsPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(51,181,229)));
        settingsPanel.add(settingsLabel);
        settingsLabel.setForeground(Color.white);
        
        Support.setLayout(new GridLayout(1, 1));
        Support.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, new Color(51,181,229)));
        Support.setBackground(new Color(0,0,0,0));
        Support.add(suppText);
        suppText.setForeground(Color.white);
        
        locationPanel.setLayout(new GridLayout(2, 2));
        locationPanel.setOpaque(false);
        locationText.setForeground(Color.white);
        locallText.setForeground(Color.gray);
        locationPanel.add(locationText);
        locationBox.setHorizontalAlignment(SwingConstants.CENTER);
        locationBox.setOpaque(false);
        locationBox.setContentAreaFilled(false);
        locationBox.setBorderPainted(false);
        locationPanel.add(locationBox);
        locationPanel.add(locallText);
        
        Temp.setLayout(new GridLayout(2, 1));
        Temp.setBackground(new Color(0,0,0,0));
        tempBut.setOpaque(false);
        tempBut.setContentAreaFilled(false);
        tempBut.setBorderPainted(false);
        tempBut.setForeground(Color.white);
        Temp.add(tempBut);
        Temp.add(tempText);
        
        Wind.setLayout(new GridLayout(2, 1));
        Wind.setBackground(new Color(0,0,0,0));
        windBut.setOpaque(false);
        windBut.setContentAreaFilled(false);
        windBut.setBorderPainted(false);
        windBut.setForeground(Color.white);
        Wind.add(windBut);
        Wind.add(windText);
      
        tempText.setForeground(Color.gray);
        tempText.setOpaque(false);
        tempText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        windText.setForeground(Color.gray);
        windText.setOpaque(false);;
        windText.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        About.setLayout(new GridLayout(1, 1));
        About.setBackground(new Color(0,0,0,0));
        aboutBut.setOpaque(false);
        aboutBut.setContentAreaFilled(false);
        aboutBut.setBorderPainted(false);
        aboutBut.setForeground(Color.white);
        aboutBut.setHorizontalAlignment(SwingConstants.LEFT);
        About.add(aboutBut);
         
        Feedback.setLayout(new GridLayout(1, 1));
        Feedback.setBackground(new Color(0,0,0,0));
        feedbackBut.setOpaque(false);
        feedbackBut.setContentAreaFilled(false);
        feedbackBut.setBorderPainted(false);
        feedbackBut.setForeground(Color.white);
        feedbackBut.setHorizontalAlignment(SwingConstants.LEFT);
        Feedback.add(feedbackBut);
        
        Help.setLayout(new GridLayout(1, 1));
        Help.setBackground(new Color(0,0,0,0));
        helpBut.setOpaque(false);
        helpBut.setContentAreaFilled(false);
        helpBut.setBorderPainted(false);
        helpBut.setForeground(Color.white);
        helpBut.setHorizontalAlignment(SwingConstants.LEFT);
        Help.add(helpBut);
        
        mainPanel.setLayout(new GridLayout(9, 1));
        mainPanel.add(headerPanel);
        mainPanel.add(settingsPanel);
        mainPanel.add(locationPanel);
        mainPanel.add(Temp); 
        mainPanel.add(Wind);
        mainPanel.add(Support);
        mainPanel.add(About);
        mainPanel.add(Feedback);
        mainPanel.add(Help);
        add(mainPanel, BorderLayout.CENTER);
        
        //this.setSize(320, 480);
        //this.setResizable(false);
        this.setVisible(true);
        back.addActionListener(this);
        tempBut.addActionListener(this);
        windBut.addActionListener(this);
        aboutBut.addActionListener(this);
        helpBut.addActionListener(this);
        feedbackBut.addActionListener(this);
    }
    
    public int getTemperatureMetrics() {
        return this.tempMetrics;
    }
    
    public int getWindMetrics() {
        return this.windMetrics;
    }
    
    public void setTmperatureMetrics(int metrics) {
        this.tempMetrics = metrics;
        if(this.tempMetrics == SettingsMain.CELSIUS) {
            tempText.setText("Celsius");
        }
        else {
            tempText.setText("Fahre..s");
        }
        
        mainPanel.repaint();
        this.repaint();
    }
    
    public void setWindMetrics(int metrics) {
        this.windMetrics = metrics;
        if(this.windMetrics == SettingsMain.KM_PER_HOUR) {
            windText.setText("Kilometers per hour");
        }
        else {
            windText.setText("Miles per hour");
        }
        
        mainPanel.repaint();
        this.repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(tempBut)) {
            new TemperatureFrame(parent, this);
            
        }
        else if(e.getSource().equals(back)){
         parent.changePanel(new MainPanel(parent, false, 1));
        }
        
         if (e.getSource().equals(windBut)) {
            new WindFrame(parent, this);
            
        }
        else if(e.getSource().equals(aboutBut)){
           
            AboutThisApp abtFrame = new AboutThisApp(parent);
            parent.changePanel(abtFrame);

        }
        else if(e.getSource().equals(helpBut)){
            Help helpFrame = new Help(parent);
            helpFrame.load();
            parent.changePanel(helpFrame);
            

        }
    }

}
