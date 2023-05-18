package Jugador;

import Ficha.Ficha;
import Tablero.Tablero;
/**
 *	Clase que sirve como contenedora, sirve 
 *	para definir a un jugador pero como sin especificar que jugador es en concreto. 
 * 	@author Alejandro Aguilar Alba
 * 	@since 1.0
 * 	@version 1.0
 *
 */
public abstract class Jugador {
	/**
	 * Atributo que indica el nombre del jugador.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
	 */
	protected String nombre;
	
	/**
	 * Atributo que indica la ficha que tendra el usuario.
	 */
	protected Ficha ficha;

	/**
	 * Constructor de la clase de Jugador.
	 * @param nombre Nombre del jugador
	 * @param ficha Ficha del jugador
	 */
	public Jugador(String nombre, Ficha ficha) {
		this.nombre = nombre;
		this.ficha = ficha;
	}

	/**
	 * Metodo que indica la ficha que tiene el jugador.
	 * @return La ficha del jugador.
	 */
	public Ficha getFicha() {
		return ficha;
	}

	/**
	 * Metodo que indica el nombre del jugador.
	 * @return El nombre del juhador.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que indica la jugada del jugador
	 * @param tablero El tablero de la partida en cuestion.
	 * @param turno El turno de la partida.
	 */
	public abstract void jugada(Tablero tablero, int turno);
}
