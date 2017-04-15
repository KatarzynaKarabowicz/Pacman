package Pacman;

import Pacman.MenuGlowne;

import java.awt.*;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        String configPath = "config.properties";
        
        
        ReadConfig readConfig = new ReadConfig();
        final Properties config;

        try {
            Properties prop = readConfig.getProperties(configPath);
            Config.readConstants(prop);


            new MenuGlowne();

        } catch (IOException e) {
            System.out.println("Exception when loading properties: " + e);
        }
    }
}

