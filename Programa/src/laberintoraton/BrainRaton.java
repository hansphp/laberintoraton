package laberintoraton;

public class BrainRaton {
//atributos
	
	Tablero t;
	
	// metodos

	BrainRaton(Tablero t){
		this.t = t;
		t.brain = this;
		
	}
	void avance(int f, int c){
		t.espacio[t.posRaton[0]][t.posRaton[1]] = 'B';
		t.espacio[f][c] = 'R';
		t.posRaton[0] = f;
		t.posRaton[1] = c;
		t.repaint();
	}
	
	void accion(int v){
		System.out.println("raton moviendose a "+ (t.posRaton[0]+1)+","+(t.posRaton[1]+1));
		// TODO 
		anclaje();
	}
	
	void anclaje(){
		/// PIENSA EL RATÓN DONDE SE VA A MOVER
		/// PARA LUEGO HACERLO... método();
		//avance(t.posRaton[0]+1,t.posRaton[1]+1);
		jugando();
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
		avance(t.posRaton[0]+1,t.posRaton[1]);
	}

	public void avanzaDerecha() {
		avance(t.posRaton[0],t.posRaton[1]+1);
	}

	public void avanzaIzquierda() {
		
		avance(t.posRaton[0],t.posRaton[1]-1);
	}

	public void avanzaArriba() {
		avance(t.posRaton[0]-1,t.posRaton[1]);
	}
	
	
	public void jugando() {

		if (verificaAbajo() == true) {
			avanzaAbajo();
			
			
		} else if (verificaDerecha() == true) {
			avanzaDerecha();
		
		}else if (verificaArriba() == true){
			avanzaArriba();
			
		}else if (verificaIzquierda() == true){
			avanzaIzquierda();
			
		}

	}

}
