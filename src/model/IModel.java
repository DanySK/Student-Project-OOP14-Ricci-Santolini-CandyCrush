package model;

/**
 * Interfaccia del modello
 * 
 * @author Nicola Santolini
 *
 */
public interface IModel extends IGenerate{
	
	/**
	 * Getter della matrice di gioco
	 * 
	 * @return la matrice di gioco
	 */
	public Element[][] getMat();
	
	/**
	 * Metodo per decrementare le mosse rimanenti
	 */
	public void decStep();
	
	/**
	 * Getter del punteggio corrente
	 * 
	 * @return il punteggio attuale
	 */
	public int getScore();
	
	/**
	 * Getter delle mosse rimanenti
	 * 
	 * @return il numero di mosse rimanenti
	 */
	public int getStep();
	
	/**
	 * Getter dell'obiettivo di punti da raggiungere
	 * 
	 * @return il punteggio da raggiungere
	 */
	public int getTarget();
		
	/**
	 * Getter del colore di un elemento della matrice di gioco
	 * date le sue coordinate
	 * 
	 * @param i indice di riga
	 * @param j indice di colonna
	 * @return il colore dell'elemento richiesto
	 */
	public int getColor(int i, int j);
	

	/**
	 * Getter del tipo di un elemento della matrice di gioco
	 * date le sue coordinate
	 * 
	 * @param i indice di riga
	 * @param j indice di colonna
	 * @return il tipo dell'elemento richiesto
	 */
	public int getTypeEl(int i, int j);
	
	/**
	 * Setter delle mosse di inizio livello, in base alla difficoltà
	 * 
	 * @param num punteggio da settare
	 */
	public void setStep(int num);
	
	/**
	 * Metodo che incrementa il punteggio
	 * 
	 * @param num numero di punti da aggiungere a quelli attuali
	 */
	public void incScore(int num);
	
	/**
	 * Metodo che inizializza il punteggio da raggiungere in base
	 * alla difficootà selezionata
	 * 
	 * @param num punteggio da settare
	 */
	public void setTarget(int num);
	
	/**
	 * Metodo che verifica se due coordinate sono compatibile per uno scambio,
	 * cioè sono adiacenti ma non poste in diagonale
	 * 
	 * @param x1 indice di riga della prima coordinata
	 * @param y1 indice di colonna della prima coordinata
	 * @param x2 indice di riga della seconda coordinata
	 * @param y2 indice di colonna della seconda coordinata
	 * @return true se lo scambio può essere fatto
	 */
	public  boolean checkExchange(int x1, int y1, int x2, int y2);
	
	/**
	 * Metodo che esegue uno scambio tra due caramelle della matrice di gioco
	 * 
	 * @param x1 indice di riga della prima coordinata
	 * @param y1 indice di colonna della prima coordinata
	 * @param x2 indice di riga della seconda coordinata
	 * @param y2 indice di colonna della seconda coordinata
	 */
	public void doExchange(int x1, int y1, int x2, int y2);
	
	/**
	 * Metodo che verifica se nella matrice di gioco attuale è in atto una combinazione
	 * ed è necessario continuare ad eliminare caramelle e aggiornare la matrice. Quando
	 * la matrice si trova in uno stato senza più combinazioni in atto, se ne notifica il
	 * controller
	 * 
	 *  @return true se bisogna continuare con il game loop
	 */
	public boolean goOn();
	
	/**
	 * Metodo che verifica la possibilità di completare almeno una mossa 
	 * col set di caramelle attuale
	 * 
	 * @return true se è possibile realizzare almeno una combinazione in verticale e/o
	 * orizzontale in una sola mossa
	 */
	public boolean checkNextMove();
	
	/**
	 * Metodo che modella il comportamento da utilizzare quando si attiva una caramella SPECIAL.
	 * 
	 * @param c colore della caramella con cui è stata abbinata la SPECIAL
	 * @return il numero di caramelle dello stesso colore di quella passata come parametro,
	 * per calcore i punti bonus da attribuire
	 */
	public int doFive(int c);
	
	/**
	 * Metodo invocato finchè sulla matrice esiste almeno un combinazione, verifica di quale 
	 * tipo di combinazione si tratta e attiva il behaviour corrispondente, finchè la matrice non 
	 * viene a trovarsi in una situazione senza combinazioni in atto
	 */
	public void gameLoop();
	
	/**
	 * Metodo che effettua un mescolamento della matrice di gioco utilizzando il set
	 * di caramelle attuale, necessario se ci si viene a trovare in una situazione di
	 * stallo in cui la matrice di gioco non ammetterebbe nuove mosse
	 */
	public void shuffle();
	
	
}
