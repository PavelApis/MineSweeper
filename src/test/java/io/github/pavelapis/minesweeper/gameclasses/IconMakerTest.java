package io.github.pavelapis.minesweeper.gameclasses;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


class IconMakerTest {

    /*
        Files in resources directory "src/main/java/sprites" should exist.
     */
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "mine"})
    /* default */ void testMakeIcon(final String name) {
        assertThat(IconMaker.makeIcon(name)).isNotNull();
    }
}
