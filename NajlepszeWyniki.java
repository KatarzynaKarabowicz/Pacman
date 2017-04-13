package Pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * klasa reprezentujaca okno wyswietlajace najlepsze wyniki 
 * po nacisnieciu ANULUJ powraca sie do glownego menu gry
 */
public class NajlepszeWyniki extends JFrame implements ActionListener {
    private JTextArea notatnik;
    private JButton powrót;

    /**
     * konstruktor klasy reprezentujacej okno najlepszych wynikow
     * @throws FileNotFoundException wyjatek rzucany w momencie bledu odczytu pliku 
     */

    public NajlepszeWyniki() throws FileNotFoundException {
        super(Config.najlepszeWyniki);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        //setLayout(null);
        setResizable(true);
        pack();

        setLayout(new BorderLayout());
        notatnik= new JTextArea();

        JScrollPane scrollPane=new JScrollPane(notatnik);
        scrollPane.setBounds(50,50,600,600);
        add(scrollPane,BorderLayout.CENTER);
        powrót = new JButton(Config.powrot);
        add(powrót, BorderLayout.PAGE_END);
        powrót.addActionListener(this);

        try{

            File plik =  new File("NajlepszeWyniki.txt");
            Scanner wczytaj= new Scanner(plik);


            while(wczytaj.hasNextLine()){
                notatnik.append(wczytaj.nextLine()+ "\n");
            }


        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }



        setSize(Config.szerokoscOkna, Config.wysokoscOkna);


    }
    
    /**
     * metoda 
     */
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == powrót){
            new MenuGlowne();
            dispose();
        }

    }
}