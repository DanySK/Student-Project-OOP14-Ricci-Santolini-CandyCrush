package view;

import java.awt.Color;
import javax.swing.*;

public interface IMenu {
	
	public void setTheTitle(String t);
	
	public void closeGame();
	
	public void closePage();
	
	public void lookPanel(JPanel p, Color c);
	
	public void lookButton(JButton b, Color c, boolean bool);
	
	public JLabel createLabel(String text, ImageIcon icon,int hPos, int vPos);
}
