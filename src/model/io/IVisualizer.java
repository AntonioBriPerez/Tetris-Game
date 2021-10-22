package model.io;

import model.Game;
import model.exceptions.WrongSizeException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IVisualizer.
 */
public interface IVisualizer {
	
	/**
	 * Sets the game.
	 *
	 * @param game the new game
	 * @throws WrongSizeException the wrong size exception
	 */
	public void setGame(Game game) throws WrongSizeException;
	
	/**
	 * Show.
	 */
	public void show();

}
