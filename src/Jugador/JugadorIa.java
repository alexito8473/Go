package Jugador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import Ficha.Ficha;
import Partida.ConsoleImput;
import Tablero.Coordenada;
import Tablero.Tablero;

/**
 * Clase hija de jugador, donde se enfoca en una inteligencia artificial apta
 * para poder jugar contra otros jugadores o o sobre otra ia(mejor que la de
 * Angel y PPk).
 * 
 * @see Jugador
 * @author Alejandro Aguilar Alba
 * @since 1.0
 * @version 1.0
 */
public class JugadorIa extends Jugador {
	/**
	 * Constructor de la clase JugadorIa.
	 * 
	 * @param ficha La ficha del jugador.
	 */
	public JugadorIa(Ficha ficha) {
		super(ponerNombre(), ficha);
	}

	/**
	 * Metodo que genera un nombre random para el JugadorIa.
	 * 
	 * @return Devuelve un nombre.
	 */
	private static String ponerNombre() {
		return switch (new Random().nextInt(32)) {
		case 0 -> "Dominio";
		case 1 -> "Jueputa";
		case 2 -> "España";
		case 3 -> "Gerardo";
		case 4 -> "No se programar";
		case 5 -> "Francia caca";
		case 6 -> "Domino";
		case 7 -> "Jugador real";
		case 8 -> "No soy de aquí";
		case 9 -> "¿Tu que miras?";
		case 10 -> "Viva España";
		case 11 -> "Estático";
		case 12 -> "Dinámico";
		case 13 -> "Ahora super estático";
		case 14 -> "Ahora mega dinámico";
		case 15 -> "Rosa melano";
		case 16 -> "Es una simulación";
		case 17 -> "Joe Luis";
		case 18 -> "PPk cagón";
		case 19 -> "Praga";
		case 20 -> "Mina Votieso";
		case 21 -> "PussyBreaker";
		case 22 -> "AzaelDobleA";
		case 23 -> "ppk copión";
		case 24 -> "Gafota promedio 🤓";
		case 25 -> "Mamamamamamamagüevaso";
		case 26 -> "Teoría de cuerdas";
		case 27 -> "SuperGamer";
		case 28 -> "Estoy detrás de ti";
		case 29 -> "Despierta!!!!!";
		case 30 -> "Sé quien eres";
		case 31 -> "Angel cagon 💩";
		default -> "Error en el nombre";
		};
	}

