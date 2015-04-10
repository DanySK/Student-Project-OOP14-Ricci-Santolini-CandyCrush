package view;

import mvc.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * 
 * @author Beatrice Ricci
 */


public class PlayGameMenu extends AbstractMenu implements IPlayMenu{

	private static final long serialVersionUID = 6751617017799096695L;
	
	private final JPanel panel;
	private final JPanel matrixPanel;
	
	private final Butt matrix[][] = new Butt[Utility.dim1][Utility.dim2];
	private final Model modelW = new Model();
	private final Controller c = new Controller(this, modelW);
	
	private JLabel step = new JLabel(" ");
	private JLabel tot = new JLabel (" "); 
	private JLabel obiettivo = new JLabel(" ");
	private JLabel level = new JLabel(" ");
	
	public PlayGameMenu(){
		
		this.setSize(((Utility.dim1*Utility.hbutt)+250), ((Utility.dim1*Utility.lbutt)+150));
		this.setResizable(false);
		
		this.panel = new JPanel(new BorderLayout());
		
		this.matrixPanel = new JPanel(new GridLayout(Utility.dim1, Utility.dim2));
		this.matrixPanel.setSize((Utility.dim1*Utility.hbutt), (Utility.dim2*Utility.lbutt));
		
		this.updatePanel();
		this.drawFirstMatrix();
		this.inizialize();
	
		this.getContentPane().add(this.panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	private void inizialize(){
		
		this.modelW.setPunteggio(0);
		this.updateTot();
	}
	
	/**
	 * 
	 */
	private void updatePanel(){
		this.panel.add(this.matrixPanel, BorderLayout.CENTER);
		this.panel.add(this.setNorthPanel(), BorderLayout.NORTH);
		this.panel.add(this.setWestPanel(), BorderLayout.WEST);
		this.panel.add(this.setSouthPanel(), BorderLayout.SOUTH);
		this.panel.add(this.setEastPanel(), BorderLayout.EAST);
	}
	
	/**
	 * 
	 * @return
	 */
	private JPanel setNorthPanel(){
		JPanel pNorth = new JPanel(new BorderLayout());
		
		this.level.setFont(new Font("Arial",Font.BOLD,14));
		pNorth.add(level, BorderLayout.EAST);
		this.lookPanel(pNorth, Color.cyan);
		
		return pNorth;
	}
	/**
	 * 
	 * @return
	 */
	private JPanel setWestPanel(){
		JPanel pWest = new JPanel(new BorderLayout());
		JPanel internalWestPanel = new JPanel(new BorderLayout());
		
		this.step.setFont(new Font("Arial",Font.BOLD,24));
		
		this.obiettivo.setFont(new Font("Arial",Font.BOLD,18));
		this.obiettivo.setBackground(Color.white);
		
		this.tot.setFont(new Font("Arial",Font.BOLD,20));
		this.tot.setBackground(Color.white);
		this.setTot(0);
		
		internalWestPanel.add(obiettivo, BorderLayout.NORTH);
		internalWestPanel.add(tot, BorderLayout.CENTER);
		
		pWest.add(step, BorderLayout.NORTH);
		pWest.add(internalWestPanel,  BorderLayout.CENTER);
		
		this.lookPanel(pWest, Color.cyan);
		this.lookPanel(internalWestPanel, Color.cyan);
		return pWest;
	}
	/**
	 * 
	 * @return
	 */
	private JPanel setSouthPanel(){
		JPanel pSouth = new JPanel(new BorderLayout());
		JButton close = new JButton();
	
		close.setIcon(Utility.closeIm);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Question();
			}
		});
		pSouth.add(close, BorderLayout.WEST);
		
