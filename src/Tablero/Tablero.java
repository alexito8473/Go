package Tablero;

import Ficha.Ficha;

public class Tablero {

	
//	private Casilla[][] tablero = {
//			{new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(), new Casilla()},
//			{new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(), new Casilla()},
//			{new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(), new Casilla()},
//			{new Casilla(),new Casilla(),new Casilla(),new Casilla(Ficha.BLANCO),new Casilla(Ficha.NEGRO),new Casilla(),new Casilla(), new Casilla()},
//			{new Casilla(),new Casilla(),new Casilla(),new Casilla(Ficha.NEGRO), new Casilla(Ficha.BLANCO),new Casilla(),new Casilla(), new Casilla()},
//			{new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(), new Casilla()},
//			{new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(), new Casilla()},
//			{new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(), new Casilla()},
//			};

	private Casilla[][] tablero = {
			{new Casilla(),new Casilla(Ficha.BLANCO),new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(), new Casilla()},
			{new Casilla(),new Casilla(Ficha.BLANCO),new Casilla(),new Casilla(),new Casilla(),new Casilla(),new Casilla(), new Casilla()},
			{new Casilla(),new Casilla(Ficha.BLANCO),new Casilla(Ficha.BLANCO),new Casilla(),new Casilla(),new Casilla(),new Casilla(), new Casilla()},
			{new Casilla(),new Casilla(Ficha.BLANCO),new Casilla(Ficha.BLANCO),new Casilla(Ficha.BLANCO),new Casilla(Ficha.NEGRO),new Casilla(),new Casilla(), new Casilla()},
			{new Casilla(),new Casilla(Ficha.BLANCO),new Casilla(Ficha.BLANCO),new Casilla(Ficha.NEGRO), new Casilla(Ficha.BLANCO),new Casilla(),new Casilla(), new Casilla()},
			{new Casilla(),new Casilla(Ficha.BLANCO),new Casilla(Ficha.BLANCO),new Casilla(),new Casilla(),new Casilla(),new Casilla(), new Casilla()},
			{new Casilla(),new Casilla(Ficha.BLANCO),new Casilla(Ficha.BLANCO),new Casilla(),new Casilla(),new Casilla(),new Casilla(), new Casilla()},
			{new Casilla(),new Casilla(Ficha.BLANCO),new Casilla(Ficha.BLANCO),new Casilla(),new Casilla(),new Casilla(),new Casilla(), new Casilla()},
	};
	
