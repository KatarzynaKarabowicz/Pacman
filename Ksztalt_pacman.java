package Pacman;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * klasa opisujaca wczytywanie ksztaltu pacmana z pliku
 *
 */
public class Ksztalt_pacman {

	private BufferedImage ksztalt;

	/**
	 * kontruktor klasy odpowiedzialnej za opis obrazkow
	 * 
	 * @param path odniesienie do odpowiedniego pliku
	 */
	public Ksztalt_pacman(String path) {

		// File imageFile = new File(path);
		try {
			ksztalt = ImageIO.read(getClass().getResource(path));
			// ksztalt=ImageIO.read(imageFile);
		} catch (IOException e) {
			System.out.println("nie zaladowano ksztaltu");
		}
	}

	/**
	 * metoda odpowiedzialna za pobranie okreslonego ksztalu
	 * 
	 * @param x   wspolrzedna na osi ox
	 * @param y  wspolrzedna na osi oy
	 * @return
	 */
	public BufferedImage pobierzKsztalt(int x, int y) {
		return ksztalt.getSubimage(x, y, 50, 50);
	}
}
