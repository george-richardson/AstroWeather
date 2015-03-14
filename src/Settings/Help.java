package Settings;

import AstroWeather.Main;
import Common.AstroPanel;
import Common.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
@SuppressWarnings("serial")
public class Help extends AstroPanel implements ActionListener {
    //private SettingsMain parent = null; 
    private SettingsMainPanel home = new SettingsMainPanel();
    private JPanel panel1 = new JPanel();
    private JPanel headerPanel = new JPanel();
    private JButton back = new JButton();
    private JLabel label1 = new JLabel("");
    private JLabel helpFeed = new JLabel("     Help and feedback");
    private JLabel helpFeed1 = new JLabel("     These are the most common questions we been ");
    private JLabel helpFeed2 = new JLabel("     about the application ");
   public Help(Main parent, boolean orientation) {
	   super(parent, orientation);
	   setLayout(new BorderLayout());
       //this.parent = parent;
    }  
    
     public void load() {
         //Container c = getContentPane();
         home.setLayout(new GridLayout(8, 1));
         headerPanel.setLayout(new GridLayout(1, 2));
         headerPanel.setBackground(new Color(36,102,176));
         headerPanel.add(back);
         
         back.setIcon(Resources.getImage("settings/backMain.png"));
          back.setOpaque(false);
          back.setContentAreaFilled(false);
          back.setBorderPainted(false);
          back.setHorizontalAlignment(SwingConstants.LEFT);
          back.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {
                back.setIcon(Resources.getImage("settings/backMain1.png"));
              // back.setIcon(icon1);
            }
            public void mouseExited(MouseEvent evt)
            {
            back.setIcon(Resources.getImage("settings/backMain.png"));
            }
           
        });
        
         panel1.setLayout(new GridLayout(4, 1));
         panel1.setBackground(new Color(0,0,0,0));
         panel1.setOpaque(false);
         panel1.add(label1);
         panel1.add(helpFeed);
         panel1.add(helpFeed1);
         panel1.add(helpFeed2);
        helpFeed.setForeground(Color.white);
        helpFeed1.setForeground(Color.white);
        helpFeed2.setForeground(Color.white);
        
        
        
        
        
         home.add(headerPanel);
         home.add(panel1);
         add(home, BorderLayout.CENTER); 
         //this.setResizable(false);
         //this.setVisible(true);
         back.addActionListener(this);
        }
     
     
     
     
        @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(back)) {
            //this.setVisible(false);
            //this.dispose(); 
            //parent.setVisible(true);
        	parent.changePanel(new SettingsMain(parent, orientation));
        }
        
    }

		@Override
		public void changeOrientation(boolean neworientation) {
			// TODO Auto-generated method stub
			orientation = !orientation;
		}
}
