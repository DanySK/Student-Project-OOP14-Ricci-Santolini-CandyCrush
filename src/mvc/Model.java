package mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import view.*;

public class Model implements IModel{
	
	private Element mat[][] = new Element[Utility.dim1][Utility.dim2];
	private int punteggio = 0;
	private int obiettivo;
	private int mosse;
	
	public Model(){
		
		for(int i = 0; i< Utility.dim1; i++){	
			for(int j = 0; j< Utility.dim2; j++){
				mat[i][j] = new Element(generate());
			}
		}
		
		this.creation();
		
	}
	
	public void creation(){
		
		while(!this.checkNextMove()){
			this.shuffle();
		}
		
		while(this.checkTris()){
			this.shuffle();
		}
		//this.modelW.setPunteggio(0);
		//this.updateTot();
	}
	
	//generatore
	public int generate(){
		return (int) (Math.random() * 10000)%6;
	}
	
	
	///////////GETTERS/SETTERS//////////////////////////
	
	public void setMosse(int num){
		this.mosse = num;
	}
	
	public void decMosse(){
		this.mosse--;
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
		return this.mat[i][j].getColorNumber();
	}
	
	public int getTypeEl(int i, int j){
		return this.mat[i][j].getType();
	}
	
	public Element[][] getMat(){
		return this.mat;
	}
	/////////////////////////////////////////////////////
	
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
		Element app = new Element();;
		//app = mat[x1][y1];
		//mat[x1][y1] = mat[x2][y2];
		//mat[x2][y2] = app;
		
		app.setColorNumber(mat[x1][y1].getColorNumber());
		app.setType(mat[x1][y1].getType());
		
		mat[x1][y1].setColorNumber(mat[x2][y2].getColorNumber());
		mat[x1][y1].setType(mat[x2][y2].getType());
		
