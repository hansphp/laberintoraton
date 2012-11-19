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
	
	
	Image 	raton 	= Toolkit.getDefaultToolkit().getImage("raton.png"),
			salida	= Toolkit.getDefaultToolkit().getImage("salida.png"),
			pared 	= Toolkit.getDefaultToolkit().getImage("pared.png"),
			goma 	= Toolkit.getDefaultToolkit().getImage("goma.png");
	int gX;
	

	public PanelTablero(Tablero t) {
		this.t = t;
		gX = (t.col*t.largo)+20;
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
				double dc = (x - 10) / (t.largo);
				double df = (y - 10) / (t.largo);
				int c = (int) Math.floor(dc);
				int f = (int) Math.floor(df);
				if ((f >= 0 && f < t.fila) && (c >= 0 && c < t.col)) {
					System.out.printf("(%d,%d) -->  [%2d,%2d]\n", x, y, f, c);
					t.jugada(f, c);
				}else{
					/*
					 * Delimita las columnas.
					 */
					if(gX < x && x < (gX+32)){
						if(10 < y && y < (10+32)){
							System.out.println("Click en pared");
						}
						if(48 < y && y < (48+32)){
							System.out.println("Click en raton");
						}
						if(86 < y && y < (86+32)){
							System.out.println("Click en salida");
						}
						if(124 < y && y < (124+32)){
							System.out.println("Click en goma");
						}
					}
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
				//System.out.println("bbb");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				//System.out.println("ccc");
				
			}
		});

		this.addMouseWheelListener(new  java.awt.event.MouseWheelListener(){

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// TODO Auto-generated method stub
				System.out.println("WHELL:"+e.getWheelRotation());
			}
				
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println("fff");
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				//System.out.println("eee");
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
				
				
				if(t.casilla(f,c)=='P'){
					g.drawImage(pared, x + 1, y + 1, 32, 32, this);
				}else{
					g.setColor(Color.WHITE);
					g.fillRect(x + 1, y + 1, t.largo -2 , t.largo -2 );
				}
				
				x += t.largo;
			}
			y += t.largo;
		}
		
		g.setColor(Color.BLACK);
		//g.fillRect(20, (t.fila + 1) * t.largo + 15, 80, 20);
		
		g.drawImage(pared, gX, 10, t.largo, t.largo, this);
		g.drawString("Ladrillo",  (t.col*t.largo)+60, 30);
		
		g.drawImage(raton, gX, 48, t.largo, t.largo, this);
		g.drawString("Ratón",  (t.col*t.largo)+60, 68);
		
		g.drawImage(salida, gX, 86, t.largo, t.largo, this);
		g.drawString("Salida",  (t.col*t.largo)+60, 106);
		
		g.drawImage(goma, gX, 124, t.largo, t.largo, this);
		g.drawString("Goma",  (t.col*t.largo)+60, 144);
	/*
		g.drawImage(raton, 10, 10, 32, 32, this);
		g.drawImage(salida, 42 + (13 * 32), 42 + (13 * 32), 32, 32, this);
*/
	}
}
