package Partida;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.ConsoleHandler;

import Ficha.Ficha;
import Jugador.Jugador;
import Jugador.JugadorReal;
import Tablero.Coordenada;
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
		boolean finPartida = false;
		int tipoPartida;
		mostraTitulo();

		do {
			tipoPartida = tipoDePartida();
			seleccionJugadores(tipoPartida);
			if (tipoPartida == 1) {
				finPartida = partidaJugadorVSJugador(devolverJugadoresOrdenados());
			} else if (tipoPartida == 2) {

			} else {

			}
		} while (finPartida);

	}

	private void mostraTitulo() {
		System.out.print(CYAN);
		frasesLentas(
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
		Scanner sc = new Scanner(System.in);
		ConsoleImput con = new ConsoleImput(sc);
		frasesLentas("¿Qué tipo de juego quieres?", 15);
		System.out.print(GREEN);
		frasesLentas("1 - Jugador vs Jugador\n2 - Jugador vs ia\n3 - is vs ia", 20);
		System.out.print(RESET + " -> ");
		return con.readIntInRange(1, 3);
	}

	private void mostrarJugadores(Jugador[] jugadores) {
		for (int i = 0; i < jugadores.length; i++) {
			frasesLentasSinSalto("El jugador ", 45);
			System.out.print(YELLOW + jugadores[i].getNombre() + RESET);
			frasesLentasSinSalto(" tiene las ficha ", 45);
			System.out.println(jugadores[i].getFicha().devolverFicha());
		}
		frasesLentasSinSalto("Empieza el jugador con la ficha ", 45);
		System.out.print(jugadores[0].getFicha().devolverFicha());
	}

	private void contandoFichasMostrando(Jugador jugador, int turno) {
		System.out.printf("%s --------------------------------------%s\n", PURPLE, RESET);
		System.out.printf("%s|%s Le toca al jugador %s%-18s%s%s|%s\n", PURPLE, RESET, YELLOW, jugador.getNombre(),
				RESET, PURPLE, RESET);
		System.out.printf("%s|%s Tiene la ficha %s, turno %-3d        %s|%s\n", PURPLE, RESET,
				jugador.getFicha().devolverFicha(), turno, PURPLE, RESET);
		System.out.printf("%s --------------------------------------%s\n", PURPLE, RESET);
	}

	private boolean partidaJugadorVSJugador(Jugador[] jugadores) {
		boolean partida = false;
		mostrarJugadores(jugadores);
		int turno = 0;
		System.out.println();
		tablero.mostrarTablero();
		do {

			if (!tablero.finalPartida(jugadores[0].getFicha())) {
				partidaJugadorReal(jugadores[0], ++turno);
			} else {
				frasesLentas("El jugador", 15);
				System.out.println(YELLOW + jugadores[0].getNombre() + RESET);
				frasesLentas("No tiene más jugada", 15);
			}
			if (!tablero.finalPartida(jugadores[1].getFicha())) {
				partidaJugadorReal(jugadores[1], ++turno);
			} else {
				frasesLentas("El jugador", 15);

				System.out.println(YELLOW + jugadores[1].getNombre() + RESET);
				frasesLentas("No tiene más jugada", 15);
			}
		} while (!tablero.finalPartida(jugadores[0].getFicha()) && !tablero.finalPartida(jugadores[0].getFicha()));
		System.out.println("Fin de partida");
		return partida;
	}

	private void partidaJugadorReal(Jugador jugadorReal, int turno) {
		Scanner sc = new Scanner(System.in);
		ConsoleImput con = new ConsoleImput(sc);

		boolean seleccionFicha;
		int posicion1, posicion2;
		do {
			contandoFichasMostrando(jugadorReal, turno);
			seleccionFicha = false;
			System.out.println();
			frasesLentas("Posicion de vertical de la ficha(1,2,3,4,5,6,7,8)", 30);
			System.out.print("  -> ");
			posicion1 = con.readIntInRange(1, 8);
			frasesLentas("Posicion de horizontal de la ficha(A,B,C,D,E,F,G,H)", 30);
			System.out.print("  -> ");
			posicion2 = con.readChar("ABCDEFGH") - 64;

			if (!tablero.comprobarSiHayFichaPuesta(posicion1 - 1, posicion2 - 1)) {
				if (tablero.movimientoValido(jugadorReal.getFicha(), new Coordenada(posicion1 - 1, posicion2 - 1))) {
					seleccionFicha = true;
					tablero.añadirFichaTablero(jugadorReal.getFicha(), posicion1 - 1, posicion2 - 1);
					tablero.mostrarTablero();
				} else {
					frasesLentas("El movimiento es invalido", 15);
				}
			} else {
				frasesLentas("Ya hay una ficha puesta", 15);
			}
		} while (!seleccionFicha);

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

		Random random = new Random();
		if (numero == 1) {
			switch (random.nextInt(2)) {
			case 0:
				frasesLentas("Escribe el nombre del jugador1", 15);
				System.out.print("  -> ");
				jugador1 = new JugadorReal(escribirNombre(), Ficha.NEGRO);
				frasesLentas("Escribe el nombre del jugador2", 15);
				System.out.print("  -> ");
				jugador2 = new JugadorReal(escribirNombre(), Ficha.BLANCO);
				tablero = new Tablero();
				break;
			case 1:
				frasesLentas("Escribe el nombre del jugador1", 15);
				System.out.print("  -> ");
				jugador1 = new JugadorReal(escribirNombre(), Ficha.BLANCO);
				frasesLentas("Escribe el nombre del jugador2", 15);
				System.out.print("  -> ");
				jugador2 = new JugadorReal(escribirNombre(), Ficha.NEGRO);
				tablero = new Tablero();
				break;
			}
		} else if (numero == 2) {

		} else {

		}
	}

	private void frasesLentasSinSalto(String frase, int numero) {
		for (int i = 0; i < frase.length(); i++) {
			System.out.print(frase.charAt(i));
			try {
				TimeUnit.MILLISECONDS.sleep(numero);
			} catch (InterruptedException e) {
			}
		}
	}

	@SuppressWarnings("resource")
	private String escribirNombre() {
		Scanner sc = new Scanner(System.in);
		String palabra;
		do {
			palabra = sc.nextLine();
			if (palabra.length() == 0) {
				System.out.println("Escribe un buen nombre");
			}
		} while (!(palabra.length() > 0));
		return palabra;
	}

	private void frasesLentas(String frase, int numero) {
		for (int i = 0; i < frase.length(); i++) {
			System.out.print(frase.charAt(i));

			try {
				TimeUnit.MILLISECONDS.sleep(numero);
			} catch (InterruptedException e) {

			}
		}
		System.out.println();
	}

}
