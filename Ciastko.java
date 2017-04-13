package Pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *Klasa reprezentacja ciastko na mapie
 * 
 *
 */
public class Ciastko extends Rectangle {
	
	 private static final long serialVersionUID=1L;
	 
	 
/**
 * konstruktor reprezentacji ciastka na mapie gry. Parametry stanowia wspolrzedne rozmieszczenia
 * @param x wspolrzedna na osi ox
 * @param y wspolrzedna na osi oy
 */
	    public Ciastko(int x, int y){
	        setBounds(x+28,y+28,8,8);

	    }
	    
	    /** metoda odpowiedzialna za wczytanie ciastka na mapie. Parametr stanowi kontekst graficzny
	     * 
	     * @param g kontekst graficzny
	     */

	    public void wczytajCiastko(Graphics g)
	    {
	        g.setColor(Color.yellow);
	        g.fillRect(x, y, width, height);
	    }

	}


