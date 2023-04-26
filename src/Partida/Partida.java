package Partida;

import java.util.Random;
import java.util.Scanner;
import Ficha.Ficha;
import Jugador.Jugador;
import Jugador.JugadorIa;
import Jugador.JugadorReal;
import Tablero.Tablero;

public class Partida {

	private Jugador jugador1;
	private Jugador jugador2;
	private Tablero tablero;
	private ConsoleImput con = new ConsoleImput(new Scanner(System.in));

	public void JugarPartida() {
		mostraTitulo();
		do {
			seleccionJugadores(tipoDePartida());
		} while (partidaJugadorVSJugador(devolverJugadoresOrdenados()));
	}

	private void mostraTitulo() {
		System.out.print(Colors.CYAN);
		con.frasesLentas(
				"  ____     ______      _____     ____    __        __    ____    _____       __________     _________\n"
						+ " |  __|   |  __  |    |  _  \\   |   _|  \\  \\      /  /  |   _|  |  _   \\    /   ____   \\   |___   ___|\n"
						+ " | |  _   | |  | |    | |_|  |  |  |_    \\  \\    /  /   |  |_   | |_|  |    \\  \\___  \\__|      | |\n"
						+ " | | | |  | |  | |    |  _  /   |   _|    \\  \\  /  /    |   _|  |  _  /   __ \\____  \\          | |\n"
						+ " | |_| |  | |__| |    | | \\ \\   |  |_      \\  \\/  /     |  |_   | | \\ \\  \\  \\_____/  /      ___| |___\n"
						+ " |_____|  |______|    |_|  \\_\\  |____|      \\____/      |____|  |_|  \\_\\  \\_________/      |_________|\n",
				1);
		System.out.println(Colors.RESET);
	}

	private int tipoDePartida() {
		con.frasesLentas("¿Qué tipo de juego quieres?", 15);
		System.out.print(Colors.GREEN);
		con.frasesLentas("1 - Jugador vs Jugador\n2 - Jugador vs ia\n3 - is vs ia", 20);
		System.out.print(Colors.RESET + " -> ");
		return con.readIntInRange(1, 3);
	}

	private void mostrarJugadores(Jugador[] jugadores) {
		for (int i = 0; i < jugadores.length; i++) {
			con.frasesLentasSinSalto("El jugador ", 45);
			System.out.print(Colors.YELLOW);
			con.frasesLentasSinSalto(jugadores[i].getNombre(), 45);
			System.out.print(Colors.RESET);
			con.frasesLentasSinSalto(" tiene las ficha ", 45);
			System.out.println(jugadores[i].getFicha().devolverFicha());
		}
		con.frasesLentasSinSalto("Empieza el jugador con la ficha ", 45);
		System.out.println(jugadores[0].getFicha().devolverFicha());
		con.stop(200);
	}

	private void enseñarFinal(Jugador[] jugadores, int turno) {
		System.out.println("\n\n\n");
		tablero.mostrarTablero();
		con.frasesLentas("Se han jugado un total de turnos : " + String.valueOf(turno - 1), 40);
		if (tablero.contador(Ficha.NEGRO) == tablero.contador(Ficha.BLANCO)) {
			con.frasesLentas("Empate entre: " + jugadores[0].getNombre() + " y " + jugadores[1].getNombre(), 15);
		} else {
			con.frasesLentas("Ha ganado el jugador: " + jugadores[turno % 2].getNombre(), 45);
		}
		con.stop(100);
		pintarBandera();
	}

	private boolean partidaJugadorVSJugador(Jugador[] jugadores) {
		boolean partida = false;
		int turno = 1;
		mostrarJugadores(jugadores);
		do {
			++turno;
			if (!tablero.finalPartida(jugadores[turno % 2].getFicha())) {
				jugadores[turno % 2].jugada(tablero, turno - 1);
			} else {
				con.frasesLentas("El jugador", 15);
				System.out.println(Colors.YELLOW + jugadores[turno % 2].getNombre() + Colors.RESET);
				con.frasesLentas("No tiene más jugada", 15);
			}
		} while (!tablero.finalPartida(jugadores[0].getFicha()) && !tablero.finalPartida(jugadores[1].getFicha()));
		enseñarFinal(jugadores, turno - 1);
		con.frasesLentas("¿Quieres jugar otra partida?(Si,No)", 20);
		System.out.println(" -> ");
		partida = con.readBooleanUsingString("Si", "no");
		return partida;
	}

