package model.exceptions.io;
import model.exceptions.TetrisException;


// TODO: Auto-generated Javadoc
/**
 * The Class TetrisIOException.
 */
public class TetrisIOException extends TetrisException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The message. */
	private String message;
	
	/**
	 * Instantiates a new tetris IO exception.
	 *
	 * @param excepcion the excepcion
	 */
	public TetrisIOException(String excepcion) {
		this.message=excepcion;
		
	}
	
	/**
	 *  String toString().
	 *
	 * @return String
	 */
	public String getMessage() {
		return message;	
	}
	

}
