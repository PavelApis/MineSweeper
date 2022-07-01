package io.github.pavelapis.minesweeper.gameclasses;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CellTest {

    /*
        Cell constructor with illegal arguments must throw IllegalArgumentException
     */
    @Test
    /* default */ void testIllegalConstructorArguments() {
        assertThatThrownBy(() -> new Cell(-1, 2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cell(2, -1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Cell(2, 3, -10)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
        /* default */ void cellsCreation() {
        final Cell cell = new Cell(1, 2);
        assertThat(cell.getValue()).isZero();
        assertThat(cell.getRow()).isEqualTo(1);
        assertThat(cell.getColumn()).isEqualTo(2);
        assertThat(cell.isNotMined()).isTrue();

        final Cell minedCell = new Cell(0, 5, Cell.MINE_VALUE);
        assertThat(minedCell.getRow()).isZero();
        assertThat(minedCell.getColumn()).isEqualTo(5);
        assertThat(minedCell.isMined()).isTrue();

        final Cell notMinedCell = new Cell(5, 0, 2);
        assertThat(notMinedCell.getRow()).isEqualTo(5);
        assertThat(notMinedCell.getColumn()).isZero();
        assertThat(notMinedCell.isNotMined()).isTrue();
    }
}
