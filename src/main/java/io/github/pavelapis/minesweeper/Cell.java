package io.github.pavelapis.minesweeper;

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

class Cell extends JButton {

    @Serial
    private static final long serialVersionUID = 1L;
    @Getter
    @Setter
    private boolean opened;
    @Getter
    private static final int CELL_SIZE = 45;
    @Getter
    private final int coordinateX;
    @Getter
    private final int coordinateY;
    @Getter
    @Setter
    private int value;


    public Cell(Minesweeper minesweeper, final int coordinateY, final int coordinateX) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.value = 0;
        setSize(new Dimension(CELL_SIZE, CELL_SIZE));
        setBackground(Color.decode("#E4E4E4"));
        this.addActionListener(actionEvent -> minesweeper.clickCell(this));
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

    /* TODO
    private void setFlag() {

    }
    */
}

