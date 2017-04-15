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
	        setBounds(x,y,64,64);

	    }
	    /**
	     * Metoda wczytujaca bonus w postaci graficznej na mape
	     * @param g kontekst graficzny
	     */

	  
 public void wczytajBonus(Graphics g){
			
			Ksztalt bonus=Rozgrywka.ksztalt_bonus;
	    	g.drawImage(bonus.pobierzKsztalt(0,0),x , y, null);
		}

	}

