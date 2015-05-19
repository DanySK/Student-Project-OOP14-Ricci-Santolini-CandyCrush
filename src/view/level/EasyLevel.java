package view.level;

import controller.Utility;
import view.play.IGamePlay;

/**
 * Classe che va a impostare la schermata di gioco in base alla caratteristiche del livello più semplice.
 * @author Beatrice Ricci
 *
 */
public class EasyLevel extends AbstractLevel {
	
	@Override
	public void setLevel(final IGamePlay play) {
		setFeatures(play);
	}
	
	/**
	 * Metodo per settare le caratteristiche del livello di difficoltà.
	 * @param play schermata di gioco da impostare
	 */
	private void setFeatures(final IGamePlay play) {
		play.updateStep(Utility.NUM_STEP);
		play.updateTarget(Utility.EASY_TARGET);
		play.setDiff("EASY");
	}

}
