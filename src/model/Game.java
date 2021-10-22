
package model;
import java.util.*;

import model.exceptions.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Game.
 */
public class Game {
	
	/** The game ended. */
	boolean gameEnded;
	
	/** The board. */
	private Gameboard board;
	
	/** The current position. */
	private Coordinate currentPosition;
	
	/** The current piece. */
	private Piece currentPiece;
	
	
	/**
	 * Instantiates a new game.
	 *
	 * @param c the c
	 * @throws WrongSizeException the wrong size exception
	 */
	public Game(Coordinate c) throws WrongSizeException {
		 Objects.requireNonNull(c, "Coordinate c no puede ser null");
		 this.board = new Gameboard(c);
		 this.gameEnded=false;
		 
	}
	
	/**
	 * Move current piece left.
	 *
	 * @throws NoCurrentPieceException the no current piece exception
	 * @throws GameEndedMovementException the game ended movement exception
	 * @throws FixedPieceMovementException the fixed piece movement exception
	 * @throws OffBoardMovementException the off board movement exception
	 * @throws CollisionMovementException the collision movement exception
	 */
	public void moveCurrentPieceLeft() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException, OffBoardMovementException, CollisionMovementException  {
		if(currentPiece!=null) {
		currentPosition=new Coordinate(currentPosition.getRow(),currentPosition.getColumn()-1); //Mueve pieza hacia izquierda
		}
		if(currentPiece==null) {
			//currentPosition=new Coordinate(currentPosition.getRow(),currentPosition.getColumn()+1);
			throw new NoCurrentPieceException();
		}
		else if(isGameEnded()) {
			throw new GameEndedMovementException();
			
		}
		
		else if(currentPiece.isFixed()) {
			throw new FixedPieceMovementException();
		}
		else if(!getGameboard().isPlaceValid(currentPosition, currentPiece)) {
			currentPosition=new Coordinate(currentPosition.getRow(),currentPosition.getColumn()+1);
			throw new OffBoardMovementException(currentPosition);
		}
		else if(!getGameboard().isPlaceFree(currentPosition, currentPiece)) {
			currentPosition=new Coordinate(currentPosition.getRow(),currentPosition.getColumn()+1);
			throw new CollisionMovementException(currentPosition);
			
		}
		
		if(!currentPiece.isFixed() && !isGameEnded() && 
		   board.isPlaceValid(currentPosition, currentPiece) &&
		   board.isPlaceFree(currentPosition, currentPiece)) {
				board.removePiece(currentPiece);
				board.putPiece(currentPosition, currentPiece);
		}
	}
	
	
	/**
	 * Move current piece right.
	 *
	 * @throws NoCurrentPieceException the no current piece exception
	 * @throws GameEndedMovementException the game ended movement exception
	 * @throws FixedPieceMovementException the fixed piece movement exception
	 * @throws OffBoardMovementException the off board movement exception
	 * @throws CollisionMovementException the collision movement exception
	 */
	public void moveCurrentPieceRight() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException, OffBoardMovementException, CollisionMovementException {
		if(currentPiece!=null) {
		currentPosition=new Coordinate(currentPosition.getRow(),currentPosition.getColumn()+1); //Mueve pieza hacia derecha
		}
		if(currentPiece==null) {
			//currentPosition=new Coordinate(currentPosition.getRow(),currentPosition.getColumn()-1); 
			throw new NoCurrentPieceException();
		}
		else if(isGameEnded()) {
			throw new GameEndedMovementException();
			
		}
		else if(currentPiece.isFixed()) {
			throw new FixedPieceMovementException();
		}
		else if(!board.isPlaceValid(currentPosition, currentPiece)) {
			currentPosition=new Coordinate(currentPosition.getRow(),currentPosition.getColumn()-1); 
		
			throw new OffBoardMovementException(currentPosition);
		}
		else if(!getGameboard().isPlaceFree(currentPosition, currentPiece)) {
			currentPosition=new Coordinate(currentPosition.getRow(),currentPosition.getColumn()-1); 
			throw new CollisionMovementException(currentPosition);
			
		}
		
	
		if(!currentPiece.isFixed() && !isGameEnded() && 
		   board.isPlaceValid(currentPosition, currentPiece) &&
		   board.isPlaceFree(currentPosition, currentPiece)) {
				board.removePiece(currentPiece);
				board.putPiece(currentPosition, currentPiece);
		}
	}
		
	
	/**
	 * Move current piece down.
	 * @return TODO
	 *
	 * @throws NoCurrentPieceException the no current piece exception
	 * @throws GameEndedMovementException the game ended movement exception
	 * @throws FixedPieceMovementException the fixed piece movement exception
	 */
	public int moveCurrentPieceDown() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException {
		int filasEliminadas=0;
		if(currentPiece!=null) {
		currentPosition=new Coordinate(currentPosition.getRow()+1,currentPosition.getColumn()); 
		}
		if(currentPiece==null) {
			//currentPosition=new Coordinate(currentPosition.getRow()-1,currentPosition.getColumn()); 
			throw new NoCurrentPieceException();
		}
		else if(isGameEnded()) {
			throw new GameEndedMovementException();
		}
		else if(currentPiece.isFixed()) {
			//currentPosition=new Coordinate(currentPosition.getRow()-1,currentPosition.getColumn()); 
			throw new FixedPieceMovementException();
		}
		boolean fix=true;
	
		if(currentPiece.isFixed() || isGameEnded()) {
			
			return 0;
		}
		
		else if((!isCurrentPieceFixed() && !isGameEnded()) && 
				   (!board.isPlaceValid(currentPosition, currentPiece) ||
				   !board.isPlaceFree(currentPosition, currentPiece))) {
					currentPiece.setFixed(fix);
					
				}
		else if(!isCurrentPieceFixed() && !isGameEnded() && 
		   board.isPlaceValid(currentPosition, currentPiece) &&
		   board.isPlaceFree(currentPosition, currentPiece)) {
				
				board.removePiece(currentPiece);
				board.putPiece(currentPosition, currentPiece);
		}
		while(board.firstRowFullFromBottom()!=-1) {
			int filaBorrar=board.firstRowFullFromBottom();
			board.clearRow(filaBorrar);
			filasEliminadas++;
			board.makeUpperRowsFall(filaBorrar);
		}
		
		return filasEliminadas;
		
	}
	
	

	
	/**
	 * Rotate current piece counterclockwise.
	 *
	 * @throws NoCurrentPieceException the no current piece exception
	 * @throws GameEndedMovementException the game ended movement exception
	 * @throws FixedPieceMovementException the fixed piece movement exception
	 * @throws OffBoardMovementException the off board movement exception
	 * @throws CollisionMovementException the collision movement exception
	 */
	public void rotateCurrentPieceCounterclockwise() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException, OffBoardMovementException, CollisionMovementException {
		if(currentPiece!=null) {
			if(!isGameEnded()) {
				Piece copyPiece= currentPiece.copy();
				copyPiece.rotateCounterclockwise();
				if(!isCurrentPieceFixed()) {
					if(board.isPlaceValid(currentPosition, copyPiece)) {
						if(board.isPlaceFree(currentPosition, copyPiece)) {
							board.removePiece(currentPiece);
							currentPiece.rotateCounterclockwise();
							board.putPiece(currentPosition, currentPiece);
						}else
							throw new CollisionMovementException(currentPosition);
					}
					else 
						throw new OffBoardMovementException(currentPosition);
				}
				else
					throw new FixedPieceMovementException();
			}
			else
				throw new GameEndedMovementException();
		}
		else
			throw new NoCurrentPieceException();

	}
	
