package laberintoraton;

public class Principal {

	public static void main(String s[]) {
		Tablero tablero = new Tablero(8, 20);
		BrainRaton raton = new BrainRaton(tablero);
		
		new FrmTablero(tablero);
	}
	
}
