package mvc;
/**
 * 0 -> blu
 * 1 ->	yellow
 * 2 ->	green
 * 3 -> violet
 * 4 ->	orange
 * 5 -> red
 * 
 * 6 -> stripV blu
 * 7 -> stripV yellow
 * 8 -> stripV green
 * 9 -> stripV violet
 * 10 -> stripV orange
 * 11 -> stripV red
 * 
 * 12 -> stripO blu
 * 13 -> stripO yellow
 * 14 -> stripO green
 * 15 -> stripO violet
 * 16 -> stripO orange
 * 17 -> stripO red
 * 
 * 18 -> wrap blu
 * 19 -> wrap yellow
 * 20 -> wrap green
 * 21 -> wrap violet
 * 22 -> wrap orange
 * 23 -> wrap red
 * 
 * 24 -> five
 */
import java.awt.Color;

import javax.swing.JButton;

public class Butt extends JButton {	

	private static final long serialVersionUID = 2769913399342872901L;
	
	public static final int hbutt = 70;
	public static final int lbutt = 60;
	
	private int posX;
	private int posY;
	private ColorButt col;
	private TypeButt type;
	
	public Butt(int x, int y) {
		this.posX = x;
		this.posY = y;
		this.setOpaque(true);
		this.setBackground(Color.gray);
		this.setSize(hbutt, lbutt);
		this.setNormalType();
	}
	
	public void setNormalType(){
		this.type = TypeButt.NORMAL;
	}
	
	public void setType(int n){
		// 6 striate, 7 wrapped, 8 five
		if (n > 5 && n < 12){
			this.type = TypeButt.STRIPPED_VER;
		} else if (n>= 12 && n<18){
			this.type = TypeButt.STRIPPED_OR;
		} else if (n>= 18 && n<24){
			this.type = TypeButt.WRAPPED;
		} else if (n == 24){
			this.type = TypeButt.FIVE;
		}
		
	}
	
	public TypeButt getType(){
		return this.type;
	}
	public void setColorButt(ColorButt color){
		this.col = color;
	}
	
	public ColorButt getColorButt(){
		return this.col;
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
	
}
