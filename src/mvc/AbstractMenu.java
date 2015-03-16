package mvc;

import java.awt.Color;

import javax.swing.JFrame;
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
}
