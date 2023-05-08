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

	public Coordenada getCoordenada() {
		return coordenada;
	}

	@Override
	public String toString() {
		return "MovimientoIa [cantidadComida=" + cantidadComida + ", coordenada=" + coordenada + "]";
	}



}
