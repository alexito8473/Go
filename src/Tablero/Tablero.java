package Tablero;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import Ficha.Ficha;
import Jugador.Jugador;
import Partida.Colors;

public class Tablero {

	private Casilla[][] tablero = new Casilla[8][8];
	private boolean finBlanco = false;
	private boolean finNegro = false;
	private final int tamaño = tablero.length;

	public Tablero() {
		inicarTablero();
	}

	public Tablero(boolean prueba) {
		inicarTableroVacio();
	}

	private void inicarTablero() {
		for (int i = 0; i < tamaño; i++) {
			for (int j = 0; j < tamaño; j++) {
				if ((i == 4 && j == 4) || (i == 3 && j == 3)) {
					tablero[i][j] = new Casilla(i, j, Ficha.BLANCO);
				} else if ((i == 3 && j == 4) || (j == 3 && i == 4)) {
					tablero[i][j] = new Casilla(i, j, Ficha.NEGRO);
				} else {
					tablero[i][j] = new Casilla(i, j);
				}
			}
		}
	}

	private void inicarTableroVacio() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				tablero[i][j] = new Casilla(i, j);
			}
		}
	}

	public Ficha fichaContraria(Ficha ficha) {
		if (ficha == Ficha.BLANCO) {
			return Ficha.NEGRO;
		}
		return Ficha.BLANCO;
	}

	public int contador(Ficha ficha) {
		int contador = 0;
		for (int i = 0; i < tamaño; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					contador++;
				}
			}
		}
		return contador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(tablero);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tablero other = (Tablero) obj;
		return Arrays.deepEquals(tablero, other.tablero);
	}

	public void contandoFichasMostrando(Jugador jugador, int turno) {
		System.out.printf("\n %s ---------------------------------------------%s\n", Colors.PURPLE, Colors.RESET);
		System.out.printf(" %s|%s Le toca al jugador %s%-25s%s%s|%s\n", Colors.PURPLE, Colors.RESET, Colors.YELLOW,
				jugador.getNombre(), Colors.RESET, Colors.PURPLE, Colors.RESET);
		System.out.printf(" %s|%s Tiene la ficha%s, turno %-5d              %s|%s\n", Colors.PURPLE, Colors.RESET,
				jugador.getFicha().devolverFicha(), turno, Colors.PURPLE, Colors.RESET);
		System.out.printf(" %s ---------------------------------------------%s\n", Colors.PURPLE, Colors.RESET);
		System.out.printf(" %s --------------------------------------%s\n", Colors.YELLOW, Colors.RESET);
		System.out.printf(" %s|%s Fichas negras: %-3dFichas Blancas: %-3d%s|%s\n", Colors.YELLOW, Colors.RESET,
				contador(Ficha.NEGRO), contador(Ficha.BLANCO), Colors.YELLOW, Colors.RESET);
		System.out.printf(" %s --------------------------------------%s\n", Colors.YELLOW, Colors.RESET);
	}

	public Casilla[][] getTablero() {
		return tablero;
	}

	public Casilla devolverCasilla(Coordenada coordenada) {
		return tablero[coordenada.getPosicion1()][coordenada.getPosicion2()];
	}

	private void pintarRaya() {
		espacioTablero(38);
		for (int i = 0; i < tamaño * 3; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private void pintarLetras() {
		espacioTablero(32);
		System.out.println("   |  A  B  C  D  E  F  G  H   |");
	}

	public void mostrarTablero() {
		System.out.println("\n");
		pintarRaya();
		pintarLetras();
		for (int i = 0; i < tamaño; i++) {
			espacioTablero(35);
			System.out.print("|" + (i + 1));
			for (int j = 0; j < tablero[i].length; j++) {
				stop(6);
				System.out.print(tablero[i][j].devolverCasilla());
			}
			System.out.print(i + 1 + " |");
			System.out.println();
		}
		pintarLetras();
		pintarRaya();
	}

	public void mostrarTablero(Ficha ficha) {
		System.out.println("\n");
		pintarRaya();
		pintarLetras();
		for (int i = 0; i < tamaño; i++) {
			espacioTablero(35);
			System.out.print("|" + (i + 1));
			for (int j = 0; j < tamaño; j++) {
				stop(6);
				if (!tablero[i][j].isLlena() && movimientoValido(ficha, tablero[i][j].getCoordenada())) {
					System.out.print(Colors.GREEN + " ☆ " + Colors.RESET);
				} else {
					System.out.print(tablero[i][j].devolverCasilla());
				}

			}
			System.out.print(i + 1 + " |");
			System.out.println();
		}
		pintarLetras();
		pintarRaya();
	}

	public void mostrarTablero(Coordenada coordenada) {
		System.out.println("\n");
		pintarRaya();
		pintarLetras();
		for (int i = 0; i < tamaño; i++) {
			espacioTablero(35);
			System.out.print("|" + (i + 1));
			for (int j = 0; j < tamaño; j++) {
				stop(6);
				if (coordenada.getPosicion1() == i && coordenada.getPosicion2() == j) {
					System.out.print(Colors.RED + " ☆ " + Colors.RESET);
				} else {
					System.out.print(tablero[i][j].devolverCasilla());
				}

			}
			System.out.print(i + 1 + " |");
			System.out.println();
		}
		pintarLetras();
		pintarRaya();
	}

	private void stop(int parada) {
		try {
			TimeUnit.MILLISECONDS.sleep(parada);
		} catch (InterruptedException e) {

		}
	}

	private void espacioTablero(int espacio) {
		for (int i = 0; i < espacio; i++) {
			System.out.print(" ");
		}
	}
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	public boolean comprobarSiHayFichaPuesta(Coordenada coordenada) {
		return tablero[coordenada.getPosicion1()][coordenada.getPosicion2()].isLlena();
	}

	public void añadirFichaTablero(Ficha ficha, Coordenada coordenada) {
		tablero[coordenada.getPosicion1()][coordenada.getPosicion2()].setFicha(ficha);
		rotarFichas(ficha, devolverCasilla(coordenada));
	}

	private void rotarFichas(Ficha ficha, Casilla casilla) {
		Ficha fichaContraria = fichaContraria(ficha);
		rotarFichasVerticalAbajo(ficha, fichaContraria, casilla);
		rotarFichasVerticalArriba(ficha, fichaContraria, casilla);
		rotarFichasHorizontalDerecha(ficha, fichaContraria, casilla);
		rotarFichasHorizontalIzquierda(ficha, fichaContraria, casilla);
		rotarFichasInclinadoAbajoDerecha(ficha, fichaContraria, casilla);
		rotarFichasInclinadoArribaDerecha(ficha, fichaContraria, casilla);
		rotarFichasInclinadoAbajoIzquierda(ficha, fichaContraria, casilla);
		rotarFichasInclinadoArribaIzquierda(ficha, fichaContraria, casilla);
	}

	private void rotarFichasInclinadoAbajoIzquierda(Ficha ficha, Ficha ficha2, Casilla casilla) {
		int numeroI = casilla.getCoordenada().getPosicion1() + 1, numeroJ = casilla.getCoordenada().getPosicion2() - 1;
		boolean salida = false;
		if (movimientoInclinadoAbajoIzquierda(ficha, ficha2, casilla)) {
			do {
				if (tablero[numeroI][numeroJ].getFicha() != ficha) {
					tablero[numeroI][numeroJ].setFicha(ficha);
				} else {
					salida = true;
				}
				numeroI++;
				numeroJ--;
			} while (!salida);
		}
	}

	private void rotarFichasInclinadoAbajoDerecha(Ficha ficha, Ficha ficha2, Casilla casilla) {
		int numeroI = casilla.getCoordenada().getPosicion1() + 1, numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		boolean salida = false;
		if (movimientoInclinadoAbajoDerecha(ficha, ficha2, casilla)) {
			do {
				if (tablero[numeroI][numeroJ].getFicha() != ficha) {
					tablero[numeroI][numeroJ].setFicha(ficha);
				} else {
					salida = true;
				}
				numeroI++;
				numeroJ++;
			} while (!salida);
		}
	}

	private void rotarFichasInclinadoArribaIzquierda(Ficha ficha, Ficha ficha2, Casilla casilla) {
		int numeroI = casilla.getCoordenada().getPosicion1() - 1, numeroJ = casilla.getCoordenada().getPosicion2() - 1;
		boolean salida = false;
		if (movimientoInclinadoArribaIzquierda(ficha, ficha2, casilla)) {
			do {

				if (tablero[numeroI][numeroJ].getFicha() != ficha) {
					tablero[numeroI][numeroJ].setFicha(ficha);
				} else {
					salida = true;
				}
				numeroI--;
				numeroJ--;
			} while (!salida);
		}

	}

	private void rotarFichasInclinadoArribaDerecha(Ficha ficha, Ficha ficha2, Casilla casilla) {
		int numeroI = casilla.getCoordenada().getPosicion1() - 1, numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		boolean salida = false;
		if (movimientoInclinadoArribaDerecha(ficha, ficha2, casilla)) {
			do {

				if (tablero[numeroI][numeroJ].getFicha() != ficha) {
					tablero[numeroI][numeroJ].setFicha(ficha);
				} else {
					salida = true;
				}
				numeroI--;
				numeroJ++;
			} while (!salida);
		}

	}

	private void rotarFichasHorizontalDerecha(Ficha ficha, Ficha ficha2, Casilla casilla) {
		boolean escape = false;
		int numeroI = casilla.getCoordenada().getPosicion1(), numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		if (movimientoHorizontalDerecha(ficha, ficha2, casilla)) {
			do {

				if (tablero[numeroI][numeroJ].getFicha() != ficha) {
					tablero[numeroI][numeroJ].setFicha(ficha);
				} else {
					escape = true;
				}
				numeroJ++;
			} while (!escape);
		}
	}

	private void rotarFichasHorizontalIzquierda(Ficha ficha, Ficha ficha2, Casilla casilla) {
		boolean escape = false;
		int numeroI = casilla.getCoordenada().getPosicion1(), numeroJ = casilla.getCoordenada().getPosicion2() - 1;
		if (movimientoHorizontalIzquierda(ficha, ficha2, casilla)) {
			do {
				if (tablero[numeroI][numeroJ].getFicha() != ficha) {
					tablero[numeroI][numeroJ].setFicha(ficha);
				} else {
					escape = true;
				}
				numeroJ--;
			} while (!escape);
		}

	}

	private void rotarFichasVerticalAbajo(Ficha ficha, Ficha ficha2, Casilla casilla) {
		boolean escape = false;
		int numeroI = casilla.getCoordenada().getPosicion1() + 1, numeroJ = casilla.getCoordenada().getPosicion2();
		if (movimientoVerticalAbajo(ficha, ficha2, casilla)) {
			do {
				if (tablero[numeroI][numeroJ].getFicha() != ficha) {
					tablero[numeroI][numeroJ].setFicha(ficha);
				} else {
					escape = true;
				}
				numeroI++;
			} while (!escape);
		}

	}

	private void rotarFichasVerticalArriba(Ficha ficha, Ficha ficha2, Casilla casilla) {
		boolean escape = false;
		int numeroI = casilla.getCoordenada().getPosicion1() - 1, numeroJ = casilla.getCoordenada().getPosicion2();
		if (movimientoVerticalArriba(ficha, ficha2, casilla)) {
			do {
				if (tablero[numeroI][numeroJ].getFicha() != ficha) {
					tablero[numeroI][numeroJ].setFicha(ficha);
				} else {
					escape = true;
				}
				numeroI--;
			} while (!escape);
		}
	}

	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	public boolean movimientoValido(Ficha ficha, Coordenada coordenda) {
		Ficha fichaContrario = fichaContraria(ficha);

		return movimientoHorizontalDerecha(ficha, fichaContrario, devolverCasilla(coordenda))
				|| movimientoHorizontalIzquierda(ficha, fichaContrario, devolverCasilla(coordenda))
				|| movimientoVerticalAbajo(ficha, fichaContrario, devolverCasilla(coordenda))
				|| movimientoVerticalArriba(ficha, fichaContrario, devolverCasilla(coordenda))
				|| movimientoInclinadoAbajoDerecha(ficha, fichaContrario, devolverCasilla(coordenda))
				|| movimientoInclinadoAbajoIzquierda(ficha, fichaContrario, devolverCasilla(coordenda))
				|| movimientoInclinadoArribaIzquierda(ficha, fichaContrario, devolverCasilla(coordenda))
				|| movimientoInclinadoArribaDerecha(ficha, fichaContrario, devolverCasilla(coordenda));

	}

	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	public boolean movimientoInclinadoAbajoIzquierda(Ficha ficha, Ficha ficha2, Casilla casilla) {
		int numeroI = casilla.getCoordenada().getPosicion1() + 1, numeroJ = casilla.getCoordenada().getPosicion2() - 1;
		boolean win = false, salida = false;
		if (numeroJ < 0 || numeroI >= tamaño) {
			return false;
		} else if (tablero[numeroI][numeroJ].getFicha() == ficha2) {
			do {
				numeroI++;
				numeroJ--;
				if (numeroJ < 0 || numeroI >= tamaño) {
					salida = true;
				} else if (tablero[numeroI][numeroJ].getFicha() == ficha) {
					salida = true;
					win = true;
				} else if (!tablero[numeroI][numeroJ].isLlena()) {
					salida = true;
					win = false;
				}

			} while (!salida);
		}
		return win;
	}

	public boolean movimientoInclinadoArribaDerecha(Ficha ficha, Ficha ficha2, Casilla casilla) {
		int numeroI = casilla.getCoordenada().getPosicion1() - 1, numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		boolean win = false, salida = false;
		if (numeroI < 0 || numeroJ >= tamaño) {
			return false;
		} else if (tablero[numeroI][numeroJ].getFicha() == ficha2) {
			do {
				numeroI--;
				numeroJ++;
				if (numeroI < 0 || numeroJ >= tamaño) {
					salida = true;
				} else if (tablero[numeroI][numeroJ].getFicha() == ficha) {
					salida = true;
					win = true;
				} else if (!tablero[numeroI][numeroJ].isLlena()) {
					salida = true;
				}
			} while (!salida);
		}
		return win;
	}

	public boolean movimientoInclinadoArribaIzquierda(Ficha ficha, Ficha ficha2, Casilla casilla) {
		int numeroI = casilla.getCoordenada().getPosicion1() - 1, numeroJ = casilla.getCoordenada().getPosicion2() - 1;
		boolean win = false, salida = false;
		if (numeroJ < 0 || numeroI < 0) {
			return false;
		} else if (tablero[numeroI][numeroJ].getFicha() == ficha2) {
			do {
				numeroI--;
				numeroJ--;
				if (numeroJ < 0 || numeroI < 0) {
					salida = true;
				} else if (tablero[numeroI][numeroJ].getFicha() == ficha) {
					salida = true;
					win = true;
				} else if (!tablero[numeroI][numeroJ].isLlena()) {
					salida = true;
				}

			} while (!salida);
		}
		return win;
	}

	public boolean movimientoInclinadoAbajoDerecha(Ficha ficha, Ficha ficha2, Casilla casilla) {
		int numeroI = casilla.getCoordenada().getPosicion1() + 1, numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		boolean win = false, salida = false;
		if (numeroI >= tamaño || numeroJ >= tamaño) {
			return false;
		} else if (tablero[numeroI][numeroJ].getFicha() == ficha2) {
			do {
				numeroI++;
				numeroJ++;
				if (numeroI >= tamaño || numeroJ >= tamaño) {
					salida = true;
				} else if (tablero[numeroI][numeroJ].getFicha() == ficha) {
					salida = true;
					win = true;
				} else if (!tablero[numeroI][numeroJ].isLlena()) {
					salida = true;
				}
			} while (!salida);
		}
		return win;
	}

	public boolean movimientoVerticalArriba(Ficha ficha, Ficha ficha2, Casilla casilla) {
		int numero = casilla.getCoordenada().getPosicion1() - 1, numero2 = casilla.getCoordenada().getPosicion2();
		boolean win = false, salida = false;
		if (numero < 0) {
			return false;
		} else if (tablero[numero][numero2].getFicha() == ficha2) {
			do {
				numero--;
				if (numero < 0) {
					salida = true;
				} else if (tablero[numero][numero2].getFicha() == ficha) {
					salida = true;
					win = true;
				} else if (!tablero[numero][numero2].isLlena()) {
					salida = true;
				}

			} while (!salida);
		}
		return win;
	}

	public boolean movimientoVerticalAbajo(Ficha ficha, Ficha ficha2, Casilla casilla) {
		int numero = casilla.getCoordenada().getPosicion1() + 1, numero2 = casilla.getCoordenada().getPosicion2();
		boolean win = false, salida = false;
		if (numero >= tamaño) {
			return false;
		} else if (tablero[numero][numero2].getFicha() == ficha2) {
			do {
				numero++;
				if (numero >= tamaño) {
					salida = true;
				} else if (tablero[numero][numero2].getFicha() == ficha) {
					salida = true;
					win = true;
				} else if (!tablero[numero][numero2].isLlena()) {
					salida = true;
				}

			} while (!salida);
		}
		return win;
	}

	public boolean movimientoHorizontalIzquierda(Ficha ficha, Ficha ficha2, Casilla casilla) {
		int numero = casilla.getCoordenada().getPosicion1(), numero2 = casilla.getCoordenada().getPosicion2() - 1;
		boolean win = false, salida = false;
		if (numero2 < 0) {
			return false;
		} else if (tablero[numero][numero2].getFicha() == ficha2) {
			do {
				numero2--;
				if (numero2 < 0) {
					salida = true;
				} else if (tablero[numero][numero2].getFicha() == ficha) {
					salida = true;
					win = true;
				} else if (!tablero[numero][numero2].isLlena()) {
					salida = true;
				}

			} while (!salida);
		}
		return win;
	}

	public boolean movimientoHorizontalDerecha(Ficha ficha, Ficha ficha2, Casilla casilla) {
		int numero1 = casilla.getCoordenada().getPosicion1(), numero2 = casilla.getCoordenada().getPosicion2() + 1;
		boolean resultado = false, salida = false;
		if (numero2 >= tamaño) {
			return false;
		} else if (tablero[numero1][numero2].getFicha() == ficha2) {
			do {
				numero2++;
				if (numero2 >= tamaño) {
					salida = true;
				} else if (tablero[numero1][numero2].getFicha() == ficha) {
					salida = true;
					resultado = true;
				} else if (!tablero[numero1][numero2].isLlena()) {
					salida = true;
				}

			} while (!salida);
		}
		return resultado;
	}

	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	private boolean finalPartidaLLeno() {
		boolean win = true;
		for (int i = 0; i < tamaño; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (!tablero[i][j].isLlena()) {
					return false;
				}
			}
		}

		return win;
	}

	public boolean fin(Ficha ficha) {

		if (finalPartidaLLeno()) {
			return true;
		}

		comprobarFin(ficha);

		if (ficha == Ficha.NEGRO) {
			return finNegro;
		} else {
			return finBlanco;
		}
	}

	private void comprobarFin(Ficha ficha) {
		boolean tipo = ficha == Ficha.NEGRO;
		if (tipo) {
			finNegro = true;
		} else {
			finBlanco = true;
		}
		for (int i = 0; i < tamaño; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (!tablero[i][j].isLlena() && movimientoValido(ficha, tablero[i][j].getCoordenada())) {
					if (ficha == Ficha.NEGRO) {
						finNegro = false;
					} else {
						finBlanco = false;
					}
				}
			}
		}
	}
	// True termino la partida, false aun sigue
}