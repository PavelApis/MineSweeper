package io.github.pavelapis.minesweeper.gameclasses;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class FieldTest {

    /*
        Field constructor with illegal arguments must throw IllegalArgumentException.
     */
    @Test
    void testIllegalConstructorArguments() {
        assertThatThrownBy(() -> new Field(-1, 2, 2)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number of rows must be more than 0.");
        assertThatThrownBy(() -> new Field(2, -1, -1)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number of columns must be more than 0.");
        assertThatThrownBy(() -> new Field(2, 3, -10)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number of mines cannot be negative.");
        assertThatThrownBy(() -> new Field(5, 5, 1000)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Number of mines cannot be more than number of cells.");
    }


    /*
        Number of mines in field must be equals to number of mines in constructor.
     */
    @Test
    void mineCells() {
        final int rows = 5;
        final int columns = 5;
        final int mines = 10;
        final Field field = new Field(columns, rows, mines);
        assertThat(field.getRows()).isEqualTo(rows);
        assertThat(field.getColumns()).isEqualTo(columns);

        int mineCounter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (field.getCell(i, j).isMined()) {
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
    void settingCellsValue() {
        final Cell[][] cells = {
                {new Cell(0, 0, -1), new Cell(0, 1, 0), new Cell(0, 2, -1)},
                {new Cell(1, 0, 0), new Cell(1, 1, 0), new Cell(1, 2, 0)},
                {new Cell(2, 0, -1), new Cell(2, 1, 0), new Cell(2, 2, 0)}
        };
        final Field field = new Field(cells, 3);
        field.setCellsValues();
        final int[][] expectedResult = {
                {-1, 2, -1},
                {2, 3, 1},
                {-1, 1, 0}
        };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertThat(field.getCell(i, j).getValue()).isEqualTo(expectedResult[i][j]);
            }
        }
        assertThat(field.numberOfMinedNeighbours(field.getCell(1, 1))).isEqualTo(3);
    }
}
