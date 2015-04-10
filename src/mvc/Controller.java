package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.*;

public class Controller implements ViewObserver{
	
	public Model model;
	public PlayGameMenu view;
	private Listener observer;
		
	public Controller(PlayGameMenu v, Model m){
		this.model = m;
		this.view = v;
		
		this.observer = new Listener();
		
		//this.view.setListener(observer);
		this.observer.addObserver(this);
	}
	
	public void finalControl(){
		//CONTROLLI VITTORIA/SCONFITTA
		if((this.model.getMosse() == 0 && this.model.getPunteggio() >= this.model.getObiettivo()) || 
				(this.model.getPunteggio() >= this.model.getObiettivo())){
			this.view.closePage();
			new Win();
		}
		if(this.model.getMosse() == 0 && this.model.getPunteggio() < this.model.getObiettivo()){
			this.view.closePage();
			new GameOver();
		}
	}
	
	public Listener getObserver(){
		return this.observer;
	}
	
	@Override
	public void update(String s) {
		// TODO Auto-generated method stub
		
	}
	
	
}