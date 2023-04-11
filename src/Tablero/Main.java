package Tablero;


public class Main {
	private void empezarPartida() {
		Tablero tablero= new Tablero();
		tablero.mostrarTablero();
		
		System.out.println();
		
		System.out.println("Blanco "+tablero.finalPartidaBlanco());
		System.out.println("Negro "+tablero.finalPartidaNegro());
	
	}
	public static void main(String[] args) {
		new Main().empezarPartida();
	}
}
