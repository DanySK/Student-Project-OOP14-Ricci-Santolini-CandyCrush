package view;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Instructions extends AbstractMenu implements Serializable{

	private static final long serialVersionUID = -6914523737504217168L;
	
	private final JButton ok = new JButton (" OK, I'M READY !! ");
	private JTextArea area = new JTextArea();
	
	public Instructions(){
		//title
		this.setTheTitle(" instructions ");
		//dimensionDimension size;
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		int taglia = (int)size.getWidth()/2;
		this.setSize(taglia, taglia);
		this.setResizable(false);
		
		
		JPanel panel = new JPanel(new BorderLayout());
		this.lookPanel(panel, Color.white);
		
		panel.add(ok, BorderLayout.SOUTH);
		this.ok.setFont(new Font("Arial",Font.BOLD,24));
		this.lookButton(ok, Color.pink, true);
		
		this.ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closePage();
			}
		});
		
		panel.add(area, BorderLayout.CENTER);
		this.area.setFont(new Font("Arial",Font.BOLD,14));
		this.area.setEditable(false);//per non modificare il testo
		
		try {
			this.readTheInstruction();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		this.getContentPane().add(panel);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
	private void readTheInstruction() throws IOException, ClassNotFoundException{
		BufferedReader br = new BufferedReader ( new InputStreamReader ( new FileInputStream (Utility.filePath) ) );
		
		String app  = "\n\n";
		do{
			app = app + br.readLine() + "\n";
		}while(br.readLine()!= null);
		
		this.area.setText(app);
		br.close();
	}
}
