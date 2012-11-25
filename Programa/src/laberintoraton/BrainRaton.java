package laberintoraton;

public class BrainRaton {
	// atributos

	Tablero t;
	Pila ruta;

	int fila;
	int columna;

	// metodos

	BrainRaton(Tablero t) {
		this.t = t;
		t.brain = this;
		ruta = new Pila();
	}

	void avance(int f, int c) {
		t.espacio[t.posRaton.fila][t.posRaton.columna] = 'B';

		System.out.println("raton moviendose de " + (t.posRaton.fila) + ","
				+ (t.posRaton.columna) + " a :" + f + "," + c);

		t.espacio[f][c] = 'R';
		ruta.push(f, c);
		t.posRaton = new Coordenada(f, c);

		ruta.recorrePila();
		t.repaint();
	}

	void accion(int v) {
		// TODO
		fila = t.posRaton.fila;
		columna = t.posRaton.columna;
		jugando();
	}

	void inicia(Coordenada coor) {
		ruta.push(coor.fila, coor.columna);
	}

	public boolean verifica(Direcciones dir) {
		System.out.println(ruta.tos());
		if (t.posRaton.getProximo(dir) == 'B') {
			return true;
		} else
			return false;
	}

	public void avanza(Direcciones dir) { // // Direcciones:
		if (dir == Direcciones.ABAJO) {
			avance(fila + 1, columna);
		} else if (dir == Direcciones.DERECHA) {
			avance(t.posRaton.fila, t.posRaton.columna + 1);
		} else if (dir == Direcciones.IZQUIERDA) {
			avance(t.posRaton.fila, t.posRaton.columna - 1);
		} else if (dir == Direcciones.ARRIBA) {
			avance(t.posRaton.fila - 1, t.posRaton.columna);
		}
	}

	public void jugando() {
		if (verifica(Direcciones.ABAJO)) {
			avanza(Direcciones.ABAJO);
		} else if (verifica(Direcciones.DERECHA)) {
			avanza(Direcciones.DERECHA);
		} else if (verifica(Direcciones.ARRIBA)) {
			avanza(Direcciones.ARRIBA);
		} else if (verifica(Direcciones.IZQUIERDA)) {
			avanza(Direcciones.IZQUIERDA);
		}

	}

}
