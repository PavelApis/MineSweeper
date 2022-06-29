package io.github.pavelapis.minesweeper;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class IconMakerTest {

    protected IconMakerTest() {

    }

    /*
        Files in resources directory "src/main/java/sprites" should exist.
     */
    @Test
    /* default */ void pathsToSprites() {
        for (int i = 1; i < 9; i++) {
            assertThat(Thread.currentThread().getContextClassLoader().getResourceAsStream(i + ".jpg")).isNotNull();
        }
        assertThat(Thread.currentThread().getContextClassLoader().getResourceAsStream("mine.jpg")).isNotNull();
    }


}
