import javax.swing.*;
import java.awt.*;
import java.util.List;

class Cell extends JButton {
    int row;
    int column;
    boolean mined;

    List<Cell> neighbors;

    public Cell(int row, int column){
        this.row = row;
        this.column = column;
        this.mined = false;
        setPreferredSize(new Dimension(30, 30));
    }

    public Cell(int row, int column, boolean mine) {
        this.row = row;
        this.column = column;
        this.mined = mine;
    }

    boolean isMined() {
        return mined;
    }
}