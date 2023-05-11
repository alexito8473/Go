package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import Ficha.Ficha;
import Tablero.Casilla;
import Tablero.Coordenada;
import Tablero.Tablero;

class HorizontalDerechaNegra {

	private Casilla[][] crearTableroVacio() {
		Casilla[][] tableroDevolver = new Casilla[8][8];
		for (int i = 0; i < tableroDevolver.length; i++) {
			for (int j = 0; j < tableroDevolver.length; j++) {
				tableroDevolver[i][j] = new Casilla(i, j);
			}
		}
		return tableroDevolver;
	}

	private void rellenarHorizontal(Coordenada posicion1, Coordenada posicion2, Casilla[][] tablero, Ficha ficha) {
		for (int j = posicion1.getPosicion2(); j <= posicion2.getPosicion2(); j++) {
			tablero[posicion1.getPosicion1()][j].setFicha(ficha);
		}
		tablero[posicion1.getPosicion1()][posicion2.getPosicion2() + 1].setFicha(ficha);
	}

	private void rellenaVertical(Coordenada posicion1, Coordenada posicion2, Casilla[][] tablero, Ficha ficha) {
		for (int i = posicion1.getPosicion1(); i <= posicion2.getPosicion1(); i++) {
			tablero[i][posicion1.getPosicion2()].setFicha(ficha);
		}
	}

	private void rellenaInclinadaArriba(Coordenada posicion1, Coordenada posicion2, Casilla[][] tablero, Ficha ficha) {
		for (int i = posicion1.getPosicion1(), j = posicion1.getPosicion2(); i >= posicion2.getPosicion1()
				&& j <= posicion2.getPosicion2(); i--, j++) {
			tablero[i][j].setFicha(ficha);
		}
	}

	private void rellenaInclinadaAbajo(Coordenada posicion1, Coordenada posicion2, Casilla[][] tablero, Ficha ficha) {
		for (int i = posicion1.getPosicion1(), j = posicion1.getPosicion2(); i <= posicion2.getPosicion1()
				&& j <= posicion2.getPosicion2(); i++, j++) {
			tablero[i][j].setFicha(ficha);
		}
	}

	private void ponerFicha(Casilla casilla, Ficha ficha) {
		casilla.setFicha(ficha);
	}

