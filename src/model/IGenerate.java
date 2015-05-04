package model;

public interface IGenerate {

	/**
	 * Metodo che genera interi da zero a cinque, utilizzato per attribuire
	 * colori casuali alle caramelle quando vengono generate
	 */
	default public int generate(){
		return (int) (Math.random() * 10000)%6;
	}
}
