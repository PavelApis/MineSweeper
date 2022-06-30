package io.github.pavelapis.minesweeper.gameclasses;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class IconMakerTest {

    /*
        Files in resources directory "src/main/java/sprites" should exist.
     */
    @Test
    /* default */ void testMakeIcon() {
        for (int i = 1; i < 9; i++) {
            assertThat(IconMaker.makeIcon(Integer.toString(i))).isNotNull();
        }
        assertThat(IconMaker.makeIcon("mine")).isNotNull();
    }
}
