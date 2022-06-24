package io.github.pavelapis.minesweeper;

import javax.swing.JFrame;

public class Game extends JFrame {

    private Minesweeper minesweeper;

    public Game(final int sizeX, final int sizeY, final int mines) {
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
