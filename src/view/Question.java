package view;

import javax.swing.*;

public class Question extends AbstractMenu {

	private static final long serialVersionUID = 8197909384969100034L;
	
	private Object[] options = {"Yes", "No"};
	
	public Question(){
		
		int n = JOptionPane.showOptionDialog(this,
		    "Are you sure ?!",
		    "     !!!!     ",
		    JOptionPane.YES_NO_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    null,
		    options,
		    options[1]);
		
		if (n == JOptionPane.YES_OPTION){
			this.closeGame();
		}
		else{
			this.closePage();
		}
		
	}
}
