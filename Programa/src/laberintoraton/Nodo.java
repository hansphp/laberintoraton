package laberintoraton;

public class Nodo {
	int fila, columna;
	Nodo sig;

	Nodo(int f, int c, Nodo s) {
		fila = f;
		columna = c;
		sig = s;
	}

	Nodo(int f, int c) {
		fila = f;
		columna = c;
		sig = null;
	}

	public String toString() {
		String s;
		s = "(f,c): " + fila + "," + columna;
		return s;
	}
}
