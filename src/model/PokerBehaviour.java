package model;

import controller.Utility;

/**
 * CLasse che contiene i comportamenti da applicare per gestire combinazioni
 * di quattro caramelle in verticale o in orizzontale
 * 
 * @author Nicola Santolini
 *
 */

public class PokerBehaviour extends AbstractBehaviourController{

	/**
	* Metodo per la gestione di una combinazione da quattro in verticale
	* 
	* @param mat matrice degli elementi
	*/
	public void doVerticalPoker(Element mat[][]){
		
		for(int j = 0; j < Utility.dim2 ; j++){
			for(int i = 0; i < Utility.dim1 - 3; i++){
				if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i+2][j].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i+3][j].getColorNumber()){
				
					for(int k = 0; k < 4; k++){
						switchOptions(mat[i+k][j].getType(), i+k, j, mat);				
					}
					mat[i][j].setType(Utility.stripedV);
					mat[i+1][j].setColorNumber(-1);
					mat[i+2][j].setColorNumber(-1);
					mat[i+3][j].setColorNumber(-1);
				}
				descend(mat);
				resolve(mat);			
			}											
		}
	}
		
	/**
	 * Metodo per la gestione di una combinazione da quattro in orizzontale
	 * 
	 * @param mat
	 */
	public void doHorizontalPoker(Element mat[][]){
		
		for(int i = 0; i < Utility.dim1 ; i++){
			for(int j = 0; j < Utility.dim2 - 3; j++){
				if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i][j+2].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i][j+3].getColorNumber()){	
					
					for(int k = 0; k < 4; k++){
						switchOptions(mat[i][j+k].getType(), i, j+k, mat);
					}				
					mat[i][j+1].setType(Utility.stripedO);
					mat[i][j].setColorNumber(-1);
					mat[i][j+2].setColorNumber(-1);
					mat[i][j+3].setColorNumber(-1);
				}				
				descend(mat);
				resolve(mat);
			}			
		}

	}

}
