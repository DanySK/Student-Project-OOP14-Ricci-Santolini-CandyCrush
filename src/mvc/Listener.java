package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import view.*;

public class Listener implements ActionListener, ViewObserver{

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
			System.out.println(c.model.getMat()[lastX][lastY].getColorNumber());
			
		}else{
			System.out.println(c.model.getMat()[b.getPosX()][b.getPosY()].getColorNumber());
			
			if(c.model.checkExchange(lastX, lastY, b.getPosX(), b.getPosY())){
				
				c.model.doExchange(lastX, lastY, b.getPosX(), b.getPosY());
				c.view.updateView();
			
				//CARAMELLA DA 5
				if(c.model.getMat()[lastX][lastY].getType() == Utility.five
					|| c.model.getMat()[b.getPosX()][b.getPosY()].getType() == Utility.five){
					System.out.println("FIVE");
					
					if(c.model.getMat()[lastX][lastY].getType() == Utility.five){
						c.model.getMat()[lastX][lastY].setColorNumber(c.model.generate());
						c.model.getMat()[lastX][lastY].setType(Utility.normal);
						c.model.doFive(c.model.getMat()[b.getPosX()][b.getPosY()].getColorNumber());
					}
					if(c.model.getMat()[b.getPosX()][b.getPosY()].getType() == Utility.five){
						c.model.getMat()[b.getPosX()][b.getPosY()].setColorNumber(c.model.generate());
						c.model.getMat()[b.getPosX()][b.getPosY()].setType(Utility.normal);
						c.model.doFive(c.model.getMat()[lastX][lastY].getColorNumber());
					}
					SwingUtilities.invokeLater(new Runnable() {	
						@Override
						public void run() {
						
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							c.view.updateView();
							c.finalControl();
						}
					});
				}
			
				//NON HAI FATTO TRIS -> UNDO
				if(!c.model.checkTris()){
					SwingUtilities.invokeLater(new Runnable() {	
						@Override
						public void run() {
						
							try {
								Thread.sleep(500);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							c.model.doExchange(lastX, lastY, b.getPosX(), b.getPosY());
							c.view.updateView();
							
							lastX = -1;
							lastY = -1;
						}
					});
				}
				
				//HAI FATTO TRIS -> DO
				else{
					c.model.decMosse();
					SwingUtilities.invokeLater(new Runnable() {		
									
							@Override
							public void run() {	
								
								while(c.model.checkTris()){
									try {
										Thread.sleep(500);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
									c.model.checkFiveVertical();
									c.model.checkFiveOrizontal();
									c.model.checkPokerVertical(); 
									c.model.checkPokerOrizontal();
									c.model.checkWrapped(); 
									
									c.model.gestTris();

									c.model.descend();
									c.model.resolve();
									c.view.updateView();
							
								}
								lastX = -1;
								lastY = -1;
								
								c.finalControl();
							}
						});
					
				
				}
				c.view.updateView();
			
			}
			//DESELEZIONE
			else{
				lastX = b.getPosX();
				lastY = b.getPosY();
				app = b;
			}
		
		}
		
	}

	@Override
	public void update(String s) {
		
	}
}

