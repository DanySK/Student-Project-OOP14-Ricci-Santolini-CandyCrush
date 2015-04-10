package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
		private static final long serialVersionUID = -4749088748024631646L;
		
		private Image img;
		public final static String sep = File.separator;

		public MyPanel() {
			this.img = Utility.sfondo;
		}
		
		// Disegno l'immagine sul pannello alle coordinate (0,0)
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, this);
		}
}