package model;

import controller.Utility;

/**
 * Classe che si occupa di effettuare i controlli delle possibili combinazioni
 * sulla matrice degli elementi
 * 
 * @author Nicola Santolini
 *
 */
public class Checks implements IChecks{

	private NextMoveChecker nextChecker;
	
	public Checks(){
		this.nextChecker = new NextMoveChecker();
	}
	
	public  boolean checkExchange(int x1, int y1, int x2, int y2){
		if(x2 == x1-1 && y1 == y2 || 
			x1 == x2 && y2 == y1-1 || 
			x1 == x2 && y2 == y1+1 || 
			x2 == x1+1 && y1 == y2){ 
			return true;
		}
		return false;
	}
	
	public boolean checkTris(Element[][] mat){	
		if(!checkTrisVertical(mat) && !checkTrisOrizontal(mat)){
			return false;
		}
		return true;	
	}
	
	public boolean checkTrisVertical(Element[][] mat){	
		for(int j = 0; j < Utility.dim2 ; j++){
			for(int i = 0; i < Utility.dim1 - 2; i++){
				if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber()
					&& mat[i+1][j].getColorNumber() == mat[i+2][j].getColorNumber()){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkTrisOrizontal(Element[][] mat){
		for(int i = 0; i < Utility.dim1 ; i++){
			for(int j = 0; j < Utility.dim2 - 2; j++){
				if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber()
					&& mat[i][j+1].getColorNumber() == mat[i][j+2].getColorNumber()){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkPokerVertical(Element[][] mat){
		for(int j = 0; j < Utility.dim2 ; j++){
			for(int i = 0; i < Utility.dim1 - 3; i++){
				if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i+2][j].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i+3][j].getColorNumber()){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkPokerOrizontal(Element[][] mat){
		for(int i = 0; i < Utility.dim1 ; i++){
			for(int j = 0; j < Utility.dim2 - 3; j++){
				if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i][j+2].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i][j+3].getColorNumber()){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkFiveOrizontal(Element[][] mat){
		for(int i = 0; i < Utility.dim1 ; i++){
			for(int j = 0; j < Utility.dim2 - 4; j++){
				if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i][j+2].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i][j+3].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i][j+4].getColorNumber()){
					return true;
				}
			}
		}
		return false;	
	}
	
	public boolean checkFiveVertical(Element[][] mat){
		for(int j = 0; j < Utility.dim2 ; j++){
			for(int i = 0; i < Utility.dim1 - 4; i++){
				if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i+2][j].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i+3][j].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i+4][j].getColorNumber()){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkWrapped(Element mat[][]){
		for(int i = 0; i < Utility.dim1 - 2; i++){
			for(int j = 0; j < Utility.dim2 - 2; j++){
				if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber()
						&& mat[i][j+1].getColorNumber() == mat[i][j+2].getColorNumber()){
					
					if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber() 
						&& mat[i][j].getColorNumber() == mat[i+2][j].getColorNumber()){
						return true;
					}
					if(mat[i][j+1].getColorNumber() == mat[i+1][j+1].getColorNumber() 
							&& mat[i][j+1].getColorNumber() == mat[i+2][j+1].getColorNumber()){
						return true;
					}
					if(mat[i][j+2].getColorNumber() == mat[i+1][j+2].getColorNumber() 
							&& mat[i][j+2].getColorNumber() == mat[i+2][j+2].getColorNumber()){
						return true;
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
						return true;
					}
					if(mat[i][j-1].getColorNumber() == mat[i-1][j-1].getColorNumber() 
							&& mat[i][j-1].getColorNumber() == mat[i-2][j-1].getColorNumber()){
						return true;
					}
					if(mat[i][j-2].getColorNumber() == mat[i-1][j-2].getColorNumber() 
							&& mat[i][j-2].getColorNumber() == mat[i-2][j-2].getColorNumber()){
						return true;
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
						return true;
					}
					if(mat[i+1][j].getColorNumber() == mat[i+1][j+1].getColorNumber() 
							&& mat[i+1][j].getColorNumber() == mat[i+1][j+2].getColorNumber()){
						return true;
					}
					if(mat[i+2][j].getColorNumber() == mat[i+2][j+1].getColorNumber() 
							&& mat[i+2][j].getColorNumber() == mat[i+2][j+2].getColorNumber()){
						return true;
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
						return true;
					}
					if(mat[i-1][j].getColorNumber() == mat[i-1][j-1].getColorNumber() 
							&& mat[i-1][j].getColorNumber() == mat[i-1][j-2].getColorNumber()){
						return true;				
					}
					if(mat[i-2][j].getColorNumber() == mat[i-2][j-1].getColorNumber() 
							&& mat[i-2][j].getColorNumber() == mat[i-2][j-2].getColorNumber()){
						return true;
					}	
				}	
			}
		}
		return false;
	}
	
	public boolean checkNextMove(Element mat[][]){
		return nextChecker.checkNextMove(mat);
	}
}
