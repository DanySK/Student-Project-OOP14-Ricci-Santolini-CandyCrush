package view;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
/**
 * Classe che mostra all'utente le istruzioni di gioco. Il testo delle istruzioni viene letto da un file 
 * e riportato in una JTextArea.
 * 
 * @author Beatrice Ricci
 *
 */
public class Instructions extends AbstractMenu implements Serializable{

	private static final long serialVersionUID = -6914523737504217168L;
	
	private final JButton ok = new JButton (" OK, I'M READY !! ");
	private JTextArea area = new JTextArea();
	
	public Instructions(){
		//title
		this.setTitle(" instructions ");
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
		this.area.setEditable(false);
		
		try {
			this.readTheInstruction();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.getContentPane().add(panel);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
	}
	/**
	 * Metodo per leggere tutte le righe di un file e poi inserirlo in una JTextArea
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readTheInstruction() throws IOException, ClassNotFoundException{
		BufferedReader br = new BufferedReader ( new InputStreamReader ( new FileInputStream (ViewUtility.filePath) ) );
		
		String app  = "\n\n";
		do{
			app = app + br.readLine() + "\n";
		}while(br.readLine()!= null);
		
		this.area.setText(app);
		br.close();
	}
}
