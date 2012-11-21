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
	 * n�mero total de renglones y columnas del tablero
	 */
	int fila, col;
	/**
	 * almacena qu� valor tiene cada casilla:<br>
	 * La casilla vac�a o 'B' es blanca.
	 */
	public char espacio[][];

	char actual;
	
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
		actual = 'P';

		espacio = new char[fila][col];
		for (int r = 0; r < fila; r++)
			for (int c = 0; c < col; c++)
				espacio[r][c] = 'B'; // fija casillas de color blanco
		System.out.println("Creando tablero");
	}
	
	void repaint(){
		dibujo.repaint();
	}
	/**
	 * Efect�a el movimiento solicitado en el tablero
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
	
	void reset(){
		for (int r = 0; r < fila; r++)
			for (int c = 0; c < col; c++)
				espacio[r][c] = 'B'; // fija casillas de color blanco.
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