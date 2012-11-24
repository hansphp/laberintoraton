package laberintoraton;

public class BrainRaton {
	// atributos

	Tablero t;
	Pila ruta;

	// metodos

	BrainRaton(Tablero t) {
		this.t = t;
		t.brain = this;
		ruta = new Pila();
	}

	void avance(int f, int c) {
		t.espacio[t.posRaton[0]][t.posRaton[1]] = 'B';
		System.out.println("raton moviendose de " + (t.posRaton[0]) + "," + (t.posRaton[1]) + " a :" + f + "," + c);
		t.espacio[f][c] = 'R';
		ruta.push(f, c);
		t.posRaton[0] = f;
		t.posRaton[1] = c;
		ruta.recorrePila();
		t.repaint();
	}

	void accion(int v) {
		// TODO
		jugando();
	}
	
	void inicia(int f, int c){
		ruta.push(f, c);
	}

	public boolean verificaAbajo() { // prioridad 1
		int f = t.posRaton[0];
		int c = t.posRaton[1];

		if (t.casilla(f + 1, c) == 'B')
			return true;

		return false;
	}

	public boolean verificaDerecha() { // prioridad 2
		int f = t.posRaton[0];
		int c = t.posRaton[1];

		if (t.casilla(f, c + 1) == 'B')
			return true;

		return false;
	}

	public boolean verificaIzquierda() { // prioridad 3
		int f = t.posRaton[0];
		int c = t.posRaton[1];

		if (t.casilla(f, c - 1) == 'B')
			return true;

		return false;
	}

	public boolean verificaArriba() { // prioridad 4

		int f = t.posRaton[0];
		int c = t.posRaton[1];

		if (t.casilla(f - 1, c) == 'B')
			return true;

		return false;
	}

	enum Direcciones{
		   ARRIBA, ABAJO, IZQUIERDA, DERECHA;
		}
	
	public void avanza(Direcciones dir) { //// Direcciones:
		if(dir==Direcciones.ABAJO){
			avance(t.posRaton[0] + 1, t.posRaton[1]);
		}else if(dir==Direcciones.DERECHA){
			avance(t.posRaton[0], t.posRaton[1] + 1);
		}else if(dir==Direcciones.IZQUIERDA){
			avance(t.posRaton[0], t.posRaton[1] - 1);
		}else if(dir==Direcciones.ARRIBA){
			avance(t.posRaton[0] - 1, t.posRaton[1]);
		}
	}


	public void jugando() {
		if (verificaAbajo() == true) {
			avanza(Direcciones.ABAJO);
		} else if (verificaDerecha() == true) {
			avanza(Direcciones.DERECHA);
		} else if (verificaArriba() == true) {
			avanza(Direcciones.ARRIBA);
		} else if (verificaIzquierda() == true) {
			avanza(Direcciones.IZQUIERDA);
		}

	}

}
