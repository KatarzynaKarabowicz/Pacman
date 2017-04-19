package Pacman;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;

/**
 * klasa odpowiedzialna za opis przebiegu rozgrywki
 */
public class Rozgrywka extends Canvas implements Runnable, KeyListener {
	/**
	 * Glowna mapa gry
	 */
	public static Mapa mapa;
	/**
	 * Ksztalt, pod ktorym kryje sie postac duszka
	 */
	public static Ksztalt ksztalt_duszek;
	/**
	 * ksztalt, pod ktorym kryje sie postac Pacmana
	 */
	public static Ksztalt_pacman ksztalt_pacman;
	/**
	 * ksztalt, pod ktorym kryje sie postac ciastka
	 */
	public static Ksztalt ksztalt_ciastko;
	/**
	 * ksztalt, pod ktorym kryje sie postac bonusu
	 */
	public static Ksztalt ksztalt_bonus;
	/**
	 * Postac glowna gry
	 */
	public static Pacman pacman;
	/**
	 * Zmienna boolowska okreslajaca czy gra trwa
	 */
	private boolean isRunning = false;
	/**
	 * Glowny watek odpowidajacy za gre
	 */
	private Thread thread;
	/**
	 * obiekt prezentujacy okno gdy nastapi przegrana
	 */
	public static Przegrana przegrana;
	/**
	 * obiekt prezentujacy okno gdy nastapi wygrana
	 */
	public static Wygrana wygrana;
	/**
	 * konstruktor klasy odpowiedzialnej za przebieg gry
	 */
	public Rozgrywka(String nazwa_mapy) {

		addKeyListener(this);

		mapa = new Mapa(nazwa_mapy);
		
		ksztalt_duszek = new Ksztalt("duszek.png");
		pacman = new Pacman(mapa.rozmiarMapy * 32, mapa.rozmiarMapy * 32);
		ksztalt_pacman = new Ksztalt_pacman("pacman50.png");
		ksztalt_ciastko = new Ksztalt("ciastko.png");
		ksztalt_bonus = new Ksztalt("bonus.png");

		Dimension dimension = new Dimension(mapa.rozmiarMapy * 64, mapa.rozmiarMapy * 64);
		setPreferredSize(dimension);
		setMaximumSize(dimension);
		setMinimumSize(dimension);

	}
	/**
	 * metoda odpowiedzialnia za start rozgrywki
	 */
	public synchronized void start() {
		if (isRunning)
			return;
		isRunning = true;
		thread = new Thread(this);
		thread.start();

	}
	/**
	 * metoda odpowiedzialnia za koniec rozgrywki
	 */
	public synchronized void stop() {
		if (!isRunning)
			return;
		isRunning = false;

		try {

			if (Pacman.czy_wygrana) {
				wygrana = new Wygrana();
				OknoWyboruNicku.okno.setVisible(false);
			} else {
				przegrana = new Przegrana();
				OknoWyboruNicku.okno.setVisible(false);
			}
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	/**
	 * metoda odpowiedzialnia za opis polozenia poszczegolnych komponentow
	 */
	private void polozenie() {
		pacman.polozenie();
		mapa.polozenie();
	}
	/**
	 * metoda odpowiedzialna za wczytanie rozgrywki (mapy i pacmana)
	 */
	void wczytajRozgrywke() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, mapa.rozmiarMapy * 64, mapa.rozmiarMapy * 64);
		mapa.wczytajMape(g);
		pacman.wczytajPacmana(g);

		g.dispose();
		bs.show();
	}
	/**
	 * metoda odpowiedzialna za odpowiednie wczytywanie rozgrywki
	 */
	@Override
	public void run() {
		requestFocus();
		int fps = 0;
		double timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		double targetpolozenie = 60.0;
		double delta = 0;
		double ns = 1000000000 / targetpolozenie;

		while (isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;

			while (delta >= 1) {
				wczytajRozgrywke();
				polozenie();

				fps++;
				delta--;
			}

			if (System.currentTimeMillis() - timer >= 1000) {
				//System.out.println(fps);
				System.out.println(OknoWyboruNicku.zycie);
				System.out.println(OknoWyboruNicku.punkty);

				fps = 0;
				timer += 1000;

			}
		}

		stop();

	}
	/**
	 * metoda przypisujaca odpowiednie wartosci boolowskie po wcisnieciu przycisku
	 */
	
	@Override 
	public void keyTyped(KeyEvent e){
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			pacman.prawo = true;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			pacman.lewo = true;
		if (e.getKeyCode() == KeyEvent.VK_UP)
			pacman.gora = true;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			pacman.dol = true;

	}

	
	/**
	 * metoda przypisujaca odpowiednie wartosci boolowskie po zwolnieniu przycisku
	 */
	
	@Override
	public void keyReleased(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			pacman.prawo = false;
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			pacman.lewo = false;
		if (e.getKeyCode() == KeyEvent.VK_UP)
			pacman.gora = false;
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			pacman.dol = false;
	}

}
