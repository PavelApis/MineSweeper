package io.github.pavelapis.minesweeper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

public class Minesweeper extends JPanel {

    int sizeX;
    int sizeY;
    Cell[][] field;

    private void initCells() {
        field = new Cell[sizeY][sizeX];
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                field[i][j] = new Cell(this, i, j);
                add(field[i][j]);
            }
        }
    }

    public Minesweeper(int sizeX, int sizeY, int mines) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        setPreferredSize(new Dimension(Cell.CELL_SIZE * sizeX, Cell.CELL_SIZE * sizeY));
        setLayout(new GridLayout(sizeY, sizeX));
        initCells();
        mineCells(mines);
        setCellsValues();
        setBackground(Color.LIGHT_GRAY);
    }

    private void mineCells(int mines) {
        List<Cell> listOfCells = new LinkedList<>();
        Arrays.stream(field).flatMap(Arrays::stream).forEach(listOfCells::add);
        Collections.shuffle(listOfCells);
        listOfCells.stream().limit(mines).forEach(Cell::mine);
    }

    private void setCellsValues() {
        Arrays.stream(field).flatMap(Arrays::stream).filter(Cell::isNotMined)
                .forEach(cell -> cell.setValue(cell.numberOfMinedNeighbours()));
    }

    /* TODO
    private void logField() {
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                System.out.print(field[i][j].getValue());
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }
    */
}
