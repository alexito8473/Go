package Tablero;

import java.util.Objects;

import Ficha.Ficha;
/**
 * Clase que constituye a las casillas que tiene un tablero.
 * @author Alejandro Aguilar Alba
 * @since 1.0
 * @version 1.0
 */
public class Casilla {
	
	/**
	 * Atributo donde se establece si hay ficha o no en la casilla.
	 */
	private boolean llena;
	
	/**
	 * Atributo donde se establece la ficha que tiene la casilla.
	 */
	private Ficha ficha;
	
	/**
	 * Atributo que almacena la coordenada que esta la ficha en el tablero.
	 */
	private Coordenada coordenada;

	/**
	 * 	Constructor de la clase Casilla, se usa cuando en la casilla no va ha tener definifa la ficha
	 * 	@param posicion1 Posicion vertical de la casilla.
	 * 	@param posicion2 Posicion horizontal de la casilla
	 */
	public Casilla(int posicion1, int posicion2) {
		llena = false;
		coordenada = new Coordenada(posicion1, posicion2);
	}
	
	/**
	 * 	Constructor de la clase Casilla, se usa cuando la casilla va ha tener definida la ficha.
	 * 	@param posicion1 Posicion vertical de la casilla.
	 * 	@param posicion2 Posicion horizontal de la casilla
	 * 	@param ficha Ficha de la casilla
	 */
	public Casilla(int posicion1, int posicion2, Ficha ficha) {
		this.ficha = ficha;
		llena = true;
		coordenada = new Coordenada(posicion1, posicion2);
	}
	
	/**
	 * Metodo que sobrescribe el metodo hascCode() de Object, que se encarga crea un hascode unico para la casilla.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(coordenada, ficha, llena);
	}
	
	/**
	 * Metodo que sobre escribe un metodo de object, que se encarga en compara objetos.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Casilla other = (Casilla) obj;
		return Objects.equals(coordenada, other.coordenada) && ficha == other.ficha && llena == other.llena;
	}

	/**
	 * Metodo que se encarga en devolver la coordenada.
	 * @return Devolver la coordenada de la casilla.
	 */
	public Coordenada getCoordenada() {
		return coordenada;
	}

	/**
	 * Metodo que devuelve si esta llena o no la casilla.
	 * @return true: hay casilla false: no hay casilla.
	 */
	public boolean isLlena() {
		return llena;
	}
	
	/**
	 * 	Metodo que sive para insertar o cambiar la ficha de la casilla.
	 *	@param ficha Donde se mete la ficha de intercambio.
	 *	@throws NullPointerException Fallo por que la ficha es nula.
	 */
	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
		llena = true;
	}

	/**
	 * Metodo que devuelve la ficha.
	 * @return Devuelve la ficha de clase.
	 */
	public Ficha getFicha() {
		return ficha;
	}
	
	/**
	 * Metodo que devuelve el contendio de la ficha
	 * @return Devuelve un String con contenido de la casilla.
	 * @see Ficha#devolverFicha() 
	 */
	public String devolverCasilla() {
		return llena ? ficha.devolverFicha() : " . ";
	}
}
