import javax.swing.*;

public class Game extends JFrame {

    Minesweeper minesweeper;

    public Game(int row, int column, int mines) {
        setResizable(false);
        minesweeper = new Minesweeper(row, column, mines);
        add(minesweeper);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setVisible(true);
    }
}
