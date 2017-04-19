package Pacman;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * Klasa ktore obiekt wywoluje okno w momencie przegranej
 * @author Katarzyna Karabowicz
 * @author Tomasz Kurowski
 *
 */
public class Przegrana extends JFrame implements ActionListener {

	private JLabel tekst;
	private JButton OK;
	private static final long serialVersionUID = 1L;

	public Przegrana() {
		super(Config.przegrana);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		// setLayout(null);
		setResizable(true);
		tekst = new JLabel("Przegrales!");
		add(tekst);
		pack();
		setSize(Config.szerokoscOkna, Config.wysokoscOkna);
		OK = new JButton("OK");
		add(OK);
		OK.addActionListener(this);
		setLayout(new FlowLayout());

	}
/**
 * metoda odpowiedzialna za odpowiednie reakcje na wcisnienie przycisku
 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == OK) {
			new MenuGlowne();
			dispose();
		}
	}
}
