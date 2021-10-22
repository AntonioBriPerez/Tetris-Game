package model.exceptions;

import model.Coordinate;

// TODO: Auto-generated Javadoc
/**
 * The Class CollisionMovementException.
 */
public class CollisionMovementException extends MovementException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The c. */
	private Coordinate c;
	
	/**
	 * Instantiates a new collision movement exception.
	 *
	 * @param coor the coor
	 */
	public CollisionMovementException(Coordinate coor) {
		this.c=coor;
		
	}
	
	/**
	 * String toString().
	 *
	 * @return String
	 */
	public String getMessage() {
		return ("ERROR: no se puede mover la pieza porque ocupa una celda ya ocupada por otra pieza. " +c+ "= "+
				"coordeanda de la esquina superior izquierda del cuadrado de la pieza colocada en una posicion"
				+ "incorrecta");
	}
	

}