	public Casilla[][] getTablero(){
		return tablero;
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
				System.out.print(tablero[i][j].pintarCasilla());
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
	
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------


	public boolean comprobarSiHayFichaPuesta(int posicion1, int posicion2) {
		if (tablero[posicion1][posicion2].isLlena()) {
			return true;
		} else {
			return false;
		}
	}

	public void añadirFichaTablero(Ficha ficha, int posicion1, int posicion2) {
		tablero[posicion1][posicion2].setFicha(ficha);
		rotarFichas(ficha,posicion1,posicion2);
	}
	private void rotarFichas(Ficha ficha, int posicion1, int posicion2) {
		Ficha fichaContraria;
		if(ficha == Ficha.BLANCO) {
			fichaContraria = Ficha.NEGRO;
		}else {
			fichaContraria = Ficha.BLANCO; 
		}
		if(movimientoValidarHorizontalIzquierda(ficha, fichaContraria, posicion1, posicion2)) {
			rotarFichasHorizontalIzquierda(ficha, posicion1, posicion2);
		}
		if(movimientoValidarVerticalArriba(ficha, fichaContraria, posicion1, posicion2)) {
			rotarFichasVerticalArriba(ficha, posicion1, posicion2);
		}
		if(movimientoValidarVerticalAbajo(ficha, fichaContraria, posicion1, posicion2)) {
			rotarFichasVerticalAbajo(ficha, posicion1, posicion2);
		}
	}
	private void rotarFichasHorizontalIzquierda(Ficha ficha, int posicion1, int posicion2) {
		boolean escape=false;
		int numero=posicion1;
			do {
				numero = numero - 1;
				if (numero >= 0) {
					if (tablero[posicion1][numero].getFicha() == ficha) {
						escape = true;
						for(int i=numero;i<posicion2;i++) {
							tablero[posicion1][i].setFicha(ficha);
						}
					}else if (!tablero[posicion1][numero].isLlena()) {
						escape = true;
					}
				} else {
					escape = true;
				}

			} while (!escape);
		}
	
	private void rotarFichasVerticalAbajo(Ficha ficha, int posicion1, int posicion2) {
		boolean escape=false;
		int tamaño=tablero.length;
		int numero=posicion1;
			do {
				numero = numero + 1;
				if (numero < tamaño) {
					if (!tablero[numero][posicion2].isLlena() ) {
						escape = true;
					} else if (tablero[numero][posicion2].getFicha() == ficha) {
						escape = true;
						for(int i=posicion1;i<numero;i++) {
							tablero[i][posicion2].setFicha(ficha);
						}	
					}
				} else {
					escape = true;
				}
			} while (!escape);
	}
	private void rotarFichasVerticalArriba(Ficha ficha, int posicion1, int posicion2) {
		boolean escape=false;
		int numero=posicion1;
		do {
				numero = numero - 1;
				if (numero >= 0) {
					if (!tablero[numero][posicion2].isLlena() ) {
						escape = true;
					} else if (tablero[numero][posicion2].getFicha() == ficha) {
						escape = true;
						for(int i=numero;i<posicion1;i++) {
							tablero[i][posicion2].setFicha(ficha);
						}
					}
				} else {
					escape = true;
				}
			} while (!escape);
	}
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	public boolean movimientoValido(Ficha ficha, int posicion1, int posicion2) {
		Ficha fichaContrario;
		boolean valido = false;
		if (ficha == Ficha.NEGRO) {
			fichaContrario = Ficha.BLANCO;
		} else {
			fichaContrario = Ficha.NEGRO;
		}
		if (movimientoValidarHorizontalDerecha(ficha, fichaContrario, posicion1, posicion2)
				|| movimientoValidarHorizontalIzquierda(ficha, fichaContrario, posicion1, posicion2)
				|| movimientoValidarVerticalAbajo(ficha, fichaContrario, posicion1, posicion2)
				|| movimientoValidarVerticalArriba(ficha, fichaContrario, posicion1, posicion2)
				|| movimientoValidarInclinadoAbajoDerecha(ficha, fichaContrario, posicion1, posicion2)
				|| movimientoValidarInclinadoAbajoIzquierda(ficha, fichaContrario, posicion1, posicion2)
				|| movimientoValidarInclinadoArribaIzquierda(ficha, fichaContrario, posicion1, posicion2)
				|| movimientoValidarInclinadoArribaDerecha(ficha, fichaContrario, posicion1, posicion2)) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}

	private boolean movimientoValidarInclinadoArribaDerecha(Ficha ficha, Ficha ficha2, int posicion1, int posicion2) {
		int tamaño = tablero.length;
		int numeroJ;
		int numeroI;
		boolean win = true;
		boolean salida = false;
		if ((posicion1 - 1 >= 0 && posicion2 + 1 < tamaño)
				&& tablero[posicion1 - 1][posicion2 + 1].getFicha() == ficha2) {
			numeroI = posicion1 - 1;
			numeroJ = posicion2 + 1;
			do {
				numeroI = numeroI - 1;
				numeroJ = numeroJ + 1;
				if (numeroI >= 0 && numeroJ < tamaño) {
					if (tablero[numeroI][numeroJ].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (tablero[numeroI][numeroJ].getFicha() == ficha2) {
						salida = false;
						win = false;
					} else if (!tablero[numeroI][numeroJ].isLlena()) {
						salida = true;
						win = false;
					}
				} else {
					salida = true;
					win = false;
				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoValidarInclinadoAbajoIzquierda(Ficha ficha, Ficha ficha2, int posicion1, int posicion2) {
		int tamaño = tablero.length;
		int numeroJ;
		int numeroI;
		boolean win = true;
		boolean salida = false;
		if ((posicion1 + 1 < tamaño && posicion2 - 1 >= 0)
				&& tablero[posicion1 + 1][posicion2 - 1].getFicha() == ficha2) {
			numeroI = posicion1 + 1;
			numeroJ = posicion2 - 1;
			do {
				numeroI = numeroI + 1;
				numeroJ = numeroJ - 1;
				if (numeroI < tamaño && numeroJ >= 0) {
					if (tablero[numeroI][numeroJ].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (tablero[numeroI][numeroJ].getFicha() == ficha2) {
						salida = false;
						win = false;
					} else if (!tablero[numeroI][numeroJ].isLlena()) {
						salida = true;
						win = false;
					}
				} else {
					salida = true;
					win = false;
				}

			} while (!salida);
		}
		return win;

	}

	private boolean movimientoValidarInclinadoArribaIzquierda(Ficha ficha, Ficha ficha2, int posicion1, int posicion2) {
		int numeroJ;
		int numeroI;
		boolean win = true;
		boolean salida = false;
		if ((posicion1 - 1 >= 0 && posicion2 - 1 >= 0) && tablero[posicion1 - 1][posicion2 - 1].getFicha() == ficha2) {
			numeroI = posicion1 - 1;
			numeroJ = posicion2 - 1;
			do {
				numeroI = numeroI - 1;
				numeroJ = numeroJ - 1;
				if (numeroI >= 0 && numeroJ >= 0) {
					if (tablero[numeroI][numeroJ].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (tablero[numeroI][numeroJ].getFicha() == ficha2) {
						salida = false;
						win = false;
					} else if (!tablero[numeroI][numeroJ].isLlena()) {
						salida = true;
						win = false;
					}
				} else {
					salida = true;
					win = false;
				}

			} while (!salida);
		}
		return win;

	}

	private boolean movimientoValidarInclinadoAbajoDerecha(Ficha ficha, Ficha ficha2, int posicion1, int posicion2) {
		int tamaño = tablero.length;
		int numeroJ;
		int numeroI;
		boolean win = true;
		boolean salida = false;
		if ((posicion1 + 1 < tamaño && posicion2 + 1 < tamaño)
				&& tablero[posicion1 + 1][posicion2 + 1].getFicha() == ficha2) {
			numeroI = posicion1 + 1;
			numeroJ = posicion2 + 1;
			do {
				numeroI = numeroI + 1;
				numeroJ = numeroJ + 1;
				if (numeroI < 8 && numeroJ < 8) {
					if (tablero[numeroI][numeroJ].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (tablero[numeroI][numeroJ].getFicha() == ficha2) {
						salida = false;
						win = false;
					} else if (!tablero[numeroI][numeroJ].isLlena()) {
						salida = true;
						win = false;
					}
				} else {
					salida = true;
					win = false;
				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoValidarVerticalArriba(Ficha ficha, Ficha ficha2, int posicion1, int posicion2) {
		int numero;
		boolean win = true;
		boolean salida = false;
		if (posicion1 - 1 >= 0 && tablero[posicion1 + 1][posicion2].getFicha() == ficha2) {
			numero = posicion1 + 1;
			do {
				numero = numero - 1;
				if (numero >= 0) {
					if (tablero[numero][posicion2].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (tablero[numero][posicion2].getFicha() == ficha2) {
						salida = false;
						win = false;
					} else if (!tablero[numero][posicion2].isLlena()) {
						salida = true;
						win = false;
					}
				} else {
					salida = true;
					win = false;
				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoValidarVerticalAbajo(Ficha ficha, Ficha ficha2, int posicion1, int posicion2) {
		int tamaño = tablero.length;
		int numero;
		boolean win = true;
		boolean salida = false;
		if (posicion1 + 1 < tamaño && tablero[posicion1 + 1][posicion2].getFicha() == ficha2) {
			numero = posicion1 + 1;
			do {
				numero = numero + 1;
				if (numero < tamaño) {
					if (tablero[numero][posicion2].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (tablero[numero][posicion2].getFicha() == ficha2) {
						salida = false;
						win = false;
					} else if (!tablero[numero][posicion2].isLlena()) {
						salida = true;
						win = false;
					}
				} else {
					salida = true;
					win = false;
				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoValidarHorizontalIzquierda(Ficha ficha, Ficha ficha2, int posicion1, int posicion2) {
		int numero;
		boolean resultado = true;
		boolean salida = false;
		if (posicion1 - 1 >= 0 && tablero[posicion1][posicion2 + 1].getFicha() == ficha2) {
			numero = posicion2 - 1;
			do {
				numero = numero - 1;
				if (numero >= 0) {
					if (tablero[posicion1][numero].getFicha() == ficha) {
						salida = true;
						resultado = true;
					} else if (!tablero[posicion1][numero].isLlena()) {
						salida = true;
						resultado = false;
					}
				} else {
					salida = true;
					resultado = false;
				}

			} while (!salida);
		}
		return resultado;
	}

	private boolean movimientoValidarHorizontalDerecha(Ficha ficha, Ficha ficha2, int posicion1, int posicion2) {
		int tamaño = tablero.length;
		int numero;
		boolean resultado = true;
		boolean salida = false;
		if (posicion1 + 1 < tamaño && tablero[posicion1][posicion2 + 1].getFicha() == ficha2) {
			numero = posicion2 + 1;
			do {
				numero = numero + 1;
				if (numero < tamaño) {
					if (tablero[posicion1][numero].getFicha() == ficha) {
						salida = true;
						resultado = true;
					} else if (tablero[posicion1][numero].getFicha() == ficha2) {
						salida = false;
						resultado = false;
					} else if (!tablero[posicion1][numero].isLlena()) {
						salida = true;
						resultado = false;
					}
				} else {
					salida = true;
					resultado = false;
				}

			} while (!salida);
		}
		return resultado;
	}

	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	private boolean movimientoInclinadoAbajoIzquierda(Ficha ficha, Ficha ficha2, int posicion1, int posicion2) {
		int tamaño = tablero.length;
		int numeroJ;
		int numeroI;
		boolean win = true;
		boolean salida = false;
		if ((posicion1 + 1 < tamaño && posicion2 - 1 >= 0)
				&& tablero[posicion1 + 1][posicion2 - 1].getFicha() == ficha2) {
			numeroI = posicion1 + 1;
			numeroJ = posicion2 - 1;
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
					}
				} else {
					salida = true;
					win = true;
				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoInclinadoArribaDerecha(Ficha ficha, Ficha ficha2, int posicion1, int posicion2) {
		int tamaño = tablero.length;
		int numeroJ;
		int numeroI;
		boolean win = true;
		boolean salida = false;
		if ((posicion1 - 1 >= 0 && posicion2 + 1 < tamaño)
				&& tablero[posicion1 - 1][posicion2 + 1].getFicha() == ficha2) {
			numeroI = posicion1 - 1;
			numeroJ = posicion2 + 1;
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
					}
				} else {
					salida = true;
					win = true;
				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoInclinadoArribaIzquierda(Ficha ficha, Ficha ficha2, int posicion1, int posicion2) {
		int numeroJ;
		int numeroI;
		boolean win = true;
		boolean salida = false;
		if ((posicion1 - 1 >= 0 && posicion2 - 1 >= 0) && tablero[posicion1 - 1][posicion2 - 1].getFicha() == ficha2) {
			numeroI = posicion1 - 1;
			numeroJ = posicion2 - 1;
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
					}
				} else {
					salida = true;
					win = true;
				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoInclinadoAbajoDerecha(Ficha ficha, Ficha ficha2, int posicion1, int posicion2) {
		int tamaño = tablero.length;
		int numeroJ;
		int numeroI;
		boolean win = true;
		boolean salida = false;
		if ((posicion1 + 1 < tamaño && posicion2 + 1 < tamaño)
				&& tablero[posicion1 + 1][posicion2 + 1].getFicha() == ficha2) {
			numeroI = posicion1 + 1;
			numeroJ = posicion2 + 1;
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
					}
				} else {
					salida = true;
					win = true;
				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoVerticalArriba(Ficha ficha, Ficha ficha2, int posicion1, int posicion2) {
		int numero;
		boolean win = true;
		boolean salida = false;
		if (posicion1 - 1 >= 0 && tablero[posicion1 - 1][posicion2].getFicha() == ficha2) {
			numero = posicion1 - 1;
			do {
				numero = numero - 1;
				if (numero >= 0) {
					if (tablero[numero][posicion2].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (tablero[numero][posicion2].getFicha() == ficha2) {
						salida = false;
						win = true;
					} else if (!tablero[numero][posicion2].isLlena()) {
						salida = true;
						win = false;
					}
				} else {
					salida = true;
					win = true;
				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoVerticalAbajo(Ficha ficha, Ficha ficha2, int posicion1, int posicion2) {
		int tamaño = tablero.length;
		int numero;
		boolean win = true;
		boolean salida = false;
		if (posicion1 + 1 < tamaño && tablero[posicion1 + 1][posicion2].getFicha() == ficha2) {
			numero = posicion1 + 1;
			do {
				numero = numero + 1;
				if (numero < 8) {
					if (tablero[numero][posicion2].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (tablero[numero][posicion2].getFicha() == ficha2) {
						salida = false;
						win = true;
					} else if (!tablero[numero][posicion2].isLlena()) {
						salida = true;
						win = false;
					}
				} else {
					salida = true;
					win = true;
				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoHorizontalIzquierda(Ficha ficha, Ficha ficha2, int posicion1, int posicion2) {
		int numero;
		boolean win = true;
		boolean salida = false;
		if (posicion2 - 1 >= 0 && tablero[posicion1][posicion2 - 1].getFicha() == ficha2) {
			numero = posicion2 - 1;
			do {
				numero = numero - 1;
				if (numero >= 0) {
					if (tablero[posicion1][numero].getFicha() == ficha) {
						salida = true;
						win = true;
					} else if (tablero[posicion1][numero].getFicha() == ficha2) {
						salida = false;
						win = true;
					} else if (!tablero[posicion1][numero].isLlena()) {
						salida = true;
						win = false;
					}
				} else {
					salida = true;
					win = true;
				}

			} while (!salida);
		}
		return win;
	}

	private boolean movimientoHorizontalDerecha(Ficha ficha, Ficha ficha2, int posicion1, int posicion2) {
		int tamaño = tablero.length;
		int numero;
		boolean resultado = true;
		boolean salida = false;
		if (posicion1 + 1 < tamaño && tablero[posicion1][posicion2 + 1].getFicha() == ficha2) {
			numero = posicion2 + 1;
			do {
				numero = numero + 1;
				if (numero < tamaño) {
					if (tablero[posicion1][numero].getFicha() == ficha) {
						salida = true;
						resultado = true;
					} else if (tablero[posicion1][numero].getFicha() == ficha2) {
						salida = false;
						resultado = true;
					} else if (!tablero[posicion1][numero].isLlena()) {
						salida = true;
						resultado = false;
					}
				} else {
					salida = true;
					resultado = true;
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
					if (!movimientoInclinadoArribaIzquierda(ficha, ficha2, i, j)) {
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
					if (!movimientoInclinadoAbajoDerecha(ficha, ficha2, i, j)) {
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
					if (!movimientoInclinadoAbajoIzquierda(ficha, ficha2, i, j)) {
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
					if (!movimientoInclinadoArribaDerecha(ficha, ficha2, i, j)) {
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
					if (!movimientoVerticalArriba(ficha, ficha2, i, j)) {
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
					if (!movimientoVerticalAbajo(ficha, ficha2, i, j)) {
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
					if (!movimientoHorizontalIzquierda(ficha, ficha2, i, j)) {
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
					if (!movimientoHorizontalDerecha(ficha, ficha2, i, j)) {
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