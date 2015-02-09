/*package scambio.copy;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*public class SwapGUI2 extends JFrame{
	
	private Bu[][] buttons = new Bu[5][5];
	private Listener guardone = new Listener();
	
	public SwapGUI2(){
		JPanel panel = new JPanel(new FlowLayout());
		this.getContentPane().add(panel);
		
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++){
				buttons[i][j] = new Bu("" + (i) + "-" + (j));
				buttons[i][j].setPosX(i);
				buttons[i][j].setPosY(j);
				buttons[i][j].setActionCommand(buttons[i][j].getText());
				buttons[i][j].addActionListener(guardone);
				panel.add(buttons[i][j]);
			}
		}
		
		
		this.setSize(400,100);
		this.setVisible(true);
	}


	private class Listener implements ActionListener{

		int lastX = -1;
		int appX = 0;
		
		int lastY = -1;
		int appY = 0;
		
		Bu temp = new Bu("");
		
		@Override
		public void actionPerformed(ActionEvent e) {
	
			if(lastX == -1){
				String s = e.getActionCommand();
				System.out.println(s);
				
				lastX = Integer.parseInt(s.substring(0, 1));
				lastY = Integer.parseInt(s.substring(2));
				
				temp = buttons[lastX][lastY];
				buttons[lastX][lastY].setEnabled(false);
			}
			else{
				String s = e.getActionCommand();

				appX = Integer.parseInt(s.substring(0, 1));
				appY = Integer.parseInt(s.substring(2));
				
				int a = buttons[lastX][lastY].getPosX();
				int b = buttons[lastX][lastY].getPosY();
				
				if ((buttons[appX][appY].getPosX() == (a-1) && buttons[appX][appY].getPosY() == (b)) || 
					(buttons[appX][appY].getPosX() == (a) && buttons[appX][appY].getPosY() == (b-1)) ||
					(buttons[appX][appY].getPosX() == (a) && buttons[appX][appY].getPosY() == (b+1)) ||
					(buttons[appX][appY].getPosX() == (a+1) && buttons[appX][appY].getPosY() == (b))){
					
					buttons[lastX][lastY] = buttons[appX][appY];
					
					buttons[appX][appY] = temp;
					
					buttons[appX][appY].setActionCommand("" + appX + "-" + appY);
					buttons[appX][appY].setText("" + appX + "-" + appY);
					buttons[lastX][lastY].setActionCommand("" + lastX + "-" + lastY);
					buttons[lastX][lastY].setText("" + lastX + "-" + lastY);
				}
				for (int i = 0; i < 5; i++){
					for (int j = 0; j < 5; j++){
						buttons[i][j].setEnabled(true);
					}		
				}
				lastX = -1;
				lastY = -1;
			}
			
			
		}
		
	}
	public static void main(String args[]){
		new SwapGUI2();
	}

}
*/