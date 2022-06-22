package io.github.pavelapis.minesweeper;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconMaker {

    JButton button;
    Path pathToSprites = FileSystems.getDefault().getPath("src", "main", "java", "sprites");

    public IconMaker(JButton button) {
        this.button = button;
    }

    public void setIcon(String name) {
        button.setIcon(new ImageIcon(pathToSprites.resolve(name + ".jpg").toString()));
    }
}
