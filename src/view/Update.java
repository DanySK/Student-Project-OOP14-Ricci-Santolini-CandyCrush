package view;

import controller.*;
/**
 * Classe il cui compito è quello di prendere i dati della matrice numerica del modello dal controller e 
 * di aggiornare la matrice che vede l'utente sulla base di quella che legge.
 * Questo è possibile controllando il tipo dell'elemento ed il suo colore.
 * 
 * @author Beatrice Ricci
 *
 */
public class Update {
	private final Controller c;
	private PlayGameMenu pgm;
	
	public Update(Controller c, PlayGameMenu pgm){
		this.c = c;
		this.pgm = pgm;
	}
	/**
	 * Metodo che aggiorna la matrice della view in base a quella del modello
	 */
	public void updateView(){
			
		for(int i = 0; i < Utility.dim1; i++){
			for(int j = 0; j < Utility.dim2; j++){
				//normal type
				if (this.c.getModelType(i, j) == Utility.normal){
					if (this.c.getModelNum(i, j) == Utility.blue){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.blueIC);
					}else if (this.c.getModelNum(i, j) == Utility.yellow){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.yellowIC);
					}else if (this.c.getModelNum(i, j) == Utility.green){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.greenIC);
					}else if (this.c.getModelNum(i, j) == Utility.violet){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.violetIC);
					}else if (this.c.getModelNum(i, j) == Utility.orange){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.orangeIC);
					}else if (this.c.getModelNum(i, j) == Utility.red){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.redIC);
					}
				}
				//stripped Ver type
				else if (this.c.getModelType(i, j) == Utility.stripedV){
					if (this.c.getModelNum(i, j) == Utility.blue){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.blueSVIC);
					}else if (this.c.getModelNum(i, j) == Utility.yellow){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.yellowSVIC);
					}else if (this.c.getModelNum(i, j) == Utility.green){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.greenSVIC);
					}else if (this.c.getModelNum(i, j) == Utility.violet){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.violetSVIC);
					}else if (this.c.getModelNum(i, j) == Utility.orange){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.orangeSVIC);
					}else if (this.c.getModelNum(i, j) == Utility.red){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.redSVIC);
					}
				}//stripped Or type
				else if (this.c.getModelType(i, j) == Utility.stripedO){
					if (this.c.getModelNum(i, j) ==  Utility.blue){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.blueSOIC);
					}else if (this.c.getModelNum(i, j) ==  Utility.yellow){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.yellowSOIC);
					}else if (this.c.getModelNum(i, j) ==  Utility.green){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.greenSOIC);
					}else if (this.c.getModelNum(i, j) ==  Utility.violet){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.violetSOIC);
					}else if (this.c.getModelNum(i, j) ==  Utility.orange){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.orangeSOIC);
					}else if (this.c.getModelNum(i, j) ==  Utility.red){
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.redSOIC);
					}
				}//wrapped
				else if (this.c.getModelType(i, j) == Utility.wrapped){
						if (this.c.getModelNum(i, j) == Utility.blue){
							this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.blueWIC);
						}else if (this.c.getModelNum(i, j) == Utility.yellow){
							this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.yellowWIC);
						}else if (this.c.getModelNum(i, j) == Utility.green){
							this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.greenWIC);
						}else if (this.c.getModelNum(i, j) == Utility.violet){
							this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.violetWIC);
						}else if (this.c.getModelNum(i, j) == Utility.orange){
							this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.orangeWIC);
						}else if (this.c.getModelNum(i, j) == Utility.red){
							this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.redWIC);
						}
				}//five
				else if (this.c.getModelType(i, j) == Utility.five){
					this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.fiveIC);
				}
				this.updateLabel();
			}		
		}
	}
	/**
	 * Metodo per aggiornare il totale delle mosse e del punteggio ottenuto
	 */
	private void updateLabel(){
		this.pgm.updateStep(this.c.getModelStep());
		this.pgm.updateTot();
	}
}
