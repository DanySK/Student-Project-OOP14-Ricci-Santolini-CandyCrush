package mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import view.*;

public class Model implements IModel{
	
	//private Oggetto mat[][] = new Oggetto[Utility.dim1][Utility.dim2];	
	private int mat[][] = new int[Utility.dim1][Utility.dim2];
	private int punteggio = 0;
	private int obiettivo;
	private int mosse;
	//private boolean vertical;
	
	public Model(){
		
		for(int i = 0; i< Utility.dim1; i++){	
			for(int j = 0; j< Utility.dim2; j++){
				mat[i][j] = generate();
			}
		}

	}
	
	//generatore
	private int generate(){
		return (int) (Math.random() * 10000)%6;
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
	
	public void setPunteggio(int num){
		this.punteggio = num;
	}
	
	public int getObiettivo(){
		return this.obiettivo;
	}
	
	public int getNum(int i, int j){
		return this.mat[i][j];
	}
	
	public int[][] getMat(){
		return this.mat;
	}
	
	/*public boolean getVertical (){
		return this.vertical;
	}*/
	
	public  boolean checkExchange(int x1, int y1, int x2, int y2){
		if(x2 == x1-1 && y1 == y2 || //su
			x1 == x2 && y2 == y1-1 || //sx
			x1 == x2 && y2 == y1+1 || //dx
			x2 == x1+1 && y1 == y2){ //giu
			//System.out.println("OK");
			return true;
		}
		return false;
	}
	
	public void doExchange(int x1, int y1, int x2, int y2){
		int app;
		app = mat[x1][y1];
		mat[x1][y1] = mat[x2][y2];
		mat[x2][y2] = app;
		mosse--;
		
	}

	/////////CONTROLLI
	
	//checkTris
	public boolean checkTris(){
		
		if(!checkTrisVertical() && !checkTrisOrizontal()){
			//System.out.println("No tris");
			return false;
		}
		return true;
		
	}
	
	public boolean checkTrisVertical(){
		
		System.out.println("Tris VERTICALI: ");
		for(int j = 0; j < Utility.dim2 ; j++){
			for(int i = 0; i < Utility.dim1 - 2; i++){
				if(mat[i][j] == mat[i+1][j] && mat[i+1][j] == mat[i+2][j]){
					//System.out.println("colonna: " + j + " / " + i + (i+1) + (i+2));
	
					mat[i][j] = -1;
					mat[i+1][j] = -1;
					mat[i+2][j] = -1;
					
					this.destroyVer(i+2, j);
					//vertical = true;
					punteggio = punteggio + 60;
					
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean checkTrisOrizontal(){
		System.out.println("\nCheck" + "\n"+ toString());
		
		System.out.println("Tris ORIZZONTALI: ");
		for(int i = 0; i < Utility.dim1 ; i++){
			for(int j = 0; j < Utility.dim2 - 2; j++){
				if(mat[i][j] == mat[i][j+1] && mat[i][j+1] == mat[i][j+2]){
					System.out.println("riga: " + i + " / " + j + (j+1) + (j+2));
			
					mat[i][j] = -1;
					mat[i][j+1] = -1;
					mat[i][j+2] = -1;
			
					System.out.println("\nCheckO\n" + toString());
					
					this.destroyOrz(i/*, j*/);
					//vertical = false;
					punteggio = punteggio + 60;
					
					return true;
				}
			}
		}
		return false;
	}
		
	
	/*private void destroy(int x, int y){
		if (this.vertical == false){
			this.destroyOrz(x);
		}
		else{
			this.destroyVer(x, y);
		}
	}*/
	private void destroyVer(int x, int y){	
		
		//System.out.println("\n-" + x + " " + y);
		
		for(int i = x; i > 2; i--){
	
			mat[i][y] = mat[i-3][y];
			mat[i-3][y] = -1;
		}
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < Utility.dim1; i++){
			if(mat[i][y] == -1){
				mat[i][y] = generate();
			}
		}
	}
	
	private void destroyOrz(int x/*, int y*/){
			
			for(int i = x; i > 0; i--){
				for(int j = Utility.dim2-1; j > -1; j--){
					if(mat[i][j] == -1){
						mat[i][j] = mat[i-1][j];
						mat[i-1][j] = -1;
					}
				}
			}
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			for(int i = 0; i < Utility.dim2; i++){
				if(mat[0][i] == -1){
					mat[0][i] = generate();
				}
			}
	}
	

	public boolean checkNextMove(){
		if(checkNextMoveOrz() || checkNextMoveVer()){
			return true;
		}		
		return false;
	}
	
	public boolean checkNextMoveOrz(){
		
		
		
		///////////////////////////////////////////////
		// su =>
		
		for(int i = 0; i < Utility.dim1-1; i++){
			for(int j = 0; j < Utility.dim2-2; j++){
				if(mat[i][j] == mat[i][j+1]){
					if(mat[i][j] == mat[i+1][j+2]){
						System.out.println("1 "+i+" "+j);
						return true;
					}
				}
				if(mat[i][j] == mat[i+1][j+1]){
					if(mat[i][j] == mat[i][j+2] || mat[i][j] == mat[i+1][j+2]){
						System.out.println("2 "+" "+i+" "+j);
						return true;
					}
				}
				
			}
		}
				
		
		
		//////////////////////////////
		// giu =>
		for(int i = Utility.dim1-1; i > 0; i--){
			for(int j = 0; j < Utility.dim2-2; j++){
				if(mat[i][j] == mat[i][j+1]){
					if(mat[i][j] == mat[i-1][j+2]){
						System.out.println("3 "+" "+i+" "+j);
						return true;
					}
				}
				if(mat[i][j] == mat[i-1][j+1]){
					if(mat[i][j] == mat[i][j+2] || mat[i][j] == mat[i-1][j+2]){
						System.out.println("4 "+" "+i+" "+j);
						return true;
					}
				}
				
			}
		}
		
		
		//////////////////////////////
		// su <=
		for(int i = 0; i < Utility.dim1-1; i++){
			for(int j = Utility.dim2-1; j > 1; j--){
				if(mat[i][j] == mat[i][j-1]){
					if(mat[i][j] == mat[i+1][j-2]){
						System.out.println("5 "+" "+i+" "+j);
						return true;
					}
				}
				if(mat[i][j] == mat[i+1][j-1]){
					if(mat[i][j] == mat[i][j-2] || mat[i][j] == mat[i+1][j-2]){
						System.out.println("6 "+" "+i+" "+j);
						return true;
					}
				}
			}
		}
		
		//////////////////////////////
		// giu <=
		
		for(int i = Utility.dim1-1; i > 0; i--){
			for(int j = Utility.dim2-1; j > 1; j--){
				if(mat[i][j] == mat[i][j-1]){
					if(mat[i][j] == mat[i-1][j-2]){
						System.out.println("7 "+" "+i+" "+j);
						return true;
					}
				}
				if(mat[i][j] == mat[i-1][j-1]){
					if(mat[i][j] == mat[i][j-2] || mat[i][j] == mat[i-1][j-2]){
						System.out.println("8 "+" "+i+" "+j);
						return true;
					}
				}
			}
		}
		
		//tris lineari
		
		for(int i = 0; i < Utility.dim1; i++){
			for(int j = 0; j < Utility.dim2-3; j++){
				if(mat[i][j] == mat[i][j+1] && mat[i][j] == mat[i][j+3]){
					System.out.println("9 "+" "+i+" "+j);
					return true;
				}
				if(mat[i][j] == mat[i][j+2] && mat[i][j] == mat[i][j+3]){
					System.out.println("10 "+" "+i+" "+j);
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean checkNextMoveVer(){

		/////////// ↓	sx
		for(int j = 0; j < Utility.dim2-1; j++){
			for(int i = 0; i < Utility.dim1-2; i++){
				if(mat[i][j] == mat[i+1][j]){
					if(mat[i][j] == mat[i+2][j+1]){
						System.out.println("11 "+" "+i+" "+j);
						return true;
					}
				}
				if(mat[i][j] == mat[i+1][j+1]){
					if(mat[i][j] == mat[i+2][j] || mat[i][j] == mat[i+2][j+1]){
						System.out.println("12 "+" "+i+" "+j);
						return true;
					}
				}
			}
		}

		
		/////////// ↓	dx
		for(int j = Utility.dim2-1; j > 0; j--){
			for(int i = 0; i < Utility.dim1-2; i++){
				if(mat[i][j] == mat[i+1][j]){
					if(mat[i][j] == mat[i+2][j-1]){
						System.out.println("13 "+" "+i+" "+j);
						return true;
					}
				}
				if(mat[i][j] == mat[i+1][j-1]){
					if(mat[i][j] == mat[i+2][j] || mat[i][j] == mat[i+2][j-1]){
						System.out.println("14 "+" "+i+" "+j);
						return true;
					}
				}
			}
		}
		
		
		/////////// su sx
		for(int j = 0; j < Utility.dim2-1; j++){
			for(int i = Utility.dim1-1; i > 1; i--){
				if(mat[i][j] == mat[i-1][j]){
					if(mat[i][j] == mat[i-2][j+1]){
						System.out.println("15 "+" "+i+" "+j);
						return true;
					}
				}
				if(mat[i][j] == mat[i-1][j+1]){
					if(mat[i][j] == mat[i-2][j] || mat[i][j] == mat[i-2][j+1]){
						System.out.println("16 "+" "+i+" "+j);
						return true;
					}
				}
			}
		}
		
		
		/////////////su dx
		for(int j = Utility.dim2-1; j > 0; j--){
			for(int i = Utility.dim1-1; i > 1; i--){
				if(mat[i][j] == mat[i-1][j]){
					if(mat[i][j] == mat[i-2][j-1]){
						System.out.println("17 "+" "+i+" "+j);
						return true;
					}
				}
				if(mat[i][j] == mat[i-1][j-1]){
					if(mat[i][j] == mat[i-2][j] || mat[i][j] == mat[i-2][j-1]){
						System.out.println("18 "+" "+i+" "+j);
						return true;
					}
				}
			}
		}
		
	//tris lineari
		
	for(int j = 0; j < Utility.dim2; j++){
		for(int i = 0; i < Utility.dim1-3; i++){
			if(mat[i][j] == mat[i+1][j] && mat[i][j] == mat[i+3][j]){
				System.out.println("19 "+" "+i+" "+j);
				return true;
			}
			if(mat[i][j] == mat[i+2][j] && mat[i][j] == mat[i+3][j]){
				System.out.println("20 "+" "+i+" "+j);
				return true;
			}
		}
	}
		
	return false;
	}
	
	public void shuffle(){
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < Utility.dim1; i++){
			for(int j = 0; j < Utility.dim2; j++){
				list.add(mat[i][j]);
			}
		}
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		
		Iterator<Integer> it = list.iterator();
		
		for(int i = 0; i < Utility.dim1; i++){
			for(int j = 0; j < Utility.dim2; j++){
				mat[i][j] = it.next();
			}
		}
	}
}
