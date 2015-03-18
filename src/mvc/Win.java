package mvc;

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
	
	public Win(){
		//title
		this.setTheTitle("    WIN !!    ");
		
		//dimension
		Dimension size;
		size = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize((int)size.getWidth()/2, (int)size.getHeight()-((int)size.getHeight()/10));
		this.setResizable(false);
		
		// button play
		JPanel app = new JPanel(new BorderLayout());
		this.lookButton(play);
		this.play.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				closePage();
				new DifficultMenu();
			}
		});
		this.play.setFont(new Font("Arial",Font.BOLD,20));
		app.add(play, BorderLayout.CENTER);
		
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
	
	//da http://antoniotancredi.altervista.org/2010/05/04/java-utilizzare-unicona-in-una-jlabel/
	private JLabel createLabel(String text, ImageIcon icon,int hPos, int vPos)
	{
	    JLabel label = new JLabel(text, icon, JLabel.CENTER);
	    label.setFont(new Font("Arial",Font.BOLD,50));
	    label.setHorizontalTextPosition(hPos);
	    label.setVerticalTextPosition(vPos);
	    return label;
	}
	
	private void lookButton(JButton b){
		b.setBackground(Color.cyan);
		b.setBorderPainted(false);
	}
	
	public static void main(String[] args) {
		new Win();
	}
}
