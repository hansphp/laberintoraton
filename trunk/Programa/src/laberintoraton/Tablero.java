package laberintoraton;

import java.awt.Color;

/**
 * 
 * Tablero lógico, modela el tablero como una matriz de caracteres.
 * <p>
 * El método jugada permite solicitar una jugada para el jugador que tiene el
 * turno, este mismo método es el que invoca el PnlTablero cuando recibe un
 * click del ratón sobre el área destinada al tablero.
 */
public class Tablero {

	PanelTablero dibujo;

	static char colores[] = { 'K' };

	int turno;

	/**
	 * longitud del cada cuadro en el tablero
	 */
	int largo;
	/**
	 * número total de renglones y columnas del tablero
	 */
	int ren, col;
	/**
	 * almacena qué color tiene cada casilla:<br>
	 * La casilla vacía es blanca
	 */
	char espacio[][];

	/**
	 * el jugador en turno solicita que la casilla (r,c) sea tomada por él, si
	 * está disponible y es una jugada valida (depende de las reglas del juego)
	 * se efectúa la toma y se establece automáticamente que el turno es del
	 * jugador siguiente en el orden. Si la jugada es invalida, ya sea porque
	 * las coordenadas son incorrectas o porque la casilla solicitada rompe las
	 * reglas del juego se ignora la solicitud y no cambia el turno del jugador
	 * 
	 * @param r
	 *            renglón de la casilla
	 * @param c
	 *            columna de la casilla
	 * @return cierto indica que se pudo ejecutar la jugada y se cambia el
	 *         turno. Falso indica que no se ejecuto la jugada y que el turno
	 *         sigue perteneciendo al jugador que solicitó la jugada
	 */
	boolean jugada(int r, int c) {
		System.out.println("===================================");

		System.out.printf("dibujando: %d\n", 0);

		movimiento(r, c);

		dibujo.repaint();

		return true;
	}

	/**
	 * Valida la jugada, determinando si lo que desea hacer el jugador en turno
	 * es valido
	 * 
	 * @param r
	 *            renglón de la casilla a tomar
	 * @param c
	 *            columna de la casilla a tomar
	 * @return true jugada valida, false jugada no valida
	 */

	/**
	 * Efectúa el movimiento solicitado en el tablero
	 * 
	 * @param r
	 *            renglón de la casilla
	 * @param c
	 *            columna de la casilla
	 */
	void movimiento(int r, int c) {
		espacio[r][c] = colores[0];
	}

	/**
	 * crea la matriz que representa el tablero, la rellena con las letras que
	 * le corresponden a cada color de casilla y a cada jugador
	 * 
	 * @param renglones
	 *            Número total de renglones del tablero
	 * @param columnas
	 *            Número total de columnas del tablero
	 * @param tamaño
	 *            Longitud en pixels de cada casilla del tablero
	 * @param jugadore
	 *            Número de jugadores que participarán en el juego
	 */
	Tablero(int renglones, int columnas, int tamaño) {
		ren = renglones;
		col = columnas;
		largo = tamaño;

		espacio = new char[ren][col];
		for (int r = 0; r < ren; r++)
			for (int c = 0; c < col; c++)
				espacio[r][c] = 'B'; // fija casillas de color blanco

	}

	/**
	 * Regresa el color de una casilla del tablero
	 * 
	 * @param r
	 *            renglón dentro del tablero
	 * @param c
	 *            columna dentro del tablero
	 * @return color correspondiente a la posición (r,c)
	 */
	Color color(int r, int c) {
		return color(espacio[r][c]);
	}

	/**
	 * Entrega el código de Color correspondiente a una letra
	 * 
	 * @param c
	 *            letra del color deseado:<br>
	 *            'R' = Rojo, 'A' = Azul, 'N' = Negro,<br>
	 *            'V' = Verde, 'B' Blanco
	 * @return código del color
	 * @see java.awt.Color
	 */
	Color color(char c) {
		switch (c) {
		case 'K':
			return Color.BLACK;

		}
		return Color.WHITE; // por default el color es blanco
	}

	/**
	 * Color del jugador que tiene el turno
	 * 
	 * @return color
	 */
	Color colorTurno() {
		return color(colores[0]);
	}

	/**
	 * Crea un JPanel donde se dibujará el tablero de juego. Se asocia el
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