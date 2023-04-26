package Jugador;

import java.util.Random;
import java.util.Scanner;

import Ficha.Ficha;
import Partida.ConsoleImput;
import Tablero.Casilla;
import Tablero.Comprobacion;
import Tablero.Coordenada;
import Tablero.Tablero;

public class JugadorIa extends Jugador {

	public JugadorIa(Ficha ficha) {
		super(ponerNombre(), ficha);
	}

	private static String ponerNombre() {
		String nombre;
		Random numeroRandom = new Random();
		int numero = numeroRandom.nextInt(10);
		nombre = switch (numero) {
		case 0 -> "Dominio";
		case 1 -> "Jueputa";
		case 2 -> "España";
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

	public void jugada(Tablero tablero, int turno) {
		int cantidad = 0, cantidadPrueba;
		ConsoleImput con = new ConsoleImput(new Scanner(System.in));
		Random ran = new Random();
		Coordenada coordenadaJugada = new Coordenada(0, 0);
		for (int i = 0; i < tablero.getTablero().length; i++) {
			for (int j = 0; j < tablero.getTablero()[i].length; j++) {
				if ((!tablero.getTablero()[i][j].isLlena()) && tablero.movimientoValido(ficha, new Coordenada(i, j))) {
					cantidadPrueba = sumarJugada(tablero.getTablero()[i][j], tablero);
					if (cantidad <= cantidadPrueba) {
						if (cantidad == cantidadPrueba) {
							if (ran.nextInt(2) == 0) {
								cantidad = cantidadPrueba;
								coordenadaJugada = new Coordenada(i, j);
							}
						} else {
							cantidad = cantidadPrueba;
							coordenadaJugada = new Coordenada(i, j);
						}
					}
				}
			}
		}
		tablero.mostrarTablero(ficha);
		tablero.contandoFichasMostrando(this, turno);
		con.frasesLentas("Posicion vertical de la ficha(1,2,3,4,5,6,7,8)", 40);
		System.out.print("  -> ");
		con.stop(500);
		con.frasesLentas(String.valueOf(coordenadaJugada.getPosicion1() + 1), 15);
		con.frasesLentas("Posicion horizontal de la ficha(A,B,C,D,E,F,G,H)", 40);
		System.out.print("  -> ");
		con.stop(500);
		con.frasesLentas(String.valueOf((char) (coordenadaJugada.getPosicion2() + 65)), 15);
		tablero.mostrarTablero(coordenadaJugada);
		con.stop(1200);
		tablero.añadirFichaTablero(ficha, coordenadaJugada);
		System.out.println();
	}

	public int sumarJugada(Casilla casilla, Tablero tablero) {
		int resultado = 0;
		resultado = resultado + conteoHorizontalIzquierda(casilla, tablero);
		resultado = resultado + conteoHorizontalDerecha(casilla, tablero);
		resultado = resultado + conteoVerticalAbajo(casilla, tablero);
		resultado = resultado + conteoVerticalArriba(casilla, tablero);
		resultado = resultado + conteoInclinadoAbajoDerecha(casilla, tablero);
		resultado = resultado + conteoInclinadoAbajoIzquierda(casilla, tablero);
		resultado = resultado + conteoInclinadoArribaIzquierda(casilla, tablero);
		resultado = resultado + conteoInclinadoArribaDerecha(casilla, tablero);
		return resultado;
	}

	private int conteoInclinadoArribaDerecha(Casilla casilla, Tablero tablero) {
		int devolver = 0;
		int numeroI = casilla.getCoordenada().getPosicion1() - 1;
		int numeroJ = casilla.getCoordenada().getPosicion2() + 1;

		boolean salida = false;
		if (tablero.movimientoInclinadoArribaDerecha(ficha, tablero.fichaContraria(ficha), casilla,
				Comprobacion.VALIDAR)) {
			do {
				if (tablero.getTablero()[numeroI][numeroJ].getFicha() == ficha) {
					salida = true;
				} else {
					devolver++;
				}
				numeroI--;
				numeroJ++;
			} while (!salida);
		}
		return devolver;

	}

	private int conteoInclinadoArribaIzquierda(Casilla casilla, Tablero tablero) {
		int devolver = 0;
		int numeroI = casilla.getCoordenada().getPosicion1() - 1;
		int numeroJ = casilla.getCoordenada().getPosicion2() - 1;

		boolean salida = false;
		if (tablero.movimientoInclinadoArribaIzquierda(ficha, tablero.fichaContraria(ficha), casilla,
				Comprobacion.VALIDAR)) {
			do {
				if (tablero.getTablero()[numeroI][numeroJ].getFicha() == ficha) {
					salida = true;
				} else {
					devolver++;
				}
				numeroI--;
				numeroJ--;
			} while (!salida);
		}
		return devolver;
	}

	private int conteoInclinadoAbajoIzquierda(Casilla casilla, Tablero tablero) {
		int devolver = 0;
		int numeroI = casilla.getCoordenada().getPosicion1() + 1;
		int numeroJ = casilla.getCoordenada().getPosicion2() - 1;
		boolean salida = false;
		if (tablero.movimientoInclinadoAbajoIzquierda(ficha, tablero.fichaContraria(ficha), casilla,
				Comprobacion.VALIDAR)) {
			do {
				if (tablero.getTablero()[numeroI][numeroJ].getFicha() == ficha) {
					salida = true;
				} else {
					devolver++;
				}
				numeroI++;
				numeroJ--;
			} while (!salida);
		}
		return devolver;
	}

	private int conteoInclinadoAbajoDerecha(Casilla casilla, Tablero tablero) {
		int devolver = 0;
		int numeroI = casilla.getCoordenada().getPosicion1() + 1;
		int numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		boolean salida = false;
		if (tablero.movimientoInclinadoAbajoDerecha(ficha, tablero.fichaContraria(ficha), casilla,
				Comprobacion.VALIDAR)) {
			do {
				if (tablero.getTablero()[numeroI][numeroJ].getFicha() == ficha) {
					salida = true;
				} else {
					devolver++;
				}
				numeroI++;
				numeroJ++;
			} while (!salida);
		}
		return devolver;
	}

	private int conteoVerticalArriba(Casilla casilla, Tablero tablero) {
		int devolver = 0;
		boolean escape = false;
		int numero = casilla.getCoordenada().getPosicion1() - 1;
		int numero2 = casilla.getCoordenada().getPosicion2();
		if (tablero.movimientoVerticalArriba(ficha, tablero.fichaContraria(ficha), casilla, Comprobacion.VALIDAR)) {
			do {
				if (tablero.getTablero()[numero][numero2].getFicha() == ficha) {
					escape = true;
				} else {
					devolver++;
				}
				numero = numero - 1;
			} while (!escape);
		}

		return devolver;
	}

	private int conteoVerticalAbajo(Casilla casilla, Tablero tablero) {
		int devolver = 0;
		boolean escape = false;
		int numero = casilla.getCoordenada().getPosicion1() + 1;
		int numero2 = casilla.getCoordenada().getPosicion2();
		if (tablero.movimientoVerticalAbajo(ficha, tablero.fichaContraria(ficha), casilla, Comprobacion.VALIDAR)) {
			do {
				if (tablero.getTablero()[numero][numero2].getFicha() == ficha) {
					escape = true;
				} else {
					devolver++;
				}
				numero++;
			} while (!escape);
		}
		return devolver;
	}

	private int conteoHorizontalIzquierda(Casilla casilla, Tablero tablero) {
		int devolver = 0;
		int numero = casilla.getCoordenada().getPosicion1();
		int numero2 = casilla.getCoordenada().getPosicion2() - 1;
		boolean salida = false;
		if (tablero.movimientoHorizontalIzquierda(ficha, tablero.fichaContraria(ficha), casilla,
				Comprobacion.VALIDAR)) {
			do {
				if (tablero.getTablero()[numero][numero2].getFicha() == ficha) {
					salida = true;
				} else {
					devolver++;
				}
				numero2--;
			} while (!salida);
		}
		return devolver;
	}

	private int conteoHorizontalDerecha(Casilla casilla, Tablero tablero) {
		int devolver = 0;
		boolean escape = false;
		int numero = casilla.getCoordenada().getPosicion1();
		int numero2 = casilla.getCoordenada().getPosicion2() + 1;
		if (tablero.movimientoHorizontalDerecha(ficha, tablero.fichaContraria(ficha), casilla, Comprobacion.VALIDAR)) {
			do {
				if (tablero.getTablero()[numero][numero2].getFicha() == ficha) {
					escape = true;
				} else {
					devolver++;
				}
				numero2++;
			} while (!escape);
		}
		return devolver;
	}

}
