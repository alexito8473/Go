package Ficha;

/**
 * Clase enumerada que contiene las diferentes fichas que existen.
 * 
 * @author Alejandro Aguilar Alba
 * @since 1.0
 * @version 1.0
 *
 */
public enum Ficha {
	/**
	 * Ficha negra.
	 */
	NEGRO("\u001B[30m ☻ \u001B[0m") {
		@Override
		public Ficha fichaContraria() {
			return BLANCO;
		}
	},
	/**
	 * Ficha blanca.
	 */
	BLANCO("\u001B[37m ☻ \u001B[0m") {
		@Override
		public Ficha fichaContraria() {
			return NEGRO;
		}
	};

	/**
	 * Atributo que contiene los datos pertinentes de las fichas.
	 */
	private String resultado;

	/**
	 * Constructor de la clase
	 * 
	 * @param resultado Los datos de la ficha.
	 */
	private Ficha(String resultado) {
		this.resultado = resultado;
	}

	/**
	 * Devuelve la ficha contraria de la ficha.
	 * 
	 * @return La ficha contraria.
	 */
	public abstract Ficha fichaContraria();

	/**
	 * Metodo que devuelve el resutado.
	 * 
	 * @return El contenido.
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * Metodo que devuelve el resutado.
	 * 
	 * @return El contenido.
	 */
	public String devolverFicha() {
		return resultado;
	}

}
