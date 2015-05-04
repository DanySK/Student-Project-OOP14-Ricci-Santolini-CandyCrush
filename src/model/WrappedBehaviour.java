package model;

import controller.Utility;

/**
 * Classe che contiene i comportamenti da applicare per gestire una caramella "wrapped"
 * 
 * @author Nicola Santolini
 *
 */
public class WrappedBehaviour extends AbstractBehaviourController{

	/**
	 * Metodo che controlla la presenza di due tris con una caramella in comune,
	 * che generano una caramella "wrapped". Viene poi invocato un metodo che si occupa di aggiornare 
	 * la matrice, a cui viene passato un codice numerico necessario per poter gestire l'evento,
	 * poichè le situazioni che generano questa combinazione di caramelle sono molteplici
	 * 
	 * @param mat matrice degli elementi
	 */
	public void controlWrapped(Element[][] mat){
			
			for(int i = 0; i < Utility.dim1 - 2; i++){
				for(int j = 0; j < Utility.dim2 - 2; j++){
					if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber()
							&& mat[i][j+1].getColorNumber() == mat[i][j+2].getColorNumber()){
						
						if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber() 
							&& mat[i][j].getColorNumber() == mat[i+2][j].getColorNumber()){
							doWrapped(mat, i+2, j, 1, mat[i][j].getColorNumber());
						}
						if(mat[i][j+1].getColorNumber() == mat[i+1][j+1].getColorNumber() 
								&& mat[i][j+1].getColorNumber() == mat[i+2][j+1].getColorNumber()){
							doWrapped(mat, i+2, j+1, 3, mat[i][j].getColorNumber());
						}
						if(mat[i][j+2].getColorNumber() == mat[i+1][j+2].getColorNumber() 
								&& mat[i][j+2].getColorNumber() == mat[i+2][j+2].getColorNumber()){
							doWrapped(mat, i+2, j+2, 5, mat[i][j].getColorNumber());	
						}	
					}	
				}
			}
			for(int i = Utility.dim1-1; i > 1; i--){
				for(int j = Utility.dim2-1; j > 1; j--){
					if(mat[i][j].getColorNumber() == mat[i][j-1].getColorNumber()
							&& mat[i][j-1].getColorNumber() == mat[i][j-2].getColorNumber()){
						
						if(mat[i][j].getColorNumber() == mat[i-1][j].getColorNumber() 
							&& mat[i][j].getColorNumber() == mat[i-2][j].getColorNumber()){
							doWrapped(mat, i, j, 6, mat[i][j].getColorNumber());
						}
						if(mat[i][j-1].getColorNumber() == mat[i-1][j-1].getColorNumber() 
								&& mat[i][j-1].getColorNumber() == mat[i-2][j-1].getColorNumber()){
							doWrapped(mat, i, j-1, 4, mat[i][j].getColorNumber());
						}
						if(mat[i][j-2].getColorNumber() == mat[i-1][j-2].getColorNumber() 
								&& mat[i][j-2].getColorNumber() == mat[i-2][j-2].getColorNumber()){
							doWrapped(mat, i, j-2, 2, mat[i][j].getColorNumber());
						}	
					}	
				}
			}		
			for(int j = 0; j < Utility.dim2 - 2; j++){
				for(int i = 0; i < Utility.dim1 - 2; i++){
					if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber()
						&& mat[i][j].getColorNumber() == mat[i+2][j].getColorNumber()){
						
						if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber() 
							&& mat[i][j].getColorNumber() == mat[i][j+2].getColorNumber()){
							doWrapped(mat, i+2, j, 1, mat[i][j].getColorNumber());
						}
						if(mat[i+1][j].getColorNumber() == mat[i+1][j+1].getColorNumber() 
								&& mat[i+1][j].getColorNumber() == mat[i+1][j+2].getColorNumber()){
							doWrapped(mat, i+2, j, 7, mat[i][j].getColorNumber());
						}
						if(mat[i+2][j].getColorNumber() == mat[i+2][j+1].getColorNumber() 
								&& mat[i+2][j].getColorNumber() == mat[i+2][j+2].getColorNumber()){
							doWrapped(mat, i+2, j, 2, mat[i][j].getColorNumber());
						}	
					}	
				}
			}
			for(int j = Utility.dim2-1; j > 1; j--){
				for(int i = Utility.dim1-1; i > 1; i--){
					if(mat[i][j].getColorNumber() == mat[i-1][j].getColorNumber()
						&& mat[i][j].getColorNumber() == mat[i-2][j].getColorNumber()){
						
						if(mat[i][j].getColorNumber() == mat[i][j-1].getColorNumber() 
							&& mat[i][j].getColorNumber() == mat[i][j-2].getColorNumber()){
							doWrapped(mat, i, j, 6, mat[i][j].getColorNumber());
						}
						if(mat[i-1][j].getColorNumber() == mat[i-1][j-1].getColorNumber() 
								&& mat[i-1][j].getColorNumber() == mat[i-1][j-2].getColorNumber()){
							doWrapped(mat, i, j, 8, mat[i][j].getColorNumber());						
						}
						if(mat[i-2][j].getColorNumber() == mat[i-2][j-1].getColorNumber() 
								&& mat[i-2][j].getColorNumber() == mat[i-2][j-2].getColorNumber()){
							doWrapped(mat, i, j, 5, mat[i][j].getColorNumber());
						}	
					}	
				}
			}
		}
		
	
	//1 -> |^, 2 -> L, 3 -> T,4 -> _|_, 5 -> 7, 6 -> _|, 7 -> |-, 8 -> -|
	/**
	 * Metodo che posizione una caramella "wrapped" e elimina le caramelle nelle posizioni corrette.
	 * Per fare ciò si usa un codice numerico che indica il tipo di conformazione che ha generato
	 * la combinazione di due tris con una caramella in comune, ad esempio una conformazione
	 * a "L" o a "T"
	 * 
	 * @param mat matrice degli elementi
	 * @param i	indice di riga
	 * @param j indice di colonna
	 * @param type codice che identifica il tipo di combinazione da gestire
	 * @param color codice del colore della caramella generata
	 */
	public void doWrapped(Element mat[][], int i, int j, int type, int color){

		mat[i][j].setType(Utility.wrapped);
		mat[i][j].setColorNumber(color);
		
		switch(type){
		
			case 1:
				mat[i-1][j].setColorNumber(-1);
				mat[i-2][j].setColorNumber(-1);
				mat[i-2][j+1].setColorNumber(-1);
				mat[i-2][j+2].setColorNumber(-1);
				break;
						
			case 2:
				mat[i-1][j].setColorNumber(-1);
				mat[i-2][j].setColorNumber(-1);
				mat[i][j+1].setColorNumber(-1);
				mat[i][j+2].setColorNumber(-1);
				break;
				
			case 3:
				mat[i-1][j].setColorNumber(-1);
				mat[i-2][j].setColorNumber(-1);
				mat[i-2][j-1].setColorNumber(-1);
				mat[i-2][j+1].setColorNumber(-1);
				break;

			case 4:
				mat[i-1][j].setColorNumber(-1);
				mat[i-2][j].setColorNumber(-1);
				mat[i][j-1].setColorNumber(-1);
				mat[i][j+1].setColorNumber(-1);
				break;

			case 5:
				mat[i-1][j].setColorNumber(-1);
				mat[i-2][j].setColorNumber(-1);
				mat[i-2][j-1].setColorNumber(-1);
				mat[i-2][j-2].setColorNumber(-1);
				break;

			case 6:
				mat[i-1][j].setColorNumber(-1);
				mat[i-2][j].setColorNumber(-1);
				mat[i][j-1].setColorNumber(-1);
				mat[i][j-2].setColorNumber(-1);
				break;

			case 7:
				mat[i-1][j].setColorNumber(-1);
				mat[i-2][j].setColorNumber(-1);
				mat[i-1][j+1].setColorNumber(-1);
				mat[i-1][j+2].setColorNumber(-1);
				break;

			case 8:
				mat[i-1][j].setColorNumber(-1);
				mat[i-2][j].setColorNumber(-1);
				mat[i-1][j-1].setColorNumber(-1);
				mat[i-1][j-2].setColorNumber(-1);
				break;

			default: 
		}
		descend(mat);
		resolve(mat);
	}
	
	
	
}
