package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe astratta che contiene metodi che caratterizzano tutte le GUI del Package. 
 * 
 * @author Beatrice Ricci
 */
public abstract class AbstractMenu extends JFrame implements IMenu {
	
	private static final long serialVersionUID = -2154453298222711291L;
	private static final int DIMENSION_FONT_50 = 50;
	private static final String TYPE_FONT = "Arial";
	
	@Override
	public void closeGame() {
		System.exit(0);
	}
	
	@Override
	public void closePage() {
		this.setVisible(false);
	}
	
	@Override
	public void lookPanel(final JPanel p, final Color c) {
		p.setOpaque(true);
		p.setBackground(c);
	}
	
	@Override
	public void lookButton(final JButton b, final Color c, final boolean bool) {
		b.setOpaque(true);
		b.setBackground(c);
		b.setBorderPainted(bool);
	}
	
	//da http://antoniotancredi.altervista.org/2010/05/04/java-utilizzare-unicona-in-una-jlabel/
	@Override
	public JLabel createLabel(final String text, final ImageIcon icon, final int hPos, final int vPos) {
	    final JLabel label = new JLabel(text, icon, JLabel.CENTER);
	    label.setFont(new Font(TYPE_FONT, Font.BOLD, DIMENSION_FONT_50));
	    label.setHorizontalTextPosition(hPos);
	    label.setVerticalTextPosition(vPos);
	    return label;
	}
}
