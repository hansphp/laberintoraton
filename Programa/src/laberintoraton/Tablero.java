package laberintoraton;


/**
 * 
 * Tablero logico, modela el tablero como una matriz de caracteres.
 * <p>
 */
public class Tablero {

	PanelTablero dibujo;

	char rellenos[] = { 'B', 'P', 'R', 'S' };
	int [] posRaton = {0 , 0};

	int turno;
	
	/**
	 * longitud de cada cuadro en el tablero
	 */
	int largo;
	/**
	 * número total de renglones y columnas del tablero
	 */
	int fila, col;
	/**
	 * almacena qué valor tiene cada casilla:<br>
	 * La casilla vacía o 'B' es blanca.
	 */
	public char espacio[][];

	char actual;
	
	/**
	 * crea la matriz que representa el tablero, la rellena con las letras que
	 * le corresponden a cada color de casilla y a cada jugador
	 * 
	 * @param filas
	 *            Número total de filas del tablero.
	 * @param columnas
	 *            Número total de columnas del tablero.
	 */
	Tablero(int filas, int columnas) {
		fila = filas;
		col = columnas;
		largo = 32;
		actual = 'P';

		espacio = new char[fila][col];
		for (int r = 0; r < fila; r++)
			for (int c = 0; c < col; c++)
				espacio[r][c] = 'B'; // fija casillas de color blanco
		System.out.println("Creando tablero");
	}

	/**
	 * el jugador en turno solicita que la casilla (r,c) sea tomada por él, si
	 * está disponible y es una jugada valida (depende de las reglas del juego)
	 * se efectúa la toma y se establece automáticamente que el turno es del
	 * jugador siguiente en el orden. Si la jugada es invalida, ya sea porque
	 * las coordenadas son incorrectas o porque la casilla solicitada rompe las
	 * reglas del juego se ignora la solicitud y no cambia el turno del jugador
	 * 
	 * @param f
	 *            renglón de la casilla
	 * @param c
	 *            columna de la casilla
	 * @return cierto indica que se pudo ejecutar la jugada y se cambia el
	 *         turno. Falso indica que no se ejecuto la jugada y que el turno
	 *         sigue perteneciendo al jugador que solicitó la jugada
	 */
	void repaint(){
		dibujo.repaint();
	}
	/**
	 * Efectúa el movimiento solicitado en el tablero
	 * 
	 * @param f
	 *            fila de la casilla
	 * @param c
	 *            columna de la casilla
	 */
	boolean movimiento(int f, int c) {
		System.out.println("===================================");
		System.out.printf("dibujando: %c\n", this.actual);
		espacio[f][c] = this.actual;
		
		
		for(char es[]:espacio){
			for(char e:es){
			System.out.print(" "+e);
			}
			System.out.println("");
		}
			
		repaint();
		return true;
	}
	
	char casilla(int f, int c){
		return 	espacio[f][c];
	}
	/**
	 * Crea un JPanel donde se dibujará el tablero. Se asocia el
	 * PnlTablero con este objeto, de manera que cada movimiento efectuado por
	 * medio de jugada(r,c) se vea reflejado gráficamente en el tablero de juego
	 * 
	 * @return una referencia al panel de dibujo
	 */
	PanelTablero preaparaTablero() {
		dibujo = new PanelTablero(this);
		return dibujo;
	}

}