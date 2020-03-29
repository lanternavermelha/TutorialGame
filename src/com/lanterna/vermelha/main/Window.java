package com.lanterna.vermelha.main;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas {

    public Window(int width, int heigth, String title, Game game) {
        JFrame frame = new JFrame(title); // frame of our game window

        frame.setPreferredSize(new Dimension(width, heigth));
        frame.setMaximumSize(new Dimension(width, heigth));
        frame.setMinimumSize(new Dimension(width, heigth));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // stops the thread when exits game, it's important to have this
        frame.setResizable(false); //cannot resize window
        frame.setLocationRelativeTo(null); // windows starts in the middle of the screen
        frame.add(game); //adds the game into the frame
        frame.setVisible(true); // makes frame visible
        game.start(); //starts the game
    }
}
