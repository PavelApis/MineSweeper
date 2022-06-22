package io.github.pavelapis.minesweeper;

import javax.swing.JFrame;

public class Game extends JFrame {

    Minesweeper minesweeper;

    public Game(int sizeX, int sizeY, int mines) {
        setResizable(false);
        minesweeper = new Minesweeper(sizeX, sizeY, mines);
        add(minesweeper);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setVisible(true);
    }
}
