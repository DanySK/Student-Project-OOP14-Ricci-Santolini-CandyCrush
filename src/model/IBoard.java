package model;

/**
 * Classe che modella la matrice di gioco.
 * 
 * @author Nicola Santolini
 */
public interface IBoard {

	/**
	 * Metodo che esegue uno scambio tra due caramelle della matrice di gioco.
	 * 
	 * @param x1 indice di riga della prima coordinata
	 * @param y1 indice di colonna della prima coordinata
	 * @param x2 indice di riga della seconda coordinata
	 * @param y2 indice di colonna della seconda coordinata
	 */
	void doExchange(final int x1, final int y1, final int x2, final int y2);
	
	/**
	 * Getter della matrice di gioco.
	 * 
	 * @return la matrice di gioco
	 */
	Candy[][] getMat();

}
