import javax.swing.*;
import java.awt.*;

/**
 * row, column - coords of cell in field.
 * value: [0-9] - number of mined neighbors; -1 - mine.
 */
class Cell extends JButton {
    private final int row;
    private final int column;
    private int value;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.value = 0;
        setPreferredSize(new Dimension(30, 30));
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    boolean isMined() {
        return this.value == -1;
    }
}