	/**
	 * Metodo heredado del padre, donde la ia decide las jugada mas optimzas y
	 * decide el juego.
	 */
	public void jugada(Tablero tablero, int turno) {
		int comer, cantidad;
		ConsoleImput con = new ConsoleImput(new Scanner(System.in));
		Coordenada coordenadaJugada;
		List<MovimientoIa> listaJugada = new ArrayList<>(), listaImportante = new ArrayList<>(),
				listaEsquinas = new ArrayList<>(), listaMenosImportante = new ArrayList<>(),
				listaMenosMenosImportante = new ArrayList<>();

		for (int i = 0; i < tablero.getTablero().length; i++) {
			for (int j = 0; j < tablero.getTablero()[i].length; j++) {
				if ((!tablero.getTablero()[i][j].isLlena())
						&& tablero.movimientoValido(ficha, tablero.getTablero()[i][j].getCoordenada())) {
					listaJugada.add(new MovimientoIa(tablero.getTablero()[i][j].getCoordenada(),
							sumarJugada(tablero.getTablero()[i][j].getCoordenada(), tablero)));
				}
			}
		}

		listaEsquinas.addAll(listaJugada.stream()
				.filter(t -> (t.getCoordenada().getPosicion1() == 0
						&& t.getCoordenada().getPosicion2() == tablero.getTablero().length - 1)
						|| (t.getCoordenada().getPosicion1() == 0 && t.getCoordenada().getPosicion2() == 0)
						|| (t.getCoordenada().getPosicion1() == tablero.getTablero().length - 1
								&& t.getCoordenada().getPosicion2() == tablero.getTablero().length - 1)
						|| (t.getCoordenada().getPosicion1() == tablero.getTablero().length - 1
								&& t.getCoordenada().getPosicion2() == 0))
				.sorted(Comparator.comparing(MovimientoIa::getCantidadComida).reversed()).toList());

		listaJugada.removeAll(listaEsquinas);

		listaImportante.addAll(listaJugada.stream()
				.filter(t -> t.getCoordenada().getPosicion1() == 0
						|| t.getCoordenada().getPosicion1() == tablero.getTablero().length - 1
						|| t.getCoordenada().getPosicion2() == tablero.getTablero().length - 1
						|| t.getCoordenada().getPosicion2() == 0)
				.sorted(Comparator.comparing(MovimientoIa::getCantidadComida).reversed()).toList());

		listaJugada.removeAll(listaImportante);

		listaMenosMenosImportante.addAll(listaJugada.stream()
				.filter(t -> (t.getCoordenada().getPosicion1() == 1
						&& t.getCoordenada().getPosicion2() == tablero.getTablero().length - 2)
						|| (t.getCoordenada().getPosicion1() == 1 && t.getCoordenada().getPosicion2() == 1)
						|| (t.getCoordenada().getPosicion1() == tablero.getTablero().length - 2
								&& t.getCoordenada().getPosicion2() == tablero.getTablero().length - 2)
						|| (t.getCoordenada().getPosicion1() == tablero.getTablero().length - 2
								&& t.getCoordenada().getPosicion2() == 1))
				.sorted(Comparator.comparing(MovimientoIa::getCantidadComida).reversed()).toList());

		listaJugada.removeAll(listaMenosMenosImportante);

		listaMenosImportante.addAll(listaJugada.stream()
				.filter(t -> t.getCoordenada().getPosicion1() == 1
						|| t.getCoordenada().getPosicion1() == tablero.getTablero().length - 2
						|| t.getCoordenada().getPosicion2() == tablero.getTablero().length - 2
						|| t.getCoordenada().getPosicion2() == 1)
				.sorted(Comparator.comparing(MovimientoIa::getCantidadComida).reversed()).toList());

		listaJugada.removeAll(listaMenosImportante);

		if (listaEsquinas.size() > 0) {
			comer = listaEsquinas.get(0).getCantidadComida();
			cantidad = (int) listaEsquinas.stream().filter(t -> t.getCantidadComida() == comer).count();
			coordenadaJugada = listaEsquinas.stream().filter(t -> t.getCantidadComida() == comer).toList()
					.get(new Random().nextInt(cantidad)).getCoordenada();
		} else {
			if (listaImportante.size() > 0) {
				comer = listaImportante.get(0).getCantidadComida();
				cantidad = (int) listaImportante.stream().filter(t -> t.getCantidadComida() == comer).count();
				coordenadaJugada = listaImportante.stream().filter(t -> t.getCantidadComida() == comer).toList()
						.get(new Random().nextInt(cantidad)).getCoordenada();
			} else {
				if (listaJugada.size() > 0) {
					listaJugada.sort(Comparator.comparing(MovimientoIa::getCantidadComida).reversed());
					comer = listaJugada.get(0).getCantidadComida();
					cantidad = (int) listaJugada.stream().filter(t -> t.getCantidadComida() == comer).count();
					coordenadaJugada = listaJugada.stream().filter(t -> t.getCantidadComida() == comer).toList()
							.get(new Random().nextInt(cantidad)).getCoordenada();
				} else {

					if (listaMenosImportante.size() > 0) {

						if (turno > 20) {
							listaMenosImportante.sort(Comparator.comparing(MovimientoIa::getCantidadComida).reversed());
						} else {
							listaMenosImportante.sort(Comparator.comparing(MovimientoIa::getCantidadComida));
						}

						comer = listaMenosImportante.get(0).getCantidadComida();
						cantidad = (int) listaMenosImportante.stream().filter(t -> t.getCantidadComida() == comer)
								.count();
						coordenadaJugada = listaMenosImportante.stream().filter(t -> t.getCantidadComida() == comer)
								.toList().get(new Random().nextInt(cantidad)).getCoordenada();
					} else {

						listaMenosMenosImportante.sort(Comparator.comparing(MovimientoIa::getCantidadComida));
						comer = listaMenosMenosImportante.get(0).getCantidadComida();
						cantidad = (int) listaMenosMenosImportante.stream().filter(t -> t.getCantidadComida() == comer)
								.count();
						coordenadaJugada = listaMenosMenosImportante.stream()
								.filter(t -> t.getCantidadComida() == comer).toList()
								.get(new Random().nextInt(cantidad)).getCoordenada();

					}

				}

			}
		}

		tablero.mostrarTablero(ficha);
		tablero.contandoFichasMostrando(this, turno);
		con.frasesLentas("Posición vertical (1,2,3,4,5,6,7,8)", 30);
		System.out.print("  -> ");
		con.stop(500);
		con.frasesLentas(String.valueOf(coordenadaJugada.getPosicion1() + 1), 18);
		con.frasesLentas("Posición horizontal (A,B,C,D,E,F,G,H)", 30);
		System.out.print("  -> ");
		con.stop(500);
		con.frasesLentas(String.valueOf((char) (coordenadaJugada.getPosicion2() + 65)), 18);
		tablero.mostrarTablero(coordenadaJugada);
		con.stop(1100);
		tablero.anadirFichaTablero(ficha, coordenadaJugada);
		System.out.println();
	}

