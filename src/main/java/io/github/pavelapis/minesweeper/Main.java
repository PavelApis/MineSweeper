package io.github.pavelapis.minesweeper;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(WelcomeFrame::new);
    }
}
