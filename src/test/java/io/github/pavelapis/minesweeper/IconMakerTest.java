package io.github.pavelapis.minesweeper;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class IconMakerTest {
    private static Path pathToSprites = FileSystems.getDefault().getPath("src", "main", "java", "sprites");
    /*
        Files in resources directory "src/main/java/sprites" should exist.
     */
    @Test
    void pathsToSprites(){
        for(int i = 1; i < 10; i++){
            assertThat(pathToSprites.resolve(i + ".jpg").toFile().exists()).isTrue();
        }
        assertThat(pathToSprites.resolve("mine.jpg").toFile().exists()).isTrue();
    }
}
