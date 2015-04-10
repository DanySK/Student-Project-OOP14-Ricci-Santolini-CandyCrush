package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class Win extends AbstractMenu{

	private static final long serialVersionUID = 5227740951252505323L;
	
	private final static String sep = File.separator;
	
	private ImageIcon iconWin = new ImageIcon("res"+sep+"win.jpg");
	private JLabel label = createLabel("  YOU WIN !!!  ", iconWin, JLabel.CENTER, JLabel.BOTTOM);
	private JButton play = new JButton (" Play again ! ");
	private JButton exit = new JButton (" Exit ");
	
	public Win(){
		//title
		this.setTheTitle("    WIN !!    ");
		
		//dimension
		Dimension size;
		size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)size.getWidth()/2, (int)size.getHeight()-((int)size.getHeight()/10));
		this.setResizable(false);
		
		// button play
		JPanel app = new JPanel(new FlowLayout());
		this.lookPanel(app, Color.cyan);
		
		this.lookButton(play, Color.cyan, false);
		this.play.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				closePage();
				new DifficultMenu();
			}
		});
		this.play.setFont(new Font("Arial",Font.BOLD,20));
		
		this.lookButton(exit, Color.cyan, false);
		this.exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Question();
			}
		});
		this.exit.setFont(new Font("Arial",Font.BOLD,20));
		
		app.add(play);
		app.add(exit);
		// principal panel
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(label, BorderLayout.CENTER);
		panel.add(app, BorderLayout.SOUTH);
		
		this.lookPanel(panel, Color.CYAN);
		this.getContentPane().add(panel);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Win();
	}
}
