package Home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.block.LineBorder;

import Common.Resources;

@SuppressWarnings("serial")
public class DayPanel extends JPanel {
	public DayPanel() {
		setLayout(new BorderLayout());
		setOpaque(false);
		//setBorder(BorderFactory.createLineBorder(Resources.titleColor));
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Resources.titleColor));
		JLabel day = new JLabel("Tuesday", JLabel.CENTER);
		day.setFont(Resources.titleFont);
		day.setForeground(Resources.titleColor);
		add(day, BorderLayout.NORTH);
		JPanel p = new JPanel(new GridLayout(1, 2));
		p.setOpaque(false);
		p.add(new HomeButton(HomeButton.createIcon("moon75.png"), "Cloud"));
		p.add(new HomeButton("Temp", "8°"));
		add(p, BorderLayout.CENTER);
	}
}
