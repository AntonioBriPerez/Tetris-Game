package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PieceFactoryTestP3 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreateIPiece() {
		Piece p = new I();
		assertNotNull(p);
	}
	
	@Test
	public void testCreateJPiece() {
		Piece p = new J();
		assertNotNull(p);
	}
	
	@Test
	public void testCreateLPiece() {
		Piece p = new L();
		assertNotNull(p);
	}
	
	@Test
	public void testCreateOPiece() {
		Piece p = new O();
		assertNotNull(p);
	}
	
	@Test
	public void testCreateSPiece() {
		Piece p = new S();
		assertNotNull(p);
	}
	
	@Test
	public void testCreateTPiece() {
		Piece p = new T();
		assertNotNull(p);
	}
	
	@Test
	public void testCreateZPiece() {
		Piece p = new Z();
		assertNotNull(p);
	}
	
	@Test
	public void testCreatePieceNull() {
		assertNull(PieceFactory.createPiece("Q"));
	}
}
