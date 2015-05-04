package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;
/**
 * Classe che osserva il comportamento della view
 * 
 * @author Beatrice Ricci, Nicola Santolini
 *
 */
public class Listener implements ActionListener {

	private Controller c;
	
	public void addObserver(Controller con){
		this.c = con;
	}

	int lastX = -1;
	int lastY = -1;
	
	@Override
	public void actionPerformed(ActionEvent e) {

		Butt b = (Butt) e.getSource();
		Butt app = (Butt) e.getSource();			
			
		if(lastX == -1 && lastY == -1){
			lastX = b.getPosX();
			lastY = b.getPosY();
			app = b;
			
		}else{
			c.update(lastX,  lastY, b.getPosX(), b.getPosY());
			lastX = -1;
			lastY = -1;
		}
		
		
	}

}

