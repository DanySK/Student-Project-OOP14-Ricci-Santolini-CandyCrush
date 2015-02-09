package mvc;

import java.awt.Color;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Butt extends JButton {	
	//private String name;
	private int posX;
	private int posY;
	private ColorButt col;
	//private ImageIcon icon;
	
	public Butt(/*String name,*/ int x, int y) {
		//this.name = name;
		this.posX = x;
		this.posY = y;
		this.setOpaque(true);
		this.setBackground(Color .white);;
		this.setSize(100, 100);
		//this.setColorButt();
		/*if(name.equals("A")){
			this.icon = new ImageIcon("blu.jpg");
		}else if(name.equals("B")){
			this.icon = new ImageIcon("rossa.jpeg");
		}else{
			this.icon = new ImageIcon("images.jpeg");
		}*/
		
		//this.setText(name);
	}
	
	/*public Butt(ImageIcon im, String name, int x, int y) {
		this.name = name;
		this.posX = x;
		this.posY = y;
		this.icon = im;
		/*if(name.equals("A")){
			this.icon = new ImageIcon("blu.jpg");
		}else if(name.equals("B")){
			this.icon = new ImageIcon("rossa.jpeg");
		}else{
			this.icon = new ImageIcon("images.jpeg");
		}
		
		//this.setText(name);
	}*/
	public void setColorButt(ColorButt color){
		this.col = color;
	}
	public ColorButt getColorButt(){
		return this.col;
	}
	/*public String getNome(){
		return this.name;
	}*/

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
	
}
