package io.github.pavelapis.minesweeper;

import io.github.pavelapis.minesweeper.gameclasses.Cell;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class CellTest {

    protected CellTest() {

    }

    @Test
        /* default */ void testIllegalConstructorArguments() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Cell(-1, 2));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Cell(2, -1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Cell(2, 3, -10));
    }

    @Test
        /* default */ void cellsCreation() {
        final Cell cell = new Cell(1, 2);
        assertThat(cell.getValue()).isEqualTo(0);
        assertThat(cell.getRow()).isEqualTo(1);
        assertThat(cell.getColumn()).isEqualTo(2);
        assertThat(cell.isNotMined());

        final Cell minedCell = new Cell(0, 5, -1);
        assertThat(minedCell.getRow()).isEqualTo(0);
        assertThat(minedCell.getColumn()).isEqualTo(5);
        assertThat(cell.isMined());

        final Cell notMinedCell = new Cell(5, 0, 2);
        assertThat(notMinedCell.getRow()).isEqualTo(5);
        assertThat(notMinedCell.getColumn()).isEqualTo(0);
        assertThat(cell.isNotMined());
    }
}
