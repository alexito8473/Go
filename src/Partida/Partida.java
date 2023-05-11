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
	private final ConsoleImput con = new ConsoleImput(new Scanner(System.in));

	public void jugarPartida() {
		do {
		} while (partidaJugadorVSJugador(selecciónJugadores(tipoDePartida())));
	}

	private int tipoDePartida() {
		mostrarTitulo();
		con.frasesLentas("¿Qué tipo de juego quieres?", 15);
		System.out.print(Colors.GREEN);
		con.frasesLentas("1 - Jugador vs Jugador\n2 - Jugador vs Ia\n3 - Ia vs Ia", 20);
		System.out.print(Colors.RESET + " -> ");
		return con.readIntInRange(1, 3);
	}

	private boolean partidaJugadorVSJugador(Jugador[] jugadores) {
		boolean salida = false;
		int turno = 0, numero = 1;
		mostrarJugadores(jugadores);
		do {
			turno++;
			numero = Math.abs(numero - 1);
			if (!tablero.fin(jugadores[numero].getFicha())) {
				jugadores[numero].jugada(tablero, turno);
			} else {
				tablero.contandoFichasMostrando(jugador1, turno);
				System.out.print("\t");
				con.frasesLentas("-----> Se quedo sin jugada <-----", 45);
			}

			if (tablero.fin(jugadores[1].getFicha()) && tablero.fin(jugadores[0].getFicha())) {
				salida = true;
			}
		} while (!salida);

		enseñarFinal(jugadores, turno, tablero);
		con.frasesLentas("¿Quieres jugar otra partida?(Si,No)", 20);
		con.frasesLentas(" -> ", 15);
		return con.readBooleanUsingString("Si", "no");
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

	private Jugador[] selecciónJugadores(int numero) {
		if (numero == 1) {
			switch (new Random().nextInt(2)) {
			case 0:
				con.frasesLentasSinSalto("Escribe el nombre del jugador1\n  -> ", 15);
				jugador1 = new JugadorReal(con.escribirNombre(), Ficha.NEGRO);
				con.frasesLentasSinSalto("Escribe el nombre del jugador2\n  -> ", 15);
				jugador2 = new JugadorReal(con.escribirNombre(), Ficha.BLANCO);
				break;
			case 1:
				con.frasesLentas("Escribe el nombre del jugador1", 15);
				System.out.print("  -> ");
				jugador1 = new JugadorReal(con.escribirNombre(), Ficha.BLANCO);
				con.frasesLentas("Escribe el nombre del jugador2", 15);
				System.out.print("  -> ");
				jugador2 = new JugadorReal(con.escribirNombre(), Ficha.NEGRO);
				break;
			}
		} else if (numero == 2) {
			switch (new Random().nextInt(2)) {
			case 0 -> {
				jugador2 = new JugadorIa(Ficha.BLANCO);
				con.frasesLentas("Escribe el nombre del jugador1", 15);
				System.out.print("  -> ");
				jugador1 = new JugadorReal(con.escribirNombre(), Ficha.NEGRO);
				con.frasesLentas("Escribe el nombre del jugador2", 15);
				System.out.print("  -> ");
				con.stop(500);
				nombreAmarillo(jugador2);
				System.out.println();
			}
			case 1 -> {
				jugador1 = new JugadorIa(Ficha.NEGRO);
				con.frasesLentas("Escribe el nombre del jugador1", 15);
				System.out.print("  -> ");
				con.stop(500);
				nombreAmarillo(jugador1);
				System.out.println();
				con.frasesLentas("Escribe el nombre del jugador2", 15);
				System.out.print("  -> ");
				jugador2 = new JugadorReal(con.escribirNombre(), Ficha.BLANCO);
			}
			}
		} else {
			switch (new Random().nextInt(2)) {
			case 0:
				jugador1 = new JugadorIa(Ficha.NEGRO);
				jugador2 = new JugadorIa(Ficha.BLANCO);
				con.frasesLentasSinSalto("Escribe el nombre del jugador1\n  -> ", 15);
				con.stop(500);
				nombreAmarillo(jugador1);
				System.out.println();
				con.frasesLentasSinSalto("Escribe el nombre del jugador2\n  -> ", 15);
				con.stop(500);
				nombreAmarillo(jugador2);
				System.out.println();
				break;
			case 1:
				jugador1 = new JugadorIa(Ficha.BLANCO);
				jugador2 = new JugadorIa(Ficha.NEGRO);
				con.frasesLentas("Escribe el nombre del jugador1", 15);
				System.out.print("  -> ");
				con.stop(500);
				nombreAmarillo(jugador1);
				System.out.println();
				con.frasesLentas("Escribe el nombre del jugador2", 15);
				System.out.print("  -> ");
				con.stop(500);
				nombreAmarillo(jugador2);
				System.out.println();

				break;
			}
		}
		tablero = new Tablero();
		return devolverJugadoresOrdenados();
	}

	private void mostrarJugadores(Jugador[] jugadores) {
		int stop = 45;
		for (int i = 0; i < jugadores.length; i++) {
			con.frasesLentasSinSalto("El jugador ", stop);
			nombreAmarillo(jugadores[i]);
			con.frasesLentasSinSalto(" tiene las ficha ", stop);
			System.out.println(jugadores[i].getFicha().devolverFicha());
		}
		con.frasesLentasSinSalto("Empieza el jugador con la ficha ", stop);
		System.out.println(jugadores[0].getFicha().devolverFicha());
		con.stop(200);
	}

	private void enseñarFinal(Jugador[] jugadores, int turno, Tablero tablero) {
		int stop = 15;
		System.out.println("\n\n\n");
		tablero.mostrarTablero();
		con.frasesLentas("Se han jugado un total de turnos : " + String.valueOf(turno), 40);
		if (tablero.contador(Ficha.NEGRO) == tablero.contador(Ficha.BLANCO)) {
			con.frasesLentasSinSalto("Empate entre: ", stop);
			nombreAmarillo(jugadores[0]);
			con.frasesLentasSinSalto(" y ", stop);
			nombreAmarillo(jugadores[1]);
			System.out.println();
			con.frasesLentasSinSalto("El jugador ", stop);
			nombreAmarillo(jugadores[0]);
			con.frasesLentasSinSalto("tiene un total de ", stop);
			System.out.print(tablero.contador(jugadores[0].getFicha()));
			System.out.println();
			con.frasesLentasSinSalto("El jugador ", stop);
			nombreAmarillo(jugadores[0]);
			con.frasesLentasSinSalto("tiene un total de ", stop);
			System.out.print(tablero.contador(jugadores[0].getFicha()));
		} else {
			con.frasesLentasSinSalto("Ha ganado el jugador: ", stop);
			nombreAmarillo(
					tablero.contador(jugadores[0].getFicha()) > tablero.contador(jugadores[1].getFicha()) ? jugadores[0]
							: jugadores[1]);
		}
		System.out.printf("\nFichas negras: %-3dFichas Blancas: %-3d\n", tablero.contador(Ficha.NEGRO),
				tablero.contador(Ficha.BLANCO));

		con.stop(100);
		pintarBandera();
	}

	private void nombreAmarillo(Jugador jugador) {
		System.out.print(Colors.YELLOW);
		con.frasesLentasSinSalto(jugador.getNombre(), 15);
		System.out.print(Colors.RESET);
	}

	private void espacio(int espacio) {
		for (int i = 0; i < espacio; i++) {
			System.out.print(" ");
		}
	}

	private void mostrarTitulo() {
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

	public void pintarBandera() {
		int velocidad = 8, espacio = 35, numero = new Random().nextInt(2);
		System.out.println();
		espacio(espacio);
		System.out.print((numero == 0 ? Colors.RED_BACKGROUND : Colors.GREEN_BACKGROUND) + Colors.BLACK);
		con.frasesLentas("  _____   _________   ___   __  ", velocidad);
		System.out.print(Colors.RESET);
		espacio(espacio);
		System.out.print((numero == 0 ? Colors.RED_BACKGROUND : Colors.GREEN_BACKGROUND) + Colors.BLACK);
		con.frasesLentas(" |   __| |___   ___| |   \\ |  | ", velocidad);
		System.out.print(Colors.RESET);
		espacio(espacio);
		System.out.print((numero == 0 ? Colors.YELLOW_BACKGROUND : Colors.WHITE_BACKGROUND) + Colors.BLACK);
		con.frasesLentas(" |  |__      | |     |    \\|  | ", velocidad);
		System.out.print(Colors.RESET);
		espacio(espacio);
		System.out.print((numero == 0 ? Colors.YELLOW_BACKGROUND : Colors.WHITE_BACKGROUND) + Colors.BLACK);
		con.frasesLentas(" |   __|  ___| |___  |  |\\    | ", velocidad);
		System.out.print(Colors.RESET);
		espacio(espacio);
		System.out.print((numero == 0 ? Colors.RED_BACKGROUND : Colors.GREEN_BACKGROUND) + Colors.BLACK);
		con.frasesLentas(" |__|    |_________| |__| \\___| ", velocidad);
		System.out.print(Colors.RESET);
		espacio(espacio);
		System.out.print((numero == 0 ? Colors.RED_BACKGROUND : Colors.GREEN_BACKGROUND) + Colors.BLACK);
		con.frasesLentas("                                ", velocidad);
		System.out.println(Colors.RESET);
	}
}
