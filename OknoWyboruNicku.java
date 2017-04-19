package Pacman;

import javax.swing.*;
import java.util.List;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * klasa odpowiedzialna za tworzenie okna wyboru nicku po wpisaniu nicku i
 * nacisnieciu OK otwiera sie nowe okno z rozgrywka po nacisnieciu ANULUJ
 * powraca sie do glownego Menu gry
 */
public class OknoWyboruNicku extends JFrame implements ActionListener {
	/**
	 * Przycisk zatwierdzenia nicku i przejscia do glownej gry
	 */
	private JButton OK;
	/**
	 * Przycisk powrotu do menu glownego
	 */
	private JButton anuluj;
	/**
	 * Okienko do wpisania nicku
	 */
	private JTextField nazwaGracza;
	// private JPanel menuPanel;

	public static JFrame okno;

	public static Rozgrywka rozgrywka;
	
	public static int zycie=180000;
	
	public static int punkty=0;
	
	public List <Mapa> mapy;

	/**
	 * konstruktor klasy odpowiedzialnej za tworzenie okna wyboru nicku
	 */
	public OknoWyboruNicku() {
		
		super(Config.nazwaOknaWyboruNicku);

		
		//mapa = new Mapa("mapa2.txt");
		//mapy.add(new Mapa("mapa1.txt"));
		//mapy.add(new Mapa("mapa2.txt"));
		
		
		
		
		
		
		
		
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		setResizable(true);
		pack();

		// setLayout(new BorderLayout());
		/*
		 * menuPanel = new JPanel(new GridBagLayout()); GridBagConstraints a
		 * =new GridBagConstraints(); a.gridx =0; a.gridy=0; a.insets= new
		 * Insets(10,10,10,10);
		 */ setLayout(new GridLayout(3, 1));
		nazwaGracza = new JTextField(Config.nazwaNicku);
		add(nazwaGracza);

		OK = new JButton(Config.zatwierdzenieNicku);
		add(OK);
		OK.addActionListener(this);

		anuluj = new JButton(Config.powrot);
		add(anuluj);
		anuluj.addActionListener(this);

		setSize(Config.szerokoscOkna, Config.wysokoscOkna);

		okno = new JFrame();
		rozgrywka = new Rozgrywka("mapa1.txt");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == OK) {

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

		} else if (source == anuluj) {
			new MenuGlowne();
			dispose();
		}
	}
}
