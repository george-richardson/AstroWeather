package Common;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Resources {
	public static final Color bgColor = new Color(0, 0, 0, 0.0f);
	public static final Color bgColorTop = new Color(11, 25, 31);
	public static final Color bgColorBottom = new Color(65, 142, 194);
	public static final Color titleColor = new Color(255, 255, 255);
	public static final Font titleFont = getFont(24, 0.1);
	public static final Font homeButtonFont = getFont(14, 0.2);
	public static final Font chartTitleFont = getFont(14, 	0.2);

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
}
