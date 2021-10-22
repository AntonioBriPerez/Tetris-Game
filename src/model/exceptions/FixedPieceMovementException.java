package model.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class FixedPieceMovementException.
 */
public class FixedPieceMovementException extends MovementException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new fixed piece movement exception.
	 */
	public FixedPieceMovementException() {
		
	}
	
	/**
	 * String toString().
	 *
	 * @return String
	 */
	public String getMessage() {
		return "ERROR: la pieza no se puede mover porque ya esta fijada";
	}

}
