package io.github.pavelapis.minesweeper.gameclasses;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class IconMakerTest {

    /*
        Files in resources directory "src/main/java/sprites" should exist.
     */
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "mine"})
    void testMakeIcon(final String name) {
        assertThat(IconMaker.makeIcon(name)).isNotNull();
    }

    @Test
    void testNonExistentFile() {
        final String nonExistentName = "notExist";
        assertThatThrownBy(() -> IconMaker.makeIcon(nonExistentName)).isInstanceOf(IllegalStateException.class)
                .hasMessage("No such file named " + nonExistentName + ".jpg in the resources directory.");
    }
}
