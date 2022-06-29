package io.github.pavelapis.minesweeper.gameclasses;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class Field {

    private transient Cell[][] cells;
    @Getter
    private final int rows;
    @Getter
    private final int columns;
    @Getter
    private final int numberOfmines;

    public Field(final Cell[][] cells, final int numberOfMines) {
        this.rows = cells.length;
        this.columns = cells[0].length;
        this.numberOfmines = numberOfMines;

        this.cells = new Cell[rows][columns];
        for (int i = 0; i < rows; i++) {
            if (cells[i].length != columns) {
                throw new IllegalArgumentException("Cells array must be rectangular.");
            }
            this.cells[i] = Arrays.copyOf(cells[i], columns);
        }
    }

    public Field(final int rows, final int columns, final int numberOfMines) {
        this.rows = rows;
        this.columns = columns;
        this.numberOfmines = numberOfMines;
        initCells();
        mineCells(numberOfMines);
        setCellsValues();
    }

    public Cell getCell(final int row, final int column) {
        return cells[row][column];
    }

    private void initCells() {
        if (cells == null) {
            cells = new Cell[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    cells[i][j] = new Cell(i, j);
                }
            }
        }
    }

    public void mineCells(final int mines) {
        final List<Cell> listOfCells = new LinkedList<>();
        Arrays.stream(cells).flatMap(Arrays::stream).forEach(listOfCells::add);
        Collections.shuffle(listOfCells);
        listOfCells.stream().limit(mines).forEach(Cell::mine);
    }

    public void setCellsValues() {
        Arrays.stream(cells).flatMap(Arrays::stream).filter(Cell::isNotMined)
                .forEach(cell -> cell.setValue(numberOfMinedNeighbours(cell)));
    }

    public boolean checkBounds(final int row, final int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public int numberOfMinedNeighbours(final Cell cell) {
        int result = 0;
        final int coordinateY = cell.getRow();
        final int coordinateX = cell.getColumn();
        for (int i = coordinateY - 1; i <= coordinateY + 1; i++) {
            for (int j = coordinateX - 1; j <= coordinateX + 1; j++) {
                if (checkBounds(i, j) && cells[i][j].isMined()) {
                    result++;
                }
            }
        }
        return result;
    }
}
