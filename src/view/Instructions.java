package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * Classe che mostra all'utente le istruzioni di gioco. Il testo delle istruzioni viene letto da un file 
 * e riportato in una JTextArea.
 * 
 * @author Beatrice Ricci
 *
 */
public class Instructions extends AbstractMenu implements Serializable {

	private static final long serialVersionUID = -6914523737504217168L;
	private static final int DIMENSION_FONT_24 = 24;
	private static final int DIMENSION_FONT_14 = 14;
	private static final String TYPE_FONT = "Arial";
	
	private final JButton ok = new JButton(" OK, I'M READY !! ");
	private final JTextArea area = new JTextArea("");
	/**
	 * Costruttore della classe.
	 */
	public Instructions() {
		//title
		this.setTitle(" instructions ");
		//dimensionDimension size;
		final Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		final int taglia = (int) size.getWidth() / 2;
		this.setSize(taglia, taglia);
		this.setResizable(false);
		
		final JPanel panel = new JPanel(new BorderLayout());
		this.lookPanel(panel, Color.white);
		
		panel.add(ok, BorderLayout.SOUTH);
		this.ok.setFont(new Font(TYPE_FONT, Font.BOLD, DIMENSION_FONT_24));
		this.lookButton(ok, Color.pink, true);
		
		this.ok.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				closePage();
			}
		});
		
		panel.add(area, BorderLayout.CENTER);
		this.area.setFont(new Font(TYPE_FONT, Font.BOLD, DIMENSION_FONT_14));
		this.area.setEditable(false);
		
		try {
			this.readTheInstruction();
		} catch (ClassNotFoundException e) { 
			/**
			 * in caso di malfunzionamento creo un JOptionPane che comunica all'utente l'errore
			 */
			JOptionPane.showMessageDialog(this,
				    "Errore",
				    "E R R O R",
				    JOptionPane.ERROR_MESSAGE);
			closeGame();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(this,
				    "Errore file non trovato",
				    "E R R O R",
				    JOptionPane.ERROR_MESSAGE);
			closeGame();
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
	private void readTheInstruction() throws IOException, ClassNotFoundException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ViewUtility.FILE_PATH)));
		
		do {
			this.area.append(br.readLine().toString());
			this.area.append("\n");
		} while (br.readLine() != null);
		
		br.close();
	}
}
