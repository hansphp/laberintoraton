package laberintoraton;

public class Principal {

	public static void main(String s[]) {
		Tablero tablero = new Tablero(3, 3);
		new FrmTablero(tablero);
		new BrainRaton(tablero);
		Coordenada.t=tablero;
	}

}
