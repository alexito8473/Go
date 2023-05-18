package Jugador;

import java.util.Scanner;

import Ficha.Ficha;
import Partida.ConsoleImput;
import Tablero.Coordenada;
import Tablero.Tablero;
/**
 * 	Clase hija de la clase Jugador donde se enfoca en las peticiones que tendria un jugador real.
 * 	@author Alejandro Aguilar Alba
 * 	@since 1.0
 *	@version 1.0 
 */
public class JugadorReal extends Jugador {
	/**
	 *	Constructor de la clase JugadorReal
	 * 	@param nombre Nombre del jugador en cuestion.
	 * 	@param ficha La ficha del jugador.
	 */
	public JugadorReal(String nombre, Ficha ficha) {
		super(nombre, ficha);
	}

	/**
	 * 	Metodo que pide enseña la el turno del jugador, el tablero y el jugador decide su jugada.
	 * 	@param tablero El tablero de la partida.
	 * 	@param turno  El turno de la partida.
	 */
	public void jugada(Tablero tablero, int turno) {
		ConsoleImput con = new ConsoleImput(new Scanner(System.in));
		do {
			tablero.mostrarTablero(ficha);
			tablero.contandoFichasMostrando(this, turno);
		} while (!ponerFicha(pedirDatos(con), tablero, con));
	}

	/**
	 *	Metodo que coloca la ficha en cuestion del jugador en las coordenada indica
	 *	pero solo si es valida.
	 *	@param coordenada Las coordenada donde se coloca la ficha.
	 *	@param tablero El tablero de la partida.
	 *	@param con El consoleimput del jugador para los datos.
	 *	@return true: Se coloco la ficha false: No se coloco la ficha.
	 */
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

	/**
	 *	Metodo que pide al usuario las los datos necesario.
	 * 	@param con Clase que sirve para los metodos de pedir datos.
	 * 	@return Las coordenadas.
	 */
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
