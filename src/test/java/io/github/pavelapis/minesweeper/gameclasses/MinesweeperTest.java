package io.github.pavelapis.minesweeper.gameclasses;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class MinesweeperTest {

    @Test
        /* default */ void testIllegalConstructorArguments() {
        assertThatThrownBy(() -> new Minesweeper(-1, 2, 2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Minesweeper(2, -1, -1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Minesweeper(2, 3, -10)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Minesweeper(5, 5, 1000)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    /* default */ void testClickAndSpread(){
        Minesweeper minesweeper = new Minesweeper(4, 4, 0);
        minesweeper.getCell(0, 0).doClick();
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                assertThat(minesweeper.getCell(i, j).isOpened()).isTrue();
            }
        }
    }

    @Test
    /* default */ void testWin(){
        Minesweeper minesweeper = new Minesweeper(3, 3, 0);
        minesweeper.getCell(1, 1).doClick();
        assertThat(minesweeper.isEnabled()).isFalse();
        assertThat(minesweeper.isGameWon()).isTrue();
    }

    @Test
    /* default */ void testLose(){
        Minesweeper minesweeper = new Minesweeper(1, 1, 1);
        minesweeper.getCell(0, 0).doClick();
        assertThat(minesweeper.isEnabled()).isFalse();
        assertThat(minesweeper.isGameWon()).isFalse();
    }
}
