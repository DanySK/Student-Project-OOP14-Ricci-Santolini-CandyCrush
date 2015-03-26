package view;

import java.util.Random;

public enum ColorButt {
		LIGHT_BLU, YELLOW, GREEN, VIOLET, ORANGE, RED;
		
		public static ColorButt randomCol(){
			Random rnd = new Random ();
			return values()[rnd.nextInt (6)];
		}
		
}
