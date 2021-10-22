package model.io;

import java.util.Objects;
import java.util.Random;

import model.exceptions.io.TetrisIOException;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerRandom.
 */
public class PlayerRandom implements IPlayer {
	
	/**
	 * Para valores de  0, 1, 2, 3, 4, 5 y 6 de este entero, se devuelven, 
	 * respectivamente, las siguientes piezas: 
	 * I, J, L, O, S, T, Z. Si el número aleatorio es 7, entonces se devuelve IPlayer.LAST_MOVE.
	 */

	private Random random;
	
	/** The next put piece. */
	private boolean nextPutPiece=true;
	
	/** The down counter. */
	private int downCounter=0;
	
	
	
	/**
	 * Instantiates a new player random.
	 *
	 * @param number the number
	 */
	PlayerRandom(long number){
		Objects.requireNonNull(number);
		random=new Random(number);		
	}
	
	/**
	 *  String toString().
	 *
	 * @return char
	 * @throws TetrisIOException the tetris IO exception
	 */
	public char nextMove() throws TetrisIOException {
		if(nextPutPiece) {
	
			int randomNumber1=random.nextInt(8);//Genera pieza aleatoria
			nextPutPiece=false;
			switch(randomNumber1) {
				case 0:return IPlayer.PIECE_I;
				case 1:return IPlayer.PIECE_J;
				case 2:return IPlayer.PIECE_L;
				case 3:return IPlayer.PIECE_O;
				case 4:return IPlayer.PIECE_S;
				case 5:return IPlayer.PIECE_T;
				case 6:return IPlayer.PIECE_Z;
				case 7://System.out.println("telodevuelvoyo1");
					return IPlayer.LAST_MOVE;
			}	
		}
		else if(!nextPutPiece) {
			int randomNumber2=random.nextInt(10);
			if(downCounter!=GamePlay.TETRIS_BOARD_STANDARD_HEIGHT) {
				switch(randomNumber2) {
					case 0: return IPlayer.LEFT_SYMBOL;
					case 1: return IPlayer.RIGHT_SYMBOL;
					case 2: return IPlayer.CLOCK_WISE;
					case 3: return IPlayer.COUNTER_CLOCK_WISE;
					
					case 4: downCounter++;
							return IPlayer.DOWN_SYMBOL;
							
					case 5: downCounter++;
							return IPlayer.DOWN_SYMBOL;
							
					case 6: downCounter++;
							return IPlayer.DOWN_SYMBOL;
							
					case 7: downCounter++;
							return IPlayer.DOWN_SYMBOL;
							
					case 8: downCounter++;
							return IPlayer.DOWN_SYMBOL;
							
					case 9: downCounter++;
							return IPlayer.DOWN_SYMBOL;
				}
			}
			if(downCounter==GamePlay.TETRIS_BOARD_STANDARD_HEIGHT) {
				downCounter=0;
				//nextPutPiece=true;
				
				return IPlayer.LAST_MOVE;
			}
		}
		return 0;
		
	}
}

