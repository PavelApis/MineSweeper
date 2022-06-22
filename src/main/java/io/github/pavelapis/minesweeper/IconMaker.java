package io.github.pavelapis.minesweeper;

import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class IconMaker {
    JButton button;

    public IconMaker(JButton button) {
        this.button = button;
    }

    public void setIcon(String path) {
        try {
            Image mineImage = ImageIO.read(button.getClass().getResource(path));
            button.setIcon(new ImageIcon(
                    mineImage.getScaledInstance(button.getWidth(), button.getHeight(), java.awt.Image.SCALE_SMOOTH
                    )));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
