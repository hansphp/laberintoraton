package laberintoraton;

public class Principal {

	public static void main(String s[]) {
		Tablero tablero = new Tablero(8, 20);
		new FrmTablero(tablero);
		new BrainRaton(tablero);
	}

}
