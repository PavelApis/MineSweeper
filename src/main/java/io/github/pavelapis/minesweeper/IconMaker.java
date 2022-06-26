package io.github.pavelapis.minesweeper;

import lombok.Getter;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconMaker {

    @Getter
    private static Path pathToSprites = FileSystems.getDefault().getPath("src", "main", "java", "sprites");

    public static void setIcon(final JButton button, final String name) {
        button.setIcon(new ImageIcon(pathToSprites.resolve(name + ".jpg").toString()));
    }
}
