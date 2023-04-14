package Partida;

import java.util.Scanner;

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
		
	}
	
	private void mostraTitulo() {
		
	}
	private int tipoDePartida() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Elige el sistema");
		
		return 1;
	}
	
	private void frasesLentas(String frase) {
		for(int i=0;i<frase.length();i++) {
			System.out.println(frase.charAt(i));
		}
	}
}
