package model;

import controller.Utility;

/**
 * Classe che contiene il core della parte di model dell'applicazione, in 
 * particolare la matrice di gioco degli elementi.
 * 
 * @author Nicola Santolini
 *
 */
public class Model implements IModel {
	
	private Element[][] mat = new Element[Utility.DIM1][Utility.DIM2];
	
	private int score;
	private int target;
	private int step;
	
	private final IChecks checker;
	private final TrisBehaviour trisController;
	private final PokerBehaviour pokerController;
	private final WrappedBehaviour wrappedController;
	private final FiveBehaviour fiveController;
		
	/**
	 * Costruttore.
	 */
	public Model() {
		
		for (int i = 0; i < Utility.DIM1; i++) {	
			for (int j = 0; j < Utility.DIM2; j++) {
				mat[i][j] = new Element(ModelUtilities.generate());
			}
		}
		
		this.checker = new Checks();
		this.trisController = new TrisBehaviour();
		this.pokerController = new PokerBehaviour();
		this.wrappedController = new WrappedBehaviour();
		this.fiveController = new FiveBehaviour();
	}
	
	/**
	 * Metodo che dopo la prima inizializzazione della matrice di gioco la controlla 
	 * e rimescola finchè non si trova in una situazione corretta per iniziare a giocare: 
	 * nessun tris già in posizione ma almeno uno realizzabile in una mossa.
	 */
	public void creation() {
		
		while (!checker.checkNextMove(this.mat) || checker.checkTris(this.mat)) {
			ModelUtilities.shuffle(this.mat);
		}
	}
	
	@Override
	public void decStep() {
		this.step--;
	}
	
	@Override
	public int getScore() {
		return this.score;
	}
	
	@Override
	public int getStep() {
		return this.step;
	}
		
	@Override
	public int getTarget() {
		return this.target;
	}
			
	@Override
	public int getColor(final int i, final int j) {
		return this.mat[i][j].getColorNumber();
	}	
	
	@Override
	public int getTypeEl(final int i, final int j) {
		return this.mat[i][j].getType();
	}
	
	@Override
	public Element[][] getMat() {
		return this.mat;
	}
	
	@Override
	public void setStep(final int num) {
		this.step = num;
	}
	
	@Override
	public void incScore(final int num) {
		this.score = this.getScore() + num;
	}
	
	@Override
	public void setTarget(final int num) {
		this.target = num;
	}
	
	@Override
	public  boolean checkExchange(final int x1, final int y1, final int x2, final int y2) {
		if (x2 == x1 - 1 && y1 == y2 
			|| x1 == x2 && y2 == y1 - 1 
			|| x1 == x2 && y2 == y1 + 1 
			|| x2 == x1 + 1 && y1 == y2) { 
			return true;
		}
		return false;
	}
	
	@Override
	public void doExchange(final int x1, final int y1, final int x2, final int y2) {
		final Element app = new Element();

		app.setColorNumber(mat[x1][y1].getColorNumber());
		app.setType(mat[x1][y1].getType());
		
		mat[x1][y1].setColorNumber(mat[x2][y2].getColorNumber());
		mat[x1][y1].setType(mat[x2][y2].getType());
		
		mat[x2][y2].setColorNumber(app.getColorNumber());
		mat[x2][y2].setType(app.getType());
	}
		
	@Override
	public boolean goOn() {
		return checker.checkTris(this.mat); 	
	}
	
	@Override
	public boolean checkNextMove() {
		return checker.checkNextMove(this.mat);
	}
	
	@Override
	public int doFive(final int c) {
		return fiveController.doFive(this.mat, c);
	}
	
	@Override
	public void gameLoop() {
		
		if (checker.checkFiveHorizontal(this.mat)) {
			fiveController.doHorizontalFive(this.mat);
			incScore(ModelUtilities.SPECIAL_POINTS);
		} else if (checker.checkFiveVertical(this.mat)) {
			fiveController.doVerticalFive(this.mat);
			incScore(ModelUtilities.SPECIAL_POINTS);
		} else if (checker.checkWrapped(this.mat)) {
			wrappedController.controlWrapped(this.mat);
			incScore(ModelUtilities.WRAPPED_POINTS);
		} else if (checker.checkPokerVertical(this.mat)) {
			pokerController.doVerticalPoker(this.mat);
			incScore(ModelUtilities.STRIPED_POINTS);
		} else if (checker.checkPokerHorizontal(this.mat)) {
			pokerController.doHorizontalPoker(this.mat);
			incScore(ModelUtilities.STRIPED_POINTS);
		} else if (checker.checkTrisVertical(this.mat)) {
			trisController.doVerticalTris(this.mat);
			incScore(ModelUtilities.TRIS_POINTS);
		} else if (checker.checkTrisHorizontal(this.mat)) {
			trisController.doHorizontalTris(this.mat);
			incScore(ModelUtilities.TRIS_POINTS);
		}	
		
		while (!checker.checkNextMove(this.mat)) {
			ModelUtilities.shuffle(this.mat);
		}
		
	}
}