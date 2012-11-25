package laberintoraton;

public class Principal {

	public static void main(String s[]) {
		Tablero tablero = new Tablero(10,15);
		new FrmTablero(tablero);
		new BrainRaton(tablero);
		Coordenada.t=tablero;
	}

}
