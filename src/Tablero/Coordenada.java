package Tablero;

import java.util.Objects;

/**
 * Clase donde sirve de almacenador de las coordenada vertical y horizontal.
 * 
 * @author Alejandro Aguilar Alba
 * @since 1.0
 * @version 1.0
 *
 */
public class Coordenada {

	/**
	 * Atributo donde se almacena una direccion.
	 */
	private int posicion1;

	/**
	 * Atributo donde se almacena una direccion.
	 */
	private int posicion2;

	/**
	 * Constructor de la clase Coordenada.
	 * 
	 * @param posicion1 Una direccion.
	 * @param posicion2 Una direccion.
	 */
	public Coordenada(int posicion1, int posicion2) {
		this.posicion1 = posicion1;
		this.posicion2 = posicion2;
	}

	/**
	 * Metodo que devuelve la posicion1.
	 * 
	 * @return Devuelve la posicion1.
	 */
	public int getPosicion1() {
		return posicion1;
	}

	/**
	 * Metodo que devuelve la posicion2.
	 * 
	 * @return Devuelve la posicion2.
	 */
	public int getPosicion2() {
		return posicion2;
	}

	/**
	 * Metodo que sobrescribe el metodo haschCode() de Object, crea un hashCode
	 * unico.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(posicion1, posicion2);
	}

	/**
	 * Metodo que sobre escribe el metodo de Object, equipara dos objetos , informa
	 * si son iguales.
	 * 
	 * @return true: Son iguales false: No son iguales.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		return posicion1 == other.posicion1 && posicion2 == other.posicion2;
	}
}
