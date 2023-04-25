package Jugador;

import Ficha.Ficha;
import Tablero.Coordenada;
import Tablero.Tablero;

public class Main {
	private void prueba() {
		Tablero tablero = new Tablero();
		JugadorIa jugador = new JugadorIa(Ficha.BLANCO);
		tablero.mostrarTablero(Ficha.BLANCO);
		tablero.añadirFichaTablero(Ficha.BLANCO, 3, 0);
		tablero.añadirFichaTablero(Ficha.NEGRO, 3, 1);
		tablero.añadirFichaTablero(Ficha.NEGRO, 3, 2);
		tablero.añadirFichaTablero(Ficha.NEGRO, 3, 4);
		tablero.añadirFichaTablero(Ficha.NEGRO, 3, 6);
		tablero.añadirFichaTablero(Ficha.BLANCO, 3, 7);
		tablero.mostrarTablero(Ficha.BLANCO);
		tablero.añadirFichaTablero(Ficha.BLANCO, 5, 0);
		tablero.añadirFichaTablero(Ficha.NEGRO, 5, 1);
		tablero.añadirFichaTablero(Ficha.NEGRO, 5, 3);
		tablero.añadirFichaTablero(Ficha.NEGRO, 5, 2);
		tablero.añadirFichaTablero(Ficha.NEGRO, 5, 4);
		tablero.añadirFichaTablero(Ficha.NEGRO, 5, 6);
		tablero.añadirFichaTablero(Ficha.BLANCO, 5, 7);
		tablero.añadirFichaTablero(Ficha.NEGRO, 6, 5);
		tablero.añadirFichaTablero(Ficha.BLANCO, 7, 5);
		System.out.println(jugador.devolverCoordenada(tablero, 1));
		tablero.mostrarTablero(Ficha.BLANCO);
	}

	public static void main(String[] args) {
		new Main().prueba();
	}
}
