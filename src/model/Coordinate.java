package model;

import java.util.Objects;

// TODO: Auto-generated Javadoc
/**
 * The Class Coordinate.
 *
 * @author Antonio Bri
 */

public class Coordinate {
	
	/** The row. */
	private int row;
	
	/** The column. */
	private int column;
	
	/** The coordinate count. */
	private static int COORDINATE_COUNT;
	
	/*
	 * Este método inicializa los atributos y cuenta las coordenadas
	 */
	
	/**
	 * Instantiates a new coordinate.
	 *
	 * @param row the row
	 * @param column the column
	 */
	public  Coordinate(int row, int column) {
		this.row=Objects.requireNonNull(row, "Int row no puede ser null");
		this.column=Objects.requireNonNull(column, "Int column no puede ser null");
		COORDINATE_COUNT++;
	
	}
	
	/**
	 * Instantiates a new coordinate.
	 *
	 * @param c the c
	 */
	public Coordinate(Coordinate c) {
		this.row=Objects.requireNonNull(c.row, "C.row no puede ser null");
		this.column=Objects.requireNonNull(c.column, "c.Column no puede ser null");
		COORDINATE_COUNT++;
		
	}
	/*
	 * Este método crea las coordenadas y llama a coordinate para inicializar los valores
	 */
	
	/**
	 * Adds the.
	 *
	 * @param c the c
	 * @return the coordinate
	 */
	public Coordinate add(Coordinate c) {
		Objects.requireNonNull(c, "Coordinate c no puede ser null");
		Coordinate c1=new Coordinate(row+c.row,column+c.column);
		return c1;
			
	}
	
	/*
	 * Este método obtiene el número de coordenadas
	 */
	
	/**
	 * Gets the coordinate count.
	 *
	 * @return the coordinate count
	 */
	public static int getCoordinateCount() {
		return COORDINATE_COUNT;
		
	}
	
	/**
	 * String toString().
	 *
	 * @return toString
	 */
	public String toString() {
		
		return "["+ row +"," + column + "]";
	
	}
	
	/**
	 * Equals.
	 *
	 * @return true, if successful
	 */
	/*
	 * Este método compara las coordenadas 
	 */
	
	
	/*
	 * Este método devuelve el numero de filas
	 */

	/**
	 * Gets the row.
	 *
	 * @return the row
	 */
	public int getRow() {
		return row;
		
	}
	
	/*
	 * Este método devuelve el número de columnas
	 */
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (column != other.column)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

	/**
	 * Gets the column.
	 *
	 * @return the column
	 */
	public int getColumn() {
		return column;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}


	
}
