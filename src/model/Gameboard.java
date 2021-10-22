package model;


import java.util.*;
import model.exceptions.*;

// TODO: Auto-generated Javadoc
/**
 *  clase para manejar el tablero.
 *
 * @author Antonio
 */

public class Gameboard {
	
	/** The height. */
	private int height;
	
	/** The width. */
	private int width;
	
	/** The gameboard. */
	private Map<Coordinate, Piece> gameboard = new HashMap<Coordinate, Piece>();

	/** The Constant MINIMUM_BOARD_HEIGHT. */
	private static final int MINIMUM_BOARD_HEIGHT=4;

	/** The Constant MINIMUM_BOARD_WIDTH. */
	private static final int MINIMUM_BOARD_WIDTH=4;
	
	
	/**
	 * Instantiates a new gameboard.
	 *
	 * @param c the c
	 * @throws WrongSizeException the wrong size exception
	 */ 
	public Gameboard(Coordinate c) throws WrongSizeException {
		
		Objects.requireNonNull(c,"No puede ser nulo");
		if(c.getRow() < MINIMUM_BOARD_HEIGHT || c.getColumn() < MINIMUM_BOARD_WIDTH) {
			throw new WrongSizeException(c);
		}
		height = c.getRow();
		width = c.getColumn();
		
	}
	
	/**
	 * Put piece.
	 *
	 * @param c the c
	 * @param p the p
	 */
	public void putPiece(Coordinate c, Piece p) {
		Objects.requireNonNull(c, "Coordinate c no puede ser nulo");
		Objects.requireNonNull(p, "Piece p no puede ser nulo");
		
		Set<Coordinate> piece= p.getAbsoluteCells(c); //Obtenemos posiciones ocupadas por pieza
		for(Coordinate pieceIsIn: piece) {
			gameboard.put(pieceIsIn,p);
			
		}
	}
	
	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Checks if is place valid.
	 *
	 * @param c the c
	 * @param p the p
	 * @return true, if is place valid
	 */
	public boolean isPlaceValid(Coordinate c, Piece p) {
		Objects.requireNonNull(c, "Coordinate c no puede ser null");
		Objects.requireNonNull(c, "Piece p no puede ser null");
		
		Set<Coordinate> coordenadas=p.getAbsoluteCells(c);
		
		for(Coordinate coord: coordenadas) {
			if(coord.getRow()>height-1|| coord.getColumn()>width-1) {
				return false;
			}
			else if(coord.getRow()<0 || coord.getColumn()<0) {
				
				return false;
			}
		}
		
		return true;
	}
	
	
	
	/**
	 * Checks if is place free.
	 *
	 * @param c the c
	 * @param p the p
	 * @return true, if is place free
	 */
	public boolean isPlaceFree(Coordinate c, Piece p) {
		Objects.requireNonNull(c, "Coordinate c no puede ser null");
		Objects.requireNonNull(p, "Piece p no puede ser null");
		
		Set<Coordinate> coordenadas=p.getAbsoluteCells(c); //Posiciones ocupadas por la pieza p en la coordenada c
		for(Coordinate coord: coordenadas) {
			Piece pAux = gameboard.get(coord);
			if(pAux!=null) {//Hay pieza en esa coordenada
				if(pAux.isFixed()) {
					return false;
				}
			}
			
		}
		return true;
	}
	
	
	/**
	 * Removes the piece.
	 *
	 * @param p the p
	 */
	public void removePiece(Piece p) {
		//Elimina del gameboard todas las entradas cuyas referencias coinciden con la pieza pasado como parametro
		Objects.requireNonNull(p, "Piece p no puede ser null");
		
		
		for(int i=0; i<getHeight(); i++) {
			for(int j=0; j<getWidth();j++) {
				Coordinate c = new Coordinate(i,j);
				Piece pAux=getCellContent(c);
				if(pAux==p) {
					gameboard.remove(c);
				}
			}
		}
		
		
	}
	
	/**
	 * Gets the cell content.
	 *
	 * @param c the c
	 * @return the cell content
	 */
	public Piece getCellContent(Coordinate c) {
		Objects.requireNonNull(c, "Coordinate c no puede ser null");
		Piece pieza = gameboard.get(c);
		if(pieza==null) { //Celda vacía
			return null;
		}
		else { //Celda llena
			return pieza;
		}
	}
	
	/**
	 * Sets the cell content.
	 *
	 * @param c the c
	 * @param p the p
	 */
	public void setCellContent(Coordinate c, Piece p) {
		Objects.requireNonNull(c, "Coordinate c no puede ser null");
		Objects.requireNonNull(p, "Piece p no puede ser null");
		
		gameboard.put(c, p);
		
	}
	
	
	/**
	 *  String toString().
	 *
	 * @return Srting
	 */
	public String toString() {
		int n=0, j=0;
		StringBuilder sb = new StringBuilder();
		for(n=0; n<getHeight(); n++) {
			for(j=0; j<getWidth(); j++) {
				Coordinate c = new Coordinate(n,j);
				if(gameboard.containsKey(c)){
					Piece p=getCellContent(c);
					
					sb.append(p.getBlockSymbol());
				}
				else if(!gameboard.containsKey(c)) {
					sb.append("·");
				}
			}
			sb.append("\n");
		}
		
		return sb.toString();
		
		
	}
	
	/**
	 * Checks if is row full.
	 *
	 * @param fila the fila
	 * @return true, if is row full
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	private boolean isRowFull(int fila) throws java.lang.IllegalArgumentException {
		if(fila<0 || fila>getHeight()) {
			throw new java.lang.IllegalArgumentException();
		}
			for(int j=0; j<getWidth();j++) {
				Coordinate c = new Coordinate(fila,j);
				Piece p = getCellContent(c);
				if(p==null || !p.isFixed()) {//La fila está vacía
					return false;
				}
			}
		return true;
	}

	/**
	 * First row full from bottom.
	 *
	 * @return the int
	 */
	public int firstRowFullFromBottom() {
		for(int i=getHeight()-1; i>=0; i--) { //Recorre altura, cada nnumero es una fila distinaS
			if(isRowFull(i)) {//Si esa fila esta llena la devuelve
				return i;
			}
		}
		return -1;
		
	}
	
	/**
	 * Clear row.
	 *
	 * @param filaBorrar the fila borrar
	 */
	public void clearRow(int filaBorrar)  {
		if(filaBorrar<0 || filaBorrar>getHeight()) {
			throw new java.lang.IllegalArgumentException();
		}
		Set<Coordinate> coord = new HashSet<Coordinate>();
		for(int i=0; i<getHeight(); i++) {
			for(int j=0; j<getWidth();j++) {
				Coordinate c = new Coordinate(i,j);
				if(c.getRow()==filaBorrar) {
					coord.add(c);//Guardamos todas las coordenadas que queremos borrar
				}
			}
		}
		for(Coordinate c:coord) {
			gameboard.remove(c);
		}
	
	}
	
	/**
	 * Make upper rows fall.
	 *
	 * @param fila the fila
	 */
	public void makeUpperRowsFall(int fila) {
		if(fila<0 || fila>getHeight()) {
			throw new java.lang.IllegalArgumentException();
		}
		for(int i=fila-1;i>=0;i--) {
			for(int j=0; j<getWidth();j++) {
				Coordinate c = new Coordinate(i,j);
				Piece p = getCellContent(c);
				gameboard.remove(c);
				if(p!=null) {
					Coordinate cAux = new Coordinate(i+1,j);
					setCellContent(cAux,p);
				}
			}
		}
	}
}
