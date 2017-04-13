package Pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 
 * Reprezentacja bonusu na mapie gry,
 *
 */

public class Bonus extends Rectangle {
	
	 private static final long serialVersionUID=1L;
	 
	 /**
	  * Konstruktor reprezentacji bonusu. 
	  * @param x Wspolrzedna na osi ox
	  * @param y Wspolrzedna na osi oy
	  */

	    public Bonus(int x, int y){
	        setBounds(x+28,y+28,8,8);

	    }
	    /**
	     * Metoda wczytujaca bonus w postaci graficznej na mape
	     * @param g kontekst graficzny
	     */

	    public void wczytajBonus(Graphics g)
	    {
	        g.setColor(Color.blue);
	        g.fillRect(x, y, width, height);
	    }

	}

