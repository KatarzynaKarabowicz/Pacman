package Pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 * Klasa reprezentujaca duszka (przeciwnika) na mapie gry
 * 
 */
public class Duszek extends Rectangle {

	private static final long serialVersionUID = 1L;

	private int random = 0;
	private int smart = 1;
	private int stan = random;
	// private enum polozenie {prawo,lewo,gora,dol};
	private int prawo = 0, lewo = 1, gora = 2, dol = 3;
	private int dir = 1;
	public Random random1;
	public int czas = 0;
	public int koncowy_czas = 60 * 4;
	private int szybkosc = 4;

	/**
	 * konstruktor klasy reprezentujacej duszka
	 * 
	 * @param x
	 *            wspolrzedna na osi ox
	 * @param y
	 *            wspolrzedna na osi oy
	 */
	public Duszek(int x, int y) {
		random1 = new Random();
		setBounds(x, y, 64, 64);
		dir = random1.nextInt(4);

	}

	public void polozenie() {

		if (stan == random) {

			if (dir == prawo) {
				if (ruch(x + szybkosc, y)) {
					x += szybkosc;
				} else {
					dir = random1.nextInt(4);
				}
			}

			if (dir == lewo) {
				if (ruch(x - szybkosc, y)) {
					x -= szybkosc;
				} else {
					dir = random1.nextInt(4);
				}
			}

			if (dir == gora) {
				if (ruch(x, y - szybkosc)) {
					y -= szybkosc;
				} else {
					dir = random1.nextInt(4);
				}
			}

			if (dir == dol) {
				if (ruch(x, y + szybkosc)) {
					y += szybkosc;
				} else {
					dir = random1.nextInt(4);
				}
			}
		}
	}

	public boolean ruch(int nastx, int nasty) {
		Rectangle bounds = new Rectangle(nastx, nasty, 64, 64);
		Mapa mapa = Rozgrywka.mapa;

		for (int xx = 0; xx < mapa.rozmiarMapy; xx++)
			for (int yy = 0; yy < mapa.rozmiarMapy; yy++) {
				if (mapa.plytki[xx][yy] != null) {
					if (bounds.intersects(mapa.plytki[xx][yy])) {
						return false;

					}
				}
			}

		return true;

	}

	/**
	 * metoda wczytujaca graficzna reprezentacje duszka
	 * 
	 * @param g
	 *            kontekst graficzny
	 */

	public void wczytajDuszka(Graphics g) {
		// g.setColor(Color.pink);
		// g.fillRect(x, y, width, height);
		Ksztalt duszek = Rozgrywka.ksztalt_duszek;
		g.drawImage(duszek.pobierzKsztalt(0, 0), x, y, null);
	}

}
