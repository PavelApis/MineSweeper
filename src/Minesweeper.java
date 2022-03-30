import javax.swing.*;
import java.awt.*;

public class Minesweeper extends JPanel {

    int size_y;
    int size_x;

    final int B_WIDTH;
    final int B_HEIGHT;
    Cell[][] cells;

    private void initCells(){
        cells = new Cell[size_x][size_y];
        for(int i = 0; i < size_x; i++){
            for(int j = 0; j < size_y; j++){
                cells[i][j] = new Cell(i, j);
                add(cells[i][j]);
            }
        }
    }
    public Minesweeper(int size_x, int size_y) {
        this.size_x = size_x;
        this.size_y = size_y;
        B_WIDTH = 35 * size_x + 15;
        B_HEIGHT = 35 * size_y + 40;
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        initCells();
        setBackground(Color.LIGHT_GRAY);
    }

    public int numberOfMinedNeighbours(int row, int column) {
        int result = 0;
        for (int i = (row == 0 ? 0 : row - 1); i < (row < size_x - 1 ? row + 1 : size_x - 1); i++) {
            for (int j = (column == 0 ? 0 : column - 1); j < (column < size_y - 1 ? column + 1 : size_y - 1); j++) {
                if (i == row && j == column) {
                    j++;
                }
                Cell currCell = cells[i][j];
                if (currCell.isMined()) {
                    result++;
                }
            }
        }
        return result;
    }

    public void openCell(int row, int column) {

    }


}