	/**
	 * Rotate current piece clockwise.
	 *
	 * @throws NoCurrentPieceException the no current piece exception
	 * @throws GameEndedMovementException the game ended movement exception
	 * @throws FixedPieceMovementException the fixed piece movement exception
	 * @throws OffBoardMovementException the off board movement exception
	 * @throws CollisionMovementException the collision movement exception
	 */
	public void rotateCurrentPieceClockwise() throws NoCurrentPieceException, GameEndedMovementException, FixedPieceMovementException, OffBoardMovementException, CollisionMovementException {
		if(currentPiece!=null) {
			if(!isGameEnded()) {
				Piece copyPiece= currentPiece.copy();
				copyPiece.rotateClockwise();
				if(!isCurrentPieceFixed()) {
					if(board.isPlaceValid(currentPosition, copyPiece)) {
						if(board.isPlaceFree(currentPosition, copyPiece)) {
							board.removePiece(currentPiece);
							currentPiece.rotateClockwise();
							board.putPiece(currentPosition, currentPiece);
						}else
							throw new CollisionMovementException(currentPosition);
					}
					else 
						throw new OffBoardMovementException(currentPosition);
				}
				else
					throw new FixedPieceMovementException();
			}
			else
				throw new GameEndedMovementException();
		}
		else
			throw new NoCurrentPieceException();
	}
	
	/**
	 * Next piece.
	 *
	 * @param type the type
	 * @return true, if successful
	 * @throws GameEndedMovementException the game ended movement exception
	 * @throws CurrentPieceNotFixedException the current piece not fixed exception
	 */
	public boolean nextPiece(String type) throws GameEndedMovementException, CurrentPieceNotFixedException{
		if(isGameEnded()) {
			throw new GameEndedMovementException();
		}
		else if(currentPiece!=null && !currentPiece.isFixed()) {
			throw new CurrentPieceNotFixedException();
		}
		Objects.requireNonNull(type, "String type no puede ser null");
		currentPiece=PieceFactory.createPiece(type);
		currentPosition = new Coordinate(0, board.getWidth() / 2 - 2);
		if(board.isPlaceValid(currentPosition, currentPiece) &&  board.isPlaceFree(currentPosition, currentPiece)){
				board.putPiece(currentPosition, currentPiece);
				return true;
		}
		else {
			gameEnded=true;
			return false;
		}
		
	}
	
	/**
	 * String toString().
	 *
	 * @return String
	 */
	public String toString() {
		
		return board.toString();
		
	}
	
	/**
	 * Checks if is current piece fixed.
	 *
	 * @return true, if is current piece fixed
	 * @throws NoCurrentPieceException the no current piece exception
	 */
	public boolean isCurrentPieceFixed() throws NoCurrentPieceException {
		if(currentPiece==null) {
			throw new NoCurrentPieceException();
		}
		return currentPiece.isFixed();
	}
	
	/**
	 * Checks if is game ended.
	 *
	 * @return true, if is game ended
	 */
	public boolean isGameEnded() {
		return gameEnded;
	}
	
	/**
	 * Gets the gameboard.
	 *
	 * @return the gameboard
	 */
	public Gameboard getGameboard() {
		return board;
	}
	

}
