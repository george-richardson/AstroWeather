package AstroWeather;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JPanelWithBackground extends JPanel {

	private final Dimension preferredSize;
	private final Image image;
	
	private JPanelWithBackground(Image image) {
		this.image = image;
		this.preferredSize = new Dimension(image.getWidth(null), image.getHeight(null));
	}
	
	public static JPanelWithBackground load(String pathToImage) {
		try {
			Image image = ImageIO.read(new File(pathToImage));
			return new JPanelWithBackground(image);
		} catch (IOException e) {
			throw new RuntimeException("Cannot load image: " + pathToImage, e);
		}
	}
	
	@Override
	public Dimension getPreferredSize() {
		return preferredSize;
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		
		Dimension dimension = getSize();
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.drawImage(image, 0, 0, dimension.width, dimension.height, null);
	}
}
