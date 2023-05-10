package Partida;

public class Main {

	private void empezarPartida() {
		Partida partida = new Partida();
		partida.jugarPartida();
	}

	public static void main(String[] args) {

		new Main().empezarPartida();
	}
}
