package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Classe il cui compito è far apparire per qualche secondo il messaggio di shuffle degli elementi della matrice principale
 * di gioco quando non ci sono più mosse possibili.
 * 
 * @author Beatrice Ricci
 *
 */
public class Shuffle extends AbstractMenu{

	private static final long serialVersionUID = -1183169779251815974L;
	
	private JLabel label = createLabel(" ", ViewUtility.shuffle, JLabel.CENTER, JLabel.TOP);
	
	public Shuffle(){
		this.setTitle("Shuffle!!");
		
		Dimension size;
		size = Toolkit.getDefaultToolkit().getScreenSize();
		int taglia = (int)size.getWidth()/3;
		this.setSize(taglia, taglia/2);
		this.setResizable(false);
		
		JPanel panel = new JPanel(new BorderLayout());
		this.lookPanel(panel, Color.white);
		panel.add(label, BorderLayout.CENTER);
		this.getContentPane().add(panel);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	/**
	 * Metodo per far apparire e scomparire il  messaggio di shuffle in modo che sia chiaro all'utente
	 */
	public void goShuffle(){
		try {
			new Shuffle();
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.closePage();
	}
}
