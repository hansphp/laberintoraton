package laberintoraton;

public class Principal {

	public static void main(String s[]) {
		Tablero tablero = new Tablero(8, 8);
		new FrmTablero(tablero);
		new BrainRaton(tablero);
		Coordenada.t=tablero;
	}

}
