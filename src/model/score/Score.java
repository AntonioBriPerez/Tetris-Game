package model.score;

import model.io.GamePlay;

// TODO: Auto-generated Javadoc
/**
 * The Class Score.
 */
public abstract class Score implements Comparable<Score> {
	
	/** The game play. */
	protected GamePlay gamePlay;
	
	/** The name. */
	private String name;
	
	/** The score. */
	private int score;
	
	/**
	 * Instantiates a new score.
	 *
	 * @param cadena the cadena
	 * @param partida the partida
	 */
	public Score(String cadena, GamePlay partida) {
		name=cadena;
		gamePlay=partida;
		score=getScoring();
	}
	
	/**
	 * @return string
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name+":"+score);
		return sb.toString();
		
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Compare to.
	 *
	 * @param puntuacion the puntuacion
	 * @return int compare
	 */
	public int compareTo(Score puntuacion) {
		if(this.score>puntuacion.score){
			return -1;
		}
		else if(this.score>puntuacion.score) {
			return 1;
		}
		return name.compareTo(puntuacion.name);
	}
	
	/**
	 * Gets the scoring.
	 *
	 * @return the scoring
	 */
	public abstract int getScoring();
	
	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		return result;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Score other = (Score) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score != other.score)
			return false;
		return true;
	}
}
