package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Classe che comunica all'utente che ha perso la partita e gli permette di giocare nuovamente o di abbandonare il gioco.
 * 
 * @author Beatrice Ricci
 * 
 */
public class GameOver extends AbstractFinal {

	private static final long serialVersionUID = -7876870538465198338L;

	private final ImageIcon iconLose = new ImageIcon("res" + ViewUtility.SEP + "loser.jpg");
	private final JLabel label = createLabel("  GAME OVER :(  ", this.iconLose, JLabel.CENTER, JLabel.BOTTOM);
	
	/**
	 * Costruttore.
	 */
	public GameOver() {
		//title
		this.setTitle("    GAME LOST :(    ");
		
		//dimension
		this.setDimension();
		
		// principal panel
		final JPanel panel = new JPanel(new BorderLayout());
		panel.add(this.label, BorderLayout.CENTER);
		panel.add(setJButtonsInPanel(Color.YELLOW), BorderLayout.SOUTH);
		
		this.lookPanel(panel, Color.YELLOW);
		this.getContentPane().add(panel);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
