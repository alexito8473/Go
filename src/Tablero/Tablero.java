package Tablero;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import Ficha.Ficha;
import Jugador.Jugador;
import Partida.Colors;

/**
 * Clase donde se crea el tablero y se se realiza sus compraobaciones
 * pertinentes.
 * 
 * @author Alejandro Aguilar Alba
 * @version 1.0
 * @since 1.0
 */
public class Tablero {
	/**
	 * Atributo donde se instancia un array de casillas.
	 */
	private Casilla[][] tablero = new Casilla[8][8];

	/**
	 * Atributo donde se define el final de partida de las fichas negras.
	 */
	private boolean finBlanco = false;

	/**
	 * Atributo donde se define el final de partida de las fichas blanca.
	 */
	private boolean finNegro = false;
	/**
	 * Atributo donde se define el tamño que tiene el array.
	 */
	private final int tamano = tablero.length;

	/**
	 * Constructor donde crea un tablero con piezas por el centro.
	 */
	public Tablero() {
		inicarTablero();
	}

	/**
	 * Constructor donde crea un tablero vacio.
	 * 
	 * @param prueba Prueba
	 */
	public Tablero(boolean prueba) {
		iniciarTableroVacio();
	}

	/**
	 * Metodo que crea el tablero, creando instancias unicas de las casillas.
	 */
	private void inicarTablero() {
		for (int i = 0; i < tamano; i++) {
			for (int j = 0; j < tamano; j++) {
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

	/**
	 * Crea un tablero vacio.
	 */
	private void iniciarTableroVacio() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				tablero[i][j] = new Casilla(i, j);
			}
		}
	}

	/**
	 * Metodo para contar las fichas del tablero.
	 * 
	 * @param ficha La ficha que con la que contamos
	 * @return Nos devolvera una numero que sera el numero de fichas que hay en el
	 *         tablero como minimo sera de 0.
	 */
	public int contador(Ficha ficha) {
		int contador = 0;
		for (int i = 0; i < tamano; i++) {
			for (int j = 0; j < tamano; j++) {
				if (tablero[i][j].getFicha() == ficha) {
					contador++;
				}
			}
		}
		return contador;
	}

	/**
	 * Metodo que esta sobrescrito de la clase Object, donde nos da un hash unico.
	 * 
	 * @return Devuelve un numero unico.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(tablero);
		return result;
	}

	/**
	 * Metodo que sobre escribe el metodo equals de Object, equipara dos objetos y
	 * informa si son iguales.
	 * 
	 * @return true: Son iguales false: No son iguales.
	 */
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

	/**
	 * Metodo que da informacion sobre el jugador y las fichas que hay en la
	 * partida.
	 * 
	 * @param jugador El jugador que hay en ese turno, donde se estrae su nombre,
	 *                ficha.
	 * @param turno   El turno de la partida.
	 */
	public void contandoFichasMostrando(Jugador jugador, int turno) {
		System.out.printf("\n %s ---------------------------------------------%s\n", Colors.PURPLE.getValor(),
				Colors.RESET.getValor());
		System.out.printf(" %s|%s Le toca al jugador %s%-25s%s%s|%s\n", Colors.PURPLE.getValor(),
				Colors.RESET.getValor(), Colors.YELLOW.getValor(), jugador.getNombre(), Colors.RESET.getValor(),
				Colors.PURPLE.getValor(), Colors.RESET.getValor());
		System.out.printf(" %s|%s Tiene la ficha%s, turno %-5d              %s|%s\n", Colors.PURPLE.getValor(),
				Colors.RESET.getValor(), jugador.getFicha().devolverFicha(), turno, Colors.PURPLE.getValor(),
				Colors.RESET.getValor());
		System.out.printf(" %s ---------------------------------------------%s\n", Colors.PURPLE.getValor(),
				Colors.RESET.getValor());
		System.out.printf(" %s --------------------------------------%s\n", Colors.YELLOW.getValor(),
				Colors.RESET.getValor());
		System.out.printf(" %s|%s Fichas negras: %-3dFichas Blancas: %-3d%s|%s\n", Colors.YELLOW.getValor(),
				Colors.RESET.getValor(), contador(Ficha.NEGRO), contador(Ficha.BLANCO), Colors.YELLOW.getValor(),
				Colors.RESET.getValor());
		System.out.printf(" %s --------------------------------------%s\n", Colors.YELLOW.getValor(),
				Colors.RESET.getValor());
	}

