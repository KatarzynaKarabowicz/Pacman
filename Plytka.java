package Pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 
 * Klasa reprezentujaca sciane labiryntu na mapie gry
 *  
 */

public class Plytka extends Rectangle{

    private static final long serialVersionUID=1L;

    /**
     * konstruktor klasy reprezentujacej sciane labiryntu. Wspolrzedne stanowia rozmieszczenie na mapie
     * @param x wspolrzedna na osi ox
     * @param y wspolrzedna na osi oy
     */
    public Plytka(int x, int y){
        setBounds(x,y,64,64);

    }
/**
 * metoda wczytujaca graficzna reprezentacje plytki na mapie
 * @param g kontekst graficzny
 */
    public void wczytajPlytke(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(x, y, width, height);
    }

}
