package mvc;

/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class Ascoltatore implements ActionListener{

	int lastX = -1;
	int lastY = -1;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Butt b = (Butt) e.getSource();
		Butt app = (Butt) e.getSource();
		
		
		if(lastX == -1 && lastY == -1){
			lastX = b.getPosX();
			lastY = b.getPosY();
			
			app = b;
			//System.out.println("if " + lastX + " " + lastY);
		}else{
			
			if(Model.checkExchange(lastX, lastY, b.getPosX(), b.getPosY())){
				Model.doExchange(lastX, lastY, b.getPosX(), b.getPosY());
			
			}
			lastX = -1;
			lastY = -1;
		}
		
	}
	
}*/