import javax.swing.*;

public class Game extends JFrame{

    Minesweeper minesweeper;
    public Game(int size_x, int size_y) {
        initUI(size_x, size_y);
    }

    private void initUI(int size_x, int size_y) {
        minesweeper = new Minesweeper(size_x, size_y);
        add(minesweeper);
        setResizable(false);
        pack();
        setTitle("Minesweeper");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void start(){
        this.setVisible(true);
    }
}
