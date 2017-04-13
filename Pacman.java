package Pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * reprezentacja gracza (pacmana) na mapie gry
 * 
 *
 */

public class Pacman extends Rectangle {
	
	private static final long serialVersionUID=1L;
	
	/**
	 * konstruktor klasy reprezentujacej pacmana. Parametry stanowia o rozmieszczeniu na mapie
	 * @param x wspolrzedna na osi ox
	 * @param y wspolrzedna na osi py
	 */
	public Pacman(int x, int y){
		setBounds(x,y,64,64);
	}
	
	/**
	 * metoda odpowiedzialna za graficzne przedstawienie pacmana
	 * @param g kontekst graficzny
	 */
	
	public void wczytajPacmana(Graphics g){
		
		Ksztalt pacman=Rozgrywka.ksztalt_pacman;
    	g.drawImage(pacman.pobierzKsztalt(0,0),x , y, null);
	}

}
