package io.github.pavelapis.minesweeper;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class IconMakerTest {
    /*
        Files in resources directory "src/main/java/sprites" should exist.
     */
    @Test
    void pathsToSprites(){
        for(int i = 1; i < 9; i++){
            assertThat(Thread.currentThread().getContextClassLoader().getResourceAsStream(i + ".jpg")).isNotNull();
        }
        assertThat(Thread.currentThread().getContextClassLoader().getResourceAsStream("mine.jpg")).isNotNull();
    }
}
