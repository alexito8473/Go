package Partida;

/**
 * 
 * @author aleja
 *
 */
public enum Colors {

	RESET("\u001B[0m"), BLACK("\u001B[30m"), RED("\u001B[31m"), GREEN("\u001B[32m"), YELLOW("\u001B[33m"),
	PURPLE("\u001B[35m"), CYAN("\u001B[36m"), RED_BACKGROUND("\u001B[41m"), GREEN_BACKGROUND("\u001B[42m"),
	YELLOW_BACKGROUND("\u001B[43m"), WHITE_BACKGROUND("\u001B[47m");

	private String valor;

	private Colors(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

}
