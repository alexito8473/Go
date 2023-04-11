package Fichas;

public enum Ficha {
	NEGRO(" ☻ "),BLANCO(" ☺ "),VACIA(" . ");
	
	private String resultado;
	
	private Ficha(String resultado) {
		this.resultado=resultado;
	}
	
	public String getResultado() {
		return resultado;
	}
	
}
