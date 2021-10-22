package model.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrentPieceNotFixedException.
 */
public class CurrentPieceNotFixedException extends TetrisException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new current piece not fixed exception.
	 */
	public CurrentPieceNotFixedException() {
		
	}
	
	/**
	 * String toString().
	 *
	 * @return String
	 */
	public String getMessage() {
		return "ERROR: la pieza actual no esta fijada y se quiere poner una nueva pieza en el tablero. ";
	}

}
