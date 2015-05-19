package controller;

import javax.swing.SwingUtilities;
import view.ending.GameOver;
import view.play.GamePlayView;
import view.play.Shuffle;
import view.play.Update;
import view.ending.Win;
import model.Model;
import model.ModelUtilities;
/**
 * Classe che contiene il Controller dell'applicazione, che fa quindi da intermediario fra model e view come da pattern MVC.
 * 
 * @author Beatrice Ricci, Nicola Santolini
 *
 */
public class Controller implements ViewObserver, IController {
	
	private final Model model;
	private final GamePlayView view;
	private final Update up;
	private final Listener observer;
	
	/**
	 * Costruttore del controller.
	 * 
	 * @param v schermata principale di gioco
	 */
	public Controller(final GamePlayView v) {
		this.model = new Model();
		this.view = v;
		this.up = new Update(this, this.view);
		
		this.observer = new Listener();
		this.observer.addObserver(this);
		
		//model.creation();
	}
	
	@Override
	public int getModelNum(final int i, final int j) {
		return model.getColor(i, j);
	}
	
	@Override
	public int getModelType(final int i, final int j) {
		return model.getTypeEl(i, j);
	}
	
	@Override
	public int getModelStep() {
		return model.getStep();
	}
	
	@Override
	public int getModelTot() {
		return model.getScore();
	}
	
	@Override
	public void setModelStep(final int t) {
		model.setStep(t);
	}
	
	@Override
	public void setModelTarget(final int t) {
		model.setTarget(t);
	}
	
	@Override
	public Listener getObserver() {
		return this.observer;
	}
	
	@Override
	public void update(final int x1, final int y1, final int x2, final int y2) {
		if (model.checkExchange(x1, y1, x2, y2)) {
			model.doExchange(x1, y1, x2, y2);
			up.updateView();
			//CARAMELLA DA 5
			if (model.getMat()[x1][y1].getType() == Utility.FIVE
				|| model.getMat()[x2][y2].getType() == Utility.FIVE) {
				
				if (model.getMat()[x1][y1].getType() == Utility.FIVE) {
					model.getMat()[x1][y1].setColorNumber(ModelUtilities.generate());
					model.getMat()[x1][y1].setType(Utility.NORMAL);
					final int n = model.doFive(model.getMat()[x2][y2].getColorNumber());
					model.incScore(n * Utility.BONUS_POINTS);
				}
				if (model.getMat()[x2][y2].getType() == Utility.FIVE) {
					model.getMat()[x2][y2].setColorNumber(ModelUtilities.generate());
					model.getMat()[x2][y2].setType(Utility.NORMAL);
					final int n = model.doFive(model.getMat()[x1][y1].getColorNumber());
					model.incScore(n * Utility.BONUS_POINTS);
				}
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							Thread.sleep(Utility.HALF_SECOND);
						} catch (InterruptedException e) {
							System.out.println(e);	
						}
						up.updateView();
						finalControl();
					}
				});
			}
			//HAI FATTO TRIS -> DO
			if (model.goOn()) {
				//NON HAI FATTO TRIS -> UNDO
				model.decStep();
				SwingUtilities.invokeLater(new Runnable() {		
					public void run() {	
						while (model.goOn()) {
							try {
								Thread.sleep(Utility.HALF_SECOND);
							} catch (InterruptedException e) {
								System.out.println(e);
							}		
							model.gameLoop();	
							up.updateView();					
						}
						finalControl();
						while (!model.checkNextMove()) {
							ModelUtilities.shuffle(model.getMat());
							new Shuffle().goShuffle();
						}
					}
				});
			
			} else { 
				SwingUtilities.invokeLater(new Runnable() {	
					public void run() {
						try {
							Thread.sleep(Utility.HALF_SECOND);
						} catch (InterruptedException e) {
							System.out.println(e);
						}
						model.doExchange(x1, y1, x2, y2);
						up.updateView();	
					}
				});
				
			}
			up.updateView();
		}
	}
	
	private void finalControl() {
		//CONTROLLI VITTORIA/SCONFITTA
		if (this.model.getStep() == 0 && this.model.getScore() >= this.model.getTarget() 
				|| this.model.getScore() >= this.model.getTarget()) {
			this.view.closePage();
			new Win();
		}
		if (this.model.getStep() == 0 && this.model.getScore() < this.model.getTarget()) {
			this.view.closePage();
			new GameOver();
		}
	}
}