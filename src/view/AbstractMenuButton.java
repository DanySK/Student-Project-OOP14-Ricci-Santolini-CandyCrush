package view;

import javax.swing.JButton;
/**
 * Classe astratta per la gestione dell'aspetto dei JButton nelle varie schermate di gioco.
 * Dato che non tutte le classi gestiscono sia JButton che JPanel, questa classe permette di modificare l'aspetto dei
 * JButton in ogni classe in base alle proprie preferenze.
 * 
 * @author Beatrice Ricci 
 *
 */
public abstract class AbstractMenuButton extends AbstractMenu implements IMenuButton {

	private static final long serialVersionUID = 1350003953896402903L;

	@Override
	public abstract void lookButton(final JButton p);

}
