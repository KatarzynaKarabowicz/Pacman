package Pacman;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * klasa odpowiedzialna za tworzenie okna wyboru nicku
 * po wpisaniu nicku i nacisnieciu OK otwiera sie nowe okno z rozgrywka
 * po nacisnieciu ANULUJ powraca sie do glownego Menu gry
 */
public class OknoWyboruNicku extends JFrame implements ActionListener {
    private JButton OK, anuluj;
    private JTextField nazwaGracza;
    private JPanel menuPanel;
    
    /**
     * konstruktor klasy odpowiedzialnej za tworzenie okna wyboru nicku
     */
    public OknoWyboruNicku() {
        super(Config.nazwaOknaWyboruNicku);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setResizable(true);
        pack();

       // setLayout(new BorderLayout());
       /*menuPanel = new JPanel(new GridBagLayout());
        GridBagConstraints a =new GridBagConstraints();
        a.gridx =0;
        a.gridy=0;
        a.insets= new Insets(10,10,10,10);
*/      setLayout(new GridLayout(3,1));
        nazwaGracza=new JTextField(Config.nazwaNicku);
        add(nazwaGracza);


        OK = new JButton(Config.zatwierdzenieNicku);
        add(OK);
        OK.addActionListener(this);


        anuluj=new JButton(Config.powrot);
        add(anuluj);
        anuluj.addActionListener(this);



        setSize(Config.szerokoscOkna, Config.wysokoscOkna);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==OK){
           
        	Rozgrywka rozgrywka= new Rozgrywka();
           JFrame okno=new JFrame();
          
           okno.setTitle("Pacman");
          
           
           okno.setDefaultCloseOperation(okno.EXIT_ON_CLOSE);
          
           okno.add(rozgrywka);
           
           okno.setResizable(true);
           okno.pack();
           okno.setVisible(true);
           rozgrywka.start();
          
           dispose();
           

        }else if (source==anuluj){
            new MenuGlowne();
            dispose();
        }
    }
}
