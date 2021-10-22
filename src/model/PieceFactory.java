package model;
 
// TODO: Auto-generated Javadoc
/**
 * A factory for creating Piece objects.
 */
public class PieceFactory {
	
	/**
	 * Instantiates a new piece factory.
	 */
	public PieceFactory() {}
	
	/**
	 * Creates a new Piece object.
	 *
	 * @param s the s
	 * @return the piece
	 */
	public static Piece createPiece(String s) {
		try {
			@SuppressWarnings("rawtypes")
			Class clase = Class.forName("model."+s);
			Piece p = (Piece)clase.newInstance();
			return p;
		}catch(IllegalAccessException e) {
				
		}
		catch(ClassNotFoundException e) {
			return null;
		} catch (InstantiationException e) {
			
		}
		return null;
	}
		
		
		
		/*
		switch(s) {
			
			case "I": p= new I();
					 return p;
			
			case "S": p = new S();
					  return p;
					  
			case "T": p= new T();
				      return p;
				      
			case "J": p = new J();
					  return p;
				
			case "L": p = new L();
					  return p;
					 
			case "O": p = new O();	
					  return p;
					  
			case "Z": p = new Z();
					  return p;
			
					  
			default: return null;
		
		}*/
		
	}


