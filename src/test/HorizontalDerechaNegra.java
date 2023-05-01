package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import Ficha.Ficha;
import Tablero.Casilla;
import Tablero.Coordenada;
import Tablero.Tablero;

class HorizontalDerechaNegra {
	
	private Casilla[][] crearTableroVacio(){
		Casilla[][] tableroDevolver= new Casilla[8][8];
		for(int i=0;i<tableroDevolver.length;i++) {
			for(int j=0;j<tableroDevolver.length;j++) {
				tableroDevolver[i][j] = new Casilla(i,j);
			}
		}
		return tableroDevolver;
	}
	
//	private void limpiarTablero(Casilla[][] tablero) {
//		for(int i=0;i<tablero.length;i++) {
//			for(int j=0;j<tablero.length;j++) {
//				tablero[i][j].setLlena(false);
//			}
//		}
//	}
	private void rellenarHorizontalDerecha(Coordenada posicion1,Coordenada posicion2,Casilla[][] tablero) {
		if(posicion1==posicion2) {
			tablero[posicion1.getPosicion1()][posicion1.getPosicion2()].setFicha(Ficha.NEGRO);
			tablero[posicion1.getPosicion1()][posicion1.getPosicion2()+1].setFicha(Ficha.NEGRO);
		}else {
			for(int j=posicion1.getPosicion2();j<=posicion2.getPosicion2();j++) {
				tablero[posicion1.getPosicion1()][j].setFicha(Ficha.NEGRO);
			}
			tablero[posicion1.getPosicion1()][posicion2.getPosicion2()+1].setFicha(Ficha.NEGRO);
		}
		
	}
	private void rellenarHorizontalDerechaTest(Coordenada posicion1,Coordenada posicion2,Casilla[][] tablero) {
		if(posicion1==posicion2) {
			tablero[posicion1.getPosicion1()][posicion1.getPosicion2()].setFicha(Ficha.BLANCO);
			tablero[posicion1.getPosicion1()][posicion1.getPosicion2()+1].setFicha(Ficha.NEGRO);
		}else {
			for(int j=posicion1.getPosicion2();j<=posicion2.getPosicion2();j++) {
				tablero[posicion1.getPosicion1()][j].setFicha(Ficha.BLANCO);
			}
			tablero[posicion1.getPosicion1()][posicion2.getPosicion2()+1].setFicha(Ficha.NEGRO);
		}
		
	}
	@Test
	void Horizontalderecha() {
		Tablero tableroPrueba= new Tablero();
		Casilla[][] tableroDevolver = crearTableroVacio();
//		limpiarTablero(tableroPrueba.getTablero());
		rellenarHorizontalDerecha(new Coordenada(0,0),new Coordenada(0,1),tableroDevolver);
		
//		for(int i=0;i<tableroDevolver.length;i++) {
//			for(int j=0;j<tableroDevolver.length;j++) {
//				System.out.print(tableroDevolver[i][j].devolverCasilla());
//			}
//			System.out.println();
//		}
		
		rellenarHorizontalDerechaTest(new Coordenada(0,1),new Coordenada(0,1),tableroPrueba.getTablero());
		tableroPrueba.añadirFichaTablero(Ficha.NEGRO, new Coordenada(0,0));
		tableroPrueba.mostrarTablero();
		Assert.assertArrayEquals(tableroDevolver, tableroPrueba.getTablero());
	}

}
