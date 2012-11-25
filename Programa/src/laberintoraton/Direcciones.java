package laberintoraton;

enum Direcciones {
	ABAJO(1), DERECHA(2), ARRIBA(3), IZQUIERDA(4);
	int rumbo;

	Direcciones(int v) {
		rumbo = v;
	}
}