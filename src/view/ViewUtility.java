package view;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
/**
 * Classe contenente costanti riservate alla view
 * 
 * @author Beatrice Ricci
 *
 */
public class ViewUtility {
	public final static String SEP = File.separator;
	
	//immagine per il JButton di uscita
	public final static ImageIcon closeIm = new ImageIcon("res"+SEP+"close.jpg");
	
	//sfondi per pannelli
	public final static Image caramelle = new ImageIcon("res"+SEP+"caramelle.jpg").getImage();
	public final static Image pois = new ImageIcon("res"+ ViewUtility.SEP +"pois.jpg").getImage();
	
	//immagine per lo shuffle
	public final static ImageIcon shuffle = new ImageIcon("res"+SEP+"shuffle.jpg");
	
	//icone JButtons del menu
	public final static ImageIcon icStart = new ImageIcon("res"+SEP+"start.jpg");
	public final static ImageIcon icInstr = new ImageIcon("res"+SEP+"instr.jpg");
	public final static ImageIcon icExit = new ImageIcon("res"+SEP+"exit.jpg");
	
	//percorso file istruzioni
	public final static String filePath = "res"+SEP+"doc"+SEP+"instr.txt";
		
}
