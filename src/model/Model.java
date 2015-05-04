package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import controller.Utility;

/**
 * Classe che contiene il core della parte di model dell'applicazione, in 
 * particolare la matrice di gioco degli elementi
 * 
 * @author Nicola Santolini
 *
 */
public class Model implements IModel{
	
	private Element mat[][] = new Element[Utility.dim1][Utility.dim2];
	
	private int score = 0;
	private int target;
	private int step;
	
	private IChecks checker;
	
	private TrisBehaviour trisController;
	private PokerBehaviour pokerController;
	private WrappedBehaviour wrappedController;
	private FiveBehaviour fiveController;
	
	public Model(){
		
		for(int i = 0; i< Utility.dim1; i++){	
			for(int j = 0; j< Utility.dim2; j++){
				mat[i][j] = new Element(generate());
			}
		}
		
		this.checker = new Checks();
		this.trisController = new TrisBehaviour();
		this.pokerController = new PokerBehaviour();
		this.wrappedController = new WrappedBehaviour();
		this.fiveController = new FiveBehaviour();
	
		this.creation();
	}
	
	/**
	 * Metodo che dopo la prima inizializzazione della matrice di gioco
	 * la controlla e rimescola finchè non si trova in una situazione corretta per
	 * iniziare a giocare: nessun tris già in posizione ma almeno uno realizzabile in
	 * una mossa
	 */
	private void creation(){
		
		while(!checker.checkNextMove(this.mat) || checker.checkTris(this.mat)){
			this.shuffle();
		}
	}
	
	public void decStep(){
		this.step--;
	}
	
	public int getScore(){
		return this.score;
	}
	
	public int getStep(){
		return this.step;
	}
		
	public int getTarget(){
		return this.target;
	}
			
	public int getColor(int i, int j){
		return this.mat[i][j].getColorNumber();
	}	
	
	public int getTypeEl(int i, int j){
		return this.mat[i][j].getType();
	}
	
	public Element[][] getMat(){
		return this.mat;
	}
	
	public void setStep(int num){
		this.step = num;
	}
	
	public void incScore(int num){
		this.score = this.getScore() + num;
	}
	
	public void setTarget(int num){
		this.target = num;
	}
	
	public  boolean checkExchange(int x1, int y1, int x2, int y2){
		if(x2 == x1-1 && y1 == y2 || //su
			x1 == x2 && y2 == y1-1 || //sx
			x1 == x2 && y2 == y1+1 || //dx
			x2 == x1+1 && y1 == y2){ //giu
			return true;
		}
		return false;
	}
	
	public void doExchange(int x1, int y1, int x2, int y2){
		Element app = new Element();;

		app.setColorNumber(mat[x1][y1].getColorNumber());
		app.setType(mat[x1][y1].getType());
		
		mat[x1][y1].setColorNumber(mat[x2][y2].getColorNumber());
		mat[x1][y1].setType(mat[x2][y2].getType());
		
		mat[x2][y2].setColorNumber(app.getColorNumber());
		mat[x2][y2].setType(app.getType());
	}
		
	public boolean goOn(){
		return checker.checkTris(this.mat); 	
	}
		
	public boolean checkNextMove(){
		return checker.checkNextMove(this.mat);
	}
	
	public int doFive(int c){
		return fiveController.doFive(c, this.mat);
	}
	
	public void gameLoop(){
		
		if(checker.checkFiveOrizontal(mat)){
			fiveController.doHorizontalFive(mat);
			incScore(500);
		}
		else if(checker.checkFiveVertical(mat)){
			fiveController.doVerticalFive(mat);
			incScore(500);
		}
		else if(checker.checkWrapped(mat)){
			wrappedController.controlWrapped(mat);
			incScore(250);
		}
		else if(checker.checkPokerVertical(mat)){
			pokerController.doVerticalPoker(mat);
			incScore(250);
		}
		else if(checker.checkPokerOrizontal(mat)){
			pokerController.doHorizontalPoker(mat);
			incScore(250);
		}
		else if(checker.checkTrisVertical(mat)){
			trisController.doVerticalTris(mat);
			incScore(100);
		}
		else if(checker.checkTrisOrizontal(mat)){
			trisController.doHorizontalTris(mat);
			incScore(100);
		}	
		
		while(!checker.checkNextMove(mat)){
			this.shuffle();
		}
		
	}

	public void shuffle(){
		List<Element> list = new ArrayList<>();
		
		for(int i = 0; i < Utility.dim1; i++){
			for(int j = 0; j < Utility.dim2; j++){
				list.add(mat[i][j]);
			}
		}
		Collections.shuffle(list);		
		Iterator<Element> it = list.iterator();
		
		for(int i = 0; i < Utility.dim1; i++){
			for(int j = 0; j < Utility.dim2; j++){
				mat[i][j] = it.next();
			}
		}
	}


}