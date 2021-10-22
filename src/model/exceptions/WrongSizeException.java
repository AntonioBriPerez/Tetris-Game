package model.exceptions;

import model.Coordinate;

// TODO: Auto-generated Javadoc
/**
 * The Class WrongSizeException.
 */
public class WrongSizeException extends TetrisException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The c. */
	private Coordinate c;
	
	/**
	 * Instantiates a new wrong size exception.
	 *
	 * @param coor the coor
	 */
	public WrongSizeException(Coordinate coor) {
		this.c=coor;
		
	}
	
	/**
	 * String toString().
	 *
	 * @return String
	 */
	public String getMessage() {
		return ("ERROR: se ha creado un tablero demasiado pequeño " +c);
	}

}
