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
        JPanel introPanel = new JPanel();
        add(introPanel);
        introPanel.setPreferredSize(new Dimension(300, 110));
        introPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        introPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        JLabel rowInputLabel = new JLabel("Enter number of rows: ");
        introPanel.add(rowInputLabel);

        JLabel columnInputLabel = new JLabel("Enter number of columns: ");
        introPanel.add(columnInputLabel);

        JLabel minesInputLabel = new JLabel("Enter number of mines: ");
        introPanel.add(minesInputLabel);

        JTextField rowInputField = new JTextField(5);
        introPanel.add(rowInputField);

        JTextField columnInputField = new JTextField(5);
        introPanel.add(columnInputField);

        JTextField minesInputField = new JTextField(5);
        introPanel.add(minesInputField);


        JButton startGame = new JButton("Start Game");
        startGame.addActionListener(actionEvent -> {
            setVisible(false);
            Function<JTextField, Integer> getText = x -> Integer.parseInt(x.getText());
            Game game = new Game(
                    getText.apply(rowInputField), getText.apply(columnInputField), getText.apply(minesInputField)
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
