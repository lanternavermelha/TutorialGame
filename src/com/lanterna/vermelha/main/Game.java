package com.lanterna.vermelha.main;

import java.awt.*;

public class Game extends Canvas implements Runnable {

    public synchronized void start() {

    }

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    public Game() {
        new Window(WIDTH, HEIGHT, "Let's Build a Game!", this);
    }
    public static void main(String[] args) {
        new Game();
    }

    @Override
    public void run() {

    }
}
