package mvc;

import java.util.Random;

public class Oggetto {

	private int x;
	private int y;;
	private int num;
	public Oggetto(){}
	
	public Oggetto(int x, int y){
		this.x = x;
		this.y = y;
		Random rnd = new Random ();
		this.num = rnd.nextInt (6);
	}
	/*public void setColorButt(){
		this.color = ColorButt.randomCol();
	}*/
	public int getNum(){
		return this.num;
	}
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	/*public void setName(String s){
		this.name = s;
	}*/
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	/*
	public ColorButt getCol(){
		return this.color;
	}*/
	
}
