package model;

//import controller.Utility;

/**
 * Classe che contiene il core della parte di model dell'applicazione, in 
 * particolare la matrice di gioco degli elementi.
 * 
 * @author Nicola Santolini
 *
 */
public class Model implements IModel {
	
	private final IGameLoop gameLoop;
	
	private int target;
	private int step;
	private int score;
	
	/**
	 * Costruttore.
	 */
	public Model() {	
		this.gameLoop = new GameLoop();
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
		return this.getMat()[i][j].getColorNumber();
	}	
	
	@Override
	public int getTypeEl(final int i, final int j) {
		return this.getMat()[i][j].getType();
	}
	
	@Override
	public Candy[][] getMat() {
		return gameLoop.getMat();
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
		gameLoop.doExchange(x1, y1, x2, y2);
	}
		
	@Override
	public boolean goOn() {
		return gameLoop.checkTris(); 	
	}
	
	@Override
	public boolean checkNextMove() {
		return gameLoop.checkNextMove();
	}
	
	@Override
	public int doFive(final int c) {
		return gameLoop.doFive(c);
	}
	
	@Override
	public void gameLoop() {
		int points = gameLoop.gameLoop();
		incScore(points);
		
		while (!gameLoop.checkNextMove()) {
			ModelUtilities.shuffle(gameLoop.getMat());
		}
		
	}
}