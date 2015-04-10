package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends AbstractMenu {

	private static final long serialVersionUID = -8627423879053598019L;
	
	private JButton start = new JButton();
	private JButton instructions = new JButton();
	private JButton exit = new JButton();
	
	public Menu(){
		//title
		this.setTheTitle("W E L C O M E");
		
		//dimension
		Dimension size;
		size = Toolkit.getDefaultToolkit().getScreenSize();
		int taglia = (int)size.getWidth()/2;
		this.setSize(taglia, taglia-((int)size.getHeight()/10));
		this.setResizable(false);
		
		//create principal panel
		JPanel panel = new MyPanel();
		panel.setLayout(new FlowLayout());
		
		this.start.setIcon(Utility.icStart);
		this.lookButton(start, Color.pink, false);
		
		this.instructions.setIcon(Utility.icInstr);
		this.lookButton(instructions, Color.pink, false);
		
		this.exit.setIcon(Utility.icExit);
		this.lookButton(exit, Color.pink, false);
		
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
