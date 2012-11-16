package laberintoraton;

public class Principal {

	public static void main(String s[]) {
		Tablero tablero = new Tablero(15, 15, 32);
		System.out.println("Creando tablero");
		new FrmTablero(tablero);
	}
}
