package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

public class Menu extends AbstractMenu {

	private static final long serialVersionUID = -8627423879053598019L;
	private static final String sep = File.separator;
	
	private JPanel ps = new JPanel();
	private JPanel pi = new JPanel();
	private JPanel pe = new JPanel();
	
	private JButton start = new JButton(/*"Start the game"*/);
	private JButton instructions = new JButton(/*"Instructions"*/);
	private JButton exit = new JButton(/*"Bye Bye"*/);
	
	private ImageIcon icStart = new ImageIcon("res"+sep+"start.jpg");
	private ImageIcon icInstr = new ImageIcon("res"+sep+"instr.jpg");
	private ImageIcon icExit = new ImageIcon("res"+sep+"exit.jpg");
	
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
		JPanel panel = new JPanel(new FlowLayout());
		panel.setOpaque(true);
		panel.setBackground(Color.pink);
		
		this.start.setIcon(icStart);
		this.lookButton(start);
		
		this.instructions.setIcon(icInstr);
		this.lookButton(instructions);
		
		this.exit.setIcon(icExit);
		this.lookButton(exit);
		
		this.ps.add(start);
		this.lookPanel(ps, Color.pink);
		
		this.pi.add(instructions);
		this.lookPanel(pi, Color.pink);
		
		this.pe.add(exit);
		this.lookPanel(pe, Color.pink);
		
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
		
		//add mini-panels to the principal panel
		panel.add(ps);
		panel.add(pi);
		panel.add(pe);
		
		this.getContentPane().add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void lookButton(JButton b){
		b.setBackground(Color.pink);
		b.setBorderPainted(false);
	}
}
