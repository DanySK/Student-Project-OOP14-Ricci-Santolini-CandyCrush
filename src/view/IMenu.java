package view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Interfaccia che contiene tutti i metodi comuni ai vari menù di gioco.
 * 
 * @author Beatrice Ricci
 *
 */
public interface IMenu {
	/**
	 * Metodo per terminare l'applicazione.
	 */
	void closeGame();
	
	/**
	 * Medoto per chiudere una schermata quando non serve più.
	 */
	void closePage();
	
	/**
	 * Metodo per cambiare l'aspetto di un JPanel.
	 * 
	 * @param p pannello da modificare
	 * @param c colore di sfondo da assegnare al pannello
	 */
	void lookPanel(JPanel p, Color c);
	
	/**
	 * Metodo per cambiare le caratteristiche principali dell'aspetto di un JButton.
	 * 
	 * @param b JButton da modificare
	 * @param c colore di sfondo per il JButton
	 * @param bool per decidere se bordare o meno il JButton
	 */
	void lookButton(JButton b, Color c, boolean bool);
	
	/**
	 * Metodo per inserire un'immagine in una JLabel.
	 * 
	 * @param text testo da inserire nella JLabel 
	 * @param icon immagine da inserire nella JLabel
	 * @param hPos allineamento orizzontale dell'immagine 
	 * @param vPos allineamento verticale dell'immagine
	 * @return Jlabel con immagine e testo
	 */
	JLabel createLabel(String text, ImageIcon icon, int hPos, int vPos);
}
