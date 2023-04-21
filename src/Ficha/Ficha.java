package Ficha;

public enum Ficha {
	NEGRO("\u001B[30m ☻ \u001B[0m"), BLANCO("\u001B[37m ☻ \u001B[0m");

	private String resultado;

	private Ficha(String resultado) {
		this.resultado = resultado;
	}

	public String getResultado() {
		return resultado;
	}

	public String devolverFicha() {
		return resultado;
	}

}
