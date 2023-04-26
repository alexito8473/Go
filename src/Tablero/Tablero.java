package Tablero;

import java.util.concurrent.TimeUnit;

import Ficha.Ficha;
import Jugador.Jugador;

public class Tablero {
	private static final String RESET = "\u001B[0m";
	private static final String YELLOW = "\u001B[33m";

	private static final String PURPLE = "\u001B[35m";

	private Casilla[][] tablero = new Casilla[8][8];

	public Tablero() {
		inicarTablero();
	}

	private void inicarTablero() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
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

	public Ficha fichaContraria(Ficha ficha) {
		if (ficha == Ficha.BLANCO) {
			return Ficha.NEGRO;
		}
		return Ficha.BLANCO;
	}

	public int contador(Ficha ficha) {
		int contador = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					contador++;
				}
			}
		}
		return contador;
	}

	public void contandoFichasMostrando(Jugador jugador, int turno) {
		System.out.printf("\n %s --------------------------------------%s\n", PURPLE, RESET);
		System.out.printf(" %s|%s Le toca al jugador %s%-18s%s%s|%s\n", PURPLE, RESET, YELLOW, jugador.getNombre(),
				RESET, PURPLE, RESET);
		System.out.printf(" %s|%s Tiene la ficha%s, turno %-3d         %s|%s\n", PURPLE, RESET,
				jugador.getFicha().devolverFicha(), turno, PURPLE, RESET);
		System.out.printf(" %s --------------------------------------%s\n", PURPLE, RESET);
		System.out.printf(" %s --------------------------------------%s\n", YELLOW, RESET);
		System.out.printf(" %s|%s Fichas negras: %-3dFichas Blancas: %-3d%s|%s\n", YELLOW, RESET, contador(Ficha.NEGRO),
				contador(Ficha.BLANCO), YELLOW, RESET);
		System.out.printf(" %s --------------------------------------%s\n", YELLOW, RESET);
	}

	public Casilla[][] getTablero() {
		return tablero;
	}

	public Casilla devolverCasilla(Coordenada coordenada) {
		return tablero[coordenada.getPosicion1()][coordenada.getPosicion2()];
	}

	private void pintarRaya() {
		espacioTablero(38);
		for (int i = 0; i < tablero.length * 3; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private void pintarLetras() {
		espacioTablero(32);
		System.out.println("   |  A  B  C  D  E  F  G  H   |");
	}
	public void mostrarTablero() {
		int tamaño = tablero.length;
		System.out.println("\n");
		pintarRaya();
		pintarLetras();
		for (int i = 0; i < tamaño; i++) {
			espacioTablero(35);
			System.out.print("|" + (i + 1));
			for (int j = 0; j < tablero[i].length; j++) {
					System.out.print(tablero[i][j].pintarCasilla());
				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {

				}
			}
			System.out.print(i + 1 + " |");
			System.out.println();
		}
		pintarLetras();
		pintarRaya();
	}
	public void mostrarTablero(Ficha ficha) {
		int tamaño = tablero.length;
		System.out.println("\n");
		pintarRaya();
		pintarLetras();

		for (int i = 0; i < tamaño; i++) {
			espacioTablero(35);
			System.out.print("|" + (i + 1));
			for (int j = 0; j < tablero[i].length; j++) {
				if (!tablero[i][j].isLlena() && movimientoValido(ficha, tablero[i][j].getCoordenada())) {
					tablero[i][j].setJugada(true);
					System.out.print(tablero[i][j].pintarCasilla());
					tablero[i][j].setJugada(false);
				} else {
					System.out.print(tablero[i][j].pintarCasilla());
				}

				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {

				}
			}
			System.out.print(i + 1 + " |");
			System.out.println();
		}
		pintarLetras();
		pintarRaya();
	}
	
	public void mostrarTablero(Coordenada coordenada) {
		String RED = "\u001B[31m";
		String RESET = "\u001B[0m";
		int tamaño = tablero.length;
		System.out.println("\n");
		pintarRaya();
		pintarLetras();

		for (int i = 0; i < tamaño; i++) {
			espacioTablero(35);
			System.out.print("|" + (i + 1));
			for (int j = 0; j < tablero[i].length; j++) {
				if (coordenada.getPosicion1()==i&& coordenada.getPosicion2()==j) {
					System.out.print(RED+" ☆ "+RESET);
				} else {
					System.out.print(tablero[i][j].pintarCasilla());
				}

				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {

				}
			}
			System.out.print(i + 1 + " |");
			System.out.println();
		}
		pintarLetras();
		pintarRaya();
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

	public void añadirFichaTablero(Ficha ficha, int posicion1, int posicion2) {
		tablero[posicion1][posicion2].setFicha(ficha);
		rotarFichas(ficha, tablero[posicion1][posicion2]);
	}
	public void añadirFichaTablero(Ficha ficha,Coordenada coordenada) {
		tablero[coordenada.getPosicion1()][coordenada.getPosicion2()].setFicha(ficha);
		rotarFichas(ficha, devolverCasilla(coordenada));
	}
	private void rotarFichas(Ficha ficha, Casilla casilla) {
		Ficha fichaContraria=fichaContraria(ficha);
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
		int numeroI = casilla.getCoordenada().getPosicion1() + 1;
		int numeroJ = casilla.getCoordenada().getPosicion2() - 1;
		boolean salida = false;
		if (movimientoInclinadoAbajoIzquierda(ficha, ficha2, casilla, Comprobacion.VALIDAR)) {
			do {
				if (tablero[numeroI][numeroJ].getFicha() == ficha) {
					for (int i = casilla.getCoordenada().getPosicion1(),
							j = casilla.getCoordenada().getPosicion2(); i < numeroI && j > numeroJ; i++, j--) {
						tablero[i][j].setFicha(ficha);
					}
					salida = true;
				}
				numeroI++;
				numeroJ--;
			} while (!salida);
		}
	}

	private void rotarFichasInclinadoAbajoDerecha(Ficha ficha, Ficha ficha2, Casilla casilla) {
		int numeroI = casilla.getCoordenada().getPosicion1() + 1;
		int numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		boolean salida = false;
		if (movimientoInclinadoAbajoDerecha(ficha, ficha2, casilla, Comprobacion.VALIDAR)) {
			do {
				if (tablero[numeroI][numeroJ].getFicha() == ficha) {
					for (int i = casilla.getCoordenada().getPosicion1(),
							j = casilla.getCoordenada().getPosicion2(); i < numeroI && j < numeroJ; i++, j++) {
						tablero[i][j].setFicha(ficha);
					}
					salida = true;
				}
				numeroI++;
				numeroJ++;
			} while (!salida);
		}
	}

	private void rotarFichasInclinadoArribaIzquierda(Ficha ficha, Ficha ficha2, Casilla casilla) {
		int numeroI = casilla.getCoordenada().getPosicion1() - 1;
		int numeroJ = casilla.getCoordenada().getPosicion2() - 1;
		boolean salida = false;
		if (movimientoInclinadoArribaIzquierda(ficha, ficha2, casilla, Comprobacion.VALIDAR)) {
			do {
				numeroI --;
				numeroJ --;
				if (tablero[numeroI][numeroJ].getFicha() == ficha) {
					salida = true;
					for (int i = numeroI,j = numeroJ; i < casilla.getCoordenada().getPosicion1() && j < casilla.getCoordenada().getPosicion2(); i++, j++) {
						tablero[i][j].setFicha(ficha);
					}
				}

			} while (!salida);
		}

	}

	private void rotarFichasInclinadoArribaDerecha(Ficha ficha, Ficha ficha2, Casilla casilla) {
		int numeroI = casilla.getCoordenada().getPosicion1() - 1;
		int numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		boolean salida = false;
		if (movimientoInclinadoArribaDerecha(ficha, ficha2, casilla, Comprobacion.VALIDAR)) {
			do {

				if (tablero[numeroI][numeroJ].getFicha() == ficha) {
					salida = true;
					for (int i = casilla.getCoordenada().getPosicion1(),j = casilla.getCoordenada().getPosicion2(); i > numeroI && j < numeroJ; i--, j++) {
						tablero[i][j].setFicha(ficha);
					}
				}
				numeroI = numeroI - 1;
				numeroJ = numeroJ + 1;
			} while (!salida);
		}

	}

	private void rotarFichasHorizontalDerecha(Ficha ficha, Ficha ficha2, Casilla casilla) {
		boolean escape = false;
		int numeroI = casilla.getCoordenada().getPosicion1();
		int numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		if (movimientoHorizontalDerecha(ficha, ficha2, casilla, Comprobacion.VALIDAR)) {
			do {

				if (tablero[numeroI][numeroJ].getFicha() == ficha) {
					for (int i = casilla.getCoordenada().getPosicion2(); i < numeroJ; i++) {
						tablero[numeroI][i].setFicha(ficha);
					}
					escape = true;
				}
				numeroJ = numeroJ + 1;
			} while (!escape);
		}
	}

	private void rotarFichasHorizontalIzquierda(Ficha ficha, Ficha ficha2, Casilla casilla) {
		boolean escape = false;
		int numeroI = casilla.getCoordenada().getPosicion1();
		int numeroJ = casilla.getCoordenada().getPosicion2() - 1;
		if (movimientoHorizontalIzquierda(ficha, ficha2, casilla, Comprobacion.VALIDAR)) {
			do {
				if (tablero[numeroI][numeroJ].getFicha() == ficha) {
					for (int i = numeroJ; i < casilla.getCoordenada().getPosicion2(); i++) {
						tablero[numeroI][i].setFicha(ficha);
					}
					escape = true;
				}
				numeroJ = numeroJ - 1;
			} while (!escape);
		}

	}

	private void rotarFichasVerticalAbajo(Ficha ficha, Ficha ficha2, Casilla casilla) {
		boolean escape = false;
		int numeroI = casilla.getCoordenada().getPosicion1() + 1;
		int numeroJ = casilla.getCoordenada().getPosicion2();
		if (movimientoVerticalAbajo(ficha, ficha2, casilla, Comprobacion.VALIDAR)) {
			do {

				if (tablero[numeroI][numeroJ].getFicha() == ficha) {
					escape = true;
					for (int i = casilla.getCoordenada().getPosicion1(); i < numeroI; i++) {
						tablero[i][numeroJ].setFicha(ficha);
					}
				}
				numeroI = numeroI + 1;
			} while (!escape);
		}

	}

	private void rotarFichasVerticalArriba(Ficha ficha, Ficha ficha2, Casilla casilla) {
		boolean escape = false;
		int numeroI = casilla.getCoordenada().getPosicion1() - 1;
		int numeroJ = casilla.getCoordenada().getPosicion2();
		if (movimientoVerticalArriba(ficha, ficha2, casilla, Comprobacion.VALIDAR)) {
			do {
				if (tablero[numeroI][numeroJ].getFicha() == ficha) {
					escape = true;
					for (int i = numeroI; i < casilla.getCoordenada().getPosicion1(); i++) {
						tablero[i][numeroJ].setFicha(ficha);
					}
				}
				numeroI = numeroI - 1;
			} while (!escape);
		}
	}

	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	public boolean movimientoValido(Ficha ficha, Coordenada coordenda) {
		Ficha fichaContrario;
		boolean valido = false;
		if (ficha == Ficha.NEGRO) {
			fichaContrario = Ficha.BLANCO;
		} else {
			fichaContrario = Ficha.NEGRO;
		}
		if (movimientoHorizontalDerecha(ficha, fichaContrario, devolverCasilla(coordenda), Comprobacion.VALIDAR)
				|| movimientoHorizontalIzquierda(ficha, fichaContrario, devolverCasilla(coordenda),
						Comprobacion.VALIDAR)
				|| movimientoVerticalAbajo(ficha, fichaContrario, devolverCasilla(coordenda), Comprobacion.VALIDAR)
				|| movimientoVerticalArriba(ficha, fichaContrario, devolverCasilla(coordenda), Comprobacion.VALIDAR)
				|| movimientoInclinadoAbajoDerecha(ficha, fichaContrario, devolverCasilla(coordenda),
						Comprobacion.VALIDAR)
				|| movimientoInclinadoAbajoIzquierda(ficha, fichaContrario, devolverCasilla(coordenda),
						Comprobacion.VALIDAR)
				|| movimientoInclinadoArribaIzquierda(ficha, fichaContrario, devolverCasilla(coordenda),
						Comprobacion.VALIDAR)
				|| movimientoInclinadoArribaDerecha(ficha, fichaContrario, devolverCasilla(coordenda),
						Comprobacion.VALIDAR)) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}

	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	public boolean movimientoInclinadoAbajoIzquierda(Ficha ficha, Ficha ficha2, Casilla casilla,
			Comprobacion comprobacion) {
		int tamaño = tablero.length;
		int numeroI = casilla.getCoordenada().getPosicion1() + 1;
		int numeroJ = casilla.getCoordenada().getPosicion2() - 1;
		boolean win = false;
		boolean salida = false;
		if ((numeroJ >=0 && numeroI < tamaño) && tablero[numeroI][numeroJ].getFicha() == ficha2) {
			do {
				numeroI ++;
				numeroJ --;
				if (numeroI < tamaño && numeroJ >= 0) {
					if (tablero[numeroI][numeroJ].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (!tablero[numeroI][numeroJ].isLlena()) {
						salida = true;
						win = false;
					}
				} else {
					salida = true;
					if (comprobacion == Comprobacion.FIN) {
						win = true;
					} else {
						win = false;
					}
				}

			} while (!salida);
		}
		return win;
	}

	public boolean movimientoInclinadoArribaDerecha(Ficha ficha, Ficha ficha2, Casilla casilla,
			Comprobacion comprobacion) {
		int tamaño = tablero.length;
		int numeroI = casilla.getCoordenada().getPosicion1() - 1;
		int numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		boolean win = false;
		boolean salida = false;
		if ((numeroI >= 0 && numeroJ < tamaño) && tablero[numeroI][numeroJ].getFicha() == ficha2) {
			do {
				numeroI --;
				numeroJ ++;
				if (numeroI >= 0 && numeroJ < tamaño) {
					if (tablero[numeroI][numeroJ].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (!tablero[numeroI][numeroJ].isLlena()) {
						salida = true;
						win = false;
					}
				} else {
					salida = true;
					if (comprobacion == Comprobacion.FIN) {
						win = true;
					} else {
						win = false;
					}

				}


			} while (!salida);
		}
		return win;
	}

	public boolean movimientoInclinadoArribaIzquierda(Ficha ficha, Ficha ficha2, Casilla casilla,
			Comprobacion comprobar) {
		int numeroI = casilla.getCoordenada().getPosicion1() - 1;
		int numeroJ = casilla.getCoordenada().getPosicion2() - 1;
		boolean win = false;
		boolean salida = false;
		if ((numeroJ >= 0 && numeroI >= 0) && tablero[numeroI][numeroJ].getFicha() == ficha2) {
			do {

				if (numeroI >= 0 && numeroJ >= 0) {
					if (tablero[numeroI][numeroJ].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (!tablero[numeroI][numeroJ].isLlena()) {
						salida = true;
						win = false;
					}
				} else {
					salida = true;
					if (comprobar == Comprobacion.FIN) {
						win = true;
					} else {
						win = false;
					}

				}
				numeroI--;
				numeroJ--;
			} while (!salida);
		}
		return win;
	}

	public boolean movimientoInclinadoAbajoDerecha(Ficha ficha, Ficha ficha2, Casilla casilla,
			Comprobacion comprobacion) {
		int tamaño = tablero.length;
		int numeroI = casilla.getCoordenada().getPosicion1() + 1;
		int numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		boolean win = false;
		boolean salida = false;
		if ((numeroI < tamaño && numeroJ < tamaño) && tablero[numeroI][numeroJ].getFicha() == ficha2) {
			do {
				numeroI ++;
				numeroJ ++;
				if (numeroI < tamaño && numeroJ < tamaño) {
					if (tablero[numeroI][numeroJ].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (!tablero[numeroI][numeroJ].isLlena()) {
						salida = true;
						win = false;
					}
				} else {
					salida = true;
					if (comprobacion == Comprobacion.FIN) {
						win = true;
					} else {
						win = false;
					}

				}
			} while (!salida);
		}
		return win;
	}

	public boolean movimientoVerticalArriba(Ficha ficha, Ficha ficha2, Casilla casilla, Comprobacion comprobacion) {
		int numero = casilla.getCoordenada().getPosicion1() - 1;
		int numero2 = casilla.getCoordenada().getPosicion2();
		boolean win = false;
		boolean salida = false;
		if (numero >= 0 && tablero[numero][numero2].getFicha() == ficha2) {
			do {

				if (numero >= 0) {
					if (tablero[numero][numero2].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (!tablero[numero][numero2].isLlena()) {
						salida = true;
						win = false;
					}
					numero = numero - 1;
				} else {
					salida = true;
					if (comprobacion == Comprobacion.FIN) {
						win = true;
					} else {
						win = false;
					}
				}

			} while (!salida);
		}
		return win;
	}

	public boolean movimientoVerticalAbajo(Ficha ficha, Ficha ficha2, Casilla casilla, Comprobacion comprobacion) {
		int tamaño = tablero.length;
		int numero = casilla.getCoordenada().getPosicion1() + 1;
		int numero2 = casilla.getCoordenada().getPosicion2();
		boolean win = false;
		boolean salida = false;
		if (numero < tamaño && tablero[numero][numero2].getFicha() == ficha2) {
			do {
				
				if (numero < 8) {
					if (tablero[numero][numero2].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (!tablero[numero][numero2].isLlena()) {
						salida = true;
						win = false;
					}

				} else {
					salida = true;
					if (comprobacion == Comprobacion.FIN) {
						win = true;
					} else {
						win = false;
					}

				}
				numero ++;
			} while (!salida);
		}
		return win;
	}

	public boolean movimientoHorizontalIzquierda(Ficha ficha, Ficha ficha2, Casilla casilla, Comprobacion comprobar) {
		int numero = casilla.getCoordenada().getPosicion1();
		int numero2 = casilla.getCoordenada().getPosicion2() - 1;
		boolean win = false;
		boolean salida = false;
		if (numero2 >= 0 && tablero[numero][numero2].getFicha() == ficha2) {
			do {
				numero2 --;
				if (numero2 >= 0) {
					if (tablero[numero][numero2].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (!tablero[numero][numero2].isLlena()) {
						salida = true;
						win = false;
					}
				} else {
					salida = true;
					if (comprobar == Comprobacion.FIN) {
						win = true;
					} else {
						win = false;
					}

				}

			} while (!salida);
		}
		return win;
	}

	public boolean movimientoHorizontalDerecha(Ficha ficha, Ficha ficha2, Casilla casilla, Comprobacion comprobar) {
		int tamaño = tablero.length;
		int numero1 = casilla.getCoordenada().getPosicion1();
		int numero2 = casilla.getCoordenada().getPosicion2() + 1;
		boolean resultado = false;
		boolean salida = false;
		if (numero2 < tamaño && tablero[numero1][numero2].getFicha() == ficha2) {
			do {
				numero2++;
				if (numero2 < tamaño) {
					if (tablero[numero1][numero2].getFicha() == ficha) {
						salida = true;
						resultado = true;
					} else if (!tablero[numero1][numero2].isLlena()) {
						salida = true;
						resultado = false;
					}
				} else {
					salida = true;
					if (comprobar == Comprobacion.FIN) {
						resultado = true;
					} else {
						resultado = false;
					}

				}

			} while (!salida);
		}
		return resultado;
	}

	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	private boolean comprobarFinPartidaInclinadoArribaIzquierda(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		boolean win = true;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if (!movimientoInclinadoArribaIzquierda(ficha, ficha2, tablero[i][j], Comprobacion.FIN)) {
						win = false;
						corto = true;
					}
				}
			}
		}
		return win;
	}

	private boolean comprobarFinPartidaInclinadoAbajoDerecha(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		boolean win = true;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if (!movimientoInclinadoAbajoDerecha(ficha, ficha2, tablero[i][j], Comprobacion.FIN)) {
						win = false;
						corto = true;
					}
				}
			}
		}
		return win;
	}

	private boolean comprobarFinPartidaInclinadoAbajoIzquierda(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		boolean win = true;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if (!movimientoInclinadoAbajoIzquierda(ficha, ficha2, tablero[i][j], Comprobacion.FIN)) {
						win = false;
						corto = true;
					}
				}
			}
		}
		return win;
	}

	private boolean comprobarFinPartidaInclinadoArribaDerecha(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		boolean win = true;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if (!movimientoInclinadoArribaDerecha(ficha, ficha2, tablero[i][j], Comprobacion.FIN)) {
						win = false;
						corto = true;
					}
				}
			}
		}
		return win;
	}

	private boolean comprobarFinPartidaVerticalArriba(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		boolean win = true;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if (!movimientoVerticalArriba(ficha, ficha2, tablero[i][j], Comprobacion.FIN)) {
						win = false;
						corto = true;
					}
				}
			}
		}
		return win;
	}

	private boolean comprobarFinPartidaVerticalAbajo(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		boolean win = true;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if (!movimientoVerticalAbajo(ficha, ficha2, tablero[i][j], Comprobacion.FIN)) {
						win = false;
						corto = true;
					}
				}
			}
		}
		return win;
	}

	private boolean comprobarFinPartidaHorizontalIzquierda(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		boolean win = true;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if (!movimientoHorizontalIzquierda(ficha, ficha2, tablero[i][j], Comprobacion.FIN)) {
						win = false;
						corto = true;
					}
				}
			}
		}
		return win;
	}

	private boolean comprobarFinPartidaHorizontalDerecha(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		boolean win = true;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if (!movimientoHorizontalDerecha(ficha, ficha2, tablero[i][j], Comprobacion.FIN)) {
						win = false;
						corto = true;
					}
				}
			}
		}
		return win;
	}

	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	private boolean finalPartidaLLeno() {
		boolean win = true;
		int tamaño = tablero.length;

		for (int i = 1; i < tamaño && win; i++) {
			for (int j = 1; j < tamaño && win; j++) {
				if (!tablero[i][j].isLlena()) {
					win = false;
				}
			}
		}

		return win;
	}

	public boolean finalPartida(Ficha ficha) {
		boolean win = true;
		
		Ficha fichaContraria= fichaContraria(ficha);
		if (finalPartidaLLeno()) {
			return win;
		}
		
		if (comprobarFinPartidaInclinadoArribaIzquierda(ficha, fichaContraria)
				&& comprobarFinPartidaInclinadoAbajoDerecha(ficha, fichaContraria)
				&& comprobarFinPartidaInclinadoAbajoIzquierda(ficha, fichaContraria)
				&& comprobarFinPartidaInclinadoArribaDerecha(ficha, fichaContraria)
				&& comprobarFinPartidaVerticalArriba(ficha, fichaContraria)
				&& comprobarFinPartidaHorizontalIzquierda(ficha, fichaContraria)
				&& comprobarFinPartidaHorizontalDerecha(ficha, fichaContraria)
				&& comprobarFinPartidaVerticalAbajo(ficha, fichaContraria)) {
			win = true;
		} else {
			win = false;
		}
		return win;
	}
	// True termino la partida, false aun sigue

}