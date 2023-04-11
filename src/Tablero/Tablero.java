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
	
	// ☻ Negro      ☺ Blanco
	
	private Casilla[][] tableroRepuesto = {
			{new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false), new Casilla(false)},
			{new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false), new Casilla(false)},
			{new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false), new Casilla(false)},
			{new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.NEGRO) ,new Casilla(false),new Casilla(false), new Casilla(false)},
			{new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(true).meterFicha(Ficha.NEGRO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(false),new Casilla(false), new Casilla(false)},
			{new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false), new Casilla(false)},
			{new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false), new Casilla(false)},
			{new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false), new Casilla(false)},
			};
	
	private Casilla[][] tablero = {
			{new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false), new Casilla(false)},
			{new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(false),new Casilla(false),new Casilla(false),new Casilla(false), new Casilla(false)},
			{new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.NEGRO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(false), new Casilla(false)},
			{new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.NEGRO) ,new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO)},
			{new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.NEGRO), new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO)},
			{new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(false), new Casilla(true).meterFicha(Ficha.BLANCO).meterFicha(Ficha.BLANCO)},
			{new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(false), new Casilla(true).meterFicha(Ficha.BLANCO).meterFicha(Ficha.BLANCO)},
			{new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO),new Casilla(true).meterFicha(Ficha.BLANCO), new Casilla(true).meterFicha(Ficha.BLANCO)},
			};

	public Tablero() {
//		reinicioTablero();
	}
	
	public void mostrarTablero() {
		int tamaño = tablero.length;
		System.out.print("  ");
		for (int i = 0; i < tamaño*3; i++) {
			System.out.print("-");
		}
		System.out.println();
		System.out.print("|  A  B  C  D  E  F  G  H   |");
		System.out.println();
		for (int i = 0; i < tamaño; i++) {
			System.out.print("|"+(i+1));
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.print(i+1+" |");
			System.out.println();
		}
		System.out.println("|  A  B  C  D  E  F  G  H   |");
		System.out.print("  ");
		for (int i = 0; i < tamaño*3; i++) {
			System.out.print("-");
		}
	}
//	 private void reinicioTablero() {
//		for(int i=0;i<tablero.length;i++) {
//			for(int j=0;j<tablero[i].length;j++) {
//				tablero[i][j]=tableroRepuesto[i][j];
//			}
//		}
//	}
	 public  void añadirFicha(int a, int b, int algo) {
		 String forma;
		 if(algo==1) {
			 forma=" ☺ ";
		 }else {
			 forma=" ☻ ";
		 }
		 
	 }
	 public void añadirFichaTablero(Jugador jugador,int posicion1,int posicion2) {
		 String compraracion;
		 
	 }
	 
	 private boolean finalPartida() {
		 boolean win=true;
		 int tamaño=tablero.length;
		 
		   for(int i=1;i<tamaño&&win;i++) {
			   for(int j=1;j<tamaño&&win;j++) {			   
				   if(!tablero[i][j].isLlena()) {
					   win=false;
				   }
			   }
		   }		   
		   
		   return win;
	 }
	 
	 public boolean finalPartidaBlanco() {
		 boolean win=true;
		 
		 if(finalPartida()) {
			 return win;
		 }
		 if(comprobarFinPartidaHorizontalDerecha(Ficha.BLANCO , Ficha.NEGRO)&&comprobarFinPartidaVerticalAbajo(Ficha.BLANCO , Ficha.NEGRO)) {
			 win=true;
		 }else {
			 win =false;
		 }
		 return win;
	 }
	 
	 public boolean finalPartidaNegro() {
		 boolean win=finalPartida();
		 if(comprobarFinPartidaHorizontalDerecha(Ficha.NEGRO , Ficha.BLANCO)&&comprobarFinPartidaVerticalAbajo(Ficha.NEGRO , Ficha.BLANCO)) {
			 win=true;
		 }else {
			 win =false;
		 }
		 return win;
	 }
	 //True termino la partida, false aun sigue
	 private boolean  comprobarFinPartidaVerticalAbajo(Ficha ficha , Ficha ficha2) {
		 int tamaño=tablero.length;
		 int numero;
		 boolean win=true;
		 boolean salida=false;
		 boolean corto=false;
		  for(int i=0;i<tamaño&&!corto;i++) {
			   for(int j=0;j<tamaño;j++) {	
				   if(tablero[i][j].getFicha()==ficha) {
					   if(i+1<tamaño&&tablero[i+1][j].getFicha()==ficha2) {
						   numero=i+1;
						   do {
							  numero=numero+1;
							   if(numero<9) {
								   if(tablero[numero][j].getFicha()==ficha) {
									   salida=true;
									   win=true;
								   }else if(tablero[numero][j].getFicha()==ficha2) {
									   salida=false;
									   win=true;
								   }else if(!tablero[numero][j].isLlena()){
									   salida=true;
									   win=false;
									   corto=true;
								   }
							   }else {
								   salida=true;
								   win=true;
							   }
							  
						   }while(!salida);
					   }
				   }
				 
			   }
		   }
		  return win;
	 }
	 private boolean comprobarFinPartidaHorizontalDerecha(Ficha ficha , Ficha ficha2) {
		 int tamaño=tablero.length;
		 int numero;
		 boolean win=true;
		 boolean salida=false;
		 boolean corto=false;
		  for(int i=0;i<tamaño&&!corto;i++) {
			   for(int j=0;j<tamaño;j++) {	
				   if(tablero[i][j].getFicha()==ficha) {
					   if(j+1<tamaño&&tablero[i][j+1].getFicha()==ficha2) {
						   numero=j+1;
						   do {
							  numero=numero+1;
							   if(numero<9) {
								   if(tablero[i][numero].getFicha()==ficha) {
									   salida=true;
									   win=true;
								   }else if(tablero[i][numero].getFicha()==ficha2) {
									   salida=false;
									   win=true;
								   }else if(!tablero[i][numero].isLlena()){
									   salida=true;
									   win=false;
									   corto=true;
								   }
							   }else {
								   salida=true;
								   win=true;
							   }
							  
						   }while(!salida);
					   }
				   }
				 
			   }
		   }
		  return win;
	 }
}
