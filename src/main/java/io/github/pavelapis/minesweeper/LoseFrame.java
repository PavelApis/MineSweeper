package io.github.pavelapis.minesweeper;

import java.awt.Component;
import java.awt.Dimension;
import java.io.Serial;
import javax.swing.*;


public class LoseFrame extends JFrame {

    @Serial
    private static final long serialVersionUID = 5L;

    public LoseFrame(final Minesweeper minesweeper) {
        setResizable(false);
        final JPanel losePanel = new JPanel();
        add(losePanel);
        losePanel.setPreferredSize(new Dimension(150, 80));
        losePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        losePanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        final JLabel loseLabel = new JLabel("Sorry, You lose!");
        losePanel.add(loseLabel);

        final JLabel askLabel = new JLabel("Want to try again?");
        losePanel.add(askLabel);

        final JButton answerYes = new JButton("Yes");
        answerYes.addActionListener(actionEvent -> {
            setVisible(false);
            minesweeper.dispose();
            dispose();
            new WelcomeFrame();
        });
        losePanel.add(answerYes);

        final JButton answerNo = new JButton("No");
        answerNo.addActionListener(actionEvent -> {
            setVisible(false);
            minesweeper.dispose();
            dispose();
        });
        losePanel.add(answerNo);
        pack();
        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
