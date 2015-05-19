package model;

/**
 * Interfaccia di "facciata", che espone un numero ridotto di funzionalità per semplificare l'utilizzo da parte del client.
 * Vengono esposti solo i metodi necessari al model o al controller.
 * 
 * @author Nicola Santolini
 */
public interface IGameLoop {
	
	/**
	 * Metodo che semplifica e "nasconde" le varie operazioni necessarie al loop di gioco.
	 * Al suo interno vengono gestiti le operzioni di controllo sulla matrice, applicazione dell'adeguato
	 * behaviour e assegnazione del punteggio corrispondente.
	 * 
	 * @return il punteggio relativo all'ultima mossa eseguita dal loop
	 */
	int gameLoop();
	
	/**
	 * Getter della matrice di gioco.
	 * 
	 * @return la matrice degli elementi
	 */
	Candy[][] getMat();
	
	/**
	 * Metodo che verifica se esiste almeno una combinazione di tre elementi. In questo caso non è rilavante se la combinazione è verticale o 
	 * orizzontale e di quanti elementi è comosta.
	 * 
	 * @return true se esiste almeno una combinazione di tre elementi
	 */
	boolean checkTris();
	
	/**
	 * Metodo che verifica la possibilità, con una mossa, di generare almeno un tris con l'attuale matrice di gioco,
	 * e quindi di poter continuare a giocare senza effetuare mescolamenti della matrice.
	 *
	 * @return true se è possibile una nuova mossa
	 */
	boolean checkNextMove();
	
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
	 * Metodo che modella il comportamento da utilizzare quando si attiva una caramella SPECIAL.
	 * 
	 * @param c colore della caramella con cui è stata abbinata la SPECIAL
	 * @return il numero di caramelle dello stesso colore di quella passata come parametro,
	 * per calcore i punti bonus da attribuire
	 */
	int doFive(final int c);
	
}
