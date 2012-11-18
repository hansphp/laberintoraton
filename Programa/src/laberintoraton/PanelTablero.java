package laberintoraton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JPanel;

/**
 * Panel para el dibujo de un Tablero de asociado a un objeto de la clase
 * Tablero
 */
class PanelTablero extends JPanel {

	private static final long serialVersionUID = -2957846057828458109L;

	Tablero t;
	
	int dire;

	public PanelTablero(Tablero t) {
		this.t = t;
		initComponents();
	}

	private void initComponents() {
		this.addMouseListener(new java.awt.event.MouseListener() {

			@Override
			// determina la posicion del mouse al momento de un click
			// identifica la posicion como una jugada determinando el renglo y
			// columna
			// y envia la posicion como una jugada a el tablero que se tiene
			// asociado
			//
			public void mouseClicked(MouseEvent evt) {
				int x = evt.getX();
				int y = evt.getY();
				double dc = (x - 10) / (t.largo * 1.0);
				double dr = (y - 10) / (t.largo * 1.0);
				int c = (int) Math.floor(dc);
				int r = (int) Math.floor(dr);
				if ((r >= 0 && r < t.fila) && (c >= 0 && c < t.col)) {
					System.out.printf("(%d,%d) -->  [%2d,%2d]\n", x, y, r, c);
					t.jugada(r, c);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});

		this.addMouseWheelListener(new  java.awt.event.MouseWheelListener(){

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// TODO Auto-generated method stub
				System.out.println("WHELL:"+e.getWheelRotation());
			}
				
		});
			
		
	}

	@Override
	public void paint(Graphics g) {
		int y = 10;
		for (int f = 0; f < t.fila; f++) {
			int x = 10;
			for (int c = 0; c < t.col; c++) {
				
				g.setColor(Color.LIGHT_GRAY);
				g.drawRect(x, y, t.largo, t.largo);
				
				g.setColor(t.color(f, c));
				g.fillRect(x + 1, y + 1, t.largo -2 , t.largo -2 );
				
				x += t.largo;
			}
			y += t.largo;
		}
		g.setColor(Color.BLACK);
		g.drawString("Ladrillos", 20, (t.fila + 1) * t.largo + 10);
		
		g.fillRect(20, (t.fila + 1) * t.largo + 15, 80, 20);
		Image raton, salida;
		raton = Toolkit.getDefaultToolkit().getImage("raton.png");
		g.drawImage(raton, 10, 10, 32, 32, this);
		salida = Toolkit.getDefaultToolkit().getImage("salida.png");
		g.drawImage(salida, 42 + (13 * 32), 42 + (13 * 32), 32, 32, this);

	}
}
