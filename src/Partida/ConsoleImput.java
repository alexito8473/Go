package Partida;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ConsoleImput {

	private final Scanner sc;

	public ConsoleImput(Scanner sc) {
		this.sc = sc;
	}

	private void cleanInput() {
		sc.nextLine();
	}

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

	public void stop(int numero) {
		try {
			TimeUnit.MILLISECONDS.sleep(numero);
		} catch (InterruptedException e) {

		}
	}

	public void frasesLentas(String frase, int numero) {
		frasesLentasSinSalto(frase, numero);
		System.out.println();
	}

	public void frasesLentasSinSalto(String frase, int numero) {
		for (int i = 0; i < frase.length(); i++) {
			System.out.print(frase.charAt(i));
			stop(numero);
		}
	}

	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public int readInt() {
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
	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	public char readChar() {
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

	public String readString() {
		String frase;
		frase = sc.nextLine();
		return frase;
	}

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