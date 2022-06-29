package io.github.pavelapis.minesweeper.gameclasses;

import lombok.Getter;
import lombok.Setter;

import java.awt.Color;
import java.awt.Dimension;
import java.io.Serial;
import javax.swing.JButton;


/**
 * row, column - coords of cell in field.
 * value: [0-9] - number of mined neighbors; -1 - mine.
 */

public class Cell extends JButton {

    @Serial
    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private boolean opened;
    @Getter
    private static final int CELL_SIZE = 45;
    @Getter
    private final int row;
    @Getter
    private final int column;
    @Getter
    @Setter
    private int value;

    public Cell(final int row, final int column, final int value) {
        checkPosition(row, column);
        checkValue(value);
        this.row = row;
        this.column = column;
        this.value = value;
        setSize(new Dimension(CELL_SIZE, CELL_SIZE));
        setBackground(Color.decode("#E4E4E4"));
    }

    public Cell(final int row, final int column) {
        checkPosition(row, column);
        this.row = row;
        this.column = column;
        this.value = 0;
        setSize(new Dimension(CELL_SIZE, CELL_SIZE));
        setBackground(Color.decode("#E4E4E4"));
    }

    public void mine() {
        value = -1;
    }

    public boolean isNotMined() {
        return this.value != -1;
    }

    public boolean isMined() {
        return this.value == -1;
    }

    public void checkPosition(final int row, final int column) {
        if (row < 0) {
            throw new IllegalArgumentException("Row must be positive.");
        }
        if (column < 0) {
            throw new IllegalArgumentException("Column must be positive");
        }
    }

    public void checkValue(final int value) {
        if (value < -1 || value > 8) {
            throw new IllegalArgumentException("Value must equals number of mined Neighbours in interval [0, 8] or " +
                    "be -1 which matches to mined cell");
        }
    }

    /* TODO
    private void setFlag() {

    }
    */
}

