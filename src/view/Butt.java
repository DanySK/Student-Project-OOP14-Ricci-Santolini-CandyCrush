package view;

import java.awt.Color;

import javax.swing.JButton;

public class Butt extends JButton implements IButt {	

	private static final long serialVersionUID = 2769913399342872901L;
	
	private int posX;
	private int posY;
	
	public Butt(int x, int y) {
		this.posX = x;
		this.posY = y;
		this.setLookButt();
	}
	
	public void setPosX(int x){
		this.posX = x;
	} 
	
	public void setPosY(int y){
		this.posY = y;
	} 
	
	public int getPosX(){
		return this.posX;
	}
	
	public int getPosY(){
		return this.posY;
	}
	
	private void setLookButt(){
		this.setBackground(Color.gray);
		this.setSize(Utility.hbutt, Utility.lbutt);
	}
	
}
