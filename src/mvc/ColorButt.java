package mvc;


import java.util.Random;


public enum ColorButt {
		LIGHT_BLU, YELLOW, GREEN, VIOLET;
		public static ColorButt randomCol(){
			Random rnd = new Random ();
			return values()[rnd.nextInt (4)];
		}
		
}
