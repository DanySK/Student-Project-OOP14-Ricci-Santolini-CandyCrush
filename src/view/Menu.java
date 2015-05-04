package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 * Classe che contiene il menù iniziale.
 * E' possibile scegliere di iniziare subito a giocare, di leggere le istruzioni di gioco o di chiudere l'applicazione
 * 
 * @author Beatrice Ricci
 *
 */
public class Menu extends AbstractMenu {

	private static final long serialVersionUID = -8627423879053598019L;
	
	private static final int WIDTH_DIMENSION = 2;
	private static final int HEIGHT_DIMENSION = 10;
	
	private JButton start = new JButton();
	private JButton instructions = new JButton();
	private JButton exit = new JButton();
	
	public Menu(){
		//title
		this.setTitle("W E L C O M E");
		
		//dimension
		Dimension size;
		size = Toolkit.getDefaultToolkit().getScreenSize();
		int dimension = (int)size.getWidth()/WIDTH_DIMENSION;
		this.setSize(dimension, dimension-((int)size.getHeight()/HEIGHT_DIMENSION));
		this.setResizable(false);
		
		//create principal panel
		JPanel panel = new MyPanel(ViewUtility.caramelle);
		panel.setLayout(new FlowLayout());
		
		this.start.setIcon(ViewUtility.icStart);
		this.lookButton(this.start, Color.PINK, false);
		
		this.instructions.setIcon(ViewUtility.icInstr);
		this.lookButton(this.instructions, Color.PINK, false);
		
		this.exit.setIcon(ViewUtility.icExit);
		this.lookButton(this.exit, Color.PINK, false);
		
		//add ActionListener to Buttons
		this.start.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				new DifficultMenu();
				closePage();
			}
			
		});
		
		this.instructions.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				new Instructions();
			}
			
		});
		
		this.exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				closeGame();
			}
			
		});
		
		panel.add(this.start);
		panel.add(this.instructions);
		panel.add(this.exit);
		
		this.getContentPane().add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
