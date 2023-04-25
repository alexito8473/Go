package Tablero;

import Ficha.Ficha;

public class Casilla {

	private boolean jugada;
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

	public void setJugada(boolean jugada) {
		this.jugada = jugada;
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

	public String pintarCasilla() {
		String GREEN = "\u001B[32m";
		String RESET = "\u001B[0m";
		return jugada ? GREEN + " ☆ " + RESET : llena ? ficha.devolverFicha() : " . ";
	}
}
