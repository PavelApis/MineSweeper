import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.util.*;
import java.util.List;

public class Minesweeper extends JPanel {

    int size_y;
    int size_x;

    final int B_WIDTH;
    final int B_HEIGHT;

    boolean isMined;
    Cell[][] cells;

    private void initCells() {
        cells = new Cell[size_x][size_y];
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {
                cells[i][j] = new Cell(i, j);
                add(cells[i][j]);
            }
        }
    }

    public Minesweeper(int size_x, int size_y, int mines) {
        this.size_x = size_x;
        this.size_y = size_y;
        initCells();
        mineCells(mines);
        setCellsValues();

        B_WIDTH = (Cell.CELL_SIZE + 5) * size_x + 15;
        B_HEIGHT = (Cell.CELL_SIZE + 5) * size_y + 40;
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setBackground(Color.LIGHT_GRAY);
    }

    private void mineCells(int mines) {
        List<Cell> listOfCells = new LinkedList<>();
        Arrays.stream(cells).flatMap(Arrays::stream).forEach(listOfCells::add);
        Collections.shuffle(listOfCells);
        listOfCells.stream().limit(mines).forEach(Cell::mine);
    }

    public void setCellsValues() {
        Arrays.stream(cells).flatMap(Arrays::stream).filter(Cell::isNotMined).
                forEach(cell -> cell.setValue(numberOfMinedNeighbours(cell)));
        Arrays.stream(cells).flatMap(Arrays::stream).forEach(cell -> {
            if (cell.getValue() != -1 && cell.getValue() != 0) cell.setText(Integer.toString(cell.getValue()));
            switch (cell.getValue()){
                case -1 ->{
                    try{
                        Image mine_img = ImageIO.read(getClass().getResource("sprites/mine.jpg"));
                        cell.setIcon(new ImageIcon(mine_img.getScaledInstance(Cell.CELL_SIZE, Cell.CELL_SIZE, Image.SCALE_SMOOTH)));
                    } catch (Exception ex){
                        System.out.println(ex);
                    }
                }
                case 0 -> cell.setBackground(Color.LIGHT_GRAY);
                case 1 -> cell.setForeground(Color.BLUE);
                case 2 -> cell.setForeground(Color.GREEN);
                case 3 -> cell.setForeground(Color.RED);
                case 4 -> cell.setForeground(Color.MAGENTA);
                case 5 -> cell.setForeground(Color.YELLOW);
                case 6 -> cell.setForeground(Color.ORANGE);
                case 7 -> cell.setForeground(Color.PINK);
                case 8 -> cell.setForeground(Color.DARK_GRAY);
            }
        });
    }

    private int numberOfMinedNeighbours(Cell cell) {
        int result = 0;
        int row = cell.getROW();
        int column = cell.getCOL();
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i >= 0 && i < size_x && j >= 0 && j < size_y && cells[i][j].isMined()) {
                    result++;
                }
            }
        }
        return result;
    }

    private void openCell(int row, int column) {

    }


}
