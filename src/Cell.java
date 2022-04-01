import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * row, column - coords of cell in field.
 * value: [0-9] - number of mined neighbors; -1 - mine.
 */
class Cell extends JButton {
    private final Minesweeper minesweeper;
    private boolean isOpened;
    final static int CELL_SIZE = 45;
    private final int X;
    private final int Y;
    private int value;


    public Cell(Minesweeper minesweeper, int Y, int X) {
        super();
        this.minesweeper = minesweeper;
        this.X = X;
        this.Y = Y;
        this.value = 0;
        setBackground(Color.LIGHT_GRAY);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCell();
            }
        });
    }

    public int getCellY() {
        return Y;
    }

    public int getCellX() {
        return X;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void mine() {
        value = -1;
    }

    boolean isNotMined() {
        return this.value != -1;
    }

    boolean isMined() {
        return this.value == -1;
    }


    boolean checkBounds(int i, int j) {
        return (i >= 0 && i < minesweeper.size_y) && (j >= 0 && j < minesweeper.size_x);
    }

    int numberOfMinedNeighbours() {
        int result = 0;
        for(int i = Y -1; i <= Y + 1; i++){
            for (int j = X - 1; j <= X+1; j++){
                if(checkBounds(i, j) && minesweeper.field[i][j].isMined()){
                    result++;
                }
            }
        }
        System.out.println(result);
        return result;
    }

    private void clickCell() {
        if (isOpened) {
            return;
        }
        if (this.getValue() != -1 && this.getValue() != 0) this.setText(Integer.toString(this.getValue()));
        isOpened = true;
        switch (this.getValue()) {
            case -1 -> {
                try {
                    Image mine_img = ImageIO.read(getClass().getResource("sprites/mine.jpg"));
                    setIcon(new ImageIcon(mine_img.getScaledInstance(CELL_SIZE, CELL_SIZE, java.awt.Image.SCALE_SMOOTH)));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
            case 0 -> {
                setBackground(Color.GRAY);
                setText(Integer.toString(getValue()));
                int y = getCellY();
                int x = getCellX();
                for (int i = y - 1; i <= y + 1; i++) {
                    for (int j = x - 1; j <= x + 1; j++) {
                        if (!(i == x && j == y) && checkBounds(i, j)) {
                            minesweeper.field[i][j].clickCell();
                        }
                    }
                }
            }

            case 1 -> this.setForeground(Color.BLUE);
            case 2 -> this.setForeground(Color.GREEN);
            case 3 -> this.setForeground(Color.RED);
            case 4 -> this.setForeground(Color.MAGENTA);
            case 5 -> this.setForeground(Color.YELLOW);
            case 6 -> this.setForeground(Color.ORANGE);
            case 7 -> this.setForeground(Color.PINK);
            case 8 -> this.setForeground(Color.DARK_GRAY);
        }
    }
}