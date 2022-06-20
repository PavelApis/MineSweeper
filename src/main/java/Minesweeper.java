import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Minesweeper extends JPanel {

    int size_x;
    int size_y;
    Cell[][] field;

    private void initCells() {
        field = new Cell[size_y][size_x];
        for (int i = 0; i < size_y; i++) {
            for (int j = 0; j < size_x; j++) {
                field[i][j] = new Cell(this, i, j);
                add(field[i][j]);
            }
        }
    }

    public Minesweeper(int size_x, int size_y, int mines) {
        this.size_x = size_x;
        this.size_y = size_y;
        setPreferredSize(new Dimension(Cell.CELL_SIZE * size_x, Cell.CELL_SIZE * size_y));
        setLayout(new GridLayout(size_y, size_x));
        initCells();
        mineCells(mines);
        printField();
        setCellsValues();
        printField();
        setBackground(Color.LIGHT_GRAY);
    }

    private void mineCells(int mines) {
        List<Cell> listOfCells = new LinkedList<>();
        Arrays.stream(field).flatMap(Arrays::stream).forEach(listOfCells::add);
        Collections.shuffle(listOfCells);
        listOfCells.stream().limit(mines).forEach(Cell::mine);
    }

    public void setCellsValues() {
        Arrays.stream(field).flatMap(Arrays::stream).filter(Cell::isNotMined).
                forEach(cell -> cell.setValue(cell.numberOfMinedNeighbours()));
    }

    private void printField() {
        for (int i = 0; i < size_y; i++){
            for (int j = 0; j < size_x; j++){
                System.out.print(field[i][j].getValue());
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }
}
