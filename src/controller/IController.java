package controller;
/**
 * Intefaccia del Controller.
 * 
 * @author Beatrice Ricci, Nicola Santolini
 *
 */
public interface IController {
	
	/**
	 * Metodo getter del numero contenuto in una certa posizione della matrice del modello.
	 * @param i prima coordinata
	 * @param j seconda coordinata 
	 * @return valore numerico che indica il colore dell'elemento
	 */
	int getModelNum(final int i, final int j);
	
	/**
	 * Metodo getter che restituisce il tipo di un elemento contenuto in una certa posizione della matrice del modello.
	 * @param i prima coordinata
	 * @param j seconda coordinata
	 * @return valore numerico che indica il tipo di elemento
	 */
	int getModelType(final int i, final int j);
	
	/**
	 * Metodo getter del numero di mosse contenute nel modello.
	 * @return numero di mosse disponibili
	 */
	int getModelStep();
	
	/**
	 * Metodo getter del numero di punti accumulati nel modello.
	 * @return punti
	 */
	int getModelTot();

	/**
	 * Metodo che permette al controller di settare il numero iniziale di mosse del modello.
	 * @param t numero di mosse da settare
	 */
	void setModelStep(final int t);
	
	/**
	 * Metodo che permette al controllore di settare l'obiettivo da raggiungere.
	 * @param t punteggio da raggiungere
	 */
	void setModelTarget(final int t);
	
	/**
	 * Getter del listener della GUI.
	 * @return listener
	 */
	Listener getObserver();
}
