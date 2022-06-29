package io.guthub.pavelapis.minesweeper;

import io.github.pavelapis.minesweeper.Minesweeper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MinesweeperTest{
    @Test
    /*
        Number of mines in field must be equals to number of mines in constructor.
     */
    void mineCells(){
        final int rows = 5;
        final int columns = 5;
        final int mines = 10;
        Minesweeper minesweeper = new Minesweeper(columns, rows, mines);
        assertThat(minesweeper.getSizeY()).isEqualTo(rows);
        assertThat(minesweeper.getSizeX()).isEqualTo(columns);

        int mineCounter = 0;
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if(minesweeper.getCell(i, j).isMined()){
                    mineCounter++;
                }
            }
        }
        assertThat(minesweeper.getNumberOfMines()).isEqualTo(mineCounter);
    }
}
