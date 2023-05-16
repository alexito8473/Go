package Partida;

/**
 * Clase que se destina para el coloreado en la consola.
 * 
 * @author Alejandro Aguilar Alba
 * @since 1.0
 * @version 1.0
 *
 */
public enum Colors {

	/**
	 * Reseteo de los colores.
	 */
	RESET("\u001B[0m"),

	/**
	 * Pinta las letras a negro.
	 */
	BLACK("\u001B[30m"),

	/**
	 * Pinta las letras a rojo.
	 */
	RED("\u001B[31m"),

	/**
	 * Pinta las letras a verde.
	 */
	GREEN("\u001B[32m"),

	/**
	 * Pinta las letras a amarillo.
	 */
	YELLOW("\u001B[33m"),

	/**
	 * Pinta las letras a morado.
	 */
	PURPLE("\u001B[35m"),

	/**
	 * Pinta las letras a cian.
	 */
	CYAN("\u001B[36m"),

	/**
	 * Pinta el fondo de rojo.
	 */
	RED_BACKGROUND("\u001B[41m"),

	/**
	 * Pinta el fondo de verde.
	 */
	GREEN_BACKGROUND("\u001B[42m"),

	/**
	 * Pinta el fondo de amarillo.
	 */
	YELLOW_BACKGROUND("\u001B[43m"),

	/**
	 * Pinta el fondo de blanco.
	 */
	WHITE_BACKGROUND("\u001B[47m");

	/**
	 * Atributo que conserva el color.
	 */
	private String valor;

	/**
	 * Constructor de la clase Colors.
	 * 
	 * @param valor El color que sera definido.
	 */
	private Colors(String valor) {
		this.valor = valor;
	}

	/**
	 * Metodo que devuelve el color.
	 * 
	 * @return Devuelve un String.
	 */
	public String getValor() {
		return valor;
	}

}
