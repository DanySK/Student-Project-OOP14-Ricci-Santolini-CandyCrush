package mvc;

import javax.swing.JPanel;

public interface IView {

	//public void draw(JPanel p, Oggetto m[][]);
	
	public void updateView(JPanel p, Oggetto m[][]);
	
	public JPanel getPanel();
}
