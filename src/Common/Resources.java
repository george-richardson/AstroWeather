package Common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Resources {
	public static final Color bgColor = new Color(26, 65, 81);
	public static final Color titleColor = new Color(255, 255, 255);
	public static final Font titleFont = getFont(24, 0.1);
	public static final Font homeButtonFont = getFont(14, 0.2);
	public static final Font chartTitleFont = getFont(14, 0.2);
	public static final Image backgroundImage = load("assets/background.png");
		
	private static Font getFont(float size, double spacing) {
		Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
		attributes.put(TextAttribute.TRACKING, spacing);
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File("assets/AliquamREG.ttf")).deriveFont(size).deriveFont(attributes);
		} catch (Exception e) {
			System.err.println("ERR: FONT FILE NOT FOUND");
			return new Font(Font.SERIF, Font.PLAIN, 12);
		}
	}
	
	private static Image load(String pathToImage) {
		try {
			return ImageIO.read(new File(pathToImage));
		} catch (IOException e) {
			throw new RuntimeException("Cannot load image: " + pathToImage, e);
		}
	}
}
