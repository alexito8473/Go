package Jugador;

import Ficha.Ficha;
import Tablero.Tablero;

public abstract class Jugador {

	protected String nombre;
	protected Ficha ficha;

	public Jugador(String nombre, Ficha ficha) {
		this.nombre = nombre;
		this.ficha = ficha;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public String getNombre() {
		return nombre;
	}


	public abstract void jugada(Tablero tablero, int turno);
}
