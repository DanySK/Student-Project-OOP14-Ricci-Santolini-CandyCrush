package mvc;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class View extends AbstractMenu implements IView{

	private static final long serialVersionUID = 6751617017799096695L;
	public static final int dim1 = 7;
	public static final int dim2 = 7;
	
	private final static String sep = File.separator;
	
	private final static ImageIcon blu = new ImageIcon("res"+sep+"azzurro.jpg");
	private final static ImageIcon yellow = new ImageIcon("res"+sep+"gialla.jpg");
	private final static ImageIcon green = new ImageIcon("res"+sep+"verde.jpg");
	private final static ImageIcon violet = new ImageIcon("res"+sep+"viola.jpg");
	
	private JPanel panel;
	private JPanel matrixPanel;
	
	private Butt matrix[][] = new Butt[dim1][dim2];
	private Model modelW = new Model();
	private Controller c = new Controller(this, modelW);
	
	private JLabel step = new JLabel("  30 mosse ");//modificare num mosse!!!!!!!!!!!!!!!!!!!!!!!!!!!
	private JLabel tot = new JLabel (" 2000 punti"); //modificare punteggio!!!!!!!!!!!!!
	
	public View(){
		Dimension size;
		size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(((dim1*100)+250), ((dim1*100)+150));
		this.setResizable(false);
		
		panel = new JPanel(new BorderLayout());
		
		matrixPanel = new JPanel(new GridLayout(dim1, dim2));
		matrixPanel.setSize((dim1*100), (dim2*100));
		
		panel.add(matrixPanel, BorderLayout.CENTER);
		panel.add(setNorthPanel(), BorderLayout.NORTH);
		panel.add(setWestPanel(), BorderLayout.WEST);
		panel.add(setSouthPanel(), BorderLayout.SOUTH);
		panel.add(setEastPanel(), BorderLayout.EAST);
		
		for(int i = 0; i < dim1; i++){
			for(int j = 0; j < dim2; j++){
				matrix[i][j] = new Butt(i, j);
				
				if (modelW.getMat()[i][j].getColorButt() == ColorButt.LIGHT_BLU){
					matrix[i][j].setIcon(blu);
				}else if (modelW.getMat()[i][j].getColorButt() == ColorButt.YELLOW){
					matrix[i][j].setIcon(yellow);
				}else if (modelW.getMat()[i][j].getColorButt() == ColorButt.GREEN){
					matrix[i][j].setIcon(green);
				}else if (modelW.getMat()[i][j].getColorButt() == ColorButt.VIOLET){
					matrix[i][j].setIcon(violet);
				}
				
				matrix[i][j].addActionListener(c);
				matrixPanel.add(matrix[i][j]);	
			}
		}	
		
		this.getContentPane().add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
	
	public void setStep(int numStep){
		this.step.setText("  "+numStep+"  ");
	}
	
	public Butt[][] getMatrix(){
		return this.matrix;
	}
	
	public void updateView(JPanel p, Oggetto m[][]){
			
		for(int i = 0; i < dim1; i++){
			for(int j = 0; j < dim2; j++){
				if (modelW.getMat()[i][j].getColorButt() == ColorButt.LIGHT_BLU){
					matrix[i][j].setIcon(blu);
				}else if (modelW.getMat()[i][j].getColorButt() == ColorButt.YELLOW){
					matrix[i][j].setIcon(yellow);
				}else if (modelW.getMat()[i][j].getColorButt() == ColorButt.GREEN){
					matrix[i][j].setIcon(green);
				}else if (modelW.getMat()[i][j].getColorButt() == ColorButt.VIOLET){
					matrix[i][j].setIcon(violet);
				}
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
		
		this.step.setFont(new Font("Arial",Font.BOLD,26));
		this.step.setBackground(Color.white);

		this.tot.setFont(new Font("Arial",Font.BOLD,26));
		this.tot.setBackground(Color.white);
		
		pWest.add(step, BorderLayout.NORTH);
		pWest.add(tot, BorderLayout.CENTER);
		this.lookPanel(pWest, Color.cyan);
		return pWest;
	}
	
	private JPanel setSouthPanel(){
		JPanel pSouth = new JPanel(new BorderLayout());
		JButton close = new JButton();
		ImageIcon closeIm = new ImageIcon("res"+sep+"close.jpg");
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
		/**/
	}
	
	private void updateTot(){
		/**/
	}
	
	
}
