package Tablero;

import Ficha.Ficha;

public class Main {
	private void empezarPartida() {
		Tablero tablero= new Tablero();
		tablero.mostrarTablero();
		
		System.out.println();
		
		tablero.añadirFichaTablero(Ficha.BLANCO, 5, 3);
		System.out.println("Negro "+tablero.finalPartida(Ficha.NEGRO));

		System.out.println();
		tablero.mostrarTablero();
	
	}
	public static void main(String[] args) {
		new Main().empezarPartida();
	}
}
