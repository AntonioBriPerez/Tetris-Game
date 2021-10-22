package model.io;


import model.exceptions.io.TetrisIOException;

import java.io.BufferedReader;

import java.io.IOException;
import java.util.Objects;


// TODO: Auto-generated Javadoc
/**
 * The Class PlayerFile.
 */
public class PlayerFile implements IPlayer {
	
	/** The br. */
	private BufferedReader br;
	
	/** The correct movements. */
	private String correctMovements[]= {"I","J","L","O","S","T","Z","left","right","down","clockwise","counterclockwise"};
	
	
	/**
	 * Instantiates a new player file.
	 *
	 * @param lectorBuffer the lector buffer
	 */
	PlayerFile(BufferedReader lectorBuffer){
		Objects.requireNonNull(lectorBuffer, "Lectorbuffer no puede ser nulo");
		br=lectorBuffer;
		
	}
	
	/**
	 *  String toString().
	 *
	 * @return char
	 * @throws TetrisIOException the tetris IO exception
	 */
	public char nextMove() throws TetrisIOException{
		boolean correctMovement=false;
		try {
			String currentLine;
			String[] splittedLine;
			currentLine=br.readLine();
			if(currentLine!=null) {//Hay texto en el fichero
				splittedLine=currentLine.split("\\s+");//Dividimos en dos la linea
					if((splittedLine[0].equals("put")||splittedLine[0].equals("move")||splittedLine[0].equals("rotate"))&&
						splittedLine.length==2) {
						for(int i=0; i<correctMovements.length;i++) {
							if(splittedLine[1].equals(correctMovements[i])) {//Es un movimiento correcto
								correctMovement=true;
								switch(splittedLine[1]){
									case "clockwise": return IPlayer.CLOCK_WISE;
									case "counterclockwise": return IPlayer.COUNTER_CLOCK_WISE;
									case "right": return IPlayer.RIGHT_SYMBOL;
									case "left": return IPlayer.LEFT_SYMBOL;
									case "down": return IPlayer.DOWN_SYMBOL;
									case "I": return IPlayer.PIECE_I;
									case "J": return IPlayer.PIECE_J;
									case "L": return IPlayer.PIECE_L;
									case "O": return IPlayer.PIECE_O;
									case "S": return IPlayer.PIECE_S;
									case "T": return IPlayer.PIECE_T;
									case "Z": return IPlayer.PIECE_Z;
								}
							}
						}
						if(!correctMovement) {
							throw new TetrisIOException(splittedLine[1]);
						}
					}
					else
						throw new TetrisIOException(splittedLine[0]);
			}
			else
				return IPlayer.LAST_MOVE;
				
		} catch (IOException e) {
			throw new TetrisIOException("Error al abrir fichero");
		}
		

		return 0;
	}
	
	
	


}
