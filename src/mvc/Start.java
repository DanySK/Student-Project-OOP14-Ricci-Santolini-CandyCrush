package mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Start extends JFrame {

	private static final long serialVersionUID = 5566467747603174212L;
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
	
	private JLabel titolo = new JLabel(" ");
	
	public Start(){
		Dimension size;
		size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)size.getWidth()/2, (int)size.getHeight());
		this.setResizable(false);
		this.setTitle("W E L C O M E !!");
		
		JPanel panel = new JPanel();
		panel.setSize((int)size.getWidth()/2, (int)size.getHeight());
		panel.setOpaque(true);
		panel.setBackground(Color.pink);
		
		JPanel pan = new JPanel(new BorderLayout());
		pan.setOpaque(true);
		pan.setBackground(Color.pink);
		
		/*this.start.setBackground(Color.WHITE);
		this.start.setSize(new Dimension ((int)size.getWidth()/3, (int)size.getHeight()/8));
		
		this.instructions.setBackground(Color.WHITE);
		this.instructions.setSize(new Dimension(((int)size.getWidth()/3), ((int)size.getHeight()/8)));
		
		this.exit.setBackground(Color.WHITE);
		this.exit.setSize(new Dimension(((int)size.getWidth()/3), ((int)size.getHeight()/8)));*/
		this.start.setIcon(icStart);
		this.start.setBackground(Color.pink);
		this.start.setBorderPainted(false);
		
		this.instructions.setIcon(icInstr);
		this.instructions.setBackground(Color.pink);
		this.instructions.setBorderPainted(false);
		
		this.exit.setIcon(icExit);
		this.exit.setBackground(Color.pink);
		this.exit.setBorderPainted(false);
		
		this.ps.add(start);
		this.ps.setOpaque(true);
		this.ps.setBackground(Color.PINK);
		this.pi.add(instructions);
		this.pi.setOpaque(true);
		this.pi.setBackground(Color.PINK);
		this.pe.add(exit);
		this.pe.setOpaque(true);
		this.pe.setBackground(Color.PINK);
		
		panel.add(ps);
		panel.add(pi);
		panel.add(pe);
		
		this.titolo.setBackground(Color.pink);
		this.titolo.setForeground(Color.black);
		//this.titolo.setOpaque(true);
		this.titolo.setText("WELCOME!");
		this.titolo.setSize(new Dimension(((int)size.getWidth()/3), ((int)size.getHeight()/8)));
		//this.titolo.setVisible(true);;
		
		pan.add(panel, BorderLayout.CENTER);
		pan.add(titolo, BorderLayout.NORTH);
		
		this.getContentPane().add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
