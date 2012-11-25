package laberintoraton;

public class BrainRaton {
	// atributos

	Tablero t;
	Pila ruta;
	Lista listaNegra;
	Coordenada inicio;

	int fila;
	int columna;

	boolean fin;

	// metodos

	BrainRaton(Tablero t) {
		this.t = t;
		t.brain = this;
		ruta = new Pila();
		listaNegra = new Lista();
	}

	void reset() {
		ruta = new Pila();
		listaNegra = new Lista();
		fin = false;
	}

	void avance(Coordenada p) {
		t.espacio[t.posRaton.fila][t.posRaton.columna] = 'B';

		System.out.println("raton moviendose de " + (t.posRaton.fila) + ","
				+ (t.posRaton.columna) + " a :" + p.fila + "," + p.columna);

		t.espacio[p.fila][p.columna] = 'R';
		t.posRaton = p; // NEW : No es necesario recrear el objeto.
		ruta.push(p);
		//ruta.recorrePila();
		t.repaint();
	}

	void reversa() {

		Nodo malo;
		t.espacio[t.posRaton.fila][t.posRaton.columna] = 'B';

		System.out.println("raton moviendose de " + (t.posRaton.fila) + ","
				+ (t.posRaton.columna) + " a :" + ruta.tos().sig.fila + ","
				+ ruta.tos().sig.columna);

		t.espacio[ruta.tos().sig.fila][ruta.tos().sig.columna] = 'R';
		t.posRaton = new Coordenada(ruta.tos().sig.fila, ruta.tos().sig.columna);

		malo = ruta.pop();
		listaNegra.agregaInicio(malo.fila, malo.columna);
		listaNegra.recorreLista();
		t.repaint();

	}

	void accion(int v) {
		// TODO
		fila = t.posRaton.fila;
		columna = t.posRaton.columna;
		jugando();
	}

	void inicia(Coordenada coor) {
		fin = false;
		reset();
		ruta.push(coor.fila, coor.columna);
		inicio = new Coordenada(coor.fila, coor.columna);

	}

	public boolean verifica(Direcciones dir) {
		if (t.posRaton.valueProximo(dir) == 'S') {
			fin = true;
			return true;
		} else if (t.posRaton.valueProximo(dir) == 'B'
				&& !t.posRaton.getProximo(dir).igual(ruta.tos().sig)) {
			if (!ruta.buscarNodo(t.posRaton.getProximo(dir))) {
				if (!listaNegra.buscarNodo(t.posRaton.getProximo(dir).fila,
						t.posRaton.getProximo(dir).columna)) {
					return true;
				}
				return false;
			} else
				return false;
		} else
			return false;
	}

	public void avanza(Direcciones dir) { // // Direcciones:
		if (dir == Direcciones.ABAJO) {
			avance(t.posRaton.getProximo(dir));
		} else if (dir == Direcciones.DERECHA) {
			avance(t.posRaton.getProximo(dir));
		} else if (dir == Direcciones.IZQUIERDA) {
			avance(t.posRaton.getProximo(dir));
		} else if (dir == Direcciones.ARRIBA) {
			avance(t.posRaton.getProximo(dir));
		}
	}

	public void jugando() {
		System.out.println("JUGADA:");
		if (!fin) {
			if (verifica(Direcciones.ABAJO)) {
				avanza(Direcciones.ABAJO);
			} else if (verifica(Direcciones.DERECHA)) {
				avanza(Direcciones.DERECHA);
			} else if (verifica(Direcciones.ARRIBA)) {
				avanza(Direcciones.ARRIBA);
			} else if (verifica(Direcciones.IZQUIERDA)) {
				avanza(Direcciones.IZQUIERDA);
			} else {
				System.out.println("DES HACER JUGADA.:" + ruta.tos());
				if (ruta.tos().sig != null)
					reversa();
				else {
					t.espacio[ruta.tos().fila][ruta.tos().columna] = 'F';
					t.repaint();
					System.out.println("NO HAY MAS CAMINO");

					for (char es[] : t.espacio) {
						for (char e : es) {
							System.out.print(" " + e);
						}
						System.out.println("");
					}
				}

			}

		}else{
			t.espacio[ruta.tos().fila][ruta.tos().columna] = 'E';
			t.repaint();
			System.out.println("SALIDA ENCONTRADA");
			
			for (char es[] : t.espacio) {
				for (char e : es) {
					System.out.print(" " + e);
				}
				System.out.println("");
			}
		}
	}

}
