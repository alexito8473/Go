package Jugador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import Ficha.Ficha;
import Partida.ConsoleImput;
import Tablero.Casilla;
import Tablero.Coordenada;
import Tablero.Tablero;

public class JugadorIa extends Jugador {

	public JugadorIa(Ficha ficha) {
		super(ponerNombre(), ficha);
	}

	private static String ponerNombre() {
		return switch (new Random().nextInt(31)) {
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
		case 10 -> "Viva españa";
		case 11 -> "Estático";
		case 12 -> "Dinámico";
		case 13 -> "Ahora super estático";
		case 14 -> "Ahora mega dinámico";
		case 15 -> "Rosa melano";
		case 16 -> "Es una simulacion";
		case 17 -> "Joe Luis";
		case 18 -> "PPk cagon";
		case 19 -> "Praga";
		case 20 -> "Mina Votieso";
		case 21 -> "PussyBreaker";
		case 22 -> "AzaelDobleA";
		case 23 -> "ppk copion";
		case 24 -> "Gafota promedio 🤓";
		case 25 -> "Mamamamamamamagüevaso";
		case 26 -> "Teoria de cuerdas";
		case 27 -> "SuperGamer";
		case 28 -> "Estoy detras de ti";
		case 29 -> "Despierta!!!!!";
		case 30 -> "Sé quien eres";
		default -> "Error en el nombre";
		};
	}

	public void jugada(Tablero tablero, int turno) {
		int comer, cantidad;
		List<MovimientoIa> listaProbar = new ArrayList<>();
		List<MovimientoIa> listaImportante = new ArrayList<>();
		ConsoleImput con = new ConsoleImput(new Scanner(System.in));
		Coordenada coordenadaJugada;
		for (int i = 0; i < tablero.getTablero().length; i++) {
			for (int j = 0; j < tablero.getTablero()[i].length; j++) {
				if ((!tablero.getTablero()[i][j].isLlena())
						&& tablero.movimientoValido(ficha, tablero.getTablero()[i][j].getCoordenada())) {
					listaProbar.add(new MovimientoIa(tablero.getTablero()[i][j].getCoordenada(),
							sumarJugada(tablero.getTablero()[i][j], tablero)));
				}
			}
		}
		listaImportante.addAll(listaProbar.stream()
				.filter(t -> t.getCoordenada().getPosicion1() == 0
						|| t.getCoordenada().getPosicion1() == tablero.getTablero().length - 1
						|| t.getCoordenada().getPosicion2() == tablero.getTablero().length - 1
						|| t.getCoordenada().getPosicion2() == 0)
				.sorted(Comparator.comparing(MovimientoIa::getCantidadComida).reversed()).toList());

		if (listaImportante.size() > 0) {
			comer = listaImportante.get(0).getCantidadComida();
			cantidad = (int) listaImportante.stream().filter(t -> t.getCantidadComida() == comer).count();
			coordenadaJugada = listaImportante.stream().filter(t -> t.getCantidadComida() == comer).toList()
					.get(new Random().nextInt(cantidad)).getCoordenada();
		} else {
			listaProbar.sort(Comparator.comparing(MovimientoIa::getCantidadComida).reversed());
			comer = listaProbar.get(0).getCantidadComida();
			cantidad = (int) listaProbar.stream().filter(t -> t.getCantidadComida() == comer).count();
			coordenadaJugada = listaProbar.stream().filter(t -> t.getCantidadComida() == comer).toList()
					.get(new Random().nextInt(cantidad)).getCoordenada();
		}

		tablero.mostrarTablero(ficha);
		tablero.contandoFichasMostrando(this, turno);
		con.frasesLentas("Posicion vertical (1,2,3,4,5,6,7,8)", 30);
		System.out.print("  -> ");
		con.stop(500);
		con.frasesLentas(String.valueOf(coordenadaJugada.getPosicion1() + 1), 15);
		con.frasesLentas("Posicion horizontal (A,B,C,D,E,F,G,H)", 30);
		System.out.print("  -> ");
		con.stop(500);
		con.frasesLentas(String.valueOf((char) (coordenadaJugada.getPosicion2() + 65)), 15);
		tablero.mostrarTablero(coordenadaJugada);
		con.stop(1100);
		tablero.añadirFichaTablero(ficha, coordenadaJugada);
		System.out.println();
	}

	private int sumarJugada(Casilla casilla, Tablero tablero) {
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
		int devolver = 0, numeroI = casilla.getCoordenada().getPosicion1() - 1,
				numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		boolean salida = false;
		if (tablero.movimientoInclinadoArribaDerecha(ficha, tablero.fichaContraria(ficha), casilla)) {
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
		int devolver = 0, numeroI = casilla.getCoordenada().getPosicion1() - 1,
				numeroJ = casilla.getCoordenada().getPosicion2() - 1;

		boolean salida = false;
		if (tablero.movimientoInclinadoArribaIzquierda(ficha, tablero.fichaContraria(ficha), casilla)) {
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
		int devolver = 0, numeroI = casilla.getCoordenada().getPosicion1() + 1,
				numeroJ = casilla.getCoordenada().getPosicion2() - 1;
		boolean salida = false;
		if (tablero.movimientoInclinadoAbajoIzquierda(ficha, tablero.fichaContraria(ficha), casilla)) {
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
		int devolver = 0, numeroI = casilla.getCoordenada().getPosicion1() + 1,
				numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		boolean salida = false;
		if (tablero.movimientoInclinadoAbajoDerecha(ficha, tablero.fichaContraria(ficha), casilla)) {
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
		int devolver = 0, numero = casilla.getCoordenada().getPosicion1() - 1,
				numero2 = casilla.getCoordenada().getPosicion2();
		boolean escape = false;
		if (tablero.movimientoVerticalArriba(ficha, tablero.fichaContraria(ficha), casilla)) {
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
		int devolver = 0, numero = casilla.getCoordenada().getPosicion1() + 1,
				numero2 = casilla.getCoordenada().getPosicion2();
		boolean escape = false;
		if (tablero.movimientoVerticalAbajo(ficha, tablero.fichaContraria(ficha), casilla)) {
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
		int devolver = 0, numero = casilla.getCoordenada().getPosicion1(),
				numero2 = casilla.getCoordenada().getPosicion2() - 1;
		boolean salida = false;
		if (tablero.movimientoHorizontalIzquierda(ficha, tablero.fichaContraria(ficha), casilla)) {
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
		int devolver = 0, numero = casilla.getCoordenada().getPosicion1(),
				numero2 = casilla.getCoordenada().getPosicion2() + 1;
		boolean escape = false;
		if (tablero.movimientoHorizontalDerecha(ficha, tablero.fichaContraria(ficha), casilla)) {
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
