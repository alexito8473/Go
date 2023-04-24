package Jugador;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Ficha.Ficha;
import Partida.ConsoleImput;
import Tablero.Coordenada;

public class Jugador {

	private String nombre;
	private Ficha ficha;

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
}
