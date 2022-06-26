package io.github.pavelapis.minesweeper;

import lombok.Getter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;

public class Minesweeper extends JPanel {

    @Getter
    private final int sizeX;
    @Getter
    private final int sizeY;
    private Cell[][] field;

    public Cell getCell(final int row, final int column) {
        return field[row][column];
    }

    public boolean checkIsMined(final int row, final int column) {
        return field[row][column].isMined();
    }

    public void clickCell(final int row, final int column) {
        field[row][column].clickCell();
    }

    private void initCells() {
        field = new Cell[sizeY][sizeX];
        for (int i = 0; i < sizeY; i++) {
            for (int j = 0; j < sizeX; j++) {
                field[i][j] = new Cell(this, i, j);
                add(field[i][j]);
            }
        }
    }

    public Minesweeper(final int sizeX, final int sizeY, final int mines) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        setPreferredSize(new Dimension(Cell.getCELL_SIZE() * sizeX, Cell.getCELL_SIZE() * sizeY));
        setLayout(new GridLayout(sizeY, sizeX));
        initCells();
        mineCells(mines);
        setCellsValues();
        setBackground(Color.LIGHT_GRAY);
    }

    private void mineCells(final int mines) {
        final List<Cell> listOfCells = new LinkedList<>();
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
