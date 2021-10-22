package model;

// TODO: Auto-generated Javadoc
/**
 * The Class JPiece.
 */
public class J extends Piece {
	
	/** The shape. */
	private  int shape[][]=new int [][] {
	      { 1, 0, 0, 0,   1, 1, 1, 0,   0, 0, 0, 0,   0, 0, 0, 0 },
	      { 0, 1, 1, 0,   0, 1, 0, 0,   0, 1, 0, 0,   0, 0, 0, 0 },
	      { 0, 0, 0, 0,   1, 1, 1, 0,   0, 0, 1, 0,   0, 0, 0, 0 },
	      { 0, 1, 0, 0,   0, 1, 0, 0,   1, 1, 0, 0,   0, 0, 0, 0 } }; 
		      
		
		@Override
		protected int[][] getShape() {
			return shape;
		}
		
		/** @method copy() 
		 * 	@return p
		 */
		public J copy() { //Devuelve una copia del objeto recibido que tenga el mismo tipo. EN este caso tipo I
			J p = new J();
			p.copyAttributes(this);
			return p; //Devolvemos un un subtipo
			
		}
		
		/**
		 * Instantiates a new j piece.
		 */
		public J() {
			super();//Llamamos al constructor por defecto de la super clase
			this.blockSymbol='◪';
			
		}

}
