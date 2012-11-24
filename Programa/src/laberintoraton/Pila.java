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

	Nodo pop() {
		return memoria.borrarInicio();
	}

	Nodo tos() {
		return memoria.cabeza();
	}
	void recorrePila(){
		memoria.recorreLista();
	}
}