package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.Utility;
/**
 * Classe che disegna il menù in cui l'utente può scegliere il livello di difficoltà.
 * Una volta scelto verrà creata una nuova schermata di gioco con le caratteristiche del livello scelto.
 * 
 * @author Beatrice Ricci
 *
 */
public class DifficultMenu extends AbstractMenu {

	private static final long serialVersionUID = 2385788298938761843L;
	
	private static final int WIDTH_DIMENSION = 3;
	private static final int HEIGHT_DIMENSION = 5;
	
	private final JButton rb1 = new JButton("EASY");
	private final JButton rb2 = new JButton("MEDIUM");
	private final JButton rb3 = new JButton("DIFFICULT");
	
	public DifficultMenu() {
		//title
		this.setTitle("Choose level");
		
		//dimension
		Dimension size;
		size = Toolkit.getDefaultToolkit().getScreenSize();
		int dimension = (int)size.getWidth()/WIDTH_DIMENSION;
		this.setSize(dimension, dimension/HEIGHT_DIMENSION);
		this.setResizable(false);
		
		//principal panel
		JPanel panel = new MyPanel(ViewUtility.pois);
		this.add(panel);
		panel.setLayout(new FlowLayout());
		
		//Button look
		this.lookButton(rb1, Color.white, true);
		this.lookButton(rb2, Color.white, true);
		this.lookButton(rb3, Color.white, true);
		
		this.rb1.setFont(new Font("Arial",Font.BOLD, 18));
		this.rb2.setFont(new Font("Arial",Font.BOLD, 18));
		this.rb3.setFont(new Font("Arial",Font.BOLD, 18));		
		
		panel.add(rb1);
		panel.add(rb2);
		panel.add(rb3);
		
		//actions
		this.rb1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				PlayGameMenu v = new PlayGameMenu();
				v.updateStep(Utility.num_mosse);
				v.updateTarget(Utility.easy_ob);
				v.setDiff("EASY ");
				closePage();
			}
		});
		this.rb2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				PlayGameMenu v = new PlayGameMenu();
				v.updateStep(Utility.num_mosse);
				v.updateTarget(Utility.medium_ob);
				v.setDiff("NORMAL ");
				closePage();
			}
		});
		this.rb3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				PlayGameMenu v = new PlayGameMenu();
				v.updateStep(Utility.num_mosse);
				v.updateTarget(Utility.difficult_ob);
				v.setDiff("DIFFICULT ");
				closePage();
			}
		});
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
