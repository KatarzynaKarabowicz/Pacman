package Pacman;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Klasa opisujaca mape. Zawiera komponenty takie jak plytki, pacman, duszyki,
 * ciastka, bonusy.
 * 
 *
 */
public class Mapa {

	// public int szerokosc=640;
	// public int wysokoscMapy=300;
	/**
	 * stala zmienna przechowujaca rozmiar mapy
	 */
	static public int rozmiarMapy;
	/**
	 * tablica obiektow plytek
	 */
	public Plytka[][] plytki;
	/**
	 * tablica obiektow ciastek
	 */
	public List<Ciastko> ciastki;
	/**
	 * tablica duszkow
	 */
	public List<Duszek> duszki;
	/**
	 * tablica bonusow
	 */
	public List<Bonus> bonusy;
	/**
	 * obiekt pacman
	 */
	public Pacman pacman;

	/**
	 * konstruktor klasy opisujacej mape wczytywana z pliku tekstowego
	 * 
	 * @param path
	 *            odnosnik do pliku
	 */
	public Mapa(String path) {

		ciastki = new ArrayList<>();
		bonusy = new ArrayList<>();
		duszki = new ArrayList<>();

		try {

			File plik = new File(path);
			Scanner in = new Scanner(plik);

			String linijka1 = in.nextLine();
			rozmiarMapy = linijka1.length();
			/*
			 * try{ File plik = new File(path); FileReader fR=new
			 * FileReader(path); BufferedReader bf=new BufferedReader(fR);
			 * Scanner in= new Scanner(plik);
			 * 
			 * szerokoscMapy=bf.readLine().length();
			 * //szerokoscMapy=linijka1.length();
			 * 
			 * bf.close(); } catch (IOException e){ e.printStackTrace(); }
			 */

			plytki = new Plytka[rozmiarMapy][rozmiarMapy];
			/*
			 * ciastki=new Ciastko[rozmiarMapy][rozmiarMapy]; duszki=new
			 * Duszek[rozmiarMapy][rozmiarMapy]; bonusy=new
			 * Bonus[rozmiarMapy][rozmiarMapy]; pacman=new
			 * Pacman(rozmiarMapy,rozmiarMapy);
			 */

			int y = 0;

			while (in.hasNextLine()) {

				String linijka = in.nextLine();
				for (int x = 0; x < linijka.length(); x++) {
					if (linijka.charAt(x) == '1')
						plytki[x][y] = new Plytka(x * 64, y * 64);

					else if (linijka.charAt(x) == 'P') {
						pacman = new Pacman(x * 64, y * 64);
						// Rozgrywka.pacman.x=x*32;
						// Rozgrywka.pacman.y=y*32;
					}

					else if (linijka.charAt(x) == 'D')
						duszki.add(new Duszek(x * 64, y * 64));

					else if (linijka.charAt(x) == 'B')
						bonusy.add(new Bonus(x * 64, y * 64));

					else
						ciastki.add(new Ciastko(x * 64, y * 64));

				}

				y++;
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void polozenie() {
		for (int i = 0; i < duszki.size(); i++) {
			duszki.get(i).polozenie();
		}
	}

	/**
	 * metoda odpowiedzialna za wczytanie odpowiednich komponentow mapy (plytek,
	 * duszkow, ciastek, bonusow, pacmama)
	 * 
	 * @param g
	 *            kontekst graficzny
	 */
	public void wczytajMape(Graphics g) {
		for (int xx = 0; xx < rozmiarMapy; xx++)
			for (int yy = 0; yy < rozmiarMapy; yy++) {
				if (plytki[xx][yy] != null)
					plytki[xx][yy].wczytajPlytke(g);
			}

		for (int i = 0; i < ciastki.size(); i++) {
			ciastki.get(i).wczytajCiastko(g);
			//
			//
		}
		for (int i = 0; i < bonusy.size(); i++) {
			bonusy.get(i).wczytajBonus(g);
		}
		for (int i = 0; i < duszki.size(); i++) {
			duszki.get(i).wczytajDuszka(g);
		}
	}
}
