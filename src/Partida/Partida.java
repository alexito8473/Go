package Partida;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.ConsoleHandler;

import Ficha.Ficha;
import Jugador.Jugador;
import Jugador.JugadorIa;
import Jugador.JugadorReal;
import Tablero.Coordenada;
import Tablero.Tablero;

public class Partida {

	private Jugador jugador1;
	private Jugador jugador2;
	private Tablero tablero;

	private static final String RESET = "\u001B[0m";
	private static final String BLACK = "\u001B[30m";
	private static final String RED = "\u001B[31m";
	private static final String GREEN = "\u001B[32m";
	private static final String YELLOW = "\u001B[33m";
	private static final String BLUE = "\u001B[34m";
	private static final String PURPLE = "\u001B[35m";
	private static final String CYAN = "\u001B[36m";
	private static final String WHITE = "\u001B[37m";
	

	public static final String BLACK_BACKGROUND = "\u001B[40m";
	public static final String RED_BACKGROUND = "\u001B[41m";
	public static final String GREEN_BACKGROUND = "\u001B[42m";
	public static final String YELLOW_BACKGROUND = "\u001B[43m";
	public static final String BLUE_BACKGROUND = "\u001B[44m";
	public static final String PURPLE_BACKGROUND = "\u001B[45m";
	public static final String CYAN_BACKGROUND = "\u001B[46m";
	public static final String WHITE_BACKGROUND = "\u001B[47m";


	public void JugarPartida() {
		boolean finPartida = false;
		int tipoPartida;
		mostraTitulo();
		do {
			tipoPartida = tipoDePartida();
			seleccionJugadores(tipoPartida);
			finPartida = partidaJugadorVSJugador(devolverJugadoresOrdenados());
		} while (finPartida);

	}

	private void mostraTitulo() {
		ConsoleImput con = new ConsoleImput(new Scanner(System.in));
		System.out.print(CYAN);
		con.frasesLentas(
				"  ____     ______      _____     ____    __        __    ____    _____       __________     _________\n"
						+ " |  __|   |  __  |    |  _  \\   |   _|  \\  \\      /  /  |   _|  |  _   \\    /   ____   \\   |___   ___|\n"
						+ " | |  _   | |  | |    | |_|  |  |  |_    \\  \\    /  /   |  |_   | |_|  |    \\  \\___  \\__|      | |\n"
						+ " | | | |  | |  | |    |  _  /   |   _|    \\  \\  /  /    |   _|  |  _  /   __ \\____  \\          | |\n"
						+ " | |_| |  | |__| |    | | \\ \\   |  |_      \\  \\/  /     |  |_   | | \\ \\  \\  \\_____/  /      ___| |___\n"
						+ " |_____|  |______|    |_|  \\_\\  |____|      \\____/      |____|  |_|  \\_\\  \\_________/      |_________|\n",
				1);
		System.out.println(RESET);
	}

	private int tipoDePartida() {
		ConsoleImput con = new ConsoleImput(new Scanner(System.in));
		con.frasesLentas("¿Qué tipo de juego quieres?", 15);
		System.out.print(GREEN);
		con.frasesLentas("1 - Jugador vs Jugador\n2 - Jugador vs ia\n3 - is vs ia", 20);
		System.out.print(RESET + " -> ");
		return con.readIntInRange(1, 3);
	}

	private void mostrarJugadores(Jugador[] jugadores) {
		ConsoleImput con = new ConsoleImput(new Scanner(System.in));
		for (int i = 0; i < jugadores.length; i++) {
			con.frasesLentasSinSalto("El jugador ", 45);
			System.out.print(YELLOW);
			con.frasesLentasSinSalto(jugadores[i].getNombre(),45);
			System.out.print(RESET);
			con.frasesLentasSinSalto(" tiene las ficha ", 45);
			System.out.println(jugadores[i].getFicha().devolverFicha());
		}
		con.frasesLentasSinSalto("Empieza el jugador con la ficha ", 45);
		System.out.println(jugadores[0].getFicha().devolverFicha());
		con.stop(200);
	}

