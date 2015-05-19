package view.level;

import view.play.IGamePlay;

/**
 * Interfaccia dei livelli di difficoltà.
 * @author Beatrice Ricci
 *
 */
public interface ILevel {
	
	/**
	 * Metodo per impostare il livello di difficoltà del gioco.
	 * @param play schermata di gioco a cui viene impostato il livello scelto dall'utente
	 */
	void setLevel(IGamePlay play);
}
