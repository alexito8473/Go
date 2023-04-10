package Tablero;


public class Main {
	private void empezarPartida() {
		Tablero tablero= new Tablero();
		tablero.mostrarTablero();
		
		System.out.println();
		
		System.out.println(tablero.finalPartidaBlanco());
		
	
	}
	public static void main(String[] args) {
		new Main().empezarPartida();
	}
}
