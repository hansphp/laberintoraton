package laberintoraton;

import javax.swing.JFrame;

class FrmTablero extends JFrame {

	private static final long serialVersionUID = -1741051753840760396L;

	Tablero tablero;

	public FrmTablero(Tablero t) {
		tablero = t;
		setSize((t.col*t.largo)+36+90,(t.fila*t.largo)+58);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PanelTablero dibujo = tablero.preaparaTablero();
	        add(dibujo);
	        setVisible(true);
		
		
	}

}
