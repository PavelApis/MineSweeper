package io.github.pavelapis.minesweeper.gameclasses;

import io.github.pavelapis.minesweeper.frames.LoseFrame;
import io.github.pavelapis.minesweeper.frames.WinFrame;
import lombok.Getter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.Serial;
import javax.swing.*;

public class Minesweeper extends JFrame {

    @Serial
    private static final long serialVersionUID = 2L;
    @Getter
    private boolean gameInProgress;
    @Getter
    private boolean gameWon;
    @Getter
    private final int columns;
    @Getter
    private final int rows;
    private transient Field field;
    @Getter
    private final int numberOfMines;
    @Getter
    private int leftCellsToOpen;

    public Minesweeper(final int columns, final int rows, final int numberOfMines) {
        this.columns = columns;
        this.rows = rows;
        this.numberOfMines = numberOfMines;
        this.leftCellsToOpen = columns * rows - numberOfMines;
        this.gameInProgress = true;
        this.gameWon = false;
        setLayout(new GridLayout(rows, columns));
        addField(new Field(rows, columns, numberOfMines));

        setPreferredSize(new Dimension(Cell.getCELL_SIZE() * columns, Cell.getCELL_SIZE() * rows));
        setResizable(false);
        pack();
        setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Minesweeper");
        setVisible(true);
    }

    private void addField(final Field field) {
        this.field = field;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                final Cell cell = field.getCell(i, j);
                add(cell);
                cell.addActionListener(actionEvent -> this.clickCell(cell));
            }
        }
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
        gameInProgress = false;
        setEnabled(false);
        new LoseFrame(this);
    }

    private void checkWin() {
        if (gameInProgress && leftCellsToOpen == 0) {
            gameInProgress = false;
            gameWon = true;
            setEnabled(false);
            new WinFrame(this);
        }
    }

    public Cell getCell(final int row, final int column) {
        return field.getCell(row, column);
    }

    protected void clickCell(final Cell cell) {
        if (cell.isOpened()) {
            return;
        }
        cell.setOpened(true);
        if (cell.getValue() == -1) {
            gameLost();
            cell.setIcon(IconMaker.makeIcon("mine"));
        } else if (cell.getValue() == 0) {
            leftCellsToOpen--;
            cell.setBackground(Color.lightGray);
            spreadClick(cell);
        } else if (cell.getValue() >= 1 || cell.getValue() < 10) {
            leftCellsToOpen--;
            cell.setIcon(IconMaker.makeIcon(Integer.toString(cell.getValue())));
        } else {
            throw new IllegalStateException("Value of cell must be from -1 to 9");
        }
        checkWin();
    }

    private void spreadClick(final Cell cell) {
        final int coordinateY = cell.getRow();
        final int coordinateX = cell.getColumn();
        for (int i = coordinateY - 1; i <= coordinateY + 1; i++) {
            for (int j = coordinateX - 1; j <= coordinateX + 1; j++) {
                if (!(i == coordinateX && j == coordinateY) && field.checkBounds(i, j)) {
                    clickCell(field.getCell(i, j));
                }
            }
        }
    }
}
