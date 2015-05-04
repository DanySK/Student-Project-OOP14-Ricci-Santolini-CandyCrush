package view;

import java.awt.*;
import javax.swing.*;
/**
 * 
 * 
 * @author Beatrice Ricci
 */
public class Win extends AbstractFinal{

	private static final long serialVersionUID = 5227740951252505323L;
	
	private ImageIcon iconWin = new ImageIcon("res"+ ViewUtility.SEP +"win.jpg");
	private JLabel label = createLabel("  YOU WIN !!!  ", iconWin, JLabel.CENTER, JLabel.BOTTOM);
	public Win(){
		//title
		this.setTitle("    WIN !!    ");
		
		//dimension
		this.setDimension();
		
		// principal panel
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(label, BorderLayout.CENTER);
		panel.add(setJButtonsInPanel(Color.cyan), BorderLayout.SOUTH);
		
		this.lookPanel(panel, Color.cyan);
		this.getContentPane().add(panel);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

