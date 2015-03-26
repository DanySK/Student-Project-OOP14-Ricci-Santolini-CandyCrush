package view;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Instructions extends AbstractMenu implements Serializable{

	private static final long serialVersionUID = -6914523737504217168L;
	
	private final String path = "res"+Utility.sep+"doc"+Utility.sep+"instr.txt";
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
		this.ok.setBackground(Color.pink);
		this.ok.setBorderPainted(true);
		
		this.ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closePage();
			}
		});
		
		panel.add(area, BorderLayout.CENTER);
		this.area.setFont(new Font("Arial",Font.BOLD,14));
		this.area.setEditable(false);//per non modificare il testo
		
		this.getContentPane().add(panel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		try {
			this.readTheInstruction();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readTheInstruction() throws IOException, ClassNotFoundException{
		BufferedReader br = new BufferedReader ( new InputStreamReader ( new FileInputStream (path) ) );
		boolean flag = true;
		String app = "\n\n";
		while(flag == true){
			String b = br.readLine();
			if (b == null){
				flag = false;
			}
			else{
				app = app + b +"\n";
			}
		}
		this.area.setText(app);
		br.close();
	}
}
