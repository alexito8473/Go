package Tablero;

import Ficha.Ficha;

public class Main {
	private void empezarPartida() {
		Tablero tablero= new Tablero();
		tablero.mostrarTablero();
		
		System.out.println();
	
		System.out.println("Negro "+tablero.finalPartida(Ficha.NEGRO));
		tablero.añadirFichaTablero(Ficha.BLANCO, 5, 3);
		System.out.println();
		tablero.mostrarTablero();
		tablero.añadirFichaTablero(Ficha.NEGRO, 2, 3);
		tablero.mostrarTablero();
		tablero.añadirFichaTablero(Ficha.NEGRO, 6, 3);
		tablero.mostrarTablero();
		tablero.añadirFichaTablero(Ficha.BLANCO, 2, 4);
		tablero.mostrarTablero();
		tablero.añadirFichaTablero(Ficha.NEGRO, 1, 4);
		tablero.mostrarTablero();
		tablero.añadirFichaTablero(Ficha.NEGRO, 5, 4);
		tablero.mostrarTablero();
	
	}
	public static void main(String[] args) {
		new Main().empezarPartida();
	}
}
