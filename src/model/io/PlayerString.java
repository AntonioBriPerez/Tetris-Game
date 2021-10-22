package model.io;
//import model.exceptions;

import java.util.Objects;

import model.exceptions.io.TetrisIOException;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerString.
 */
public class PlayerString implements IPlayer {
	
	/** The moves. */
	private String moves;
	
	/** The current move. */
	private int currentMove = 0;
	
	/** The all movements. */
	String allMovements="IJLOSTZ↻↺→←↓";
	
	/**
	 * Instantiates a new player string.
	 *
	 * @param movement the movement
	 */
	PlayerString(String movement){
		Objects.requireNonNull(movement, "String movement no puede ser null");
		moves=movement; //Movimientos en un tablero de 20x10
	}
	
	/**
	 *  String toString().
	 *
	 * @return char
	 * @throws TetrisIOException the tetris IO exception
	 */
	public char nextMove() throws TetrisIOException{
		char movimiento;
		if(currentMove==moves.length()) {
			return IPlayer.LAST_MOVE;
		}
		movimiento=moves.charAt(currentMove);
		currentMove++;
		if(allMovements.indexOf(movimiento)>=0) {//El siguiente caracter es valido.
			return movimiento;
		}
		else
			throw new TetrisIOException(Character.toString(movimiento));
	}
}
