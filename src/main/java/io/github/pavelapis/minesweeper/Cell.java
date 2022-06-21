package io.github.pavelapis.minesweeper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;


/**
 * row, column - coords of cell in field.
 * value: [0-9] - number of mined neighbors; -1 - mine.
 */
class Cell extends JButton {
    private final Minesweeper minesweeper;
    private boolean isOpened;
    static final int CELL_SIZE = 45;
    private final int coordinateX;
    private final int coordinateY;
    private int value;


    public Cell(Minesweeper minesweeper, int y, int x) {
        this.minesweeper = minesweeper;
        this.coordinateX = x;
        this.coordinateY = y;
        this.value = 0;
        setSize(new Dimension(CELL_SIZE, CELL_SIZE));
        setBackground(Color.decode("#E4E4E4"));
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCell();
            }
        });
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


    boolean checkBounds(int i, int j) {
        return (i >= 0 && i < minesweeper.sizeY) && (j >= 0 && j < minesweeper.sizeX);
    }

    int numberOfMinedNeighbours() {
        int result = 0;
        for (int i = coordinateY - 1; i <= coordinateY + 1; i++) {
            for (int j = coordinateX - 1; j <= coordinateX + 1; j++) {
                if (checkBounds(i, j) && minesweeper.field[i][j].isMined()) {
                    result++;
                }
            }
        }
        System.out.println(result);
        return result;
    }

    private void setFlag() {

    }

    private void clickCell() {
        if (isOpened) {
            return;
        }
        isOpened = true;
        IconMaker iconFactory = new IconMaker(this);
        switch (this.getValue()) {
            case -1 -> {
                iconFactory.setIcon("sprites/mine.jpg");
            }
            case 0 -> {
                setBackground(Color.lightGray);
                int y = getCellY();
                int x = getCellX();
                for (int i = y - 1; i <= y + 1; i++) {
                    for (int j = x - 1; j <= x + 1; j++) {
                        if (!(i == x && j == y) && checkBounds(i, j)) {
                            minesweeper.field[i][j].clickCell();
                        }
                    }
                }
            }

            case 1 -> iconFactory.setIcon("sprites/1.jpg");
            case 2 -> iconFactory.setIcon("sprites/2.jpg");
            case 3 -> iconFactory.setIcon("sprites/3.jpg");
            case 4 -> iconFactory.setIcon("sprites/4.jpg");
            case 5 -> iconFactory.setIcon("sprites/5.jpg");
            case 6 -> iconFactory.setIcon("sprites/6.jpg");
            case 7 -> iconFactory.setIcon("sprites/7.jpg");
            case 8 -> iconFactory.setIcon("sprites/8.jpg");
            default -> throw new IllegalStateException("Value of cell must be from -1 to 9");
        }
    }
}
