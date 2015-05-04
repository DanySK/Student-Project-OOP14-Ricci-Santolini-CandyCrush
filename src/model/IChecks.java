package model;

/**
 * Interfaccia per la gestione dei controlli delle combinazioni nella matrice di gioco
 * 
 * @author Nicola Santolini
 *
 */
public interface IChecks {
	
	/**
	 * Metodo che verifica se due caramelle sono adiacenti tramite le loro coordinate
	 * 
	 * @param x1 indice di riga della prima caramella
	 * @param y1 indice di colonna della prima caramelle
	 * @param x2 indice di riga della seconda caramella
	 * @param y2 indice di colonna della seconda caramella
	 * @return true se le due caramelle sono adiacenti
	 */
	public  boolean checkExchange(int x1, int y1, int x2, int y2);
	
	/**
	 * Metodo che verifica la presenza di un tris verticale o orizzontale
	 * 
	 * @param mat matrice degli elementi
	 * @return true se è presente almeno un tris
	 */
	public boolean checkTris(Element[][] mat);
	
	/**
	 * Metodo che verifica la presenza di tris verticali
	 * 
	 * @param mat matrice degli elementi
	 * @return true se è presente almeno un tris verticale
	 */
	public boolean checkTrisVertical(Element[][] mat);
	
	/**
	 * Metodo che verifica la presenza di tris orizzontali
	 * 
	 * @param mat matrice degli elementi
	 * @return true se è presente almeno un tris orizzontale
	 */
	public boolean checkTrisOrizontal(Element[][] mat);
	
	/**
	 * Metodo che verifica la presenza di combinazioni di quattro caramelle in verticale
	 * 
	 * @param mat matrice degli elementi
	 * @return true se è presente almeno una combinazione di quattro caramelle in verticale
	 */
	public boolean checkPokerVertical(Element[][] mat);
	
	/**
	 * Metodo che verifica la presenza di combinazioni di quattro caramelle in orizzontale
	 * 
	 * @param mat matrice degli elementi
	 * @return true se è presente almeno una combinazione di quattro caramelle in orizzontale
	 */
	public boolean checkPokerOrizontal(Element[][] mat);
	
	/**
	 * Metodo che verifica la presenza di combinazioni di cinque caramelle in verticale
	 * 
	 * @param mat matrice degli elementi
	 * @return true se è presente almeno una combinazione di cinque caramelle in verticale
	 */
	public boolean checkFiveOrizontal(Element[][] mat);
	
	/**
	 * Metodo che verifica la presenza di combinazioni di cinque caramelle in orizzontale
	 * 
	 * @param mat matrice degli elementi
	 * @return true se è presente almeno una combinazione di cinque caramelle in orizzontale
	 */
	public boolean checkFiveVertical(Element[][] mat);
	
	/**
	 * Metodo che verifica la presenza di combinazioni di due tris con una caramella
	 * in comune
	 * 
	 * @param mat matrice degli elementi
	 * @return true se è presente almeno una combinazione di due tris con una
	 * caramella in comune
	 */
	public boolean checkWrapped(Element mat[][]);
	
	/**
	 * Metodo che verifica la possibilità, con una mossa, di generare almeno un tris con l'attuale matrice di gioco,
	 * e quindi di poter continuare a giocare senza effetuare mescolamenti della matrice
	 * @param mat
	 * @return
	 */
	public boolean checkNextMove(Element mat[][]);
}
