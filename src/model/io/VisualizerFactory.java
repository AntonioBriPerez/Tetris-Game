package model.io;

import model.exceptions.io.TetrisIOException;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Visualizer objects.
 */
public class VisualizerFactory {
	
	/**
	 * Instantiates a new visualizer factory.
	 */
	public VisualizerFactory() {}
	
	/**
	 * Creates a new Visualizer object.
	 *
	 * @param cadena the cadena
	 * @return the i visualizer
	 * @throws TetrisIOException the tetris IO exception
	 */
	public static IVisualizer createVisualizer(String cadena) throws TetrisIOException {
		if(cadena.equals("console")) {
			VisualizerConsole vc = new VisualizerConsole();
			return vc;
		}
		else if(cadena.equals("window")) {
			return (new VisualizerWindow());
		}
		else
			throw new TetrisIOException("VisualizerFactory no es 'console'");
		
		
	}

}
