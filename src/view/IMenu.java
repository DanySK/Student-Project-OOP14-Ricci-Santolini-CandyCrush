package view;

import java.awt.Color;
import javax.swing.*;
/**
 * Interfaccia che contiene tutti i metodi comuni ai vari menù di gioco.
 * 
 * @author Beatrice Ricci
 *
 */
public interface IMenu {
	/**
	 * Metodo per terminare l'applicazione
	 */
	public void closeGame();
	
	/**
	 * Medoto per chiudere una schermata quando non serve più
	 */
	public void closePage();
	
	/**
	 * Metodo per cambiare l'aspetto di un JPanel
	 * @param p pannello da modificare
	 * @param c colore di sfondo da assegnare al pannello
	 */
	public void lookPanel(JPanel p, Color c);
	
	/**
	 * Metodo per cambiare le caratteristiche principali dell'aspetto di un JButton
	 * @param b JButton da modificare
	 * @param c colore di sfondo per il JButton
	 * @param bool per decidere se bordare o meno il JButton
	 */
	public void lookButton(JButton b, Color c, boolean bool);
	
	/**
	 * Metodo per inserire un'immagine in una JLabel
	 * @param text testo da inserire nella JLabel 
	 * @param icon immagine da inserire nella JLabel
	 * @param hPos allineamento orizzontale dell'immagine 
	 * @param vPos allineamento verticale dell'immagine
	 * @return Jlabel con immagine e testo
	 */
	public JLabel createLabel(String text, ImageIcon icon,int hPos, int vPos);
}
