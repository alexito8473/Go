package Jugador;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Ficha.Ficha;
import Partida.ConsoleImput;
import Tablero.Casilla;
import Tablero.Comprobacion;
import Tablero.Coordenada;
import Tablero.Tablero;

public class JugadorReal extends Jugador {

	public JugadorReal(String nombre, Ficha ficha) {
		super(nombre, ficha);
	}

	public void devolverCoordenada(Tablero tablero, int turno) {
		Coordenada coordenada;
		boolean seleccionFicha;
		ConsoleImput con = new ConsoleImput(new Scanner(System.in));
		tablero.mostrarTablero(ficha);
		do {
			tablero.contandoFichasMostrando(this, turno);
			seleccionFicha = false;
			coordenada = pedirDatos();
			if (!tablero.comprobarSiHayFichaPuesta(coordenada)) {
				if (tablero.movimientoValido(ficha, coordenada)) {
					seleccionFicha = true;
					tablero.añadirFichaTablero(ficha, coordenada.getPosicion1(), coordenada.getPosicion2());
				} else {
					con.frasesLentas("El movimiento es invalido", 15);
					tablero.mostrarTablero(ficha);
				}
			} else {
				con.frasesLentas("Ya hay una ficha puesta", 15);
				tablero.mostrarTablero(ficha);
			}
		} while (!seleccionFicha);
	}

	private Coordenada pedirDatos() {
		int posicion1, posicion2;
		ConsoleImput con = new ConsoleImput(new Scanner(System.in));
		System.out.println();
		con.frasesLentas("Posicion de vertical de la ficha(1,2,3,4,5,6,7,8)", 30);
		System.out.print("  -> ");
		posicion1 = con.readIntInRange(1, 8) - 1;
		con.frasesLentas("Posicion de horizontal de la ficha(A,B,C,D,E,F,G,H)", 30);
		System.out.print("  -> ");
		posicion2 = Character.toUpperCase(con.readChar("ABCDEFGHabcdefgh")) - 65;
		return new Coordenada(posicion1, posicion2);
	}

}
