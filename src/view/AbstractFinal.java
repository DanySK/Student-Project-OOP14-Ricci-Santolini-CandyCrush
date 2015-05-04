package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Classe astratta che contiene metodi protected che si occupano della creazione dei frame che gestiscono i messaggi
 * per la terminazione del gioco (vittoria, sconfitta)
 * 
 * @author Beatrice Ricci
 */

public abstract class AbstractFinal extends AbstractMenu {

	private static final long serialVersionUID = 6998965214419663725L;
	
	private static final int WIDTH_DIMENSION = 2;
	private static final int HEIGHT_DIMENSION = 10;
	
	/**
	 * Metodo per stabilire la dimensione del frame
	 */
	protected void setDimension(){
		Dimension size;
		size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)size.getWidth()/WIDTH_DIMENSION, (int)size.getHeight()-((int)size.getHeight()/HEIGHT_DIMENSION));
		this.setResizable(false);
	}
	
	/**
	 * Metodo per la gestione dei JButtons presenti nella schermata e dello sfondo:
	 * il tasto "play" permetterà di giocare nuovamente mentre il pulsante "exit" chiude l'applicazione
	 * @param c colore di sfondo
	 * @return JPanel completo
	 */
	protected JPanel setJButtonsInPanel(Color c){
		JButton play = new JButton (" Play again ! ");
		play.setFont(new Font("Arial",Font.BOLD,20));
		
		JButton exit = new JButton (" EXIT ");
		exit.setFont(new Font("Arial",Font.BOLD,20));
		
		this.lookButton(play, c, false);
		this.lookButton(exit, c, false);

		this.setJButtonBehaviour(play, exit);
		
		JPanel app = new JPanel(new FlowLayout());
		this.lookPanel(app, c);
		
		app.add(play);
		app.add(exit);
		
		return app;
	}
	
	/**
	 * Metodo privato per gestire il comportamento dei JButton una volta premuti
	 * @param p JButton play again
	 * @param e JButton exit
	 */
	private void setJButtonBehaviour(JButton p, JButton e){
		p.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				closePage();
				new DifficultMenu();
			}
		});
		e.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Question();
			}
		});
	}
}
