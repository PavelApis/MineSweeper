package io.github.pavelapis.minesweeper;

import io.github.pavelapis.minesweeper.frames.WelcomeFrame;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(WelcomeFrame::new);
    }
}
