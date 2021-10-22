package model;

/**
 * 
 * @author Antonio Bri
 *
 */

public class Coordinate {
	
	/*
	 * Atributos de la clase coordinate
	 */
	private int row;
	private int column;
	private static int COORDINATE_COUNT;
	
	/*
	 * Este método inicializa los atributos y cuenta las coordenadas
	 */
	
	public  Coordinate(int row, int column) {
		this.row=row;
		this.column=column;
		COORDINATE_COUNT++;
	
	}
	
	public Coordinate(Coordinate c) {
		this.row=c.row;
		this.column=c.column;
		
	}
	/*
	 * Este método crea las coordenadas y llama a coordinate para inicializar los valores
	 */
	
	public Coordinate add(Coordinate c) {
		Coordinate c1=new Coordinate(row+c.row,column+c.column);
		return c1;
			
	}
	
	/*
	 * Este método obtiene el número de coordenadas
	 */
	
	public static int getCoordinateCount() {
		return COORDINATE_COUNT;
		
	}
	/*
	 * Este método convierte las coordenadas a string
	 */
	
	public String toString() {
		
		return "["+ row +"," + column + "]";
	
	}
	
	/*
	 * Este método compara las coordenadas 
	 */
	public boolean equals(Coordinate c) {
		if (this == c)
			return true;
		if (c == null)
			return false;
		if (getClass() !=c.getClass())
			return false;
		Coordinate other = (Coordinate) c;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	
	/*
	 * Este método devuelve el numero de filas
	 */

	public int getRow() {
		return row;
		
	}
	
	/*
	 * Este método devuelve el número de columnas
	 */
	
	public int getColumn() {
		return column;
		
	}
	
}
