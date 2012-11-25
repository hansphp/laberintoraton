package laberintoraton;

public class Pila {

	Lista memoria;

	Pila() {
		memoria = new Lista();
	}

	boolean vacia() {
		return memoria.vacia();
	}

	void push(int f, int c) {
		memoria.agregaInicio(f, c);
	}
	void push(Coordenada coor){
		memoria.agregaInicio(coor.fila, coor.columna);
	}
	
	Nodo pop() {
		return memoria.borrarInicio();
	}

	Nodo tos() {
		return memoria.cabeza();
	}
	void recorrePila(){
		memoria.recorreLista();
	}
	boolean buscarNodo(Coordenada coor){
		return memoria.buscarNodo(coor.fila, coor.columna);
	}
}