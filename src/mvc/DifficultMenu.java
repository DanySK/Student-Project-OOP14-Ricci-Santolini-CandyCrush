package mvc;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DifficultMenu extends AbstractMenu {

	private static final long serialVersionUID = 2385788298938761843L;
	
	private JLabel question = new JLabel("What's level?");
	
	private JRadioButton rb1 = new JRadioButton("EASY");
	private JRadioButton rb2 = new JRadioButton("MEDIUM");
	private JRadioButton rb3 = new JRadioButton("DIFFICULT");
	
	public DifficultMenu(){
		//title
		this.setTheTitle("Choose level");
		
		//dimension
		Dimension size;
		size = Toolkit.getDefaultToolkit().getScreenSize();
		int taglia = (int)size.getWidth()/3;
		this.setSize(taglia, taglia/3);
		this.setResizable(false);
		//principal panel
		this.getContentPane().setLayout(new BorderLayout());
		
		
		//Button look
		this.lookButton(rb1);
		this.lookButton(rb2);
		this.lookButton(rb3);
		
		//Panel look
		JPanel pq = new JPanel();
		this.lookPanel(pq, Color.yellow);
		pq.add(question);
		
		JPanel p1 = new JPanel();
		this.lookPanel(p1, Color.yellow);
		p1.add(rb1);
		
		JPanel p2 = new JPanel();
		this.lookPanel(p2, Color.yellow);
		p2.add(rb2);
		
		JPanel p3 = new JPanel();
		this.lookPanel(p3, Color.yellow);
		p3.add(rb3);
		
		JPanel pp = new JPanel(new BorderLayout());
		pp.add(p2, BorderLayout.NORTH);
		pp.add(p3, BorderLayout.SOUTH);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(p1, BorderLayout.NORTH);
		p.add(pp, BorderLayout.CENTER);
		//actions
		this.rb1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				View v = new View();
				v.setStep(30);
				v.setObiettivo(500);
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
				View v = new View();
				v.setStep(30);
				v.setObiettivo(500);
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
				View v = new View();
				v.setStep(30);
				v.setObiettivo(500);
				closePage();
			}
		});
		
		//label's options
		this.question.setFont(new Font("Arial",Font.BOLD,16));

		((JComponent) this.getContentPane()).setOpaque(true);
		this.getContentPane().setBackground(Color.GREEN);
		
		this.getContentPane().add(pq, BorderLayout.NORTH);
		this.getContentPane().add(p, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void lookButton(JRadioButton b){
		b.setBackground(Color.yellow);
		b.setBorderPainted(false);
	}
	
	//ActionListener
	//modificare con il numero di mosse!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
	/*private class Click implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			new View();
			closePage();
		}
		
	}*/
}
