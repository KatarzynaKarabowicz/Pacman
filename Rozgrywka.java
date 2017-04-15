package Pacman;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;



/**
 * Created by pcc on 2017-03-29.
 */
public class Rozgrywka extends Canvas implements Runnable, KeyListener{
    /**
     * Główna mapa gry
     */
    public  static Mapa mapa;
    /**
     * Ksztalt, pod którym kryje się postac duszka
     */
    public static Ksztalt ksztalt_duszek;
    /**
     *ksztalt, pod którym kryje sie postać Pacmana
     */
    public static Ksztalt_pacman ksztalt_pacman;
    
    public static Ksztalt ksztalt_ciastko;
    
    public static Ksztalt ksztalt_bonus;
    /**
     *Postac glowna gry
     */
    public static Pacman pacman;
    /**
     * Zmienna boolowska okreslajaca czy gra trwa
     */
    private boolean isRunning = false;
    /**
     * Glowny watek odpowidajacy za gre
     */
    private Thread thread;
    
    public static Przegrana przegrana;
    
    public static Wygrana wygrana;
    
    public Rozgrywka(){
       

    	addKeyListener(this);
    	
        mapa = new Mapa("mapa2.txt");
        ksztalt_duszek = new Ksztalt("duszek.png");
        pacman=new Pacman(mapa.rozmiarMapy*32, mapa.rozmiarMapy*32);
        ksztalt_pacman=new Ksztalt_pacman("pacman50.png");
        ksztalt_ciastko=new Ksztalt("ciastko.png");
        ksztalt_bonus=new Ksztalt("bonus.png");
        
        Dimension dimension =new Dimension(mapa.rozmiarMapy*64, mapa.rozmiarMapy*64);
        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);


        
    }
    public synchronized void start(){
        if(isRunning) return;
        isRunning = true;
        thread = new Thread(this);
        thread.start();
        
    }

    public synchronized void stop(){
        if (!isRunning) return;
        isRunning = false;
        
        try {
            
            if(Pacman.czy_wygrana){
            wygrana= new Wygrana();
            OknoWyboruNicku.okno.setVisible(false);
            }
            else{
            	przegrana=new Przegrana();
            	OknoWyboruNicku.okno.setVisible(false);
            }
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    
    private void polozenie()
    {
    	pacman.polozenie();
    	mapa.polozenie();
    }
    
     void wczytajRozgrywke(){
        BufferStrategy bs =getBufferStrategy();
        if (bs==null){
            createBufferStrategy(3);
            return;
        }
        Graphics g =bs.getDrawGraphics();
        g.setColor(Color.GRAY);
        g.fillRect(0,0,mapa.rozmiarMapy*64,mapa.rozmiarMapy*64);
        mapa.wczytajMape(g);
       pacman.wczytajPacmana(g);
       
       
        g.dispose();
        bs.show();
    }


    @Override
    public void run() {
        requestFocus();
        int fps = 0;
        double timer = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        double targetpolozenie = 60.0;
        double delta = 0;
        double ns = 1000000000/targetpolozenie;

        while(isRunning){
            long now = System.nanoTime();
            delta+=(now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1){
                wczytajRozgrywke();
                polozenie();

                fps++;
                delta--;
            }

            if(System.currentTimeMillis()-timer >= 1000){
                System.out.println(fps);
                //System.out.println(mapa.rozmiarMapy);

                fps = 0;
                timer+=1000;

            }
        }

        stop();
       

    }

    
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) pacman.prawo = true;
        if(e.getKeyCode()==KeyEvent.VK_LEFT) pacman.lewo = true;
        if(e.getKeyCode()==KeyEvent.VK_UP) pacman.gora = true;
        if(e.getKeyCode()==KeyEvent.VK_DOWN) pacman.dol = true;
	
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) pacman.prawo = false;
        if(e.getKeyCode()==KeyEvent.VK_LEFT) pacman.lewo = false;
        if(e.getKeyCode()==KeyEvent.VK_UP) pacman.gora = false;
        if(e.getKeyCode()==KeyEvent.VK_DOWN) pacman.dol = false;
	}
	

}

