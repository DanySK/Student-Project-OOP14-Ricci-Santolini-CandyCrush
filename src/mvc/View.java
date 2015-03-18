package mvc;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class View extends AbstractMenu implements IView{

	private static final long serialVersionUID = 6751617017799096695L;
	
	private JPanel panel;
	private JPanel matrixPanel;
	
	private Butt matrix[][] = new Butt[Utility.dim1][Utility.dim2];
	private Model modelW = new Model();
	private Controller c = new Controller(this, modelW);
	
	private JLabel step = new JLabel(" ");//modificare num mosse!!!!!!!!!!!!!!!!!!!!!!!!!!!
	private JLabel tot = new JLabel (" "); //modificare punteggio!!!!!!!!!!!!!
	private JLabel obiettivo = new JLabel(" ");//modificare obiettivo!!!!!!!!!!!!!
	
	public View(){
		this.setSize(((Utility.dim1*Utility.hbutt)+250), ((Utility.dim1*Utility.lbutt)+150));
		this.setResizable(false);
		
		panel = new JPanel(new BorderLayout());
		
		matrixPanel = new JPanel(new GridLayout(Utility.dim1, Utility.dim2));
		matrixPanel.setSize((Utility.dim1*Utility.hbutt), (Utility.dim2*Utility.lbutt));
		
		panel.add(matrixPanel, BorderLayout.CENTER);
		panel.add(this.setNorthPanel(), BorderLayout.NORTH);
		panel.add(this.setWestPanel(), BorderLayout.WEST);
		panel.add(this.setSouthPanel(), BorderLayout.SOUTH);
		panel.add(this.setEastPanel(), BorderLayout.EAST);
		
		for(int i = 0; i < Utility.dim1; i++){
			for(int j = 0; j < Utility.dim2; j++){
				matrix[i][j] = new Butt(i, j);
				if (modelW.getMat()[i][j].getNum() == 0){
					matrix[i][j].setIcon(Utility.blue);
				}else if (modelW.getMat()[i][j].getNum() == 1){
					matrix[i][j].setIcon(Utility.yellow);
				}else if (modelW.getMat()[i][j].getNum() == 2){
					matrix[i][j].setIcon(Utility.green);
				}else if (modelW.getMat()[i][j].getNum() == 3){
					matrix[i][j].setIcon(Utility.violet);
				}else if (modelW.getMat()[i][j].getNum() == 4){
					matrix[i][j].setIcon(Utility.orange);
				}else if (modelW.getMat()[i][j].getNum() == 5){
					matrix[i][j].setIcon(Utility.red);
				}
				matrix[i][j].addActionListener(c);
				matrixPanel.add(matrix[i][j]);	
			}
		}	
		
		this.getContentPane().add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public JPanel getPanel(){
		return this.matrixPanel;
	}
	
	//li uso ??
	/*public String getTotNumber(){
		return this.tot.getText();
	}
	
	public String getStepNumber(){
		return this.step.getText();
	}*/
	private void setTot(int num){
		this.tot.setText(" "+num+" punti");
		System.out.println(num);
	}
	
	public void setStep(int n){
		this.step.setText("  "+n+"  ");
		modelW.setMosse(n);
		System.out.println(modelW.getMosse());
	}
	
	public void setObiettivo(int n){
		this.obiettivo.setText("Obiettivo: "+n+" p");
		modelW.setObiettivo(n);
		System.out.println(modelW.getObiettivo());
	}
	
	/*private Butt[][] getMatrix(){
		return this.matrix;
	}*/
	
	public void updateView(JPanel p, Oggetto m[][]){
			
		for(int i = 0; i < Utility.dim1; i++){
			for(int j = 0; j < Utility.dim2; j++){
				//normal type
				if (modelW.getMat()[i][j].getNum() >= 0 && modelW.getMat()[i][j].getNum()< 6){
					if (modelW.getMat()[i][j].getNum() == 0){
						matrix[i][j].setIcon(Utility.blue);
					}else if (modelW.getMat()[i][j].getNum() == 1){
						matrix[i][j].setIcon(Utility.yellow);
					}else if (modelW.getMat()[i][j].getNum() == 2){
						matrix[i][j].setIcon(Utility.green);
					}else if (modelW.getMat()[i][j].getNum() == 3){
						matrix[i][j].setIcon(Utility.violet);
					}else if (modelW.getMat()[i][j].getNum() == 4){
						matrix[i][j].setIcon(Utility.orange);
					}else if (modelW.getMat()[i][j].getNum() == 5){
						matrix[i][j].setIcon(Utility.red);
					}
				}
				//stripped Ver type
				else if (modelW.getMat()[i][j].getNum() >= 6 && modelW.getMat()[i][j].getNum()< 12){
					System.out.println("bbb");
					if (modelW.getMat()[i][j].getNum() == 6){
						matrix[i][j].setIcon(Utility.blueSV);
					}else if (modelW.getMat()[i][j].getNum() == 7){
						matrix[i][j].setIcon(Utility.yellowSV);
					}else if (modelW.getMat()[i][j].getNum() == 8){
						matrix[i][j].setIcon(Utility.greenSV);
					}else if (modelW.getMat()[i][j].getNum() == 9){
						matrix[i][j].setIcon(Utility.violetSV);
					}else if (modelW.getMat()[i][j].getNum() == 10){
						matrix[i][j].setIcon(Utility.redSV);
					}else if (modelW.getMat()[i][j].getNum() == 11){
						matrix[i][j].setIcon(Utility.yellowSV);
					}
				}//stripped Or type
				else if (modelW.getMat()[i][j].getNum() >= 12 && modelW.getMat()[i][j].getNum()< 18){
					if (modelW.getMat()[i][j].getNum() == 12){
						matrix[i][j].setIcon(Utility.blueSV);
					}else if (modelW.getMat()[i][j].getNum() == 13){
						matrix[i][j].setIcon(Utility.yellowSV);
					}else if (modelW.getMat()[i][j].getNum() == 14){
						matrix[i][j].setIcon(Utility.greenSV);
					}else if (modelW.getMat()[i][j].getNum() == 15){
						matrix[i][j].setIcon(Utility.violetSV);
					}else if (modelW.getMat()[i][j].getNum() == 16){
						matrix[i][j].setIcon(Utility.orangeSV);
					}else if (modelW.getMat()[i][j].getNum() == 17){
						matrix[i][j].setIcon(Utility.redSV);
					}
				}//wrapped
				else if (modelW.getMat()[i][j].getNum() >= 18 && modelW.getMat()[i][j].getNum()< 24){
						if (modelW.getMat()[i][j].getNum() == 18){
							matrix[i][j].setIcon(Utility.blueW);
						}else if (modelW.getMat()[i][j].getNum() == 19){
							matrix[i][j].setIcon(Utility.yellowW);
						}else if (modelW.getMat()[i][j].getNum() == 20){
							matrix[i][j].setIcon(Utility.greenW);
						}else if (modelW.getMat()[i][j].getNum() == 21){
							matrix[i][j].setIcon(Utility.violetW);
						}else if (modelW.getMat()[i][j].getNum() == 22){
							matrix[i][j].setIcon(Utility.orangeW);
						}else if (modelW.getMat()[i][j].getNum() == 23){
							matrix[i][j].setIcon(Utility.redW);
						}
				}//five
				else if (modelW.getMat()[i][j].getNum() == 24){
						matrix[i][j].setIcon(Utility.five);
				}
				this.updateStep();
				this.updateTot();
			}		
		}
	}
	
	private JPanel setNorthPanel(){
		//if mosseIniziali == ??  => EASY || MEDIUM || DIFFICULT LEVEL
		JPanel pNorth = new JPanel(new BorderLayout());
		JLabel level = new JLabel(" ??????? LEVEL");
		level.setFont(new Font("Arial",Font.BOLD,14));
		pNorth.add(level, BorderLayout.EAST);
		this.lookPanel(pNorth, Color.cyan);
		
		return pNorth;
	}
	
	private JPanel setWestPanel(){
		JPanel pWest = new JPanel(new BorderLayout());
		JPanel internalPanel = new JPanel(new BorderLayout());
		
		this.step.setFont(new Font("Arial",Font.BOLD,24));
		this.step.setBackground(Color.white);

		this.obiettivo.setFont(new Font("Arial",Font.BOLD,18));
		this.obiettivo.setBackground(Color.white);
		
		this.tot.setFont(new Font("Arial",Font.BOLD,20));
		this.tot.setBackground(Color.white);
		
		this.setTot(0);
		
		internalPanel.add(obiettivo, BorderLayout.NORTH);
		internalPanel.add(tot, BorderLayout.CENTER);
		
		pWest.add(step, BorderLayout.NORTH);
		pWest.add(internalPanel,  BorderLayout.CENTER);
		
		
		this.lookPanel(pWest, Color.cyan);
		this.lookPanel(internalPanel, Color.cyan);
		return pWest;
	}
	
	private JPanel setSouthPanel(){
		JPanel pSouth = new JPanel(new BorderLayout());
		JButton close = new JButton();
		ImageIcon closeIm = new ImageIcon("res"+Utility.sep+"close.jpg");
		close.setIcon(closeIm);
		
		pSouth.add(close, BorderLayout.WEST);
		
		close.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				closeGame();
			}
			
		});
		this.lookPanel(pSouth, Color.cyan);
		return pSouth;
	}
	
	private JPanel setEastPanel(){
		JPanel pEast = new JPanel(new BorderLayout());
		JLabel est = new JLabel("             ");
		pEast.add(est);
		
		this.lookPanel(pEast, Color.cyan);
		return pEast;
	}
	
	private void updateStep(){
		int temp = modelW.getMosse();
		this.setStep(temp);
	}
	
	private void updateTot(){
		int temp = modelW.getPunteggio();
		this.setStep(temp);
	}
}
