package Common;

import javax.swing.JPanel;

import AstroWeather.Main;

@SuppressWarnings("serial")
public abstract class AstroPanel extends JPanel {
	private Main parent;
	protected boolean orientation;
	
	protected AstroPanel(Main parent, boolean orientation) {
		this.parent = parent;
		this.orientation= orientation;
	}
	protected void change(AstroPanel p) {
		parent.changePanel(p);
	}

	public abstract void changeOrientation(boolean orientation);
	
}
