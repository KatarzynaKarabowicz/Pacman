package Pacman;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

/**
 * Created by pcc on 2017-03-29.
 */
public class Rozgrywka extends Canvas implements Runnable{
  
	
    public  static Mapa mapa;
    public static Ksztalt ksztalt_duszek;
    public static Ksztalt ksztalt_pacman;
    public static Pacman pacman;
   
    private boolean isRunning = false;
    private Thread thread;
    
    
    public Rozgrywka(){
       

        mapa = new Mapa("mapa1.txt");
        ksztalt_duszek = new Ksztalt("duszek.png");
        ksztalt_pacman=new Ksztalt("pacman64.png");
        
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
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
       //pacman.wczytajPacmana(g);
       
       
        g.dispose();
        bs.show();
    }


    @Override
    public void run() {
        requestFocus();
        int fps = 0;
        double timer = System.currentTimeMillis();
        long lastTime = System.nanoTime();
        double targetTick = 60.0;
        double delta = 0;
        double ns = 1000000000/targetTick;

        while(isRunning){
            long now = System.nanoTime();
            delta+=(now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1){
               // tick();
                wczytajRozgrywke();
                fps++;
                delta--;
            }

            if(System.currentTimeMillis()-timer >= 1000){
               // System.out.println(fps);
                fps = 0;
                timer+=1000;

            }
        }

        stop();

    }
/*
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) player.right = true;
        if(e.getKeyCode()==KeyEvent.VK_LEFT) player.left = true;
        if(e.getKeyCode()==KeyEvent.VK_UP) player.up = true;
        if(e.getKeyCode()==KeyEvent.VK_DOWN) player.down = true;
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) player.right = false;
        if(e.getKeyCode()==KeyEvent.VK_LEFT) player.left = false;
        if(e.getKeyCode()==KeyEvent.VK_UP) player.up = false;
        if(e.getKeyCode()==KeyEvent.VK_DOWN) player.down = false;

    }
    @Override
    public void keyTyped(KeyEvent e) {}

*/
}