	private void enseñarFinal(Jugador[] jugadores,int turno) {
		System.out.println("\n\n\n");
		ConsoleImput con = new ConsoleImput(new Scanner(System.in));
		tablero.mostrarTablero();
		con.frasesLentas("Se han jugado un total de turnos : "+String.valueOf(turno - 1), 40);
		if(tablero.contador(Ficha.NEGRO)==tablero.contador(Ficha.BLANCO)) {
			con.frasesLentas("Empate entre: "+jugadores[0].getNombre()+" y "+jugadores[1].getNombre(), 15);
		}else {
			con.frasesLentas("Ha ganado el jugador: "+jugadores[turno % 2].getNombre(), 45);
		}
		con.stop(100);
		pintarBandera();
	}
	
	private boolean partidaJugadorVSJugador(Jugador[] jugadores) {
		boolean partida = false;
		int turno = 1;
		ConsoleImput con = new ConsoleImput(new Scanner(System.in));
		mostrarJugadores(jugadores);
		do {
			++turno;
			if (!tablero.finalPartida(jugadores[turno % 2].getFicha())) {
				jugadores[turno % 2].devolverCoordenada(tablero, turno - 1);
			} else {
				con.frasesLentas("El jugador", 15);
				System.out.println(YELLOW + jugadores[turno % 2].getNombre() + RESET);
				con.frasesLentas("No tiene más jugada", 15);
			}
		} while (!tablero.finalPartida(jugadores[0].getFicha()) && !tablero.finalPartida(jugadores[1].getFicha()));
		enseñarFinal(jugadores, turno-1);
		return partida;
	}
	
	private void espacio(int espacio) {
		for (int i = 0; i < espacio; i++) {
			System.out.print(" ");
		}
	}
	public void pintarBandera() {
		int velicidad=8;
		int espacio=35;
		Random ran= new Random();
		ConsoleImput con= new ConsoleImput(new Scanner(System.in));
		System.out.println();
		if(ran.nextInt(2)==0) {		
			espacio(espacio);
			System.out.print(RED_BACKGROUND+BLACK);
			con.frasesLentasSinSalto("  _____   _________   ___   __  \n", velicidad);
			System.out.print(RESET);
			espacio(espacio);
			System.out.print(RED_BACKGROUND+BLACK);
			con.frasesLentasSinSalto(" |   __| |___   ___| |   \\ |  | \n",velicidad);
			System.out.print(RESET);
			espacio(espacio);
			System.out.print(YELLOW_BACKGROUND+BLACK);
			con.frasesLentasSinSalto(" |  |__      | |     |    \\|  | \n",velicidad);
			System.out.print(RESET);
			espacio(espacio);
			System.out.print(YELLOW_BACKGROUND+BLACK);
			con.frasesLentasSinSalto(" |   __|  ___| |___  |  |\\    | \n",velicidad);
			System.out.print(RESET);
			espacio(espacio);
			System.out.print(RED_BACKGROUND+BLACK);
			con.frasesLentasSinSalto(" |__|    |_________| |__| \\___| \n",velicidad);
			System.out.print(RESET);
			espacio(espacio);
			System.out.print(RED_BACKGROUND+BLACK);
			con.frasesLentas("                                ",velicidad);
		}else {
			espacio(espacio);
			System.out.print(GREEN_BACKGROUND+BLACK);
			con.frasesLentasSinSalto("  _____   _________   ___   __  \n", velicidad);
			System.out.print(RESET);
			espacio(espacio);
			System.out.print(GREEN_BACKGROUND+BLACK);
			con.frasesLentasSinSalto(" |   __| |___   ___| |   \\ |  | \n",velicidad);
			System.out.print(RESET);
			espacio(espacio);
			System.out.print(WHITE_BACKGROUND+BLACK);
			con.frasesLentasSinSalto(" |  |__      | |     |    \\|  | \n",velicidad);
			System.out.print(RESET);
			espacio(espacio);
			System.out.print(WHITE_BACKGROUND+BLACK);
			con.frasesLentasSinSalto(" |   __|  ___| |___  |  |\\    | \n",velicidad);
			System.out.print(RESET);
			espacio(espacio);
			System.out.print(GREEN_BACKGROUND+BLACK);
			con.frasesLentasSinSalto(" |__|    |_________| |__| \\___| \n",velicidad);
			System.out.print(RESET);
			espacio(espacio);
			System.out.print(GREEN_BACKGROUND+BLACK);
			con.frasesLentas("                                ",velicidad);
		}
		System.out.println(RESET);
	}
	private Jugador[] devolverJugadoresOrdenados() {
		Jugador[] jugadores = new Jugador[2];
		if (jugador1.getFicha() == Ficha.NEGRO) {
			jugadores[0] = jugador1;
			jugadores[1] = jugador2;
		} else {
			jugadores[0] = jugador2;
			jugadores[1] = jugador1;
		}
		return jugadores;
	}

