package Tablero;

import java.util.Objects;

public class Coordenada {

	private int posicion1;
	private int posicion2;

	public Coordenada(int posicion1, int posicion2) {
		this.posicion1 = posicion1;
		this.posicion2 = posicion2;
	}

	public int getPosicion1() {
		return posicion1;
	}

	public int getPosicion2() {
		return posicion2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(posicion1, posicion2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		return posicion1 == other.posicion1 && posicion2 == other.posicion2;
	}

}
