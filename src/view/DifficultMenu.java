package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

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
	private static final int DIMENSION_FONT_18 = 18;
	private static final String TYPE_FONT = "Arial";
	
	
	private final JButton rb1 = new JButton("EASY");
	private final JButton rb2 = new JButton("MEDIUM");
	private final JButton rb3 = new JButton("DIFFICULT");
	
	/**
	 * Costruttore del menù di scelta della difficoltà di gioco.
	 */
	public DifficultMenu() {
		//title
		this.setTitle("Choose level");
		
		//dimension
		Dimension size;
		size = Toolkit.getDefaultToolkit().getScreenSize();
		final int dimension = (int) size.getWidth() / WIDTH_DIMENSION;
		this.setSize(dimension, dimension / HEIGHT_DIMENSION);
		this.setResizable(false);
		
		//principal panel
		final JPanel panel = new MyPanel(ViewUtility.POIS);
		this.add(panel);
		panel.setLayout(new FlowLayout());
		
		//Button look
		this.lookButton(rb1, Color.white, true);
		this.lookButton(rb2, Color.white, true);
		this.lookButton(rb3, Color.white, true);
		
		this.rb1.setFont(new Font(TYPE_FONT, Font.BOLD, DIMENSION_FONT_18));
		this.rb2.setFont(new Font(TYPE_FONT, Font.BOLD, DIMENSION_FONT_18));
		this.rb3.setFont(new Font(TYPE_FONT, Font.BOLD, DIMENSION_FONT_18));
		
		panel.add(rb1);
		panel.add(rb2);
		panel.add(rb3);
		
		//actions
		this.rb1.addActionListener(new ActionListener() {
			
			public void actionPerformed(final ActionEvent e) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					
				}
				final PlayGameMenu v = new PlayGameMenu();
				v.updateStep(Utility.NUM_STEP);
				v.updateTarget(Utility.EASY_TARGET);
				v.setDiff("EASY ");
				closePage();
			}
		});
		this.rb2.addActionListener(new ActionListener() {
			
			public void actionPerformed(final ActionEvent e) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					
				}
				final PlayGameMenu v = new PlayGameMenu();
				v.updateStep(Utility.NUM_STEP);
				v.updateTarget(Utility.MEDIUM_TARGET);
				v.setDiff("NORMAL ");
				closePage();
			}
		});
		this.rb3.addActionListener(new ActionListener() {
			
			public void actionPerformed(final ActionEvent e) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					
				}
				final PlayGameMenu v = new PlayGameMenu();
				v.updateStep(Utility.NUM_STEP);
				v.updateTarget(Utility.DIFFICULT_TARGET);
				v.setDiff("DIFFICULT ");
				closePage();
			}
		});
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
