package Tablero;

import Ficha.Ficha;

public class Casilla {

	private boolean llena;
	private Ficha ficha;

	private Coordenada coordenada;

	public Casilla(int posicion1, int posicion2) {
		llena = false;
		coordenada = new Coordenada(posicion1, posicion2);
	}

	public Casilla(int posicion1, int posicion2, Ficha ficha) {
		this.ficha = ficha;
		llena = true;
		coordenada = new Coordenada(posicion1, posicion2);
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public boolean isLlena() {
		return llena;
	}

	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
		llena = true;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void setLlena(boolean llena) {
		this.llena = llena;
	}

	public String devolverCasilla() {
		return llena ? ficha.devolverFicha() : " . ";
	}
}
