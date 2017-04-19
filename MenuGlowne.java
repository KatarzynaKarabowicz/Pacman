package Pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

/**
 * Created by pcc on 2017-03-17. Klasa opisujaca menu glowne gry, tworzona przy
 * uruchomieniu programu
 *
 *
 * @author Katarzyna Karabowicz
 * @author Tomasz Kurowski
 */
public class MenuGlowne extends JFrame implements ActionListener {
	/**
	 * Przyciks startu gry
	 */
	private JButton start;
	/**
	 * Przycisk przejscia do instrukcji
	 */
	private JButton instrukcja;
	/**
	 * Przyciksk przejscia do listy najlepszych wyników;
	 */
	private JButton lista_wynikow;
	/**
	 * Przycisk konca gry
	 */
	private JButton koniec;

	// public static KoniecGry koniecc;

	/**
	 * konstruktor klasy opisujacej menu glowne gry
	 */

	public MenuGlowne() {
		super(Config.nazwaAplikacji);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocation(100, 100);

		setResizable(true);
		pack();

		setLayout(new GridLayout(4, 1, 5, 5));
		start = new JButton(Config.startMenu);
		add(start);
		start.addActionListener(this);
		// add(new JButton(Config.startMenu));
		instrukcja = new JButton(Config.zasady);
		add(instrukcja);
		instrukcja.addActionListener(this);
		// add(new JButton(Config.zasady));
		lista_wynikow = new JButton(Config.listaNajlepszychWynikow);
		add(lista_wynikow);
		lista_wynikow.addActionListener(this);
		// add(new JButton(Config.listaNajlepszychWyników));
		koniec = new JButton(Config.koniec);
		add(koniec);
		koniec.addActionListener(this);
		// add(new JButton(Config.koniec));
		setSize(Config.szerokoscOkna, Config.wysokoscOkna);

		// KoniecGry koniecc=new KoniecGry();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == start) {
			new OknoWyboruNicku().setVisible(true);
			dispose();

		} else if (source == instrukcja) {
			try {
				new Instrukcja().setVisible(true);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		} else if (source == lista_wynikow) {
			try {
				new NajlepszeWyniki().setVisible(true);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		} else if (source == koniec)
			;
		{
			dispose();
		}

	}

}
