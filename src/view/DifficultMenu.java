package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DifficultMenu extends AbstractMenu {

	private static final long serialVersionUID = 2385788298938761843L;
	
	private JLabel question = new JLabel("What's level?");
	
	private final JButton rb1 = new JButton("EASY");
	private final JButton rb2 = new JButton("MEDIUM");
	private final JButton rb3 = new JButton("DIFFICULT");
	
	public DifficultMenu(){
		//title
		this.setTheTitle("Choose level");
		
		//dimension
		Dimension size;
		size = Toolkit.getDefaultToolkit().getScreenSize();
		int taglia = (int)size.getWidth()/3;
		this.setSize(taglia, taglia/5);
		this.setResizable(false);
		
		//principal panel
		JPanel panel = new MyPanel();
		this.add(panel);
		panel.setLayout(new FlowLayout());
		
		//Button look
		this.lookButton(rb1, Color.white, true);
		this.lookButton(rb2, Color.white, true);
		this.lookButton(rb3, Color.white, true);
		
		panel.add(question);
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
				v.setStep(Utility.num_mosse);
				v.setObiettivo(Utility.easy_ob);
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
				v.setStep(Utility.num_mosse);
				v.setObiettivo(Utility.medium_ob);
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
				v.setStep(Utility.num_mosse);
				v.setObiettivo(Utility.difficult_ob);
				v.setDiff("DIFFICULT ");
				closePage();
			}
		});
		
		//label's options
		this.question.setFont(new Font("Arial",Font.BOLD,24));

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
