package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Controller implements ActionListener{

	public static final int dim1 = 5;
	public static final int dim2 = 5;
	
	private Model modello;
	private IView view;
		
	public Controller(View v, Model m){
		this.modello = m;
		this.view = v;
	}
	
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
		}else{
			
			if(modello.checkExchange(lastX, lastY, b.getPosX(), b.getPosY())){
				modello.doExchange(lastX, lastY, b.getPosX(), b.getPosY());
				view.updateView(view.getPanel(), modello.getMat());
				modello.checkTris(modello.getMat());
				
				for(int i = 0; i< dim1 ; i++){
					for(int j = 0; j< dim2; j++){
						System.out.println(modello.getMat()[i][j].getColorButt());
					}
					System.out.println("\n");
				}
			}
			lastX = -1;
			lastY = -1;
		}
		
	}
	public static void main(String args[]){
		new Start();
		//Controller c = new Controller(new View(), new Model());
		//c.view.draw(c.view.getPanel(), c.modello.getMat());
		//c.view.updateView(c.view.getPanel() ,c.view.getMat());
	}

	
}
