package view;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
/**
 * Classe contenente costanti riservate alla view.
 * 
 * @author Beatrice Ricci
 *
 */
public final class ViewUtility {
	private static final String RES = "res";
	
	/**
	 * Separatore.
	 */
	public static final String SEP = File.separator;
	
	/**
	 * Immagine per il JButton di uscita.
	 */
	public static final ImageIcon CLOSE_IM = new ImageIcon(RES + SEP + "close.jpg");
	
	/**
	 * Sfondo per il pannello del menù iniziale.
	 */
	public static final Image CARAMELLE = new ImageIcon(RES + SEP + "caramelle.jpg").getImage();
	/**
	 * Sfondo per il pannello di scelta del livello di difficoltà.
	 */
	public static final Image POIS = new ImageIcon(RES + SEP + "pois.jpg").getImage();
	
	/**
	 * Immagine per la schermata di shuffle.
	 */
	public static final ImageIcon SHUFFLE = new ImageIcon(RES + SEP + "shuffle.jpg");
	
	/**
	 * Icona del JButtons START del menu iniziale.
	 */
	public static final ImageIcon IC_START = new ImageIcon(RES + SEP + "start.jpg");
	/**
	 * Icona del JButtons INSTRUCTION del menu iniziale.
	 */
	public static final ImageIcon IC_INSTR = new ImageIcon(RES + SEP + "instr.jpg");
	/**
	 * Icona del JButtons EXIT del menu iniziale.
	 */
	public static final ImageIcon IC_EXIT = new ImageIcon(RES + SEP + "exit.jpg");
	
	/**
	 * Percorso file istruzioni.
	 */
	public static final String FILE_PATH = RES + SEP + "doc" + SEP + "instr.txt";
	
	private ViewUtility() { }
}
