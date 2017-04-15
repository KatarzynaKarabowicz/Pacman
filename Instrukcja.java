package Pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Scanner;


/**
 * klasa opisujaca okno wyswietlajace okno z instrukcja gry
 * po wcisnieciu ANULUJ powraca sie do glownego menu gry
 */
public class Instrukcja extends JFrame implements ActionListener {
    /**
     * Obszar do wyświetlania instrukcji
     */
    private JTextArea notatnik;
    /**
     * Przycisk powrotu do menu glownego
     */
    private JButton powrot;
    /**
     * ScrollPane przewijający okno gdy instrukcja jest za długa
     */
     private JScrollPane scrollPane;
    /**
     * konstruktor klasy opisujacej okno z instrukcja gry
     * @throws FileNotFoundException wyjatek rzucany w przypadku bledu odczytu pliku
     */

    public Instrukcja() throws FileNotFoundException {
        super(Config.instrukcja);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(false);
        //setLayout(null);
        setResizable(true);
        pack();

        setLayout(new BorderLayout());
        notatnik= new JTextArea();

        scrollPane=new JScrollPane(notatnik);
        scrollPane.setBounds(50,50,600,600);
        add(scrollPane,BorderLayout.CENTER);
        powrot = new JButton(Config.powrot);
        add(powrot, BorderLayout.PAGE_END);
        powrot.addActionListener(this);

        try{

            File plik =  new File("Instrukcja.txt");
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
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == powrot){
            new MenuGlowne();
            dispose();
        }

    }
}