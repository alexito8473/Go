package Tablero;

import Fichas.Ficha;
import Jugador.Jugador;

public class Tablero {
	private String[][] tablero = { 
			{ "   ", " A ", " B ", " C ", " D ", " E ", " F ", " G ", " H ", "  " },
			{ " 1 ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " 1" },
			{ " 2 ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " 2" },
			{ " 3 ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " 3" },
			{ " 4 ", " . ", " . ", " . ", " ☺ ", " ☻ ", " . ", " . ", " . ", " 4" },
			{ " 5 ", " . ", " . ", " . ", " ☻ ", " ☺ ", " . ", " . ", " . ", " 5" },
			{ " 6 ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " 6" },
			{ " 7 ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " 7" },
			{ " 8 ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " 8" },
			{ "   ", " A ", " B ", " C ", " D ", " E ", " F ", " G ", " H ", "  " } };
	
	// ☻ Negro      ☺ Blanco
	
	private String[][] tableroRepuesto={ 
		{ "   ", " A ", " B ", " C ", " D ", " E ", " F ", " G ", " H ", "  " },
		{ " 1 ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " 1" },
		{ " 2 ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " 2" },
		{ " 3 ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " 3" },
		{ " 4 ", " . ", " . ", " . ", " ☺ ", " ☻ ", " . ", " . ", " . ", " 4" },
		{ " 5 ", " . ", " . ", " . ", " ☻ ", " ☺ ", " . ", " . ", " . ", " 5" },
		{ " 6 ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " 6" },
		{ " 7 ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " 7" },
		{ " 8 ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " . ", " 8" },
		{ "   ", " A ", " B ", " C ", " D ", " E ", " F ", " G ", " H ", "  " } };
	
	private String[][] tableroa={ 
			{ "   ", " A ", " B ", " C ", " D ", " E ", " F ", " G ", " H ", "  " },
			{ " 1 ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " 1" },
			{ " 2 ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " 2" },
			{ " 3 ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " 3" },
			{ " 4 ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " . ", " 4" },
			{ " 5 ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☺ ", " ☻ ", " ☻ ", " 5" },
			{ " 6 ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " 6" },
			{ " 7 ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☺ ", " ☻ ", " ☻ ", " 7" },
			{ " 8 ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " ☻ ", " 8" },
			{ "   ", " A ", " B ", " C ", " D ", " E ", " F ", " G ", " H ", "  " } };

	public Tablero() {
//		reinicioTablero();
	}
	
	public void mostrarTablero() {
		int tamaño = tablero.length;
		System.out.print(" ");
		for (int i = 0; i < tamaño * 3; i++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i = 0; i < tamaño; i++) {
			System.out.print("|");
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j]);
			}
			System.out.print(" |");
			System.out.println();
		}
		System.out.print(" ");
		for (int i = 0; i < tamaño * 3; i++) {
			System.out.print("-");
		}
	}
	 private void reinicioTablero() {
		for(int i=0;i<tablero.length;i++) {
			for(int j=0;j<tablero[i].length;j++) {
				tablero[i][j]=tableroRepuesto[i][j];
			}
		}
	}
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
		 
		   for(int i=1;i<tamaño;i++) {
			   for(int j=1;j<tamaño;j++) {			   
				   if(tablero[i][j].equals(" . ")) {
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
		 if(comprobarFinPartidaHorizontal(Ficha.BLANCO , Ficha.NEGRO)&&comprobarFinPartidaVertical(Ficha.BLANCO , Ficha.NEGRO)) {
			 win=true;
		 }else {
			 win =false;
		 }
		 return win;
	 }
	 
	 public boolean finalPartidaNegro() {
		 boolean win=finalPartida();
		 win=comprobarFinPartidaHorizontal(Ficha.NEGRO , Ficha.BLANCO);
		 return win;
	 }
	 //True termino la partida, false aun sigue
	 private boolean  comprobarFinPartidaVertical(Ficha ficha , Ficha ficha2) {
		 int tamaño=tablero.length;
		 int numero;
		 boolean win=true;
		 boolean salida=false;
		 boolean corto=false;
		  for(int i=1;i<tamaño&&!corto;i++) {
			   for(int j=1;j<tamaño;j++) {	
				   if(tablero[i][j].equals(ficha.getResultado())) {
					   if(tablero[i+1][j].equals(ficha2.getResultado())) {
						   numero=i+1;
						   do {
							  numero=numero+1;
							   if(numero<9) {
								   if(tablero[numero][j].equals(ficha.getResultado())) {
									   salida=true;
									   win=true;
								   }else if(tablero[numero][j].equals(ficha2.getResultado())) {
									   salida=false;
									   win=true;
								   }else if(tablero[numero][j].equals(" . ")){
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
	 private boolean comprobarFinPartidaHorizontal(Ficha ficha , Ficha ficha2) {
		 int tamaño=tablero.length;
		 int numero;
		 boolean win=true;
		 boolean salida=false;
		 boolean corto=false;
		  for(int i=1;i<tamaño&&!corto;i++) {
			   for(int j=1;j<tamaño;j++) {	
				   if(tablero[i][j].equals(ficha.getResultado())) {
					   if(tablero[i][j+1].equals(ficha2.getResultado())) {
						   numero=j+1;
						   do {
							  numero=numero+1;
							   if(numero<9) {
								   if(tablero[i][numero].equals(ficha.getResultado())) {
									   salida=true;
									   win=true;
								   }else if(tablero[i][numero].equals(ficha2.getResultado())) {
									   salida=false;
									   win=true;
								   }else if(tablero[i][numero].equals(" . ")){
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
