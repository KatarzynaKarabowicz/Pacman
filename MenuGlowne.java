package Pacman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

/**
 * Created by pcc on 2017-03-17.
 * Klasa opisujaca menu glowne gry,
 * tworzona przy uruchomieniu programu
 *
 *
 * @author Katarzyna Karabowicz
 * @author Tomasz Kurowski
 */
public class MenuGlowne extends JFrame implements ActionListener {
    private JButton start, instrukcja, lista_wynikow, koniec;

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
        //add(new JButton(Config.startMenu));
        instrukcja=new JButton(Config.zasady);
        add(instrukcja);
        instrukcja.addActionListener(this);
        //add(new JButton(Config.zasady));
        lista_wynikow=new JButton(Config.listaNajlepszychWynikow);
        add(lista_wynikow);
        lista_wynikow.addActionListener(this);
        //add(new JButton(Config.listaNajlepszychWyników));
        koniec=new JButton(Config.koniec);
        add(koniec);
        koniec.addActionListener(this);
        //add(new JButton(Config.koniec));
        setSize(Config.szerokoscOkna, Config.wysokoscOkna);





        }




    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == start) {
            new OknoWyboruNicku().setVisible(true);
            dispose();

        }else if(source==instrukcja) {
            try {
                new Instrukcja().setVisible(true);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        } else if(source==lista_wynikow){
        	try {
                new NajlepszeWyniki().setVisible(true);
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }else if (source==koniec);{
            dispose();
        }

    }
 /*
    *//**
         * Panel głowny layoutu CardLayout
         *//*
    private JPanel cards;

    *//**
         * Identyfikator panelu menuPanel
         *//*
    final static String PANELMENU = "panelMenu";

    *//**
         * Panel z zawartoscia menu glownego
         *//*
    private JPanel panelMenu;

    *//**
         * Identyfikator panelu najlepszeWynikiPanel
         *//*
    final static String PANELNAJLEPSZEWYNIKI = "panelNajlepszeWyniki";

    *//**
         * Panel z najlepszymi wynikami
         *//*
    private JPanel panelNajlepszeWyniki;

    *//**
         * Pole tekstowe wyswietlające liste najlepszych wyników
         *//*
    private JTextArea nwTextArea;

    *//**
         * Identyfikator panelu startPanel
         *//*
    final static String PANELSTART = "panelStart";

    *//**
         * Panel, w którym podajemy nic gracza
         *//*
    private JPanel panelStart;

    *//**
         * Pole, w które wprowadzamy nick gracza
         *//*
    private JTextField nickTextField;

    *//**
         * Identyfikator panelu zasadyPanel
         *//*
    final static String PANELZASAD = "panelZasad";

    *//**
         * Panel wyswietlajacy zasady gry
         *//*
    private JPanel panelZasad;

    *//**
         * Identyfikator panelu gameOver
         *//*
    final static String PANELKONIECGRY = "panelKoniecGry";

    *//**
         * Panel ukonczenia gry
         *//*
    private JPanel panelKoniecGry;

    *//**
         * Pole wyswietlające podsunowanie rozgrywki
         *//*
    private JTextArea podsumowanieTextArea;

    *//**
         * Identyfikator panelu pausePanel
         *//*
    final static String PANELPAUZY = "panelPauzy";
    *//**
         * Panel manu pauzy podczas gry
         *//*
    private JPanel panelPauzy;

    *//**
         *
         * Identyfikator panelu gamePanel
         *//*
    final static String PANELGRY = "panelGry";
    *//**
         * Panel wyswietlajacy gre
         *//*
    private JPanel panelGry;

    *//**
         *     Identyfikator panelu levelPassedPanel
         *//*
    final static String PANELUKONCZONEGOPOZIOMU = "panelUkonczonegoPoziomu";

    *//**
         * Panel ukonczenia poziomu
         *//*
    private JPanel panelUkonczeniaPoziomu;


    *//**
         * Określa, który poziom powinien zostać wyświetlony
         *//*
    private int wyswietlanyPoziom;


    *//**
         * Konstruktor Menu głównego
         * Inicjalizuje instancję poprzez init()
         *//*
    public MainWindow(){ init();}

    *//**
         * Tworzy okno główne i wszystkie panele menu
         *//*
    public void init(){
        this.setTitle(Config.nazwaAplikacji);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(Config.szerokoscOkna, Config.wysokoscOkna);
        this.wyswietlanyPoziom = 1;

        this.setLocationRelativeTo(null);

        cards = new JPanel(new CardLayout());

        createMenu();
        *//*createStart();
        createHighScores();
        createMenuPause();
        createLevelPassedPanel();
        createRulesPanel();
        creategameOverPanel();
       *//*

        cards.add(panelMenu, PANELMENU);
        cards.add(panelNajlepszeWyniki, PANELNAJLEPSZEWYNIKI);
        cards.add(panelStart, PANELSTART);
        cards.add(panelPauzy, PANELPAUZY);
        cards.add(panelUkonczeniaPoziomu, PANELUKONCZONEGOPOZIOMU);
        cards.add(panelZasad, PANELZASAD);
        cards.add(panelKoniecGry, PANELKONIECGRY);

        CardLayout cardLayout = (CardLayout) cards.getLayout();
        cardLayout.show(cards, PANELMENU);

        this.getContentPane().add(cards);
    }
       *//** super("Pacman");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
         setLocation(300, 200);
         setSize(500, 500);
         *//**setResizable(false);

         setLayout(new GridLayout(4,1, 5,5));
         add(new JButton("START"));
         add(new JButton("INSTRUKCJA"));
         add(new JButton("LISTA WYNIKÓW"));
         add(new JButton("KONIEC"));
         }
         *//*
       private void createMenu() {

           panelMenu = new JPanel((new GridBagLayout()));
           panelMenu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); //Obwodka ekranu, czysto estetyczna

           GridBagConstraints c = new GridBagConstraints();
           c.gridx = 0;
           c.gridy = 0;
           c.insets = new Insets(10, 10, 10, 10);
           JButton startButton = new JButton(Config.menuStart);
           startButton.addActionListener(new StartButtonListener());
           panelMenu.add(startButton, c);

           c.gridy = 1;
           JButton highScoresButton = new JButton(Config.menuHighscore);
           highScoresButton.addActionListener(new HighscoresButtonListener());
           panelMenu.add(highScoresButton, c);


           c.gridy = 2;
           JButton rulesButton = new JButton(Config.menuRules);
           rulesButton.addActionListener(new RulesButtonListener());
           panelMenu.add(rulesButton, c);


           c.gridy = 3;
           JButton endButton = new JButton(Config.menuExit);
           endButton.addActionListener(new QuitButtonListener());
           panelMenu.add(endButton, c);


       }
    public class StartButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            CardLayout cardLayout = (CardLayout) cards.getLayout();
            cardLayout.show(cards, STARTPANEL);
        }
    }
    */
    }
