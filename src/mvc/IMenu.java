package mvc;

import java.awt.Color;

import javax.swing.JPanel;

public interface IMenu {
	
	public void setTheTitle(String t);
	
	public void closeGame();
	
	public void closePage();
	
	public void lookPanel(JPanel p, Color c);
}
