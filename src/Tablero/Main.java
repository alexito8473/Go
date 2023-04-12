package Tablero;

import Fichas.Ficha;

public class Main {
	private void empezarPartida() {
		Tablero tablero= new Tablero();
		tablero.mostrarTablero();
		
		System.out.println();
		
		System.out.println("Blanco "+tablero.finalPartida(Ficha.BLANCO));
		System.out.println("Negro "+tablero.finalPartida(Ficha.NEGRO));
	
	}
	public static void main(String[] args) {
		new Main().empezarPartida();
	}
}
