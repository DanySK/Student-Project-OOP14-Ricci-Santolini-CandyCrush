package view;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

public class GameOver extends AbstractMenu {

	private static final long serialVersionUID = -7876870538465198338L;

	private final static String sep = File.separator;
	
	private ImageIcon iconLose = new ImageIcon("res"+sep+"loser.jpg");
	private JLabel label = createLabel("  GAME OVER :(  ", iconLose, JLabel.CENTER, JLabel.BOTTOM);
	private JButton play = new JButton (" Play again ! ");
	private JButton exit = new JButton (" EXIT ");
	
	public GameOver(){
		//title
		this.setTheTitle("    GAME LOST :(    ");
		
		//dimension
		Dimension size;
		size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)size.getWidth()/2, (int)size.getHeight()-((int)size.getHeight()/10));
		this.setResizable(false);
		
		// button play
		JPanel app = new JPanel(new FlowLayout());
		this.lookButton(play);
		this.lookPanel(app, Color.yellow);
		this.play.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				closePage();
				new DifficultMenu();
			}
		});
		this.play.setFont(new Font("Arial",Font.BOLD,20));
		
		this.lookButton(exit);
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
		
		this.lookPanel(panel, Color.yellow);
		this.getContentPane().add(panel);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void lookButton(JButton b){
		b.setBackground(Color.yellow);
		b.setBorderPainted(false);
	}
	
	public static void main(String[] args) {
		new GameOver();
	}
}
