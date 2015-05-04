package view;

import controller.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Classe che disegna la schermata principale del gioco con la matrice di caramelle, label con i punti, le mosse e l'target
 * che devono aggiornarsi ad ogni mossa.
 * 
 * @author Beatrice Ricci
 */

public class PlayGameMenu extends AbstractMenu implements IPlayMenu{

	private static final long serialVersionUID = 6751617017799096695L;
	
	private static final int WIDTH_DIMENSION = 250;
	private static final int HEIGHT_DIMENSION = 150;
	
	private final JPanel panel;
	private final JPanel matrixPanel;
	
	private final Butt matrix[][] = new Butt[Utility.dim1][Utility.dim2];
	private final Controller c = new Controller(this);
		
	private JLabel step = new JLabel(" ");
	private JLabel tot = new JLabel (" "); 
	private JLabel target = new JLabel(" ");
	private JLabel level = new JLabel(" ");
	private final Border border = LineBorder.createBlackLineBorder();
	
	public PlayGameMenu(){
		
		this.setSize(((Utility.dim1*Utility.hbutt)+WIDTH_DIMENSION), ((Utility.dim1*Utility.lbutt)+HEIGHT_DIMENSION));
		this.setResizable(false);
		
		this.panel = new JPanel(new BorderLayout());
		
		this.matrixPanel = new JPanel(new GridLayout(Utility.dim1, Utility.dim2));
		this.matrixPanel.setSize((Utility.dim1*Utility.hbutt), (Utility.dim2*Utility.lbutt));
		
		this.updatePanel();
		this.drawFirstMatrix();
		this.getContentPane().add(this.panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	/**
	 * Metodo per la creazione iniziale della schermata di gioco. In base agli interi che identificano il colore
	 * presenti nella matrice di Element vengono creati dei Butt (e aggiunti alla matrice matrix[][]) con le rispettive icone.
	 */
	private void drawFirstMatrix(){
		for(int i = 0; i < Utility.dim1; i++){
			for(int j = 0; j < Utility.dim2; j++){
				matrix[i][j] = new Butt(i, j);
				
				if (this.c.getModelNum(i, j) == Utility.blue){
					matrix[i][j].setIcon(IconUtility.blueIC);
				}else if (this.c.getModelNum(i, j) == Utility.yellow){
					matrix[i][j].setIcon(IconUtility.yellowIC);
				}else if (this.c.getModelNum(i, j) == Utility.green){
					matrix[i][j].setIcon(IconUtility.greenIC);
				}else if (this.c.getModelNum(i, j) == Utility.violet){
					matrix[i][j].setIcon(IconUtility.violetIC);
				}else if (this.c.getModelNum(i, j) == Utility.orange){
					matrix[i][j].setIcon(IconUtility.orangeIC);
				}else if (this.c.getModelNum(i, j) == Utility.red){
					matrix[i][j].setIcon(IconUtility.redIC);
				}
				
				matrix[i][j].addActionListener(c.getObserver());
				matrixPanel.add(matrix[i][j]);	
			}
		}
	}
	/**
	 * Metodo per aggiungere tutti i pannelli "minori", nella parte centrale viene inserita la matrice di gioco
	 */
	private void updatePanel(){
		this.panel.add(this.matrixPanel, BorderLayout.CENTER);
		this.panel.add(this.setNorthPanel(), BorderLayout.NORTH);
		this.panel.add(this.setWestPanel(), BorderLayout.WEST);
		this.panel.add(this.setSouthPanel(), BorderLayout.SOUTH);
		this.panel.add(this.setEastPanel(), BorderLayout.EAST);
	}
	/**
	 * Metodo per disegnare il pannello "nord".  
	 * @return pannello "superiore" della schermata di gioco
	 */
	private JPanel setNorthPanel(){
		JPanel pNorth = new JPanel(new BorderLayout());
		
		this.level.setFont(new Font("Arial",Font.BOLD,14));
		this.level.setForeground(Color.MAGENTA);
		this.level.setOpaque(true);
		this.level.setBackground(Color.WHITE);
		this.level.setBorder(border);
		
		pNorth.add(this.level, BorderLayout.EAST);
		this.lookPanel(pNorth, Color.CYAN);
		
		return pNorth;
	}
	/**
	 * Metodo per disegnare il pannello a sinistra
	 * @return pannello sinistro
	 */
	private JPanel setWestPanel(){
		JPanel pWest = new JPanel(new BorderLayout());
		JPanel internalWestPanel = new JPanel(new BorderLayout());
		
		this.step.setFont(new Font("Arial",Font.BOLD,24));
		
		this.target.setFont(new Font("Arial",Font.BOLD,18));
		this.target.setForeground(Color.MAGENTA);
		this.target.setOpaque(true);
		this.target.setBackground(Color.WHITE);
		this.target.setBorder(border);
		
		this.tot.setFont(new Font("Arial",Font.BOLD,20));
		this.updateStep(this.c.getModelStep());
		
		internalWestPanel.add(this.target, BorderLayout.NORTH);
		internalWestPanel.add(this.tot, BorderLayout.CENTER);
		
		pWest.add(this.step, BorderLayout.NORTH);
		pWest.add(internalWestPanel,  BorderLayout.CENTER);
		
		this.lookPanel(pWest, Color.CYAN);
		this.lookPanel(internalWestPanel, Color.CYAN);
		return pWest;
	}
	/**
	 * Metodo per disegnare il pannello a sud.
	 * @return pannello in basso
	 */
	private JPanel setSouthPanel(){
		JPanel pSouth = new JPanel(new BorderLayout());
		JButton close = new JButton();
	
		close.setIcon(ViewUtility.closeIm);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Question();
			}
		});
		pSouth.add(close, BorderLayout.WEST);
		
		this.lookPanel(pSouth, Color.CYAN);
		return pSouth;
	}
	/**
	 * Medoto per disegnare il pannello a sinistra
	 * @return pannello di sinistra
	 */
	private JPanel setEastPanel(){
		JPanel pEast = new JPanel(new BorderLayout());
		JLabel gap = new JLabel("     ");
		pEast.add(gap);
		
		this.lookPanel(pEast, Color.CYAN);
		return pEast;
	}
	
	public void updateTarget(int n){
		this.target.setText("target: "+n+" p");
		this.c.setModelTarget(n);
	}
	
	public void setDiff(String s){
		this.level.setText(s+" LEVEL");
	}

	public void updateStep(int n){
		this.step.setText("  "+n+"  ");
		this.c.setModelStep(n);
	}
	
	public void updateTot(){
		this.tot.setText(" "+c.getModelTot()+" punti");
	}
	
	public Butt getAMatrixButt(int i, int j){
		return this.matrix[i][j];
	}
}
