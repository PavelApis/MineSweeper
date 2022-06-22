package io.github.pavelapis.minesweeper;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        JLabel columnInputLabel = new JLabel("Enter number of columns: ");
        JLabel minesInputLabel = new JLabel("Enter number of mines: ");

        JTextField rowInputField = new JTextField(5);
        JTextField columnInputField = new JTextField(5);
        JTextField minesInputField = new JTextField(5);


        JButton startGame = new JButton("Start Game");
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Function<JTextField, Integer> getText = x -> Integer.parseInt(x.getText());
                Game game = new Game(
                        getText.apply(rowInputField), getText.apply(columnInputField), getText.apply(minesInputField)
                );
            }
        });

        introPanel.add(rowInputLabel);
        introPanel.add(rowInputField);
        introPanel.add(columnInputLabel);
        introPanel.add(columnInputField);
        introPanel.add(minesInputLabel);
        introPanel.add(minesInputField);
        introPanel.add(startGame, BorderLayout.CENTER);
        pack();
        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
