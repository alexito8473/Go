package Tablero;

import Fichas.Casilla;
import Fichas.Ficha;
import Jugador.Jugador;

public class Tablero {

//	private Casilla[][] tablero = {
//			{new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false), new Casilla(false)},
//			{new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false), new Casilla(false)},
//			{new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false), new Casilla(false)},
//			{new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.NEGRO) ,new Casilla(false),new Casilla(false), new Casilla(false)},
//			{new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(true).meterFicha(Ficha.NEGRO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(false),new Casilla(false), new Casilla(false)},
//			{new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false), new Casilla(false)},
//			{new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false), new Casilla(false)},
//			{new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false), new Casilla(false)},
//			};

	// ☻ Negro ☺ Blanco

	private Casilla[][] tablero = {
			{ new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(false), new Casilla(false),new Casilla(false), new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO)},
			{ new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),  new Casilla(true).meterFicha(Ficha.NEGRO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(false) },
			{ new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.NEGRO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(false), new Casilla(false) },
			{ new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.NEGRO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO) },
			{ new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.NEGRO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO) },
			{ new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(false), new Casilla(true).meterFicha(Ficha.BLANCO).meterFicha(Ficha.BLANCO) },
			{ new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(false), new Casilla(true).meterFicha(Ficha.BLANCO).meterFicha(Ficha.BLANCO) },
			{ new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO) }, };

	public Tablero() {
//		reinicioTablero();
	}

	public void mostrarTablero() {
		int tamaño = tablero.length;
		System.out.print("  ");
		for (int i = 0; i < tamaño * 3; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|  A  B  C  D  E  F  G  H   |");
		System.out.println();
		for (int i = 0; i < tamaño; i++) {
			System.out.print("|" + (i + 1));
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.print(i + 1 + " |");
			System.out.println();
		}
		System.out.println("|  A  B  C  D  E  F  G  H   |");
		System.out.print("  ");
		for (int i = 0; i < tamaño * 3; i++) {
			System.out.print("-");
		}
	}

	private void reinicioTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if ((i == 4 && j == 4) || (i == 3 && j == 3)) {
					tablero[i][j] = new Casilla(true).meterFicha(Ficha.BLANCO);
				} else if ((i == 4 && j == 3) || (i == 3 && j == 4)) {
					tablero[i][j] = new Casilla(true).meterFicha(Ficha.NEGRO);
				} else {
					tablero[i][j] = new Casilla(false);
				}

			}
		}
	}

	public void añadirFicha(int a, int b, int algo) {

	}

	public void añadirFichaTablero(Jugador jugador, int posicion1, int posicion2) {
		String compraracion;

	}

	private boolean finalPartida() {
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

	public boolean finalPartidaBlanco() {
		boolean win = true;

		if (finalPartida()) {
			return win;
		}
		if (comprobarFinPartidaInclinadoArribaIzquierda(Ficha.BLANCO , Ficha.NEGRO )
				&& comprobarFinPartidaInclinadoAbajoDerecha(Ficha.BLANCO, Ficha.NEGRO)
				&& comprobarFinPartidaInclinadoAbajoIzquieda(Ficha.BLANCO, Ficha.NEGRO)
				&& comprobarFinPartidaInclinadoArribaDerecha(Ficha.BLANCO, Ficha.NEGRO)
				&& comprobarFinPartidaVerticalArriba(Ficha.BLANCO, Ficha.NEGRO)
				&& comprobarFinPartidaHorizontalIzquierda(Ficha.BLANCO, Ficha.NEGRO)
				&& comprobarFinPartidaHorizontalDerecha(Ficha.BLANCO, Ficha.NEGRO)
				&& comprobarFinPartidaVerticalAbajo(Ficha.BLANCO, Ficha.NEGRO)) {
			win = true;
		} else {
			win = false;
		}
		return win;
	}

	public boolean finalPartidaNegro() {
		boolean win = true;
		if (finalPartida()) {
			return win;
		}
		if (comprobarFinPartidaInclinadoAbajoDerecha(Ficha.NEGRO, Ficha.BLANCO) 
				&& comprobarFinPartidaInclinadoArribaIzquierda(Ficha.NEGRO , Ficha.BLANCO )
				&& comprobarFinPartidaInclinadoAbajoIzquieda(Ficha.NEGRO, Ficha.BLANCO)
				&& comprobarFinPartidaInclinadoArribaDerecha(Ficha.NEGRO, Ficha.BLANCO)
				&& comprobarFinPartidaVerticalArriba(Ficha.NEGRO, Ficha.BLANCO)
				&& comprobarFinPartidaHorizontalIzquierda(Ficha.NEGRO, Ficha.BLANCO)
				&& comprobarFinPartidaHorizontalDerecha(Ficha.NEGRO, Ficha.BLANCO)
				&& comprobarFinPartidaVerticalAbajo(Ficha.NEGRO, Ficha.BLANCO)) {
			win = true;
		} else {
			win = false;
		}
		return win;
	}

	// True termino la partida, false aun sigue
	private boolean comprobarFinPartidaInclinadoArribaIzquierda(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		int numeroJ;
		int numeroI;
		boolean win = true;
		boolean salida = false;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if ((i + 1 < tamaño && j - 1 >= 0) && tablero[i + 1][j - 1].getFicha() == ficha2) {
						numeroI = i + 1;
						numeroJ = j - 1;
						do {
							numeroI = numeroI + 1;
							numeroJ = numeroJ - 1;
							if (numeroI < tamaño && numeroJ >= 0) {
								if (tablero[numeroI][numeroJ].getFicha() == ficha) {
									salida = true;
									win = true;
								} else if (tablero[numeroI][numeroJ].getFicha() == ficha2) {
									salida = false;
									win = true;
								} else if (!tablero[numeroI][numeroJ].isLlena()) {
									salida = true;
									win = false;
									corto = true;
								}
							} else {
								salida = true;
								win = true;
							}

						} while (!salida);
					}
				}
			}
		}
		return win;
	}

	private boolean comprobarFinPartidaInclinadoAbajoDerecha(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		int numeroJ;
		int numeroI;
		boolean win = true;
		boolean salida = false;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if ((i - 1 >= 0 && j + 1 < tamaño) && tablero[i - 1][j + 1].getFicha() == ficha2) {
						numeroI = i - 1;
						numeroJ = j + 1;
						do {
							numeroI = numeroI - 1;
							numeroJ = numeroJ + 1;
							if (numeroI >= 0 && numeroJ < tamaño) {
								if (tablero[numeroI][numeroJ].getFicha() == ficha) {
									salida = true;
									win = true;
								} else if (tablero[numeroI][numeroJ].getFicha() == ficha2) {
									salida = false;
									win = true;
								} else if (!tablero[numeroI][numeroJ].isLlena()) {
									salida = true;
									win = false;
									corto = true;
								}
							} else {
								salida = true;
								win = true;
							}

						} while (!salida);
					}
				}
			}
		}
		return win;
	}

	private boolean comprobarFinPartidaInclinadoAbajoIzquieda(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		int numeroJ;
		int numeroI;
		boolean win = true;
		boolean salida = false;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if ((i - 1 >= 0 && j - 1 >= 0) && tablero[i - 1][j - 1].getFicha() == ficha2) {
						numeroI = i - 1;
						numeroJ = j - 1;
						do {
							numeroI = numeroI - 1;
							numeroJ = numeroJ - 1;
							if (numeroI >= 0 && numeroJ >= 0) {
								if (tablero[numeroI][numeroJ].getFicha() == ficha) {
									salida = true;
									win = true;
								} else if (tablero[numeroI][numeroJ].getFicha() == ficha2) {
									salida = false;
									win = true;
								} else if (!tablero[numeroI][numeroJ].isLlena()) {
									salida = true;
									win = false;
									corto = true;
								}
							} else {
								salida = true;
								win = true;
							}

						} while (!salida);
					}
				}
			}
		}
		return win;
	}

	private boolean comprobarFinPartidaInclinadoArribaDerecha(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		int numeroJ;
		int numeroI;
		boolean win = true;
		boolean salida = false;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if ((i + 1 < tamaño && j + 1 < tamaño) && tablero[i + 1][j + 1].getFicha() == ficha2) {
						numeroI = i + 1;
						numeroJ = j + 1;
						do {
							numeroI = numeroI + 1;
							numeroJ = numeroJ + 1;
							if (numeroI < 8 && numeroJ < 8) {
								if (tablero[numeroI][numeroJ].getFicha() == ficha) {
									salida = true;
									win = true;
								} else if (tablero[numeroI][numeroJ].getFicha() == ficha2) {
									salida = false;
									win = true;
								} else if (!tablero[numeroI][numeroJ].isLlena()) {
									salida = true;
									win = false;
									corto = true;
								}
							} else {
								salida = true;
								win = true;
							}

						} while (!salida);
					}
				}
			}
		}
		return win;
	}

	private boolean comprobarFinPartidaVerticalArriba(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		int numero;
		boolean win = true;
		boolean salida = false;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if (i - 1 >= 0 && tablero[i - 1][j].getFicha() == ficha2) {
						numero = i - 1;
						do {
							numero = numero - 1;
							if (numero >= 0) {
								if (tablero[numero][j].getFicha() == ficha) {
									salida = true;
									win = true;
								} else if (tablero[numero][j].getFicha() == ficha2) {
									salida = false;
									win = true;
								} else if (!tablero[numero][j].isLlena()) {
									salida = true;
									win = false;
									corto = true;
								}
							} else {
								salida = true;
								win = true;
							}

						} while (!salida);
					}
				}
			}
		}
		return win;
	}

	private boolean comprobarFinPartidaVerticalAbajo(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		int numero;
		boolean win = true;
		boolean salida = false;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if (i + 1 < tamaño && tablero[i + 1][j].getFicha() == ficha2) {
						numero = i + 1;
						do {
							numero = numero + 1;
							if (numero < 8) {
								if (tablero[numero][j].getFicha() == ficha) {
									salida = true;
									win = true;
								} else if (tablero[numero][j].getFicha() == ficha2) {
									salida = false;
									win = true;
								} else if (!tablero[numero][j].isLlena()) {
									salida = true;
									win = false;
									corto = true;
								}
							} else {
								salida = true;
								win = true;
							}

						} while (!salida);
					}
				}
			}
		}
		return win;
	}

	private boolean comprobarFinPartidaHorizontalIzquierda(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		int numero;
		boolean win = true;
		boolean salida = false;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if (j - 1 >= 0 && tablero[i][j - 1].getFicha() == ficha2) {
						numero = j - 1;
						do {
							numero = numero - 1;
							if (numero >= 0) {
								if (tablero[i][numero].getFicha() == ficha) {
									salida = true;
									win = true;
								} else if (tablero[i][numero].getFicha() == ficha2) {
									salida = false;
									win = true;
								} else if (!tablero[i][numero].isLlena()) {
									salida = true;
									win = false;
									corto = true;
								}
							} else {
								salida = true;
								win = true;
							}

						} while (!salida);
					}
				}
			}
		}
		return win;
	}

	private boolean comprobarFinPartidaHorizontalDerecha(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		int numero;
		boolean win = true;
		boolean salida = false;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if (j + 1 < tamaño && tablero[i][j + 1].getFicha() == ficha2) {
						numero = j + 1;
						do {
							numero = numero + 1;
							if (numero < 8) {
								if (tablero[i][numero].getFicha() == ficha) {
									salida = true;
									win = true;
								} else if (tablero[i][numero].getFicha() == ficha2) {
									salida = false;
									win = true;
								} else if (!tablero[i][numero].isLlena()) {
									salida = true;
									win = false;
									corto = true;
								}
							} else {
								salida = true;
								win = true;
							}

						} while (!salida);
					}
				}
			}
		}
		return win;
	}
}
