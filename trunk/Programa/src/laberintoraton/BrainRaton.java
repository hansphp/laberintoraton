package laberintoraton;

public class BrainRaton {
//atributos
	
	Tablero t;
	
	// metodos

	BrainRaton(Tablero t){
		this.t = t;
		
	}
	public boolean verificaAbajo() { //prioridad 1
		int f = t.posRaton[0];
		int c = t.posRaton[1];
		
		if (t.casilla(f+1,c) == 'B') 
	  return true;
			
		return false;
	}

	public boolean verificaDerecha() { //prioridad 2
		int f = t.posRaton[0];
		int c = t.posRaton[1];
		
		if (t.casilla(f,c+1) == 'B') 
		return true;
		
		return false;
	}

	public boolean verificaIzquierda() { //prioridad 3
		int f = t.posRaton[0];
		int c = t.posRaton[1];
		
		if (t.casilla(f,c-1) == 'B') 
		return true;
		
		return false;
	}

	public boolean verificaArriba() { // prioridad 4

		int f = t.posRaton[0];
		int c = t.posRaton[1];
		
		if (t.casilla(f-1,c) == 'B') 
		return true;
		
		return false;
	}

	public void avanzaAbajo() {

		 t.posRaton[0]++;
		 t.repaint();

	}

	public void avanzaDerecha() {

		t.posRaton[1]++;
		t.repaint();
	}

	public void avanzaIzquierda() {
		t.posRaton[0]--;
		t.repaint();
	}

	public void avanzaArriba() {
		t.posRaton[1]--;
		t.repaint();

	}

}
