package model;

import controller.Utility;

/**
 * Classe che contiene i comportamenti da applicare per gestire tris
 * verticali e orizzontali
 * 
 * @author Nicola Santolini
 *
 */
public class TrisBehaviour extends AbstractBehaviourController{

	/**
	 * Metodo per la gestione di un tris in verticale
	 * 
	 * @param mat matrice degli elementi
	 */
	public void doVerticalTris(Element mat[][]){
			
		for(int j = 0; j < Utility.dim2 ; j++){
			for(int i = 0; i < Utility.dim1 - 2; i++){
				if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber()
					&& mat[i+1][j].getColorNumber() == mat[i+2][j].getColorNumber()){
				
					for(int k = 0; k < 3; k++){
						switchOptions(mat[i+k][j].getType(), i+k, j, mat);				
					}		
					mat[i][j].setColorNumber(-1);
					mat[i+1][j].setColorNumber(-1);
					mat[i+2][j].setColorNumber(-1);								
				}	
				descend(mat);
				resolve(mat);		
			}
		}					
	}
	
	/**
	 * Metodo per la gestione di un tris in orizzontale
	 * 
	 * @param mat matrice degli elementi
	 */
	public void doHorizontalTris(Element mat[][]){
		
		for(int i = 0; i < Utility.dim1 ; i++){
			for(int j = 0; j < Utility.dim2 - 2; j++){
				if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber()
					&& mat[i][j+1].getColorNumber() == mat[i][j+2].getColorNumber()){	
					
					for(int k = 0; k < 3; k++){
						switchOptions(mat[i][j+k].getType(), i, j+k, mat);				
					}	
					mat[i][j].setColorNumber(-1);
					mat[i][j+1].setColorNumber(-1);
					mat[i][j+2].setColorNumber(-1);
				}
				descend(mat);
				resolve(mat);		
			}
		}
	}
}
