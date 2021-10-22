
package model;
import java.util.*;


// TODO: Auto-generated Javadoc
/**
 * The Class Piece.
 *
 * @author Bri, Pérez Antonio
 */
public abstract class Piece {

	/** The orientation. */
	private Rotation orientation;

	/** The fixed. */
	private boolean fixed;

	/** The block symbol. */
	protected char blockSymbol;

	/** The bounding square size. */
	private static int BOUNDING_SQUARE_SIZE=4;

	/**
	 * Instantiates a new piece.
	 */
	public Piece() {
		this.fixed=false;
		this.orientation=Rotation.D0;

	}

	/**
	 * Instantiates a new piece.
	 *
	 * @param p the p
	 */

	protected void copyAttributes(Piece p) {
		Objects.requireNonNull(p, "Pieza p no puede ser nulo");
		this.fixed=Objects.requireNonNull(p.fixed, "El parametro 'fixed' no puede ser null");
		this.blockSymbol=Objects.requireNonNull(p.blockSymbol, "parametros blocksymbol no puede ser null");
		this.orientation=Objects.requireNonNull(p.orientation, "EL parametros orientation no puede ser null");
	}

	/**
	 * Checks if is fixed.
	 *
	 * @return true, if is fixed
	 */
	public boolean isFixed() {
		return fixed;

	}

	/**
	 * Gets the orientation.
	 *
	 * @return the orientation
	 */
	public Rotation getOrientation() {
		return this.orientation;


	}

	/**
	 * Gets the block symbol.
	 *
	 * @return the block symbol
	 */
	public char getBlockSymbol() {
		return blockSymbol;

	}

	/**
	 * Sets the orientation.
	 *
	 * @param rot the new orientation
	 */
	public void setOrientation(Rotation rot) {
		this.orientation=Objects.requireNonNull(rot,"El parametro 'orientation' no puede ser nulll");
		

	}

	/**
	 * Rotate clockwise.
	 */
	public void rotateClockwise() {

		switch(orientation) {
			case D0: orientation=Rotation.D270;
			break;

			case D270: orientation=Rotation.D180;
			break;

			case D180: orientation=Rotation.D90;
			break;

			case D90: orientation=Rotation.D0;
			break;
		}



	}

	/**
	 * Rotate counterclockwise.
	 */
	public void rotateCounterclockwise() {
		switch(orientation) {
			case D0: orientation=Rotation.D90;
			break;

			case D90: orientation=Rotation.D180;
			break;

			case D180: orientation=Rotation.D270;
			break;

			case D270: orientation=Rotation.D0;
			break;

		}

	}

	/**
	 * Gets the absolute cells.
	 *
	 * @param c the c
	 * @return the absolute cells
	 */
	public Set<Coordinate> getAbsoluteCells(Coordinate c){
		Objects.requireNonNull(c,"Coordenada c no puede ser nulo");
		Set<Coordinate> squares = new HashSet<Coordinate>();
		for(int i=0; i<BOUNDING_SQUARE_SIZE; i++) {
			for(int j=0; j<BOUNDING_SQUARE_SIZE; j++) {
				if(getShape()[orientation.ordinal()][i*BOUNDING_SQUARE_SIZE+j]==1) {
					squares.add(c.add(new Coordinate(i,j)));
				}
			}
		}



		return squares;
	}


	/**
	 * String toString().
	 *
	 * @return String
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int j=0; j<BOUNDING_SQUARE_SIZE*4; j++) {
			if(j%BOUNDING_SQUARE_SIZE==0 && j!=0) {
				sb.append("\n");
			}

			if(getShape()[orientation.ordinal()][j]==1) {

				sb.append(getBlockSymbol());
			}
			else {
				sb.append("·");
			}
		}
		sb.append("\n");

			return sb.toString();

	}

	/**
	 * Sets the fixed.
	 *
	 * @param fix the new fixed
	 */
	public void setFixed(boolean fix ) {
		fixed=Objects.requireNonNull(fix, "Boolean fix no puede ser nulo");

	}
	
	/**
	 * Copy.
	 *
	 * @return the piece
	 */
	public abstract Piece copy();

	/**
	 * Gets the shape.
	 *
	 * @return the shape
	 */
	protected abstract int[][] getShape();

}
