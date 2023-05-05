package Tablero;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(coordenada, ficha, llena);
	}

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
