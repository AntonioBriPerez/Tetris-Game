package model.score;

import model.io.GamePlay;

// TODO: Auto-generated Javadoc
/**
 * The Class TimeScore.
 */
public class TimeScore extends Score {

	/**
	 * Instantiates a new time score.
	 *
	 * @param cadena the cadena
	 * @param partida the partida
	 */
	public TimeScore(String cadena, GamePlay partida) {
		super(cadena, partida);	
	}
	
	/**
	 * @return int
	 */
	public int getScoring() {
		return (0-gamePlay.getDuration());
	}
	

	

}
