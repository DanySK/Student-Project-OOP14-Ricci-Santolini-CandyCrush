package mvc;

import java.awt.*;
import java.io.File;

import javax.swing.*;

public class View extends JFrame implements IView{

	private static final long serialVersionUID = 6751617017799096695L;
	public static final int dim1 = 5;
	public static final int dim2 = 5;
	
	private final static String sep = File.separator;
	
	private final static ImageIcon blu = new ImageIcon("res"+sep+"azzurro.jpg");
	private final static ImageIcon yellow = new ImageIcon("res"+sep+"gialla.jpg");
	private final static ImageIcon green = new ImageIcon("res"+sep+"verde.jpg");
	private final static ImageIcon violet = new ImageIcon("res"+sep+"viola.jpg");
	
	private JPanel panel;
	private JPanel centralPanel;
	
	private Butt matrix[][] = new Butt[dim1][dim2];
	private Model modelW = new Model();
	private Controller c = new Controller(this, modelW);
	
	public View(){
		Dimension size;
		size = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setSize((int)size.getWidth(), (int)size.getHeight());
		this.setSize((dim1*110+150), (dim1*110+50));
		this.setResizable(false);
		
		panel = new JPanel(new BorderLayout());
		panel.setSize((int)size.getWidth(), (int)size.getHeight());
		this.getContentPane().add(panel);
		
		centralPanel = new JPanel(new GridLayout(dim1, dim2));
		centralPanel.setSize((dim1*110), (dim2*110));
		
		JLabel nord = new JLabel(" ");
		//nord.setSize(new Dimension (250,40));
		nord.setOpaque(true);
		nord.setBackground(Color.cyan);
		
		JLabel sud = new JLabel(" ");
		sud.setOpaque(true);
		sud.setBackground(Color.cyan);
		
		JLabel ovest = new JLabel("         ");
		ovest.setOpaque(true);
		ovest.setBackground(Color.cyan);
		
		JLabel est = new JLabel("                 ");
		est.setOpaque(true);
		est.setBackground(Color.cyan);
		
		panel.add(centralPanel, BorderLayout.CENTER);
		panel.add(nord, BorderLayout.NORTH);
		panel.add(sud, BorderLayout.SOUTH);
		panel.add(ovest, BorderLayout.WEST);
		panel.add(est, BorderLayout.EAST);
		
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
				centralPanel.add(matrix[i][j]);	
			}
		}	
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public JPanel getPanel(){
		return this.centralPanel;
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
	/*public void whatIcon(){		
		if (this.getColor() == ColorButt.LIGHT_BLU){
			this.setIcon(blu);
		}else if (this.getColor() == ColorButt.YELLOW){
			this.setIcon(yellow);
		}else if (this.getColor() == ColorButt.GREEN){
			this.setIcon(green);
		}else if (this.getColor() == ColorButt.VIOLET){
			this.setIcon(violet);
		}
	}*/
	
	
	/*public Oggetto[][] getMat(){
		return this.modelW.getMat();
	}*/
	
	
	/*public void draw(JPanel p, Oggetto m[][]){
		
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				matrix[i][j] = new Butt(m[i][j].getString(), i, j);
				centralPanel.add(matrix[i][j]);	
				matrix[i][j].addActionListener(c);
			}
		}	
		
	}*/
}