	@Test
	void horizontal_Vertical_Inclinado_Comer1_MedioTablero() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(4, 1), new Coordenada(4, 4), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(2, 3), new Coordenada(6, 3), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaArriba(new Coordenada(6, 1), new Coordenada(2, 5), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaAbajo(new Coordenada(2, 1), new Coordenada(6, 5), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(4, 2), new Coordenada(4, 3), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(3, 3), new Coordenada(5, 3), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaArriba(new Coordenada(5, 2), new Coordenada(2, 6), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaAbajo(new Coordenada(3, 2), new Coordenada(5, 4), tableroPrueba.getTablero(), Ficha.BLANCO);
		ponerFicha(tableroPrueba.getTablero()[2][1], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[2][5], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[4][1], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[2][3], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[6][3], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[4][5], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[6][1], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[6][5], Ficha.NEGRO);
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(4, 3));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontal_Vertical_Inclinado_Comer2_MedioTablero() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(4, 0), new Coordenada(4, 5), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(1, 3), new Coordenada(7, 3), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaArriba(new Coordenada(7, 0), new Coordenada(1, 6), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaAbajo(new Coordenada(1, 0), new Coordenada(7, 6), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(4, 1), new Coordenada(4, 4), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(2, 3), new Coordenada(6, 3), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaArriba(new Coordenada(6, 1), new Coordenada(2, 5), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaAbajo(new Coordenada(2, 1), new Coordenada(6, 5), tableroPrueba.getTablero(), Ficha.BLANCO);
		ponerFicha(tableroPrueba.getTablero()[2][1], Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[1][0], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[1][3], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[1][6], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[4][0], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[4][6], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[7][0], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[7][3], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[7][6], Ficha.NEGRO);
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(4, 3));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontalDerecha_VerticalArriba_InclinadoArribaDerecha_Comer3_MedioTablero() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(6, 1), new Coordenada(6, 4), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(2, 1), new Coordenada(5, 1), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaArriba(new Coordenada(6, 1), new Coordenada(2, 5), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(6, 1), new Coordenada(6, 3), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(3, 1), new Coordenada(5, 1), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaArriba(new Coordenada(6, 1), new Coordenada(3, 4), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[2][1], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[2][5], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[6][5], Ficha.NEGRO);
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(6, 1));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontalIzquierda_VerticalArriba_InclinadoArribaIzquierda_Comer3_MedioTablero() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(6, 2), new Coordenada(6, 5), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(2, 6), new Coordenada(5, 6), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaAbajo(new Coordenada(2, 2), new Coordenada(6, 6), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(6, 3), new Coordenada(6, 5), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(3, 6), new Coordenada(5, 6), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaAbajo(new Coordenada(3, 3), new Coordenada(6, 6), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[6][2], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[2][2], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[2][6], Ficha.NEGRO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(6, 6));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontalIzquierda_VerticalAbajo_InclinadoAbajoIzquierda_Comer3_MedioTablero() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(1, 2), new Coordenada(1, 5), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(2, 6), new Coordenada(5, 6), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaArriba(new Coordenada(5, 2), new Coordenada(2, 5), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(1, 3), new Coordenada(1, 5), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(2, 6), new Coordenada(4, 6), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaArriba(new Coordenada(4, 3), new Coordenada(2, 5), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[1][2], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[5][6], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[5][2], Ficha.NEGRO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(1, 6));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontalDerecha_VerticalAbajo_InclinadoAbajoDerecha_Comer3_MedioTablero() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(1, 1), new Coordenada(1, 4), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(2, 1), new Coordenada(5, 1), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaAbajo(new Coordenada(2, 2), new Coordenada(5, 5), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(1, 1), new Coordenada(1, 3), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(2, 1), new Coordenada(4, 1), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaAbajo(new Coordenada(2, 2), new Coordenada(4, 4), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[1][5], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[5][1], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[5][5], Ficha.NEGRO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(1, 1));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontalDerecha_VerticalAbajo_InclinadoAbajoDerecha_Comer1_Borde() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(0, 0), new Coordenada(0, 1), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(1, 0), new Coordenada(2, 0), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaAbajo(new Coordenada(1, 1), new Coordenada(2, 2), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(0, 0), new Coordenada(0, 0), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(1, 0), new Coordenada(1, 0), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaAbajo(new Coordenada(1, 1), new Coordenada(1, 1), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[0][2], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[2][2], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[2][0], Ficha.NEGRO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(0, 0));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontalDerecha_VerticalAbajo_InclinadoAbajoDerecha_Comer3_Borde() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(0, 0), new Coordenada(0, 3), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(1, 0), new Coordenada(4, 0), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaAbajo(new Coordenada(1, 1), new Coordenada(4, 4), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(0, 0), new Coordenada(0, 2), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(1, 0), new Coordenada(3, 0), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaAbajo(new Coordenada(1, 1), new Coordenada(3, 3), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[0][4], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[4][4], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[4][0], Ficha.NEGRO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(0, 0));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(0, 0));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontalDerecha_VerticalAbajo_InclinadoAbajoDerecha_ComerTodo_Borde() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(0, 0), new Coordenada(0, 6), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(1, 0), new Coordenada(7, 0), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaAbajo(new Coordenada(1, 1), new Coordenada(7, 7), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(0, 0), new Coordenada(0, 6), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(1, 0), new Coordenada(6, 0), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaAbajo(new Coordenada(1, 1), new Coordenada(6, 6), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[0][7], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[7][7], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[7][0], Ficha.NEGRO);
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(0, 0));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontalIzquierda_VerticalAbajo_InclinadoAbajoIzquierda_Comer1_Borde() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(0, 5), new Coordenada(0, 6), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(1, 7), new Coordenada(2, 7), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaArriba(new Coordenada(2, 5), new Coordenada(1, 6), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(0, 6), new Coordenada(0, 6), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(1, 7), new Coordenada(1, 7), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaArriba(new Coordenada(1, 6), new Coordenada(1, 6), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[0][5], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[2][7], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[2][5], Ficha.NEGRO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(0, 7));

		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontalIzquierda_VerticalAbajo_InclinadoAbajoIzquierda_Comer3_Borde() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(0, 3), new Coordenada(0, 6), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(1, 7), new Coordenada(4, 7), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaArriba(new Coordenada(4, 3), new Coordenada(1, 6), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(0, 4), new Coordenada(0, 6), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(1, 7), new Coordenada(3, 7), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaArriba(new Coordenada(3, 4), new Coordenada(1, 6), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[0][3], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[4][7], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[4][3], Ficha.NEGRO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(0, 7));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontalIzquierda_VerticalAbajo_InclinadoAbajoIzquierda_ComerTodo_Borde() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(0, 0), new Coordenada(0, 6), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(1, 7), new Coordenada(7, 7), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaArriba(new Coordenada(7, 0), new Coordenada(1, 6), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(0, 1), new Coordenada(0, 6), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(1, 7), new Coordenada(6, 7), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaArriba(new Coordenada(6, 1), new Coordenada(1, 6), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[0][0], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[7][7], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[7][0], Ficha.NEGRO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(0, 7));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontalIzquierda_VerticalArriba_InclinadoArribaIzquierda_Comer1_Borde() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(7, 5), new Coordenada(7, 6), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(5, 7), new Coordenada(7, 7), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaAbajo(new Coordenada(5, 5), new Coordenada(6, 6), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(7, 6), new Coordenada(7, 6), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(6, 7), new Coordenada(7, 7), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaAbajo(new Coordenada(6, 6), new Coordenada(6, 6), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[5][7], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[5][5], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[7][5], Ficha.NEGRO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(7, 7));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontalIzquierda_VerticalArriba_InclinadoArribaIzquierda_Comer3_Borde() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(7, 3), new Coordenada(7, 6), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(3, 7), new Coordenada(7, 7), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaAbajo(new Coordenada(3, 3), new Coordenada(6, 6), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(7, 4), new Coordenada(7, 6), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(4, 7), new Coordenada(7, 7), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaAbajo(new Coordenada(4, 4), new Coordenada(6, 6), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[3][7], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[7][3], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[3][3], Ficha.NEGRO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(7, 7));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontalIzquierda_VerticalArriba_InclinadoArribaIzquierda_ComerTodo_Borde() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(7, 0), new Coordenada(7, 6), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(0, 7), new Coordenada(7, 7), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaAbajo(new Coordenada(0, 0), new Coordenada(6, 6), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(7, 1), new Coordenada(7, 6), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(1, 7), new Coordenada(7, 7), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaAbajo(new Coordenada(1, 1), new Coordenada(6, 6), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[0][0], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[7][0], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[0][7], Ficha.NEGRO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(7, 7));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontalDerecho_VerticalArriba_InclinadoArribaDerecho_Comer1_Borde() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(7, 0), new Coordenada(7, 1), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(5, 0), new Coordenada(7, 0), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaArriba(new Coordenada(7, 0), new Coordenada(5, 2), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(7, 0), new Coordenada(7, 0), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(6, 0), new Coordenada(6, 0), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaArriba(new Coordenada(7, 0), new Coordenada(6, 1), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[5][0], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[5][2], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[7][2], Ficha.NEGRO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(7, 0));

		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontalDerecho_VerticalArriba_InclinadoArribaDerecho_Comer3_Borde() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(7, 0), new Coordenada(7, 3), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(3, 0), new Coordenada(7, 0), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaArriba(new Coordenada(7, 0), new Coordenada(3, 4), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(7, 0), new Coordenada(7, 2), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(4, 0), new Coordenada(6, 0), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaArriba(new Coordenada(7, 0), new Coordenada(4, 3), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[3][0], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[3][4], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[7][4], Ficha.NEGRO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(7, 0));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void horizontalDerecho_VerticalArriba_InclinadoArribaDerecho_ComerTodo_Borde() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(7, 0), new Coordenada(7, 6), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(0, 0), new Coordenada(7, 0), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaArriba(new Coordenada(7, 0), new Coordenada(0, 7), tableroDevolver, Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(7, 0), new Coordenada(7, 5), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(1, 0), new Coordenada(6, 0), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaArriba(new Coordenada(7, 0), new Coordenada(1, 6), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[7][7], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[0][7], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[0][0], Ficha.NEGRO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(7, 0));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void HorizontalNoValido() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenarHorizontal(new Coordenada(1, 1), new Coordenada(1, 1), tableroDevolver, Ficha.NEGRO);
		rellenarHorizontal(new Coordenada(2, 2), new Coordenada(2, 6), tableroDevolver, Ficha.BLANCO);
		rellenarHorizontal(new Coordenada(3, 2), new Coordenada(3, 3), tableroDevolver, Ficha.BLANCO);
		rellenarHorizontal(new Coordenada(5, 5), new Coordenada(5, 5), tableroDevolver, Ficha.NEGRO);
		rellenarHorizontal(new Coordenada(6, 0), new Coordenada(6, 4), tableroDevolver, Ficha.BLANCO);
		rellenarHorizontal(new Coordenada(7, 3), new Coordenada(7, 4), tableroDevolver, Ficha.BLANCO);

		ponerFicha(tableroDevolver[2][1], Ficha.NEGRO);
		ponerFicha(tableroDevolver[3][1], Ficha.NEGRO);
		ponerFicha(tableroDevolver[6][6], Ficha.NEGRO);
		ponerFicha(tableroDevolver[7][6], Ficha.NEGRO);

		rellenarHorizontal(new Coordenada(1, 1), new Coordenada(1, 1), tableroPrueba.getTablero(), Ficha.NEGRO);
		rellenarHorizontal(new Coordenada(2, 2), new Coordenada(2, 6), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenarHorizontal(new Coordenada(3, 2), new Coordenada(3, 3), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenarHorizontal(new Coordenada(5, 5), new Coordenada(5, 5), tableroPrueba.getTablero(), Ficha.NEGRO);
		rellenarHorizontal(new Coordenada(6, 0), new Coordenada(6, 4), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenarHorizontal(new Coordenada(7, 3), new Coordenada(7, 4), tableroPrueba.getTablero(), Ficha.BLANCO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(1, 1));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(2, 1));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(3, 1));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(5, 5));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(6, 6));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(7, 6));

		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void verticalNoValido() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenaVertical(new Coordenada(1, 1), new Coordenada(2, 1), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(2, 2), new Coordenada(7, 2), tableroDevolver, Ficha.BLANCO);
		rellenaVertical(new Coordenada(2, 3), new Coordenada(4, 3), tableroDevolver, Ficha.BLANCO);
		rellenaVertical(new Coordenada(5, 5), new Coordenada(6, 6), tableroDevolver, Ficha.NEGRO);
		rellenaVertical(new Coordenada(0, 6), new Coordenada(5, 6), tableroDevolver, Ficha.BLANCO);
		rellenaVertical(new Coordenada(3, 7), new Coordenada(5, 7), tableroDevolver, Ficha.BLANCO);

		ponerFicha(tableroDevolver[1][2], Ficha.NEGRO);
		ponerFicha(tableroDevolver[1][3], Ficha.NEGRO);
		ponerFicha(tableroDevolver[6][6], Ficha.NEGRO);
		ponerFicha(tableroDevolver[6][7], Ficha.NEGRO);

		rellenaVertical(new Coordenada(2, 1), new Coordenada(2, 1), tableroPrueba.getTablero(), Ficha.NEGRO);
		rellenaVertical(new Coordenada(2, 2), new Coordenada(7, 2), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(2, 3), new Coordenada(4, 3), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(5, 5), new Coordenada(5, 5), tableroPrueba.getTablero(), Ficha.NEGRO);
		rellenaVertical(new Coordenada(0, 6), new Coordenada(5, 6), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaVertical(new Coordenada(3, 7), new Coordenada(5, 7), tableroPrueba.getTablero(), Ficha.BLANCO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(1, 1));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(1, 2));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(1, 3));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(6, 5));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(6, 6));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(6, 7));

		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void inclinada() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenaInclinadaAbajo(new Coordenada(0, 5), new Coordenada(2, 7), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaAbajo(new Coordenada(0, 4), new Coordenada(3, 7), tableroDevolver, Ficha.NEGRO);

		rellenaInclinadaAbajo(new Coordenada(5, 0), new Coordenada(7, 2), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaAbajo(new Coordenada(4, 0), new Coordenada(7, 3), tableroDevolver, Ficha.NEGRO);

		rellenaInclinadaArriba(new Coordenada(3, 0), new Coordenada(0, 3), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaArriba(new Coordenada(2, 0), new Coordenada(0, 2), tableroDevolver, Ficha.NEGRO);

		rellenaInclinadaArriba(new Coordenada(7, 4), new Coordenada(4, 7), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaArriba(new Coordenada(7, 5), new Coordenada(5, 7), tableroDevolver, Ficha.NEGRO);

		rellenaInclinadaAbajo(new Coordenada(1, 6), new Coordenada(1, 6), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaAbajo(new Coordenada(1, 5), new Coordenada(3, 7), tableroPrueba.getTablero(), Ficha.BLANCO);

		rellenaInclinadaAbajo(new Coordenada(6, 1), new Coordenada(6, 1), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaAbajo(new Coordenada(5, 1), new Coordenada(6, 2), tableroPrueba.getTablero(), Ficha.BLANCO);

		rellenaInclinadaArriba(new Coordenada(2, 1), new Coordenada(1, 2), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaArriba(new Coordenada(1, 1), new Coordenada(1, 1), tableroPrueba.getTablero(), Ficha.BLANCO);

		rellenaInclinadaArriba(new Coordenada(6, 5), new Coordenada(3, 6), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaArriba(new Coordenada(6, 6), new Coordenada(6, 6), tableroPrueba.getTablero(), Ficha.BLANCO);

		ponerFicha(tableroPrueba.getTablero()[3][7], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[0][5], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[7][3], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[5][0], Ficha.NEGRO);

		ponerFicha(tableroPrueba.getTablero()[3][0], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[0][2], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[7][4], Ficha.NEGRO);
		ponerFicha(tableroPrueba.getTablero()[5][7], Ficha.NEGRO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(2, 7));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(0, 4));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(7, 2));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(4, 0));

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(2, 0));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(0, 3));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(7, 5));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(4, 7));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void inclinada_AbajoDerecha_ArribaIzquierdaNV() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenaInclinadaAbajo(new Coordenada(2, 6), new Coordenada(2, 6), tableroDevolver, Ficha.BLANCO);
		rellenaInclinadaAbajo(new Coordenada(2, 5), new Coordenada(2, 5), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaAbajo(new Coordenada(2, 4), new Coordenada(5, 7), tableroDevolver, Ficha.BLANCO);

		rellenaInclinadaAbajo(new Coordenada(5, 1), new Coordenada(5, 1), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaAbajo(new Coordenada(5, 2), new Coordenada(5, 2), tableroDevolver, Ficha.BLANCO);
		rellenaInclinadaAbajo(new Coordenada(2, 0), new Coordenada(5, 3), tableroDevolver, Ficha.BLANCO);

		ponerFicha(tableroDevolver[1][5], Ficha.NEGRO);
		ponerFicha(tableroDevolver[1][4], Ficha.NEGRO);
		ponerFicha(tableroDevolver[1][3], Ficha.NEGRO);
		ponerFicha(tableroDevolver[6][2], Ficha.NEGRO);
		ponerFicha(tableroDevolver[6][3], Ficha.NEGRO);
		ponerFicha(tableroDevolver[6][4], Ficha.NEGRO);

		rellenaInclinadaAbajo(new Coordenada(2, 6), new Coordenada(2, 6), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaAbajo(new Coordenada(2, 5), new Coordenada(2, 5), tableroPrueba.getTablero(), Ficha.NEGRO);
		rellenaInclinadaAbajo(new Coordenada(2, 4), new Coordenada(5, 7), tableroPrueba.getTablero(), Ficha.BLANCO);

		rellenaInclinadaAbajo(new Coordenada(5, 1), new Coordenada(5, 1), tableroPrueba.getTablero(), Ficha.NEGRO);
		rellenaInclinadaAbajo(new Coordenada(5, 2), new Coordenada(5, 2), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaAbajo(new Coordenada(2, 0), new Coordenada(5, 3), tableroPrueba.getTablero(), Ficha.BLANCO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(1, 5));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(1, 4));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(1, 3));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(6, 2));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(6, 3));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(6, 4));

		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

	@Test
	void inclinada_ArribaDerecha_AbajoIzquierdaNV() {
		Tablero tableroPrueba = new Tablero(true);
		Casilla[][] tableroDevolver = crearTableroVacio();

		rellenaInclinadaArriba(new Coordenada(5, 6), new Coordenada(2, 6), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaArriba(new Coordenada(5, 5), new Coordenada(5, 5), tableroDevolver, Ficha.BLANCO);
		rellenaInclinadaArriba(new Coordenada(5, 4), new Coordenada(2, 7), tableroDevolver, Ficha.BLANCO);

		rellenaInclinadaArriba(new Coordenada(2, 1), new Coordenada(2, 1), tableroDevolver, Ficha.NEGRO);
		rellenaInclinadaArriba(new Coordenada(2, 2), new Coordenada(2, 2), tableroDevolver, Ficha.BLANCO);
		rellenaInclinadaArriba(new Coordenada(5, 0), new Coordenada(2, 3), tableroDevolver, Ficha.BLANCO);

		ponerFicha(tableroDevolver[1][2], Ficha.NEGRO);
		ponerFicha(tableroDevolver[1][3], Ficha.NEGRO);
		ponerFicha(tableroDevolver[1][4], Ficha.NEGRO);
		ponerFicha(tableroDevolver[6][3], Ficha.NEGRO);
		ponerFicha(tableroDevolver[6][4], Ficha.NEGRO);
		ponerFicha(tableroDevolver[6][5], Ficha.NEGRO);

		rellenaInclinadaArriba(new Coordenada(5, 6), new Coordenada(2, 6), tableroPrueba.getTablero(), Ficha.NEGRO);
		rellenaInclinadaArriba(new Coordenada(5, 5), new Coordenada(5, 5), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaArriba(new Coordenada(5, 4), new Coordenada(2, 7), tableroPrueba.getTablero(), Ficha.BLANCO);

		rellenaInclinadaArriba(new Coordenada(2, 1), new Coordenada(2, 1), tableroPrueba.getTablero(), Ficha.NEGRO);
		rellenaInclinadaArriba(new Coordenada(2, 2), new Coordenada(2, 2), tableroPrueba.getTablero(), Ficha.BLANCO);
		rellenaInclinadaArriba(new Coordenada(5, 0), new Coordenada(2, 3), tableroPrueba.getTablero(), Ficha.BLANCO);

		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(1, 2));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(1, 3));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(1, 4));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(6, 3));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(6, 4));
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(6, 5));
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}
}
