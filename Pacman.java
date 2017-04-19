package Pacman;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JFrame;

/**
 * reprezentacja gracza (pacmana) na mapie gry
 * 
 *
 */

public class Pacman extends Rectangle {

	private static final long serialVersionUID = 1L;
	public boolean prawo, lewo, gora, dol;
	private int szybkosc = 4;

	public static JFrame okno;
	//public int punkty = 0;
	//public int zycie=150;

	public static boolean czy_wygrana;

	/**
	 * konstruktor klasy reprezentujacej pacmana. Parametry stanowia o
	 * rozmieszczeniu na mapie
	 * 
	 * @param x
	 *            wspolrzedna na osi ox
	 * @param y
	 *            wspolrzedna na osi py
	 */
	public Pacman(int x, int y) {
		setBounds(x, y, 50, 50);
		//public int zycie=3;
	}

	/**
	 * metoda odpowiedzialna za graficzne przedstawienie pacmana
	 * 
	 * @param g
	 *            kontekst graficzny
	 */

	/**
	 * metoda sterujaca pozycja pacmana i kolizjami
	 */

	public void polozenie() {
		if (prawo && ruch(x + szybkosc, y))
			x += szybkosc;
		if (lewo && ruch(x - szybkosc, y))
			x -= szybkosc;
		if (gora && ruch(x, y - szybkosc))
			y -= szybkosc;
		if (dol && ruch(x, y + szybkosc))
			y += szybkosc;

		Mapa mapa = Rozgrywka.mapa;

		for (int i = 0; i < mapa.ciastki.size(); i++) {
			if (this.intersects(mapa.ciastki.get(i))) {
				mapa.ciastki.remove(i);
				OknoWyboruNicku.punkty += 10;
				break;
			}

		}
		for (int k = 0; k < mapa.duszki.size(); k++) {

			for (int i = 0; i < mapa.bonusy.size(); i++) {

				if (this.intersects(mapa.bonusy.get(i))) {
					mapa.bonusy.remove(i);
					if (this.intersects(mapa.duszki.get(k))) {
						//czy_wygrana = true;
						//OknoWyboruNicku.rozgrywka.stop();
						mapa.duszki.remove(k);
						OknoWyboruNicku.punkty+=100;

					}
					break;
				}
				if (this.intersects(mapa.duszki.get(k))) {
					
					OknoWyboruNicku.zycie-=1;
					if(OknoWyboruNicku.zycie<0){
					czy_wygrana = false;
					OknoWyboruNicku.rozgrywka.stop();
					Wygrana.rozgrywka.stop();
					}
				}
			}

		}

		for (int i = 0; i < mapa.duszki.size(); i++) {

		}

		if (mapa.ciastki.size() == 0 && mapa.bonusy.size() == 0) {
			czy_wygrana = true;
			OknoWyboruNicku.rozgrywka.stop();
			Wygrana.rozgrywka.stop();
		}

	}

	/**
	 * metoda odpowiedzialna za ruch pacmana
	 * 
	 * @param nastx wsp x nastepnego polozenia
	 * @param nasty wsp y nastepnego polozenia
	 * @return
	 */
	public boolean ruch(int nastx, int nasty) {
		Rectangle bounds = new Rectangle(nastx, nasty, 50, 50);
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
	 * metoda wczytujaca graficzna reprezentacje pacmana
	 * 
	 * @param g
	 *            kontekst graficzny
	 */
	public void wczytajPacmana(Graphics g) {

		Ksztalt_pacman pacman = Rozgrywka.ksztalt_pacman;
		g.drawImage(pacman.pobierzKsztalt(0, 0), x, y, null);
	}

}
