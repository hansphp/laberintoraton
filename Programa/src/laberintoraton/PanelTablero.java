package laberintoraton;

import java.awt.Color;
import java.awt.Graphics;
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
	
	Sprite goma, raton, salida, pared, reset;
	

	public PanelTablero(Tablero t) {
		this.t = t;
		initComponents();
		pared = new Sprite("pared",this); // El primer elemento pasa el this.
		salida = new Sprite("salida");
		goma = new Sprite("goma");
		raton = new Sprite("raton");
		reset = new Sprite("reset");
		
		
		
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
			public void mouseClicked(MouseEvent e) {
				int coor[] = coordenadas(e);
				int x = e.getX();
				int y = e.getY();
				
				if ((coor[0] >= 0 && coor[0] < t.fila) && (coor[1] >= 0 && coor[1] < t.col)) {
					System.out.printf("[%2d,%2d]\n", x, y, coor[0], coor[1]);
					t.pintar(coor[0], coor[1]);
				}else{
					/*
					 * Delimita las columnas para el panel de seleción.
					 */
					if(Sprite.gX < x && x < (Sprite.gX+100)){
						if(10 < y && y < (10+32)){
							Sprite.actual="pared";
							t.actual = 'P'; 
						}
						if(48 < y && y < (48+32)){
							Sprite.actual="raton";
							t.actual = 'R'; 
						}
						if(86 < y && y < (86+32)){
							Sprite.actual="salida";
							t.actual = 'S'; 
						}
						if(124 < y && y < (124+32)){
							Sprite.actual="goma";
							t.actual = 'B'; 
						}
						if(224 < y && y < (224+32)){
							t.reset();
						}
						t.repaint();
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
				t.brain.accion(e.getWheelRotation());
			}
				
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {
				int coor[] = coordenadas(e);
				if ((coor[0] >= 0 && coor[0] < t.fila) && (coor[1] >= 0 && coor[1] < t.col)) {
					System.out.printf("coor[%2d,%2d]\n", coor[0], coor[1]);
					t.pintar(coor[0], coor[1]);
				}
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				//System.out.println("eee");
			}
			
		});

	}
	
	public int[] coordenadas(MouseEvent e){
		int coor[] = new int[2];
		double dc = (e.getX() - 10) / (t.largo);
		double df = (e.getY() - 10) / (t.largo);
		coor[1] = (int) Math.floor(dc);
		coor[0] = (int) Math.floor(df);
		return coor;
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
					pared.dibujar(g,x + 1,y + 1);
				}else if(t.casilla(f,c)=='R'){
					raton.dibujar(g, x + 1,y + 1);
				}else if(t.casilla(f,c)=='S'){
					salida.dibujar(g, x + 1,y + 1);
				}else{
					g.setColor(Color.WHITE);
					g.fillRect(x + 1, y + 1, t.largo -1 , t.largo -1 );
				}
				
				x += t.largo;
			}
			y += t.largo;
		}
		
		pared.dibujar(g, 10);
		raton.dibujar(g, 48);
		salida.dibujar(g, 86);
		goma.dibujar(g, 124);
		
		reset.dibujar(g, 224);
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(Sprite.gX, 170, 84, 20);
		g.setColor(Color.BLACK);
		g.drawString(Sprite.actual.toUpperCase(),  Sprite.gX+20, 185);
	}
}
