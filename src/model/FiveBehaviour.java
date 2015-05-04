package model;

import controller.Utility;

/**
 * Classe che gestisce il comportamento da applicare quando si genera una
 * caramella SPECIAL, combinazione di 5 elementi dello stesso colore
 * 
 * @author Nicola Santolini
 *
 */
public class FiveBehaviour extends AbstractBehaviourController{

	/**
	 * Metodo che individua una combinazione di 5 elementi in orizzontale, posiziona
	 * una caramella SPECIAL e elimina quelle adiacenti nel modo corretto
	 * 
	 * @param mat matrice degli elementi
	 */
	public void doHorizontalFive(Element mat[][]){
		
		for(int i = 0; i < Utility.dim1 ; i++){
			for(int j = 0; j < Utility.dim2 - 4; j++){
				if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i][j+2].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i][j+3].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i][j+4].getColorNumber()){
					
					for(int k = 0; k < 5; k++){
						switchOptions(mat[i][j+k].getType(), i, j+k, mat);
					}
					mat[i][j+2].setColorNumber(Utility.special);
					mat[i][j+2].setType(Utility.five);
					mat[i][j].setColorNumber(-1);
					mat[i][j+1].setColorNumber(-1);
					mat[i][j+3].setColorNumber(-1);
					mat[i][j+4].setColorNumber(-1);
					
					descend(mat);
					resolve(mat);
				}
			}
		}
	}
	
	
	/**
	 * Metodo che individua una combinazione di 5 elementi in verticale, posiziona
	 * una caramella SPECIAL e elimina quelle adiacenti nel modo corretto
	 * 
	 * @param mat matrice degli elementi
	 */
	public void doVerticalFive(Element[][] mat){

		for(int j = 0; j < Utility.dim2 ; j++){
			for(int i = 0; i < Utility.dim1 - 4; i++){
				if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i+2][j].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i+3][j].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i+4][j].getColorNumber()){
						
					for(int k = 0; k < 5; k++){
						switchOptions(mat[i+k][j].getType(), i+k, j, mat);				
					}
					
					mat[i+4][j].setColorNumber(Utility.special);
					mat[i+4][j].setType(Utility.five);
					mat[i][j].setColorNumber(-1);
					mat[i+1][j].setColorNumber(-1);
					mat[i+2][j].setColorNumber(-1);
					mat[i+3][j].setColorNumber(-1);
					
					descend(mat);
					resolve(mat);
				}
			}
		}
	}

	/**
	 * Metodo che gestisce il comportamento da applicare quando si attiva una caramella 
	 * SPECIAL, che quando associata a una caramella di un qualsiasi colore, elimina
	 * tutte le caramelle di quel colore; per ogni caramella eliminata in questo modo
	 * vengono attribuiti punti bonus
	 * 
	 * @param color colore con cui è stata abbinata la caramella SPECIAL
	 * @param mat matrice degli elementi
	 * @return il numero di caramelle che sono state eliminate
	 */
	public int doFive(int color, Element[][] mat){
		int n = 0;
		for(int i = 0; i < Utility.dim1; i++){
			for(int j = 0; j < Utility.dim2; j++){
				if(mat[i][j].getColorNumber() == color){
					mat[i][j].setColorNumber(-1);
					mat[i][j].setType(Utility.normal);
					n++;
				}
			}
		}
		descend(mat);									
		resolve(mat);
		
		return n;
	}
	
	
	
}
