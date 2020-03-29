package com.lanterna.vermelha.main;

import java.awt.*;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    private Thread thread; //single thread game (not recommended, unless its a simple game)
    private boolean running = false;

    public Game() {
        new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);
    }

    public synchronized void start() {
        thread = new Thread(this); //instantiates a new thread of our Game(this) class
        thread.start(); //starts the thread
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join(); //thread is stopped
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Game();
    }

    // game loop
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) /ns;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void render() {
    }

    private void tick() {
    }
}
