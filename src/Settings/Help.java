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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
public class Help extends JFrame implements ActionListener {
    private Main parent = null; 
    private MainPanel home = new MainPanel();
    private JPanel panel1 = new JPanel();
    private JPanel headerPanel = new JPanel();
    private JButton back = new JButton();
    private JLabel label1 = new JLabel("");
    private JLabel helpFeed = new JLabel("     Help and feedback");
    private JLabel helpFeed1 = new JLabel("     These are the most common questions we been ");
    private JLabel helpFeed2 = new JLabel("     about the application ");
   public Help(Main parent) {
       this.parent = parent;
      
    }  
    
     public void load() {
         Container c = getContentPane();
         home.setLayout(new GridLayout(8, 1));
         headerPanel.setLayout(new GridLayout(1, 2));
         headerPanel.setBackground(new Color(36,102,176));
         headerPanel.add(back);
         
         back.setIcon(new ImageIcon(getClass().getResource("backMain.png")));
          back.setOpaque(false);
          back.setContentAreaFilled(false);
          back.setBorderPainted(false);
          back.setHorizontalAlignment(SwingConstants.LEFT);
          back.addMouseListener(new MouseAdapter()
        {
            public void mouseEntered(MouseEvent evt)
            {
                back.setIcon(new ImageIcon(getClass().getResource("backMain1.png")));
              // back.setIcon(icon1);
            }
            public void mouseExited(MouseEvent evt)
            {
            back.setIcon(new ImageIcon(getClass().getResource("backMain.png")));
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
         c.add(home); 
         this.setResizable(false);
         this.setVisible(true);
         back.addActionListener(this);
        }
     
     
     
     
        @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(back)) {
            this.setVisible(false);
            this.dispose(); 
            parent.setVisible(true);
        }
        
    }
}
