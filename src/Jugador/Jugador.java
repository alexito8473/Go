package Jugador;

import Ficha.Ficha;

public class Jugador {
	
	private String nombre;
	private Ficha ficha;
	
	public Jugador(String nombre,Ficha ficha) {
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
}
