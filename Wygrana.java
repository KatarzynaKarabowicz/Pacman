package Pacman;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * Klasa ktore obiekt wywoluje okno w momencie wygranej
 * @author Katarzyna Karabowicz
 * @author Tomasz Kurowski
 *
 */
public class Wygrana extends JFrame implements ActionListener {
	private JLabel tekst;
	private JButton OK;
	private JButton NastepnyPoziom;
	public static Rozgrywka rozgrywka;
	public static JFrame okno;
	private static final long serialVersionUID = 1L;

	public Wygrana() {
		super(Config.wygrana);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// setLayout(null);
		setResizable(true);
		tekst = new JLabel("Wygrales!");
		add(tekst);
		pack();
		setSize(Config.szerokoscOkna, Config.wysokoscOkna);
		OK = new JButton("OK");
		add(OK);
		OK.addActionListener(this);
		NastepnyPoziom = new JButton("Nastepny poziom");
		add(NastepnyPoziom);
		NastepnyPoziom.addActionListener(this);
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
		else if (source == NastepnyPoziom){
			okno = new JFrame();
			
			rozgrywka=new Rozgrywka("mapa2.txt");
			okno.setTitle("Pacman");

			okno.setDefaultCloseOperation(okno.EXIT_ON_CLOSE);

			okno.add(rozgrywka);
			// okno.setLocationRelativeTo(null);
			//
			okno.setResizable(true);
			okno.pack();
			okno.setVisible(true);
			//for( int i=0; i<mapy.size();i++){
			rozgrywka.start();
			//}

			dispose();
			
		}
	}
}