	private void espacio(int espacio) {
		for (int i = 0; i < espacio; i++) {
			System.out.print(" ");
		}
	}

	public void pintarBandera() {
		int velicidad = 8;
		int espacio = 35;
		Random ran = new Random();
		System.out.println();
		if (ran.nextInt(2) == 0) {
			espacio(espacio);
			System.out.print(Colors.RED_BACKGROUND + Colors.BLACK);
			con.frasesLentasSinSalto("  _____   _________   ___   __  \n", velicidad);
			System.out.print(Colors.RESET);
			espacio(espacio);
			System.out.print(Colors.RED_BACKGROUND + Colors.BLACK);
			con.frasesLentasSinSalto(" |   __| |___   ___| |   \\ |  | \n", velicidad);
			System.out.print(Colors.RESET);
			espacio(espacio);
			System.out.print(Colors.YELLOW_BACKGROUND + Colors.BLACK);
			con.frasesLentasSinSalto(" |  |__      | |     |    \\|  | \n", velicidad);
			System.out.print(Colors.RESET);
			espacio(espacio);
			System.out.print(Colors.YELLOW_BACKGROUND + Colors.BLACK);
			con.frasesLentasSinSalto(" |   __|  ___| |___  |  |\\    | \n", velicidad);
			System.out.print(Colors.RESET);
			espacio(espacio);
			System.out.print(Colors.RED_BACKGROUND + Colors.BLACK);
			con.frasesLentasSinSalto(" |__|    |_________| |__| \\___| \n", velicidad);
			System.out.print(Colors.RESET);
			espacio(espacio);
			System.out.print(Colors.RED_BACKGROUND + Colors.BLACK);
			con.frasesLentas("                                ", velicidad);
		} else {
			espacio(espacio);
			System.out.print(Colors.GREEN_BACKGROUND + Colors.BLACK);
			con.frasesLentasSinSalto("  _____   _________   ___   __  \n", velicidad);
			System.out.print(Colors.RESET);
			espacio(espacio);
			System.out.print(Colors.GREEN_BACKGROUND + Colors.BLACK);
			con.frasesLentasSinSalto(" |   __| |___   ___| |   \\ |  | \n", velicidad);
			System.out.print(Colors.RESET);
			espacio(espacio);
			System.out.print(Colors.WHITE_BACKGROUND + Colors.BLACK);
			con.frasesLentasSinSalto(" |  |__      | |     |    \\|  | \n", velicidad);
			System.out.print(Colors.RESET);
			espacio(espacio);
			System.out.print(Colors.WHITE_BACKGROUND + Colors.BLACK);
			con.frasesLentasSinSalto(" |   __|  ___| |___  |  |\\    | \n", velicidad);
			System.out.print(Colors.RESET);
			espacio(espacio);
			System.out.print(Colors.GREEN_BACKGROUND + Colors.BLACK);
			con.frasesLentasSinSalto(" |__|    |_________| |__| \\___| \n", velicidad);
			System.out.print(Colors.RESET);
			espacio(espacio);
			System.out.print(Colors.GREEN_BACKGROUND + Colors.BLACK);
			con.frasesLentas("                                ", velicidad);
		}
		System.out.println(Colors.RESET);
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
				con.frasesLentas(jugador2.getNombre(), 40);
				tablero = new Tablero();
				break;
			case 1:
				jugador1 = new JugadorIa(Ficha.NEGRO);
				con.frasesLentas("Escribe el nombre del jugador1", 15);
				System.out.print("  -> ");
				con.stop(500);
				con.frasesLentas(jugador1.getNombre(), 40);
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
				con.frasesLentas(jugador1.getNombre(), 40);
				con.frasesLentas("Escribe el nombre del jugador2", 15);
				System.out.print("  -> ");
				con.stop(500);
				con.frasesLentas(jugador2.getNombre(), 40);
				tablero = new Tablero();
				break;
			case 1:
				jugador1 = new JugadorIa(Ficha.BLANCO);
				jugador2 = new JugadorIa(Ficha.NEGRO);
				con.frasesLentas("Escribe el nombre del jugador1", 15);
				System.out.print("  -> ");
				con.stop(500);
				con.frasesLentas(jugador1.getNombre(), 15);
				con.frasesLentas("Escribe el nombre del jugador2", 15);
				System.out.print("  -> ");
				con.stop(500);
				con.frasesLentas(jugador2.getNombre(), 15);
				tablero = new Tablero();
				break;
			}
		}
	}

}
