package Jugador;

import Tablero.Coordenada;

public class MovimientoIa {

	private int cantidadComida;
	private Coordenada coordenada;

	MovimientoIa(Coordenada coordenada, int cantidadComida) {
		this.cantidadComida = cantidadComida;
		this.coordenada = coordenada;
	}

	public int getCantidadComida() {
		return cantidadComida;
	}

	public void setCantidadComida(int cantidadComida) {
		this.cantidadComida = cantidadComida;
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}

}
