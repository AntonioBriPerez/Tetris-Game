package model.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class GameEndedMovementException.
 */
public class GameEndedMovementException extends MovementException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new game ended movement exception.
	 */
	public GameEndedMovementException() {
		
	}
	/**
	 * String toString().
	 *
	 * @return String
	 */
	
	public String getMessage() {
		return "ERROR: La partida ya se ha terminado";
	}

}
