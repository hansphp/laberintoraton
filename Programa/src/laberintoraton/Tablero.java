package laberintoraton;


/**
 * 
 * Tablero l�gico, modela el tablero como una matriz de caracteres.
 * <p>
 */
public class Tablero {

	PanelTablero dibujo;

	static char rellenos[] = { 'K', 'P', 'R', 'S' };

	int turno;
	
	/**
	 * longitud de cada cuadro en el tablero
	 */
	int largo;
	/**
	 * n�mero total de renglones y columnas del tablero
	 */
	int fila, col;
	/**
	 * almacena qu� valor tiene cada casilla:<br>
	 * La casilla vac�a o 'B' es blanca.
	 */
	public char espacio[][];

	/**
	 * crea la matriz que representa el tablero, la rellena con las letras que
	 * le corresponden a cada color de casilla y a cada jugador
	 * 
	 * @param filas
	 *            N�mero total de filas del tablero.
	 * @param columnas
	 *            N�mero total de columnas del tablero.
	 */
	Tablero(int filas, int columnas) {
		fila = filas;
		col = columnas;
		largo = 32;

		espacio = new char[fila][col];
		for (int r = 0; r < fila; r++)
			for (int c = 0; c < col; c++)
				espacio[r][c] = 'B'; // fija casillas de color blanco
		System.out.println("Creando tablero");
	}

	/**
	 * el jugador en turno solicita que la casilla (r,c) sea tomada por �l, si
	 * est� disponible y es una jugada valida (depende de las reglas del juego)
	 * se efect�a la toma y se establece autom�ticamente que el turno es del
	 * jugador siguiente en el orden. Si la jugada es invalida, ya sea porque
	 * las coordenadas son incorrectas o porque la casilla solicitada rompe las
	 * reglas del juego se ignora la solicitud y no cambia el turno del jugador
	 * 
	 * @param f
	 *            rengl�n de la casilla
	 * @param c
	 *            columna de la casilla
	 * @return cierto indica que se pudo ejecutar la jugada y se cambia el
	 *         turno. Falso indica que no se ejecuto la jugada y que el turno
	 *         sigue perteneciendo al jugador que solicit� la jugada
	 */
	boolean jugada(int f, int c) {
		System.out.println("===================================");

		System.out.printf("dibujando: %d\n",5454);

		movimiento(f, c);

		repaint();

		return true;
	}
	void repaint(){
		dibujo.repaint();
	}
	/**
	 * Efect�a el movimiento solicitado en el tablero
	 * 
	 * @param r
	 *            rengl�n de la casilla
	 * @param c
	 *            columna de la casilla
	 */
	void movimiento(int f, int c) {
		espacio[f][c] = rellenos[1];
	}
	char casilla(int f, int c){
		return 	espacio[f][c];
	}
	/**
	 * Crea un JPanel donde se dibujar� el tablero. Se asocia el
	 * PnlTablero con este objeto, de manera que cada movimiento efectuado por
	 * medio de jugada(r,c) se vea reflejado gr�ficamente en el tablero de juego
	 * 
	 * @return una referencia al panel de dibujo
	 */
	PanelTablero preaparaTablero() {
		dibujo = new PanelTablero(this);
		return dibujo;
	}

}