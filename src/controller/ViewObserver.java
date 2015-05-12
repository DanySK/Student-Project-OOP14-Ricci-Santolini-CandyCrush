package controller;
/**
 * Classe che contiene l'interfaccia dell'observer della gui.
 * 
 * @author Beatrice Ricci, Nicola Santolini
 */
public interface ViewObserver {
	/**
	 * Metodo che quando vengono selezionate due caramelle sulla matrice di gioco notifica la loro posizione al controller, 
	 * che poi esegue i necessari controlli per convalidare o meno la mossa che si deve fare.
	 * 
	 * @param x1 coordinata di riga del primo elemento
	 * @param y1 coordinata di colonna del secondo elemento
	 * @param x2 coordinata di riga del primo elemento
	 * @param y2 coordinata di colonna del secondo elemento
	 */
	void update(final int x1, final int y1, final int x2, final int y2);
}
