package Pacman;

import java.util.Properties;

/**
 * Klasa zawierajaca stale operacyjne, udostepniajaca je dla wszystkich
 * komponentow programu. Nazwy danych sa identyczne z nazwami parametrow
 * konfiguracyjnych i maja typy wlasciwe dla ich wykorzystania.
 *
 *@author Katarzyna Karabowicz
 * @author Tomasz Kurowski
 * @version 1.0
 */
public class Config {
    /**
     * Nazwa aplikacji
     */
    public static String nazwaAplikacji;
    /**
     * Szerokosc okna aplikacji
     */
    public static int szerokoscOkna;
    /**
     * Wysokosc okna aplikacji
     */
    public static int wysokoscOkna;
    /**
     * Tekst na przycsiku Start
     */
    public static String startMenu;

    /**
     *Tekst przycisku Isntrukcja
     */
    public static String zasady;

    /**
     *Tekst przycisku LisatWyniow
     */
    public static String listaNajlepszychWynikow;

    /**
     *Tekst przycisku Koniec
     */
    public static String koniec;

    /**
     * Nazwa okna z wpisaniem nicku
     */
    public static String nazwaOknaWyboruNicku;
    /**
     * Tekst na przycisku zatwierdzenia nicku
     */
    public static String zatwierdzenieNicku;
    /**
     * tekst na przycisku powrotu do menu glownego
     */
    public static String powrot;

    /**
     * Tekst w miejscu wyboru nicku
     */
    public static String nazwaNicku;
    /**
     * Tekst instrukcji
     */
    public static String instrukcja;
    
    /**
     * Lista najlepszych wynikow
     */
    public static String najlepszeWyniki;
    
    public static String przegrana;
    public static String wygrana;




    public static void readConstants(Properties config) {
        nazwaAplikacji=config.getProperty("nazwaAplikacji");
        szerokoscOkna=Integer.parseInt(config.getProperty("szerokoscOkna"));
        wysokoscOkna=Integer.parseInt(config.getProperty("wysokoscOkna"));
        startMenu=config.getProperty("startMenu");
        zasady=config.getProperty("zasady");
        listaNajlepszychWynikow=config.getProperty("listaNajlepszychWynikow");
        koniec=config.getProperty("koniec");
        nazwaOknaWyboruNicku=config.getProperty("nazwaOknaWyboruNicku");
        zatwierdzenieNicku=config.getProperty("zatwierdzenieNicku");
        powrot=config.getProperty("powrot");
        nazwaNicku=config.getProperty("nazwaNicku");
        instrukcja=config.getProperty("instrukcja");
        najlepszeWyniki=config.getProperty("najlepszeWyniki");
        przegrana=config.getProperty("przegrana");
        wygrana=config.getProperty("wygrana");


    }

}
