package model.exceptions;

// TODO: Auto-generated Javadoc
/**
 * The Class NoCurrentPieceException.
 */
public class NoCurrentPieceException extends TetrisException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new no current piece exception.
	 */
	public NoCurrentPieceException() {
		
	}
	
	/**
	 * String toString().
	 *
	 * @return String
	 */
	public String getMessage() {
		return "ERROR: La partida no ha empezado y no hay pieza actual";
	}

}
