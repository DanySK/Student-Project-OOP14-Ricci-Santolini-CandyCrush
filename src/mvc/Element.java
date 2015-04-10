package mvc;

public class Element {
	
	private int colorNumber;
	private int type;
	
	public Element(){
		this.type = 1; //1 = normale
	}
	
	public Element(int i){
		this.colorNumber = i;
		this.type = 1; //1 = normale
	}
	
	public int getColorNumber(){
		return this.colorNumber;
	}
	
	public void setColorNumber(int c){
		this.colorNumber = c;
	}
	
	public int getType(){
		return this.type;
	}
	
	public void setType(int t){
		this.type = t;
	}
}
