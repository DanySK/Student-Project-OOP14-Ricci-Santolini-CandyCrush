package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class AbstractMenu extends JFrame implements IMenu {
	
	private static final long serialVersionUID = -2154453298222711291L;

	public void setTheTitle(String title){
		this.setTitle(title);
	}
	
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
