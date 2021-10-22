package model.io;


import java.util.Objects;

import model.Coordinate;
import model.Game;
import model.exceptions.WrongSizeException;

// TODO: Auto-generated Javadoc
/**
 * The Class VisualizerConsole.
 */
public class VisualizerConsole implements IVisualizer {
	
	/** The game. */
	private Game game;

	/**
	 * Instantiates a new visualizer console.
	 */
	VisualizerConsole(){game=null;}
	
	/**
	 * Sets the game.
	 *
	 * @param game2 the new game
	 * @throws WrongSizeException the wrong size exception
	 */
	public void setGame(Game game2) throws WrongSizeException {
		Objects.requireNonNull(game2, "El parametro game2 no puede ser null");
		this.game=game2;
		if(game.getGameboard().getHeight()!=GamePlay.TETRIS_BOARD_STANDARD_HEIGHT || 
			game.getGameboard().getWidth()!=GamePlay.TETRIS_BOARD_STANDARD_WIDTH) {
			Coordinate c = new Coordinate(game.getGameboard().getHeight(),game.getGameboard().getWidth());
			throw new WrongSizeException(c);	
		}
	}

	/**
	 * Show
	 */
	public void show() {
		Objects.requireNonNull(game, "El parametro game no puede ser null");
		System.out.println(game.toString());
		
		
	}
	

}
