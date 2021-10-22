package model.score;

import model.io.GamePlay;

// TODO: Auto-generated Javadoc
/**
 * The Class RowsClearedScore.
 */
public class RowsClearedScore extends Score {

	/**
	 * Instantiates a new rows cleared score.
	 *
	 * @param cadena the cadena
	 * @param partida the partida
	 */
	public RowsClearedScore(String cadena, GamePlay partida) {
		
		super(cadena, partida);
		
	}
	
	/**
	 * @return int scoring
	 */
	public int getScoring() {
		
		return gamePlay.getRowsCleared();
	}

}
