package model;

// TODO: Auto-generated Javadoc
/**
 * The Class IPiece.
 */
public class I extends Piece {
	
	/** The shape. */
	private  int shape[][]=new int [][] {
	      { 0, 0, 0, 0,   1, 1, 1, 1,   0, 0, 0, 0,   0, 0, 0, 0 },
	      { 0, 0, 1, 0,   0, 0, 1, 0,   0, 0, 1, 0,   0, 0, 1, 0 },
	      { 0, 0, 0, 0,   0, 0, 0, 0,   1, 1, 1, 1,   0, 0, 0, 0 },
	      { 0, 1, 0, 0,   0, 1, 0, 0,   0, 1, 0, 0,   0, 1, 0, 0 } }; 

	/**
	 * @return shape
	 */
	@Override
	protected int[][] getShape() {
		return shape;
	}
	
	/** @method copy() 
	 * 	@return p
	 */
	public I copy() { //Devuelve una copia del objeto recibido que tenga el mismo tipo. EN este caso tipo I
		I p = new I();
		p.copyAttributes(this);
		return p; //Devolvemos un un subtipo
		
	}
	
	/**
	 * Instantiates a new i piece.
	 */
	public I() {
		super();//Llamamos al constructor por defecto de la super clase
		this.blockSymbol='▒';
		
	}

}
