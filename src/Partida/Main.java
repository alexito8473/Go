package Partida;

/**
 * Clase de inicio, donde se inicia la partida.
 * @author Alejandro Aguilar Alba
 * @since 1.0
 * @version 1.0
 *
 */

public class Main {
	
	/**
	 * Metodo donde se inicia la partida.
	 */
	
	private void empezarPartida() {
		Partida partida = new Partida();
		partida.jugarPartida();
	}
	
	/**
	 * Metodo se inicia al principio para llamar a otro metodo para comenzar la partida.
	 * @see empezarPartida()
	 */
	
	public static void main(String[] args) {

		new Main().empezarPartida();
	}
}
