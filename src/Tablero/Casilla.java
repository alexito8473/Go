package Tablero;

import Ficha.Ficha;

public class Casilla {
	
	private boolean llena;
	private Ficha ficha;
	
	public Casilla() {
		llena=false;
	}
	
	public Casilla(Ficha ficha) {
		this.ficha=ficha;
		llena=true;
	}
	
	public boolean isLlena() {
		return llena;
	}
	
	public void setFicha(Ficha ficha) {
		this.ficha=ficha;
		llena=true;
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
