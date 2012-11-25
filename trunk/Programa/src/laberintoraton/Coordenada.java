package laberintoraton;

public class Coordenada extends Nodo {

	public static Tablero t;

	Coordenada(int f, int c) {
		super(f, c);
		// TODO Auto-generated constructor stub
	}

	public boolean igual(Coordenada coor) {
		if (coor != null && fila == coor.fila && coor.columna == columna)
			return true;
		else
			return false;
	}

	public boolean igual(Nodo coor) {
		if (coor != null && fila == coor.fila && coor.columna == columna)
			return true;
		else
			return false;
	}

	public char valueProximo(Direcciones dir) {
		if (dir == Direcciones.ABAJO) {
			return t.casilla(fila + 1, columna);
		} else if (dir == Direcciones.DERECHA) {
			return t.casilla(fila, columna + 1);
		} else if (dir == Direcciones.IZQUIERDA) {
			return t.casilla(fila, columna - 1);
		} else if (dir == Direcciones.ARRIBA) {
			return t.casilla(fila - 1, columna);
		} else
			return 'X';
	}

	public Coordenada getProximo(Direcciones dir) {
		if (dir == Direcciones.ABAJO) {
			return new Coordenada(fila + 1, columna);
		} else if (dir == Direcciones.DERECHA) {
			return new Coordenada(fila, columna + 1);
		} else if (dir == Direcciones.IZQUIERDA) {
			return new Coordenada(fila, columna - 1);
		} else if (dir == Direcciones.ARRIBA) {
			return new Coordenada(fila - 1, columna);
		} else
			return null;
	}
}
