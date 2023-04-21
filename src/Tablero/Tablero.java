package Tablero;

import java.util.concurrent.TimeUnit;

import Ficha.Ficha;

public class Tablero {

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

	public Casilla[][] getTablero() {
		return tablero;
	}

	public Casilla devolverCasilla(Coordenada coordenada) {
		return tablero[coordenada.getPosicion1()][coordenada.getPosicion2()];
	}

	public void mostrarTablero() {
		int tamaño = tablero.length;
		System.out.print("\n");
		espacioTablero(38);
		for (int i = 0; i < tamaño * 3; i++) {
			System.out.print("-");
		}
		System.out.println();
		espacioTablero(32);
		System.out.print("   |  A  B  C  D  E  F  G  H   |");
		System.out.println();
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
		espacioTablero(32);
		System.out.println("   |  A  B  C  D  E  F  G  H   |");
		espacioTablero(38);
		for (int i = 0; i < tamaño * 3; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	private void espacioTablero(int espacio) {
		for (int i = 0; i < espacio; i++) {
			System.out.print(" ");
		}
	}
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	public boolean comprobarSiHayFichaPuesta(int posicion1, int posicion2) {
		return tablero[posicion1][posicion2].isLlena();
	}

	public void añadirFichaTablero(Ficha ficha, int posicion1, int posicion2) {
		tablero[posicion1][posicion2].setFicha(ficha);
		rotarFichas(ficha, tablero[posicion1][posicion2]);
	}

	private void rotarFichas(Ficha ficha, Casilla casilla) {
		Ficha fichaContraria;
		if (ficha == Ficha.BLANCO) {
			fichaContraria = Ficha.NEGRO;
		} else {
			fichaContraria = Ficha.BLANCO;
		}
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
		int numeroJ = casilla.getCoordenada().getPosicion1() + 1;
		int numeroI = casilla.getCoordenada().getPosicion2() - 1;
		boolean salida = false;
		if (movimientoInclinadoAbajoIzquierda(ficha, ficha2, casilla, Comprobacion.Validar)) {
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
		int numeroJ = casilla.getCoordenada().getPosicion1() + 1;
		int numeroI = casilla.getCoordenada().getPosicion2() + 1;
		boolean salida = false;
		if (movimientoInclinadoAbajoDerecha(ficha, ficha2, casilla, Comprobacion.Validar)) {
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
		int numeroJ = casilla.getCoordenada().getPosicion1() - 1;
		int numeroI = casilla.getCoordenada().getPosicion2() - 1;
		boolean salida = false;
		if (movimientoInclinadoArribaIzquierda(ficha, ficha2, casilla, Comprobacion.Validar)) {
			do {
				if (tablero[numeroI][numeroJ].getFicha() == ficha) {
					salida = true;
					for (int i = casilla.getCoordenada().getPosicion1(),
							j = casilla.getCoordenada().getPosicion2(); i > numeroI && j > numeroJ; i--, j--) {
						tablero[i][j].setFicha(ficha);
					}
				}
				numeroI = numeroI - 1;
				numeroJ = numeroJ - 1;
			} while (!salida);
		}

	}

	private void rotarFichasInclinadoArribaDerecha(Ficha ficha, Ficha ficha2, Casilla casilla) {
		int numeroJ = casilla.getCoordenada().getPosicion1() - 1;
		int numeroI = casilla.getCoordenada().getPosicion2() + 1;
		boolean salida = false;
		if (movimientoInclinadoArribaDerecha(ficha, ficha2, casilla, Comprobacion.Validar)) {
			do {

				if (tablero[numeroI][numeroJ].getFicha() == ficha) {
					salida = true;
					for (int i = casilla.getCoordenada().getPosicion1(),
							j = casilla.getCoordenada().getPosicion2(); i > numeroI && j < numeroJ; i--, j++) {
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
		int numero = casilla.getCoordenada().getPosicion1();
		int numero2 = casilla.getCoordenada().getPosicion2() + 1;
		if (movimientoHorizontalDerecha(ficha, ficha2, casilla, Comprobacion.Validar)) {
			do {

				if (tablero[numero][numero2].getFicha() == ficha) {
					for (int i = casilla.getCoordenada().getPosicion2(); i < numero2; i++) {
						tablero[numero][i].setFicha(ficha);
					}
					escape = true;
				}
				numero2 = numero2 + 1;
			} while (!escape);
		}
	}

	private void rotarFichasHorizontalIzquierda(Ficha ficha, Ficha ficha2, Casilla casilla) {
		boolean escape = false;
		int numero = casilla.getCoordenada().getPosicion1();
		int numero2 = casilla.getCoordenada().getPosicion2() - 1;
		if (movimientoHorizontalIzquierda(ficha, ficha2, casilla, Comprobacion.Validar)) {
			do {
				if (tablero[numero][numero2].getFicha() == ficha) {
					for (int i = numero2; i < casilla.getCoordenada().getPosicion2(); i++) {
						tablero[numero][i].setFicha(ficha);
					}
					escape = true;
				}
				numero2 = numero2 - 1;
			} while (!escape);
		}

	}

	private void rotarFichasVerticalAbajo(Ficha ficha, Ficha ficha2, Casilla casilla) {
		boolean escape = false;
		int numero = casilla.getCoordenada().getPosicion1() + 1;
		int numero2 = casilla.getCoordenada().getPosicion2();

		if (movimientoVerticalAbajo(ficha, ficha2, casilla, Comprobacion.Validar)) {
			do {

				if (tablero[numero][numero2].getFicha() == ficha) {
					escape = true;
					for (int i = casilla.getCoordenada().getPosicion1(); i < numero; i++) {
						tablero[i][numero2].setFicha(ficha);
					}
				}
				numero = numero + 1;
			} while (!escape);
		}

	}

	private void rotarFichasVerticalArriba(Ficha ficha, Ficha ficha2, Casilla casilla) {
		boolean escape = false;
		int numero = casilla.getCoordenada().getPosicion1() - 1;
		int numero2 = casilla.getCoordenada().getPosicion2();
		if (movimientoVerticalArriba(ficha, ficha2, casilla, Comprobacion.Validar)) {
			do {
				if (tablero[numero][numero2].getFicha() == ficha) {
					escape = true;
					for (int i = numero; i < casilla.getCoordenada().getPosicion1(); i++) {
						tablero[i][numero2].setFicha(ficha);
					}
				}
				numero = numero - 1;
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
		if (movimientoHorizontalDerecha(ficha, fichaContrario, devolverCasilla(coordenda), Comprobacion.Validar)
				|| movimientoHorizontalIzquierda(ficha, fichaContrario, devolverCasilla(coordenda),
						Comprobacion.Validar)
				|| movimientoVerticalAbajo(ficha, fichaContrario, devolverCasilla(coordenda), Comprobacion.Validar)
				|| movimientoVerticalArriba(ficha, fichaContrario, devolverCasilla(coordenda), Comprobacion.Validar)
				|| movimientoInclinadoAbajoDerecha(ficha, fichaContrario, devolverCasilla(coordenda),
						Comprobacion.Validar)
				|| movimientoInclinadoAbajoIzquierda(ficha, fichaContrario, devolverCasilla(coordenda),
						Comprobacion.Validar)
				|| movimientoInclinadoArribaIzquierda(ficha, fichaContrario, devolverCasilla(coordenda),
						Comprobacion.Validar)
				|| movimientoInclinadoArribaDerecha(ficha, fichaContrario, devolverCasilla(coordenda),
						Comprobacion.Validar)) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}

	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	private boolean movimientoInclinadoAbajoIzquierda(Ficha ficha, Ficha ficha2, Casilla casilla,
			Comprobacion comprobacion) {
		int tamaño = tablero.length;
		int numeroJ = casilla.getCoordenada().getPosicion1() + 1;
		int numeroI = casilla.getCoordenada().getPosicion2() - 1;
		;
		boolean win = false;
		boolean salida = false;
		if ((numeroJ < tamaño && numeroI >= 0) && tablero[numeroJ][numeroI].getFicha() == ficha2) {
			do {
				numeroI = numeroI + 1;
				numeroJ = numeroJ - 1;
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
					if (comprobacion == Comprobacion.Fin) {
						win = true;
					} else {
						win = false;
					}
				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoInclinadoArribaDerecha(Ficha ficha, Ficha ficha2, Casilla casilla,
			Comprobacion comprobacion) {
		int tamaño = tablero.length;
		int numeroI = casilla.getCoordenada().getPosicion1() - 1;
		int numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		boolean win = false;
		boolean salida = false;
		if ((numeroI >= 0 && numeroJ < tamaño) && tablero[numeroI][numeroJ].getFicha() == ficha2) {
			do {
				numeroI = numeroI - 1;
				numeroJ = numeroJ + 1;
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
					if (comprobacion == Comprobacion.Fin) {
						win = true;
					} else {
						win = false;
					}

				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoInclinadoArribaIzquierda(Ficha ficha, Ficha ficha2, Casilla casilla,
			Comprobacion comprobar) {
		int numeroJ = casilla.getCoordenada().getPosicion1() - 1;
		int numeroI = casilla.getCoordenada().getPosicion2() - 1;
		boolean win = false;
		boolean salida = false;
		if ((numeroJ >= 0 && numeroI >= 0) && tablero[numeroJ][numeroI].getFicha() == ficha2) {
			do {
				numeroI--;
				numeroJ--;
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
					if (comprobar == Comprobacion.Fin) {
						win = true;
					} else {
						win = false;
					}

				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoInclinadoAbajoDerecha(Ficha ficha, Ficha ficha2, Casilla casilla,
			Comprobacion comprobacion) {
		int tamaño = tablero.length;
		int numeroJ = casilla.getCoordenada().getPosicion1() + 1;
		int numeroI = casilla.getCoordenada().getPosicion2() + 1;
		boolean win = false;
		boolean salida = false;
		if ((numeroI < tamaño && numeroJ < tamaño) && tablero[numeroJ][numeroI].getFicha() == ficha2) {
			do {
				numeroI = numeroI + 1;
				numeroJ = numeroJ + 1;
				if (numeroI < 8 && numeroJ < 8) {
					if (tablero[numeroI][numeroJ].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (!tablero[numeroI][numeroJ].isLlena()) {
						salida = true;
						win = false;
					}
				} else {
					salida = true;
					if (comprobacion == Comprobacion.Fin) {
						win = true;
					} else {
						win = false;
					}

				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoVerticalArriba(Ficha ficha, Ficha ficha2, Casilla casilla, Comprobacion comprobacion) {
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
					if (comprobacion == Comprobacion.Fin) {
						win = true;
					} else {
						win = false;
					}
				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoVerticalAbajo(Ficha ficha, Ficha ficha2, Casilla casilla, Comprobacion comprobacion) {
		int tamaño = tablero.length;
		int numero = casilla.getCoordenada().getPosicion1() + 1;
		int numero2 = casilla.getCoordenada().getPosicion2();
		boolean win = false;
		boolean salida = false;
		if (numero < tamaño && tablero[numero][numero2].getFicha() == ficha2) {
			do {
				numero = numero + 1;
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
					if (comprobacion == Comprobacion.Fin) {
						win = true;
					} else {
						win = false;
					}

				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoHorizontalIzquierda(Ficha ficha, Ficha ficha2, Casilla casilla, Comprobacion comprobar) {
		int numero = casilla.getCoordenada().getPosicion1();
		int numero2 = casilla.getCoordenada().getPosicion2() - 1;
		boolean win = false;
		boolean salida = false;
		if (numero2 >= 0 && tablero[numero][numero2].getFicha() == ficha2) {
			do {
				numero2 = numero2 - 1;
				if (numero >= 0) {
					if (tablero[numero][numero2].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (!tablero[numero][numero2].isLlena()) {
						salida = true;
						win = false;
					}
				} else {
					salida = true;
					if (comprobar == Comprobacion.Fin) {
						win = true;
					} else {
						win = false;
					}

				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoHorizontalDerecha(Ficha ficha, Ficha ficha2, Casilla casilla, Comprobacion comprobar) {
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
					if (comprobar == Comprobacion.Fin) {
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
					if (!movimientoInclinadoArribaIzquierda(ficha, ficha2, tablero[i][j], Comprobacion.Fin)) {
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
					if (!movimientoInclinadoAbajoDerecha(ficha, ficha2, tablero[i][j], Comprobacion.Fin)) {
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
					if (!movimientoInclinadoAbajoIzquierda(ficha, ficha2, tablero[i][j], Comprobacion.Fin)) {
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
					if (!movimientoInclinadoArribaDerecha(ficha, ficha2, tablero[i][j], Comprobacion.Fin)) {
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
					if (!movimientoVerticalArriba(ficha, ficha2, tablero[i][j], Comprobacion.Fin)) {
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
					if (!movimientoVerticalAbajo(ficha, ficha2, tablero[i][j], Comprobacion.Fin)) {
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
					if (!movimientoHorizontalIzquierda(ficha, ficha2, tablero[i][j], Comprobacion.Fin)) {
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
					if (!movimientoHorizontalDerecha(ficha, ficha2, tablero[i][j], Comprobacion.Fin)) {
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
		Ficha fichaContraria;

		if (finalPartidaLLeno()) {
			return win;
		}

		if (ficha == Ficha.NEGRO) {
			fichaContraria = Ficha.BLANCO;
		} else {
			fichaContraria = Ficha.NEGRO;
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