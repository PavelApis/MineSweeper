package io.github.pavelapis.minesweeper;

import lombok.Getter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;

public class Minesweeper extends JFrame {

    @Serial
    private static final long serialVersionUID = 2L;
    @Getter
    private boolean gameInProgress;
    @Getter
    private final int sizeX;
    @Getter
    private final int sizeY;
    private transient Cell[][] field;
    @Getter
    private final int numberOfMines;
    @Getter
    private int leftCellsToOpen;

    public Minesweeper(final int sizeX, final int sizeY, final int mines) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.numberOfMines = mines;
        this.leftCellsToOpen = sizeX * sizeY - mines;
        this.gameInProgress = true;

        setPreferredSize(new Dimension(Cell.getCELL_SIZE() * sizeX, Cell.getCELL_SIZE() * sizeY));
        setResizable(false);
        setLayout(new GridLayout(sizeY, sizeX));
        initCells();
        mineCells(numberOfMines);
        setCellsValues();
        pack();
        setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setVisible(true);
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

    private void mineCells(final int mines) {
        final List<Cell> listOfCells = new LinkedList<>();
        Arrays.stream(field).flatMap(Arrays::stream).forEach(listOfCells::add);
        Collections.shuffle(listOfCells);
        listOfCells.stream().limit(mines).forEach(Cell::mine);
    }

    private void setCellsValues() {
        Arrays.stream(field).flatMap(Arrays::stream).filter(Cell::isNotMined)
                .forEach(cell -> cell.setValue(numberOfMinedNeighbours(cell)));
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

    private void gameLost() {
        setEnabled(false);
        new LoseFrame(this);
    }

    private void checkWin() {
        if (gameInProgress && leftCellsToOpen == 0) {
            gameInProgress = false;
            setEnabled(false);
            new WinFrame(this);
        }
    }

    public boolean checkBounds(final int row, final int column) {
        return row >= 0 && row < getSizeY() && column >= 0 && column < getSizeX();
    }

    public int numberOfMinedNeighbours(final Cell cell) {
        int result = 0;
        final int coordinateY = cell.getCoordinateY();
        final int coordinateX = cell.getCoordinateX();
        for (int i = coordinateY - 1; i <= coordinateY + 1; i++) {
            for (int j = coordinateX - 1; j <= coordinateX + 1; j++) {
                if (checkBounds(i, j) && field[i][j].isMined()) {
                    result++;
                }
            }
        }
        return result;
    }

    protected void clickCell(final Cell cell) {
        if (cell.isOpened()) {
            return;
        }
        cell.setOpened(true);
        if (cell.getValue() == -1) {
            gameLost();
            IconMaker.setIcon(cell, "mine");
        } else if (cell.getValue() == 0) {
            leftCellsToOpen--;
            cell.setBackground(Color.lightGray);
            spreadClick(cell);
        } else if (cell.getValue() >= 1 || cell.getValue() < 10) {
            leftCellsToOpen--;
            IconMaker.setIcon(cell, Integer.toString(cell.getValue()));
        } else {
            throw new IllegalStateException("Value of cell must be from -1 to 9");
        }
        checkWin();
    }

    private void spreadClick(final Cell cell) {
        final int coordinateY = cell.getCoordinateY();
        final int coordinateX = cell.getCoordinateX();
        for (int i = coordinateY - 1; i <= coordinateY + 1; i++) {
            for (int j = coordinateX - 1; j <= coordinateX + 1; j++) {
                if (!(i == coordinateX && j == coordinateY) && checkBounds(i, j)) {
                    clickCell(field[i][j]);
                }
            }
        }
    }
}
