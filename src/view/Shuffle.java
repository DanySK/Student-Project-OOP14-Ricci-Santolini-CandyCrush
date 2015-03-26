package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Shuffle extends AbstractMenu{

	private static final long serialVersionUID = -1183169779251815974L;
	
	private final static String sep = File.separator;
	private ImageIcon icon = new ImageIcon("res"+sep+"shuffle.jpg");
	private JLabel label = createLabel(" ", icon, JLabel.CENTER, JLabel.TOP);
	
	public Shuffle(){
		//title
		this.setTheTitle("Shuffle!!");
		
		//dimension
		Dimension size;
		size = Toolkit.getDefaultToolkit().getScreenSize();
		int taglia = (int)size.getWidth()/3;
		this.setSize(taglia, taglia/2);
		this.setResizable(false);
		
		//principal panel
		JPanel panel = new JPanel(new BorderLayout());
		this.lookPanel(panel, Color.white);
		panel.add(label, BorderLayout.CENTER);
		this.getContentPane().add(panel);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		Shuffle s = new Shuffle();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//s.setVisible(false);
		s.closePage();
	}

}
