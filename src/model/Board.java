package model;

import controller.Utility;

/**
 * Classe che implementa l'interfaccia della matrice di gioco.
 * 
 * @author Nicola Santolini
 */
public class Board implements IBoard {
	
	private final Candy[][] mat = new Candy[Utility.DIM1][Utility.DIM2];

	/**
	 * Costruttore.
	 */
	public Board() {
		
		for (int i = 0; i < Utility.DIM1; i++) {	
			for (int j = 0; j < Utility.DIM2; j++) {
				mat[i][j] = new Candy(ModelUtilities.generate());
			}
		}
	}

	@Override
	public Candy[][] getMat() {
		return this.mat;
	}
	
	@Override
	public void doExchange(final int x1, final int y1, final int x2, final int y2) {
		final Candy app = new Candy();

		app.setColorNumber(mat[x1][y1].getColorNumber());
		app.setType(mat[x1][y1].getType());
		
		mat[x1][y1].setColorNumber(mat[x2][y2].getColorNumber());
		mat[x1][y1].setType(mat[x2][y2].getType());
		
		mat[x2][y2].setColorNumber(app.getColorNumber());
		mat[x2][y2].setType(app.getType());
	}
}
