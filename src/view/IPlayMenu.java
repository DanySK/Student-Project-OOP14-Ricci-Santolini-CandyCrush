package view;
/**
 * Intefaccia che contiene i metodi della schermata di gioco
 * 
 * @author Beatrice Ricci
 *
 */
public interface IPlayMenu {
	/**
	 * Setter dell'obiettivo da raggiungere per superare il livello
	 * @param n obiettivo da raggiungere
	 */
	public void updateTarget(int n);
	
	/**
	 * Setter della difficoltà del livello
	 * @param s tipologia di difficoltà del livello
	 */
	public void setDiff(String s);

	/**
	 * Metodo per aggiornare le mosse rimaste in base al modello
	 */
	public void updateStep(int n);
	
	/**
	 * Metodo per aggiornare il punteggio ottunuto in base ai dati del modello
	 */
	public void updateTot();
	
	/**
	 * Metodo che restituisce il Butt desiderato in base alle coordinate passate come parametro
	 * @param i coordinata x
	 * @param j coordinata y
	 * @return Butt di coordinate x, y
	 */
	public Butt getAMatrixButt(int i, int j);
}
