package model;

// TODO: Auto-generated Javadoc
/**
 * The Class ZPiece.
 */
public class Z extends Piece {

	/** The shape. */
	private  int shape[][]=new int [][] {
	      { 1, 1, 0, 0,   0, 1, 1, 0,   0, 0, 0, 0,   0, 0, 0, 0 },
	      { 0, 0, 1, 0,   0, 1, 1, 0,   0, 1, 0, 0,   0, 0, 0, 0 },
	      { 0, 0, 0, 0,   1, 1, 0, 0,   0, 1, 1, 0,   0, 0, 0, 0 },
	      { 0, 1, 0, 0,   1, 1, 0, 0,   1, 0, 0, 0,   0, 0, 0, 0 } }; 

	/* (non-Javadoc)
	 * @see model.Piece#getShape()
	 */
	@Override
	protected int[][] getShape() {
		return shape;
	}
	
	/** @method copy() 
	 * 	@return p
	 */
	public Z copy() { //Devuelve una copia del objeto recibido que tenga el mismo tipo. EN este caso tipo I
		Z p = new Z();
		p.copyAttributes(this);
		return p; //Devolvemos un un subtipo
		
	}
	
	/**
	 * Instantiates a new z piece.
	 */
	public Z() {
		super();//Llamamos al constructor por defecto de la super clase
		this.blockSymbol='◫';
		
	}


}