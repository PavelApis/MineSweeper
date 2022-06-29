package io.github.pavelapis.minesweeper;

import io.github.pavelapis.minesweeper.gameclasses.Field;
import io.github.pavelapis.minesweeper.gameclasses.Cell;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FieldTest {
    @Test
    /*
        Number of mines in field must be equals to number of mines in constructor.
     */
    void mineCells(){
        final int rows = 5;
        final int columns = 5;
        final int mines = 10;
        Field field = new Field(columns, rows, mines);
        assertThat(field.getRows()).isEqualTo(rows);
        assertThat(field.getColumns()).isEqualTo(columns);

        int mineCounter = 0;
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                if(field.getCell(i, j).isMined()){
                    mineCounter++;
                }
            }
        }
        assertThat(field.getNumberOfMines()).isEqualTo(mineCounter);
    }
    /*
            field:                field:
            -1 0 -1               -1 2 -1
             0 0 0  -must become-> 2 3 1
            -1 0 0                -1 1 0
         */
    @Test
    void settingCellsValue(){
        Cell[][] cells = {
                { new Cell(0, 0, -1), new Cell(0, 1, 0), new Cell(0, 2, -1)},
                { new Cell(1, 0, 0), new Cell(1, 1, 0), new Cell(1, 2, 0)},
                {new Cell(2, 0, -1), new Cell(2, 1, 0), new Cell(2, 2, 0)}
        };
        Field field = new Field(cells, 3);
        field.setCellsValues();
        int[][] expectedResult = {
                {-1, 2, -1},
                {2, 3, 1},
                {-1, 1, 0}
        };
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                assertThat(field.getCell(i, j).getValue()).isEqualTo(expectedResult[i][j]);
            }
        }
    }
}
