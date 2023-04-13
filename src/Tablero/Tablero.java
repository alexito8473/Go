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
	
	//------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------

	public boolean movimientoValido(Ficha ficha, int posicion1, int posicion2) {
		Ficha fichaContrario;
		boolean valido=false;
		if(ficha==Ficha.NEGRO) {
			fichaContrario=Ficha.BLANCO;
		}else {
			fichaContrario=Ficha.NEGRO;
		}
		if(movimientoValidarHorizontalDerecha(ficha,fichaContrario,posicion1,posicion2)) {
			valido=true;
		}else {
			valido=false;
		}
		return valido;
	}
	
	private boolean movimientoValidarInclinadoAbajoDerecha(Ficha ficha, Ficha ficha2,int posicion1,int posicion2) {
		int tamaño = tablero.length;
		int numeroJ;
		int numeroI;
		boolean win = true;
		boolean salida = false;
					if ((posicion1 + 1 < tamaño && posicion2 + 1 < tamaño) && tablero[posicion1 + 1][posicion2 + 1].getFicha() == ficha2) {
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
	
	private boolean movimientoValidarVerticalArriba(Ficha ficha, Ficha ficha2,int posicion1,int posicion2) {
		int numero;
		boolean win = true;
		boolean salida = false;
					if (posicion1 - 1 >=0 && tablero[posicion1 + 1][posicion2].getFicha() == ficha2) {
						numero = posicion1 + 1;
						do {
							numero = numero + 1;
							if (numero >=0) {
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
	
	private boolean movimientoValidarVerticalAbajo(Ficha ficha, Ficha ficha2,int posicion1,int posicion2) {
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
	
	private boolean movimientoValidarHorizontalIzquierda(Ficha ficha, Ficha ficha2,int posicion1,int posicion2) {
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
	private boolean movimientoValidarHorizontalDerecha(Ficha ficha, Ficha ficha2,int posicion1,int posicion2) {
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
	
	//------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------
	
	private boolean movimientoInclinadoAbajoIzquierda(Ficha ficha, Ficha ficha2,int posicion1,int posicion2) {
		int tamaño = tablero.length;
		int numeroJ;
		int numeroI;
		boolean win = true;
		boolean salida = false;
					if ((posicion1 + 1 < tamaño && posicion2 - 1 >= 0) && tablero[posicion1 + 1][posicion2 - 1].getFicha() == ficha2) {
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
	
	private boolean movimientoInclinadoArribaDerecha(Ficha ficha, Ficha ficha2,int posicion1,int posicion2) {
		int tamaño = tablero.length;
		int numeroJ;
		int numeroI;
		boolean win = true;
		boolean salida = false;
					if ((posicion1 - 1 >= 0 && posicion2 + 1 < tamaño) && tablero[posicion1 - 1][posicion2 + 1].getFicha() == ficha2) {
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
	
	private boolean movimientoInclinadoArribaIzquierda(Ficha ficha, Ficha ficha2,int posicion1,int posicion2) {
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
	
	private boolean movimientoInclinadoAbajoDerecha(Ficha ficha, Ficha ficha2,int posicion1,int posicion2) {
		int tamaño = tablero.length;
		int numeroJ;
		int numeroI;
		boolean win = true;
		boolean salida = false;
					if ((posicion1 + 1 < tamaño && posicion2 + 1 < tamaño) && tablero[posicion1 + 1][posicion2 + 1].getFicha() == ficha2) {
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
	
	private boolean movimientoVerticalArriba(Ficha ficha, Ficha ficha2,int posicion1,int posicion2) {
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
	private boolean movimientoVerticalAbajo(Ficha ficha, Ficha ficha2,int posicion1,int posicion2){
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
	private boolean movimientoHorizontalIzquierda(Ficha ficha, Ficha ficha2,int posicion1,int posicion2) {
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
	private boolean movimientoHorizontalDerecha(Ficha ficha, Ficha ficha2,int posicion1,int posicion2) {
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
	
	
	//------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------
	
	private boolean comprobarFinPartidaInclinadoArribaIzquierda(Ficha ficha, Ficha ficha2) {
		int tamaño = tablero.length;
		boolean win = true;
		boolean corto = false;
		for (int i = 0; i < tamaño && !corto; i++) {
			for (int j = 0; j < tamaño; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					if(!movimientoInclinadoArribaIzquierda(ficha,ficha2,i,j)) {
						win =false;
						corto=true;
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
					if(!movimientoInclinadoAbajoDerecha(ficha,ficha2,i,j)) {
						win =false;
						corto=true;
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
					if(!movimientoInclinadoAbajoIzquierda(ficha,ficha2,i,j)) {
						win =false;
						corto=true;
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
					if(!movimientoInclinadoAbajoDerecha(ficha,ficha2,i,j)) {
						win =false;
						corto=true;
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
					if(!movimientoVerticalArriba(ficha,ficha2,i,j)) {
						win =false;
						corto=true;
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
					if(!movimientoVerticalAbajo(ficha,ficha2,i,j)) {
						win =false;
						corto=true;
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
					if(!movimientoHorizontalIzquierda(ficha,ficha2,i,j)) {
						win =false;
						corto=true;
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
					if(!movimientoHorizontalDerecha(ficha,ficha2,i,j)) {
						win =false;
						corto=true;
					}
				}
			}
		}
		return win;
	}
	//------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------------
	
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
		if(ficha==Ficha.NEGRO) {
			fichaContraria=Ficha.BLANCO;
		}else {
			fichaContraria=Ficha.NEGRO;
		}
		if (comprobarFinPartidaInclinadoArribaIzquierda(ficha ,fichaContraria )
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
