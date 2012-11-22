package laberintoraton;


/**
 * 
 * Tablero logico, modela el tablero como una matriz de caracteres.
 * <p>
 */
public class Tablero {

	PanelTablero dibujo;
	
	BrainRaton brain;

	char rellenos[] = { 'B', 'P', 'R', 'S', 'E' };
	
	int [] posRaton = new int[2];
	int [] posPuerta = {3,3};
	
	boolean ratonEnTablero;
	boolean puertaEnTablero;

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
		ratonEnTablero = false;
		puertaEnTablero = false;
		posRaton[0] = 0;
		posRaton[1] = 0;
		
		espacio = new char[fila][col];
		for (int f = 0; f < fila; f++)
			for (int c = 0; c < col; c++)
				espacio[f][c] = 'B'; // fija casillas de color blanco
		System.out.println("Creando tablero desde el Constructor");
	}
	
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
	void pintar(int f, int c) {
		System.out.println("===================================");
		System.out.printf("dibujando: %c\n", this.actual);
		if(this.actual=='R'){
			if(ratonEnTablero==false && espacio[f][c]=='B'){
				espacio[f][c] = this.actual;
				posRaton[0] = f;
				posRaton[1] = c;
				ratonEnTablero=true;
			}else{
				System.out.println("YA NO DIBUJA RATON");
			}
		}else if(this.actual=='S'){
			if(puertaEnTablero==false && espacio[f][c]=='B'){
				espacio[f][c] = this.actual;
				posPuerta[0] = f;
				posPuerta[1] = c;
				puertaEnTablero=true;
			}else{
				System.out.println("YA NO DIBUJA SALIDA");
			}	
		}else{
			if(posRaton[0] == f &&  c == posRaton[1]){
				espacio[f][c] = this.actual;
				ratonEnTablero = false;
			}else if(posPuerta[0] == f &&  c == posPuerta[1]){
				espacio[f][c] = this.actual;
				puertaEnTablero = false;
			}else
			espacio[f][c] = this.actual;
			System.out.println(this.actual);
		}
		
		/* for(char es[]:espacio){
			for(char e:es){
			System.out.print(" "+e);
			}
			System.out.println("");
		}*/
			
		repaint();
	}
	
	void pintar(int f, int c, char n) {
		System.out.println("===================================");
		System.out.printf("dibujando: %c\n", n);
		espacio[f][c] = n;
		repaint();
	}
	char casilla(int f, int c){
		return 	espacio[f][c];
	}
	
	void reset(){
		for (int f = 0; f < fila; f++)
			for (int c = 0; c < col; c++)
				espacio[f][c] = 'B'; // fija casillas de color blanco.
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