package model.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import model.exceptions.io.TetrisIOException;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Player objects.
 */
public class PlayerFactory {
	
	/**
	 * Instantiates a new player factory.
	 */
	public PlayerFactory() {};
	
	/**
	 * Checks if is long.
	 *
	 * @param cadena the cadena
	 * @return true, if is long
	 */
	private static boolean isLong(String cadena) {
		return false;
		
	}
	
	/**
	 * Creates a new Player object.
	 *
	 * @param cadena the cadena
	 * @return the i player
	 * @throws TetrisIOException the tetris IO exception
	 */
	public static IPlayer createPlayer(String cadena) throws TetrisIOException{
		//System.out.println("hihi");
		if(cadena=="") {
			return (new PlayerKeyboard());
		}
		else if(cadena.indexOf('.')>=0 || cadena.indexOf('/')>=0 || cadena.indexOf('\\')>=0) {

				try {
					BufferedReader bf = new BufferedReader(new FileReader(cadena));
					PlayerFile pf = new PlayerFile(bf);
					return pf;
				} catch (FileNotFoundException e) {
					throw new TetrisIOException("Buffered reader no se pudo crear");
				  }
		}
		
		else {
			try {
				
				 long numero = Long.parseLong(cadena);
				 PlayerRandom pr = new PlayerRandom(numero);
				 return pr;
				 
			}catch (NumberFormatException nf) {
				
				PlayerString ps = new PlayerString(cadena);
				return ps;
				
			}	
		}
	}
}

	


