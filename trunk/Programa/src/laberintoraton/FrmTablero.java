package laberintoraton;

import javax.swing.JFrame;

class FrmTablero extends JFrame {
	/**
     *
     */
	private static final long serialVersionUID = -1741051753840760396L;

	Tablero tablero;

	public FrmTablero(Tablero t) {
		tablero = t;
		setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PanelTablero dibujo = tablero.preaparaTablero();
		dibujo.setSize(this.getSize());
		add(dibujo);
		setVisible(true);
	}

}