		this.lookPanel(pSouth, Color.cyan);
		return pSouth;
	}
	/**
	 * 
	 * @return
	 */
	private JPanel setEastPanel(){
		JPanel pEast = new JPanel(new BorderLayout());
		JLabel gap = new JLabel("     ");
		pEast.add(gap);
		
		this.lookPanel(pEast, Color.cyan);
		return pEast;
	}
	/**
	 * Metodo per la creazione iniziale della schermata di gioco. In base agli interi che identificano il colore
	 * presenti nella matrice di Element vengono creati dei Butt (e aggiunti alla matrice matrix[][]) con le rispettive icone.
	 */
	private void drawFirstMatrix(){
		for(int i = 0; i < Utility.dim1; i++){
			for(int j = 0; j < Utility.dim2; j++){
				matrix[i][j] = new Butt(i, j);
				
				if (modelW.getNum(i, j) == Utility.blue){
					matrix[i][j].setIcon(Utility.blueIC);
				}else if (modelW.getNum(i, j) == Utility.yellow){
					matrix[i][j].setIcon(Utility.yellowIC);
				}else if (modelW.getNum(i, j) == Utility.green){
					matrix[i][j].setIcon(Utility.greenIC);
				}else if (modelW.getNum(i, j) == Utility.violet){
					matrix[i][j].setIcon(Utility.violetIC);
				}else if (modelW.getNum(i, j) == Utility.orange){
					matrix[i][j].setIcon(Utility.orangeIC);
				}else if (modelW.getNum(i, j) == Utility.red){
					matrix[i][j].setIcon(Utility.redIC);
				}
				
				matrix[i][j].addActionListener(c.getObserver());
				matrixPanel.add(matrix[i][j]);	
			}
		}
	}
	/**
	 * Aggiorno la label che mostra al giocatore il suo punteggio totale
	 * @param num punteggio ottenuto grazie all'ultima mossa
	 */
	private void setTot(int num){
		this.tot.setText(" "+num+" punti");
	}
	
	public void setStep(int n){
		this.step.setText("  "+n+"  ");
		this.modelW.setMosse(n);
	}
	
	public void setObiettivo(int n){
		this.obiettivo.setText("Obiettivo: "+n+" p");
		this.modelW.setObiettivo(n);
	}
	
	public void setDiff(String s){
		this.level.setText(s+" LEVEL");
	}

	public void updateStep(){
		int temp = modelW.getMosse();
		this.setStep(temp);
	}
	
	public void updateTot(){
		int temp = modelW.getPunteggio();
		this.setTot(temp);
	}
	
	public JPanel getPanel(){
		return this.matrixPanel;
	}
	
	public void updateView(){
			
		for(int i = 0; i < Utility.dim1; i++){
			for(int j = 0; j < Utility.dim2; j++){
				//if (modelW.getNum(i, j) == -1){
					//matrix[i][j].setIcon(Utility.black);
				//}
				//normal type
				if (modelW.getTypeEl(i, j) == Utility.normal){
					if (modelW.getNum(i, j) == Utility.blue){
						matrix[i][j].setIcon(Utility.blueIC);
					}else if (modelW.getNum(i, j) == Utility.yellow){
						matrix[i][j].setIcon(Utility.yellowIC);
					}else if (modelW.getNum(i, j) == Utility.green){
						matrix[i][j].setIcon(Utility.greenIC);
					}else if (modelW.getNum(i, j) == Utility.violet){
						matrix[i][j].setIcon(Utility.violetIC);
					}else if (modelW.getNum(i, j) == Utility.orange){
						matrix[i][j].setIcon(Utility.orangeIC);
					}else if (modelW.getNum(i, j) == Utility.red){
						matrix[i][j].setIcon(Utility.redIC);
					}
				}
				//stripped Ver type
				else if (modelW.getTypeEl(i, j) == Utility.stripedV){
					if (modelW.getNum(i, j) == Utility.blue){
						matrix[i][j].setIcon(Utility.blueSVIC);
					}else if (modelW.getNum(i, j) == Utility.yellow){
						matrix[i][j].setIcon(Utility.yellowSVIC);
					}else if (modelW.getNum(i, j) == Utility.green){
						matrix[i][j].setIcon(Utility.greenSVIC);
					}else if (modelW.getNum(i, j) == Utility.violet){
						matrix[i][j].setIcon(Utility.violetSVIC);
					}else if (modelW.getNum(i, j) == Utility.orange){
						matrix[i][j].setIcon(Utility.orangeSVIC);
					}else if (modelW.getNum(i, j) == Utility.red){
						matrix[i][j].setIcon(Utility.redSVIC);
					}
				}//stripped Or type
				else if (modelW.getTypeEl(i, j) == Utility.stripedO){
					if (modelW.getNum(i, j) ==  Utility.blue){
						matrix[i][j].setIcon(Utility.blueSOIC);
					}else if (modelW.getNum(i, j) ==  Utility.yellow){
						matrix[i][j].setIcon(Utility.yellowSOIC);
					}else if (modelW.getNum(i, j) ==  Utility.green){
						matrix[i][j].setIcon(Utility.greenSOIC);
					}else if (modelW.getNum(i, j) ==  Utility.violet){
						matrix[i][j].setIcon(Utility.violetSOIC);
					}else if (modelW.getNum(i, j) ==  Utility.orange){
						matrix[i][j].setIcon(Utility.orangeSOIC);
					}else if (modelW.getNum(i, j) ==  Utility.red){
						matrix[i][j].setIcon(Utility.redSOIC);
					}
				}//wrapped
				else if (modelW.getTypeEl(i, j) == Utility.wrapped){
						if (modelW.getNum(i, j) == Utility.blue){
							matrix[i][j].setIcon(Utility.blueWIC);
						}else if (modelW.getNum(i, j) == Utility.yellow){
							matrix[i][j].setIcon(Utility.yellowWIC);
						}else if (modelW.getNum(i, j) == Utility.green){
							matrix[i][j].setIcon(Utility.greenWIC);
						}else if (modelW.getNum(i, j) == Utility.violet){
							matrix[i][j].setIcon(Utility.violetWIC);
						}else if (modelW.getNum(i, j) == Utility.orange){
							matrix[i][j].setIcon(Utility.orangeWIC);
						}else if (modelW.getNum(i, j) == Utility.red){
							matrix[i][j].setIcon(Utility.redWIC);
						}
				}//five
				else if (modelW.getTypeEl(i, j) == Utility.five){
						matrix[i][j].setIcon(Utility.fiveIC);
				}
				this.updateStep();
				this.updateTot();
			}		
		}
	}
}
