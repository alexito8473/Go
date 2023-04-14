package Ficha;

public enum Ficha {
	NEGRO(" ☺ "),BLANCO(" ☻ ");
	
	private String resultado;
	
	private Ficha(String resultado) {
		this.resultado=resultado;
	}
	
	public String getResultado() {
		return resultado;
	}
	public String pintarFicha() {
		return resultado;
	}
	
}
