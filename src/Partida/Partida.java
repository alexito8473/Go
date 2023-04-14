package Partida;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Jugador.Jugador;
import Tablero.Tablero;

public class Partida {
	
	private Jugador jugador1;
	private Jugador jugador2;
	private Tablero tablero;
	
	public static final String RESET = "\u001B[0m";
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	
	public void JugarPartida() {
		frasesLentas("Esto es una prueba");
	}
	
	private void mostraTitulo() {
		
	}
	private int tipoDePartida() {
		Scanner sc = new Scanner(System.in);
		frasesLentas("¿Qué tipo de juego quieres?\n"
				+ "");
		System.out.printf("Elige el sistema");
		
		return 1;
	}
	
	private void frasesLentas(String frase) {
		for(int i=0;i<frase.length();i++) {
			System.out.print(frase.charAt(i));
			try {
				TimeUnit.MILLISECONDS.sleep(15);
			} catch (InterruptedException e) {

			}
		}
		System.out.println();
	}
	
}
