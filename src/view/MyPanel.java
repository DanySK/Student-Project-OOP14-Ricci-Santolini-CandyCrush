package view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
/**
 * Classe che estende JPanel in modo che contenga un'immagine come sfondo.
 * 
 * @author Beatrice Ricci
 *
 */
public class MyPanel extends JPanel {
	private static final long serialVersionUID = -4749088748024631646L;
	
	private Image img;
	
	public MyPanel(Image img) {
		this.img = img;
	}
	
	/**
	 * Disegno l'immagine sul pannello alle coordinate 0-0
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, this);
	}
}