	/**
	 * Metodo que devuelve el tablero de la clase
	 * 
	 * @return Devuelve el array de casillas de la clase.
	 */
	public Casilla[][] getTablero() {
		return tablero;
	}

	/**
	 * Metodo que devuelve una casilla en concreto del array de casillas de la
	 * clase.
	 * 
	 * @param coordenada Las coordenadas para buscar la casilla.
	 * @return Devuelve la casilla exacta del array de casillas.
	 */
	public Casilla devolverCasilla(Coordenada coordenada) {
		return tablero[coordenada.getPosicion1()][coordenada.getPosicion2()];
	}

	/**
	 * Metodo que pinta una raya horizontal enla consola.
	 */
	private void pintarRaya() {
		espacioTablero(38);
		for (int i = 0; i < tamano * 3; i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	/**
	 * Metodo que pinta una succesion de letras mayusculas.
	 */
	private void pintarLetras() {
		espacioTablero(32);
		System.out.println("   |  A  B  C  D  E  F  G  H   |");
	}

	/**
	 * Metodo que pinta el tablero , con efecto para que se vea bonito
	 * 
	 * @see #stop(int)
	 * @see #pintarLetras()
	 * @see #pintarRaya()
	 * @see Casilla#devolverCasilla()
	 */
	public void mostrarTablero() {
		System.out.println("\n");
		pintarRaya();
		pintarLetras();
		for (int i = 0; i < tamano; i++) {
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

	/**
	 * Metodo que pinta un tablero que marca las jugadas valida de una ficha en
	 * concreto, con efectos para que se vea bonito.
	 * 
	 * @param ficha La ficha para comparar.
	 * @see #stop(int)
	 * @see #pintarLetras()
	 * @see #pintarRaya()
	 * @see Casilla#devolverCasilla()
	 * @see #movimientoValido(Ficha, Coordenada)
	 */
	public void mostrarTablero(Ficha ficha) {
		System.out.println("\n");
		pintarRaya();
		pintarLetras();
		for (int i = 0; i < tamano; i++) {
			espacioTablero(35);
			System.out.print("|" + (i + 1));
			for (int j = 0; j < tamano; j++) {
				stop(6);
				if (!tablero[i][j].isLlena() && movimientoValido(ficha, tablero[i][j].getCoordenada())) {
					System.out.print(Colors.GREEN.getValor() + " ✦ " + Colors.RESET.getValor());
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

	/**
	 * Metodo que pinta un tablero donde en una coordenada en especifico se pinta
	 * solo en rojo.
	 * 
	 * @param coordenada La coordenada en comparar.
	 * @see #stop(int)
	 * @see #pintarLetras()
	 * @see #pintarRaya()
	 * @see Casilla#devolverCasilla()
	 */
	public void mostrarTablero(Coordenada coordenada) {
		System.out.println("\n");
		pintarRaya();
		pintarLetras();
		for (int i = 0; i < tamano; i++) {
			espacioTablero(35);
			System.out.print("|" + (i + 1));
			for (int j = 0; j < tamano; j++) {
				stop(6);
				if (coordenada.getPosicion1() == i && coordenada.getPosicion2() == j) {
					System.out.print(Colors.RED.getValor() + " ☆ " + Colors.RESET.getValor());
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

	/**
	 * Metodo que para la consola por un tiempo limitado.
	 * 
	 * @param parada El tiempo que se para.
	 */
	private void stop(int parada) {
		try {
			TimeUnit.MILLISECONDS.sleep(parada);
		} catch (InterruptedException e) {

		}
	}

	/**
	 * Metodo que pone espacios.
	 * 
	 * @param espacio El numero de espacio.
	 */
	private void espacioTablero(int espacio) {
		for (int i = 0; i < espacio; i++) {
			System.out.print(" ");
		}
	}
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	/**
	 * Metodo que comprueba si en una coordenada hay una ficha ya en esas coordenada
	 * o no.
	 * 
	 * @param coordenada Las coordenada donde se busca si hay una ficha ya.
	 * @return true: Hay una ficha false: No hay ficha puesta.
	 */
	public boolean comprobarSiHayFichaPuesta(Coordenada coordenada) {
		return tablero[coordenada.getPosicion1()][coordenada.getPosicion2()].isLlena();
	}

	/**
	 * Metodo que añade una ficha en unas coordenada concretas.
	 * 
	 * @param ficha      La ficha donde se introduce en el tablero.
	 * @param coordenada Las coordenadas del tablero.
	 * @see #rotarFichas(Casilla)
	 */
	public void anadirFichaTablero(Ficha ficha, Coordenada coordenada) {
		tablero[coordenada.getPosicion1()][coordenada.getPosicion2()].setFicha(ficha);
		rotarFichas(devolverCasilla(coordenada));
	}

	/**
	 * Metodo donde comprueba si puede rotar en una coordenadas todas las fichas en
	 * las 8 direcciones.
	 * 
	 * @param casilla La casilla de comparacion.
	 * @see #rotarFichasHorizontalDerecha(Casilla)
	 * @see #rotarFichasHorizontalIzquierda(Casilla)
	 * @see #rotarFichasInclinadoAbajoDerecha(Casilla)
	 * @see #rotarFichasInclinadoAbajoIzquierda(Casilla)
	 * @see #rotarFichasInclinadoArribaIzquierda(Casilla)
	 * @see #rotarFichasInclinadoArribaDerecha(Casilla)
	 * @see #rotarFichasVerticalAbajo(Casilla)
	 * @see #rotarFichasVerticalArriba(Casilla)
	 */
	private void rotarFichas(Casilla casilla) {
		rotarFichasVerticalAbajo(casilla);
		rotarFichasVerticalArriba(casilla);
		rotarFichasHorizontalDerecha(casilla);
		rotarFichasHorizontalIzquierda(casilla);
		rotarFichasInclinadoAbajoDerecha(casilla);
		rotarFichasInclinadoArribaDerecha(casilla);
		rotarFichasInclinadoAbajoIzquierda(casilla);
		rotarFichasInclinadoArribaIzquierda(casilla);
	}

	/**
	 * Metodo que comprueba la dirrecion diagonal_abajo_izquierda si se puede rotar,
	 * en el caso que si se puede rota todas las fichas.
	 * 
	 * @param casilla La casilla de comparacion.
	 */
	private void rotarFichasInclinadoAbajoIzquierda(Casilla casilla) {
		int numeroI = casilla.getCoordenada().getPosicion1() + 1, numeroJ = casilla.getCoordenada().getPosicion2() - 1;
		boolean salida = false;
		if (movimientoInclinadoAbajoIzquierda(casilla.getFicha(), casilla.getCoordenada())) {
			do {
				if (tablero[numeroI][numeroJ].getFicha() != casilla.getFicha()) {
					tablero[numeroI][numeroJ].setFicha(casilla.getFicha());
				} else {
					salida = true;
				}
				numeroI++;
				numeroJ--;
			} while (!salida);
		}
	}

	/**
	 * Metodo que comprueba la dirrecion diagonal_abajo_derecha si se puede rotar,
	 * en el caso que si se puede rota todas las fichas.
	 * 
	 * @param casilla La casilla de comparacion.
	 */
	private void rotarFichasInclinadoAbajoDerecha(Casilla casilla) {
		int numeroI = casilla.getCoordenada().getPosicion1() + 1, numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		boolean salida = false;
		if (movimientoInclinadoAbajoDerecha(casilla.getFicha(), casilla.getCoordenada())) {
			do {
				if (tablero[numeroI][numeroJ].getFicha() != casilla.getFicha()) {
					tablero[numeroI][numeroJ].setFicha(casilla.getFicha());
				} else {
					salida = true;
				}
				numeroI++;
				numeroJ++;
			} while (!salida);
		}
	}

	/**
	 * Metodo que comprueba la dirrecion diagonal_arriba_izquierda si se puede
	 * rotar, en el caso que si se puede rota todas las fichas.
	 * 
	 * @param casilla La casilla de comparacion.
	 */
	private void rotarFichasInclinadoArribaIzquierda(Casilla casilla) {
		int numeroI = casilla.getCoordenada().getPosicion1() - 1, numeroJ = casilla.getCoordenada().getPosicion2() - 1;
		boolean salida = false;
		if (movimientoInclinadoArribaIzquierda(casilla.getFicha(), casilla.getCoordenada())) {
			do {

				if (tablero[numeroI][numeroJ].getFicha() != casilla.getFicha()) {
					tablero[numeroI][numeroJ].setFicha(casilla.getFicha());
				} else {
					salida = true;
				}
				numeroI--;
				numeroJ--;
			} while (!salida);
		}

	}

	/**
	 * Metodo que comprueba la dirrecion diagonal_arriba_derecha si se puede rotar,
	 * en el caso que si se puede rota todas las fichas.
	 * 
	 * @param casilla La casilla de comparacion.
	 */
	private void rotarFichasInclinadoArribaDerecha(Casilla casilla) {
		int numeroI = casilla.getCoordenada().getPosicion1() - 1, numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		boolean salida = false;
		if (movimientoInclinadoArribaDerecha(casilla.getFicha(), casilla.getCoordenada())) {
			do {

				if (tablero[numeroI][numeroJ].getFicha() != casilla.getFicha()) {
					tablero[numeroI][numeroJ].setFicha(casilla.getFicha());
				} else {
					salida = true;
				}
				numeroI--;
				numeroJ++;
			} while (!salida);
		}

	}

	/**
	 * Metodo que comprueba la dirrecion horizontal_derecha si se puede rotar, en el
	 * caso que si se puede rota todas las fichas.
	 * 
	 * @param casilla La casilla de comparacion.
	 */
	private void rotarFichasHorizontalDerecha(Casilla casilla) {
		boolean escape = false;
		int numeroI = casilla.getCoordenada().getPosicion1(), numeroJ = casilla.getCoordenada().getPosicion2() + 1;
		if (movimientoHorizontalDerecha(casilla.getFicha(), casilla.getCoordenada())) {
			do {
				if (tablero[numeroI][numeroJ].getFicha() != casilla.getFicha()) {
					tablero[numeroI][numeroJ].setFicha(casilla.getFicha());
				} else {
					escape = true;
				}
				numeroJ++;
			} while (!escape);
		}
	}

	/**
	 * Metodo que comprueba la dirrecion horizontal_izquierda si se puede rotar, en
	 * el caso que si se puede rota todas las fichas.
	 * 
	 * @param casilla La casilla de comparacion.
	 */
	private void rotarFichasHorizontalIzquierda(Casilla casilla) {
		boolean escape = false;
		int numeroI = casilla.getCoordenada().getPosicion1(), numeroJ = casilla.getCoordenada().getPosicion2() - 1;
		if (movimientoHorizontalIzquierda(casilla.getFicha(), casilla.getCoordenada())) {
			do {
				if (tablero[numeroI][numeroJ].getFicha() != casilla.getFicha()) {
					tablero[numeroI][numeroJ].setFicha(casilla.getFicha());
				} else {
					escape = true;
				}
				numeroJ--;
			} while (!escape);
		}

	}

	/**
	 * Metodo que comprueba la dirrecion vertical_abajo si se puede rotar, en el
	 * caso que si se puede rota todas las fichas.
	 * 
	 * @param casilla La casilla de comparacion.
	 */
	private void rotarFichasVerticalAbajo(Casilla casilla) {
		boolean escape = false;
		int numeroI = casilla.getCoordenada().getPosicion1() + 1, numeroJ = casilla.getCoordenada().getPosicion2();
		if (movimientoVerticalAbajo(casilla.getFicha(), casilla.getCoordenada())) {
			do {
				if (tablero[numeroI][numeroJ].getFicha() != casilla.getFicha()) {
					tablero[numeroI][numeroJ].setFicha(casilla.getFicha());
				} else {
					escape = true;
				}
				numeroI++;
			} while (!escape);
		}

	}

	/**
	 * Metodo que comprueba la dirrecion vertical_arriba si se puede rotar, en el
	 * caso que si se puede rota todas las fichas.
	 * 
	 * @param casilla La casilla de comparacion.
	 */
	private void rotarFichasVerticalArriba(Casilla casilla) {
		boolean escape = false;
		int numeroI = casilla.getCoordenada().getPosicion1() - 1, numeroJ = casilla.getCoordenada().getPosicion2();
		if (movimientoVerticalArriba(casilla.getFicha(), casilla.getCoordenada())) {
			do {
				if (tablero[numeroI][numeroJ].getFicha() != casilla.getFicha()) {
					tablero[numeroI][numeroJ].setFicha(casilla.getFicha());
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
	/**
	 * Metodo que comprueba todas las direcciones y dice si hay movimiento o no en
	 * esa coordenada.
	 * 
	 * @param ficha     Ficha a comparar
	 * @param coordenda La coordenada del array.
	 * @return true: Hay movimiento false: no hay movimiento.
	 */
	public boolean movimientoValido(Ficha ficha, Coordenada coordenda) {
		return movimientoHorizontalDerecha(ficha, coordenda) || movimientoHorizontalIzquierda(ficha, coordenda)
				|| movimientoVerticalAbajo(ficha, coordenda) || movimientoVerticalArriba(ficha, coordenda)
				|| movimientoInclinadoAbajoDerecha(ficha, coordenda)
				|| movimientoInclinadoAbajoIzquierda(ficha, coordenda)
				|| movimientoInclinadoArribaIzquierda(ficha, coordenda)
				|| movimientoInclinadoArribaDerecha(ficha, coordenda);

	}

	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	/**
	 * Metodo que con una dirrecion si es valido el movimiento en la direccion
	 * inclianda_abajo_izquierda.
	 * 
	 * @param ficha      La ficha de comparacion
	 * @param coordenada Las coordenada de poscion inicial.
	 * @return true: Hay movimiento false: No hay movimiento.
	 */
	public boolean movimientoInclinadoAbajoIzquierda(Ficha ficha, Coordenada coordenada) {
		int numeroI = coordenada.getPosicion1() + 1, numeroJ = coordenada.getPosicion2() - 1;
		boolean win = false, salida = false;
		if (numeroJ < 0 || numeroI >= tamano) {
			return false;
		} else if (tablero[numeroI][numeroJ].getFicha() == ficha.fichaContraria()) {
			do {
				numeroI++;
				numeroJ--;
				if (numeroJ < 0 || numeroI >= tamano) {
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

	/**
	 * Metodo que con una dirrecion si es valido el movimiento en la direccion
	 * inclianda_arriba_derecha.
	 * 
	 * @param ficha      La ficha de comparacion
	 * @param coordenada Las coordenada de poscion inicial.
	 * @return true: Hay movimiento false: No hay movimiento.
	 */
	public boolean movimientoInclinadoArribaDerecha(Ficha ficha, Coordenada coordenada) {
		int numeroI = coordenada.getPosicion1() - 1, numeroJ = coordenada.getPosicion2() + 1;
		boolean win = false, salida = false;
		if (numeroI < 0 || numeroJ >= tamano) {
			return false;
		} else if (tablero[numeroI][numeroJ].getFicha() == ficha.fichaContraria()) {
			do {
				numeroI--;
				numeroJ++;
				if (numeroI < 0 || numeroJ >= tamano) {
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

	/**
	 * Metodo que con una dirrecion si es valido el movimiento en la direccion
	 * inclianda_arriba_izquierda.
	 * 
	 * @param ficha      La ficha de comparacion
	 * @param coordenada Las coordenada de poscion inicial.
	 * @return true: Hay movimiento false: No hay movimiento.
	 */
	public boolean movimientoInclinadoArribaIzquierda(Ficha ficha, Coordenada coordenada) {
		int numeroI = coordenada.getPosicion1() - 1, numeroJ = coordenada.getPosicion2() - 1;
		boolean win = false, salida = false;
		if (numeroJ < 0 || numeroI < 0) {
			return false;
		} else if (tablero[numeroI][numeroJ].getFicha() == ficha.fichaContraria()) {
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

	/**
	 * Metodo que con una dirrecion si es valido el movimiento en la direccion
	 * inclianda_abajo_derecha.
	 * 
	 * @param ficha      La ficha de comparacion
	 * @param coordenada Las coordenada de poscion inicial.
	 * @return true: Hay movimiento false: No hay movimiento.
	 */
	public boolean movimientoInclinadoAbajoDerecha(Ficha ficha, Coordenada coordenada) {
		int numeroI = coordenada.getPosicion1() + 1, numeroJ = coordenada.getPosicion2() + 1;
		boolean win = false, salida = false;
		if (numeroI >= tamano || numeroJ >= tamano) {
			return false;
		} else if (tablero[numeroI][numeroJ].getFicha() == ficha.fichaContraria()) {
			do {
				numeroI++;
				numeroJ++;
				if (numeroI >= tamano || numeroJ >= tamano) {
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

	/**
	 * Metodo que con una dirrecion si es valido el movimiento en la direccion
	 * vertical_arriba.
	 * 
	 * @param ficha      La ficha de comparacion
	 * @param coordenada Las coordenada de poscion inicial.
	 * @return true: Hay movimiento false: No hay movimiento.
	 */
	public boolean movimientoVerticalArriba(Ficha ficha, Coordenada coordenada) {
		int numero = coordenada.getPosicion1() - 1, numero2 = coordenada.getPosicion2();
		boolean win = false, salida = false;
		if (numero < 0) {
			return false;
		} else if (tablero[numero][numero2].getFicha() == ficha.fichaContraria()) {
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

	/**
	 * Metodo que con una dirrecion si es valido el movimiento en la direccion
	 * vertical_abajo.
	 * 
	 * @param ficha      La ficha de comparacion
	 * @param coordenada Las coordenada de poscion inicial.
	 * @return true: Hay movimiento false: No hay movimiento.
	 */
	public boolean movimientoVerticalAbajo(Ficha ficha, Coordenada coordenada) {
		int numero = coordenada.getPosicion1() + 1, numero2 = coordenada.getPosicion2();
		boolean win = false, salida = false;
		if (numero >= tamano) {
			return false;
		} else if (tablero[numero][numero2].getFicha() == ficha.fichaContraria()) {
			do {
				numero++;
				if (numero >= tamano) {
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

	/**
	 * Metodo que con una dirrecion si es valido el movimiento en la direccion
	 * horzizontal_izquierda.
	 * 
	 * @param ficha      La ficha de comparacion
	 * @param coordenada Las coordenada de poscion inicial.
	 * @return true: Hay movimiento false: No hay movimiento.
	 */
	public boolean movimientoHorizontalIzquierda(Ficha ficha, Coordenada coordenada) {
		int numero = coordenada.getPosicion1(), numero2 = coordenada.getPosicion2() - 1;
		boolean win = false, salida = false;
		if (numero2 < 0) {
			return false;
		} else if (tablero[numero][numero2].getFicha() == ficha.fichaContraria()) {
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

	/**
	 * Metodo que con una dirrecion si es valido el movimiento en la direccion
	 * horzizontal_derecha.
	 * 
	 * @param ficha      La ficha de comparacion
	 * @param coordenada Las coordenada de poscion inicial.
	 * @return true: Hay movimiento false: No hay movimiento.
	 */
	public boolean movimientoHorizontalDerecha(Ficha ficha, Coordenada coordenada) {
		int numero1 = coordenada.getPosicion1(), numero2 = coordenada.getPosicion2() + 1;
		boolean resultado = false, salida = false;
		if (numero2 >= tamano) {
			return false;
		} else if (tablero[numero1][numero2].getFicha() == ficha.fichaContraria()) {
			do {
				numero2++;
				if (numero2 >= tamano) {
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

	/**
	 * Metodo que consulta todo el tablero y comprueba si no hay mas posibles
	 * lugares donde colorcar una ficha.
	 * 
	 * @return true: No existe mas lugares para colocar ficha false: Existe un lugar
	 *         para colocar una ficha.
	 */
	private boolean finalPartidaLLeno() {
		boolean win = true;
		for (int i = 0; i < tamano; i++) {
			for (int j = 0; j < tamano; j++) {
				if (!tablero[i][j].isLlena()) {
					return false;
				}
			}
		}
		return win;
	}

	/**
	 * Metodo que define cuando termina cuando termina una partida.
	 * 
	 * @param ficha La ficha de comparacion
	 * @return true: termino la partida false: aun sigue
	 */
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

	/**
	 * Comprueba que no haya más jugada para un tipo de ficha.
	 * 
	 * @param ficha La ficha de comparacion.
	 */
	private void comprobarFin(Ficha ficha) {
		boolean tipo = ficha == Ficha.NEGRO;
		if (tipo) {
			finNegro = true;
		} else {
			finBlanco = true;
		}
		for (int i = 0; i < tamano; i++) {
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
}