package Pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * klasa reprezentujaca okno wysiwetlajace najlepsze wyniki
 */
public class NajlepszeWyniki extends JFrame implements ActionListener {
	/**
	 * Obszar wyswietlający najlepsze wyniki
	 */
	private JTextArea notatnik;
	/**
	 * Przycisk powrotu do menu glownego
	 */
	private JButton powrot;
	/**
	 * ScrollPane przewijający okno gdy lista najlepszych wyników jest za
	 * długa
	 */
	private JScrollPane scrollPane;

	public NajlepszeWyniki() throws FileNotFoundException {
		super(Config.najlepszeWyniki);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);
		// setLayout(null);
		setResizable(true);
		pack();

		setLayout(new BorderLayout());
		notatnik = new JTextArea();

		scrollPane = new JScrollPane(notatnik);
		scrollPane.setBounds(50, 50, 600, 600);
		add(scrollPane, BorderLayout.CENTER);
		powrot = new JButton(Config.powrot);
		add(powrot, BorderLayout.PAGE_END);
		powrot.addActionListener(this);

		try {

			File plik = new File("NajlepszeWyniki.txt");
			Scanner wczytaj = new Scanner(plik);

			while (wczytaj.hasNextLine()) {
				notatnik.append(wczytaj.nextLine() + "\n");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		setSize(Config.szerokoscOkna, Config.wysokoscOkna);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == powrot) {
			new MenuGlowne();
			dispose();
		}

	}
}