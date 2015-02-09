package scambio.copy;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwapGUI extends JFrame{
	
	
/*	private Bu[] buttons = new Bu[3];
	private Listener guardone = new Listener();
	
	public SwapGUI(){
		JPanel panel = new JPanel(new FlowLayout());
		this.getContentPane().add(panel);
		
		for(int i = 0; i < 3; i++){
			buttons[i] = new Bu("" + (i));
			buttons[i].setPos(i);
			buttons[i].setActionCommand(buttons[i].getText());
			buttons[i].addActionListener(guardone);
			panel.add(buttons[i]);
		}
		
		
		this.setSize(400,100);
		this.setVisible(true);
	}


	private class Listener implements ActionListener{

		int last = -1;
		int app = 0;
		Bu temp = new Bu("");
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(last == -1){
				last = Integer.parseInt(e.getActionCommand());
				temp = buttons[last];
				
				int a = buttons[last].getPos();
				//System.out.println(""+a);
				
				for (Bu b :buttons){
					b.setEnabled(false);
					if ((b.getPos() == (a-1)) || (b.getPos() == (a+1))){
						b.setEnabled(true);
					}
				}
			}
			else{
				app = Integer.parseInt(e.getActionCommand());
				
				buttons[last] = buttons[app];
				buttons[app] = temp;
				buttons[app].setActionCommand("" + app);
				buttons[app].setText("" + app);
				buttons[last].setActionCommand("" + last);
				buttons[last].setText("" + last);
			
				for (int i = 0; i < 3; i++){
					buttons[i].setEnabled(true);
				}
				last = -1;
			}
			
			
		}
		
	}
	public static void main(String args[]){
		new SwapGUI();
	}*/

}