package Partida;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.ConsoleHandler;

import Ficha.Ficha;
import Jugador.Jugador;
import Jugador.JugadorReal;
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
		boolean finPartida=false;
		int tipoPartida;
		mostraTitulo();

		do {
			tipoPartida=tipoDePartida();
			seleccionJugadores(tipoPartida);
			if(tipoPartida==1) {
				finPartida=partidaJugadorVSJugador(devolverJugadoresOrdenados());
			}else if(tipoPartida==2) {
				
			}else {
				
			}
		}while(finPartida);
		
	}
	
	private void mostraTitulo() {
		System.out.print(CYAN);
		frasesLentas("  ____     ______      _____     ____    __        __    ____    _____       __________     _________\n"
					+" |  __|   |  __  |    |  _  \\   |   _|  \\  \\      /  /  |   _|  |  _   \\    /   ____   \\   |___   ___|\n"
					+" | |  _   | |  | |    | |_|  |  |  |_    \\  \\    /  /   |  |_   | |_|  |    \\  \\___  \\__|      | |\n"    
					+" | | | |  | |  | |    |  _  /   |   _|    \\  \\  /  /    |   _|  |  _  /   __ \\____  \\          | |\n"
					+" | |_| |  | |__| |    | | \\ \\   |  |_      \\  \\/  /     |  |_   | | \\ \\  \\  \\_____/  /      ___| |___\n"
					+" |_____|  |______|    |_|  \\_\\  |____|      \\____/      |____|  |_|  \\_\\  \\_________/      |_________|\n",1);
		System.out.println(RESET);
	}
	
	
	private int tipoDePartida() {
		Scanner sc = new Scanner(System.in);
		ConsoleImput con = new ConsoleImput(sc);
		frasesLentas("¿Qué tipo de juego quieres?",15);
		System.out.print(GREEN);
		frasesLentas("1 - Jugador vs Jugador\n2 - Jugador vs ia\n3 - is vs ia",20);
		System.out.print(RESET+" -> ");
		return con.readIntInRange(1, 3);
	}
	
	private boolean partidaJugadorVSJugador(Jugador[] jugadores) {
		boolean partida = false;
		System.out.printf("El jugador %s tiene las ficha %s\nEl jugador %s tiene la ficha %s\nEmpieza el jugador con la ficha %s", jugadores[0].getNombre(),jugadores[0].getFicha().devolverFicha(),jugadores[1].getNombre(),jugadores[1].getFicha().devolverFicha(),jugadores[0].getFicha().devolverFicha());
		do {
			tablero.mostrarTablero();
			if(!tablero.finalPartida(jugadores[0].getFicha())) {
				
			}
			if(!tablero.finalPartida(jugadores[1].getFicha())) {
				
			}
		}while(tablero.finalPartida(jugadores[0].getFicha())&&tablero.finalPartida(jugadores[0].getFicha()));
		return partida;
	}
	
	private Jugador[] devolverJugadoresOrdenados() {
		Jugador[] jugadores= new Jugador[2];
		if(jugador1.getFicha()==Ficha.NEGRO) {
			jugadores[0]=jugador1;
			jugadores[1]=jugador2;
		}else {
			jugadores[0]=jugador2;
			jugadores[1]=jugador1;
		}
		return jugadores;
	}
	
	private void seleccionJugadores(int numero) {
		Scanner sc = new Scanner(System.in);
		Random random= new Random();
		if(numero==1) {
			switch (random.nextInt(2)) {
			case 0:
				frasesLentas("Escribe el nombre del jugador1",15);
				jugador1 = new JugadorReal(sc.nextLine(),Ficha.NEGRO);
				frasesLentas("Escribe el nombre del jugador2",15);
				jugador2 = new JugadorReal(sc.nextLine(),Ficha.BLANCO);
				tablero= new Tablero();
				break;
			case 1:
				frasesLentas("Escribe el nombre del jugador1",15);
				jugador1 = new JugadorReal(sc.nextLine(),Ficha.BLANCO);
				frasesLentas("Escribe el nombre del jugador2",15);
				jugador2 = new JugadorReal(sc.nextLine(),Ficha.NEGRO);
				tablero= new Tablero();
				break;
			}
		}else if(numero==2){
			
		}else {
			
		}
	}
	
	private void frasesLentas(String frase, int numero) {
		for(int i=0;i<frase.length();i++) {
			System.out.print(frase.charAt(i));
			
			try {
				TimeUnit.MILLISECONDS.sleep(numero);
			} catch (InterruptedException e) {

			}
		}
		System.out.println();
	}
	
}
