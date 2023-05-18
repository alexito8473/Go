package Jugador;

import Tablero.Coordenada;
/**
 * Clase donde contiene el movimiento de un jugada, se utiliza para la ia principalemte.
 * @author Alejandro Aguilar Alba
 * @since 1.0
 * @version 1.0
 *
 */
public class MovimientoIa {
	/**
	 *	Atributo donde se almacena la cantidad total que gira.
	 */
	private int cantidadComida;
	/**
	 * Atributo donde almacena la coordenada de la ficha.
	 */
	private Coordenada coordenada;

	/**
	 * Contructor de la clase 
	 * @param coordenada La coordenada de la jugada
	 * @param cantidadComida La cantidad de fichas que se come.
	 */
	MovimientoIa(Coordenada coordenada, int cantidadComida) {
		this.cantidadComida = cantidadComida;
		this.coordenada = coordenada;
	}

	/**
	 *	Metodo que devuelve la cantidad de fichas que puede comer en total.
	 * @return La cantidad.
	 */
	public int getCantidadComida() {
		return cantidadComida;
	}

	/**
	 * Metodo que devuelve la coordenada.
	 * @return La cooordenada.
	 */
	public Coordenada getCoordenada() {
		return coordenada;
	}

}
