package mvc;

public class Oggetto {

	private int x;
	private int y;
	private ColorButt color;
	
	public Oggetto(){}
	
	public Oggetto(int x, int y/*, ColorButt n*/){
		this.x = x;
		this.y = y;
		//this.color = n;
		this.setColorButt();
	}
	public void setColorButt(){
		this.color = ColorButt.randomCol();
	}
	public ColorButt getColorButt(){
		return this.color;
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
	
	public ColorButt getCol(){
		return this.color;
	}
	
}
