package scambio;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwapGUI extends JFrame{
	
	private JButton[] buttons = new JButton[5];
	private Listener guardone = new Listener();
	
	public SwapGUI(){
		JPanel panel = new JPanel(new FlowLayout());
		this.getContentPane().add(panel);
		for(int i = 0; i < 5; i++){
			buttons[i] = new JButton("" + (i));
			buttons[i].setActionCommand(buttons[i].getText());
			buttons[i].addActionListener(guardone);
			panel.add(buttons[i]);
		}
		this.setSize(400,100);
		this.setVisible(true);
	}
	
	
	private class Listener implements ActionListener{
	
		int last = -1;
		int second_last = -1;
		JButton first = new JButton();
		JButton second = new JButton();
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(last == -1){
				last = Integer.parseInt(e.getActionCommand());
				first = (JButton) e.getSource();
				first.setEnabled(false);
			}
			else{
				second_last = Integer.parseInt(e.getActionCommand());
				second = (JButton) e.getSource();
				second.setEnabled(false);
				
				if(last - second_last == 1 || last - second_last == -1){				
					System.out.println("SI");
					
					
					
					
				}
				else{
					System.out.println("NO");
					
					
					
					
				}
				first.setEnabled(true);
				second.setEnabled(true);
				last = -1;
				second_last = -1;
			}
		}
		
	
	}
	
	
	public static void main(String args[]){
		new SwapGUI();
	}
}
	
	
