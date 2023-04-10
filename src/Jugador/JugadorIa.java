package Jugador;

import java.util.Random;

import Fichas.Ficha;

public class JugadorIa extends Jugador {

	public JugadorIa(Ficha ficha) {
		super(ponerNombre(), ficha);
	}
	
	private static String ponerNombre() {
		String nombre;
		Random numeroRandom = new Random();
		int numero= numeroRandom.nextInt(10);
		nombre = switch (numero) {
		case 0 -> "Dominio";
		case 1 -> "Jueputa";
		case 2-> "España";
		case 3 -> "Gerardo";
		case 4 -> "No se programar";
		case 5 -> "Francia caca";
		case 6 -> "Domino";
		case 7 -> "Jugador real";
		case 8 -> "No soy de aqui";
		case 9 -> "¿Tu que miras?";
		default -> "Error en el nombre";
		};
		return nombre;
		
	}
}
