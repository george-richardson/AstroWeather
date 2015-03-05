package Common;

import java.awt.Color;
import java.awt.Font;
import java.io.File;

public class Resources {
	public static final Color bgColor = new Color(26, 65, 81);
	public static final Color titleColor = new Color(255, 255, 255);
	public static final Font titleFont = getTitleFont();
	
	private static Font getTitleFont() {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File("assets/AliquamREG.ttf")).deriveFont(24f);
		} catch (Exception e) {
			System.err.println("ERR: FONT FILE NOT FOUND");
			return new Font(Font.SERIF, Font.PLAIN, 12);
		}
	}
}
