package model;

import controller.Utility;

/**
 * Classe astratta che gestisce comportamenti comuni a più tipi di caramelle
 * 
 * @author Nicola Santolini
 *
 */
public abstract class AbstractBehaviourController implements IGenerate{
	
	/**
	 * metodo che in base al tipo della caramella in esame attua il relativo comportamento
	 * 
	 * @param inputType tipo della caramella che si sta analizando
	 * @param i indice di riga
	 * @param j indice di colonna
	 * @param mat matrice degli elementi
	 */
	protected void switchOptions(int inputType, int i, int j, Element[][] mat){
		switch(inputType){	
			case Utility.normal:
				//do nothing, una caramella normale non genera comportamenti speciali a parte la sua eliminazione
				break;
			case Utility.stripedO:
				row(i, mat);
				break;
			case Utility.stripedV:
				coloumn(j, mat);
				break;
			case Utility.wrapped:
				bomb(i, j, mat);
				break;
			default:
		}
		
	}
	
	/**
	 * metodo per l'eliminazione di una intera colonna
	 * 
	 * @param x colonna su cui operare
	 * @param mat matrice degli elementi
	 */
	private void coloumn(int x, Element[][] mat){
		
		for(int i = 0; i < Utility.dim1; i++){
			mat[i][x].setColorNumber(generate());
			mat[i][x].setType(Utility.normal);
		}
	}
	
	/**
	 * metodo per l'eliminazione di una intera riga
	 * 
	 * @param x riga su cui operare
	 * @param mat matrice degli elementi
	 */
	private void row(int x, Element[][] mat){
		
		for(int i = x; i > 0; i--){
			for(int j = Utility.dim2-1; j > -1; j--){	
				mat[i][j].setColorNumber(mat[i-1][j].getColorNumber());
				mat[i][j].setType(mat[i-1][j].getType());
				mat[i-1][j].setColorNumber(-1);
				mat[i-1][j].setType(Utility.normal);				
			}
		}
			
		for(int i = 0; i < Utility.dim2; i++){
			if(mat[0][i].getColorNumber() == -1){
				mat[0][i].setColorNumber(generate());
				mat[0][i].setType(Utility.normal);
			}
		}
	}
		
	/**
	 * metodo per l'eliminazione di un'area 3x3
	 * 
	 * @param first indice di riga
	 * @param second indice di colonna
	 * @param mat matrice degli elementi
	 */
	private void bomb(int first, int second, Element[][] mat){
			
		if(first > 0 && first < Utility.dim1-1 && second > 0 && second < Utility.dim2-1){
			for(int i = first-1; i < first+2; i++){
				for(int j = second-1; j < second +2; j++){
					mat[i][j].setColorNumber(-1);
					mat[i][j].setType(Utility.normal);
				}
			}
		}
			
		descend(mat);						
		resolve(mat);
	}

	/**
	* Metodo che compatta la matrice di gioco, facendo "scendere" le caramelle per sostiruire quelle 
	* eliminate
	* 
	* @param mat matrice degli elementi
	*/
	protected void descend(Element[][] mat){
		
		@SuppressWarnings("unused")
		
		int last = 0;
		Element app = new Element(-1);
		boolean flag = false;
		
		for(int j = Utility.dim2-1; j > -1; j--){
				for(int i = Utility.dim1-1; i > -1; i--){
			
					if(mat[i][j].getColorNumber() == -1){
						flag = false;
						last = i;
				
						/*una volta localizzata una posizione settata a -1 l'algoritmo 
						  inizia a risalire la colonna e sostituisce col primo elemento
						  non settato a -1 che incontra. Se al di sopra sono presenti solo 
						  elementi settati a -1 l'algoritmo non effettua scambi*/
						for(int k = i; k > -1; k--){
							if(mat[k][j].getColorNumber() != -1 && flag == false){
								
								app.setColorNumber(mat[i][j].getColorNumber());
								app.setType(mat[i][j].getType());
								
								mat[i][j].setColorNumber(mat[k][j].getColorNumber());
								mat[i][j].setType(mat[k][j].getType());
								
								mat[k][j].setColorNumber(app.getColorNumber());
								mat[k][j].setType(app.getType());
								
								flag = true;
							}
						}	
					}
				}
		}		
	}
	
	/**
	* Metodo che sostitisce tutte le caramelle settate a -1
	* generandone delle nuove
	* 
	* @param mat matrice degli elementi
	*/
	protected void resolve(Element[][] mat){
	
		for(int i = 0; i < Utility.dim1; i++){
			for(int j = 0; j < Utility.dim2; j++){
				if(mat[i][j].getColorNumber() == -1){
					mat[i][j].setColorNumber(generate());	
					mat[i][j].setType(Utility.normal);		
				}
			}
		}
	}

}
	
