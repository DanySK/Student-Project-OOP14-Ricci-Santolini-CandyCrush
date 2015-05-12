package view;

import controller.Controller;
import controller.Utility;

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
	private final PlayGameMenu pgm;
	
	/**
	 * Costruttore con passaggio di parametri.
	 * @param controller controller che dice alla classe come aggiornare la schermata di gioco
	 * @param play schermata di gioco
	 */
	public Update(final Controller controller, final PlayGameMenu play) {
		this.c = controller;
		this.pgm = play;
	}
	
	/**
	 * Metodo che aggiorna la matrice della view in base a quella del modello.
	 */
	public void updateView() {
			
		for (int i = 0; i < Utility.DIM1; i++) {
			for (int j = 0; j < Utility.DIM2; j++) {

				if (this.c.getModelType(i, j) == Utility.NORMAL) {
					if (this.c.getModelNum(i, j) == Utility.BLUE) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.BLUEIC);
					} else if (this.c.getModelNum(i, j) == Utility.YELLOW) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.YELLOWIC);
					} else if (this.c.getModelNum(i, j) == Utility.GREEN) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.GREENIC);
					} else if (this.c.getModelNum(i, j) == Utility.VIOLET) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.VIOLETIC);
					} else if (this.c.getModelNum(i, j) == Utility.ORANGE) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.ORANGEIC);
					} else if (this.c.getModelNum(i, j) == Utility.RED) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.REDIC);
					}
				} else if (this.c.getModelType(i, j) == Utility.STRIPED_V) {
					if (this.c.getModelNum(i, j) == Utility.BLUE) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.BLUEVIC);
					} else if (this.c.getModelNum(i, j) == Utility.YELLOW) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.YELLOWSVIC);
					} else if (this.c.getModelNum(i, j) == Utility.GREEN) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.GREENSVIC);
					} else if (this.c.getModelNum(i, j) == Utility.VIOLET) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.VIOLETSVIC);
					} else if (this.c.getModelNum(i, j) == Utility.ORANGE) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.ORANGESVIC);
					} else if (this.c.getModelNum(i, j) == Utility.RED) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.REDSVIC);
					}
				} else if (this.c.getModelType(i, j) == Utility.STRIPED_O) {
					if (this.c.getModelNum(i, j) ==  Utility.BLUE) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.BLUESOIC);
					} else if (this.c.getModelNum(i, j) ==  Utility.YELLOW) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.YELLOWSOIC);
					} else if (this.c.getModelNum(i, j) ==  Utility.GREEN) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.GREENSOIC);
					} else if (this.c.getModelNum(i, j) ==  Utility.VIOLET) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.VIOLETSOIC);
					} else if (this.c.getModelNum(i, j) ==  Utility.ORANGE) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.ORANGESOIC);
					} else if (this.c.getModelNum(i, j) ==  Utility.RED) {
						this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.REDSOIC);
					}
				} else if (this.c.getModelType(i, j) == Utility.WRAPPED) {
						if (this.c.getModelNum(i, j) == Utility.BLUE) {
							this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.BLUEWIC);
						} else if (this.c.getModelNum(i, j) == Utility.YELLOW) {
							this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.YELLOWWIC);
						} else if (this.c.getModelNum(i, j) == Utility.GREEN) {
							this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.GREENWIC);
						} else if (this.c.getModelNum(i, j) == Utility.VIOLET) {
							this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.VIOLETWIC);
						} else if (this.c.getModelNum(i, j) == Utility.ORANGE) {
							this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.ORANGEWIC);
						} else if (this.c.getModelNum(i, j) == Utility.RED) {
							this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.REDWIC);
						}
				} else if (this.c.getModelType(i, j) == Utility.FIVE) {
					this.pgm.getAMatrixButt(i, j).setIcon(IconUtility.FIVEIC);
				}
				this.updateLabel();
			}		
		}
	}
	
	/**
	 * Metodo per aggiornare il totale delle mosse e del punteggio ottenuto
	 */
	private void updateLabel() {
		this.pgm.updateStep(this.c.getModelStep());
		this.pgm.updateTot();
	}
}
