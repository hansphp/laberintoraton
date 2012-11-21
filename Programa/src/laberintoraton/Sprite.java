package laberintoraton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Sprite {
	
	static int gX;
	static Tablero t;
	static PanelTablero obj;
	static String actual;
	
	Image pic;
	String nombre;	
	
	Sprite(String n, PanelTablero este){
		actual="pared";
		obj = este;
		t = obj.t;
		gX =  (t.col*t.largo)+20;
		validadorInicial(n);
	}
	Sprite(String n){
		validadorInicial(n);
	}
	
	
	private boolean validadorInicial(String n){
		if("raton"==n || "salida"==n || "pared"==n || "goma"==n || "reset"==n){
			pic = Toolkit.getDefaultToolkit().getImage(n+".png");
			nombre=n;
			return true;
		}else{
			return false;
		}
	}
	
	void dibujar(Graphics g, int x, int y){
		g.drawImage(pic, x, y, t.largo, t.largo, obj);
	}
	
	void dibujar(Graphics g, int y){
		g.drawImage(pic, gX, y, t.largo, t.largo, obj);
		g.setColor(Color.BLACK);
		g.drawString(nombre.toUpperCase(),  gX+40, y+20);
	}

}
