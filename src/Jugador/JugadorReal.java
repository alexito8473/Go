package Jugador;

import java.util.Scanner;

import Ficha.Ficha;
import Partida.ConsoleImput;
import Tablero.Coordenada;
import Tablero.Tablero;

public class JugadorReal extends Jugador {

	public JugadorReal(String nombre, Ficha ficha) {
		super(nombre, ficha);
	}

	public void jugada(Tablero tablero, int turno) {
		ConsoleImput con = new ConsoleImput(new Scanner(System.in));
		do {
			tablero.mostrarTablero(ficha);
			tablero.contandoFichasMostrando(this, turno);
		} while (!ponerFicha(pedirDatos(con), tablero, con));
	}

	private boolean ponerFicha(Coordenada coordenada, Tablero tablero, ConsoleImput con) {
		if (!tablero.comprobarSiHayFichaPuesta(coordenada)) {
			if (tablero.movimientoValido(ficha, coordenada)) {
				tablero.mostrarTablero(coordenada);
				tablero.anadirFichaTablero(ficha, coordenada);
				con.stop(800);
				return true;
			} else {
				con.frasesLentas("El movimiento es invalido", 15);
			}
		} else {
			con.frasesLentas("Ya hay una ficha puesta", 15);
		}
		return false;
	}

	private Coordenada pedirDatos(ConsoleImput con) {
		int posicion1, posicion2;
		System.out.println();
		con.frasesLentas("Posición vertical(1,2,3,4,5,6,7,8)", 20);
		System.out.print("  -> ");
		posicion1 = con.readIntInRange(1, 8) - 1;
		con.frasesLentas("Posición horizontal(A,B,C,D,E,F,G,H)", 20);
		System.out.print("  -> ");
		posicion2 = Character.toUpperCase(con.readChar("ABCDEFGHabcdefgh")) - 65;
		return new Coordenada(posicion1, posicion2);
	}

}
