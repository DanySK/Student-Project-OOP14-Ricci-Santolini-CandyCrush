package mvc;

public class Model implements IModel{

	public static final int dim1 = 9;
	public static final int dim2 = 9;
	
	private Oggetto mat[][] = new Oggetto[dim1][dim2];	
	private int punteggio = 0;
	private int obiettivo;
	private int mosse;
	
	public Model(){
		
		for(int i = 0; i< dim1; i++){	
			for(int j = 0; j< dim2; j++){
				mat[i][j] = new Oggetto(i, j);
			}
		}
		
	}
	
	public void setMosse(int num){
		this.mosse = num;
	}
	
	public int getPunteggio(){
		return this.punteggio;
	}
	
	public void incPunteggio(int num){
		this.punteggio = this.getPunteggio() + num;
	}
	
	public int getMosse(){
		return this.mosse;
	}
	
	public void setObiettivo(int num){
		this.obiettivo = num;
	}
	
	public int getObiettivo(){
		return this.obiettivo;
	}
	
	public Oggetto[][] getMat(){
		return this.mat;
	}
	
	public  boolean checkExchange(int x1, int y1, int x2, int y2){
		if(x2 == x1-1 && y1 == y2 || //su
			x1 == x2 && y2 == y1-1 || //sx
			x1 == x2 && y2 == y1+1 || //dx
			x2 == x1+1 && y1 == y2){ //giu
			System.out.println("OK");
			return true;
		}
		return false;
	}
	
	public void doExchange(int x1, int y1, int x2, int y2){
		Oggetto app = new Oggetto();
		app = mat[x1][y1];
		mat[x1][y1] = mat[x2][y2];
		mat[x2][y2] = app;
	System.out.println("Scambiato");
		
	}
	
	/*public void checkTris(Oggetto[][] m){
		for(int i = (dim1-3); i< dim1; i++){
			for(int j = (dim2-3); j< dim2; j++){
				if(m[i][j].getColorButt().equals(m[i][j-1].getColorButt()) && m[i][j-1].getColorButt().equals(m[i][j-2].getColorButt())){
					System.out.println("TRIS ORIZ. di "+m[i][j].getColorButt() + " " + i + " " + j + "  " + (j-1)+ "  "+ (j-2));
				}
				if(m[i][j].getColorButt().equals(m[i-1][j].getColorButt()) && m[i-1][j].getColorButt().equals(m[i-2][j].getColorButt())){
					System.out.println("TRIS VERT. di "+m[i][j].getColorButt() + " " + j + " " + i + "  " + (i-1)+ "  "+ (i-2));
				}
			}
		}
	}*/
	
	
	
}
