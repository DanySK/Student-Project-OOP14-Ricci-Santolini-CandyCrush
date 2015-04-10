package view;

import javax.swing.JPanel;

public interface IPlayMenu {

	public void updateView();
	
	public JPanel getPanel();
	
	public void setStep(int n);
	
	public void setObiettivo(int n);
	
}
