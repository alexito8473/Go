package Tablero;

import Ficha.Ficha;

public class Casilla {
	
	private boolean llena;
	private Ficha ficha;
	
	public Casilla(boolean llena) {
		setLlena(llena);
	}

	public boolean isLlena() {
		return llena;
	}

	public Casilla meterFicha( Ficha ficha) {
		this.ficha=ficha;
		return this;
	}
	
	public void setFicha(Ficha ficha) {
		this.ficha=ficha;
	}
	
	public Ficha getFicha() {
		return ficha;
	}
	public void setLlena(boolean llena) {
		this.llena = llena;
	}

	public String pintarCasilla() {
		return llena?ficha.pintarFicha():" . ";
	}
}
