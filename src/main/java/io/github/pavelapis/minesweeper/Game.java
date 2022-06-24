package io.github.pavelapis.minesweeper;

import javax.swing.JFrame;

public class Game extends JFrame {

    public Game(final int sizeX, final int sizeY, final int mines) {
        setResizable(false);
        add(new Minesweeper(sizeX, sizeY, mines));
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setVisible(true);
    }
}
