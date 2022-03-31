import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {

    Minesweeper minesweeper;

    public Game() {
        initUI();
    }

    private void initUI() {
        setResizable(false);
        JPanel introPanel = new JPanel();
        add(introPanel);
        introPanel.setPreferredSize(new Dimension(300, 100));
        introPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        introPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        JLabel rowInputLabel = new JLabel("Enter number of rows: ");
        JLabel columnInputLabel = new JLabel("Enter number of columns: ");

        JTextField rowInputField = new JTextField(5);
        JTextField columnInputField = new JTextField(5);

        JButton start_game = new JButton("Start Game");
        start_game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                minesweeper = new Minesweeper(Integer.parseInt(rowInputField.getText()), Integer.parseInt(columnInputField.getText()));
                add(minesweeper);
            }
        });

        introPanel.add(rowInputLabel);
        introPanel.add(rowInputField);
        introPanel.add(columnInputLabel);
        introPanel.add(columnInputField);
        introPanel.add(start_game, BorderLayout.CENTER);
        pack();
        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void open() {
        setVisible(true);
    }
}
