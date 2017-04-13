package Pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


/**
 * Klasa reprezentujaca duszka (przeciwnika) na mapie gry
 * 
 */
public class Duszek extends Rectangle{

    private static final long serialVersionUID=1L;

    /**
     * konstruktor klasy reprezentujacej duszka
     * @param x wspolrzedna na osi ox
     * @param y wspolrzedna na osi oy
     */
    public Duszek(int x, int y){
        setBounds(x,y,64,64);

    }
    
    /**
     * metoda wczytujaca graficzna reprezentacje duszka
     * @param g kontekst graficzny
     */

    public void wczytajDuszka(Graphics g)
    {
       // g.setColor(Color.pink);
        //g.fillRect(x, y, width, height);
    	Ksztalt duszek=Rozgrywka.ksztalt_duszek;
    	g.drawImage(duszek.pobierzKsztalt(0,0),x , y, null);
    }
    
    

}
