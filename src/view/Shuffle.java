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
public class Shuffle extends AbstractMenu {

	private static final long serialVersionUID = -1183169779251815974L;
	
	private static final int TIME = 500;
	
	private final JLabel label = createLabel(" ", ViewUtility.SHUFFLE, JLabel.CENTER, JLabel.TOP);
	/**
	 * Costruttore.
	 */
	public Shuffle() {
		this.setTitle("Shuffle!!");
		
		Dimension size;
		size = Toolkit.getDefaultToolkit().getScreenSize();
		final int taglia = (int) size.getWidth() / 3;
		this.setSize(taglia, taglia / 2);
		this.setResizable(false);
		
		final JPanel panel = new JPanel(new BorderLayout());
		this.lookPanel(panel, Color.white);
		panel.add(label, BorderLayout.CENTER);
		this.getContentPane().add(panel);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	/**
	 * Metodo per far apparire e scomparire il  messaggio di shuffle in modo che sia chiaro all'utente.
	 */
	public void goShuffle() {
		try {
			new Shuffle();
			Thread.sleep(TIME);
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}
		this.closePage();
	}
}
