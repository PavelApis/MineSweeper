import javax.swing.*;

public class Game extends JFrame {

    Minesweeper minesweeper;

    public Game( int size_x,int size_y, int mines) {
        setResizable(false);
        minesweeper = new Minesweeper(size_x, size_y, mines);
        add(minesweeper);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setVisible(true);
    }
}
