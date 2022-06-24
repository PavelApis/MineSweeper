package io.github.pavelapis.minesweeper;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconMaker {

    private JButton button;
    private Path pathToSprites = FileSystems.getDefault().getPath("src", "main", "java", "sprites");

    public IconMaker(final JButton button) {
        this.button = button;
    }

    public void setIcon(final String name) {
        button.setIcon(new ImageIcon(pathToSprites.resolve(name + ".jpg").toString()));
    }
}
