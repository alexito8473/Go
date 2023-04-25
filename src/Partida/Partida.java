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
				finPartida = partidaJugadorVSJugador(devolverJugadoresOrdenados());
			}
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
			System.out.print(YELLOW + jugadores[i].getNombre() + RESET);
			con.frasesLentasSinSalto(" tiene las ficha ", 45);
			System.out.println(jugadores[i].getFicha().devolverFicha());
		}
		con.frasesLentasSinSalto("Empieza el jugador con la ficha ", 45);
		System.out.println(jugadores[0].getFicha().devolverFicha());
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

		con.frasesLentasSinSalto("Se han jugado un total de turnos : ", 15);
		System.out.print(turno - 1);
		con.frasesLentasSinSalto("Ha ganado el jugador ", 15);
		System.out.print(jugadores[turno % 2].getNombre());
		System.out.println("Fin de partida");
		return partida;
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

		} else {
			switch (random.nextInt(2)) {
			case 0:
				jugador1 = new JugadorIa(Ficha.NEGRO);	
				jugador2 = new JugadorIa(Ficha.BLANCO);
				con.frasesLentas("Escribe el nombre del jugador1", 15);
				System.out.print("  -> ");
				con.frasesLentas(jugador1.getNombre(),15);
				con.frasesLentas("Escribe el nombre del jugador2", 15);
				System.out.print("  -> ");
				con.frasesLentas(jugador2.getNombre(),15);
				tablero = new Tablero();
				break;
			case 1:
				break;
			}
		}
	}

}
