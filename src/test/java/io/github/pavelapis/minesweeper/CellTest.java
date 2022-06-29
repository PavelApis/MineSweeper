package io.github.pavelapis.minesweeper;

import io.github.pavelapis.minesweeper.gameclasses.Cell;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CellTest {
    @Test
    public void cellsCreation(){
        Cell cell = new Cell(1, 2);
        assertThat(cell.getValue()).isEqualTo(0);
        assertThat(cell.getRow()).isEqualTo(1);
        assertThat(cell.getColumn()).isEqualTo(2);
        assertThat(cell.isNotMined());

        Cell minedCell = new Cell(0, 5, -1);
        assertThat(minedCell.getRow()).isEqualTo(0);
        assertThat(minedCell.getColumn()).isEqualTo(5);
        assertThat(cell.isMined());

        Cell notMinedCell = new Cell(5, 0, 2);
        assertThat(notMinedCell.getRow()).isEqualTo(5);
        assertThat(notMinedCell.getColumn()).isEqualTo(0);
        assertThat(cell.isNotMined());
    }
}
