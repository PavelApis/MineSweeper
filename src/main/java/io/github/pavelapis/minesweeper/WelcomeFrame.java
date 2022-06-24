package io.github.pavelapis.minesweeper;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.util.function.Function;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WelcomeFrame extends JFrame {
    public WelcomeFrame() {
        setResizable(false);
        final JPanel introPanel = new JPanel();
        add(introPanel);
        introPanel.setPreferredSize(new Dimension(300, 110));
        introPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        introPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        final JLabel rowInputLabel = new JLabel("Enter number of rows: ");
        introPanel.add(rowInputLabel);
        final JTextField rowInputField = new JTextField(5);
        introPanel.add(rowInputField);

        final JLabel columnInputLabel = new JLabel("Enter number of columns: ");
        introPanel.add(columnInputLabel);
        final JTextField columnInputField = new JTextField(5);
        introPanel.add(columnInputField);

        final JLabel minesInputLabel = new JLabel("Enter number of mines: ");
        introPanel.add(minesInputLabel);
        final JTextField minesInputField = new JTextField(5);
        introPanel.add(minesInputField);


        final JButton startGame = new JButton("Start Game");
        startGame.addActionListener(actionEvent -> {
            setVisible(false);
            final Function<JTextField, Integer> getText = x -> Integer.parseInt(x.getText());
            new Game(
                    getText.apply(columnInputField), getText.apply(rowInputField), getText.apply(minesInputField)
            );
        });

        introPanel.add(startGame, BorderLayout.CENTER);
        pack();
        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
