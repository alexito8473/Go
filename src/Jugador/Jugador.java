package Jugador;

import Ficha.Ficha;
import Tablero.Coordenada;
import Tablero.Tablero;

public abstract class Jugador {

	protected String nombre;
	protected Ficha ficha;

	public Jugador(String nombre, Ficha ficha) {
		setNombre(nombre);
		setFicha(ficha);
	}

	public Ficha getFicha() {
		return ficha;
	}

	public String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	protected void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}

	public abstract void devolverCoordenada(Tablero tablero, int turno);
}
