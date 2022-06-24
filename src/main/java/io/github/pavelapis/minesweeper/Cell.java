package io.github.pavelapis.minesweeper;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;


/**
 * row, column - coords of cell in field.
 * value: [0-9] - number of mined neighbors; -1 - mine.
 */
class Cell extends JButton {
    public static final long serialVersionUID = 1;
    private final Minesweeper minesweeper;
    private boolean isOpened;
    //The pixel size of button
    private static final int CELL_SIZE = 45;
    private final int coordinateX;
    private final int coordinateY;
    private int value;


    public Cell(final Minesweeper minesweeper, final int coordinateY, final int coordinateX) {
        this.minesweeper = minesweeper;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.value = 0;
        setSize(new Dimension(CELL_SIZE, CELL_SIZE));
        setBackground(Color.decode("#E4E4E4"));
        this.addActionListener(actionEvent -> clickCell());
    }

    public static int getCellSize() {
        return CELL_SIZE;
    }

    public int getCellY() {
        return coordinateY;
    }

    public int getCellX() {
        return coordinateX;
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
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


    public boolean checkBounds(final int row, final int column) {
        return row >= 0 && row < minesweeper.getSizeY() && column >= 0 && column < minesweeper.getSizeX();
    }

    public int numberOfMinedNeighbours() {
        int result = 0;
        for (int i = coordinateY - 1; i <= coordinateY + 1; i++) {
            for (int j = coordinateX - 1; j <= coordinateX + 1; j++) {
                if (checkBounds(i, j) && minesweeper.checkIsMined(i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    /* TODO
    private void setFlag() {

    }
    */

    protected void clickCell() {
        if (isOpened) {
            return;
        }
        isOpened = true;
        final IconMaker iconFactory = new IconMaker(this);
        if (this.getValue() == -1) {
            iconFactory.setIcon("mine");
        } else if (this.getValue() == 0) {
            setBackground(Color.lightGray);
            spreadClick();
        } else if (this.getValue() >= 1 || this.getValue() < 10) {
            iconFactory.setIcon(Integer.toString(this.getValue()));
        } else {
            throw new IllegalStateException("Value of cell must be from -1 to 9");
        }
    }

    private void spreadClick() {
        final int coordinateY = getCellY();
        final int coordinateX = getCellX();
        for (int i = coordinateY - 1; i <= coordinateY + 1; i++) {
            for (int j = coordinateX - 1; j <= coordinateX + 1; j++) {
                if (!(i == coordinateX && j == coordinateY) && checkBounds(i, j)) {
                    minesweeper.clickCell(i, j);
                }
            }
        }
    }
}

