package Settings;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class MainPanel extends JPanel {
    public MainPanel(){
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        BufferedImage image = null;
        try {                
    		image = ImageIO.read(getClass().getResource("background2.jpg"));
        } catch (IOException ex) {
            System.out.println("Exception caught, exception is: " + ex.getMessage());
        }            
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null); // see javadoc for more info on the parameters
    }                


}

