package view;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public final class Utility {
	private final static String sep = File.separator;
	
	public static final int dim1 = 9;
	public static final int dim2 = 9;
	
	public static final int hbutt = 70;
	public static final int lbutt = 60;
	
	public final static int num_mosse = 30;
	public final static int easy_ob = 5000;
	public final static int medium_ob = 8000;
	public final static int difficult_ob = 12000;
	
	public final static ImageIcon closeIm = new ImageIcon("res"+sep+"close.jpg");
	
	//sfondo
	public final static Image sfondo = new ImageIcon("res"+sep+"caramelle.jpg").getImage();
	
	//icone bottoni menu
	public final static ImageIcon icStart = new ImageIcon("res"+sep+"start.jpg");
	public final static ImageIcon icInstr = new ImageIcon("res"+sep+"instr.jpg");
	public final static ImageIcon icExit = new ImageIcon("res"+sep+"exit.jpg");
	
	//percorso file istruzioni
	public final static String filePath = "res"+sep+"doc"+sep+"instr.txt";
	
	//icone chicche
	//public final static ImageIcon black = new ImageIcon("res"+sep+"candy"+sep+"black.jpg");
	
	public final static ImageIcon blueIC = new ImageIcon("res"+sep+"candy"+sep+"piccolaAzzurra.jpg");
	public final static ImageIcon yellowIC = new ImageIcon("res"+sep+"candy"+sep+"piccolaGialla.jpg");
	public final static ImageIcon greenIC = new ImageIcon("res"+sep+"candy"+sep+"piccolaVerde.jpg");
	public final static ImageIcon violetIC = new ImageIcon("res"+sep+"candy"+sep+"piccolaViola.jpg");
	public final static ImageIcon redIC = new ImageIcon("res"+sep+"candy"+sep+"piccolaRossa.jpg");
	public final static ImageIcon orangeIC = new ImageIcon("res"+sep+"candy"+sep+"piccolaArancio.jpg");
	
	public final static ImageIcon blueSOIC = new ImageIcon("res"+sep+"candy"+sep+"sOrAzzurra.jpg");
	public final static ImageIcon yellowSOIC = new ImageIcon("res"+sep+"candy"+sep+"sOrGialla.jpg");
	public final static ImageIcon greenSOIC = new ImageIcon("res"+sep+"candy"+sep+"sOrVerde.jpg");
	public final static ImageIcon violetSOIC = new ImageIcon("res"+sep+"candy"+sep+"sOrViola.jpg");
	public final static ImageIcon redSOIC = new ImageIcon("res"+sep+"candy"+sep+"sOrRossa.jpg");
	public final static ImageIcon orangeSOIC = new ImageIcon("res"+sep+"candy"+sep+"sOrArancio.jpg");
	
	public final static ImageIcon blueSVIC = new ImageIcon("res"+sep+"candy"+sep+"sVerticalAzzurra.jpg");
	public final static ImageIcon yellowSVIC = new ImageIcon("res"+sep+"candy"+sep+"sVerticalGialla.jpg");
	public final static ImageIcon greenSVIC = new ImageIcon("res"+sep+"candy"+sep+"sVerticalVerde.jpg");
	public final static ImageIcon violetSVIC = new ImageIcon("res"+sep+"candy"+sep+"sVerticalViola.jpg");
	public final static ImageIcon redSVIC = new ImageIcon("res"+sep+"candy"+sep+"sVerticalRossa.jpg");
	public final static ImageIcon orangeSVIC = new ImageIcon("res"+sep+"candy"+sep+"sVerticalArancio.jpg");
	
	public final static ImageIcon blueWIC = new ImageIcon("res"+sep+"candy"+sep+"wAzzurra.jpg");
	public final static ImageIcon yellowWIC = new ImageIcon("res"+sep+"candy"+sep+"wGialla.jpg");
	public final static ImageIcon greenWIC = new ImageIcon("res"+sep+"candy"+sep+"wVerde.jpg");
	public final static ImageIcon violetWIC = new ImageIcon("res"+sep+"candy"+sep+"wViola.jpg");
	public final static ImageIcon redWIC = new ImageIcon("res"+sep+"candy"+sep+"wRossa.jpg");
	public final static ImageIcon orangeWIC = new ImageIcon("res"+sep+"candy"+sep+"wArancio.jpg");

	public final static ImageIcon fiveIC = new ImageIcon("res"+sep+"candy"+sep+"five.jpg");
	
	//tipi
	public final static int normal = 1;
	public final static int stripedV = 2;
	public final static int stripedO = 3;
	public final static int wrapped = 4;
	public final static int five = 5;
	
	//colori
	public final static int blue = 0;
	public final static int yellow = 1;
	public final static int green = 2;
	public final static int violet = 3;
	public final static int orange = 4;
	public final static int red = 5;
	
	public final static int special = 6;
	
	
}
