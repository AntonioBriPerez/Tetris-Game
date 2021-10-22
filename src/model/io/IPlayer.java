package model.io;

import java.io.IOException;

import model.exceptions.io.TetrisIOException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPlayer.
 */
public interface IPlayer {
	
	/** The last move. */
	public static char LAST_MOVE='●';
	
	/** The piece i. */
	public static char PIECE_I='I';
	
	/** The piece j. */
	public static char PIECE_J='J';
	
	/** The piece l. */
	public static char PIECE_L='L';
	
	/** The piece o. */
	public static char PIECE_O='O';
	
	/** The piece s. */
	public static char PIECE_S='S';
	
	/** The piece t. */
	public static char PIECE_T='T';
	
	/** The piece z. */
	public static char PIECE_Z='Z';
	
	/** The clock wise. */
	public static char CLOCK_WISE='↻';
	
	/** The counter clock wise. */
	public static char COUNTER_CLOCK_WISE='↺';
	
	/** The right symbol. */
	public static char RIGHT_SYMBOL='→';
	
	/** The left symbol. */
	public static char LEFT_SYMBOL='←';
	
	/** The down symbol. */
	public static char DOWN_SYMBOL='↓';
	
	/**
	 * Next move.
	 *
	 * @return the char
	 * @throws TetrisIOException the tetris IO exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public char nextMove() throws TetrisIOException, IOException;
	
	
	
}
