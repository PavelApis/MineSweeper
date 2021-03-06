package io.github.pavelapis.minesweeper.frames;

import io.github.pavelapis.minesweeper.gameclasses.Minesweeper;

import java.awt.*;
import java.io.Serial;
import java.util.function.ToIntFunction;
import javax.swing.*;

public class WelcomeFrame extends JFrame {

    @Serial
    private static final long serialVersionUID = 3L;

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
            dispose();
            final ToIntFunction<JTextField> getText = x -> Integer.parseInt(x.getText());
            new Minesweeper(
                    getText.applyAsInt(columnInputField),
                    getText.applyAsInt(rowInputField),
                    getText.applyAsInt(minesInputField)
            );
        });

        introPanel.add(startGame, BorderLayout.CENTER);
        super.pack();
        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
