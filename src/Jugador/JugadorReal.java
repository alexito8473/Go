package Jugador;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import Ficha.Ficha;
import Partida.ConsoleImput;
import Tablero.Casilla;
import Tablero.Coordenada;

public class JugadorReal extends Jugador {

	public JugadorReal(String nombre, Ficha ficha) {
		super(nombre, ficha);
	}
	
	public Coordenada devolverCoordenada() {
		int posicion1,posicion2;
		Scanner sc = new Scanner(System.in);
		ConsoleImput con = new ConsoleImput(sc);
		System.out.println();
		con.frasesLentas("Posicion de vertical de la ficha(1,2,3,4,5,6,7,8)", 30);
		System.out.print("  -> ");
		posicion1 = con.readIntInRange(1, 8)-1;
		con.frasesLentas("Posicion de horizontal de la ficha(A,B,C,D,E,F,G,H)", 30);
		System.out.print("  -> ");
		posicion2 = Character.toUpperCase(con.readChar("ABCDEFGHabcdefgh")) - 65;
		return new Coordenada(posicion1,posicion2);
	
	}
	
	public  Coordenada jugada(Casilla[][] tableroJuego) {
		
		
		return null;
	}
	
	
}
