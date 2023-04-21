package Tablero;

import Ficha.Ficha;

public class Main {
	private void empezarPartida() {
		Tablero tablero = new Tablero();
		tablero.mostrarTablero();

		System.out.println();

		System.out.println("Negro " + tablero.finalPartida(Ficha.NEGRO));
		tablero.añadirFichaTablero(Ficha.BLANCO, 7, 1);
		tablero.añadirFichaTablero(Ficha.BLANCO, 7, 2);
		tablero.añadirFichaTablero(Ficha.BLANCO, 7, 3);
		tablero.añadirFichaTablero(Ficha.BLANCO, 7, 4);
		tablero.añadirFichaTablero(Ficha.BLANCO, 7, 5);
		tablero.añadirFichaTablero(Ficha.BLANCO, 7, 6);
		tablero.añadirFichaTablero(Ficha.NEGRO, 7, 0);
		tablero.mostrarTablero();
		tablero.añadirFichaTablero(Ficha.NEGRO, 7, 7);
		tablero.mostrarTablero();
	}

	public static void main(String[] args) {
		new Main().empezarPartida();
	}
}