	/**
	 * Metodo que suma la cantidad total de fichas que se come la jugada.
	 * 
	 * @param coordenada Las coordenda de comparacion.
	 * @param tablero    El tablero de juego.
	 * @return Retorna la cantidad total de fichas que se puede comer, el minimo
	 *         siempre sera 0.
	 */
	private int sumarJugada(Coordenada coordenada, Tablero tablero) {
		return conteoHorizontalIzquierda(coordenada, tablero) + conteoHorizontalDerecha(coordenada, tablero)
				+ conteoVerticalAbajo(coordenada, tablero) + conteoVerticalArriba(coordenada, tablero)
				+ conteoInclinadoAbajoDerecha(coordenada, tablero) + conteoInclinadoAbajoIzquierda(coordenada, tablero)
				+ conteoInclinadoArribaIzquierda(coordenada, tablero)
				+ conteoInclinadoArribaDerecha(coordenada, tablero);
	}

	/**
	 * Metodo que cuenta las fichas totales que donde la direccion es la
	 * diagonal_arriba_derecha.
	 * 
	 * @param coordenada Las coordenda de comparacion.
	 * @param tablero    El tablero donde se juega
	 * @return Devuelve la cantidad total de fichas que puede girar.
	 */
	private int conteoInclinadoArribaDerecha(Coordenada coordenada, Tablero tablero) {
		int devolver = 0, numeroI = coordenada.getPosicion1() - 1, numeroJ = coordenada.getPosicion2() + 1;
		boolean salida = false;
		if (tablero.movimientoInclinadoArribaDerecha(ficha, coordenada)) {
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

	/**
	 * Metodo que cuenta las fichas totales que donde la direccion es la
	 * diagonal_arriba_izquierda.
	 * 
	 * @param coordenada Las coordenda de comparacion.
	 * @param tablero    El tablero donde se juega
	 * @return Devuelve la cantidad total de fichas que puede girar.
	 */
	private int conteoInclinadoArribaIzquierda(Coordenada coordenada, Tablero tablero) {
		int devolver = 0, numeroI = coordenada.getPosicion1() - 1, numeroJ = coordenada.getPosicion2() - 1;
		boolean salida = false;
		if (tablero.movimientoInclinadoArribaIzquierda(ficha, coordenada)) {
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

	/**
	 * Metodo que cuenta las fichas totales que donde la direccion es la
	 * diagonal_abajo_izquierda.
	 * 
	 * @param coordenada Las coordenda de comparacion.
	 * @param tablero    El tablero donde se juega
	 * @return Devuelve la cantidad total de fichas que puede girar.
	 */
	private int conteoInclinadoAbajoIzquierda(Coordenada coordenada, Tablero tablero) {
		int devolver = 0, numeroI = coordenada.getPosicion1() + 1, numeroJ = coordenada.getPosicion2() - 1;
		boolean salida = false;
		if (tablero.movimientoInclinadoAbajoIzquierda(ficha, coordenada)) {
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

	/**
	 * Metodo que cuenta las fichas totales que donde la direccion es la
	 * diagonal_abajo_derecha.
	 * 
	 * @param coordenada Las coordenda de comparacion.
	 * @param tablero    El tablero donde se juega
	 * @return Devuelve la cantidad total de fichas que puede girar.
	 */
	private int conteoInclinadoAbajoDerecha(Coordenada coordenada, Tablero tablero) {
		int devolver = 0, numeroI = coordenada.getPosicion1() + 1, numeroJ = coordenada.getPosicion2() + 1;
		boolean salida = false;
		if (tablero.movimientoInclinadoAbajoDerecha(ficha, coordenada)) {
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

	/**
	 * Metodo que cuenta las fichas totales que donde la direccion es la
	 * vertical_arriba.
	 * 
	 * @param coordenada Las coordenda de comparacion.
	 * @param tablero    El tablero donde se juega
	 * @return Devuelve la cantidad total de fichas que puede girar.
	 */
	private int conteoVerticalArriba(Coordenada coordenada, Tablero tablero) {
		int devolver = 0, numero = coordenada.getPosicion1() - 1, numero2 = coordenada.getPosicion2();
		boolean escape = false;
		if (tablero.movimientoVerticalArriba(ficha, coordenada)) {
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

	/**
	 * Metodo que cuenta las fichas totales que donde la direccion es la
	 * vertical_abajo.
	 * 
	 * @param coordenada Las coordenda de comparacion.
	 * @param tablero    El tablero donde se juega
	 * @return Devuelve la cantidad total de fichas que puede girar.
	 */
	private int conteoVerticalAbajo(Coordenada coordenada, Tablero tablero) {
		int devolver = 0, numero = coordenada.getPosicion1() + 1, numero2 = coordenada.getPosicion2();
		boolean escape = false;
		if (tablero.movimientoVerticalAbajo(ficha, coordenada)) {
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

	/**
	 * Metodo que cuenta las fichas totales que donde la direccion es la
	 * horizontal_izquierda.
	 * 
	 * @param coordenada Las coordenda de comparacion.
	 * @param tablero    El tablero donde se juega
	 * @return Devuelve la cantidad total de fichas que puede girar.
	 */
	private int conteoHorizontalIzquierda(Coordenada coordenada, Tablero tablero) {
		int devolver = 0, numero = coordenada.getPosicion1(), numero2 = coordenada.getPosicion2() - 1;
		boolean salida = false;
		if (tablero.movimientoHorizontalIzquierda(ficha, coordenada)) {
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

	/**
	 * Metodo que cuenta las fichas totales que donde la direccion es la
	 * horizontal_derecha.
	 * 
	 * @param coordenada Las coordenda de comparacion.
	 * @param tablero    El tablero donde se juega
	 * @return Devuelve la cantidad total de fichas que puede girar.
	 */
	private int conteoHorizontalDerecha(Coordenada coordenada, Tablero tablero) {
		int devolver = 0, numero = coordenada.getPosicion1(), numero2 = coordenada.getPosicion2() + 1;
		boolean escape = false;
		if (tablero.movimientoHorizontalDerecha(ficha, coordenada)) {
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
