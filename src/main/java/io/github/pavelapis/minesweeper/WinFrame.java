package io.github.pavelapis.minesweeper;

import javax.swing.*;
import java.awt.*;

public class WinFrame extends JFrame {
    public WinFrame(Minesweeper minesweeper) {
        setResizable(false);
        final JPanel winPanel = new JPanel();
        add(winPanel);
        winPanel.setPreferredSize(new Dimension(150, 80));
        winPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        winPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        final JLabel loseLabel = new JLabel("Congratulations, You WIN!");
        winPanel.add(loseLabel);

        final JLabel askLabel = new JLabel("Want to play again?");
        winPanel.add(askLabel);

        final JButton answerYes = new JButton("Yes");
        answerYes.addActionListener(actionEvent -> {
            setVisible(false);
            minesweeper.dispose();
            dispose();
            new WelcomeFrame();
        });
        winPanel.add(answerYes);

        final JButton answerNo = new JButton("No");
        answerNo.addActionListener(actionEvent -> {
            setVisible(false);
            minesweeper.dispose();
            dispose();
        });
        winPanel.add(answerNo);
        pack();
        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
