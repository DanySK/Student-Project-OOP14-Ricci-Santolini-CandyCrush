package controller;

import javax.swing.SwingUtilities;

import view.*;
import model.*;
/**
 * Classe che contiene il Controller dell'applicazione, che fa quindi da intermediario fra model e view come da pattern MVC
 * 
 * @author Beatrice Ricci, Nicola Santolini
 *
 */
public class Controller implements ViewObserver, IController{
	
	private final Model model;
	private final PlayGameMenu view;
	private final Update up;
	private final Listener observer;
		
	public Controller(PlayGameMenu v){
		this.model = new Model();
		this.view = v;
		this.up = new Update(this, this.view);
		
		this.observer = new Listener();
		this.observer.addObserver(this);
	}
	
	public int getModelNum(int i, int j){
		return model.getColor(i, j);
	}
	
	public int getModelType(int i, int j){
		return model.getTypeEl(i, j);
	}
	
	public int getModelStep(){
		return model.getStep();
	}
	
	public int getModelTot(){
		return model.getScore();
	}
	
	public void setModelStep(int t){
		model.setStep(t);
	}
	
	public void setModelTarget(int t){
		model.setTarget(t);
	}
	
	private void finalControl(){
		//CONTROLLI VITTORIA/SCONFITTA
		if((this.model.getStep() == 0 && this.model.getScore() >= this.model.getTarget()) || 
				(this.model.getScore() >= this.model.getTarget())){
			this.view.closePage();
			new Win();
		}
		if(this.model.getStep() == 0 && this.model.getScore() < this.model.getTarget()){
			this.view.closePage();
			new GameOver();
		}
	}
	
	public Listener getObserver(){
		return this.observer;
	}
	
	public void update(int x1, int y1, int x2, int y2) {
		if(model.checkExchange(x1, y1, x2, y2)){
			model.doExchange(x1, y1, x2, y2);
			up.updateView();
			//CARAMELLA DA 5
			if(model.getMat()[x1][y1].getType() == Utility.five
				|| model.getMat()[x2][y2].getType() == Utility.five){
				
				if(model.getMat()[x1][y1].getType() == Utility.five){
					model.getMat()[x1][y1].setColorNumber(model.generate());
					model.getMat()[x1][y1].setType(Utility.normal);
					int n = model.doFive(model.getMat()[x2][y2].getColorNumber());
					model.incScore(n * 50);
				}
				if(model.getMat()[x2][y2].getType() == Utility.five){
					model.getMat()[x2][y2].setColorNumber(model.generate());
					model.getMat()[x2][y2].setType(Utility.normal);
					int n = model.doFive(model.getMat()[x1][y1].getColorNumber());
					model.incScore(n * 50);
				}
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						up.updateView();
						finalControl();
					}
				});
			}
			//NON HAI FATTO TRIS -> UNDO
			if(!model.goOn()){
				SwingUtilities.invokeLater(new Runnable() {	
					public void run() {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						model.doExchange(x1, y1, x2, y2);
						up.updateView();	
					}
				});
			}
			//HAI FATTO TRIS -> DO
			else{
				model.decStep();
				SwingUtilities.invokeLater(new Runnable() {		
						public void run() {	
							while(model.goOn()){
								try {
									Thread.sleep(500);
								} catch (InterruptedException e) {
									e.printStackTrace();
								}		
								model.gameLoop();	
								up.updateView();					
							}
							finalControl();
							while(!model.checkNextMove()){
								model.shuffle();
								new Shuffle().goShuffle();
							}
						}
					});
			}
			up.updateView();
		}
	}
}