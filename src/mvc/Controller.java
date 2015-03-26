package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;

public class Controller implements ActionListener{
	
	private Model modello;
	//private IPlayMenu playMenu;
	private PlayGameMenu playMenu;	
	public Controller(PlayGameMenu v, Model m){
		this.modello = m;
		this.playMenu = v;
		
	}
	
	int lastX = -1;
	int lastY = -1;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Butt b = (Butt) e.getSource();
		
		if(lastX == -1 && lastY == -1){
			//Butt app = (Butt) e.getSource();
			lastX = b.getPosX();
			lastY = b.getPosY();
			//app = b;
			
		}else{
			
			if(modello.checkExchange(lastX, lastY, b.getPosX(), b.getPosY())){
				//view.updateView(view.getPanel(), modello.getMat());
				modello.doExchange(lastX, lastY, b.getPosX(), b.getPosY());
				playMenu.updateView(playMenu.getPanel(), modello.getMat());
				while(modello.checkTris()){
					playMenu.updateView(playMenu.getPanel(), modello.getMat());
				}
				while(!modello.checkNextMove()){
					modello.shuffle();
					new Shuffle();
					playMenu.updateView(playMenu.getPanel(), modello.getMat());
				}
				
			}
			lastX = -1;
			lastY = -1;
		}
		
		if((modello.getMosse() == 0 && modello.getPunteggio() >= modello.getObiettivo()) || 
				(modello.getPunteggio() >= modello.getObiettivo())){
			new Win();
		}
		if(modello.getMosse() == 0 && modello.getPunteggio() < modello.getObiettivo()){
			new GameOver();
		}
	}

	
}
