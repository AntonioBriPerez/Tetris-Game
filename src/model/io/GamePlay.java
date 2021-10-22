package model.io;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

import model.Coordinate;
import model.Game;
import model.exceptions.CollisionMovementException;
import model.exceptions.CurrentPieceNotFixedException;
import model.exceptions.FixedPieceMovementException;
import model.exceptions.GameEndedMovementException;
import model.exceptions.NoCurrentPieceException;
import model.exceptions.OffBoardMovementException;
import model.exceptions.WrongSizeException;
import model.exceptions.io.TetrisIOException;

// TODO: Auto-generated Javadoc
/**
 * The Class GamePlay.
 */
public class GamePlay {
	
	/** The tetris board standard width. */
	static int TETRIS_BOARD_STANDARD_WIDTH=10;	
	
	/** The tetris board standard height. */
	static int TETRIS_BOARD_STANDARD_HEIGHT=20;
	
	/** The visualizer. */
	IVisualizer visualizer;
	
	/** The player. */
	IPlayer player;
	
	/** The game. */
	Game game;
	
	/** The move. */
	private char move;
	/** the rows*/
	private int rowsCleared;
	/** the duration*/
	private int duration;
	
	
	/**
	 * Instantiates a new game play.
	 *
	 * @param ip the ip
	 * @param iv the iv
	 */
	public GamePlay(IPlayer ip, IVisualizer iv)  {
		Objects.requireNonNull(ip, "IP no puede ser nulo 'gameplay'");
		Objects.requireNonNull(iv, "IV no puede ser nulo 'gameplay'");
		player=ip;
		visualizer=iv;
		rowsCleared=0;
		duration=0;
		
		try {
			Coordinate c = new Coordinate(TETRIS_BOARD_STANDARD_HEIGHT,TETRIS_BOARD_STANDARD_WIDTH);//Crea coordenada 20x10
			Game gm = new Game(c);//Crea tablero con 20x10
			game = gm;//Almacenamos en atributi game
			visualizer.setGame(game);
		}catch(WrongSizeException we) {//Intentamos capturar we
			throw new RuntimeException();//Relanzamos runtimeexception
		}
		
	}
	
	


	/**
	 * Play.
	 *
	 * @throws TetrisIOException the tetris IO exception
	 */
	public void play() throws TetrisIOException {	
		long t0 = new Date().getTime();
		
		
		
		while(move != IPlayer.LAST_MOVE) {
			
			visualizer.show();
			try {
				move = player.nextMove();
			//	System.out.println(move);
				switch(move) {
				case 'I': game.nextPiece(Character.toString(move));
						  break;
				case 'J': game.nextPiece(Character.toString(move));
						  break;
				case 'L': game.nextPiece(Character.toString(move));
						  break;
				case 'Z': game.nextPiece(Character.toString(move));
						  break;
				case 'T': game.nextPiece(Character.toString(move));
						  break;
				case 'S': game.nextPiece(Character.toString(move));
						  break;
				case 'O': game.nextPiece(Character.toString(move));
						  break;
				case '↺': game.rotateCurrentPieceCounterclockwise();
						  break;
				case '↻': game.rotateCurrentPieceClockwise();
						  break;
				case '→': game.moveCurrentPieceRight();
						  break;
				case '←': game.moveCurrentPieceLeft();
						  break;
				case '↓': rowsCleared=rowsCleared+game.moveCurrentPieceDown();
				 		
						  break;
				}
			} catch (IOException e) {
				
			} catch (GameEndedMovementException e) {
				return;
				
			} catch (CurrentPieceNotFixedException e) {
				throw new TetrisIOException(null);
				
			} catch (FixedPieceMovementException e) {
				
			} catch (OffBoardMovementException e) {
				
			} catch (CollisionMovementException e) {
			
			} catch (NoCurrentPieceException e) {
				throw new TetrisIOException(null);
				
			}
		}
		long t1 = new Date().getTime();
		duration=(int)(t1-t0);
		
	}
	
	/**
	 * Gets the rows cleared.
	 *
	 * @return the rows cleared
	 */
	public int getRowsCleared() {
		return rowsCleared;
	}

	
	/**
	 * Gets the duration.
	 *
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
}
