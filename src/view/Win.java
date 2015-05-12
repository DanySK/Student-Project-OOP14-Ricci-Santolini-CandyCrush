package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Classe che comunica all'utente che ha vinto la partita e gli permette di giocare nuovamente o di abbandonare il gioco.
 * 
 * @author Beatrice Ricci
 */
public class Win extends AbstractFinal {

	private static final long serialVersionUID = 5227740951252505323L;
	
	private final ImageIcon iconWin = new ImageIcon("res" + ViewUtility.SEP + "win.jpg");
	private final JLabel label = createLabel("  YOU WIN !!!  ", iconWin, JLabel.CENTER, JLabel.BOTTOM);
	/**
	 * Costruttore.
	 */
	public Win() {
		//title
		this.setTitle("    WIN !!    ");
		
		//dimension
		this.setDimension();
		
		// principal panel
		final JPanel panel = new JPanel(new BorderLayout());
		panel.add(label, BorderLayout.CENTER);
		panel.add(setJButtonsInPanel(Color.cyan), BorderLayout.SOUTH);
		
		this.lookPanel(panel, Color.cyan);
		this.getContentPane().add(panel);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

