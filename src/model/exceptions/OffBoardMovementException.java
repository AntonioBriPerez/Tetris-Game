package model.exceptions;

import model.Coordinate;

// TODO: Auto-generated Javadoc
/**
 * The Class OffBoardMovementException.
 */
public class OffBoardMovementException extends MovementException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The c. */
	private Coordinate c;
	
	/**
	 * Instantiates a new off board movement exception.
	 *
	 * @param coor the coor
	 */
	public OffBoardMovementException(Coordinate coor) {
		this.c=coor;
		
	}
	
	/**
	 * String toString().
	 *
	 * @return String
	 */
	public String getMessage() {
		String error;
		error=("ERROR: No se puede acceder a la casilla " + c + " (fuera del tablero)");
		
		return error;
	}
	

}
