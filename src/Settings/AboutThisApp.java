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
public class AboutThisApp extends JFrame implements ActionListener {
    private Main parent = null; 
    private MainPanel home = new MainPanel();
    private JButton back = new JButton();
    private JLabel title = new JLabel("     Astro Weather");
    private JLabel version = new JLabel("     Version 1.0");
    private JLabel label1 = new JLabel(""); 
    private JLabel info1 = new JLabel(); 
    private JLabel info2 = new JLabel(); 
    private JLabel info3 = new JLabel(); 
    private JPanel infoPanel = new JPanel();
    private JPanel headerPanel = new JPanel();
    private JPanel assocPanel = new JPanel();
    private JPanel createPanel = new JPanel();
    public AboutThisApp(Main parent) {
       this.parent = parent;
       
    }
    
    
     
     public void load() {
         Container c = getContentPane();
         home.setLayout(new GridLayout(8, 1));
         c.setBackground(new Color(40,40,40));
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
        
      
       
         
        infoPanel.setLayout(new GridLayout(3, 1));
        infoPanel.setBackground(new Color(0,0,0,0));
        infoPanel.setOpaque(false);
        infoPanel.add(label1);
        infoPanel.add(title);
        infoPanel.add(version);
        title.setForeground(Color.white);
        version.setForeground(Color.white);
        
        assocPanel.setLayout(new GridLayout(2, 1));
        assocPanel.setBackground(new Color(0,0,0,0));
        assocPanel.setOpaque(false);
        assocPanel.add(info2);
        assocPanel.add(info3);
        info2.setText("      Astro Weather was created with the help ");
        info3.setText("     of several third-party libraries."); 
        info2.setForeground(Color.white);
        info3.setForeground(Color.white);
         
        createPanel.setLayout(new GridLayout(1, 1));
        createPanel.setBackground(new Color(0,0,0,0));
        createPanel.setOpaque(false);
        createPanel.add(info1);
        info1.setText("     Data in associate with the Yahoo .."); 
        info1.setForeground(Color.white);
        
        
        
        home.add(headerPanel);
        home.add(infoPanel);
        home.add(createPanel);
        home.add(assocPanel);
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
