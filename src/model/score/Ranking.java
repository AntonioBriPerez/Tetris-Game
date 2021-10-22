package model.score;


import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

import model.exceptions.score.RankingException;



// TODO: Auto-generated Javadoc
/**
 * The Class Ranking.
 *
 * @param <ScoreType> the generic type
 */
public class Ranking<ScoreType extends Score>{
	
	/** The game plays. */
	private SortedSet<ScoreType> gamePlays;
	//gamePlays = new TreeSet<>();
	
	/**
	 * Instantiates a new ranking.
	 */
	public Ranking() {
		gamePlays = new TreeSet<>();
	}
	
	/**
	 * Adds the score.
	 *
	 * @param tipoPuntuacion the tipo puntuacion
	 */
	public void addScore(ScoreType tipoPuntuacion) {
		Objects.requireNonNull(tipoPuntuacion);
		gamePlays.add(tipoPuntuacion);	
	}
	
	/**
	 * Gets the winner.
	 *
	 * @return the winner
	 * @throws RankingException the ranking exception
	 */
	public ScoreType getWinner() throws RankingException{
		if(gamePlays.isEmpty()) {
			throw new RankingException();
		}
		return  gamePlays.first();
	}
	
	/**
	 * Gets the sorted ranking.
	 *
	 * @return the sorted ranking
	 */
	public SortedSet<ScoreType> getSortedRanking(){
		return gamePlays;
		
	}
}
