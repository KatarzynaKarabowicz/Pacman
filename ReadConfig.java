package Pacman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Implementacja wczytywania pliku konfiguracyjngeo.
 * <p>
 * Zawiera metode przyjmujaca nazwe pliku konfiguracyjnego i zwracajaca
 * obiekt typu Properties zawierajacy stale konfiguracyjne.
 *
 * @author Katarzyna Karabowicz
 * @author Tomasz Kurowski
 * @version 1.0
 */
public class ReadConfig {

    /**
     * Metoda sluzaca do wyczytania wartosci z pliku <code>.properties</code>
     * i umieszczenia ich w obiekcie klasy Properties. Metoda zwraca nowo stworzony
     * obiekt.
     *
     * @param propFilePath sciezka dostepu do pliku <code>.properties</code>
     * @return obiekt Properties zawierający dane z pliku
     * @throws IOException jezeli nie uda sie otworzyc pliku konfiguracyjnego
     */
    public final Properties getProperties(String propFilePath) throws IOException {

        Properties prop = new Properties();
        try (InputStream inputStream = new FileInputStream(propFilePath)) {
            prop.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }
}