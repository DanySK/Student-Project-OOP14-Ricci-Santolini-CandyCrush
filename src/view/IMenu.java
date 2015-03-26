package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public interface IMenu {
	
	public void setTheTitle(String t);
	
	public void closeGame();
	
	public void closePage();
	
	public void lookPanel(JPanel p, Color c);
	
	public JLabel createLabel(String text, ImageIcon icon,int hPos, int vPos);
}