	private void seleccionJugadores(int numero) {
		ConsoleImput con = new ConsoleImput(new Scanner(System.in));
		Random random = new Random();

		if (numero == 1) {
			switch (random.nextInt(2)) {
			case 0:
				con.frasesLentas("Escribe el nombre del jugador1", 15);
				System.out.print("  -> ");
				jugador1 = new JugadorReal(con.escribirNombre(), Ficha.NEGRO);
				con.frasesLentas("Escribe el nombre del jugador2", 15);
				System.out.print("  -> ");
				jugador2 = new JugadorReal(con.escribirNombre(), Ficha.BLANCO);
				tablero = new Tablero();
				break;
			case 1:
				con.frasesLentas("Escribe el nombre del jugador1", 15);
				System.out.print("  -> ");
				jugador1 = new JugadorReal(con.escribirNombre(), Ficha.BLANCO);
				con.frasesLentas("Escribe el nombre del jugador2", 15);
				System.out.print("  -> ");
				jugador2 = new JugadorReal(con.escribirNombre(), Ficha.NEGRO);
				tablero = new Tablero();
				break;
			}
		} else if (numero == 2) {
			switch (random.nextInt(2)) {
			case 0:
				jugador2 = new JugadorIa(Ficha.BLANCO);
				con.frasesLentas("Escribe el nombre del jugador1", 15);
				System.out.print("  -> ");
				jugador1 = new JugadorReal(con.escribirNombre(), Ficha.NEGRO);
				con.frasesLentas("Escribe el nombre del jugador2", 15);
				System.out.print("  -> ");
				con.stop(500);
				con.frasesLentas(jugador2.getNombre(),40);
				tablero = new Tablero();
				break;
			case 1:
				jugador1 = new JugadorIa(Ficha.NEGRO);
				con.frasesLentas("Escribe el nombre del jugador1", 15);
				System.out.print("  -> ");
				con.stop(500);
				con.frasesLentas(jugador1.getNombre(),40);
				con.frasesLentas("Escribe el nombre del jugador2", 15);
				System.out.print("  -> ");		
				jugador1 = new JugadorReal(con.escribirNombre(), Ficha.BLANCO);
				tablero = new Tablero();
				break;
			}
		} else {
			switch (random.nextInt(2)) {
			case 0:
				jugador1 = new JugadorIa(Ficha.NEGRO);	
				jugador2 = new JugadorIa(Ficha.BLANCO);
				con.frasesLentas("Escribe el nombre del jugador1", 15);
				System.out.print("  -> ");
				con.stop(500);
				con.frasesLentas(jugador1.getNombre(),40);
				con.frasesLentas("Escribe el nombre del jugador2", 15);
				System.out.print("  -> ");
				con.stop(500);
				con.frasesLentas(jugador2.getNombre(),40);
				tablero = new Tablero();
				break;
			case 1:
				jugador1 = new JugadorIa(Ficha.BLANCO);	
				jugador2 = new JugadorIa(Ficha.NEGRO);
				con.frasesLentas("Escribe el nombre del jugador1", 15);
				System.out.print("  -> ");
				con.stop(500);
				con.frasesLentas(jugador1.getNombre(),15);
				con.frasesLentas("Escribe el nombre del jugador2", 15);
				System.out.print("  -> ");
				con.stop(500);
				con.frasesLentas(jugador2.getNombre(),15);
				tablero = new Tablero();
				break;
			}
		}
	}

}