		mat[x2][y2].setColorNumber(app.getColorNumber());
		mat[x2][y2].setType(app.getType());
	}

	public void undoExchange(int x1, int y1, int x2, int y2){
		Element app;
		app = mat[x1][y1];
		mat[x1][y1] = mat[x2][y2];
		mat[x2][y2] = app;
		
	}
	
	
	/////////CONTROLLI
	
	//checkTris
		public boolean checkTris(){
			
			if(!checkTrisVertical() && !checkTrisOrizontal()){
				System.out.println("No tris");
				return false;
			}
			return true;
			
		}
		
		public void gestTris(){
		
			if(checkTrisVertical()){
				
				for(int j = 0; j < Utility.dim2 ; j++){
					for(int i = 0; i < Utility.dim1 - 2; i++){
						if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber()
							&& mat[i+1][j].getColorNumber() == mat[i+2][j].getColorNumber()){
							
							if(mat[i][j].getType() == Utility.stripedV || mat[i+1][j].getType() == Utility.stripedV 
								|| mat[i+2][j].getType() == Utility.stripedV){
								gestPokerV(i, j);
							}
							
							else if(mat[i][j].getType() == Utility.stripedO || mat[i+1][j].getType() == Utility.stripedO 
									|| mat[i+2][j].getType() == Utility.stripedO){
								gestPokerV(i, j);
							}
							else if(mat[i][j].getType() == Utility.wrapped || mat[i+1][j].getType() == Utility.wrapped 
									|| mat[i+2][j].getType() == Utility.wrapped){
								if(mat[i][j].getType() == Utility.wrapped){
									bomb(i, j);
								}
								if(mat[i+1][j].getType() == Utility.wrapped){
									bomb(i+1, j);								
								}
								if(mat[i+2][j].getType() == Utility.wrapped){
									bomb(i+2, j);
								}
							}
						
							mat[i][j].setColorNumber(-1);
							mat[i+1][j].setColorNumber(-1);
							mat[i+2][j].setColorNumber(-1);
																	/////////////////
								descend();
								resolve();			
						}
					}
				}
			}
			else{
				
				for(int i = 0; i < Utility.dim1 ; i++){
					for(int j = 0; j < Utility.dim2 - 2; j++){
						if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber()
							&& mat[i][j+1].getColorNumber() == mat[i][j+2].getColorNumber()){	
							
							if(mat[i][j].getType() == Utility.stripedV || mat[i][j+1].getType() == Utility.stripedV
									|| mat[i][j+2].getType() == Utility.stripedV){
									gestPokerO(i, j);
							}
								
							else if(mat[i][j].getType() == Utility.stripedO || mat[i][j+1].getType() == Utility.stripedO 
									|| mat[i][j+2].getType() == Utility.stripedO){
									gestPokerO(i, j);
							}
							else if(mat[i][j].getType() == Utility.wrapped || mat[i][j+1].getType() == Utility.wrapped 
									|| mat[i][j+2].getType() == Utility.wrapped){
								if(mat[i][j].getType() == Utility.wrapped){
									bomb(i, j);
								}
								if(mat[i][j+1].getType() == Utility.wrapped){
									bomb(i, j+1);								
								}
								if(mat[i][j+2].getType() == Utility.wrapped){
									bomb(i, j+2);
								}
							}
						//	else{
								mat[i][j].setColorNumber(-1);
								mat[i][j+1].setColorNumber(-1);
								mat[i][j+2].setColorNumber(-1);
															/////////////
								descend();
								resolve();
							//}
						}
					}
				}
			}
			
			
					
		}
		
		public void gestPokerV(int x, int y){
			System.out.println("gestPokerV");
			if(mat[x][y].getType() == Utility.stripedO || mat[x][y].getType() == Utility.stripedV){
				System.out.println("1");
				if(mat[x][y].getType() == Utility.stripedO){
					riga(x);
				}
				else{
					colonna(y);
				}
			}
			if(mat[x+1][y].getType() == Utility.stripedO || mat[x+1][y].getType() == Utility.stripedV){
				System.out.println("2");
				if(mat[x+1][y].getType() == Utility.stripedO){
					riga(x+1);
				}
				else{
					colonna(y);
				}
			}
			if(mat[x+2][y].getType() == Utility.stripedO || mat[x+2][y].getType() == Utility.stripedV){
				System.out.println("3");
				if(mat[x+2][y].getType() == Utility.stripedO){
					riga(x+2);
				}
				else{
					colonna(y);
				}
			}
		}
		
		public void gestPokerO(int x, int y){
			System.out.println("gestPokerO");
			if(mat[x][y].getType() == Utility.stripedO || mat[x][y].getType() == Utility.stripedV){
				if(mat[x][y].getType() == Utility.stripedO){
					riga(x);
				}
				else{
					colonna(y);
				}	
			}
			if(mat[x][y+1].getType() == Utility.stripedO || mat[x][y+1].getType() == Utility.stripedV){
				System.out.println("2");
				if(mat[x][y+1].getType() == Utility.stripedO){
					riga(x);
				}
				else{
					colonna(y+1);
				}
			}
			if(mat[x][y+2].getType() == Utility.stripedO || mat[x][y+2].getType() == Utility.stripedV){
				System.out.println("3");
				if(mat[x][y+2].getType() == Utility.stripedO){
					riga(x);
				}
				else{	
					colonna(y+2);
				}
			}
		}
		
		public void colonna(int x){
			for(int i = 0; i < Utility.dim1; i++){
				System.out.println("colonna");
				mat[i][x].setColorNumber(generate());
				//mat[i][x].setType(Utility.normal);
				mat[i][x].setType(1);
			}
		}
		
		public void riga(int x){
			System.out.println("riga");
			for(int i = x; i > 0; i--){
				for(int j = Utility.dim2-1; j > -1; j--){	
					mat[i][j].setColorNumber(mat[i-1][j].getColorNumber());
					mat[i][j].setType(mat[i-1][j].getType());
					mat[i-1][j].setColorNumber(-1);
					mat[i-1][j].setType(1);				
				}
			}
				
			for(int i = 0; i < Utility.dim2; i++){
				if(mat[0][i].getColorNumber() == -1){
					mat[0][i].setColorNumber(generate());
					mat[0][i].setType(Utility.normal);
				}
			}
		}
	
		public boolean checkTrisVertical(){
		
			for(int j = 0; j < Utility.dim2 ; j++){
				for(int i = 0; i < Utility.dim1 - 2; i++){
					if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber()
						&& mat[i+1][j].getColorNumber() == mat[i+2][j].getColorNumber()){
						System.out.println("colonna: " + j + " / " + i + (i+1) + (i+2));
		
						incPunteggio(60);
						return true;
					}
				}
			}
			return false;
		}
		
		public boolean checkTrisOrizontal(){

			for(int i = 0; i < Utility.dim1 ; i++){
				for(int j = 0; j < Utility.dim2 - 2; j++){
					if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber()
						&& mat[i][j+1].getColorNumber() == mat[i][j+2].getColorNumber()){
						
						incPunteggio(60);
						return true;
					}
				}
			}
			return false;
		}
			
		public boolean checkPokerVertical(){
			for(int j = 0; j < Utility.dim2 ; j++){
				for(int i = 0; i < Utility.dim1 - 3; i++){
					if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber()
						&& mat[i][j].getColorNumber() == mat[i+2][j].getColorNumber()
						&& mat[i][j].getColorNumber() == mat[i+3][j].getColorNumber()){
						
						incPunteggio(100);
						mat[i][j].setType(Utility.stripedV);
						mat[i+1][j].setColorNumber(-1);
						mat[i+2][j].setColorNumber(-1);
						mat[i+3][j].setColorNumber(-1);
						
						descend();									//////////////////
						resolve();
						return true;
					}
				}
			}
			return false;
		}
		
		public boolean checkPokerOrizontal(){
			for(int i = 0; i < Utility.dim1 ; i++){
				for(int j = 0; j < Utility.dim2 - 3; j++){
					if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber()
						&& mat[i][j].getColorNumber() == mat[i][j+2].getColorNumber()
						&& mat[i][j].getColorNumber() == mat[i][j+3].getColorNumber()){
						
						incPunteggio(100);
						mat[i][j].setType(Utility.stripedO);
						mat[i][j+1].setColorNumber(-1);
						mat[i][j+2].setColorNumber(-1);
						mat[i][j+3].setColorNumber(-1);
						
						descend();								//////////////////////////
						resolve();
						return true;
					}
				}
			}
			return false;
		}
		
		public boolean checkFiveOrizontal(){
			for(int i = 0; i < Utility.dim1 ; i++){
				for(int j = 0; j < Utility.dim2 - 4; j++){
					if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber()
						&& mat[i][j].getColorNumber() == mat[i][j+2].getColorNumber()
						&& mat[i][j].getColorNumber() == mat[i][j+3].getColorNumber()
						&& mat[i][j].getColorNumber() == mat[i][j+4].getColorNumber()){
						
						incPunteggio(500);
						mat[i][j+2].setColorNumber(Utility.special);
						mat[i][j+2].setType(Utility.five);
						mat[i][j].setColorNumber(-1);
						mat[i][j+1].setColorNumber(-1);
						mat[i][j+3].setColorNumber(-1);
						mat[i][j+4].setColorNumber(-1);
	
						descend();						////////////////////////
						resolve();
						return true;
					}
				}
			}
			return false;
			
		}
		
		public boolean checkFiveVertical(){
			for(int j = 0; j < Utility.dim2 ; j++){
				for(int i = 0; i < Utility.dim1 - 4; i++){
					if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber()
						&& mat[i][j].getColorNumber() == mat[i+2][j].getColorNumber()
						&& mat[i][j].getColorNumber() == mat[i+3][j].getColorNumber()
						&& mat[i][j].getColorNumber() == mat[i+4][j].getColorNumber()){
										
						incPunteggio(500);
						mat[i+4][j].setColorNumber(Utility.special);
						mat[i+4][j].setType(Utility.five);
						mat[i][j].setColorNumber(-1);
						mat[i+1][j].setColorNumber(-1);
						mat[i+2][j].setColorNumber(-1);
						mat[i+3][j].setColorNumber(-1);
						
						descend();							//////////////////////
						resolve();
						return true;
					}
				}
			}
			return false;
		}
		
		public void doFive(int color){
			for(int i = 0; i < Utility.dim1; i++){
				for(int j = 0; j < Utility.dim2; j++){
					if(mat[i][j].getColorNumber() == color){
						//mat[i][j].setColorNumber(generate());
						//mat[i][j].setType(Utility.normal);
						incPunteggio(30);
						mat[i][j].setColorNumber(-1);
					}
				}
			}
			descend();									////////////////////
			resolve();
		}
		
		public boolean checkWrapped(){
			for(int i = 0; i < Utility.dim1 - 2; i++){
				for(int j = 0; j < Utility.dim2 - 2; j++){
					if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber()
							&& mat[i][j+1].getColorNumber() == mat[i][j+2].getColorNumber()){
						
						if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber() 
							&& mat[i][j].getColorNumber() == mat[i+2][j].getColorNumber()){
							doWrapped(i+2, j, 1, mat[i][j].getColorNumber());
						}
						if(mat[i][j+1].getColorNumber() == mat[i+1][j+1].getColorNumber() 
								&& mat[i][j+1].getColorNumber() == mat[i+2][j+1].getColorNumber()){
							doWrapped(i+2, j+1, 3, mat[i][j].getColorNumber());
						}
						if(mat[i][j+2].getColorNumber() == mat[i+1][j+2].getColorNumber() 
								&& mat[i][j+2].getColorNumber() == mat[i+2][j+2].getColorNumber()){
							doWrapped(i+2, j+2, 5, mat[i][j].getColorNumber());	
						}	
					}	
				}
			}
			
			for(int i = Utility.dim1-1; i > 1; i--){
				for(int j = Utility.dim2-1; j > 1; j--){
					if(mat[i][j].getColorNumber() == mat[i][j-1].getColorNumber()
							&& mat[i][j-1].getColorNumber() == mat[i][j-2].getColorNumber()){
						
						if(mat[i][j].getColorNumber() == mat[i-1][j].getColorNumber() 
							&& mat[i][j].getColorNumber() == mat[i-2][j].getColorNumber()){
							doWrapped(i, j, 6, mat[i][j].getColorNumber());
						}
						if(mat[i][j-1].getColorNumber() == mat[i-1][j-1].getColorNumber() 
								&& mat[i][j-1].getColorNumber() == mat[i-2][j-1].getColorNumber()){
							doWrapped(i, j-1, 4, mat[i][j].getColorNumber());
						}
						if(mat[i][j-2].getColorNumber() == mat[i-1][j-2].getColorNumber() 
								&& mat[i][j-2].getColorNumber() == mat[i-2][j-2].getColorNumber()){
							doWrapped(i, j-2, 2, mat[i][j].getColorNumber());
						}	
					}	
				}
			}
			
			
			for(int j = 0; j < Utility.dim2 - 2; j++){
				for(int i = 0; i < Utility.dim1 - 2; i++){
					if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber()
						&& mat[i][j].getColorNumber() == mat[i+2][j].getColorNumber()){
						
						if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber() 
							&& mat[i][j].getColorNumber() == mat[i][j+2].getColorNumber()){
							doWrapped(i+2, j, 1, mat[i][j].getColorNumber());
						}
						if(mat[i+1][j].getColorNumber() == mat[i+1][j+1].getColorNumber() 
								&& mat[i+1][j].getColorNumber() == mat[i+1][j+2].getColorNumber()){
							doWrapped(i+2, j, 7, mat[i][j].getColorNumber());
						}
						if(mat[i+2][j].getColorNumber() == mat[i+2][j+1].getColorNumber() 
								&& mat[i+2][j].getColorNumber() == mat[i+2][j+2].getColorNumber()){
							doWrapped(i+2, j, 2, mat[i][j].getColorNumber());
						}	
					}	
				}
			}
			
			
			for(int j = Utility.dim2-1; j > 1; j--){
				for(int i = Utility.dim1-1; i > 1; i--){
					if(mat[i][j].getColorNumber() == mat[i-1][j].getColorNumber()
						&& mat[i][j].getColorNumber() == mat[i-2][j].getColorNumber()){
						
						if(mat[i][j].getColorNumber() == mat[i][j-1].getColorNumber() 
							&& mat[i][j].getColorNumber() == mat[i][j-2].getColorNumber()){
							doWrapped(i, j, 6, mat[i][j].getColorNumber());
						}
						if(mat[i-1][j].getColorNumber() == mat[i-1][j-1].getColorNumber() 
								&& mat[i-1][j].getColorNumber() == mat[i-1][j-2].getColorNumber()){
							doWrapped(i, j, 8, mat[i][j].getColorNumber());						
						}
						if(mat[i-2][j].getColorNumber() == mat[i-2][j-1].getColorNumber() 
								&& mat[i-2][j].getColorNumber() == mat[i-2][j-2].getColorNumber()){
							doWrapped(i, j, 5, mat[i][j].getColorNumber());
						}	
					}	
				}
			}
			return false;
		}
		
		//1 -> |^, 2 -> L, 3 -> T,4 -> _|_, 5 -> 7, 6 -> _|, 7 -> |-, 8 -> -|
		public void doWrapped(int i, int j, int type, int color){
		
			incPunteggio(100);
			
			mat[i][j].setType(Utility.wrapped);
			mat[i][j].setColorNumber(color);
			
			switch(type){
			
				case 1:
					mat[i-1][j].setColorNumber(-1);
					mat[i-2][j].setColorNumber(-1);
					mat[i-2][j+1].setColorNumber(-1);
					mat[i-2][j+2].setColorNumber(-1);
					break;
					
					
				case 2:
					mat[i-1][j].setColorNumber(-1);
					mat[i-2][j].setColorNumber(-1);
					mat[i][j+1].setColorNumber(-1);
					mat[i][j+2].setColorNumber(-1);
					break;
					
				case 3:
					mat[i-1][j].setColorNumber(-1);
					mat[i-2][j].setColorNumber(-1);
					mat[i-2][j-1].setColorNumber(-1);
					mat[i-2][j+1].setColorNumber(-1);
					break;
	
				case 4:
					mat[i-1][j].setColorNumber(-1);
					mat[i-2][j].setColorNumber(-1);
					mat[i][j-1].setColorNumber(-1);
					mat[i][j+1].setColorNumber(-1);
					break;
	
				case 5:
					mat[i-1][j].setColorNumber(-1);
					mat[i-2][j].setColorNumber(-1);
					mat[i-2][j-1].setColorNumber(-1);
					mat[i-2][j-2].setColorNumber(-1);
					break;
	
				case 6:
					mat[i-1][j].setColorNumber(-1);
					mat[i-2][j].setColorNumber(-1);
					mat[i][j-1].setColorNumber(-1);
					mat[i][j-2].setColorNumber(-1);
					break;
	
				case 7:
					mat[i-1][j].setColorNumber(-1);
					mat[i-2][j].setColorNumber(-1);
					mat[i-1][j+1].setColorNumber(-1);
					mat[i-1][j+2].setColorNumber(-1);
					break;
	
				case 8:
					mat[i-1][j].setColorNumber(-1);
					mat[i-2][j].setColorNumber(-1);
					mat[i-1][j-1].setColorNumber(-1);
					mat[i-1][j-2].setColorNumber(-1);
					break;
	
				default: //System.out.println("swich error");
			}
			descend();										/////////////////////////////
			resolve();
		}
		
		public void bomb(int first, int second){
			if(first > 0 && first < Utility.dim1-1 && second > 0 && second < Utility.dim2-1){
				for(int i = first-1; i < first+2; i++){
					for(int j = second-1; j < second +2; j++){
						mat[i][j].setColorNumber(-1);
						mat[i][j].setType(Utility.normal);
					}
				}
			}
				
			descend();											///////////////////////////////////////
			resolve();
		}
		
		//public void posWrapped(int i, int j)
		
	/*	public void destroyVer(int x, int y){	
					
			for(int i = x; i > 2; i--){
				mat[i][y].setColorNumber(mat[i-3][y].getColorNumber());
				mat[i][y].setType(mat[i-3][y].getType());
				mat[i-3][y].setColorNumber(-1);
				mat[i-3][y].setType(Utility.normal);
			}
			
			for(int i = 0; i < Utility.dim1; i++){
				if(mat[i][y].getColorNumber() == -1){
					mat[i][y].setColorNumber(generate());
					mat[i][y].setType(Utility.normal);
				}
			}
		}*/
		
		/*public void destroyOrz(int x){
			
			for(int i = x; i > 0; i--){
				for(int j = Utility.dim2-1; j > -1; j--){
					if(mat[i][j].getColorNumber() == -1){
						mat[i][j].setColorNumber(mat[i-1][j].getColorNumber());
						mat[i][j].setType(mat[i-1][j].getType());
						mat[i-1][j].setColorNumber(-1);
						mat[i-1][j].setType(1);
					}
				}
			}
				
			for(int i = 0; i < Utility.dim2; i++){
				if(mat[0][i].getColorNumber() == -1){
					mat[0][i].setColorNumber(generate());
					mat[0][i].setType(Utility.normal);
				}
			}
		}*/
			
		public void descend(){
			int last = 0;
			Element app = new Element(-1);
			boolean flag = false;
			
			for(int j = Utility.dim2-1; j > -1; j--){
					for(int i = Utility.dim1-1; i > -1; i--){
				
						if(mat[i][j].getColorNumber() == -1){
							flag = false;
							last = i;
					
							for(int k = i; k > -1; k--){
								if(mat[k][j].getColorNumber() != -1 && flag == false){
									
									app.setColorNumber(mat[i][j].getColorNumber());
									app.setType(mat[i][j].getType());
									
									mat[i][j].setColorNumber(mat[k][j].getColorNumber());
									mat[i][j].setType(mat[k][j].getType());
									
									mat[k][j].setColorNumber(app.getColorNumber());
									mat[k][j].setType(app.getType());
									
									flag = true;
								}
							}	
						}
					}
	
			}
			
		}
		
		public void resolve(){
			for(int i = 0; i < Utility.dim1; i++){
				for(int j = 0; j < Utility.dim2; j++){
					if(mat[i][j].getColorNumber() == -1){
						mat[i][j].setColorNumber(generate());	
						mat[i][j].setType(Utility.normal);		
					}
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
					if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber()){
						if(mat[i][j].getColorNumber() == mat[i+1][j+2].getColorNumber()){
						//	System.out.println("1 "+i+" "+j);
							return true;
						}
					}
					if(mat[i][j].getColorNumber() == mat[i+1][j+1].getColorNumber()){
						if(mat[i][j].getColorNumber() == mat[i][j+2].getColorNumber() 
								|| mat[i][j].getColorNumber() == mat[i+1][j+2].getColorNumber()){
						//	System.out.println("2 "+" "+i+" "+j);
							return true;
						}
					}
					
				}
			}
					
			
			
			//////////////////////////////
			// giu =>
			for(int i = Utility.dim1-1; i > 0; i--){
				for(int j = 0; j < Utility.dim2-2; j++){
					if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber()){
						if(mat[i][j].getColorNumber() == mat[i-1][j+2].getColorNumber()){
						//	System.out.println("3 "+" "+i+" "+j);
							return true;
						}
					}
					if(mat[i][j].getColorNumber() == mat[i-1][j+1].getColorNumber()){
						if(mat[i][j].getColorNumber() == mat[i][j+2].getColorNumber()
							|| mat[i][j].getColorNumber() == mat[i-1][j+2].getColorNumber()){
						//	System.out.println("4 "+" "+i+" "+j);
							return true;
						}
					}
					
				}
			}
			
			
			//////////////////////////////
			// su <=
			for(int i = 0; i < Utility.dim1-1; i++){
				for(int j = Utility.dim2-1; j > 1; j--){
					if(mat[i][j].getColorNumber() == mat[i][j-1].getColorNumber()){
						if(mat[i][j].getColorNumber() == mat[i+1][j-2].getColorNumber()){
						//	System.out.println("5 "+" "+i+" "+j);
							return true;
						}
					}
					if(mat[i][j].getColorNumber() == mat[i+1][j-1].getColorNumber()){
						if(mat[i][j].getColorNumber() == mat[i][j-2].getColorNumber()
							|| mat[i][j].getColorNumber() == mat[i+1][j-2].getColorNumber()){
						//	System.out.println("6 "+" "+i+" "+j);
							return true;
						}
					}
				}
			}
			
			//////////////////////////////
			// giu <=
			
			for(int i = Utility.dim1-1; i > 0; i--){
				for(int j = Utility.dim2-1; j > 1; j--){
					if(mat[i][j].getColorNumber() == mat[i][j-1].getColorNumber()){
						if(mat[i][j].getColorNumber() == mat[i-1][j-2].getColorNumber()){
						//	System.out.println("7 "+" "+i+" "+j);
							return true;
						}
					}
					if(mat[i][j].getColorNumber() == mat[i-1][j-1].getColorNumber()){
						if(mat[i][j].getColorNumber() == mat[i][j-2].getColorNumber()
							|| mat[i][j].getColorNumber() == mat[i-1][j-2].getColorNumber()){
						//	System.out.println("8 "+" "+i+" "+j);
							return true;
						}
					}
				}
			}
			
			//tris lineari
			
			for(int i = 0; i < Utility.dim1; i++){
				for(int j = 0; j < Utility.dim2-3; j++){
					if(mat[i][j].getColorNumber() == mat[i][j+1].getColorNumber() 
						&& mat[i][j].getColorNumber() == mat[i][j+3].getColorNumber()){
					//	System.out.println("9 "+" "+i+" "+j);
						return true;
					}
					if(mat[i][j].getColorNumber() == mat[i][j+2].getColorNumber()
						&& mat[i][j].getColorNumber() == mat[i][j+3].getColorNumber()){
					//	System.out.println("10 "+" "+i+" "+j);
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
					if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber()){
						if(mat[i][j].getColorNumber() == mat[i+2][j+1].getColorNumber()){
						//	System.out.println("11 "+" "+i+" "+j);
							return true;
						}
					}
					if(mat[i][j].getColorNumber() == mat[i+1][j+1].getColorNumber()){
						if(mat[i][j].getColorNumber() == mat[i+2][j].getColorNumber()
							|| mat[i][j].getColorNumber() == mat[i+2][j+1].getColorNumber()){
						//	System.out.println("12 "+" "+i+" "+j);
							return true;
						}
					}
				}
			}

			
			/////////// ↓	dx
			for(int j = Utility.dim2-1; j > 0; j--){
				for(int i = 0; i < Utility.dim1-2; i++){
					if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber()){
						if(mat[i][j].getColorNumber() == mat[i+2][j-1].getColorNumber()){
						//	System.out.println("13 "+" "+i+" "+j);
							return true;
						}
					}
					if(mat[i][j].getColorNumber() == mat[i+1][j-1].getColorNumber()){
						if(mat[i][j].getColorNumber() == mat[i+2][j].getColorNumber() 
							|| mat[i][j].getColorNumber() == mat[i+2][j-1].getColorNumber()){
						//	System.out.println("14 "+" "+i+" "+j);
							return true;
						}
					}
				}
			}
			
			
			/////////// su sx
			for(int j = 0; j < Utility.dim2-1; j++){
				for(int i = Utility.dim1-1; i > 1; i--){
					if(mat[i][j].getColorNumber() == mat[i-1][j].getColorNumber()){
						if(mat[i][j].getColorNumber() == mat[i-2][j+1].getColorNumber()){
						//	System.out.println("15 "+" "+i+" "+j);
							return true;
						}
					}
					if(mat[i][j].getColorNumber() == mat[i-1][j+1].getColorNumber()){
						if(mat[i][j].getColorNumber() == mat[i-2][j].getColorNumber()
							|| mat[i][j].getColorNumber() == mat[i-2][j+1].getColorNumber()){
						//	System.out.println("16 "+" "+i+" "+j);
							return true;
						}
					}
				}
			}
			
			
			/////////////su dx
			for(int j = Utility.dim2-1; j > 0; j--){
				for(int i = Utility.dim1-1; i > 1; i--){
					if(mat[i][j].getColorNumber() == mat[i-1][j].getColorNumber()){
						if(mat[i][j].getColorNumber() == mat[i-2][j-1].getColorNumber()){
						//	System.out.println("17 "+" "+i+" "+j);
							return true;
						}
					}
					if(mat[i][j].getColorNumber() == mat[i-1][j-1].getColorNumber()){
						if(mat[i][j].getColorNumber() == mat[i-2][j].getColorNumber()
							|| mat[i][j].getColorNumber() == mat[i-2][j-1].getColorNumber()){
						//	System.out.println("18 "+" "+i+" "+j);
							return true;
						}
					}
				}
			}
			
		//tris lineari
			
		for(int j = 0; j < Utility.dim2; j++){
			for(int i = 0; i < Utility.dim1-3; i++){
				if(mat[i][j].getColorNumber() == mat[i+1][j].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i+3][j].getColorNumber()){
				//	System.out.println("19 "+" "+i+" "+j);
					return true;
				}
				if(mat[i][j].getColorNumber() == mat[i+2][j].getColorNumber()
					&& mat[i][j].getColorNumber() == mat[i+3][j].getColorNumber()){
				//	System.out.println("20 "+" "+i+" "+j);
					return true;
				}
			}
		}
			
		return false;
		}
		
		public void shuffle(){
			List<Element> list = new ArrayList<>();
			
			for(int i = 0; i < Utility.dim1; i++){
				for(int j = 0; j < Utility.dim2; j++){
					list.add(mat[i][j]);
				}
			}
			System.out.println(list);
			Collections.shuffle(list);
			System.out.println(list);
			
			Iterator<Element> it = list.iterator();
			
			for(int i = 0; i < Utility.dim1; i++){
				for(int j = 0; j < Utility.dim2; j++){
					mat[i][j] = it.next();
				}
			}
		}

	
}