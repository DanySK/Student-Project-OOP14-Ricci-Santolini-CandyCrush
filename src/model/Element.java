package model;

import controller.Utility;
/**
 * 
 * Classe che modella a livello di modello un singolo elemento della 
 * matrice di gioco, caratterizzato da un colore e da un tipo
 * 
 * @author Nicola Santolini
 *
 */
public class Element {
	
	private int colorNumber;
	private int type;
	
	public Element(){
		this.type = Utility.normal; 
	}
	
	public Element(int i){
		this.colorNumber = i;
		this.type = Utility.normal; 
	}
	
	/**
	 * Getter del colore dell'elemento
	 * 
	 * @return il colore dell'elemento
	 */
	public int getColorNumber(){
		return this.colorNumber;
	}
	
	/**
	 * Setter del colore di un elemento
	 * 
	 * @param c	il colore da applicare a un elemento
	 */
	public void setColorNumber(int c){
		this.colorNumber = c;
	}
	
	/**
	 * Getter del tipo dell'elemento
	 * 
	 * @return il tipo dell'elemento
	 */
	public int getType(){
		return this.type;
	}
	
	/**
	 * Setter del tipo dell'elemento
	 * 
	 * @param t il tipo da applicare a un elemento
	 */
	public void setType(int t){
		this.type = t;
	}
}
