package core.engine;

import core.game.Blocks;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private final Window window;
    private final Thread thread;

    private int width,height;

    private boolean running;

    int FPS_CAP = 60;

    private BufferStrategy bs;

    // Create sprites
    private BufferedImage bIGround;
    private BufferedImage bIWood;
    private BufferedImage bILeaves;

    // Create blocks
    private final Blocks ground = new Blocks("ground", bIGround);
    private final Blocks wood = new Blocks("wood", bIWood);
    private final Blocks leaves = new Blocks("leaves", bILeaves);

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        window = new Window(title, width, height);
        window.init();
        thread = new Thread(this);
        running = false;

        // Initialize blocks
        ground.init();
        wood.init();
        leaves.init();
    }

    // Game loop
    private void gameLoop() {
        double delta = 1000.0/FPS_CAP;
        long last = System.currentTimeMillis();
        while (running) {
            long now = System.currentTimeMillis();
            input();
            if (now-last > delta) {
                update();
                render();
            }
        }
        stop();
    }

    // Handle user input
    private void input() {

    }

    // Update the game
    private void update() {

    }

    // Render everything
    private void render() {

        bs = window.getBufferStrategy();
        if (bs == null) {
            window.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        update();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,width,height);
        for (int i = 1; i*16 <= width ; i++) {
            ground.drawBlock(g,width-i*16,height-16);
            ground.drawBlock(g,width-i*16,height-16*2);
            ground.drawBlock(g,width-i*16,height-16*3);
            ground.drawBlock(g,width-i*16,height-16*4);
            ground.drawBlock(g,width-i*16,height-16*5);
            ground.drawBlock(g,width-i*16,height-16*6);
            ground.drawBlock(g,width-i*16,height-16*7);
            ground.drawBlock(g,width-i*16,height-16*8);
            ground.drawBlock(g,width-i*16,height-16*9);
            ground.drawBlock(g,width-i*16,height-16*10);
            ground.drawBlock(g,width-i*16,height-16*11);
            ground.drawBlock(g,width-i*16,height-16*12);
        }
        g.dispose();
        bs.show();
    }

    public synchronized void start() {
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        gameLoop();
    }
}
