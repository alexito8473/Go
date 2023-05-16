package Partida;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Clase que se encarga de las entrada y salida de las peticiones de teclado,
 * ademas de funciones variadas.
 * 
 * @author Alejandro Aguilar Alba
 * @since 1.0
 * @version 1.0
 */

public class ConsoleImput {

	/**
	 * Atributo que almacena el Scanner que sera utilizado en toda la Clase.
	 */
	private final Scanner sc;

	/**
	 * Constructor de la clase ConsoleImput
	 * 
	 * @param sc Scanner que recibe por parametro.
	 */
	public ConsoleImput(Scanner sc) {
		this.sc = sc;
	}

	/**
	 * Metodo que se ocupa de limpiar el buffer de las entrada de teclado.
	 */
	private void cleanInput() {
		sc.nextLine();
	}

	/**
	 * Metodo que sirve para devolver nombre que ha sido escrita por teclado.
	 * 
	 * @return Devuelve un String con una longitud minima de 1 caracter.
	 */
	public String escribirNombre() {
		String palabra;
		do {
			palabra = sc.nextLine();
			if (palabra.length() == 0) {
				System.out.println("Escribe un buen nombre");
			}
		} while (!(palabra.length() > 0));
		return palabra;
	}

	/**
	 * Metodo que sive parar la console por un tiempo limitado.
	 * 
	 * @param numero Sirve para marcar el tiempo que sera se parara la consola.
	 */
	public void stop(int numero) {
		try {
			TimeUnit.MILLISECONDS.sleep(numero);
		} catch (InterruptedException e) {

		}
	}

	/**
	 * Metodo que muestra la frase que ha sido insertada por parametro con una
	 * velocidad ajustable y con un salto de linea al final.
	 * 
	 * @param frase  String que se pasa para que despues sea leido.
	 * @param numero Velocidad que sera leido , mientras el numero sea mas alto mas
	 *               lento sera la velocidad.
	 * @see #frasesLentasSinSalto( String, int)
	 */
	public void frasesLentas(String frase, int numero) {
		frasesLentasSinSalto(frase, numero);
		System.out.println();
	}

	/**
	 * Metodo que muestra la frase que ha sido insertada por parametro con una
	 * velocidad ajustable.
	 * 
	 * @param frase  String que se pasa para que despues sea leido.
	 * @param numero Velocidad que sera leido , mientras el numero sea mas alto mas
	 *               lento sera la velocidad.
	 * @see #stop(int)
	 */
	public void frasesLentasSinSalto(String frase, int numero) {
		for (int i = 0; i < frase.length(); i++) {
			System.out.print(frase.charAt(i));
			stop(numero);
		}
	}

	/**
	 * Metodo sirve para recibir por teclado solamente numeros.
	 * 
	 * @return devuelve el numero que sera pedido por teclado.
	 */
	private int readInt() {
		int resultado = 0;
		boolean salida = false;
		do {
			try {
				resultado = sc.nextInt();
				salida = true;
			} catch (Exception e) {
				System.err.println("Introduce el valor bien(int)");
			} finally {
				cleanInput();
			}
		} while (!salida);
		return resultado;
	}

	/**
	 * Metodo solo devuelve un numero que este entre los dos numeros que se han
	 * petido por parametro.
	 * 
	 * @param a Limitador
	 * @param b Limitador
	 * @return Devuelve un int que su valor esta entre los valores de los
	 *         parametros.
	 * @see #readInt()
	 */
	public int readIntInRange(int a, int b) {
		int c = 0;
		boolean salir = false;
		do {
			c = readInt();
			if (c >= a && c <= b) {
				salir = true;
			} else if (c >= b && c <= a) {
				salir = true;
			} else {
				System.out.println("Su dato no esta en el rango. Vuelve a escribirlo");
			}
		} while (!salir);
		return c;

	}

	/**
	 * Metodo que devuelve un char, que ha sido obtenido por teclado.
	 * 
	 * @return #Devuelve un char.
	 */
	private char readChar() {
		boolean salir = false;
		String cadena;
		char resultado = 0;
		do {
			try {
				cadena = sc.nextLine();

				if (cadena.length() > 1) {
					System.out.println("Solo se puede introducir un caracter");
					salir = false;
				} else {
					resultado = cadena.charAt(0);
					salir = true;
				}
			} catch (StringIndexOutOfBoundsException e) {
				System.err.println("Valor invalido");
				salir = false;
			}
		} while (!salir);
		return resultado;
	}

	/**
	 * Metodo solo devuelve un char que coincida con la expresion regular metida por
	 * parametro.
	 * 
	 * @param validCharacters Cadena de texto que sirve como expresion regular.
	 * @return Devuelve un char que coincida por la expresion del String.
	 * @see #readChar()
	 */
	public char readChar(String validCharacters) {
		if (validCharacters.isEmpty()) {
			throw new ArithmeticException("Cadena vacia");
		}
		char resultado;
		String frase = null, patter = String.format("[%s]", validCharacters);
		do {
			resultado = readChar();
			frase = String.valueOf(resultado);
		} while (!frase.matches(patter));
		return resultado;
	}

	/**
	 * Metodo que pide por teclado texto.
	 * 
	 * @return Devuelve un String
	 */
	private String readString() {
		return sc.nextLine();
	}

	/**
	 * Metodo que recibe por teclado recibe un String y si coincide con alguno de
	 * los parametro devolver true o false dependiendo de el String del paramtro que
	 * sea.
	 * 
	 * @param affirmativeValue String que sirve de comparador.
	 * @param negativeValue    String que sirve de comparador.
	 * @return Devuelve un boolean dependiendo con cual de las compracion es valida.
	 */
	public boolean readBooleanUsingString(String affirmativeValue, String negativeValue) {
		boolean error = true;
		String dato;
		do {
			dato = readString();
			if (dato.equalsIgnoreCase(affirmativeValue)) {
				error = false;
			} else if (dato.equalsIgnoreCase(negativeValue)) {
				return false;
			}
		} while (error);
		return true;
	}
}
