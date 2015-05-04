package view;

import java.awt.*;
import javax.swing.*;

/**
 * Classe astratta che contiene metodi che caratterizzano tutte le GUI del Package. 
 * 
 * @author Beatrice Ricci
 */
public abstract class AbstractMenu extends JFrame implements IMenu {
	
	private static final long serialVersionUID = -2154453298222711291L;

	public void closeGame(){
		System.exit(1);
	}
	
	public void closePage(){
		this.setVisible(false);
	}
	
	public void lookPanel(JPanel p, Color c){
		p.setOpaque(true);
		p.setBackground(c);
	}
	
	public void lookButton(JButton b, Color c, boolean bool){
		b.setOpaque(true);
		b.setBackground(c);
		b.setBorderPainted(bool);
	}
	
	//da http://antoniotancredi.altervista.org/2010/05/04/java-utilizzare-unicona-in-una-jlabel/
	public JLabel createLabel(String text, ImageIcon icon,int hPos, int vPos)
	{
	    JLabel label = new JLabel(text, icon, JLabel.CENTER);
	    label.setFont(new Font("Arial",Font.BOLD,50));
	    label.setHorizontalTextPosition(hPos);
	    label.setVerticalTextPosition(vPos);
	    return label;
	}
}
