package laberintoraton;

/**
 * 
 * Tablero logico, modela el tablero como una matriz de caracteres.
 * <p>
 */
public class Tablero {

	PanelTablero dibujo;

	BrainRaton brain;

	char rellenos[] = { 'B', 'P', 'R', 'S', 'E', 'F' };

	Coordenada posRaton;
	Coordenada posSalida;

	/**
	 * longitud de cada cuadro en el tablero
	 */
	int largo;
	/**
	 * número total de renglones y columnas del tablero
	 */
	int fila, columna;
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
		columna = columnas;
		largo = 32;
		actual = 'P';

		espacio = new char[fila][columna];
		for (int f = 0; f < fila; f++)
			for (int c = 0; c < columna; c++)
				espacio[f][c] = 'B'; // fija casillas de color blanco
		System.out.println("Creando tablero desde el Constructor.");
	}

	void repaint() {
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
	void pintar(int f, int c) {
		System.out.println("===================================");
		System.out.printf("dibujando: %c\n", this.actual);
		Coordenada coor = new Coordenada(f, c);

		if (this.actual == 'R') {
			if (posRaton == null && espacio[f][c] == 'B') {
				espacio[f][c] = this.actual;
				posRaton = coor; // NEW | Paso de referencia.
				brain.inicia(coor);
			}
		} else if (this.actual == 'S') {
			if (posSalida == null && espacio[f][c] == 'B') {
				espacio[f][c] = this.actual;
				posSalida = coor; // NEW | Paso de referencia.
			}
		} else {
			if (coor.igual(posRaton)) {
				espacio[f][c] = this.actual;
				posRaton = null;
			} else if (coor.igual(posSalida)) {
				espacio[f][c] = this.actual;
				posSalida = null;
			} else {
				espacio[f][c] = this.actual;
			}
		}

		/*
		  for(char es[]:espacio){ for(char e:es){ System.out.print(" "+e); }
		  System.out.println(""); }
		 
*/
		repaint();
	}

	void pintar(int f, int c, char n) {
		System.out.println("===================================");
		System.out.printf("dibujando: %c\n", n);
		espacio[f][c] = n;
		repaint();
	}

	char casilla(int f, int c) {
		if (f >= 0 && (f < fila && c < columna) && c >= 0)
			return espacio[f][c];
		return 'X';
	}

	void reset() {
		for (int f = 0; f < fila; f++)
			for (int c = 0; c < columna; c++)
				espacio[f][c] = 'B'; // fija casillas de color blanco.
		actual = 'P';
		Sprite.actual = "pared";
		posRaton = null;
		posSalida = null;
		brain.reset();
	}

	/**
	 * Crea un JPanel donde se dibujará el tablero. Se asocia el PnlTablero con
	 * este objeto, de manera que cada movimiento efectuado por medio de
	 * jugada(r,c) se vea reflejado gráficamente en el tablero de juego
	 * 
	 * @return una referencia al panel de dibujo
	 */
	PanelTablero preaparaTablero() {
		dibujo = new PanelTablero(this);
		return dibujo;
	}

}