import javax.swing.*;
import java.awt.*;

/**
 * row, column - coords of cell in field.
 * value: [0-9] - number of mined neighbors; -1 - mine.
 */
class Cell extends JButton {
    static final int CELL_SIZE = 50;

    private final int ROW;
    private final int COL;
    private int value;

    public Cell(int row, int column) {
        this.ROW = row;
        this.COL = column;
        this.value = 0;
        setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
    }

    public int getROW() {
        return ROW;
    }

    public int getCOL() {
        return COL;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void mine() {
        value = -1;
    }

    boolean isNotMined() {
        return this.value != -1;
    }

    boolean isMined() {
        return this.value == -1;
    }
}