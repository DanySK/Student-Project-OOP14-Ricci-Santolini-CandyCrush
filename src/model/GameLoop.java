package model;

/**
 * Classe che implementa l'interfaccia di "facciata" e interagisce con il Board e i gestori dei comportamenti.
 * 
 * @author Nicola Santolini
 */

public class GameLoop implements IGameLoop {

	private final IBoard board;
	
	private final IChecks checker;
	
	private final TrisBehaviour trisController;
	private final PokerBehaviour pokerController;
	private final WrappedBehaviour wrappedController;
	private final FiveBehaviour fiveController;
	
	
	
	/**
	 * Costruttore.
	 */
	public GameLoop() {
		
		this.board = new Board();
		
		this.checker = new Checks();
		
		this.trisController = new TrisBehaviour();
		this.pokerController = new PokerBehaviour();
		this.wrappedController = new WrappedBehaviour();
		this.fiveController = new FiveBehaviour();
		
		creation();
	}
	
	@Override
	public int gameLoop() {

		if (checker.checkFiveVertical(board.getMat())) {
			fiveController.makeVertical(board.getMat());
			return ModelUtilities.SPECIAL_POINTS;
		} else if (checker.checkFiveHorizontal(board.getMat())) {
			fiveController.makeHorizontal(board.getMat());
			return ModelUtilities.SPECIAL_POINTS;
		} else if (checker.checkWrapped(board.getMat())) {
			wrappedController.controlWrapped(board.getMat());
			return ModelUtilities.WRAPPED_POINTS;
		} else if (checker.checkPokerVertical(board.getMat())) {
			pokerController.makeVertical(board.getMat());
			return ModelUtilities.STRIPED_POINTS;
		} else if (checker.checkPokerHorizontal(board.getMat())) {
			pokerController.makeHorizontal(board.getMat());
			return ModelUtilities.STRIPED_POINTS;
		} else if (checker.checkTrisVertical(board.getMat())) {
			trisController.makeVertical(board.getMat());
			return ModelUtilities.TRIS_POINTS;
		} else if (checker.checkTrisHorizontal(board.getMat())) {
			trisController.makeHorizontal(board.getMat());
			return ModelUtilities.TRIS_POINTS;
		}
		return 0;
	}
	
	/**
	 * Metodo che dopo la prima inizializzazione della matrice di gioco la controlla 
	 * e rimescola finchè non si trova in una situazione corretta per iniziare a giocare: 
	 * nessun tris già in posizione ma almeno uno realizzabile in una mossa.
	 */
	private void creation() {
		
		while (!checker.checkNextMove(board.getMat()) || checker.checkTris(board.getMat())) {
			ModelUtilities.shuffle(board.getMat());
		}
	}
	
	@Override
	public Candy[][] getMat() {
		return board.getMat();
	}
	
	@Override
	public boolean checkTris() {
		return checker.checkTris(board.getMat());
	}
	
	@Override
	public boolean checkNextMove() {
		return checker.checkNextMove(board.getMat());
	}
	
	@Override
	public void doExchange(final int x1, final int y1, final int x2, final int y2) {
		board.doExchange(x1, y1, x2, y2);
	}
	
	@Override
	public int doFive(final int c) {
		return fiveController.doFive(board.getMat(), c);
	}
	
}
