package controller;

public interface ViewObserver {
	/**
	 * Metodo che quando vengono selezionate due caramelle sulla matrice di gioco notifica la loro posizione al controller, 
	 * che poi esegue i necessari controlli per convalidare o meno la mossa che si deve fare
	 * 
	 * @param x1 coordinata di riga del primo elemento
	 * @param y1 coordinata di colonna del secondo elemento
	 * @param x2 coordinata di riga del primo elemento
	 * @param y2 coordinata di colonna del secondo elemento
	 */
	public void update(int x1, int y1, int x2, int y2);
}
